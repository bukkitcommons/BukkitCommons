package bukkit.commons.misc.reference;

import bukkit.commons.misc.reference.interfaces.Present;
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
    
    public int add(int toAdd) {
        return value += toAdd;
    }
    
    public int addThen() {
        return value++;
    }
    
    public int addThen(int toAdd) {
        return value =+ toAdd;
    }
    
    public int sum(int toSum) {
        return value + toSum;
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
