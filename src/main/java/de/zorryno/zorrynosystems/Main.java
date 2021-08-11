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
        getLogger().info("\n" + ChatColor.GRAY + "|" +
                ChatColor.GRAY +        " -------------------------------------------------------------------" + ChatColor.GRAY +           "------------------------------------------------------------ " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.BLUE +        "  ______                                                            " + ChatColor.DARK_RED +       "                                                             " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.BLUE +        " |___  /                                                            " + ChatColor.DARK_RED +       " _    __                                                     " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.BLUE +        "    / / ___  _ __ _ __ _   _ _ __   ___                             " + ChatColor.DARK_RED +       "| |  / /                                                     " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.BLUE +        "   / / / _ \\| '__| '__| | | | '_ \\ / _ \\                            " + ChatColor.DARK_RED +    "| | / / ___                                                  " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.BLUE +        "  / /_| (_) | |  | |  | |_| | | | | (_) |                           " + ChatColor.DARK_RED +       "| |/ / / _ \\  _____                                          " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.BLUE +        " /_____\\___/|_|  |_|   \\__, |_| |_|\\___/                            " + ChatColor.DARK_RED +    "|___/ /  __/ / ___/ _____  _                                 " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.BLUE +        "                        __/ |                                       " + ChatColor.DARK_RED +       "      \\___/ / /    / ___/ (_)                                " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.BLUE +        "                       |___/                                        " + ChatColor.DARK_RED +       "           /_/    (__  ) / / ____                            " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.DARK_GREEN +  "                       _____           _                            " + ChatColor.DARK_RED +       "                 /____/ / / / __ \\  ____                     " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.DARK_GREEN +  "                      / ____|         | |                           " + ChatColor.DARK_RED +       "                       /_/ / /_/ / / __ \\     ___            " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.DARK_GREEN +  "                     | (___  _   _ ___| |_ ___ _ __ ___  ___        " + ChatColor.DARK_RED +       "                           \\____/ / / / /    <  /            " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.DARK_GREEN +  "                      \\___ \\| | | / __| __/ _ \\ '_ ` _ \\/ __|       " + ChatColor.DARK_RED +   "                                 /_/ /_/     / /    ___      " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.DARK_GREEN +  "                      ____) | |_| \\__ \\ ||  __/ | | | | \\__ \\       " + ChatColor.DARK_RED +   "                                            / /    <  /      " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.DARK_GREEN +  "                     |_____/ \\__, |___/\\__\\___|_| |_| |_|___/       " + ChatColor.DARK_RED +    "                                           /_/ _   / /       " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.DARK_GREEN +  "                              __/ |                                 " + ChatColor.DARK_RED +       "                                              (_) / /        " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.DARK_GREEN +  "                             |___/                                  " + ChatColor.DARK_RED +       "                                                 /_/         " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.GRAY +        "                                                                    " + ChatColor.DARK_RED +       "                                                             " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.GREEN +       "                                                    Zorryno Systems " + ChatColor.DARK_RED +       "erfolgreich geladen!                                         " + ChatColor.GRAY + "|\n" + ChatColor.GRAY + "|" +
                ChatColor.GRAY +        " -------------------------------------------------------------------" + ChatColor.GRAY +           "------------------------------------------------------------ " + ChatColor.GRAY + "|");
    }
}
