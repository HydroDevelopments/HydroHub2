package xyz.hydro;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.hydro.commands.*;
import xyz.hydro.events.OnJoinEvents;
import xyz.hydro.events.OnRespawnEvent;
import xyz.hydro.features.BoostPads;
import xyz.hydro.gui.BoostPadsGUI;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public final class Main extends JavaPlugin {

    public Permission permission;

    public static double pluginVersion;

    public static String pluginPrefix;

    private File messagesConfigFile;
    private FileConfiguration messagesConfig;

    private File locationsConfigFile;
    private FileConfiguration locationsConfig;

    public static String pluginContributors;

    public static String noPermission;

    public Main() {

        pluginPrefix = format("&c[HydroHub] &r");

        pluginVersion = 1.0;

        pluginContributors = "jiggey, Rismose";

        noPermission = format("&cYou do not have permissions to use this command!");

        // Admin Permissions
        this.permission = new Permission("hhub.admin.mainCommand");
        this.permission = new Permission("hhub.admin.command.reloadExecution");
        this.permission = new Permission("hhub.admin.command.setWorldSpawn");
        this.permission = new Permission("hhub.admin.commands.boostPadsCommand");

        // Member Permissions
        this.permission = new Permission("hhub.member.boostPads.use");
        this.permission = new Permission("hhub.member.command.spawnCommand");

    }

    @Override
    public void onEnable() {
        // Permissions
        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.addPermission(this.permission);

        // Registering the MAIN Commands
        Objects.requireNonNull(getCommand("hydroreload")).setExecutor((new ReloadCommand(this)));
        Objects.requireNonNull(getCommand("hydrohub")).setExecutor((new HydroHubCommand(this)));
        Objects.requireNonNull(getCommand("help")).setExecutor((new CustomHelpCommand(this)));

        // Registering Plugin Commands
        Objects.requireNonNull(getCommand("boostpads")).setExecutor((new BoostPadsGUI(this)));
        Objects.requireNonNull(getCommand("setspawn")).setExecutor((new SetSpawnCommand(this)));
        Objects.requireNonNull(getCommand("spawn")).setExecutor((new SpawnCommand(this)));

        // Event Registering Goes Here!
        pluginManager.registerEvents(new OnRespawnEvent(this), this);
        pluginManager.registerEvents(new OnJoinEvents(this), this);
        pluginManager.registerEvents(new BoostPads(this), this);
        pluginManager.registerEvents(new BoostPadsGUI(this), this);


        // Config Things.
        this.saveDefaultConfig();
        this.reloadConfig();
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        this.createMessagesConfig();
        this.reloadMessagesConfig();
        this.saveMessagesConfig();
        getMessagesConfig().options().copyDefaults();
        saveMessagesConfig();

        this.createLocationsConfig();
        this.reloadLocationsConfig();
        this.saveLocationConfig();
        getLocationsConfig().options().copyDefaults();
        saveLocationConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    // Messages.yml File Creation.
    public FileConfiguration getMessagesConfig() {
        return this.messagesConfig;
    }

    public void saveMessagesConfig() {
        if(this.messagesConfig == null) {
            return;
        }

        try {
            this.getMessagesConfig().save(this.messagesConfigFile);
        } catch(IOException e) {
            // Being naughty and not logging :o
        }
    }

    public void reloadMessagesConfig() {
        if (this.messagesConfig == null) {
            createMessagesConfig();
        }
        this.messagesConfig = YamlConfiguration.loadConfiguration(this.messagesConfigFile);

        InputStream defaultStream = this.getResource("messages.yml");
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.messagesConfig.setDefaults(defaultConfig);
        }
    }

    private void createMessagesConfig() {
        messagesConfigFile = new File(getDataFolder(), "messages.yml");
        if (!messagesConfigFile.exists()) {
            messagesConfigFile.getParentFile().mkdirs();
            saveResource("messages.yml", true);
        }

        messagesConfig = new YamlConfiguration();
        try {
            messagesConfig.load(messagesConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


    // Locations.yml File Creation.
    public FileConfiguration getLocationsConfig() {
        return this.locationsConfig;
    }

    public void saveLocationConfig() {
        if(this.locationsConfig == null) {
            return;
        }

        try {
            this.getLocationsConfig().save(this.locationsConfigFile);
        } catch(IOException e) {
            // Being naughty and not logging :o
        }
    }

    public void reloadLocationsConfig() {
        if (this.locationsConfig == null) {
            createLocationsConfig();
        }
        this.locationsConfig = YamlConfiguration.loadConfiguration(this.locationsConfigFile);

        InputStream defaultStream = this.getResource("locations.yml");
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.locationsConfig.setDefaults(defaultConfig);
        }
    }

    private void createLocationsConfig() {
        locationsConfigFile = new File(getDataFolder(), "locations.yml");
        if (!locationsConfigFile.exists()) {
            locationsConfigFile.getParentFile().mkdirs();
            saveResource("locations.yml", true);
        }

        locationsConfig = new YamlConfiguration();
        try {
            locationsConfig.load(locationsConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
