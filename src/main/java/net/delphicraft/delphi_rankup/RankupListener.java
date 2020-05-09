package net.delphicraft.delphi_rankup;

import com.google.inject.Inject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.scheduler.BukkitTask;

public class RankupListener implements Listener {

    @Inject private Rankup plugin;

    @EventHandler
    public void onEnable(PluginEnableEvent event) {

        double interval_d = plugin.getConfig().getDouble("check_interval") * 60 / 0.05;
        long interval = (long)interval_d;

        BukkitTask task = new RankupTask(plugin).runTaskTimer(plugin, 600, interval);
    }
}
