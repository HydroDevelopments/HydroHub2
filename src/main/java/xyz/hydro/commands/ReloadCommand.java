package xyz.hydro.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.hydro.Main;

import static xyz.hydro.Main.pluginPrefix;

public class ReloadCommand implements CommandExecutor {

    private Main plugin;

    public ReloadCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(cmd.getName().equalsIgnoreCase("hydroreload")) {

            if(sender.hasPermission("hhub.admin.command.reloadExecution")) {

                    plugin.getLogger().info("Reloading config.yml...");
                    plugin.saveDefaultConfig();
                    plugin.reloadConfig();
                    plugin.getConfig().options().copyDefaults();
                    plugin.saveDefaultConfig();
                    plugin.getLogger().info("Reloaded config.yml!");

                sender.sendMessage(format(pluginPrefix + "&aAll Config Files Have Been Reloaded."));
                return true;

            } else {

                sender.sendMessage(format(pluginPrefix + "&cYou Have No Permissions Todo This."));
                return true;

            }
        }
        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}