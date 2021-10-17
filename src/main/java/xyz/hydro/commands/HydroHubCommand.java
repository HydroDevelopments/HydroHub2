package xyz.hydro.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.hydro.Main;

import static xyz.hydro.Main.*;

public class HydroHubCommand implements CommandExecutor {

    private Main plugin;

    public HydroHubCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("hydrohub")) {

            if(sender.hasPermission("hhub.admin.command.mainCommand")) {

                player.sendMessage(format(pluginPrefix + "&aVersion: " + pluginVersion));
                player.sendMessage(format(pluginPrefix + "&6Made by " + pluginContributors));

            } else {
                player.sendMessage(format(noPermission));
                return true;
            }

        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
