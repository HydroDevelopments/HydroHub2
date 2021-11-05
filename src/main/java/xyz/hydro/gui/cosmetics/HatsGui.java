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
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import xyz.hydro.Main;

import static xyz.hydro.Main.*;
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

        Gui foodGui = new Gui(2, "Food Hats");
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
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.access")) {
                        alphabetGui.open(player);
                        event.setCancelled(true);
                    } else {
                        player.sendMessage(format(pluginPrefix + noPermission));
                        event.setCancelled(true);
                        hatsGui.close(player);
                        return;
                    }
        });

        GuiItem emoteHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjRlYTJkNmY5MzlmZWZlZmY1ZDEyMmU2M2RkMjZmYThhNDI3ZGY5MGIyOTI4YmMxZmE4OWE4MjUyYTdlIn19fQ==")))
                .setName("Emoji Hats").setLore("Want to express your feelings more? These are the hats for you!").asGuiItem(event -> {
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.access")) {
                        emojiGui.open(player);
                        event.setCancelled(true);
                    } else {
                        player.sendMessage(format(pluginPrefix + noPermission));
                        event.setCancelled(true);
                        hatsGui.close(player);
                        return;
                    }
                });

        GuiItem foodHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2RhZGYxNzQ0NDMzZTFjNzlkMWQ1OWQyNzc3ZDkzOWRlMTU5YTI0Y2Y1N2U4YTYxYzgyYmM0ZmUzNzc3NTUzYyJ9fX0=")))
                .setName("Food Hats").setLore("Hungry and want to make others hungry? Here's our delicious food hats!").asGuiItem(event -> {
                    if(player.hasPermission("hhub.cosmetics.hats.food.access")) {
                        foodGui.open(player);
                        event.setCancelled(true);
                    } else {
                        player.sendMessage(format(pluginPrefix + noPermission));
                        event.setCancelled(true);
                        hatsGui.close(player);
                        return;
                    }
                });

        GuiItem characterHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFhMDU5NjZkYmIzOWY3ODBlN2VhNjNhMjk1NjBkOGViNDhlMGMyNDk3YTgxOGE4OTU2NGE1YTE0YTMzZWYifX19")))
                .setName("Characters").setLore("Wanna be in disguise? Pick a familiar face here!").asGuiItem(event -> {
                    if(player.hasPermission("hhub.cosmetics.hats.character.access")) {
                        characterGui.open(player);
                        event.setCancelled(true);
                    } else {
                        player.sendMessage(format(pluginPrefix + noPermission));
                        event.setCancelled(true);
                        hatsGui.close(player);
                        return;
                    }
                });

        GuiItem mobHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E1OWJiMGE3YTMyOTY1YjNkOTBkOGVhZmE4OTlkMTgzNWY0MjQ1MDllYWRkNGU2YjcwOWFkYTUwYjljZiJ9fX0=")))
                .setName("Mob Hats").setLore("Mob and Animal hats! Plenty to choose from.").asGuiItem(event -> {
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.access")) {
                        mobGui.open(player);
                        event.setCancelled(true);
                    } else {
                        player.sendMessage(format(pluginPrefix + noPermission));
                        event.setCancelled(true);
                        hatsGui.close(player);
                        return;
                    }
                });

        GuiItem colorHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTkzNTJiY2FiZmMyN2VkYjQ0Y2ViNTFiMDQ3ODY1NDJmMjZhMjk5YTA1Mjk0NzUzNDYxODZlZTk0NzM4ZiJ9fX0=")))
                .setName("Color Hats").setLore("§oComing Soon!").asGuiItem(event -> {
                    if(player.hasPermission("hhub.cosmetics.hats.color.access")) {
                        colorGui.open(player);
                        event.setCancelled(true);
                    } else {
                        player.sendMessage(format(pluginPrefix + noPermission));
                        event.setCancelled(true);
                        hatsGui.close(player);
                        return;
                    }
                });

        GuiItem blockHats = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGZjNDk1ZDFlNmViNTRhMzg2MDY4YzZjYjEyMWM1ODc1ZTAzMWI3ZjYxZDcyMzZkNWYyNGI3N2RiN2RhN2YifX19")))
                .setName("Block Hats").setLore("§oComing Soon!").asGuiItem(event -> {
                    if(player.hasPermission("hhub.cosmetics.hats.blocks.access")) {
                        blockGui.open(player);
                        event.setCancelled(true);
                    } else {
                        player.sendMessage(format(pluginPrefix + noPermission));
                        event.setCancelled(true);
                        hatsGui.close(player);
                        return;
                    }
                });

        GuiItem backArrow = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2ViZjkwNzQ5NGE5MzVlOTU1YmZjYWRhYjgxYmVhZmI5MGZiOWJlNDljNzAyNmJhOTdkNzk4ZDVmMWEyMyJ9fX0=")))
                .setName(format("&eGo Back")).setLore("Return To Hats Menu").asGuiItem(event -> {
                    player.performCommand("hatsgui");
                    event.setCancelled(true);
                });

        GuiItem backArrowCosmetics = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2ViZjkwNzQ5NGE5MzVlOTU1YmZjYWRhYjgxYmVhZmI5MGZiOWJlNDljNzAyNmJhOTdkNzk4ZDVmMWEyMyJ9fX0=")))
                .setName(format("&eGo Back")).setLore("Return To Cosmetics Menu").asGuiItem(event -> {
                    player.performCommand("cosmetics");
                    event.setCancelled(true);
                });

        GuiItem clearHat = ItemBuilder.from(Material.BARRIER).setName(format("&eClear Hat")).asGuiItem(event -> {
            event.setCancelled(true);
            if(player.hasPermission("hhub.cosmetics.hats.clearHat")) {
                player.getInventory().setHelmet(new ItemStack(Material.AIR));
                hatsGui.close(player);
                player.sendMessage(format(pluginPrefix + "You have cleared your hat!"));
            } else {
                hatsGui.close(player);
                player.sendMessage(format(pluginPrefix + noPermission));
                return;
            }
        });

        GuiItem blackFiller = ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE).setName(" ").asGuiItem(event -> {
            event.setCancelled(true);
        });

        // Alphabet GUI Items
        GuiItem woodA = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTY3ZDgxM2FlN2ZmZTViZTk1MWE0ZjQxZjJhYTYxOWE1ZTM4OTRlODVlYTVkNDk4NmY4NDk0OWM2M2Q3NjcyZSJ9fX0=")))
                .setName("Wooden Letter A").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterAHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTY3ZDgxM2FlN2ZmZTViZTk1MWE0ZjQxZjJhYTYxOWE1ZTM4OTRlODVlYTVkNDk4NmY4NDk0OWM2M2Q3NjcyZSJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden A' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem woodB = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTBjMWI1ODRmMTM5ODdiNDY2MTM5Mjg1YjJmM2YyOGRmNjc4NzEyM2QwYjMyMjgzZDg3OTRlMzM3NGUyMyJ9fX0=")))
                .setName("Wooden Letter B").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterBHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTBjMWI1ODRmMTM5ODdiNDY2MTM5Mjg1YjJmM2YyOGRmNjc4NzEyM2QwYjMyMjgzZDg3OTRlMzM3NGUyMyJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden B' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem woodC = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJlOTgzZWM0NzgwMjRlYzZmZDA0NmZjZGZhNDg0MjY3NjkzOTU1MWI0NzM1MDQ0N2M3N2MxM2FmMThlNmYifX19")))
                .setName("Wooden Letter C").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterCHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJlOTgzZWM0NzgwMjRlYzZmZDA0NmZjZGZhNDg0MjY3NjkzOTU1MWI0NzM1MDQ0N2M3N2MxM2FmMThlNmYifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden C' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });


        GuiItem woodD = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE5M2RjMGQ0YzVlODBmZjlhOGEwNWQyZmNmZTI2OTUzOWNiMzkyNzE5MGJhYzE5ZGEyZmNlNjFkNzEifX19")))
                .setName("Wooden Letter D").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterDHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE5M2RjMGQ0YzVlODBmZjlhOGEwNWQyZmNmZTI2OTUzOWNiMzkyNzE5MGJhYzE5ZGEyZmNlNjFkNzEifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden D' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix  + noHatPermission));
                    }
                });

        GuiItem woodE = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGJiMjczN2VjYmY5MTBlZmUzYjI2N2RiN2Q0YjMyN2YzNjBhYmM3MzJjNzdiZDBlNGVmZjFkNTEwY2RlZiJ9fX0=")))
                .setName("Wooden Letter E").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterEHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGJiMjczN2VjYmY5MTBlZmUzYjI2N2RiN2Q0YjMyN2YzNjBhYmM3MzJjNzdiZDBlNGVmZjFkNTEwY2RlZiJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden E' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem woodF = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjE4M2JhYjUwYTMyMjQwMjQ4ODZmMjUyNTFkMjRiNmRiOTNkNzNjMjQzMjU1OWZmNDllNDU5YjRjZDZhIn19fQ==")))
                .setName("Wooden Letter F").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterFHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjE4M2JhYjUwYTMyMjQwMjQ4ODZmMjUyNTFkMjRiNmRiOTNkNzNjMjQzMjU1OWZmNDllNDU5YjRjZDZhIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden F' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodG = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWNhM2YzMjRiZWVlZmI2YTBlMmM1YjNjNDZhYmM5MWNhOTFjMTRlYmE0MTlmYTQ3NjhhYzMwMjNkYmI0YjIifX19")))
                .setName("Wooden Letter G").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterGHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWNhM2YzMjRiZWVlZmI2YTBlMmM1YjNjNDZhYmM5MWNhOTFjMTRlYmE0MTlmYTQ3NjhhYzMwMjNkYmI0YjIifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden G' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodH = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzFmMzQ2MmE0NzM1NDlmMTQ2OWY4OTdmODRhOGQ0MTE5YmM3MWQ0YTVkODUyZTg1YzI2YjU4OGE1YzBjNzJmIn19fQ==")))
                .setName("Wooden Letter H").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterHHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzFmMzQ2MmE0NzM1NDlmMTQ2OWY4OTdmODRhOGQ0MTE5YmM3MWQ0YTVkODUyZTg1YzI2YjU4OGE1YzBjNzJmIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden H' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodI = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDYxNzhhZDUxZmQ1MmIxOWQwYTM4ODg3MTBiZDkyMDY4ZTkzMzI1MmFhYzZiMTNjNzZlN2U2ZWE1ZDMyMjYifX19")))
                .setName("Wooden Letter I").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterIHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDYxNzhhZDUxZmQ1MmIxOWQwYTM4ODg3MTBiZDkyMDY4ZTkzMzI1MmFhYzZiMTNjNzZlN2U2ZWE1ZDMyMjYifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden I' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodJ = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2E3OWRiOTkyMzg2N2U2OWMxZGJmMTcxNTFlNmY0YWQ5MmNlNjgxYmNlZGQzOTc3ZWViYmM0NGMyMDZmNDkifX19")))
                .setName("Wooden Letter J").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterJHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2E3OWRiOTkyMzg2N2U2OWMxZGJmMTcxNTFlNmY0YWQ5MmNlNjgxYmNlZGQzOTc3ZWViYmM0NGMyMDZmNDkifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden J' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodK = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQ2MWIzOGM4ZTQ1NzgyYWRhNTlkMTYxMzJhNDIyMmMxOTM3NzhlN2Q3MGM0NTQyYzk1MzYzNzZmMzdiZTQyIn19fQ==")))
                .setName("Wooden Letter K").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterKHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQ2MWIzOGM4ZTQ1NzgyYWRhNTlkMTYxMzJhNDIyMmMxOTM3NzhlN2Q3MGM0NTQyYzk1MzYzNzZmMzdiZTQyIn19fQ==")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden K' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodL = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE5ZjUwYjQzMmQ4NjhhZTM1OGUxNmY2MmVjMjZmMzU0MzdhZWI5NDkyYmNlMTM1NmM5YWE2YmIxOWEzODYifX19")))
                .setName("Wooden Letter L").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterLHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE5ZjUwYjQzMmQ4NjhhZTM1OGUxNmY2MmVjMjZmMzU0MzdhZWI5NDkyYmNlMTM1NmM5YWE2YmIxOWEzODYifX19")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden L' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodM = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDljNDVhMjRhYWFiZjQ5ZTIxN2MxNTQ4MzIwNDg0OGE3MzU4MmFiYTdmYWUxMGVlMmM1N2JkYjc2NDgyZiJ9fX0=")))
                .setName("Wooden Letter M").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterMHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDljNDVhMjRhYWFiZjQ5ZTIxN2MxNTQ4MzIwNDg0OGE3MzU4MmFiYTdmYWUxMGVlMmM1N2JkYjc2NDgyZiJ9fX0=")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden M' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodN = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzViOGIzZDhjNzdkZmI4ZmJkMjQ5NWM4NDJlYWM5NGZmZmE2ZjU5M2JmMTVhMjU3NGQ4NTRkZmYzOTI4In19fQ==")))
                .setName("Wooden Letter N").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterIHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzViOGIzZDhjNzdkZmI4ZmJkMjQ5NWM4NDJlYWM5NGZmZmE2ZjU5M2JmMTVhMjU3NGQ4NTRkZmYzOTI4In19fQ==")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden N' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodO = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDExZGUxY2FkYjJhZGU2MTE0OWU1ZGVkMWJkODg1ZWRmMGRmNjI1OTI1NWIzM2I1ODdhOTZmOTgzYjJhMSJ9fX0=")))
                .setName("Wooden Letter O").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterIHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDExZGUxY2FkYjJhZGU2MTE0OWU1ZGVkMWJkODg1ZWRmMGRmNjI1OTI1NWIzM2I1ODdhOTZmOTgzYjJhMSJ9fX0=")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden O' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodP = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTBhNzk4OWI1ZDZlNjIxYTEyMWVlZGFlNmY0NzZkMzUxOTNjOTdjMWE3Y2I4ZWNkNDM2MjJhNDg1ZGMyZTkxMiJ9fX0=")))
                .setName("Wooden Letter P").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterPHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTBhNzk4OWI1ZDZlNjIxYTEyMWVlZGFlNmY0NzZkMzUxOTNjOTdjMWE3Y2I4ZWNkNDM2MjJhNDg1ZGMyZTkxMiJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden P' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodQ = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDM2MDlmMWZhZjgxZWQ0OWM1ODk0YWMxNGM5NGJhNTI5ODlmZGE0ZTFkMmE1MmZkOTQ1YTU1ZWQ3MTllZDQifX19")))
                .setName("Wooden Letter Q").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterQHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDM2MDlmMWZhZjgxZWQ0OWM1ODk0YWMxNGM5NGJhNTI5ODlmZGE0ZTFkMmE1MmZkOTQ1YTU1ZWQ3MTllZDQifX19")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden Q' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodR = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTVjZWQ5OTMxYWNlMjNhZmMzNTEzNzEzNzliZjA1YzYzNWFkMTg2OTQzYmMxMzY0NzRlNGU1MTU2YzRjMzcifX19")))
                .setName("Wooden Letter R").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterRHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTVjZWQ5OTMxYWNlMjNhZmMzNTEzNzEzNzliZjA1YzYzNWFkMTg2OTQzYmMxMzY0NzRlNGU1MTU2YzRjMzcifX19")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden R' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodS = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U0MWM2MDU3MmM1MzNlOTNjYTQyMTIyODkyOWU1NGQ2Yzg1NjUyOTQ1OTI0OWMyNWMzMmJhMzNhMWIxNTE3In19fQ==")))
                .setName("Wooden Letter S").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterSHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U0MWM2MDU3MmM1MzNlOTNjYTQyMTIyODkyOWU1NGQ2Yzg1NjUyOTQ1OTI0OWMyNWMzMmJhMzNhMWIxNTE3In19fQ==")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden S' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodT = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTU2MmU4YzFkNjZiMjFlNDU5YmU5YTI0ZTVjMDI3YTM0ZDI2OWJkY2U0ZmJlZTJmNzY3OGQyZDNlZTQ3MTgifX19")))
                .setName("Wooden Letter T").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterTHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTU2MmU4YzFkNjZiMjFlNDU5YmU5YTI0ZTVjMDI3YTM0ZDI2OWJkY2U0ZmJlZTJmNzY3OGQyZDNlZTQ3MTgifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden T' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodU = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjA3ZmJjMzM5ZmYyNDFhYzNkNjYxOWJjYjY4MjUzZGZjM2M5ODc4MmJhZjNmMWY0ZWZkYjk1NGY5YzI2In19fQ==")))
                .setName("Wooden Letter U").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterUHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjA3ZmJjMzM5ZmYyNDFhYzNkNjYxOWJjYjY4MjUzZGZjM2M5ODc4MmJhZjNmMWY0ZWZkYjk1NGY5YzI2In19fQ==")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden U' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodV = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2M5YTEzODYzOGZlZGI1MzRkNzk5Mjg4NzZiYWJhMjYxYzdhNjRiYTc5YzQyNGRjYmFmY2M5YmFjNzAxMGI4In19fQ==")))
                .setName("Wooden Letter S").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterVHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2M5YTEzODYzOGZlZGI1MzRkNzk5Mjg4NzZiYWJhMjYxYzdhNjRiYTc5YzQyNGRjYmFmY2M5YmFjNzAxMGI4In19fQ==")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden V' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodW = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjY5YWQxYTg4ZWQyYjA3NGUxMzAzYTEyOWY5NGU0YjcxMGNmM2U1YjRkOTk1MTYzNTY3ZjY4NzE5YzNkOTc5MiJ9fX0=")))
                .setName("Wooden Letter W").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterWHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjY5YWQxYTg4ZWQyYjA3NGUxMzAzYTEyOWY5NGU0YjcxMGNmM2U1YjRkOTk1MTYzNTY3ZjY4NzE5YzNkOTc5MiJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden W' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodX = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWE2Nzg3YmEzMjU2NGU3YzJmM2EwY2U2NDQ5OGVjYmIyM2I4OTg0NWU1YTY2YjVjZWM3NzM2ZjcyOWVkMzcifX19")))
                .setName("Wooden Letter X").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterXHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWE2Nzg3YmEzMjU2NGU3YzJmM2EwY2U2NDQ5OGVjYmIyM2I4OTg0NWU1YTY2YjVjZWM3NzM2ZjcyOWVkMzcifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden X' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodY = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzUyZmIzODhlMzMyMTJhMjQ3OGI1ZTE1YTk2ZjI3YWNhNmM2MmFjNzE5ZTFlNWY4N2ExY2YwZGU3YjE1ZTkxOCJ9fX0=")))
                .setName("Wooden Letter Y").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterSHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzUyZmIzODhlMzMyMTJhMjQ3OGI1ZTE1YTk2ZjI3YWNhNmM2MmFjNzE5ZTFlNWY4N2ExY2YwZGU3YjE1ZTkxOCJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden Y' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem woodZ = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTA1ODJiOWI1ZDk3OTc0YjExNDYxZDYzZWNlZDg1ZjQzOGEzZWVmNWRjMzI3OWY5YzQ3ZTFlMzhlYTU0YWU4ZCJ9fX0=")))
                .setName("Wooden Letter Z").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.alphabet.letterSHat") || player.hasPermission("hhub.cosmetics.hats.alphabet.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTA1ODJiOWI1ZDk3OTc0YjExNDYxZDYzZWNlZDg1ZjQzOGEzZWVmNWRjMzI3OWY5YzQ3ZTFlMzhlYTU0YWU4ZCJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Wooden Z' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        // Emoji GUI Items
        GuiItem smiley1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTJlOTgxNjVkZWVmNGVkNjIxOTUzOTIxYzFlZjgxN2RjNjM4YWY3MWMxOTM0YTQyODdiNjlkN2EzMWY2YjgifX19")))
                .setName("Smiley").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.smiley") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTJlOTgxNjVkZWVmNGVkNjIxOTUzOTIxYzFlZjgxN2RjNjM4YWY3MWMxOTM0YTQyODdiNjlkN2EzMWY2YjgifX19")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Smiley' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }

                });

        GuiItem cool1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY4ZjRjZWY5NDlmMzJlMzNlYzVhZTg0NWY5YzU2OTgzY2JlMTMzNzVhNGRlYzQ2ZTViYmZiN2RjYjYifX19")))
                .setName("Sunglasses").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.sunglasses") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY4ZjRjZWY5NDlmMzJlMzNlYzVhZTg0NWY5YzU2OTgzY2JlMTMzNzVhNGRlYzQ2ZTViYmZiN2RjYjYifX19")));

                        player.sendMessage(format(pluginPrefix + "You have selected the 'Sunglasses' hat!"));

                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem deceased1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM3MWU0ZTFjZjZhMWEzNmZkYWUyNzEzN2ZkOWI4NzQ4ZTYxNjkyOTk5MjVmOWFmMmJlMzAxZTU0Mjk4YzczIn19fQ==")))
                .setName("Deceased").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.deceased") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM3MWU0ZTFjZjZhMWEzNmZkYWUyNzEzN2ZkOWI4NzQ4ZTYxNjkyOTk5MjVmOWFmMmJlMzAxZTU0Mjk4YzczIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Deceased' hat!"));

                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem derpy1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDViMDU5NWE1MTFjNGIzNzc0MzdhNTE2ZmVmYmVhMmZmY2YzNTU4NWFlNTM0NjViMGU4NjAyNGEyMTVlYiJ9fX0=")))
                .setName("Derp").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.derp") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDViMDU5NWE1MTFjNGIzNzc0MzdhNTE2ZmVmYmVhMmZmY2YzNTU4NWFlNTM0NjViMGU4NjAyNGEyMTVlYiJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Derpy' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem happy1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDFhYzIxZDkzY2UxN2YyYjdlZTJlMGUwN2E5ODNlZWI0YTUzOWUzNDFjZTVjNzdjMzZjNzIyZjc3YTIyMzUifX19")))
                .setName("Happy").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.happy") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDFhYzIxZDkzY2UxN2YyYjdlZTJlMGUwN2E5ODNlZWI0YTUzOWUzNDFjZTVjNzdjMzZjNzIyZjc3YTIyMzUifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Happy' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem sleepy1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2Q5ZjBmMTllZjE2MWJmYWJhZWFhNDljNTI4ODBiZWNmZTgyZmI5NjJiYmIyMTdkMTc0M2QwZjFiNTNhOTUifX19")))
                .setName("Sleepy").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.sleepy") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2Q5ZjBmMTllZjE2MWJmYWJhZWFhNDljNTI4ODBiZWNmZTgyZmI5NjJiYmIyMTdkMTc0M2QwZjFiNTNhOTUifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Sleepy' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem shocked1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjMyOGRiMWMzMjM1ODVhZGViYTE5MDdjZWQzMDYwNTBlMDJhYTc3NTkxNTg4ZmIxODJmZGVhZjQyM2FkNiJ9fX0=")))
                .setName("Shocked").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.shocked") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjMyOGRiMWMzMjM1ODVhZGViYTE5MDdjZWQzMDYwNTBlMDJhYTc3NTkxNTg4ZmIxODJmZGVhZjQyM2FkNiJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Shocked' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem crying1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzMyZmUxMjFhNjNlYWFiZDk5Y2VkNmQxYWNjOTE3OTg2NTJkMWVlODA4NGQyZjkxMjdkOGEzMTVjYWQ1Y2U0In19fQ==")))
                .setName("Crying").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.crying") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzMyZmUxMjFhNjNlYWFiZDk5Y2VkNmQxYWNjOTE3OTg2NTJkMWVlODA4NGQyZjkxMjdkOGEzMTVjYWQ1Y2U0In19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Crying' hat!"));

                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem intense1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM0NmVlNzZmZDllOTQ3ZTM3ODlmYWMzNDgyMTZhYjk4YzI0MjEyNjhmYWZhZjNlYjI5ZWM5NDljMGI4MjE2OSJ9fX0=")))
                .setName("Intense").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.intense") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM0NmVlNzZmZDllOTQ3ZTM3ODlmYWMzNDgyMTZhYjk4YzI0MjEyNjhmYWZhZjNlYjI5ZWM5NDljMGI4MjE2OSJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Intense' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem laughCry1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY1ZWY4Y2M4YzY0NjFhN2M0NTIwM2IyNDlkMTMwZjA2NjA4NmE5YmI4MDMwN2VjYWVkYWU4MzU2ODAwY2VhNCJ9fX0=")))
                .setName("ROFL").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.rofl") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY1ZWY4Y2M4YzY0NjFhN2M0NTIwM2IyNDlkMTMwZjA2NjA4NmE5YmI4MDMwN2VjYWVkYWU4MzU2ODAwY2VhNCJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'ROFL' hat!"));

                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem colonP = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxNWM5YjhlZGM1NjI5YjZjYWE0OTE0OGEyMGM1ODkwODUzYzI2NzQzODVlNDM4NzZjYTU2ZDFkNDY1ZiJ9fX0=")))
                .setName(":P").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.colonP") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxNWM5YjhlZGM1NjI5YjZjYWE0OTE0OGEyMGM1ODkwODUzYzI2NzQzODVlNDM4NzZjYTU2ZDFkNDY1ZiJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the ':P' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem wow1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDE2ZjNkY2U5NzdkOGI3OTdlMWU0NzZmNWFiOTM2MTllZDJmMmIyMWE0OWFjOTM3NDMxNDBjZjY3YTA4OCJ9fX0=")))
                .setName("WOW!").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.emoji.wow") || player.hasPermission("hhub.cosmetics.hats.emoji.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDE2ZjNkY2U5NzdkOGI3OTdlMWU0NzZmNWFiOTM2MTllZDJmMmIyMWE0OWFjOTM3NDMxNDBjZjY3YTA4OCJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'WOW!' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        // Food GUI Items
        GuiItem fries1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTBlYWNhYzQxYTllYWYwNTEzNzZlZjJmOTU5NzAxZTFiYmUxYmY0YWE2NzE1YWRjMzRiNmRjMjlhMTNlYTkifX19")))
                .setName("Fries").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.food.fries") || player.hasPermission("hhub.cosmetics.hats.food.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTBlYWNhYzQxYTllYWYwNTEzNzZlZjJmOTU5NzAxZTFiYmUxYmY0YWE2NzE1YWRjMzRiNmRjMjlhMTNlYTkifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Fries' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem pumpkin1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmVjNDE1ZDcwMmYzMjkyYTgyZjE0NzFjODc5NGNmNjMxMjJkNDQ5ZDI4YWI4ODZkNGRjNThmYWZkNjYifX19")))
                .setName("Pumpkin").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.food.pumpkin") || player.hasPermission("hhub.cosmetics.hats.food.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmVjNDE1ZDcwMmYzMjkyYTgyZjE0NzFjODc5NGNmNjMxMjJkNDQ5ZDI4YWI4ODZkNGRjNThmYWZkNjYifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Pumpkin' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem burger1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZlZjFjMjVmNTE2ZjJlN2Q2Zjc2Njc0MjBlMzNhZGNmM2NkZjkzOGNiMzdmOWE0MWE4YjM1ODY5ZjU2OWIifX19")))
                .setName("Burger").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.food.burger") || player.hasPermission("hhub.cosmetics.hats.food.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZlZjFjMjVmNTE2ZjJlN2Q2Zjc2Njc0MjBlMzNhZGNmM2NkZjkzOGNiMzdmOWE0MWE4YjM1ODY5ZjU2OWIifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Burger' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem sushi1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTA0MDUxODFkMzllNzYxOTdhMjYyYmU0Y2M2NTQxZThlM2VkMjQ2MzMzODRjODczYWRiOTFkZmUzOTAxYyJ9fX0=")))
                .setName("Sushi").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.food.sushi") || player.hasPermission("hhub.cosmetics.hats.food.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTA0MDUxODFkMzllNzYxOTdhMjYyYmU0Y2M2NTQxZThlM2VkMjQ2MzMzODRjODczYWRiOTFkZmUzOTAxYyJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Sushi' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem strawbJam1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzBiOGI1ODg5ZWUxYzYzODhkYzZjMmM1ZGJkNzBiNjk4NGFlZmU1NDMxOWEwOTVlNjRkYjc2MzgwOTdiODIxIn19fQ==")))
                .setName("Strawberry Jam").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.food.jamStraw") || player.hasPermission("hhub.cosmetics.hats.food.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzBiOGI1ODg5ZWUxYzYzODhkYzZjMmM1ZGJkNzBiNjk4NGFlZmU1NDMxOWEwOTVlNjRkYjc2MzgwOTdiODIxIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Strawberry Jam' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem pizzaHat1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQyMGMyMTJkZmMzNGJkNDEyODQzZjJlYTk3YWYyZTgyNDhjNzE2MzE0MGE1ZDY2MjE5MTczNDkwYWQ2NmE5In19fQ==")))
                .setName("Pizza Hat").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.food.pizzaHat") || player.hasPermission("hhub.cosmetics.hats.food.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQyMGMyMTJkZmMzNGJkNDEyODQzZjJlYTk3YWYyZTgyNDhjNzE2MzE0MGE1ZDY2MjE5MTczNDkwYWQ2NmE5In19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Pizza Hat' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem melon1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODlmYzljNWI4NzM2ZjM2ZjM0MDVjYmUxMzYzZDQzNGMxNDFjZDIzYWFjMDQxODY0NzZhZjBhMGY3ODc3YWVmNCJ9fX0=")))
                .setName("Melon Head").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.food.melonHead") || player.hasPermission("hhub.cosmetics.hats.food.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODlmYzljNWI4NzM2ZjM2ZjM0MDVjYmUxMzYzZDQzNGMxNDFjZDIzYWFjMDQxODY0NzZhZjBhMGY3ODc3YWVmNCJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Melon Head' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem cake1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFkNjg0ZjY3NTEwODBkNDRhNjk5OWE4ZDMzOTRjMGIxYWJmN2QzZTUzOTFkMjFhYTYyZDQ4MWE1YjhjZTg3MyJ9fX0=")))
                .setName("Cake").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.food.cake") || player.hasPermission("hhub.cosmetics.hats.food.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFkNjg0ZjY3NTEwODBkNDRhNjk5OWE4ZDMzOTRjMGIxYWJmN2QzZTUzOTFkMjFhYTYyZDQ4MWE1YjhjZTg3MyJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Cake' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem pizzaHat2 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2IwZGI2MTNlNmMxYzQ3M2U5MTEyZGM2YjI1N2NkZWU5YzcxNzcwM2QzMjIyZjY1YTgwYjNiYzkxNDI3Y2UyZSJ9fX0=")))
                .setName("Pizza Hat 2").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.food.pizzaHat2") || player.hasPermission("hhub.cosmetics.hats.food.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2IwZGI2MTNlNmMxYzQ3M2U5MTEyZGM2YjI1N2NkZWU5YzcxNzcwM2QzMjIyZjY1YTgwYjNiYzkxNDI3Y2UyZSJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Pizza Hat 2' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        // Character GUI Items
        GuiItem link1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFhMDU5NjZkYmIzOWY3ODBlN2VhNjNhMjk1NjBkOGViNDhlMGMyNDk3YTgxOGE4OTU2NGE1YTE0YTMzZWYifX19")))
                .setName("Link").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.link") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFhMDU5NjZkYmIzOWY3ODBlN2VhNjNhMjk1NjBkOGViNDhlMGMyNDk3YTgxOGE4OTU2NGE1YTE0YTMzZWYifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Link' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem finnTheHuman = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjUxZDU5NjZlYTQ3MmM0M2VmNTJhNWY2NTdmZjg1OTIwM2JlYTI4ZmU0YmVkY2U1YTFjZDc4OWIzYWM0YmEifX19")))
                .setName("Finn the Human").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.finnTheHuman") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjUxZDU5NjZlYTQ3MmM0M2VmNTJhNWY2NTdmZjg1OTIwM2JlYTI4ZmU0YmVkY2U1YTFjZDc4OWIzYWM0YmEifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected 'Finn the Human' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem jakeTheDog = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTNkMTg3N2JlOTVhOWVkYjg2ZGYyMjU2ZjIzOTU4MzI0YzJlYzE5ZWY5NDI3N2NlMmZiNWMzMzAxODQxZGMifX19")))
                .setName("Jake the Dog").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.jakeTheDog") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTNkMTg3N2JlOTVhOWVkYjg2ZGYyMjU2ZjIzOTU4MzI0YzJlYzE5ZWY5NDI3N2NlMmZiNWMzMzAxODQxZGMifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected 'Jake the Dog' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem ashKetchum = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGMyMzU4NmY1MWZjOThiNTU0NTBiYjlhMzdhMDY2Y2FhYzI3NjVjMWQ0NzFjYjg5MTA5NGE4ZWMwMzJiZWZiIn19fQ==")))
                .setName("Ash Ketchum").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.ashKetchum") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGMyMzU4NmY1MWZjOThiNTU0NTBiYjlhMzdhMDY2Y2FhYzI3NjVjMWQ0NzFjYjg5MTA5NGE4ZWMwMzJiZWZiIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Ash Ketchum' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem warrio1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2E4YjNhMWFmMmQ4ZmMzNzcyOWY2ZjYzZmRiYTVkNWUyMDk3NThkZWQ0YjJmY2Y2YWRkNGI4NWJmNjdlZGQ3MiJ9fX0=")))
                .setName("Warrio").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.warrio") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2E4YjNhMWFmMmQ4ZmMzNzcyOWY2ZjYzZmRiYTVkNWUyMDk3NThkZWQ0YjJmY2Y2YWRkNGI4NWJmNjdlZGQ3MiJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Warrio' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem masterCheif = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjU0ODg0NGM0OGIwODJkZjU3Y2I0YWFkYzZiMjNhNGFmNDllM2JlMDI4ZjIxNmM2MmVmNTM5YWI4NGNjYmMwIn19fQ==")))
                .setName("Master Chief").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.masterCheif") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjU0ODg0NGM0OGIwODJkZjU3Y2I0YWFkYzZiMjNhNGFmNDllM2JlMDI4ZjIxNmM2MmVmNTM5YWI4NGNjYmMwIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Master Cheif' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem joker1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWY0ZjY4MjVlZjZkNWU0NmQ3OTQ2OTdkMWJmODZkMTQ0YmY2ZmIzZGE0ZTU1ZjdjZjU1MjcxZjYzN2VhYTcifX19")))
                .setName("The Joker").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.theJoker") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWY0ZjY4MjVlZjZkNWU0NmQ3OTQ2OTdkMWJmODZkMTQ0YmY2ZmIzZGE0ZTU1ZjdjZjU1MjcxZjYzN2VhYTcifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'The Joker' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem batMan1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjI1NmY3MTczNWVmNDU4NTgxYzlkYWNmMzk0MTg1ZWVkOWIzM2NiNmVjNWNkNTk0YTU3MTUzYThiNTY2NTYwIn19fQ==")))
                .setName("Bat-Man").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.batMan") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjI1NmY3MTczNWVmNDU4NTgxYzlkYWNmMzk0MTg1ZWVkOWIzM2NiNmVjNWNkNTk0YTU3MTUzYThiNTY2NTYwIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Bat-Man' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem deadpool1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGMxNWMzMTYzOWU5M2YyYmIyNzRjZjI5ZDI0NGE4YTI5MDZlODBhYjhiZDJjMDEyMWM3ZmQxZTI2MjRkNTMifX19")))
                .setName("Deadpool").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.deadpool") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGMxNWMzMTYzOWU5M2YyYmIyNzRjZjI5ZDI0NGE4YTI5MDZlODBhYjhiZDJjMDEyMWM3ZmQxZTI2MjRkNTMifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Deadpool' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem captainAmerica = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2VjNTI3NzEzZDM0YzExNjdlZWQwY2QxZTk2OWRiZmFkNWQ0NGE3NTIxNTRjY2FmNjRjMWM3YWI2YmMzZjNmIn19fQ==")))
                .setName("Captain America").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.captainAmerica") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2VjNTI3NzEzZDM0YzExNjdlZWQwY2QxZTk2OWRiZmFkNWQ0NGE3NTIxNTRjY2FmNjRjMWM3YWI2YmMzZjNmIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Captain America' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem goomba1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVjZjk0ZjRiY2JiZjZlYWRjYjI1YWEzZDA2OWFhNjc4ZWJkYjUyNDFlYjgyZThlMjY4ODljYWYzMjc1NTcwIn19fQ==")))
                .setName("Goomba").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.goomba") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVjZjk0ZjRiY2JiZjZlYWRjYjI1YWEzZDA2OWFhNjc4ZWJkYjUyNDFlYjgyZThlMjY4ODljYWYzMjc1NTcwIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Goomba' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem doge1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjlhZmIyZTVmMGI5NzdjNGM2ODNlMDE3ZDJiNDdmY2QxNDg4YWI1NjM5Nzc2NmU1YjM4MDQwNWExMzkyNjAifX19")))
                .setName("Doge").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.doge") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjlhZmIyZTVmMGI5NzdjNGM2ODNlMDE3ZDJiNDdmY2QxNDg4YWI1NjM5Nzc2NmU1YjM4MDQwNWExMzkyNjAifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Doge' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem bowser1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTg2MDYxMGVkMzA3ODVlNjIyOWU4MmUyODk3YjQyZmRhYmIxZGY2Mjk2ZDM3MzFmYWMyNzQ0ZTU2YTllYjkifX19")))
                .setName("Bowser").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.bowser") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTg2MDYxMGVkMzA3ODVlNjIyOWU4MmUyODk3YjQyZmRhYmIxZGY2Mjk2ZDM3MzFmYWMyNzQ0ZTU2YTllYjkifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Bowser' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem darthVader = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzFjM2UxZjIyNGI0NDZjY2FjNmE2Y2MzY2Q5ODkxMDE5YTEyMmY5OTY5MWMzOTA3OTkyYTNhZjk5YTIxYjAifX19")))
                .setName("Darth Vader").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.darthVador") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzFjM2UxZjIyNGI0NDZjY2FjNmE2Y2MzY2Q5ODkxMDE5YTEyMmY5OTY5MWMzOTA3OTkyYTNhZjk5YTIxYjAifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Darth Vader' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem stitch1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZhOGNiZTliNWI2NTYzNDVhZTAzNGJlZmVhZDI2YjkzNjc3ZmViYzg4NzI1NDkwNDE2Y2U3YmFiYmQ1OWYzZCJ9fX0=")))
                .setName("Stitch").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.stitch") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZhOGNiZTliNWI2NTYzNDVhZTAzNGJlZmVhZDI2YjkzNjc3ZmViYzg4NzI1NDkwNDE2Y2U3YmFiYmQ1OWYzZCJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Stitch' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem groot1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjNjNzFhODVlZWIzY2Q2NDQ5MTU5Njc1YWE4OTI3OGEyYTFkNTg3YjRkMGI3NjgxNzRmYzJlMTVjOWJlNGQifX19")))
                .setName("Groot").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.character.groot") || player.hasPermission("hhub.cosmetics.hats.character.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjNjNzFhODVlZWIzY2Q2NDQ5MTU5Njc1YWE4OTI3OGEyYTFkNTg3YjRkMGI3NjgxNzRmYzJlMTVjOWJlNGQifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Groot' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        // Items for the Mob GUI
        GuiItem enderMan1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E1OWJiMGE3YTMyOTY1YjNkOTBkOGVhZmE4OTlkMTgzNWY0MjQ1MDllYWRkNGU2YjcwOWFkYTUwYjljZiJ9fX0=")))
                .setName("Enderman").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.enderman") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E1OWJiMGE3YTMyOTY1YjNkOTBkOGVhZmE4OTlkMTgzNWY0MjQ1MDllYWRkNGU2YjcwOWFkYTUwYjljZiJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Enderman' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem slime1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZhZDIwZmMyZDU3OWJlMjUwZDNkYjY1OWM4MzJkYTJiNDc4YTczYTY5OGI3ZWExMGQxOGM5MTYyZTRkOWI1In19fQ==")))
                .setName("Slime").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.slime") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZhZDIwZmMyZDU3OWJlMjUwZDNkYjY1OWM4MzJkYTJiNDc4YTczYTY5OGI3ZWExMGQxOGM5MTYyZTRkOWI1In19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Slime' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem magmaCube1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzg5NTdkNTAyM2M5MzdjNGM0MWFhMjQxMmQ0MzQxMGJkYTIzY2Y3OWE5ZjZhYjM2Yjc2ZmVmMmQ3YzQyOSJ9fX0=")))
                .setName("Magma Cube").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.magmaCube") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzg5NTdkNTAyM2M5MzdjNGM0MWFhMjQxMmQ0MzQxMGJkYTIzY2Y3OWE5ZjZhYjM2Yjc2ZmVmMmQ3YzQyOSJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Magma Cube' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem spider1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q1NDE1NDFkYWFmZjUwODk2Y2QyNThiZGJkZDRjZjgwYzNiYTgxNjczNTcyNjA3OGJmZTM5MzkyN2U1N2YxIn19fQ==")))
                .setName("Spider").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.spider") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q1NDE1NDFkYWFmZjUwODk2Y2QyNThiZGJkZDRjZjgwYzNiYTgxNjczNTcyNjA3OGJmZTM5MzkyN2U1N2YxIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Spider' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem chicken1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTYzODQ2OWE1OTljZWVmNzIwNzUzNzYwMzI0OGE5YWIxMWZmNTkxZmQzNzhiZWE0NzM1YjM0NmE3ZmFlODkzIn19fQ==")))
                .setName("Chicken").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.chicken") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTYzODQ2OWE1OTljZWVmNzIwNzUzNzYwMzI0OGE5YWIxMWZmNTkxZmQzNzhiZWE0NzM1YjM0NmE3ZmFlODkzIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Chicken' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem pig1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIxNjY4ZWY3Y2I3OWRkOWMyMmNlM2QxZjNmNGNiNmUyNTU5ODkzYjZkZjRhNDY5NTE0ZTY2N2MxNmFhNCJ9fX0=")))
                .setName("Pig").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.pig") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIxNjY4ZWY3Y2I3OWRkOWMyMmNlM2QxZjNmNGNiNmUyNTU5ODkzYjZkZjRhNDY5NTE0ZTY2N2MxNmFhNCJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Pig' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem cow1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWQ2YzZlZGE5NDJmN2Y1ZjcxYzMxNjFjNzMwNmY0YWVkMzA3ZDgyODk1ZjlkMmIwN2FiNDUyNTcxOGVkYzUifX19")))
                .setName("Cow").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.cow") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWQ2YzZlZGE5NDJmN2Y1ZjcxYzMxNjFjNzMwNmY0YWVkMzA3ZDgyODk1ZjlkMmIwN2FiNDUyNTcxOGVkYzUifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Cow' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem squid1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDE0MzNiZTI0MjM2NmFmMTI2ZGE0MzRiODczNWRmMWViNWIzY2IyY2VkZTM5MTQ1OTc0ZTljNDgzNjA3YmFjIn19fQ==")))
                .setName("Squid").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.squid") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDE0MzNiZTI0MjM2NmFmMTI2ZGE0MzRiODczNWRmMWViNWIzY2IyY2VkZTM5MTQ1OTc0ZTljNDgzNjA3YmFjIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Squid' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem villager1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODIyZDhlNzUxYzhmMmZkNGM4OTQyYzQ0YmRiMmY1Y2E0ZDhhZThlNTc1ZWQzZWIzNGMxOGE4NmU5M2IifX19")))
                .setName("Villager").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.villager") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODIyZDhlNzUxYzhmMmZkNGM4OTQyYzQ0YmRiMmY1Y2E0ZDhhZThlNTc1ZWQzZWIzNGMxOGE4NmU5M2IifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Villager' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem ironGolem1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODkwOTFkNzllYTBmNTllZjdlZjk0ZDdiYmE2ZTVmMTdmMmY3ZDQ1NzJjNDRmOTBmNzZjNDgxOWE3MTQifX19")))
                .setName("Iron Golem").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.ironGolem") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODkwOTFkNzllYTBmNTllZjdlZjk0ZDdiYmE2ZTVmMTdmMmY3ZDQ1NzJjNDRmOTBmNzZjNDgxOWE3MTQifX19")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Iron Golem' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem mooShroom1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDBiYzYxYjk3NTdhN2I4M2UwM2NkMjUwN2EyMTU3OTEzYzJjZjAxNmU3YzA5NmE0ZDZjZjFmZTFiOGRiIn19fQ==")))
                .setName("Mooshroom").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.mooshroom") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDBiYzYxYjk3NTdhN2I4M2UwM2NkMjUwN2EyMTU3OTEzYzJjZjAxNmU3YzA5NmE0ZDZjZjFmZTFiOGRiIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Mooshroom' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem guardian1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTMyYzI0NTI0YzgyYWIzYjNlNTdjMjA1MmM1MzNmMTNkZDhjMGJlYjhiZGQwNjM2OWJiMjU1NGRhODZjMTIzIn19fQ==")))
                .setName("Guardian").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.guardian") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTMyYzI0NTI0YzgyYWIzYjNlNTdjMjA1MmM1MzNmMTNkZDhjMGJlYjhiZGQwNjM2OWJiMjU1NGRhODZjMTIzIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Guardian' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem penguin1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDNjNTdmYWNiYjNhNGRiN2ZkNTViNWMwZGM3ZDE5YzE5Y2IwODEzYzc0OGNjYzk3MTBjNzE0NzI3NTUxZjViOSJ9fX0=")))
                .setName("Penguin").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.penguin") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDNjNTdmYWNiYjNhNGRiN2ZkNTViNWMwZGM3ZDE5YzE5Y2IwODEzYzc0OGNjYzk3MTBjNzE0NzI3NTUxZjViOSJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Penguin' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem walrus1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdiYWVkYWY5YWQ5NTQ3NGViMWJlNTg5MjQ0NDVkZmM3N2JiZGMyNTJjYzFjODE2NDRjZjcxNTRjNDQxIn19fQ==")))
                .setName("Walrus").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.walrus") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdiYWVkYWY5YWQ5NTQ3NGViMWJlNTg5MjQ0NDVkZmM3N2JiZGMyNTJjYzFjODE2NDRjZjcxNTRjNDQxIn19fQ==")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Walrus' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem koala1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2EzNWViMTBiOTRlODg4NDI3ZmIyM2M3ODMwODI2NThjZWI4MWYzY2Y1ZDBhYWQyNWQ3ZDQxYTE5NGIyNiJ9fX0=")))
                .setName("Koala").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.koala") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2EzNWViMTBiOTRlODg4NDI3ZmIyM2M3ODMwODI2NThjZWI4MWYzY2Y1ZDBhYWQyNWQ3ZDQxYTE5NGIyNiJ9fX0=")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Koala' hat!"));
                    } else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });

        GuiItem turtle1 = ItemBuilder.from(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTJlNTQ4NDA4YWI3NWQ3ZGY4ZTZkNWQyNDQ2ZDkwYjZlYzYyYWE0ZjdmZWI3OTMwZDFlZTcxZWVmZGRmNjE4OSJ9fX0")))
                .setName("Turtle").asGuiItem(event -> {
                    event.setCancelled(true);
                    if(player.hasPermission("hhub.cosmetics.hats.mobs.turtle") || player.hasPermission("hhub.cosmetics.hats.mobs.unlockAllHats")) {
                        player.getInventory().setHelmet(new ItemStack(getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTJlNTQ4NDA4YWI3NWQ3ZGY4ZTZkNWQyNDQ2ZDkwYjZlYzYyYWE0ZjdmZWI3OTMwZDFlZTcxZWVmZGRmNjE4OSJ9fX0")));
                        player.sendMessage(format(pluginPrefix + "You have selected the 'Turtle' hat!"));
                    }else {
                        player.sendMessage(format(pluginPrefix + noHatPermission));
                    }
                });


        // Setting the main GUI's items
        hatsGui.setItem(2, 2, alphabetHats);
        hatsGui.setItem(2, 4, emoteHats);
        hatsGui.setItem(2, 6, foodHats);
        hatsGui.setItem(2, 8, characterHats);
        hatsGui.setItem(4, 3, mobHats);
        hatsGui.setItem(4, 5, colorHats);
        hatsGui.setItem(4, 7, blockHats);
        hatsGui.setItem(6, 1, backArrowCosmetics);

        // Setting Alphabet GUI items
        alphabetGui.setItem(1,1, woodA);
        alphabetGui.setItem(1,2, woodB);
        alphabetGui.setItem(1,3, woodC);
        alphabetGui.setItem(1,4, woodD);
        alphabetGui.setItem(1,5, woodE);
        alphabetGui.setItem(1,6, woodF);
        alphabetGui.setItem(1,7, woodG);
        alphabetGui.setItem(1,8, woodH);
        alphabetGui.setItem(1,9, woodI);
        alphabetGui.setItem(2,1, woodJ);
        alphabetGui.setItem(2,2, woodK);
        alphabetGui.setItem(2,3, woodL);
        alphabetGui.setItem(2,4, woodM);
        alphabetGui.setItem(2,5, woodN);
        alphabetGui.setItem(2,6, woodO);
        alphabetGui.setItem(2,7, woodP);
        alphabetGui.setItem(2,8, woodQ);
        alphabetGui.setItem(2,9, woodR);
        alphabetGui.setItem(3,1, woodS);
        alphabetGui.setItem(3,2, woodT);
        alphabetGui.setItem(3,3, woodU);
        alphabetGui.setItem(3,4, woodV);
        alphabetGui.setItem(3,5, woodW);
        alphabetGui.setItem(3,6, woodX);
        alphabetGui.setItem(3,7, woodY);
        alphabetGui.setItem(3,8, woodZ);

        alphabetGui.setItem(5,1, backArrow);
        alphabetGui.setItem(5, 2, blackFiller);
        alphabetGui.setItem(5, 3, blackFiller);
        alphabetGui.setItem(5, 4, blackFiller);
        alphabetGui.setItem(5,5, clearHat);
        alphabetGui.setItem(5, 6, blackFiller);
        alphabetGui.setItem(5, 7, blackFiller);
        alphabetGui.setItem(5, 8, blackFiller);
        alphabetGui.setItem(5, 9, blackFiller);

        // Setting Emoji Items In GUI
        emojiGui.setItem(1,1, smiley1);
        emojiGui.setItem(1,2, cool1);
        emojiGui.setItem(1,3, deceased1);
        emojiGui.setItem(1,4, derpy1);
        emojiGui.setItem(1,5, happy1);
        emojiGui.setItem(1,6, sleepy1);
        emojiGui.setItem(1,7, shocked1);
        emojiGui.setItem(1,8, crying1);
        emojiGui.setItem(1,9, intense1);
        emojiGui.setItem(2,1, laughCry1);
        emojiGui.setItem(2,2, colonP);
        emojiGui.setItem(2,3, wow1);

        emojiGui.setItem(4,1, backArrow);
        emojiGui.setItem(4, 2, blackFiller);
        emojiGui.setItem(4, 3, blackFiller);
        emojiGui.setItem(4, 4, blackFiller);
        emojiGui.setItem(4,5, clearHat);
        emojiGui.setItem(4, 6, blackFiller);
        emojiGui.setItem(4, 7, blackFiller);
        emojiGui.setItem(4, 8, blackFiller);
        emojiGui.setItem(4, 9, blackFiller);

        // Setting Food Items In GUI
        foodGui.setItem(1, 1, fries1);
        foodGui.setItem(1, 2, pumpkin1);
        foodGui.setItem(1, 3, burger1);
        foodGui.setItem(1, 4, sushi1);
        foodGui.setItem(1, 5, strawbJam1);
        foodGui.setItem(1, 6, pizzaHat1);
        foodGui.setItem(1, 7, melon1);
        foodGui.setItem(1, 8, cake1);
        foodGui.setItem(1, 9, pizzaHat2);

        foodGui.setItem(2,1, backArrow);
        foodGui.setItem(2, 2, blackFiller);
        foodGui.setItem(2, 3, blackFiller);
        foodGui.setItem(2, 4, blackFiller);
        foodGui.setItem(2,5, clearHat);
        foodGui.setItem(2, 6, blackFiller);
        foodGui.setItem(2, 7, blackFiller);
        foodGui.setItem(2, 8, blackFiller);
        foodGui.setItem(2, 9, blackFiller);

        // Setting Character Items In GUI
        characterGui.setItem(1,1, link1);
        characterGui.setItem(1,2, finnTheHuman);
        characterGui.setItem(1,3, jakeTheDog);
        characterGui.setItem(1,4, ashKetchum);
        characterGui.setItem(1,5, warrio1);
        characterGui.setItem(1,6, masterCheif);
        characterGui.setItem(1,7, joker1);
        characterGui.setItem(1,8, batMan1);
        characterGui.setItem(1,9, deadpool1);
        characterGui.setItem(2,1, captainAmerica);
        characterGui.setItem(2,2, goomba1);
        characterGui.setItem(2,3, doge1);
        characterGui.setItem(2,4, bowser1);
        characterGui.setItem(2,5, darthVader);
        characterGui.setItem(2,6, stitch1);
        characterGui.setItem(2,7, groot1);

        characterGui.setItem(4,1, backArrow);
        characterGui.setItem(4, 2, blackFiller);
        characterGui.setItem(4, 3, blackFiller);
        characterGui.setItem(4, 4, blackFiller);
        characterGui.setItem(4,5, clearHat);
        characterGui.setItem(4, 6, blackFiller);
        characterGui.setItem(4, 7, blackFiller);
        characterGui.setItem(4, 8, blackFiller);
        characterGui.setItem(4, 9, blackFiller);

        // Setting Mob Items In GUI
        mobGui.setItem(1,1, enderMan1);
        mobGui.setItem(1,2, slime1);
        mobGui.setItem(1,3, magmaCube1);
        mobGui.setItem(1,4, spider1);
        mobGui.setItem(1,5, chicken1);
        mobGui.setItem(1,6, pig1);
        mobGui.setItem(1,7, cow1);
        mobGui.setItem(1,8, squid1);
        mobGui.setItem(1,9, villager1);
        mobGui.setItem(2,1, ironGolem1);
        mobGui.setItem(2,2, mooShroom1);
        mobGui.setItem(2,3, guardian1);
        mobGui.setItem(2,4, penguin1);
        mobGui.setItem(2,5, walrus1);
        mobGui.setItem(2,6, koala1);
        mobGui.setItem(2,7, turtle1);

        mobGui.setItem(3,1, backArrow);
        mobGui.setItem(3, 2, blackFiller);
        mobGui.setItem(3, 3, blackFiller);
        mobGui.setItem(3, 4, blackFiller);
        mobGui.setItem(3,5, clearHat);
        mobGui.setItem(3, 6, blackFiller);
        mobGui.setItem(3, 7, blackFiller);
        mobGui.setItem(3, 8, blackFiller);
        mobGui.setItem(3, 9, blackFiller);


        if (cmd.getName().equalsIgnoreCase("hatsgui")) {

            if (sender.hasPermission("hhub.members.command.hatsGuiCommand")) {

                hatsGui.open(player);

            }
            else {
                player.sendMessage(format(pluginPrefix + noPermission));
            }
        }

        return true;
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}