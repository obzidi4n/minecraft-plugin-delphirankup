package net.delphicraft.delphi_rankup;

import com.google.inject.Inject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.scheduler.BukkitTask;

public class DatabaseListener implements Listener {

    @Inject private Rankup plugin;

    @EventHandler
    public void onEnable(PluginEnableEvent event) {

        BukkitTask task = new DatabaseTask(plugin).runTaskAsynchronously(plugin);

    }

}

