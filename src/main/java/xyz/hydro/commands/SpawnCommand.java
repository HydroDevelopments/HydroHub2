package xyz.hydro.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.hydro.Main;

import java.util.Objects;

import static xyz.hydro.Main.pluginPrefix;

public class SpawnCommand implements CommandExecutor {

    private Main plugin;
    public SpawnCommand(Main plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("spawn")) {

            if (sender.hasPermission("hhub.member.command.spawnCommand")) {
                Player p = (Player) sender;

                World world = plugin.getServer().getWorld(Objects.requireNonNull(plugin.getConfig().getString("worldSpawnName")));
                double x = plugin.getConfig().getDouble("worldSpawnX");
                double y = plugin.getConfig().getDouble("worldSpawnY");
                double z = plugin.getConfig().getDouble("worldSpawnZ");
                double yaw = plugin.getConfig().getDouble("worldSpawnYaw");
                double pitch = plugin.getConfig().getDouble("worldSpawnPitch");

                if (world == null) {
                    p.sendMessage(format(pluginPrefix + "You cannot be teleported as it has been configured incorrectly. Please notify an admin and try again."));
                    return true;
                } else {

                    p.sendMessage(format(pluginPrefix + "&cYou will be teleported to spawn in 5 seconds. You are allowed to move."));

                    plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                        @Override
                        public void run() {
                            p.teleport(new Location(world, x, y, z, (float)yaw, (float)pitch));
                        }

                    }, 20 * 5);
                }
            }
        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
