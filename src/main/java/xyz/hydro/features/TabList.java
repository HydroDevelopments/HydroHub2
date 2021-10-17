package xyz.hydro.features;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import xyz.hydro.Main;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TabList implements Listener {

    private List<ChatComponentText> headers = new ArrayList<>();
    private List<ChatComponentText> footers = new ArrayList<>();

    private Main plugin;
    public TabList(Main plugin) {
        this.plugin = plugin;
    }

    public void showTab() {
        if(headers.isEmpty() && footers.isEmpty())
            return;

        if(!plugin.getConfig().getBoolean("tabListEnabled")) {
            return;
        } else {
            Bukkit.getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {
                PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
                int headCount = 0;
                int footCount = 0;

                @Override
                public void run() {
                    try {

                        Field a = packet.getClass().getDeclaredField("header");
                        a.setAccessible(true);
                        Field b = packet.getClass().getDeclaredField("footer");
                        b.setAccessible(true);

                        if (headCount >= headers.size())
                            headCount = 0;

                        if (footCount >= footers.size())
                            footCount = 0;

                        a.set(packet, headers.get(headCount));
                        b.set(packet, footers.get(footCount));

                        if (Bukkit.getOnlinePlayers().size() != 0) {
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
                            }
                        }

                        headCount++;
                        footCount++;

                    } catch (Exception e) {
                        // Log any errors.
                        e.printStackTrace();
                    }

                }
            }, 10, plugin.getConfig().getLong("tabListTimer"));
        }
    }

    public void addHeader(String header) {
        headers.add(new ChatComponentText(format(header)));
    }

    public void addFooter(String footer) {
        footers.add(new ChatComponentText(format(footer)));
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }


}
