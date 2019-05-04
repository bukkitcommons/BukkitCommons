package cc.bukkit.misc;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;

import cc.bukkit.plugin.CommonsPlugin;

public final class CommonTicker implements Runnable {
    private int currentTick;
    
    public int currentTick() {
        return currentTick;
    }
    
    @Override
    public void run() {
        ++currentTick;
    }
    
    // ------------------------------
    // Singleton
    // ------------------------------
    
    private static class Singleton {
        private final static CommonTicker INSTANCE;
        
        static {
            Bukkit.getScheduler().runTaskTimer(CommonsPlugin.getInstance(), (INSTANCE = new CommonTicker()), 0, 0);
        }
    }
    
    public static CommonTicker getInstance() {
        return Singleton.INSTANCE;
    }
    
    public static long toTicks(TimeUnit unit, long duration) {
        return unit.toSeconds(duration) * 20;
    }
}
