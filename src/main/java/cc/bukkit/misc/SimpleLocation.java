package cc.bukkit.misc;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public final class SimpleLocation implements Serializable {
    private static final long serialVersionUID = -4030491579424596273L;
    
    private final String world;
    private final double x;
    private final double y;
    private final double z;
    
    private transient Location location;
    
    public SimpleLocation(Location location) {
        this.world = location.getWorld().getName();
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        this.location = location;
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
    
    public SimpleLocation deserialize(String serialized) {
        String[] data = StringUtils.split(serialized, ".");
        return new SimpleLocation(data[0], Double.valueOf(data[1]), Double.valueOf(data[2]), Double.valueOf(data[3]));
    }
}
