package me.valentesteban.test.listener;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.unnamed.inject.InjectAll;

@InjectAll
public class ParkourMapListener
        implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();

        if (world.getName().equals("parkour")) {
            player.sendMessage("welcome to the parkour event.");
        }
    }
}
