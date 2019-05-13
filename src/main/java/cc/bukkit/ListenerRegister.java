package cc.bukkit;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenerRegister {
	/**
     * Fast register multi-listener.
     * @param plugin The plugin main class
     * @param listeners The listeners you want register
     * @return
     */
	public static void registerListeners(JavaPlugin plugin, Listener... listeners) {
		for (Listener listenerClass : listeners) {
			Bukkit.getPluginManager().registerEvents(listenerClass,plugin);
		}
	}
	/**
     * Fast un-register multi-listener.
     * @param plugin The plugin main class
     * @param listeners The listeners you want unregister
     * @return
     */
	public static void unregisterListeners(JavaPlugin plugin, Listener...listeners) {
		ArrayList<RegisteredListener> registeredListeners = HandlerList.getRegisteredListeners(plugin);
		for (Listener listenerArg : listeners) {
			for (RegisteredListener registeredListener : registeredListeners) {
				if(listenerArg.equals(registeredListener.getListener())) //We must check it if you didn't want other plugin unregister another plugin's listener
					HandlerList.unregisterAll(listenerArg);
			}
		}
	}
	/**
     * Fast un-register multi-listener.
     * @param plugin The plugin main class
     * @param listeners The listeners you want unregister
     * @return
     */
	public static ArrayList<RegisteredListener> getRegisteredListeners(JavaPlugin plugin) {
		return HandlerList.getRegisteredListeners(plugin);
	}
}
