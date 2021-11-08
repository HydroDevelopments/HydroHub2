package xyz.hydro.features.holograms;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.hydro.Main;

public class MainHoloCommand implements CommandExecutor {

    private Main plugin;
    public MainHoloCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("holo")) {

            if(args.length == 0 || args[0].equals("help")) {
                if (player.hasPermission("hhub.admin.commands.mainHoloCommand")) {
                    player.sendMessage(format("&5&l&oHologram Commmands!"));
                    player.sendMessage(format("&b/holo create {name} {message} &f- &6Create a hologram with a message."));
                    player.sendMessage(format("&b/holo select [name] &f- &6Selects the hologram you specify or are looking at."));
                    player.sendMessage(format("&b/holo addline {msg} &f- &6Add's a line to a hologram. (Select a holo first!)"));
                    player.sendMessage(format("&b/holo remove [name] &f- &6Removes a holo that is specified or selected."));
                    player.sendMessage(format("&b/holo movehere {name} &f- &6Move the holo to where you are currently positioned!"));
                    return true;
                }
            }

            if(args[0].equals("create") && args[1] == null) {
                player.sendMessage(format("&cIncorrect Syntax! Please Use:"));
                player.sendMessage(format("&c&o/holo create {name} {message}"));
                return true;
            } else if(args[0].equals("create") && args[1])

        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
