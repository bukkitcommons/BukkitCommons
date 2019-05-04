package cc.bukkit;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import javax.annotation.Nonnull;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import cc.bukkit.misc.BlockLocation;
import cc.bukkit.misc.CommonTicker;
import cc.bukkit.misc.SimpleLocation;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class BukkitCommons {
    // ------------------------------
    // Bukkit Commons
    // ------------------------------
    // Ticker
    public static int currentTick() {
        return CommonTicker.getInstance().currentTick();
    }
    
    public static long toTicks(TimeUnit unit, long duration) {
        return CommonTicker.toTicks(unit, duration);
    }
    
    // Simple location
    public static SimpleLocation createSimpleLocation(Location location) {
        return new SimpleLocation(location);
    }
    
    public static SimpleLocation createSimpleLocation(String world, double x, double y, double z) {
        return new SimpleLocation(world, x, y, z);
    }
    
    public static SimpleLocation createSimpleLocation(World world, double x, double y, double z) {
        return new SimpleLocation(world.getName(), x, y, z);
    }
    
    public static SimpleLocation createSimpleLocation(Entity entity) {
        return new SimpleLocation(entity.getLocation());
    }
    
    public static SimpleLocation createSimpleLocation(Block block) {
        return new SimpleLocation(block.getLocation());
    }
    
    public static SimpleLocation createSimpleLocation(String serialized) {
        return SimpleLocation.deserialize(serialized);
    }
    
    // Block location
    public static BlockLocation createBlockLocation(String world, int x, int y, int z) {
        return new BlockLocation(world, x, y, z);
    }
    
    public static BlockLocation createBlockLocation(World world, int x, int y, int z) {
        return new BlockLocation(world.getName(), x, y, z);
    }
    
    public static BlockLocation createBlockLocation(Block block) {
        return new BlockLocation(block);
    }
    
    public static BlockLocation createBlockLocation(Location location) {
        return new BlockLocation(location);
    }
    
    public static BlockLocation createBlockLocation(String serialized) {
        return BlockLocation.deserialize(serialized);
    }
    
    // ------------------------------
    // Bukkit
    // ------------------------------
    
    /**
     * 
     * @param consumer
     * @return
     */
    public static Collection<? extends Player> forEachOnlinePlayers(@Nonnull Consumer<Player> consumer) {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        onlinePlayers.forEach(consumer);
        return onlinePlayers;
    }
    
    /**
     * 
     * @param maxPlayers
     * @return
     */
    @SneakyThrows
    public static int setMaxPlayers(int maxPlayers) {
        Field playerListField = Bukkit.getServer().getClass().getDeclaredField("playerList");
        Field maxPlayersField = playerListField.getDeclaringClass().getDeclaredField("maxPlayers");
        maxPlayersField.setAccessible(true);
        maxPlayersField.set(playerListField.get(Bukkit.getServer()), maxPlayers);
        return maxPlayers;
    }
    
    /**
     * 
     * @param consumer
     * @return
     */
    public static Collection<OfflinePlayer> forEachWhitelistedPlayers(@Nonnull Consumer<OfflinePlayer> consumer) {
        Collection<OfflinePlayer> onlinePlayers = Bukkit.getWhitelistedPlayers();
        onlinePlayers.forEach(consumer);
        return onlinePlayers;
    }
    
    /**
     * 
     * @param message
     * @return
     */
    public static String broadcast(@Nonnull String message) {
        Bukkit.broadcastMessage(message);
        return message;
    }
    
    public static String info(@Nonnull String message) {
        Bukkit.getLogger().info(message);
        return message;
    }
    
    public static String warning(@Nonnull String message) {
        Bukkit.getLogger().warning(message);
        return message;
    }
    
    public static String severe(@Nonnull String message) {
        Bukkit.getLogger().severe(message);
        return message;
    }
    
    /**
     * 
     * @param sender
     * @param perm
     * @return
     */
    public static boolean hasPerm(CommandSender sender, String perm) {
        return sender.isOp() || sender.hasPermission(perm);
    }
    
    /**
     * 
     * @param sender
     * @param perm
     * @return
     */
    public static boolean hasPerm(CommandSender sender, Permission perm) {
        return sender.isOp() || sender.hasPermission(perm);
    }
    
    /**
     * 
     * @param name
     * @return
     */
    public static Optional<Player> getPlayer(@Nonnull String name) {
        return Optional.ofNullable(Bukkit.getPlayerExact(name));
    }
    
    /**
     * 
     * @param uuid
     * @return
     */
    public static Optional<Player> getPlayer(@Nonnull UUID uuid) {
        return Optional.ofNullable(Bukkit.getPlayer(uuid));
    }
    
    /**
     * 
     * @param name
     * @return
     */
    public static Optional<UUID> getPlayerUniqueId(@Nonnull String name) {
        Optional<Player> player = getPlayer(name);
        return player.isPresent() ? Optional.of(player.get().getUniqueId()) : Optional.empty();
    }
    
    /**
     * 
     * @param consumer
     * @return
     */
    public static List<World> forEachWorlds(Consumer<World> consumer) {
        List<World> worlds = Bukkit.getWorlds();
        worlds.forEach(consumer);
        return worlds;
    }
}
