package org.bukkit.commons.collection.misc;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class BooleanReference implements Present {
    private boolean value;
    
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
    
    public static BooleanReference of(boolean coord) {
        return new BooleanReference(coord);
    }
    
    public static BooleanReference empty() {
        return new BooleanReference(false);
    }
}
