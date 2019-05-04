package cc.bukkit.misc;

public class PointableObject extends Object {
    public int asInt() {
        return (int) (Object) this;
    }
    
    public boolean asBoolean() {
        return (boolean) (Object) this;
    }
    
    public double asDouble() {
        return (double) (Object) this;
    }
    
    public short asShort() {
        return (short) (Object) this;
    }
    
    public String asString() {
        return (String) (Object) this;
    }
}
