package xyz.hydro.features.chat;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.hydro.Main;

import java.util.Objects;

public class JoinMessage implements Listener {

    private Main plugin;
    public JoinMessage(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if(plugin.getConfig().getBoolean("announcePlayerJoin")) {

            Bukkit.broadcastMessage(Objects.requireNonNull(plugin.getMessagesConfig().getString("defaultJoinMessage")));

        }

    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
