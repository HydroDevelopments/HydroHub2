package xyz.hydro.features.chat;

import me.clip.placeholderapi.PlaceholderAPI;
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

            String joinDefault = format(plugin.getConfig().getString("defaultJoinMessage"));
            joinDefault = PlaceholderAPI.setPlaceholders(player, joinDefault);

            String joinRank1 = format(plugin.getConfig().getString("rankOneJoinMessage"));
            joinRank1 = PlaceholderAPI.setPlaceholders(player, joinRank1);

            String joinRank2 = format(plugin.getConfig().getString("rankTwoJoinMessage"));
            joinRank2 = PlaceholderAPI.setPlaceholders(player, joinRank2);

            String joinRank3 = format(plugin.getConfig().getString("rankThreeJoinMessage"));
            joinRank3 = PlaceholderAPI.setPlaceholders(player, joinRank3);

            String joinRank4 = format(plugin.getConfig().getString("rankFourJoinMessage"));
            joinRank4 = PlaceholderAPI.setPlaceholders(player, joinRank4);

            String joinRank5 = format(plugin.getConfig().getString("rankFiveJoinMessage"));
            joinRank5 = PlaceholderAPI.setPlaceholders(player, joinRank5);

            String joinAdmin = format(plugin.getConfig().getString("adminJoinMessage"));
            joinAdmin = PlaceholderAPI.setPlaceholders(player, joinAdmin);

            String joinOp = format(plugin.getConfig().getString("opJoinMessage"));
            joinOp = PlaceholderAPI.setPlaceholders(player, joinOp);

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


            if(player.isOp()) {
                Bukkit.broadcastMessage(joinOp);
                return;
            }

            if(player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(joinDefault);
                return;
            }

            if(!player.hasPermission(defaultJoin) && player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(joinRank1);
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(joinRank2);
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(joinRank3);
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(joinRank4);
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    player.hasPermission(rank5Join) && !player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(joinRank5);
                return;
            }

            if(!player.hasPermission(defaultJoin) && !player.hasPermission(rank1Join) || !player.hasPermission(rank2Join) || !player.hasPermission(rank3Join) || !player.hasPermission(rank4Join) ||
                    !player.hasPermission(rank5Join) && player.hasPermission(adminJoin) && !player.hasPermission(opJoin)) {
                Bukkit.broadcastMessage(joinAdmin);
                return;
            }

        }

        // Does nothing since it's disabled in config.

    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
