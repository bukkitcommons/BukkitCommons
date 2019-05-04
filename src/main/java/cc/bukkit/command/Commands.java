package cc.bukkit.command;

import java.lang.reflect.Field;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.Plugin;

import cc.bukkit.plugin.CommonsPlugin;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class Commands {
    /**
     * 
     * @param label
     * @param executor
     */
    public static void registerCommand(String label, Command executor) {
        registerCommand(CommonsPlugin.getInstance(), label, executor);
    }
    
    /**
     * 
     * @param plugin
     * @param label
     * @param executor
     */
    public static void registerCommand(Plugin plugin, String label, Command executor) {
        registerCommand(plugin.getName().toLowerCase(Locale.ENGLISH), label, executor);
    }
    
    /**
     * 
     * @param prefix
     * @param label
     * @param executor
     */
    @SneakyThrows
    public static void registerCommand(String prefix, String label, Command executor) {
        Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
        commandMapField.setAccessible(true);
        
        ((CommandMap) commandMapField.get(Bukkit.getServer())).register(prefix, label, executor);
    }
}
