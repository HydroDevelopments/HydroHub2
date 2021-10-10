package xyz.hydro.particles;

import org.bukkit.Bukkit;
import org.bukkit.Color;
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

    @SuppressWarnings("depreciated")

    public void startCrossLoop() {
        taskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, one, two;
            ParticleMainHandler particle = new ParticleMainHandler(player.getUniqueId());

            @Override
            public void run() {

                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                var += Math.PI / 16;

                loc = player.getLocation();
                one = loc.clone().add(Math.cos(var), Math.sin(var) + 1, Math.sin(var));
                two = loc.clone().add(Math.cos(var + Math.PI), Math.sin(var) + 1, Math.sin(var + Math.PI));

                player.getWorld().spawnParticle(Particle.SPELL, one, 0);
                player.getWorld().spawnParticle(Particle.SPELL, two, 0);

            }
        }, 0, 1);
    }

    public void startHotHeadLoop() {
        taskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, one, two;
            ParticleMainHandler particle = new ParticleMainHandler(player.getUniqueId());

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                //var += Math.PI /16;

                loc = player.getLocation();
                one = loc.clone().add(Math.cos(var) - 1, Math.sin(var) + 2.3, Math.sin(var));

                player.getWorld().spawnParticle(Particle.FLAME, one, 0);

            }
        }, 0, 5);
    }

    public void startHaloLoop() {
        taskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            Location loc;
            ParticleMainHandler particle = new ParticleMainHandler(player.getUniqueId());

            private float radius = 0.4f;
            private float angle = 0.8f;

            @Override
            public void run() {
                if(!particle.hasID()) {
                    particle.setID(taskID);
                }

                loc = player.getLocation();
                double x = (radius * Math.sin(angle));
                double z = (radius * Math.cos(angle));
                angle += 1f;

                player.spawnParticle(Particle.DRAGON_BREATH,
                        loc.getX() + x,
                        loc.getY() + 2.3,
                        loc.getZ() + z,
                        0);

                player.spawnParticle(Particle.DRAGON_BREATH,
                        loc.getX() - x,
                        loc.getY() + 2.3,
                        loc.getZ() - z,
                        0);

            }
        }, 0, 5);
    }

}
