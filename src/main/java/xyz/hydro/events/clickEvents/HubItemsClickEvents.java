package xyz.hydro.events.clickEvents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.hydro.Main;

import static xyz.hydro.Main.noPermission;

public class HubItemsClickEvents {

    private final Main plugin;
    public HubItemsClickEvents(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(player.hasPermission("hhub.items.hubItemsClick")) {
            Action action = event.getAction();
            if (player.getInventory().getItemInMainHand().getType().equals(Material.COMPASS) && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(format("&3Server Selector")) &&
                    player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(format("&dChoose A Server To Join!"))
                    && (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) || (action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK))) {
                player.performCommand("serverselector");
                event.setCancelled(true);
            }
        } else {
            player.sendMessage(format(noPermission));
        }
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
