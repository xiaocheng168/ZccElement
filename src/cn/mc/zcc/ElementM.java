package cn.mc.zcc;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ElementM extends JavaPlugin {
    public static ElementM plugin;

    @Override
    public void onLoad() {
        plugin = this;
        saveDefaultConfig();
    }

    public static ElementM getInstance() {
        return plugin;
    }
}
