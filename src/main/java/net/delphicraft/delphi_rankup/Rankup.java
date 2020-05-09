package net.delphicraft.delphi_rankup;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

public class Rankup extends JavaPlugin {

    @Inject private CommandKit commandKit;
    @Inject private RankupListener rankupListener;
    @Inject private DatabaseListener databaseListener;

    @Override
    public void onEnable() {

        // set up dependency injection
        Binder binder = new Binder(this);
        Injector injector = binder.createInjector();
        injector.injectMembers(this);

        // create config.yml if none exists
        this.saveDefaultConfig();

        // register commands
        this.getCommand("kit").setExecutor(this.commandKit);

        // register listeners
        this.getServer().getPluginManager().registerEvents(this.rankupListener, this);
        this.getServer().getPluginManager().registerEvents(this.databaseListener, this);

    }

    @Override
    public void onDisable() {

    }

}