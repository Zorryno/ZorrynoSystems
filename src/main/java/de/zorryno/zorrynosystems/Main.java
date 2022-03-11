package de.zorryno.zorrynosystems;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        consoleMessage();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void consoleMessage() {
        getLogger().info("\n" +
                ChatColor.GRAY + "|" + ChatColor.GRAY +        " -------------------------------------------------------------------"       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.BLUE +        "  ______                                                            "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.BLUE +        " |___  /                                                            "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.BLUE +        "    / / ___  _ __ _ __ _   _ _ __   ___                             "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.BLUE +        "   / / / _ \\| '__| '__| | | | '_ \\ / _ \\                            "    + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.BLUE +        "  / /_| (_) | |  | |  | |_| | | | | (_) |                           "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.BLUE +        " /_____\\___/|_|  |_|   \\__, |_| |_|\\___/                            "    + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.BLUE +        "                        __/ |                                       "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.BLUE +        "                       |___/                                        "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.DARK_GREEN +  "                       _____           _                            "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.DARK_GREEN +  "                      / ____|         | |                           "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.DARK_GREEN +  "                     | (___  _   _ ___| |_ ___ _ __ ___  ___        "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.DARK_GREEN +  "                      \\___ \\| | | / __| __/ _ \\ '_ ` _ \\/ __|       "   + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.DARK_GREEN +  "                      ____) | |_| \\__ \\ ||  __/ | | | | \\__ \\       "   + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.DARK_GREEN +  "                     |_____/ \\__, |___/\\__\\___|_| |_| |_|___/       "    + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.DARK_GREEN +  "                              __/ |                                 "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.DARK_GREEN +  "                             |___/                                  "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.GRAY +        "                                                                    "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.GREEN +       "         Zorryno Systems erfolgreich geladen!         Version 1.2.9 "       + ChatColor.GRAY + "|\n" +
                ChatColor.GRAY + "|" + ChatColor.GRAY +        " -------------------------------------------------------------------"       + ChatColor.GRAY + "|");
    }
}
