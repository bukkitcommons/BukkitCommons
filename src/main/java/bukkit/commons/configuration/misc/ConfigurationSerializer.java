package bukkit.commons.configuration.misc;

import java.util.List;
import com.google.gson.Gson;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ConfigurationSerializer {
    private static final Gson GSON = new Gson();
    
    public static Object serialize(Object value, Class<?> type) {
        // let bukkit handle them
        if (type.isPrimitive() || type.isAssignableFrom(List.class))
            return value;
        
        return GSON.toJson(value);
    }
    
    @SneakyThrows
    public static Object deserialize(Object value, Class<?> type) {
        // let bukkit handle them
        if (type.isPrimitive() || type.isAssignableFrom(List.class))
            return value;
        
        return GSON.fromJson(String.valueOf(value), type);
    }
}
