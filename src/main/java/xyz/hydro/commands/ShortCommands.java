package xyz.hydro.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.hydro.Main;

import static xyz.hydro.Main.pluginPrefix;

public class ShortCommands implements CommandExecutor {

    private Main plugin;

    public ShortCommands(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("hhub.admin.commands.smallCommands")) {

                if (command.getName().equalsIgnoreCase("gm")) {
                    player.sendMessage(format(pluginPrefix + "&cInvalid syntax! Please use one of the following commands:\n&c&o/gmc, /gms, /gma &cor&o /gm3."));
                }

                if (command.getName().equalsIgnoreCase("gmc")) {
                    if (player.getGameMode() == GameMode.CREATIVE) {
                        player.sendMessage(format(pluginPrefix + "You are already in Creative!"));
                        return true;
                    } else {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(format(pluginPrefix + "Your gamemode has been updated to Creative."));
                        return true;
                    }
                }

                if (command.getName().equalsIgnoreCase("gms")) {
                    if (player.getGameMode() == GameMode.SURVIVAL) {
                        player.sendMessage(format(pluginPrefix + "You are already in Survival!"));
                        return true;
                    } else {
                        player.sendMessage(format(pluginPrefix + "Your gamemode has been updated to Survival."));
                        player.setGameMode(GameMode.SURVIVAL);
                        return true;
                    }
                }

                if (command.getName().equalsIgnoreCase("gma")) {
                    if (player.getGameMode() == GameMode.ADVENTURE) {
                        player.sendMessage(format(pluginPrefix + "You are already in Adventure!"));
                        return true;
                    } else {
                        player.sendMessage(format(pluginPrefix + "Your gamemode has been updated to Adventure."));
                        player.setGameMode(GameMode.ADVENTURE);
                        return true;
                    }
                }

                if (command.getName().equalsIgnoreCase("gm3") || command.getName().equalsIgnoreCase("gmsp")) {
                    if (player.getGameMode() == GameMode.SPECTATOR) {
                        player.sendMessage(format(pluginPrefix + "You are already in Spectator!"));
                        return true;
                    } else {
                        player.sendMessage(format(pluginPrefix + "Your gamemode has been updated to Spectator."));
                        player.setGameMode(GameMode.SPECTATOR);
                        return true;
                    }
                }
            }
        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}