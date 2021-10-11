package xyz.hydro.gui.cosmetics;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
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
            //wingsGui.open(player);



            event.setCancelled(true);
        });

        GuiItem crossLoopTrail = ItemBuilder.from(Material.ICE).setName(ChatColor.WHITE + "CrossLoop").asGuiItem(event -> {
            if(particles.hasID()) {
                particles.stopTrail();
                particles.removeID();
            }

            trails.startCrossLoop();
            wingsGui.close(player);

            player.sendMessage(format(pluginPrefix + "'CrossLoop' Trail Selected!"));

            event.setCancelled(true);
        });

        GuiItem hotHeadTrail = ItemBuilder.from(Material.FLINT_AND_STEEL).setName(ChatColor.RED + "Hot-Head").asGuiItem(event -> {
            if(particles.hasID()) {
                particles.stopTrail();
                particles.removeID();
            }

            trails.startHotHeadLoop();
            wingsGui.close(player);

            player.sendMessage(format(pluginPrefix + "'Hot-Head' Trail Selected!"));

            event.setCancelled(true);
        });

        GuiItem haloTrail = ItemBuilder.from(Material.ARROW).setName(ChatColor.YELLOW + "Halo").asGuiItem(event -> {
            if(particles.hasID()) {
                particles.stopTrail();
                particles.removeID();
            }

            trails.startHaloLoop();
            wingsGui.close(player);

            player.sendMessage(format(pluginPrefix + "'Halo' Trail Selected!"));

            event.setCancelled(true);
        });

        /*GuiItem rainbowRain = ItemBuilder.from(Material.WATER_BUCKET).setName(format("&3Rainbow")).asGuiItem(event -> {
            if(particles.hasID()) {
                particles.stopTrail();
                particles.removeID();
            }

            //trails.startRainbowRainLoop();
            wingsGui.close(player);

            player.sendMessage(format(pluginPrefix + "&3Rainbow' Trail Selected!"));

            event.setCancelled(true);
        });*/

        // Wings GUI Items

        trailsGui.setItem(2, 2, clearTrails);
        trailsGui.setItem(2, 3, trailOne);
        trailsGui.setItem(2, 4, crossLoopTrail);
        trailsGui.setItem(2, 5, hotHeadTrail);
        trailsGui.setItem(2, 6, haloTrail);
        //trailsGui.setItem(2, 7, rainbowRain);

        //wingsGui.setItem(2, 2, wingsOne);

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
