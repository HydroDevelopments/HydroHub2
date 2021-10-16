package xyz.hydro.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.hydro.Main;

import static xyz.hydro.Main.noPermission;

public class CustomHelpCommand implements CommandExecutor {

    private Main plugin;

    public CustomHelpCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("help")) {

            if (sender.hasPermission("hhub.members.command.helpCommand")) {

                for (String msg : plugin.getMessagesConfig().getStringList("helpMenu.strings")) {
                    player.sendMessage(format(msg));
                }

            }else {
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

