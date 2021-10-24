package xyz.hydro.gui.cosmetics;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import xyz.hydro.Main;
import xyz.hydro.particles.ParticleEffects;
import xyz.hydro.particles.ParticleMainHandler;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.UUID;

import static xyz.hydro.Main.noPermission;
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

        Gui trailsGui = new Gui(5, ChatColor.GRAY + "Trails");
        trailsGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        trailsGui.getFiller().fill(ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE).setName(" ").asGuiItem());

        //Gui wingsGui = new Gui(3, "Wings Menu");
        //wingsGui.setDefaultClickAction(event -> {
        //    event.setCancelled(true);
        //});

        // Wings GUI Items
        //GuiItem wingsOne = ItemBuilder.from(Material.BLACK_WOOL).setName("Black and White").asGuiItem(event -> {

//            event.setCancelled(true);
//        });

        // Trail GUI Items

        GuiItem clearTrails = ItemBuilder.from(Material.GLASS_PANE).setName(ChatColor.DARK_GRAY + "Clear Trails").asGuiItem(event -> {
            if(particles.hasID()) {
                particles.stopTrail();
                particles.removeID();

                player.sendMessage(format(pluginPrefix + "Your Trails Have Been Stopped."));
            } else {
                player.sendMessage(format(pluginPrefix + "You do not have any trails active."));
            }

            event.setCancelled(true);
        });

        GuiItem trailOne = ItemBuilder.from(Material.FEATHER).setName(ChatColor.WHITE + "Wings").asGuiItem(event -> {
            //wingsGui.open(player);

            event.setCancelled(true);
        });

        GuiItem crossLoopTrail = ItemBuilder.from(Material.ICE).setName(ChatColor.WHITE + "CrossLoop").asGuiItem(event -> {

            if(player.hasPermission("hhub.cosmetics.particles.crossLoop")) {

                if (particles.hasID()) {
                    particles.stopTrail();
                    particles.removeID();
                }

                trails.startCrossLoop();
                trailsGui.close(player);

                player.sendMessage(format(pluginPrefix + "'CrossLoop' Trail Selected!"));
            } else {
                player.sendMessage(format(pluginPrefix + "You do not have permission to use this trail."));
            }

            event.setCancelled(true);
        });

        GuiItem hotHeadTrail = ItemBuilder.from(Material.FLINT_AND_STEEL).setName(ChatColor.RED + "Hot-Head").asGuiItem(event -> {

            if(player.hasPermission("hhub.cosmetics.particles.hotHead")) {

                if (particles.hasID()) {
                    particles.stopTrail();
                    particles.removeID();
                }

                trails.startHotHeadLoop();
                trailsGui.close(player);

                player.sendMessage(format(pluginPrefix + "'Hot-Head' Trail Selected!"));
            } else {
                player.sendMessage(format(pluginPrefix + "You do not have permission to use this trail."));
            }

            event.setCancelled(true);
        });

        GuiItem haloTrail = ItemBuilder.from(Material.ARROW).setName(ChatColor.YELLOW + "Halo").asGuiItem(event -> {

            if(player.hasPermission("hhub.cosmetics.particles.halo")) {

                if (particles.hasID()) {
                    particles.stopTrail();
                    particles.removeID();
                }

                trails.startHaloLoop();
                trailsGui.close(player);

                player.sendMessage(format(pluginPrefix + "'Halo' Trail Selected!"));
            } else {
                player.sendMessage(format(pluginPrefix + "You do not have permission to use this trail."));
            }

            event.setCancelled(true);
        });

        GuiItem milkRain = ItemBuilder.from(Material.MILK_BUCKET).setName(ChatColor.WHITE + "Milk Rain").asGuiItem(event -> {

            if(player.hasPermission("hhub.cosmetics.particles.milkRain")) {

                if (particles.hasID()) {
                    particles.stopTrail();
                    particles.removeID();
                }

                trails.startMilkRain();
                trailsGui.close(player);

                player.sendMessage(format(pluginPrefix + "'Milk Rain' Trail Selected!"));
            } else {
                player.sendMessage(format(pluginPrefix + "You do not have permission to use this trail."));
            }

            event.setCancelled(true);
        });

        GuiItem antiHalo = ItemBuilder.from(Material.LAVA_BUCKET).setName(format("&4Anti-Halo")).asGuiItem(event -> {

            if(player.hasPermission("hhub.cosmetics.particles.antiHalo")) {

                if (particles.hasID()) {
                    particles.stopTrail();
                    particles.removeID();
                }

                trails.startAntiHalo();
                trailsGui.close(player);

                player.sendMessage(format(pluginPrefix + "&4Anti-Halo' Trail Selected!"));
            } else {
                player.sendMessage(format(pluginPrefix + "You do not have permission to use this trail."));
            }

            event.setCancelled(true);
        });

        GuiItem loveable = ItemBuilder.from(Material.SHIELD).setName(ChatColor.LIGHT_PURPLE + "Force-Field").asGuiItem(event -> {

            if(player.hasPermission("hhub.cosmetics.particles.forcefield")) {

                if (particles.hasID()) {
                    particles.stopTrail();
                    particles.removeID();
                }

                trails.startForcefield();
                trailsGui.close(player);

                player.sendMessage(format(pluginPrefix + "&dForce-Field' Trail Selected!"));
            } else {
                player.sendMessage(format(pluginPrefix + "You do not have permission to use this trail."));
            }
        });


        GuiItem comingSoon = ItemBuilder.from(Material.BEDROCK).setName(format("&cComing Soon...")).asGuiItem(event -> {

            trailsGui.close(player);

            player.sendMessage(format(pluginPrefix + "These trails are coming soon..."));

            event.setCancelled(true);
        });

        GuiItem backArrow = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2ViZjkwNzQ5NGE5MzVlOTU1YmZjYWRhYjgxYmVhZmI5MGZiOWJlNDljNzAyNmJhOTdkNzk4ZDVmMWEyMyJ9fX0=")))
                .setName(format("&3Server Selector")).setLore("Return To Server Selector").asGuiItem(event -> {
                    player.performCommand("serverselector");
                    event.setCancelled(true);
        });

        GuiItem frontArrow = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWE0ZjY4YzhmYjI3OWU1MGFiNzg2ZjlmYTU0Yzg4Y2E0ZWNmZTFlYjVmZDVmMGMzOGM1NGM5YjFjNzIwM2Q3YSJ9fX0=")))
                .setName(format("&bHub Selector")).setLore("Go to the Hub Selector!").asGuiItem(event -> {
                player.performCommand("lobbyselector");
                event.setCancelled(true);
        });

        // Wings GUI Items

        trailsGui.setItem(2, 2, clearTrails);
        //trailsGui.setItem(2, 3, trailOne);
        trailsGui.setItem(2, 3, crossLoopTrail);
        trailsGui.setItem(2, 4, milkRain);
        trailsGui.setItem(2, 5, haloTrail);
        trailsGui.setItem(2, 6, antiHalo);
        trailsGui.setItem(2, 7, hotHeadTrail);
        trailsGui.setItem(2, 8, loveable);

        trailsGui.setItem(3, 2, comingSoon);
        trailsGui.setItem(3, 3, comingSoon);
        trailsGui.setItem(3, 4, comingSoon);
        trailsGui.setItem(3, 5, comingSoon);
        trailsGui.setItem(3, 6, comingSoon);
        trailsGui.setItem(3, 7, comingSoon);
        trailsGui.setItem(3, 8, comingSoon);
        trailsGui.setItem(4, 2, comingSoon);
        trailsGui.setItem(4, 3, comingSoon);
        trailsGui.setItem(4, 4, comingSoon);
        trailsGui.setItem(4, 5, comingSoon);
        trailsGui.setItem(4, 6, comingSoon);
        trailsGui.setItem(4, 7, comingSoon);
        trailsGui.setItem(4, 8, comingSoon);

        trailsGui.setItem(5, 1, backArrow);
        trailsGui.setItem(5, 9, frontArrow);

        //wingsGui.setItem(2, 2, wingsOne);

        if (cmd.getName().equalsIgnoreCase("trails")) {

            if (sender.hasPermission("hhub.members.command.trailsCommand")) {

                trailsGui.open(player);

            }else {
                sender.sendMessage(format(noPermission));
                return true;
            }
        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static ItemStack getSkull(String url) {
        ItemStack item = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
        if(url.isEmpty())return item;


        SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));
        Field profileField = null;
        try
        {
            profileField = itemMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(itemMeta, profile);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        item.setItemMeta(itemMeta);
        return item;
    }

}
