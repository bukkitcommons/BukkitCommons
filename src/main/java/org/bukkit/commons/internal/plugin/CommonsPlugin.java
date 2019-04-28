package org.bukkit.commons.internal.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class CommonsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        @SuppressWarnings("unused")
        Metrics metrics = new Metrics(this, "Bukkit Commons");
    }
}
