package de.zorryno.zorrynosystems.minecraftutils.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class EasyScoreboard {
    public EasyScoreboard(String displayName) {
        this(displayName, Bukkit.getScoreboardManager().getMainScoreboard());
    }

    public EasyScoreboard(String displayName, Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
        if(scoreboard.getObjective("sidebar") != null) {
            scoreboard.getObjective("sidebar").unregister();
        }
        sidebarObjective = scoreboard.registerNewObjective("sidebar", "dummy", displayName);
        sidebarObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
    }


    public void setSidebarScore(int slot, String content) {
        if(slot > 16 || slot < 0) {
            throw new IllegalArgumentException("slot must be within 0 and 16");
        }

        Team team = getOrCreateTeam("sidebar" + slot);
        String entry = getEntry(slot);

        if(content == null) {
            scoreboard.resetScores(entry);
            return;
        }
        team.setPrefix(content);
        team.addEntry(entry);
        sidebarObjective.getScore(entry).setScore(slot);
    }

    public void addPlayer(Player player, String teamName, String prefix, String suffix, ChatColor color) {
         Team team = getOrCreateTeam(teamName);
         team.setPrefix(prefix);
         team.setSuffix(suffix);
         team.setColor(color);
         team.addEntry(player.getName());
    }

    public void removePlayer(Player player) {
        Team team = scoreboard.getEntryTeam(player.getName());
        if (team != null) team.removeEntry(player.getName());
    }

    private Team getOrCreateTeam(String name) {
        Team team = scoreboard.getTeam(name);
        if (team != null) return team;
        return scoreboard.registerNewTeam(name);
    }

    private String getEntry(int slot) {
        return ChatColor.values()[slot].toString() + ChatColor.values()[slot + 1];
    }

    private Plugin plugin;
    private final Scoreboard scoreboard;
    private final Objective sidebarObjective;
}
