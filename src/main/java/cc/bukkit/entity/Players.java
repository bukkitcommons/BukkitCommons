package cc.bukkit.entity;

import javax.annotation.concurrent.NotThreadSafe;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

@NotThreadSafe
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
}
