package xyz.hydro.features;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
import xyz.hydro.Main;

import java.util.List;

public class BoostPads implements Listener {
    private final Main plugin;
    public BoostPads(Main plugin) {
        this.plugin = plugin;
    }

    private Material pressurePlate;

    @EventHandler
    public void onWalkOver(PlayerMoveEvent event) {

        Player p = event.getPlayer();
        List<String> ignoredWorld = plugin.getConfig().getStringList("boostPadWorlds.allowed");
        String world = p.getWorld().getName();

        if(!ignoredWorld.contains(world) && p.hasPermission("hhub.member.boostPads.use")) {

            Vector v = p.getLocation().getDirection();

            int count = 1;

            if(plugin.getConfig().getString("boostPadBlock").equals("GOLD_BLOCK")) {
                pressurePlate = Material.GOLD_BLOCK;
            } else if(plugin.getConfig().getString("boostPadBlock").equals("EMERALD_BLOCK")) {
                pressurePlate = Material.EMERALD_BLOCK;
            } else {
                plugin.getLogger().warning("boostPadBlock in config MUST be either GOLD_BLOCK or EMERALD_BLOCK!");
                return;
            }

            if (p.getLocation().subtract(0, 1, 0).getBlock().getType() == pressurePlate ) {
                Vector direction = p.getLocation().getDirection().multiply(plugin.getConfig().getDouble("boostPadLaunchMultiplier"));
                direction.setY(direction.getY() + plugin.getConfig().getDouble("boostPadHeightMultiplier"));
                p.setVelocity(direction);

                p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BLOCK_PISTON_EXTEND, 4, 4);
            }
        }
    }

    @EventHandler
    public void onLand(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                e.setCancelled(true);
                p.setFallDistance(0.0f);
                e.setDamage(0.0);
            }
        }
    }

}