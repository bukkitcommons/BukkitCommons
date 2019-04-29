package org.bukkit.commons.collection.misc;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class VolatileBooleanReference implements Present {
    private volatile boolean value;
    
    public boolean get() {
        return value;
    }
    
    public boolean set(boolean newValue) {
        boolean prev = value;
        value = newValue;
        return prev;
    }
    
    public boolean isPresent() {
        return value;
    }
    
    public boolean isEmpty() {
        return !value;
    }
    
    public static VolatileBooleanReference of(boolean coord) {
        return new VolatileBooleanReference(coord);
    }
    
    public static VolatileBooleanReference empty() {
        return new VolatileBooleanReference(false);
    }
}
