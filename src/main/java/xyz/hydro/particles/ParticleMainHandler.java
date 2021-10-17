package xyz.hydro.particles;

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParticleMainHandler {

    private static Map<UUID, Integer> trail = new HashMap<UUID, Integer>();
    private final UUID uuid;

    public ParticleMainHandler(UUID uuid) {
        this.uuid = uuid;
    }

    public void setID(int id) {
        trail.put(uuid, id);
    }

    public int getID() {
        return trail.get(uuid);
    }

    public boolean hasID() {
        if(trail.containsKey(uuid)) {
            return true;
        }
        return false;
    }

    public void removeID() {
        trail.remove(uuid);
    }

    public void stopTrail() {
        if (getID() == 1) {
            return;
        }

        Bukkit.getScheduler().cancelTask(getID());

    }

    public static boolean hasFakeID(UUID uuid) {
        if (trail.containsKey(uuid)) {
            if(trail.get(uuid) == 1) {
                return true;
            }
        }

        return false;
    }
}
