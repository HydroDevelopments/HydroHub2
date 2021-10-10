package xyz.hydro.features.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.hydro.Main;

import java.util.Objects;

public class PlayerJoinMessage implements Listener {

    private Main plugin;
    public PlayerJoinMessage(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if(plugin.getConfig().getBoolean("announcePlayerJoin")) {

            // Member Messages
            String defaultJoin = "hhub.joinMessages.defaultMessagePermission";
            String rank1Join = "hhub.joinMessages.rankOneMessagePermission";
            String rank2Join = "hhub.joinMessages.rankTwoMessagePermission";
            String rank3Join = "hhub.joinMessages.rankThreeMessagePermission";
            String rank4Join = "hhub.joinMessages.rankFourMessagePermission";
            String rank5Join = "hhub.joinMessages.rankFiveMessagePermission";

            // Staff Messages
            String adminJoin = "hhub.joinMessages.adminMessagePermission";
            String opJoin = "hhub.joinMessage.opMessagePermission";


            if(player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(Objects.requireNonNull(plugin.getMessagesConfig().getString("defaultJoinMessage")));
                return;
            }

            if(!player.hasPermission(defaultJoin) && player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(Objects.requireNonNull(plugin.getMessagesConfig().getString("rankOneJoinMessage")));
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(Objects.requireNonNull(plugin.getMessagesConfig().getString("rankTwoJoinMessage")));
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(Objects.requireNonNull(plugin.getMessagesConfig().getString("rankThreeJoinMessage")));
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(Objects.requireNonNull(plugin.getMessagesConfig().getString("rankFourJoinMessage")));
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(Objects.requireNonNull(plugin.getMessagesConfig().getString("rankFiveJoinMessage")));
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(Objects.requireNonNull(plugin.getMessagesConfig().getString("adminJoinMessage")));
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(Objects.requireNonNull(plugin.getMessagesConfig().getString("opJoinMessage")));
            }

        }

    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
