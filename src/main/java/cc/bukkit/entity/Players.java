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

    /**
     *
     * @param uuid
     * @return
     */
    /*
    public static Player getOfflinePlayer(UUID uuid) {
        String version = "v" + Bukkit.getServer().getClass().getPackage().getName().split("v")[1];
        GameProfile profile = new GameProfile(uuid,Bukkit.getOfflinePlayer(uuid));
        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        EntityPlayer entity;
        if(version.equals("v1_14_R1")){
            entity = new EntityPlayer(server, server.getWorldServer(DimensionManager.a(0)), profile, new PlayerInteractManager(server.getWorldServer(DimensionManager.a(0))));
        } else {
            entity = new EntityPlayer(server, server.getWorldServer(0), profile, new PlayerInteractManager(server.getWorldServer(0)));
        }
        Player target = entity == null ? null : entity.getBukkitEntity();
        if (target != null) {
            target.loadData();
            return target;
        }
        return target;
    }
    */
}
