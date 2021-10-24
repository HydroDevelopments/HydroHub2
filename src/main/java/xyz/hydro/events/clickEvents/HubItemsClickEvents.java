package xyz.hydro.events.clickEvents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.hydro.Main;

public class HubItemsClickEvents implements Listener {

    private final Main plugin;
    public HubItemsClickEvents(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
            Action action = event.getAction();
            if (player.getInventory().getItemInMainHand().getType().equals(Material.COMPASS) && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Server Selector")
                    && (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))) {

            player.performCommand("serverselector");

            event.setCancelled(true);

        }

        if (player.getInventory().getItemInMainHand().getType().equals(Material.CHEST) && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Cosmetics")
                && (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))) {

            player.performCommand("cosmetics");

            event.setCancelled(true);

        }

        if (player.getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR) && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Hub Selector")
                && (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))) {

            player.performCommand("lobbyselector");

            event.setCancelled(true);

        }
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
