package xyz.hydro.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.hydro.Main;

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



            }

        }


        return true;
    }

}
