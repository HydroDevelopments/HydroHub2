package xyz.hydro.features;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;
import xyz.hydro.Main;

import java.util.Objects;

public class Scoreboard implements Listener {
    private Main plugin;
    public Scoreboard(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void joinServer(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // String + PAPI Intergration!
        String title = format(plugin.getConfig().getString("scoreboardTitle"));
        title = PlaceholderAPI.setPlaceholders(player, title);

        String input1 = format(plugin.getConfig().getString("scoreboardLineOne"));
        input1 = PlaceholderAPI.setPlaceholders(player, input1);

        String input2 = format(plugin.getConfig().getString("scoreboardLineTwo"));
        input2 = PlaceholderAPI.setPlaceholders(player, input2);

        String input3 = format(plugin.getConfig().getString("scoreboardLineThree"));
        input3 = PlaceholderAPI.setPlaceholders(player, input3);

        String input4 = format(plugin.getConfig().getString("scoreboardLineFour"));
        input4 = PlaceholderAPI.setPlaceholders(player, input4);

        String input5 = format(plugin.getConfig().getString("scoreboardLineFive"));
        input5 = PlaceholderAPI.setPlaceholders(player, input5);

        String web1 = format(plugin.getConfig().getString("scoreboardWeb"));
        web1 = PlaceholderAPI.setPlaceholders(player, web1);


        ScoreboardManager scoreboardManager = plugin.getServer().getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("Test", "Dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score1 = objective.getScore(input1);
        score1.setScore(6);

        Score score2 = objective.getScore(input2);
        score2.setScore(5);

        Score score3 = objective.getScore(input3);
        score3.setScore(4);

        Score score4 = objective.getScore(input4);
        score4.setScore(3);

        Score score5 = objective.getScore(input5);
        score5.setScore(2);

        Score score6 = objective.getScore(web1);
        score6.setScore(1);

        String title1 = format(plugin.getConfig().getString("scoreboardTitle"));
        char[] split = Objects.requireNonNull(title).toCharArray();


        // Scoreboard Animation
        new BukkitRunnable() {
            int counter = 0;
            String finaltitle = "";

            @Override
            public void run() {
                if (counter < split.length) {
                    String letter = String.valueOf(split[counter]);
                    counter += 1;
                    String space = "";
                    for (int i = 0; i < split.length - counter; i++) {
                        space += " ";
                    }

                    finaltitle +=   letter;
                    objective.setDisplayName(finaltitle);
                }else{
                    String space = "";
                    finaltitle = "";
                    for (int i = 0; i < split.length - counter; i++) {
                        space += " ";
                    }
                    objective.setDisplayName(space);
                    counter = 0;
                }
            }
        }.runTaskAsynchronously(plugin);

        player.setScoreboard(scoreboard);
    }

    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
