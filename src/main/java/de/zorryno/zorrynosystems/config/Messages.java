package de.zorryno.zorrynosystems.config;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Messages {
    public Messages(@NotNull String fileName, @NotNull Plugin plugin) {
        this.plugin = plugin;
        messagesConfig = new Config(fileName, plugin);
        loadMessages();
    }

    private void loadMessages() {
        for (String key : messagesConfig.getConfig().getKeys(true)) {
            String message = messagesConfig.getConfig().getString(key);
            if(message != null) {
                this.messages.put(key, ChatColor.translateAlternateColorCodes('&', message));
            }
        }
    }

    public void reload() {
        messagesConfig.reload();
        loadMessages();
    }

    private HashMap<String, String> messages = new HashMap<>();
    private Plugin plugin;
    private Config messagesConfig;

    public HashMap<String, String> getCache() {
        return new HashMap<>(messages);
    }
}
