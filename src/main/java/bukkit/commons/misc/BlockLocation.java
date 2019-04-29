package bukkit.commons.misc;

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
public final class BlockLocation implements Serializable {
    private static final long serialVersionUID = -4030491579424596273L;
    
    private final String world;
    private final int x;
    private final int y;
    private final int z;
    
    private transient Location location;
    
    public BlockLocation(Location location) {
        this.world = location.getWorld().getName();
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
        this.location = location;
    }
    
    public BlockLocation(Block block) {
        this(block.getLocation());
    }
    
    public World getWorldInstance() {
        return Bukkit.getWorld(world);
    }
    
    public Location toLocation() {
        return location == null ? (location = new Location(Bukkit.getWorld(world), x, y, z)) : location;
    }
    
    public String serialize() {
        return world.concat(".") + x + "." + y + "." + z;
    }
    
    public BlockLocation deserialize(String serialized) {
        String[] data = StringUtils.split(serialized, ".");
        return new BlockLocation(data[0], Integer.valueOf(data[1]), Integer.valueOf(data[2]), Integer.valueOf(data[3]));
    }
}
