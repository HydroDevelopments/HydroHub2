package xyz.hydro.features.hubItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.hydro.Main;

import java.util.ArrayList;
import java.util.List;

public class ItemsOnJoin implements Listener {

    private final Main plugin;
    public ItemsOnJoin(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        List<String> ignoredWorld = plugin.getConfig().getStringList("hubItemWorlds.ignored");
        plugin.getLogger().info("Something: " + ignoredWorld);
        items(e.getPlayer());
    }

    public void items(Player p) {
        List<String> ignoredWorld = plugin.getConfig().getStringList("hubItemWorlds.ignored");
        String world = p.getWorld().getName();
        if(!ignoredWorld.contains(world)) {
            ItemStack compass = new ItemStack(Material.COMPASS);
            ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
            ItemStack book = new ItemStack(Material.NETHER_STAR);

            ItemMeta compass_meta = compass.getItemMeta();
            compass_meta.setDisplayName(format("&3Server Selector"));
            ArrayList<String> compass_lore = new ArrayList();
            compass_lore.add(format("&dChoose A Server To Join!"));
            compass_meta.setLore(compass_lore);
            compass.setItemMeta(compass_meta);

            ItemMeta blaze_meta = blaze.getItemMeta();
            compass_meta.setDisplayName(format("&6Trails"));
            ArrayList<String> blaze_lore = new ArrayList();
            blaze_lore.add(format("Choose a nice trail to follow you around!"));
            blaze_meta.setLore(blaze_lore);
            blaze.setItemMeta(blaze_meta);

            ItemMeta book_meta = book.getItemMeta();
            book_meta.setDisplayName(format("&2Hub Selector"));
            ArrayList<String> book_lore = new ArrayList();
            book_lore.add(format("Don't like this hub? Choose another one!"));
            book_meta.setLore(book_lore);
            book.setItemMeta(book_meta);

            PlayerInventory playerInventory = p.getInventory();

            playerInventory.setItem(0, compass);
            playerInventory.setItem(4, blaze);
            playerInventory.setItem(8, book);
        } else {
            return;
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        List<String> ignoredWorld = plugin.getConfig().getStringList("hubItemWorlds.ignored");
        Player p = e.getPlayer();
        String world = p.getWorld().getName();
        if(!ignoredWorld.contains(world) && !p.hasPermission("hhub.admin.items.bypass")) {
            e.setCancelled(true);
        } else {
            return;
        }
    }

    @EventHandler
    public void onOffHandMove(PlayerSwapHandItemsEvent e) {
        List<String> ignoredWorld = plugin.getConfig().getStringList("hubItemWorlds.ignored");
        Player p = e.getPlayer();
        String world = p.getWorld().getName();
        if(!ignoredWorld.contains(world) && !p.hasPermission("hhub.admin.items.bypass")) {
            e.setCancelled(true);
        } else {
            return;
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        List<String> ignoredWorld = plugin.getConfig().getStringList("hubItemWorlds.ignored");
        String world = p.getWorld().getName();
        if(!ignoredWorld.contains(world) && !p.hasPermission("hhub.admin.items.bypass")) {
            e.setCancelled(true);
        } else {
            return;
        }
    }

    @EventHandler
    public void onInvDrag(InventoryDragEvent e) {
        Player p = (Player) e.getWhoClicked();
        List<String> ignoredWorld = plugin.getConfig().getStringList("hubItemWorlds.ignored");
        String world = p.getWorld().getName();
        if(!ignoredWorld.contains(world) && !p.hasPermission("hhub.admin.items.bypass")) {
            e.setCancelled(true);
        } else {
            return;
        }
    }

    @EventHandler
    public void onInvInteract(InventoryInteractEvent e) {
        Player p = (Player) e.getWhoClicked();
        List<String> ignoredWorld = plugin.getConfig().getStringList("hubItemWorlds.ignored");
        String world = p.getWorld().getName();
        if(!ignoredWorld.contains(world) && !p.hasPermission("hhub.admin.items.bypass")) {
            e.setCancelled(true);
        } else {
            return;
        }
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {
        List<String> ignoredWorld = plugin.getConfig().getStringList("hubItemWorlds.ignored");
        Player p = e.getPlayer();
        String world = p.getWorld().getName();
        if(!ignoredWorld.contains(world)) {
            items(p);
        } else {
            return;
        }
    }

    @EventHandler
    public void onDeath(PlayerRespawnEvent e) {
        List<String> ignoredWorld = plugin.getConfig().getStringList("hubItemWorlds.ignored");
        Player p = e.getPlayer();
        String world = p.getWorld().getName();
        if(!ignoredWorld.contains(world)) {
            items(p);
        } else {
            return;
        }
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }


}
