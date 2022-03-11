package de.zorryno.zorrynosystems.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * Represents a {@link Config}
 * This can be used to Save Data in a yml {@link File}
 */
public class Config {
    private final FileConfiguration fileConfiguration;
    private final File file;
    private final Plugin plugin;


    /**
     * Create a new {@link Config}
     *
     * @param fileName the name of the Config file [Example: config.yml]
     * @param plugin the {@link Plugin} in which Folder the File will be created
     */
    public Config(String fileName, Plugin plugin) {
        file = new File(plugin.getDataFolder(), fileName);
        this.plugin = plugin;

        if (!file.exists()) {
            plugin.getDataFolder().mkdirs();
            plugin.saveResource(file.getName(), false);
        }
        fileConfiguration = new YamlConfiguration();
        try {
            fileConfiguration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


    /**
     * Saves the {@link Config}
     */
    public void save() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reloads the {@link Config}
     */
    public void reload() {
        try {
            fileConfiguration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete the File and create a new one with the defaults
     */
    public void reset() {
        file.delete();
        plugin.saveResource(file.getName(), false);
        try {
            fileConfiguration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the {@link File} in which the Data is stored
     *
     * @return the Config{@link File}
     */
    public File getFile() {
        return file;
    }

    /**
     * Gets the {@link FileConfiguration}
     * Use this to get and set values
     * If you set values you must save the {@link Config} with {@link Config#save()}
     *
     * @return the {@link FileConfiguration} from the Config
     */
    public FileConfiguration getConfig() {
        return fileConfiguration;
    }

    /**
     * Gets the {@link Plugin} from which the {@link Config} is
     * @return the owning {@link Plugin} of this {@link Config}
     */

    public Plugin getPlugin() {
        return plugin;
    }
}
