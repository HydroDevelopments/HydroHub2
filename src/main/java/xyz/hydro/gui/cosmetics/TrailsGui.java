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
import xyz.hydro.Main;

public class TrailsGui implements CommandExecutor {
    private final Main plugin;
    public TrailsGui(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("depreciated")

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        Gui trailsGui = new Gui(6, ChatColor.GRAY + "Trails");
        trailsGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        Gui wingsGui = new Gui(3, "Wings Menu");
        wingsGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        // Wings GUI Items
        GuiItem wingsOne = ItemBuilder.from(Material.BLACK_WOOL).setName("Black and White").asGuiItem(event -> {
            event.setCancelled(true);
        });

        // Trail GUI Items

        GuiItem trailOne = ItemBuilder.from(Material.FEATHER).setName(ChatColor.WHITE + "Wings").asGuiItem(event -> {
            wingsGui.open(player);
            event.setCancelled(true);
        });

        // Wings GUI Items

        trailsGui.setItem(2, 2, trailOne);

        wingsGui.setItem(2, 2, wingsOne);

        if (cmd.getName().equalsIgnoreCase("trails")) {

            if (sender.hasPermission("hhub.members.command.trailsCommand")) {

                trailsGui.open(player);

            }
        }

        return true;
    }

}
