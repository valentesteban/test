package me.valentesteban.test.service.impl;

import me.valentesteban.test.Test;
import me.valentesteban.test.listener.ParkourMapListener;
import me.valentesteban.test.service.Service;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import team.unnamed.inject.InjectAll;

@InjectAll
public class ListenerService implements Service {

    private Test test;
    private ParkourMapListener parkourMapListener;

    @Override
    public void start() {
        registerListeners(
                parkourMapListener
        );
    }

    private void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, test);
        }
    }
}
