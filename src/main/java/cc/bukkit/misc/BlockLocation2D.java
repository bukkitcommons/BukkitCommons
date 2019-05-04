package cc.bukkit.misc;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public final class BlockLocation2D implements Serializable {
    private static final long serialVersionUID = -4030491579424596273L;
    
    private final String world;
    private final int x;
    private final int z;
    
    private transient Location location;
    
    public BlockLocation2D(Location location) {
        this.world = location.getWorld().getName();
        this.x = location.getBlockX();
        this.z = location.getBlockZ();
        this.location = location;
    }
    
    public BlockLocation2D(Block block) {
        this(block.getLocation());
    }
    
    public World getWorldInstance() {
        return Bukkit.getWorld(world);
    }
    
    public Location toLocation() {
        return location == null ? (location = new Location(Bukkit.getWorld(world), x, 0, z)) : location;
    }
    
    public String serialize() {
        return world.concat(".") + x + "." + z;
    }
    
    public static BlockLocation2D deserialize(String serialized) {
        String[] data = StringUtils.split(serialized, ".");
        return new BlockLocation2D(data[0], Integer.valueOf(data[1]), Integer.valueOf(data[2]));
    }
}
