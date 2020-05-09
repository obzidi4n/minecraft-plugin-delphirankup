package net.delphicraft.delphi_rankup;

import com.google.inject.Inject;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.UUID;

public class RankupTask extends BukkitRunnable {

    // set plugin instance
    private final JavaPlugin plugin;
    public RankupTask(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        plugin.getServer().broadcastMessage("RankupCheckTask ran on schedule.");

        // loop through online player UUIDs
        for (Player player : Bukkit.getOnlinePlayers()) {

            // get player identifiers
            String playerName = player.getName();
            UUID playerUUID = player.getUniqueId();

            // get minecraft player stats
            Integer playerMinutesPlayed = player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20 / 60;
            plugin.getServer().broadcastMessage("Rankup processing for " + playerName + ": " + playerUUID + ": " + playerMinutesPlayed);

            // New player to Rankups? create sql record


            // Get player votes and rank from sql


            // check for rankup requirements met

            // do rankup commands, update rank in sql

        }

    }

}
