package xyz.hydro.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import xyz.hydro.Main;

import java.util.Objects;

public class OnRespawnEvent implements Listener {

    private Main plugin;
    public OnRespawnEvent(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
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
