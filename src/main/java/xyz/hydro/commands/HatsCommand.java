package xyz.hydro.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import xyz.hydro.Main;

import static xyz.hydro.Main.noPermission;
import static xyz.hydro.Main.pluginPrefix;
import static xyz.hydro.utils.CustomSkullGetter.getSkull;

public class HatsCommand implements CommandExecutor, Listener {

    private Main plugin;
    public HatsCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        ItemStack heldItem = new ItemStack(player.getInventory().getItemInMainHand());

        if (cmd.getName().equalsIgnoreCase("hat")) {

            if (sender.hasPermission("hhub.members.command.setHatCommand")) {

            if(args.length <= 0) {
                if(player.getInventory().getItemInMainHand().getType() == Material.AIR) {

                    player.sendMessage(format(pluginPrefix + "You are not holding anything in your main hand!"));
                    return true;

                } else {
                    if(heldItem.getAmount() == 1) {
                        player.getInventory().setHelmet(player.getInventory().getItemInMainHand());
                        player.getInventory().setItemInMainHand(new ItemStack(Material.AIR, 1));
                    } else if(heldItem.getAmount() > 1) {
                        player.sendMessage(format(pluginPrefix + "You are holding a stack of " + heldItem.getAmount() + " items. You are only allowed to hold one!"));
                        return true;
                    }
                    player.sendMessage(format(pluginPrefix + "You have selected your new hat!"));
                    return true;
                }
            }

            if(args.length == 2) {
                if (sender.hasPermission("hhub.admin.commands.getCustomSkullCommand")) {
                    if(args[0].equals("skull")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull(args[1])));
                        player.sendMessage(format(pluginPrefix + "Here's your custom skull hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + "&cAn error has occurred. Make sure you are using the correct syntax:"));
                        player.sendMessage(format(pluginPrefix + "&c/hat skull &o<base64Value>"));
                    }
                } else {
                    player.sendMessage(format(pluginPrefix + noPermission));
                    return true;
                }
            }


            } else {
                player.sendMessage(format(pluginPrefix + noPermission));
            }
        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
