package bukkit.commons.misc.reference;

import bukkit.commons.misc.reference.interfaces.Present;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class Reference<V> implements Present {
    private V value;
    
    public V get() {
        return value;
    }
    
    public V set(V newValue) {
        V prev = value;
        value = newValue;
        return prev;
    }
    
    public boolean isPresent() {
        return value != null;
    }
    
    public boolean isEmpty() {
        return value == null;
    }
    
    public static <V> Reference<V> of(V coord) {
        return new Reference<V>(coord);
    }
    
    public static <V> Reference<V> empty() {
        return new Reference<V>(null);
    }
}
