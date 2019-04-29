package org.bukkit.commons.collection.misc;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class IntReference implements Present {
    private int value;
    
    public int get() {
        return value;
    }
    
    public int set(int newValue) {
        int prev = value;
        value = newValue;
        return prev;
    }
    
    public int add() {
        return ++value;
    }
    
    public int addThen() {
        return value++;
    }
    
    public boolean isPresent() {
        return value != 0;
    }
    
    public boolean isEmpty() {
        return value == 0;
    }
    
    public static IntReference of(int coord) {
        return new IntReference(coord);
    }
    
    public static IntReference empty() {
        return new IntReference(0);
    }
}
