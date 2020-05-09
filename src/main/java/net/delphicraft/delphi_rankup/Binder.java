package net.delphicraft.delphi_rankup;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Binder extends AbstractModule {

    private final Rankup plugin;

    public Binder(Rankup plugin) {
        this.plugin = plugin;
    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        this.bind(Rankup.class).toInstance(this.plugin);
    }
}
