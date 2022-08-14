package de.lupu.bs;

import com.onarandombox.MultiverseCore.MultiverseCore;
import de.lupu.bs.commands.BuildCmd;
import de.lupu.bs.events.ChatEvent;
import de.lupu.bs.events.ClickEvent;
import de.lupu.bs.events.InteractEvent;
import de.lupu.bs.events.PlayerHandler;
import de.lupu.bs.utils.FileManager;
import de.lupu.bs.utils.InventoryManager;
import de.lupu.bs.utils.ScoreboardManager;
import de.lupu.bs.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BauSystem extends JavaPlugin {

    private static BauSystem plugin;
    private static Util util;
    private static FileManager fileManager;
    private static InventoryManager inventoryManager;
    private static ScoreboardManager scoreboardManager;
    private static MultiverseCore core;

    @Override
    public void onEnable() {

        plugin = this;
        util = new Util();
        fileManager = new FileManager();
        inventoryManager = new InventoryManager();
        scoreboardManager = new ScoreboardManager();
        core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");

        getCommand("build").setExecutor(new BuildCmd());
        getCommand("edit").setExecutor(new BuildCmd());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ChatEvent(), this);
        pm.registerEvents(new ClickEvent(), this);
        pm.registerEvents(new InteractEvent(), this);
        pm.registerEvents(new PlayerHandler(), this);

    }

    @Override
    public void onDisable() {

    }

    public static BauSystem getPlugin() {
        return plugin;
    }

    public static FileManager getFileManager() {
        return fileManager;
    }

    public static InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public static ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public static Util getUtil() {
        return util;
    }

    public static MultiverseCore getCore() {
        return core;
    }
}
