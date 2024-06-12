package hu.serwenyi.mentorud;

import hu.serwenyi.mentorud.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SerwSaveRod extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("SerwenyiSaveRod plugin has been enabled!");
        getCommand("mentorud").setExecutor(new SaveRodCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("SerwenyiSaveRod plugin has been disabled!");
    }
}
