package org.bukkit.commons.collection.misc;

public interface Present {
    public default boolean has() {
        return isPresent();
    }
    
    public boolean isPresent();
    
    public boolean isEmpty();
}
