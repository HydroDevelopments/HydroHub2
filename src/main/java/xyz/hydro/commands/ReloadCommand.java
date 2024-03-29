package xyz.hydro.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.hydro.Main;

import static xyz.hydro.Main.noPermission;
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

                    plugin.getLogger().info("Starting Reload...");
                    plugin.getLogger().info("Reloading config.yml...");

                    // Reloads Default Config (config.yml)
                    plugin.saveDefaultConfig();
                    plugin.reloadConfig();
                    plugin.getConfig().options().copyDefaults();
                    plugin.saveDefaultConfig();
                    plugin.getLogger().info("Reloaded config.yml!");

                    // Reloads Messages Config (messages.yml)
                    plugin.reloadMessagesConfig();
                    plugin.saveMessagesConfig();
                    plugin.getLogger().info("Reloaded messages.yml!");

                    // Reloads Locations Config (locations.yml)
                    plugin.reloadLocationsConfig();
                    plugin.saveLocationConfig();
                    plugin.getLogger().info("Reloaded locations.yml");

                    // Reloads serverSelector Config (serverSelector.yml)
                    plugin.reloadServerConfig();
                    plugin.saveServerConfig();
                    plugin.getLogger().info("Reloaded serverSelector.yml");


                    plugin.getLogger().info("Successfully Reloaded All Config Files.");

                sender.sendMessage(format(pluginPrefix + plugin.getMessagesConfig().getString("configReloadMsg")));
                return true;

            }else {
                sender.sendMessage(format(noPermission));
                return true;
            }
        }
        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
