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
import org.bukkit.inventory.ItemStack;
import xyz.hydro.Main;

import static xyz.hydro.utils.CustomSkullGetter.getSkull;

public class HatsGui implements CommandExecutor, Listener {

    private Main plugin;
    public HatsGui(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("depreciated")

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        // Server Selector GUI

        Gui hatsGui = new Gui(6, ChatColor.GRAY + "Hats");
        hatsGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        GuiItem snowMan = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTgxNzFlZTUyY2RlOGE4Zjk4MTdkMGEyYzc4MmM3NjE1YmZkNTMwMWRjOTIwNzZlNzhmZTkyYWFkMWE5M2JmIn19fQ==")))
                .setName(format("&lSnowman")).asGuiItem(event -> {
                    event.setCancelled(true);
                });


        hatsGui.setItem(2, 2, snowMan);

        if (cmd.getName().equalsIgnoreCase("hatsgui")) {

            if (sender.hasPermission("hhub.members.command.hatsGuiCommand")) {

                hatsGui.open(player);

            }
        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
