package xyz.hydro;

import org.bukkit.ChatColor;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.hydro.commands.HydroHubCommand;
import xyz.hydro.commands.ReloadCommand;
import xyz.hydro.commands.SetSpawnCommand;
import xyz.hydro.commands.SpawnCommand;
import xyz.hydro.events.OnJoinEvents;
import xyz.hydro.events.OnRespawnEvent;

import java.util.Objects;

public final class Main extends JavaPlugin {

    public Permission permission;

    public static double pluginVersion;

    public static String pluginPrefix;

    public static String pluginContributors;

    public static String noPermission;

    public Main() {

        pluginPrefix = format("&c[HydroHub] &r");

        pluginVersion = 1.0;

        pluginContributors = "jiggey, Rismose";

        noPermission = format("&cYou do not have permissions to use this command!");

        // Admin Permissions
        this.permission = new Permission("hhub.admin.mainCommand");

    }

    @Override
    public void onEnable() {
        // Permissions
        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.addPermission(this.permission);

        // Registering the Commands
        Objects.requireNonNull(getCommand("hydroreload")).setExecutor((new ReloadCommand(this)));
        Objects.requireNonNull(getCommand("hydrohub")).setExecutor((new HydroHubCommand(this)));
        Objects.requireNonNull(getCommand("setspawn")).setExecutor((new SetSpawnCommand(this)));
        Objects.requireNonNull(getCommand("spawn")).setExecutor((new SpawnCommand(this)));

        // Event Registering Goes Here!
        pluginManager.registerEvents(new OnRespawnEvent(this), this);
        pluginManager.registerEvents(new OnJoinEvents(this), this);


        // Config Things.
        this.saveDefaultConfig();
        this.reloadConfig();
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
