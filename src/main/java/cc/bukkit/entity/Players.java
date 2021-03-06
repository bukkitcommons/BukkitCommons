package cc.bukkit.entity;

import java.util.Optional;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Players implements Listener {
    /**
     * 
     * @param player
     * @param sound
     * @return
     */
    public static Player playSound(Player player, Sound sound) {
        player.playSound(player.getLocation(), sound, Float.MAX_VALUE, 1);
        return player;
    }
    
    /**
     * 
     * @param player
     * @param sound
     * @param pitch
     * @return
     */
    public static Player playSound(Player player, Sound sound, float pitch) {
        player.playSound(player.getLocation(), sound, Float.MAX_VALUE, pitch);
        return player;
    }
    
    /**
     * 
     * @param player
     * @param sound
     * @param volume
     * @param pitch
     * @return
     */
    public static Player playSound(Player player, Sound sound, float volume, float pitch) {
        player.playSound(player.getLocation(), sound, volume, pitch);
        return player;
    }
    
    /**
     * 
     * @param playerName
     * @param command
     * @return
     */
    public static Optional<Player> dispatchCommand(String playerName, String command) {
        Player player = Bukkit.getPlayerExact(playerName);
        if (player != null)
            Bukkit.dispatchCommand(player, command);
        
        return Optional.ofNullable(player);
    }
    /**
     * 
     * @param player
     * @param command
     * @return
     */
    public static Optional<Player> dispatchCommand(Player player, String command) {
        if (player != null)
            Bukkit.dispatchCommand(player, command);
        
        return Optional.ofNullable(player);
    }
    /**
     * 
     * @param playerUUID
     * @param command
     * @return
     */
    public static Optional<Player> dispatchCommand(UUID playerUUID, String command) {
    	Player player = Bukkit.getPlayer(playerUUID);
        if (player != null)
            Bukkit.dispatchCommand(player, command);
        
        return Optional.ofNullable(player);
    }

}
