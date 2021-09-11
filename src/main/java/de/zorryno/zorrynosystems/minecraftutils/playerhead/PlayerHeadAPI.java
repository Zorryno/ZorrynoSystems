package de.zorryno.zorrynosystems.minecraftutils.playerhead;

import de.zorryno.zorrynosystems.minecraftutils.playerhead.chatmessageapi.ImageChar;
import de.zorryno.zorrynosystems.minecraftutils.playerhead.chatmessageapi.ImageMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class PlayerHeadAPI implements Listener {
    public static String[] getPlayerHeadMessage(final Player player, final int size) {
        try {
            BufferedImage image = ImageIO.read(new URL("https://crafatar.com/avatars/" + player.getUniqueId() + ".png"));
            return (new ImageMessage(image, size, ImageChar.BLOCK.getChar())).getLines();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void broadcastPlayerHeadAsync(final Player p, final int size, String... text) {
        new Thread(() -> {
            try {
                BufferedImage bi = ImageIO.read(new URL("https://crafatar.com/avatars/" + p.getUniqueId() + ".png"));
                (new ImageMessage(bi, size, ImageChar.BLOCK.getChar()).appendText(text)).broadcast();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void broadcastOfflinePlayerHeadAsync(final String name, final int size, String... text) {
        new Thread(() -> {
            try {
                BufferedImage bi = ImageIO.read(new URL("https://crafatar.com/avatars/" + Bukkit.getPlayerUniqueId(name) + ".png"));
                (new ImageMessage(bi, size, ImageChar.BLOCK.getChar()).appendText(text)).broadcast();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
