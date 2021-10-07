package xyz.hydro.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;
import xyz.hydro.Main;

import java.util.Objects;

public class OnRespawnEvent implements Listener {

    private Main plugin;
    public OnRespawnEvent(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onRespawn(PlayerSpawnLocationEvent e) {
        Player player = e.getPlayer();

        if(plugin.getLocationsConfig().get("worldSpawnX") == null) {
            return;
        } else {


            // Player Spawn
            World world = plugin.getServer().getWorld(Objects.requireNonNull(plugin.getLocationsConfig().getString("worldSpawnName")));
            double x = plugin.getLocationsConfig().getDouble("worldSpawnX");
            double y = plugin.getLocationsConfig().getDouble("worldSpawnY");
            double z = plugin.getLocationsConfig().getDouble("worldSpawnZ");
            double yaw = plugin.getLocationsConfig().getDouble("worldSpawnYaw");
            double pitch = plugin.getLocationsConfig().getDouble("worldSpawnPitch");

            if (plugin.getLocationsConfig().get("worldSpawnX") != null) {
                player.teleport(new Location(world, x, y, z, (float) yaw, (float) pitch));
            } else {
                player.sendMessage("Event Trigger");
                return;
            }
        }

    }
}
