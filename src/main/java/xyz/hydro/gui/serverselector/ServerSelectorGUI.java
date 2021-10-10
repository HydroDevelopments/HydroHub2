package xyz.hydro.gui.serverselector;

import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import xyz.hydro.Main;

public class ServerSelectorGUI implements CommandExecutor, Listener {
    private final Main plugin;
    public ServerSelectorGUI(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("depreciated")

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        // Server Selector GUI

        Gui server = new Gui(9, ChatColor.GRAY + "Server Selector");
        server.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        /*
        * THIS IS BEING DONE LATE
        * HONESTLY CAN'T BE ARSED RIGHT NOW
        * IT'S GONNA BE A LONG PROCESS, RISMOSE NEEDS TO HELP ME
        * COSMETIC MENU IS BEING CONSTRUCTED FIRST, ANYWAYS.
         */


        if (cmd.getName().equalsIgnoreCase("serverselector")) {

            if (sender.hasPermission("hhub.members.command.serverSelectorCommand")) {



            }
        }

        return true;
    }

}
