package xyz.hydro.gui.serverselector;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import xyz.hydro.Main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static xyz.hydro.Main.noPermission;
import static xyz.hydro.Main.pluginPrefix;

public class ServerSelectorGUI implements CommandExecutor, Listener {
    private final Main plugin;
    public ServerSelectorGUI(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("depreciated")

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        // Server Selector GUI

        Gui server = new Gui(5, ChatColor.GRAY + "Server Selector");
        server.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        GuiItem blackGlass = ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE).setName("").asGuiItem(event -> {
            event.setCancelled(true);
        });

        GuiItem redGlass = ItemBuilder.from(Material.RED_STAINED_GLASS_PANE).setName("").asGuiItem(event -> {
            event.setCancelled(true);
        });

        GuiItem blueGlass = ItemBuilder.from(Material.BLUE_STAINED_GLASS_PANE).setName("").asGuiItem(event -> {
            event.setCancelled(true);
        });

        GuiItem plainGlass = ItemBuilder.from(Material.GLASS_PANE).setName("").asGuiItem(event -> {
            event.setCancelled(true);
        });

        // Actual Items

        // Slot1
        List<String> slot1Lore = plugin.getServerConfig().getStringList("serverSelector.items.1.lore");
        GuiItem slot1 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.1.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.1.name"))).setLore(slot1Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.1.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 2
        List<String> slot2Lore = plugin.getServerConfig().getStringList("serverSelector.items.2.lore");
        GuiItem slot2 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.2.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.2.name"))).setLore(slot2Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.2.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 3
        List<String> slot3Lore = plugin.getServerConfig().getStringList("serverSelector.items.3.lore");
        GuiItem slot3 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.3.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.3.name"))).setLore(slot3Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.3.teleportToServer"));

            event.setCancelled(true);
        });
        
        // Slot 4
        List<String> slot4Lore = plugin.getServerConfig().getStringList("serverSelector.items.4.lore");
        GuiItem slot4 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.4.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.4.name"))).setLore(slot4Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.4.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 5
        List<String> slot5Lore = plugin.getServerConfig().getStringList("serverSelector.items.5.lore");
        GuiItem slot5 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.5.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.5.name"))).setLore(slot5Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.5.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 6
        List<String> slot6Lore = plugin.getServerConfig().getStringList("serverSelector.items.6.lore");
        GuiItem slot6 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.6.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.6.name"))).setLore(slot6Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.6.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 7
        List<String> slot7Lore = plugin.getServerConfig().getStringList("serverSelector.items.7.lore");
        GuiItem slot7 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.7.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.7.name"))).setLore(slot7Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.7.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 8
        List<String> slot8Lore = plugin.getServerConfig().getStringList("serverSelector.items.8.lore");
        GuiItem slot8 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.8.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.8.name"))).setLore(slot8Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.8.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 9
        List<String> slot9Lore = plugin.getServerConfig().getStringList("serverSelector.items.9.lore");
        GuiItem slot9 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.9.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.9.name"))).setLore(slot9Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.9.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 10
        List<String> slot10Lore = plugin.getServerConfig().getStringList("serverSelector.items.10.lore");
        GuiItem slot10 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.10.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.10.name"))).setLore(slot10Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.10.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 11
        List<String> slot11Lore = plugin.getServerConfig().getStringList("serverSelector.items.11.lore");
        GuiItem slot11 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.11.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.11.name"))).setLore(slot11Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.11.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 12
        List<String> slot12Lore = plugin.getServerConfig().getStringList("serverSelector.items.12.lore");
        GuiItem slot12 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.12.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.12.name"))).setLore(slot12Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.12.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 13
        List<String> slot13Lore = plugin.getServerConfig().getStringList("serverSelector.items.13.lore");
        GuiItem slot13 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.13.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.13.name"))).setLore(slot13Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.13.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 14
        List<String> slot14Lore = plugin.getServerConfig().getStringList("serverSelector.items.14.lore");
        GuiItem slot14 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.14.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.14.name"))).setLore(slot14Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.14.teleportToServer"));

            event.setCancelled(true);
        });

        // Slot 15
        List<String> slot15Lore = plugin.getServerConfig().getStringList("serverSelector.items.15.lore");
        GuiItem slot15 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("serverSelector.items.15.material").toUpperCase()))).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.15.name"))).setLore(slot15Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.15.teleportToServer"));

            event.setCancelled(true);
        });

        // Setting Actual Servers Items
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.1.row"), plugin.getServerConfig().getInt("serverSelector.items.1.slot"), slot1);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.2.row"), plugin.getServerConfig().getInt("serverSelector.items.2.slot"), slot2);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.3.row"), plugin.getServerConfig().getInt("serverSelector.items.3.slot"), slot3);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.4.row"), plugin.getServerConfig().getInt("serverSelector.items.4.slot"), slot4);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.5.row"), plugin.getServerConfig().getInt("serverSelector.items.5.slot"), slot5);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.6.row"), plugin.getServerConfig().getInt("serverSelector.items.6.slot"), slot6);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.7.row"), plugin.getServerConfig().getInt("serverSelector.items.7.slot"), slot7);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.8.row"), plugin.getServerConfig().getInt("serverSelector.items.8.slot"), slot8);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.9.row"), plugin.getServerConfig().getInt("serverSelector.items.9.slot"), slot9);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.10.row"), plugin.getServerConfig().getInt("serverSelector.items.10.slot"), slot10);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.11.row"), plugin.getServerConfig().getInt("serverSelector.items.11.slot"), slot11);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.12.row"), plugin.getServerConfig().getInt("serverSelector.items.12.slot"), slot12);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.13.row"), plugin.getServerConfig().getInt("serverSelector.items.13.slot"), slot13);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.14.row"), plugin.getServerConfig().getInt("serverSelector.items.14.slot"), slot14);
        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.15.row"), plugin.getServerConfig().getInt("serverSelector.items.15.slot"), slot15);


        // PRIMARY PART
        if(Objects.equals(plugin.getServerConfig().getString("serverSelector.primaryGlassColor"), "BLACK")) {
            server.setItem(1,2, blackGlass);
            server.setItem(2,2, blackGlass);
            server.setItem(3,2, blackGlass);
            server.setItem(4,2, blackGlass);
            server.setItem(5,2, blackGlass);

            server.setItem(1,3, blackGlass);
            server.setItem(1,4, blackGlass);
            server.setItem(1,5, blackGlass);
            server.setItem(1,6, blackGlass);
            server.setItem(1,7, blackGlass);
            server.setItem(1,8, blackGlass);
            server.setItem(1,9, blackGlass);

            server.setItem(1,8, blackGlass);
            server.setItem(2,8, blackGlass);
            server.setItem(3,8, blackGlass);
            server.setItem(4,8, blackGlass);
            server.setItem(5,8, blackGlass);

            server.setItem(5,3, blackGlass);
            server.setItem(5,4, blackGlass);
            server.setItem(5,5, blackGlass);
            server.setItem(5,6, blackGlass);
            server.setItem(5,7, blackGlass);
            server.setItem(5,8, blackGlass);
            server.setItem(5,9, blackGlass);
        } else if(Objects.equals(plugin.getServerConfig().getString("serverSelector.primaryGlassColor"), "RED")) {
            server.setItem(1,2, redGlass);
            server.setItem(2,2, redGlass);
            server.setItem(3,2, redGlass);
            server.setItem(4,2, redGlass);
            server.setItem(5,2, redGlass);

            server.setItem(1,3, redGlass);
            server.setItem(1,4, redGlass);
            server.setItem(1,5, redGlass);
            server.setItem(1,6, redGlass);
            server.setItem(1,7, redGlass);
            server.setItem(1,8, redGlass);
            server.setItem(1,9, redGlass);

            server.setItem(1,8, redGlass);
            server.setItem(2,8, redGlass);
            server.setItem(3,8, redGlass);
            server.setItem(4,8, redGlass);
            server.setItem(5,8, redGlass);

            server.setItem(5,3, redGlass);
            server.setItem(5,4, redGlass);
            server.setItem(5,5, redGlass);
            server.setItem(5,6, redGlass);
            server.setItem(5,7, redGlass);
            server.setItem(5,8, redGlass);
            server.setItem(5,9, redGlass);
        }else if(Objects.equals(plugin.getServerConfig().getString("serverSelector.primaryGlassColor"), "BLUE")) {
            server.setItem(1,2, blueGlass);
            server.setItem(2,2, blueGlass);
            server.setItem(3,2, blueGlass);
            server.setItem(4,2, blueGlass);
            server.setItem(5,2, blueGlass);

            server.setItem(1,3, blueGlass);
            server.setItem(1,4, blueGlass);
            server.setItem(1,5, blueGlass);
            server.setItem(1,6, blueGlass);
            server.setItem(1,7, blueGlass);
            server.setItem(1,8, blueGlass);
            server.setItem(1,9, blueGlass);

            server.setItem(1,8, blueGlass);
            server.setItem(2,8, blueGlass);
            server.setItem(3,8, blueGlass);
            server.setItem(4,8, blueGlass);
            server.setItem(5,8, blueGlass);

            server.setItem(5,3, blueGlass);
            server.setItem(5,4, blueGlass);
            server.setItem(5,5, blueGlass);
            server.setItem(5,6, blueGlass);
            server.setItem(5,7, blueGlass);
            server.setItem(5,8, blueGlass);
            server.setItem(5,9, blueGlass);
        } else if(Objects.equals(plugin.getServerConfig().getString("serverSelector.primaryGlassColor"), "NORMAL")) {
            server.setItem(1,2, plainGlass);
            server.setItem(2,2, plainGlass);
            server.setItem(3,2, plainGlass);
            server.setItem(4,2, plainGlass);
            server.setItem(5,2, plainGlass);

            server.setItem(1,3, plainGlass);
            server.setItem(1,4, plainGlass);
            server.setItem(1,5, plainGlass);
            server.setItem(1,6, plainGlass);
            server.setItem(1,7, plainGlass);
            server.setItem(1,8, plainGlass);
            server.setItem(1,9, plainGlass);

            server.setItem(1,8, plainGlass);
            server.setItem(2,8, plainGlass);
            server.setItem(3,8, plainGlass);
            server.setItem(4,8, plainGlass);
            server.setItem(5,8, plainGlass);

            server.setItem(5,3, plainGlass);
            server.setItem(5,4, plainGlass);
            server.setItem(5,5, plainGlass);
            server.setItem(5,6, plainGlass);
            server.setItem(5,7, plainGlass);
            server.setItem(5,8, plainGlass);
            server.setItem(5,9, plainGlass);
        }else {
            sendErrorSpam("You did not provide a valid primary color.");
            return true;
        }


        // SECONDARY PART
        // Black as secondary
        if(Objects.equals(plugin.getServerConfig().getString("serverSelector.secondaryGlassColor"), "BLACK")) {
            server.setItem(1, 1, blackGlass);
            server.setItem(2, 1, blackGlass);
            server.setItem(3, 1, blackGlass);
            server.setItem(4, 1, blackGlass);
            server.setItem(5, 1, blackGlass);

            server.setItem(1, 9, blackGlass);
            server.setItem(2, 9, blackGlass);
            server.setItem(3, 9, blackGlass);
            server.setItem(4, 9, blackGlass);
            server.setItem(5, 9, blackGlass);
            // Red as secondary
        } else if(Objects.equals(plugin.getServerConfig().getString("serverSelector.secondaryGlassColor"), "RED")) {
            server.setItem(1, 1, redGlass);
            server.setItem(2, 1, redGlass);
            server.setItem(3, 1, redGlass);
            server.setItem(4, 1, redGlass);
            server.setItem(5, 1, redGlass);

            server.setItem(1, 9, redGlass);
            server.setItem(2, 9, redGlass);
            server.setItem(3, 9, redGlass);
            server.setItem(4, 9, redGlass);
            server.setItem(5, 9, redGlass);
            // blue as secondary
        } else if(Objects.equals(plugin.getServerConfig().getString("serverSelector.secondaryGlassColor"), "BLUE")) {
            server.setItem(1, 1, blueGlass);
            server.setItem(2, 1, blueGlass);
            server.setItem(3, 1, blueGlass);
            server.setItem(4, 1, blueGlass);
            server.setItem(5, 1, blueGlass);

            server.setItem(1, 9, blueGlass);
            server.setItem(2, 9, blueGlass);
            server.setItem(3, 9, blueGlass);
            server.setItem(4, 9, blueGlass);
            server.setItem(5, 9, blueGlass);
            // Normal as secondary
        } else if(Objects.equals(plugin.getServerConfig().getString("serverSelector.secondaryGlassColor"), "NORMAL")) {
            server.setItem(1, 1, plainGlass);
            server.setItem(2, 1, plainGlass);
            server.setItem(3, 1, plainGlass);
            server.setItem(4, 1, plainGlass);
            server.setItem(5, 1, plainGlass);

            server.setItem(1, 9, plainGlass);
            server.setItem(2, 9, plainGlass);
            server.setItem(3, 9, plainGlass);
            server.setItem(4, 9, plainGlass);
            server.setItem(5, 9, plainGlass);
        } else {
            // Else throw an error but not throwing just printing a bunch.
            sendErrorSpam("You did not provide a valid secondary color.");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("serverselector")) {

            if (sender.hasPermission("hhub.members.command.serverSelectorCommand")) {

                server.open(player);

            }else {
                player.sendMessage(format(noPermission));
                return true;
            }
        }

        return true;
    }

    private void sendToServer(Player player, String server) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        try {
            dataOutputStream.writeUTF("Connect");
            dataOutputStream.writeUTF(server);
        } catch (IOException e) {
            e.getStackTrace();
        }
        if(server == null) {
            return;
        }
        player.closeInventory();
        player.sendPluginMessage(plugin, "BungeeCord", byteArrayOutputStream.toByteArray());
        player.sendMessage(format(pluginPrefix + "Sending you to the server..."));
    }

    private void sendErrorSpam(String reason) {
        for(int i=0; i<3; i++)
        {
            plugin.getLogger().warning("serverSelector.yml SETUP INCORRECTLY! ABORTING! REASON: " + reason);
        }
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
