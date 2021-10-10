package xyz.hydro.particles.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.hydro.particles.ParticleMainHandler;

public class OnQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        ParticleMainHandler p = new ParticleMainHandler(e.getPlayer().getUniqueId());

        if(p.hasID()) {
            p.stopTrail();
        }
    }
}
