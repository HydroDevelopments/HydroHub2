package xyz.hydro.gui;

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

import java.util.List;
import java.util.Set;

import static xyz.hydro.Main.noPermission;
import static xyz.hydro.Main.pluginPrefix;

public class BoostPadsGUI implements CommandExecutor, Listener {

    private Main plugin;

    public BoostPadsGUI(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Set<String> itemList = plugin.getConfig().getConfigurationSection("boostPadWorlds.enabled").getKeys(false);


        // The enabledWorlds GUI

        Gui enabledWorldsGUI = new Gui(6, format("&7enabledWorlds Config"));
        enabledWorldsGUI.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        GuiItem exampleWorld = ItemBuilder.from(Material.GRASS_BLOCK).setName("WorldName").setLore("Right-Click To Remove This World.").asGuiItem(event -> {

            event.setCancelled(true);
        });

        enabledWorldsGUI.setItem(1, exampleWorld);



        // The Main GUI

        Gui bpgMain = new Gui(1, "BoostPads Configs");
        bpgMain.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        // Maintenance GUI Items
        GuiItem item1 = ItemBuilder.from(Material.PAPER).setName("enabledWorlds").setLore("This is a list of worlds that BoostPads are enabled in. Right-Click a world to remove it.").asGuiItem(event -> {
            enabledWorldsGUI.open(player);
            event.setCancelled(true);
        });

        bpgMain.setItem(1, 3, item1);


        // Where the execution happens.

        if(command.getName().equalsIgnoreCase("boostpads")) {
            if(player.hasPermission("hhub.admin.commands.boostPadsCommand")) {

                bpgMain.open(player);

            }
        }

        return true;
    }


    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}