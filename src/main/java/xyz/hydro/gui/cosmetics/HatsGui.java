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
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import xyz.hydro.Main;

import static xyz.hydro.utils.CustomSkullGetter.getSkull;

public class HatsGui implements CommandExecutor, Listener {

    private Main plugin;
    public HatsGui(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("depreciated")

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;

        // Main GUI's

        Gui hatsGui = new Gui(6, ChatColor.GRAY + "Hats");
        hatsGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        Gui alphabetGui = new Gui(5, "Alphabet");
        alphabetGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        Gui emojiGui = new Gui(4, "Emoticons");
        emojiGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        Gui foodGui = new Gui(6, "Food Hats");
        foodGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        Gui characterGui = new Gui(4, "Character Hats");
        characterGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        Gui mobGui = new Gui(3, "Mob Hats");
        mobGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        Gui colorGui = new Gui(4, "Solid Colors");
        colorGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        Gui blockGui = new Gui(5, "Block hats");
        blockGui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        // Main GUI's Click Events
        GuiItem alphabetHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM2MGRhMjk0NGExNzdkZDA4MjY4ZmJlYzA0ZTQwODEyZDFkOTI5NjUwYmU2NjUyOWIxZWU1ZTFlN2VjYSJ9fX0=")))
                .setName("Alphabet Hats").setLore("Here you can pick any letter to use as a hat!").asGuiItem(event -> {
            alphabetGui.open(player);
            event.setCancelled(true);
        });

        GuiItem emoteHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjRlYTJkNmY5MzlmZWZlZmY1ZDEyMmU2M2RkMjZmYThhNDI3ZGY5MGIyOTI4YmMxZmE4OWE4MjUyYTdlIn19fQ==")))
                .setName("Emoji Hats").setLore("Want to express your feelings more? These are the hats for you!").asGuiItem(event -> {
                    emojiGui.open(player);
                    event.setCancelled(true);
                });

        GuiItem foodHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2RhZGYxNzQ0NDMzZTFjNzlkMWQ1OWQyNzc3ZDkzOWRlMTU5YTI0Y2Y1N2U4YTYxYzgyYmM0ZmUzNzc3NTUzYyJ9fX0=")))
                .setName("Food Hats").setLore("Hungry and want to make others hungry? Here's our delicious food hats!").asGuiItem(event -> {
                    foodGui.open(player);
                    event.setCancelled(true);
                });

        GuiItem characterHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFhMDU5NjZkYmIzOWY3ODBlN2VhNjNhMjk1NjBkOGViNDhlMGMyNDk3YTgxOGE4OTU2NGE1YTE0YTMzZWYifX19")))
                .setName("Characters").setLore("Wanna be in disguise? Pick a familiar face here!").asGuiItem(event -> {
                    characterGui.open(player);
                    event.setCancelled(true);
                });

        GuiItem mobHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E1OWJiMGE3YTMyOTY1YjNkOTBkOGVhZmE4OTlkMTgzNWY0MjQ1MDllYWRkNGU2YjcwOWFkYTUwYjljZiJ9fX0=")))
                .setName("Mob Hats").setLore("Mob and Animal hats! Plenty to choose from.").asGuiItem(event -> {
                    mobGui.open(player);
                    event.setCancelled(true);
                });

        GuiItem colorHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTkzNTJiY2FiZmMyN2VkYjQ0Y2ViNTFiMDQ3ODY1NDJmMjZhMjk5YTA1Mjk0NzUzNDYxODZlZTk0NzM4ZiJ9fX0=")))
                .setName("Color Hats").setLore("Feeling sorta blue? Show it off to people with the color hats!").asGuiItem(event -> {
                    colorGui.open(player);
                    event.setCancelled(true);
                });

        GuiItem blockHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGZjNDk1ZDFlNmViNTRhMzg2MDY4YzZjYjEyMWM1ODc1ZTAzMWI3ZjYxZDcyMzZkNWYyNGI3N2RiN2RhN2YifX19")))
                .setName("Block Hats").setLore("Want to hide in plain sight? We have just the thing!").asGuiItem(event -> {
                    blockGui.open(player);
                    event.setCancelled(true);
                });


        // Setting the main GUI's items
        hatsGui.setItem(2, 2, alphabetHats);
        hatsGui.setItem(2, 4, emoteHats);
        hatsGui.setItem(2, 6, foodHats);
        hatsGui.setItem(2, 8, characterHats);
        hatsGui.setItem(4, 3, mobHats);
        hatsGui.setItem(4, 5, colorHats);
        hatsGui.setItem(4, 7, blockHats);


        if (cmd.getName().equalsIgnoreCase("hatsgui")) {

            if (sender.hasPermission("hhub.members.command.hatsGuiCommand")) {

                hatsGui.open(player);

            }
        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
