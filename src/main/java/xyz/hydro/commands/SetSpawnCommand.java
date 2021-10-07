package xyz.hydro.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import xyz.hydro.Main;

import static xyz.hydro.Main.noPermission;
import static xyz.hydro.Main.pluginPrefix;

public class SetSpawnCommand implements CommandExecutor, Listener {

    private Main plugin;

    public SetSpawnCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("setspawn")) {

            if (sender.hasPermission("hhub.admin.command.setWorldSpawn")) {

                plugin.getLocationsConfig().set("worldSpawnName", player.getWorld().getName());
                plugin.getLocationsConfig().set("worldSpawnX", player.getLocation().getX());
                plugin.getLocationsConfig().set("worldSpawnY", player.getLocation().getY());
                plugin.getLocationsConfig().set("worldSpawnZ", player.getLocation().getZ());
                plugin.getLocationsConfig().set("worldSpawnYaw", player.getLocation().getYaw());
                plugin.getLocationsConfig().set("worldSpawnPitch", player.getLocation().getPitch());

                plugin.saveLocationConfig();
                plugin.reloadLocationsConfig();
                plugin.getLocationsConfig().options().copyDefaults();

                player.sendMessage(format(pluginPrefix + "Spawn Set Successfully!"));

            } else {
                player.sendMessage(format(noPermission));
            }

        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
