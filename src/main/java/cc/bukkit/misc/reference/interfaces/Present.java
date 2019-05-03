package cc.bukkit.misc.reference.interfaces;

public interface Present {
    public default boolean has() {
        return isPresent();
    }
    
    public boolean isPresent();
    
    public boolean isEmpty();
}
