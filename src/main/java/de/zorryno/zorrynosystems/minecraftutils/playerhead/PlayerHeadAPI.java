package de.zorryno.zorrynosystems.minecraftutils.playerhead;

import de.zorryno.zorrynosystems.minecraftutils.playerhead.chatmessageapi.ImageChar;
import de.zorryno.zorrynosystems.minecraftutils.playerhead.chatmessageapi.ImageMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class PlayerHeadAPI implements Listener {
    public static String[] getPlayerHeadMessage(final Player player, final int size) {
        try {
            URL url = player.getPlayerProfile().getTextures().getSkin();
            BufferedImage bi = ImageIO.read(url);
            if (bi == null) return null;
            BufferedImage image = bi.getSubimage(8, 8, 8, 8);
            return (new ImageMessage(image, size, ImageChar.BLOCK.getChar())).getLines();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void broadcastPlayerHeadAsync(final Plugin plugin, final Player p, final int size, String... text) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            try {
                URL url = p.getPlayerProfile().getTextures().getSkin();
                BufferedImage bi = ImageIO.read(url);
                if (bi == null) return;
                BufferedImage subimage = bi.getSubimage(8, 8, 8, 8);
                (new ImageMessage(subimage, size, ImageChar.BLOCK.getChar()).appendText(text)).broadcast();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void broadcastPlayerHeadAsync(final Plugin plugin, final Player p, final int size, List<String> text) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            try {
                URL url = p.getPlayerProfile().getTextures().getSkin();
                BufferedImage bi = ImageIO.read(url);
                if (bi == null) return;
                BufferedImage subimage = bi.getSubimage(8, 8, 8, 8);
                (new ImageMessage(subimage, size, ImageChar.BLOCK.getChar()).appendText(text)).broadcast();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    public static void broadcastOfflinePlayerHeadAsync(final Plugin plugin, final String name, final int size, String... text) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                URL url = Bukkit.getOfflinePlayer(Bukkit.getPlayerUniqueId(name)).getPlayerProfile().getTextures().getSkin();
                BufferedImage bi = ImageIO.read(url);
                if (bi == null) return;
                BufferedImage subimage = bi.getSubimage(8, 8, 8, 8);
                (new ImageMessage(subimage, size, ImageChar.BLOCK.getChar()).appendText(text)).broadcast();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void broadcastOfflinePlayerHeadAsync(final Plugin plugin, final String name, final int size, List<String> text) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                URL url = Bukkit.getOfflinePlayer(Bukkit.getPlayerUniqueId(name)).getPlayerProfile().getTextures().getSkin();
                BufferedImage bi = ImageIO.read(url);
                if (bi == null) return;
                BufferedImage subimage = bi.getSubimage(8, 8, 8, 8);
                (new ImageMessage(subimage, size, ImageChar.BLOCK.getChar()).appendText(text)).broadcast();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
