package org.bukkit.commons.misc;

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
public final class SimpleLocation2D implements Serializable {
    private static final long serialVersionUID = -4030491579424596273L;
    
    private final String world;
    private final double x;
    private final double z;
    
    private transient Location location;
    
    public SimpleLocation2D(Location location) {
        this.world = location.getWorld().getName();
        this.x = location.getX();
        this.z = location.getZ();
        this.location = location;
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
    
    public SimpleLocation2D deserialize(String serialized) {
        String[] data = StringUtils.split(serialized, ";");
        return new SimpleLocation2D(data[0], Double.valueOf(data[1]), Double.valueOf(data[2]));
    }
}
