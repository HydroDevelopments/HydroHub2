package xyz.hydro.features.hubItems;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.hydro.Main;

public class ItemsOnJoin implements Listener {

    private Main plugin;
    public ItemsOnJoin(Main plugin) {
        this.plugin = plugin;
    }



    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
    }

}
