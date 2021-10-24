package xyz.hydro.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import xyz.hydro.Main;

import static xyz.hydro.Main.noPermission;
import static xyz.hydro.Main.pluginPrefix;

public class HatsCommand implements CommandExecutor, Listener {

    private Main plugin;
    public HatsCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("hat")) {

            if (sender.hasPermission("hhub.members.command.hatsGuiCommand")) {

            if(args.length == 0) {
                if(player.getInventory().getItemInMainHand().equals(Material.AIR)) {

                    player.sendMessage(format(pluginPrefix + "You are not holding anything in your main hand!"));
                    return true;

                } else {



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
