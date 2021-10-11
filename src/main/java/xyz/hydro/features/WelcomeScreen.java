package xyz.hydro.features;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.hydro.Main;

public class WelcomeScreen implements Listener {

    private Main plugin;
    public WelcomeScreen(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player= e.getPlayer();

        if(!player.hasPlayedBefore()) {
            player.sendTitle(format(plugin.getMessagesConfig().getString("firstWelcomeTitle")), format(plugin.getMessagesConfig().getString("firstWelcomeSub")), 20, 40, 15);
        } else {
            player.sendTitle(format(plugin.getMessagesConfig().getString("returningWelcomeTitle")), format(plugin.getMessagesConfig().getString("returningWelcomeSub")), 20, 40, 15);
        }

        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3.0F, 0.533F);

    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
