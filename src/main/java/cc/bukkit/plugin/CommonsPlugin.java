package cc.bukkit.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import cc.bukkit.collection.AutoCloses;

public class CommonsPlugin extends JavaPlugin {
    private static CommonsPlugin instance;
    
    public CommonsPlugin() {
        instance = this;
    }
    
    /**
     * 
     * @return
     */
    public static CommonsPlugin getInstance() {
        return instance;
    }
    
    @Override
    public void onEnable() {
        @SuppressWarnings("unused")
        Metrics metrics = new Metrics(this, "Bukkit Commons");
        
        // Registry
        Bukkit.getPluginManager().registerEvents(AutoCloses.getInstance(), this);
    }
}
