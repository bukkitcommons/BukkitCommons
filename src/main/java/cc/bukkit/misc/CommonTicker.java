package cc.bukkit.misc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
    
    // ------------------------------
    // Helper
    // ------------------------------
    
    public static long toTicks(TimeUnit unit, long duration) {
        return unit.toSeconds(duration) * 20;
    }
    
	private static Object serverInstance;
    private static Field tpsField;
    
    /**
	 * Get MinecraftServer's TPS
	 * @return double TPS (e.g 19.92)
	 */
	public static Double getTPS() {
	    try {
            serverInstance = getNMSClass("MinecraftServer").getMethod("getServer").invoke(null);
            tpsField = serverInstance.getClass().getField("recentTps");
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
	    try {
            double[] tps = ((double[]) tpsField.get(serverInstance));
            return tps[0];
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
	    
	}
	
    public static Class<?> getNMSClass(String className) {
    	String name = Bukkit.getServer().getClass().getPackage().getName();
	    String version = name.substring(name.lastIndexOf('.') + 1);
        try {
            return Class.forName("net.minecraft.server." + version + "." + className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
