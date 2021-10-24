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

        GuiItem hatItem = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmFhMTU1NTA5YWFjMWU1NGM2NDQwZDgzMjE1YTdiODBjOTBjNmVhY2M4MDg1Njg4NzU2YTFlODE2NmE0ZSJ9fX0=")))
                .setName(format("&6Hats")).setLore("Pick A Hat, Any Hat").asGuiItem(event -> {
                    player.performCommand("hatsgui");
                    event.setCancelled(true);
                });

        GuiItem trails = ItemBuilder.from(Material.ARROW).setName(ChatColor.BLUE + "Trails").asGuiItem(event -> {
            player.performCommand("trails");
            event.setCancelled(true);
        });

        cosmGui.setItem(2, 2, hatItem);
        cosmGui.setItem(2, 4, trails);


        if (cmd.getName().equalsIgnoreCase("cosmetics")) {

            if (sender.hasPermission("hhub.members.command.cosmeticsCommand")) {

                cosmGui.open(player);

            }
        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
