package xyz.hydro.gui.cosmetics;

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

public class CosmeticsGui implements CommandExecutor, Listener {
    private final Main plugin;
    public CosmeticsGui(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("depreciated")

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        // Server Selector GUI

        Gui cosmGui = new Gui(6, ChatColor.LIGHT_PURPLE + "Cosmetic Menu");
        cosmGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        // Cosmetic GUI Items

        GuiItem hats = ItemBuilder.from(Material.GOLDEN_HELMET).setName(ChatColor.GOLD + "" + ChatColor.BOLD + "Hats").asGuiItem(event -> {
            event.setCancelled(true);
        });

        GuiItem trails = ItemBuilder.from(Material.ARROW).setName(ChatColor.BLUE + "Trails").asGuiItem(event -> {
            player.performCommand("trails");
            event.setCancelled(true);
        });

        cosmGui.setItem(2, 2, hats);
        cosmGui.setItem(2, 2, trails);


        if (cmd.getName().equalsIgnoreCase("cosmetics")) {

            if (sender.hasPermission("hhub.members.command.cosmeticsCommand")) {

                cosmGui.open(player);

            }
        }

        return true;
    }
}
