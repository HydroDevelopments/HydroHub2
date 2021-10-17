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
import xyz.hydro.Main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        List<String> slot1Lore = plugin.getServerConfig().getStringList("serverSelector.items.1.lore");
        GuiItem slot1 = ItemBuilder.from(Material.RED_BED).setName(Objects.requireNonNull(plugin.getServerConfig().getString("serverSelector.items.1.name"))).setLore(slot1Lore).asGuiItem(event -> {

            sendToServer(player, plugin.getServerConfig().getString("serverSelector.items.1.teleportToServer"));

            event.setCancelled(true);
        });

        server.setItem(plugin.getServerConfig().getInt("serverSelector.items.1.row"), plugin.getServerConfig().getInt("serverSelector.items.1.slot"), slot1);

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
            // Else throw an error but not throwing just printing a bunch.
            for(int i=0; i<3; i++)
            {
                plugin.getLogger().warning("SERVER CONFIG NOT SETUP CORRECTLY! ABORTING!");
            }
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
            for(int i=0; i<3; i++)
            {
                plugin.getLogger().warning("SERVER CONFIG NOT SETUP CORRECTLY! ABORTING!");
            }
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
        player.closeInventory();
        player.sendPluginMessage(Main.getPlugin(Main.class), Objects.requireNonNull(plugin.getServerConfig().getString("bungeeCordProxy")), byteArrayOutputStream.toByteArray());
        player.sendMessage(format(pluginPrefix + "Connecting to server..."));
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
