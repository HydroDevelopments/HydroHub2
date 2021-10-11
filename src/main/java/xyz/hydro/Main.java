package xyz.hydro;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Score;
import xyz.hydro.commands.*;
import xyz.hydro.events.OnJoinEvents;
import xyz.hydro.events.OnRespawnEvent;
import xyz.hydro.features.BoostPads;
import xyz.hydro.features.Scoreboard;
import xyz.hydro.features.TabList;
import xyz.hydro.features.chat.PlayerJoinMessage;
import xyz.hydro.gui.cosmetics.CosmeticsGui;
import xyz.hydro.gui.cosmetics.TrailsGui;
import xyz.hydro.gui.serverselector.ServerSelectorGUI;
import xyz.hydro.particles.events.OnQuit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public final class Main extends JavaPlugin implements Listener {

    public Permission permission;

    public TabList tab;

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

        // Chat Permission
        this.permission = new Permission("hhub.joinMessages.defaultMessagePermission");

        this.permission = new Permission("hhub.joinMessages.rankOneMessagePermission");
        this.permission = new Permission("hhub.joinMessages.rankTwoMessagePermission");
        this.permission = new Permission("hhub.joinMessages.rankThreeMessagePermission");
        this.permission = new Permission("hhub.joinMessages.rankFourMessagePermission");
        this.permission = new Permission("hhub.joinMessages.rankFiveMessagePermission");

        this.permission = new Permission("hhub.joinMessages.adminJoinMessage");
        this.permission = new Permission("hhub.joinMessages.opJoinMessage");

    }

    @Override
    public void onEnable() {
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

        // TABList things
        this.tab = new TabList(this);
        List<String> tabListHeader = getMessagesConfig().getStringList("tabListHeader.lines");
        List<String> tabListFooter = getMessagesConfig().getStringList("tabListFooter.lines");

        try {
            for (String title : tabListHeader) {
                tab.addHeader(title);
            }

            for (String foot : tabListFooter) {
                tab.addFooter(foot);
            }

            tab.showTab();
        } catch(Exception e) {
            e.printStackTrace();
            getLogger().warning("Something went wrong when initializing the TABList.");
        }


        // Permissions
        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.addPermission(this.permission);

        // Registering the MAIN Commands
        Objects.requireNonNull(getCommand("hydroreload")).setExecutor((new ReloadCommand(this)));
        Objects.requireNonNull(getCommand("hydrohub")).setExecutor((new HydroHubCommand(this)));
        Objects.requireNonNull(getCommand("help")).setExecutor((new CustomHelpCommand(this)));

        // Registering Plugin Commands
        Objects.requireNonNull(getCommand("setspawn")).setExecutor((new SetSpawnCommand(this)));
        Objects.requireNonNull(getCommand("spawn")).setExecutor((new SpawnCommand(this)));
        Objects.requireNonNull(getCommand("serverselector")).setExecutor((new ServerSelectorGUI(this)));
        Objects.requireNonNull(getCommand("trails")).setExecutor((new TrailsGui(this)));
        Objects.requireNonNull(getCommand("cosmetics")).setExecutor((new CosmeticsGui(this)));

        // Event Registering Goes Here!
        pluginManager.registerEvents(new OnRespawnEvent(this), this);
        pluginManager.registerEvents(new OnJoinEvents(this), this);
        pluginManager.registerEvents(new BoostPads(this), this);
        pluginManager.registerEvents(new PlayerJoinMessage(this), this);
        pluginManager.registerEvents(new OnQuit(), this);
        pluginManager.registerEvents(new Scoreboard(this), this);
        pluginManager.registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // Disables default join messages
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoinEvent1(final PlayerJoinEvent event) throws Exception {
        if (getConfig().getBoolean("disableDefaultJoinMessages")) {
            event.setJoinMessage("");
        }
    }

    // Disables default leave messages.
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerQuitEvent2(final PlayerQuitEvent event) throws Exception {
        if (getConfig().getBoolean("disableDefaultJoinMessages")) {
            event.setQuitMessage("");
        }
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
