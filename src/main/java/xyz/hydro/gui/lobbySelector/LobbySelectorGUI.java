package xyz.hydro.gui.lobbySelector;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.hydro.Main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static xyz.hydro.Main.noPermission;
import static xyz.hydro.Main.pluginPrefix;

public class LobbySelectorGUI implements CommandExecutor {
    private final Main plugin;
    public LobbySelectorGUI(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("depreciated")

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        // Server Selector GUI

        Gui server = new Gui(1, ChatColor.GRAY + "Lobby Selector");
        server.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        /*String fillMaterial = plugin.getServerConfig().getString("lobbySelector.fillerItem").toUpperCase();
        if(fillMaterial.equals("AIR")) {
            server.getFiller().fill(ItemBuilder.from(Material.AIR).asGuiItem());
        } else {
            server.getFiller().fill(ItemBuilder.from(new ItemStack(Material.valueOf(fillMaterial))).asGuiItem());
        }*/

        // Slot1
        List<String> slot1Lore = plugin.getServerConfig().getStringList("lobbySelector.items.1.lore");
        slot1Lore = PlaceholderAPI.setPlaceholders(player, slot1Lore);
        String slot1Name = format(Objects.requireNonNull(plugin.getServerConfig().getString("lobbySelector.items.1.name")));
        slot1Name = PlaceholderAPI.setPlaceholders(player, slot1Name);

        String slot1Material = plugin.getServerConfig().getString("lobbySelector.items.1.material").toUpperCase();
        if(slot1Material.equals("AIR")) {
            GuiItem slot1 = ItemBuilder.from(Material.AIR).asGuiItem();
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.1.slot"), slot1);
        } else {
            GuiItem slot1 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("lobbySelector.items.1.material").toUpperCase())))
                    .setName(slot1Name).setLore(slot1Lore).asGuiItem(event -> {

                        sendToServer(player, plugin.getServerConfig().getString("lobbySelector.items.1.teleportToServer"));

                        event.setCancelled(true);
                    });
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.1.slot"), slot1);
        }

        // Slot 2
        List<String> slot2Lore = plugin.getServerConfig().getStringList("lobbySelector.items.2.lore");
        slot2Lore = PlaceholderAPI.setPlaceholders(player, slot2Lore);
        String slot2Name = format(Objects.requireNonNull(plugin.getServerConfig().getString("lobbySelector.items.2.name")));
        slot2Name = PlaceholderAPI.setPlaceholders(player, slot2Name);

        String slot2Material = plugin.getServerConfig().getString("lobbySelector.items.2.material").toUpperCase();
        if(slot2Material.equals("AIR")) {
            GuiItem slot2 = ItemBuilder.from(Material.AIR).asGuiItem();
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.2.slot"), slot2);
        } else {
            GuiItem slot2 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("lobbySelector.items.2.material").toUpperCase())))
                    .setName(slot2Name).setLore(slot2Lore).asGuiItem(event -> {

                        sendToServer(player, plugin.getServerConfig().getString("lobbySelector.items.2.teleportToServer"));

                        event.setCancelled(true);
                    });
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.2.slot"), slot2);
        }

        // Slot 3
        List<String> slot3Lore = plugin.getServerConfig().getStringList("lobbySelector.items.3.lore");
        slot3Lore = PlaceholderAPI.setPlaceholders(player, slot3Lore);
        String slot3Name = format(Objects.requireNonNull(plugin.getServerConfig().getString("lobbySelector.items.3.name")));
        slot3Name = PlaceholderAPI.setPlaceholders(player, slot3Name);

        String slot3Material = plugin.getServerConfig().getString("lobbySelector.items.3.material").toUpperCase();
        if(slot3Material.equals("AIR")) {
            GuiItem slot3 = ItemBuilder.from(Material.AIR).asGuiItem();
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.3.slot"), slot3);
        } else {
            GuiItem slot3 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("lobbySelector.items.3.material").toUpperCase())))
                    .setName(slot3Name).setLore(slot3Lore).asGuiItem(event -> {

                        sendToServer(player, plugin.getServerConfig().getString("lobbySelector.items.3.teleportToServer"));

                        event.setCancelled(true);
                    });
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.3.slot"), slot3);
        }

        // Slot 4
        List<String> slot4Lore = plugin.getServerConfig().getStringList("lobbySelector.items.4.lore");
        slot4Lore = PlaceholderAPI.setPlaceholders(player, slot4Lore);
        String slot4Name = format(Objects.requireNonNull(plugin.getServerConfig().getString("lobbySelector.items.4.name")));
        slot4Name = PlaceholderAPI.setPlaceholders(player, slot4Name);

        String slot4Material = plugin.getServerConfig().getString("lobbySelector.items.4.material").toUpperCase();
        if(slot4Material.equals("AIR")) {
            GuiItem slot4 = ItemBuilder.from(Material.AIR).asGuiItem();
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.4.slot"), slot4);
        } else {

            GuiItem slot4 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("lobbySelector.items.4.material").toUpperCase())))
                    .setName(slot4Name).setLore(slot4Lore).asGuiItem(event -> {

                        sendToServer(player, plugin.getServerConfig().getString("lobbySelector.items.4.teleportToServer"));

                        event.setCancelled(true);
                    });

            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.4.slot"), slot4);
        }

        // Slot 5
        List<String> slot5Lore = plugin.getServerConfig().getStringList("lobbySelector.items.5.lore");
        slot5Lore = PlaceholderAPI.setPlaceholders(player, slot5Lore);
        String slot5Name = format(Objects.requireNonNull(plugin.getServerConfig().getString("lobbySelector.items.5.name")));
        slot5Name = PlaceholderAPI.setPlaceholders(player, slot5Name);

        String slot5Material = plugin.getServerConfig().getString("lobbySelector.items.5.material").toUpperCase();
        if(slot5Material.equals("AIR")) {
            GuiItem slot5 = ItemBuilder.from(Material.AIR).asGuiItem();
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.5.slot"), slot5);
        } else {
            GuiItem slot5 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("lobbySelector.items.5.material").toUpperCase())))
                    .setName(slot5Name).setLore(slot5Lore).asGuiItem(event -> {

                        sendToServer(player, plugin.getServerConfig().getString("lobbySelector.items.5.teleportToServer"));

                        event.setCancelled(true);
                    });

            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.5.slot"), slot5);
        }

        // Slot 6
        List<String> slot6Lore = plugin.getServerConfig().getStringList("lobbySelector.items.6.lore");
        slot6Lore = PlaceholderAPI.setPlaceholders(player, slot6Lore);
        String slot6Name = format(Objects.requireNonNull(plugin.getServerConfig().getString("lobbySelector.items.6.name")));
        slot6Name = PlaceholderAPI.setPlaceholders(player, slot6Name);

        String slot6Material = plugin.getServerConfig().getString("lobbySelector.items.6.material").toUpperCase();
        if(slot6Material.equals("AIR")) {
            GuiItem slot6 = ItemBuilder.from(Material.AIR).asGuiItem();
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.6.slot"), slot6);
        } else {

            GuiItem slot6 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("lobbySelector.items.6.material").toUpperCase())))
                    .setName(slot6Name).setLore(slot6Lore).asGuiItem(event -> {

                        sendToServer(player, plugin.getServerConfig().getString("lobbySelector.items.6.teleportToServer"));

                        event.setCancelled(true);
                    });
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.6.slot"), slot6);
        }

        // Slot 7
        List<String> slot7Lore = plugin.getServerConfig().getStringList("lobbySelector.items.7.lore");
        slot7Lore = PlaceholderAPI.setPlaceholders(player, slot7Lore);
        String slot7Name = format(Objects.requireNonNull(plugin.getServerConfig().getString("lobbySelector.items.7.name")));
        slot7Name = PlaceholderAPI.setPlaceholders(player, slot7Name);

        String slot7Material = plugin.getServerConfig().getString("lobbySelector.items.7.material").toUpperCase();
        if(slot7Material.equals("AIR")) {
            GuiItem slot7 = ItemBuilder.from(Material.AIR).asGuiItem();
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.7.slot"), slot7);
        } else {

            GuiItem slot7 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("lobbySelector.items.7.material").toUpperCase())))
                    .setName(slot7Name).setLore(slot7Lore).asGuiItem(event -> {

                        sendToServer(player, plugin.getServerConfig().getString("lobbySelector.items.7.teleportToServer"));

                        event.setCancelled(true);
                    });
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.7.slot"), slot7);
        }

        // Slot 8
        List<String> slot8Lore = plugin.getServerConfig().getStringList("lobbySelector.items.8.lore");
        slot8Lore = PlaceholderAPI.setPlaceholders(player, slot8Lore);
        String slot8Name = format(Objects.requireNonNull(plugin.getServerConfig().getString("lobbySelector.items.8.name")));
        slot8Name = PlaceholderAPI.setPlaceholders(player, slot8Name);

        String slot8Material = plugin.getServerConfig().getString("lobbySelector.items.8.material").toUpperCase();
        if(slot8Material.equals("AIR")) {
            GuiItem slot8 = ItemBuilder.from(Material.AIR).asGuiItem();
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.8.slot"), slot8);
        } else {

            GuiItem slot8 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("lobbySelector.items.8.material").toUpperCase())))
                    .setName(slot8Name).setLore(slot8Lore).asGuiItem(event -> {

                        sendToServer(player, plugin.getServerConfig().getString("lobbySelector.items.8.teleportToServer"));

                        event.setCancelled(true);
                    });
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.8.slot"), slot8);
        }

        // Slot 9
        List<String> slot9Lore = plugin.getServerConfig().getStringList("lobbySelector.items.9.lore");
        slot9Lore = PlaceholderAPI.setPlaceholders(player, slot9Lore);
        String slot9Name = format(Objects.requireNonNull(plugin.getServerConfig().getString("lobbySelector.items.9.name")));
        slot9Name = PlaceholderAPI.setPlaceholders(player, slot9Name);

        String slot9Material = plugin.getServerConfig().getString("lobbySelector.items.9.material").toUpperCase();
        if(slot9Material.equals("AIR")) {
            GuiItem slot9 = ItemBuilder.from(Material.AIR).asGuiItem();
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.9.slot"), slot9);
        } else {

            GuiItem slot9 = ItemBuilder.from(new ItemStack(Material.valueOf(plugin.getServerConfig().getString("lobbySelector.items.9.material").toUpperCase())))
                    .setName(slot9Name).setLore(slot9Lore).asGuiItem(event -> {

                        sendToServer(player, plugin.getServerConfig().getString("lobbySelector.items.9.teleportToServer"));

                        event.setCancelled(true);
                    });
            server.setItem(1, plugin.getServerConfig().getInt("lobbySelector.items.9.slot"), slot9);
        }


        if (cmd.getName().equalsIgnoreCase("lobbyselector")) {

            if (sender.hasPermission("hhub.members.command.lobbySelectorCommand")) {

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
        player.sendMessage(format(pluginPrefix + plugin.getMessagesConfig().getString("connectingToServerMsg")));
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
