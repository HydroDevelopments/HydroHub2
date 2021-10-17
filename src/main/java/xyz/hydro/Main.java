package xyz.hydro;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.hydro.commands.*;
import xyz.hydro.events.OnJoinEvents;
import xyz.hydro.events.OnRespawnEvent;
import xyz.hydro.events.clickEvents.HubItemsClickEvents;
import xyz.hydro.features.BoostPads;
import xyz.hydro.features.Scoreboard;
import xyz.hydro.features.TabList;
import xyz.hydro.features.WelcomeScreen;
import xyz.hydro.features.chat.PlayerJoinMessage;
import xyz.hydro.features.hubItems.ItemsOnJoin;
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

    private File serverConfigFile;
    private FileConfiguration serverConfig;

    public static String pluginContributors;

    public static String noPermission;

    public Main() {

        pluginVersion = 1.0;

        pluginContributors = "HydroDevelopments";

        noPermission = format("&cYou do not have permissions to use this command!");

        // Admin Permissions
        this.permission = new Permission("hhub.admin.mainCommand");
        this.permission = new Permission("hhub.admin.command.reloadExecution");
        this.permission = new Permission("hhub.admin.command.setWorldSpawn");
        this.permission = new Permission("hhub.admin.commands.boostPadsCommand");
        this.permission = new Permission("hhub.admin.commands.smallCommands");

        // Member Permissions
        this.permission = new Permission("hhub.member.boostPads.use");
        this.permission = new Permission("hhub.member.command.spawnCommand");
        this.permission = new Permission("hhub.member.command.helpCommand");
        this.permission = new Permission("hhub.members.command.cosmeticsCommand");
        this.permission = new Permission("hhub.members.command.trailsCommand");
        this.permission = new Permission("hhub.members.command.serverSelectorCommand");

        // Chat Permission
        this.permission = new Permission("hhub.joinMessages.defaultMessagePermission");

        this.permission = new Permission("hhub.joinMessages.rankOneMessagePermission");
        this.permission = new Permission("hhub.joinMessages.rankTwoMessagePermission");
        this.permission = new Permission("hhub.joinMessages.rankThreeMessagePermission");
        this.permission = new Permission("hhub.joinMessages.rankFourMessagePermission");
        this.permission = new Permission("hhub.joinMessages.rankFiveMessagePermission");

        this.permission = new Permission("hhub.joinMessages.adminJoinMessage");
        this.permission = new Permission("hhub.joinMessages.opJoinMessage");

        // Cosmetic Permisisons
        this.permission = new Permission("hhub.cosmetics.particles.crossLoop");
        this.permission = new Permission("hhub.cosmetics.particles.hotHead");
        this.permission = new Permission("hhub.cosmetics.particles.halo");
        this.permission = new Permission("hhub.cosmetics.particles.milkRain");
        this.permission = new Permission("hhub.cosmetics.particles.antiHalo");

        // Items Permissions
        this.permission = new Permission("hhub.items.hubItemsClick");
        this.permission = new Permission("hhub.admin.items.bypass");

    }

    @Override
    public void onEnable() {
        Player player;

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

        pluginPrefix = this.getMessagesConfig().getString("pluginPrefix");

        this.createLocationsConfig();
        this.reloadLocationsConfig();
        this.saveLocationConfig();
        getLocationsConfig().options().copyDefaults();
        saveLocationConfig();

        this.createServerConfig();
        this.reloadServerConfig();
        this.saveServerConfig();
        getServerConfig().options().copyDefaults();
        saveServerConfig();

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
        } catch(NullPointerException e) {
            e.printStackTrace();
            getLogger().warning("Something went wrong when initializing the TABList.");
        }

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");


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

        // Gamemode Commands
        Objects.requireNonNull(getCommand("gm")).setExecutor((new ShortCommands(this)));
        Objects.requireNonNull(getCommand("gmc")).setExecutor((new ShortCommands(this)));
        Objects.requireNonNull(getCommand("gms")).setExecutor((new ShortCommands(this)));
        Objects.requireNonNull(getCommand("gma")).setExecutor((new ShortCommands(this)));
        Objects.requireNonNull(getCommand("gm3")).setExecutor((new ShortCommands(this)));
        Objects.requireNonNull(getCommand("gmsp")).setExecutor((new ShortCommands(this)));

        // Event Registering Goes Here!
        pluginManager.registerEvents(new OnRespawnEvent(this), this);
        pluginManager.registerEvents(new OnJoinEvents(this), this);
        pluginManager.registerEvents(new BoostPads(this), this);
        pluginManager.registerEvents(new PlayerJoinMessage(this), this);
        pluginManager.registerEvents(new OnQuit(), this);
        pluginManager.registerEvents(new Scoreboard(this), this);
        pluginManager.registerEvents(new WelcomeScreen(this), this);
        pluginManager.registerEvents(new ItemsOnJoin(this), this);
        pluginManager.registerEvents(new HubItemsClickEvents(this), this);
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


    // serverselector.yml File Creation.
    public FileConfiguration getServerConfig() {
        return this.serverConfig;
    }

    public void saveServerConfig() {
        if(this.serverConfig == null) {
            return;
        }

        try {
            this.getServerConfig().save(this.serverConfigFile);
        } catch(IOException e) {
            // Being naughty and not logging :o
        }
    }

    public void reloadServerConfig() {
        if (this.serverConfig == null) {
            createServerConfig();
        }
        this.serverConfig = YamlConfiguration.loadConfiguration(this.serverConfigFile);

        InputStream defaultStream = this.getResource("serverSelector.yml");
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.serverConfig.setDefaults(defaultConfig);
        }
    }

    private void createServerConfig() {
        serverConfigFile = new File(getDataFolder(), "serverSelector.yml");
        if (!serverConfigFile.exists()) {
            serverConfigFile.getParentFile().mkdirs();
            saveResource("serverSelector.yml", true);
        }

        serverConfig = new YamlConfiguration();
        try {
            serverConfig.load(serverConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
