package de.zorryno.zorrynosystems.config;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Messages {
    private HashMap<String, String> messages = new HashMap<>();
    private Plugin plugin;
    private Config messagesConfig;
    private String prefix;

    public Messages(@NotNull String fileName, @NotNull Plugin plugin) {
        this(fileName, plugin, null);
    }

    public Messages(@NotNull String fileName, @NotNull Plugin plugin, @Nullable String prefix) {
        this.plugin = plugin;
        if(prefix != null)
            this.prefix = prefix;
        else
            this.prefix = "";
        messagesConfig = new Config(fileName, plugin);
        loadMessages();
    }

    /**
     * Load all messages
     */
    private void loadMessages() {
        for (String key : messagesConfig.getConfig().getKeys(true)) {
            String message = messagesConfig.getConfig().getString(key);
            if (message != null) {
                this.messages.put(key, ChatColor.translateAlternateColorCodes('&', (prefix + message)));
            }
        }
    }

    /**
     * Reloads the Config and the Cache
     */
    public void reload() {
        messagesConfig.reload();
        loadMessages();
    }

    /**
     * Get the Cache
     *
     * @return A HashMap with Path as Key and the message as Value
     */
    public HashMap<String, String> getCache() {
        return new HashMap<>(messages);
    }

    /**
     * Get A StringList with messages
     *
     * @param path the Locating path in the messagesConfig
     * @return A List with Messages
     */
    public List<String> getMessagesList(String path) {
        List<String> messages = new ArrayList<>();
        messagesConfig.getConfig().getStringList(path).forEach(message -> {
            if (message != null) messages.add(ChatColor.translateAlternateColorCodes('&', (prefix + message)));
        });
        return messages;
    }

    /**
     * Get the Configuration
     *
     * @return the FileConfiguration
     */
    public FileConfiguration getConfig() {
        return messagesConfig.getConfig();
    }

    /**
     * Get the Plugin for this MessagesConfig
     *
     * @return the Plugin
     */
    public Plugin getPlugin() {
        return plugin;
    }
}
