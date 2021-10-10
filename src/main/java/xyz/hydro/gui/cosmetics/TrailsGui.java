package xyz.hydro.gui.cosmetics;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.hydro.Main;
import xyz.hydro.particles.ParticleEffects;
import xyz.hydro.particles.ParticleMainHandler;

import static xyz.hydro.Main.pluginPrefix;

public class TrailsGui implements CommandExecutor {
    private final Main plugin;
    public TrailsGui(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("depreciated")

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        ParticleMainHandler particles = new ParticleMainHandler(player.getUniqueId());
        ParticleEffects trails = new ParticleEffects(player);

        Gui trailsGui = new Gui(6, ChatColor.GRAY + "Trails");
        trailsGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        Gui wingsGui = new Gui(3, "Wings Menu");
        wingsGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        // Wings GUI Items
        GuiItem wingsOne = ItemBuilder.from(Material.BLACK_WOOL).setName("Black and White").asGuiItem(event -> {
            if(particles.hasID()) {
                particles.stopTrail();
                particles.removeID();
            }

            trails.startWingTrail();
            wingsGui.close(player);

            player.sendMessage(format(pluginPrefix + "'Wings' Trail Selected!"));

            event.setCancelled(true);
        });

        // Trail GUI Items

        GuiItem clearTrails = ItemBuilder.from(Material.GLASS_PANE).setName(ChatColor.DARK_GRAY + "Clear Trails").asGuiItem(event -> {
            if(particles.hasID()) {
                particles.stopTrail();
                particles.removeID();
            }

            player.sendMessage(format(pluginPrefix + "Your Trails Have Been Stopped."));

            event.setCancelled(true);
        });

        GuiItem trailOne = ItemBuilder.from(Material.FEATHER).setName(ChatColor.WHITE + "Wings").asGuiItem(event -> {
            wingsGui.open(player);
            event.setCancelled(true);
        });

        // Wings GUI Items

        trailsGui.setItem(2, 3, trailOne);
        trailsGui.setItem(2, 2, clearTrails);

        wingsGui.setItem(2, 2, wingsOne);

        if (cmd.getName().equalsIgnoreCase("trails")) {

            if (sender.hasPermission("hhub.members.command.trailsCommand")) {

                trailsGui.open(player);

            }
        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
