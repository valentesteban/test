package me.valentesteban.test;

import me.valentesteban.test.service.Service;
import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Injector;

import javax.inject.Inject;
import java.util.Set;

public class Test
        extends JavaPlugin {

    @Inject
    private Set<Service> services;

    @Override
    public void onLoad() {
        Injector.create(new TestModule(this))
                .injectMembers(this);
    }

    @Override
    public void onEnable() {
        for (Service service : services) {
            service.start();
        }
    }

    @Override
    public void onDisable() {
        for (Service service : services) {
            service.stop();
        }
    }
}
