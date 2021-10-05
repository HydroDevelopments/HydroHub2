package xyz.hydro.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.hydro.Main;

import java.util.Objects;

public class OnJoinEvents implements Listener {

    private Main plugin;
    public OnJoinEvents(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        // Player Spawn
        World world = plugin.getServer().getWorld(Objects.requireNonNull(plugin.getConfig().getString("worldSpawnName")));
        double x = plugin.getConfig().getDouble("worldSpawnX");
        double y = plugin.getConfig().getDouble("worldSpawnY");
        double z = plugin.getConfig().getDouble("worldSpawnZ");
        double yaw = plugin.getConfig().getDouble("worldSpawnYaw");
        double pitch = plugin.getConfig().getDouble("worldSpawnPitch");

        player.teleport(new Location(world, x, y, z, (float) yaw, (float) pitch));

    }

}
