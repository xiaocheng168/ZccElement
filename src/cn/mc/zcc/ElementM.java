package cn.mc.zcc;

import cn.mc.zcc.listener.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ElementM extends JavaPlugin {
    public static ElementM plugin;
    public static File dataDir;

    @Override
    public void onLoad() {
        plugin = this;
        dataDir = new File(this.getDataFolder(), "playerData");
        if (!dataDir.isDirectory()) {
            if (dataDir.mkdirs()) {
                getLogger().info(dataDir.getAbsolutePath() + " 目录已初始化成功");
            }
        }
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
    }

    public static ElementM getInstance() {
        return plugin;
    }
}
