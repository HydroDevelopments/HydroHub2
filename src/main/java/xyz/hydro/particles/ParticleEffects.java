package xyz.hydro.particles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import xyz.hydro.Main;

public class ParticleEffects {

    private int taskID;
    private final Player player;

    public ParticleEffects(Player player) {
        this.player = player;
    }

    public void startWingTrail() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, one, two;
            ParticleMainHandler particle = new ParticleMainHandler(player.getUniqueId());

            @Override
            public void run() {

                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                var += Math.PI /16;

                loc = player.getLocation();
                one = loc.clone().add(Math.cos(var), Math.sin(var) + 1, Math.sin(var));
                two = loc.clone().add(Math.cos(var + Math.PI), Math.sin(var) + 1, Math.sin(var + Math.PI));

                player.getWorld().spawnParticle(Particle.PORTAL, one, 0);
                player.getWorld().spawnParticle(Particle.PORTAL, two, 0);

            }
        }, 0, 10);
    }
}
