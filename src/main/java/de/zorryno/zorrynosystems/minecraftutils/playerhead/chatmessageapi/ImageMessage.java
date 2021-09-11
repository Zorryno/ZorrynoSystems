package de.zorryno.zorrynosystems.minecraftutils.playerhead.chatmessageapi;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ImageMessage {
    private static final char TRANSPARENT_CHAR = '#';
    private final Color[] colors = new Color[]{new Color(0, 0, 0), new Color(0, 0, 170), new Color(0, 170, 0), new Color(0, 170, 170), new Color(170, 0, 0), new Color(170, 0, 170), new Color(255, 170, 0), new Color(170, 170, 170), new Color(85, 85, 85), new Color(85, 85, 255), new Color(85, 255, 85), new Color(85, 255, 255), new Color(255, 85, 85), new Color(255, 85, 255), new Color(255, 255, 85), new Color(255, 255, 255)};
    private String[] lines;

    public ImageMessage(BufferedImage image, int height, char imgChar) {
        ChatColor[][] chatColors = toChatColorArray(image, height);
        lines = toImgMessage(chatColors, imgChar);
    }

    public ImageMessage(ChatColor[][] chatColors, char imgChar) {
        lines = toImgMessage(chatColors, imgChar);
    }

    public ImageMessage(String... imgLines) {
        lines = imgLines;
    }

    public ImageMessage appendText(String... text) {
        for(int y = 0; y < lines.length; ++y) {
            if (text.length > y) {
                String[] immageLines = lines;
                immageLines[y] = immageLines[y] + " " + text[y];
            }
        }

        return this;
    }

    public ImageMessage appendCenteredText(String... text) {
        for(int y = 0; y < lines.length; ++y) {
            if (text.length <= y) {
                return this;
            }

            int len = 65 - lines[y].length();
            lines[y] = lines[y] + center(text[y], len);
        }

        return this;
    }

    private ChatColor[][] toChatColorArray(BufferedImage image, int height) {
        double ratio = (double)image.getHeight() / (double)image.getWidth();
        int width = (int)((double)height / ratio);

        BufferedImage resized = resizeImage(image, (int)((double)height / ratio), height);
        ChatColor[][] chatImg = new ChatColor[resized.getWidth()][resized.getHeight()];

        for(int x = 0; x < resized.getWidth(); ++x) {
            for(int y = 0; y < resized.getHeight(); ++y) {
                int rgb = resized.getRGB(x, y);
                ChatColor closest = getClosestChatColor(new Color(rgb, true));
                chatImg[x][y] = closest;
            }
        }

        return chatImg;
    }

    private String[] toImgMessage(ChatColor[][] colors, char imgchar) {
        String[] lines = new String[colors[0].length];

        for(int y = 0; y < colors[0].length; ++y) {
            String line = "";

            for(int x = 0; x < colors.length; ++x) {
                ChatColor color = colors[x][y];
                line = line + (color != null ? colors[x][y].toString() + imgchar : "Â§0#");
            }

            lines[y] = line + ChatColor.RESET;
        }

        return lines;
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        AffineTransform af = new AffineTransform();
        af.scale((double)width / (double)originalImage.getWidth(), (double)height / (double)originalImage.getHeight());
        AffineTransformOp operation = new AffineTransformOp(af, 1);
        return operation.filter(originalImage, (BufferedImage)null);
    }

    private double getDistance(Color c1, Color c2) {
        double rmean = (double)(c1.getRed() + c2.getRed()) / 2.0D;
        double r = (double)(c1.getRed() - c2.getRed());
        double g = (double)(c1.getGreen() - c2.getGreen());
        int b = c1.getBlue() - c2.getBlue();
        double weightR = 2.0D + rmean / 256.0D;
        double weightG = 4.0D;
        double weightB = 2.0D + (255.0D - rmean) / 256.0D;
        return weightR * r * r + weightG * g * g + weightB * (double)b * (double)b;
    }

    private boolean areIdentical(Color c1, Color c2) {
        return Math.abs(c1.getRed() - c2.getRed()) <= 5 && Math.abs(c1.getGreen() - c2.getGreen()) <= 5 && Math.abs(c1.getBlue() - c2.getBlue()) <= 5;
    }

    private ChatColor getClosestChatColor(Color color) {
        if (color.getAlpha() < 128) {
            return null;
        } else {
            int index = 0;
            double best = -1.0D;

            int i;
            for(i = 0; i < colors.length; ++i) {
                if (areIdentical(colors[i], color)) {
                    return ChatColor.values()[i];
                }
            }

            for(i = 0; i < colors.length; ++i) {
                double distance = getDistance(color, colors[i]);
                if (distance < best || best == -1.0D) {
                    best = distance;
                    index = i;
                }
            }

            return ChatColor.values()[index];
        }
    }

    private String center(String s, int length) {
        if (s.length() > length) {
            return s.substring(0, length);
        } else if (s.length() == length) {
            return s;
        } else {
            int leftPadding = (length - s.length()) / 2;
            StringBuilder leftBuilder = new StringBuilder();

            for(int i = 0; i < leftPadding; ++i) {
                leftBuilder.append(" ");
            }

            return leftBuilder + s;
        }
    }

    public String[] getLines() {
        return lines;
    }

    public void broadcast() {
        String [] messageLines = lines.clone();
        for(String line : messageLines) {
            Bukkit.broadcastMessage(line);
        }
    }

    public void send(CommandSender commandSender) {
        String [] messageLines = lines.clone();
        for(String line : messageLines) {
            commandSender.sendMessage(line);
        }
    }
}
