package de.zorryno.zorrynosystems.minecraftutils.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CustomPlayerScoreboard {
    public CustomPlayerScoreboard(String displayName) {
        this.displayName = displayName;
    }

    private final Map<UUID, CustomScoreboard> scoreboards = new HashMap<>();
    private final Map<Integer, String> defaults = new HashMap<>();
    private String displayName;

    public void setSidebarScore(int slot, String content) {
        if(slot > 16 || slot < 0) {
            throw new IllegalArgumentException("slot must be within 0 and 16");
        }

        scoreboards.forEach((uuid, customScoreboard) -> customScoreboard.setSidebarScore(slot, content));
    }

    public void setSidebarTitle(String displayName) {
        this.displayName = displayName;
        scoreboards.forEach((uuid, customScoreboard) -> {customScoreboard.setSidebarTitle(displayName);});
    }

    public void setDefaultSidebarScore(int slot, String content) {
        if(slot > 16 || slot < 0) {
            throw new IllegalArgumentException("slot must be within 0 and 16");
        }
        setSidebarScore(slot, content);

        if(content == null) defaults.remove(slot);
        else defaults.put(slot, content);
    }

    public void removePlayer(Player player) {
        scoreboards.remove(player.getUniqueId());
    }

    public CustomScoreboard getScorboard(Player player) {
        return scoreboards.computeIfAbsent(player.getUniqueId(), uuid -> {
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            player.setScoreboard(scoreboard);
            CustomScoreboard customScoreboard = new CustomScoreboard(displayName, scoreboard);
            defaults.forEach(customScoreboard::setSidebarScore);
            return customScoreboard;
        });
    }
}
