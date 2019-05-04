package cc.bukkit.configuration.misc;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import lombok.SneakyThrows;
import lombok.val;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ConfigurationSerializer {
    private static final Gson GSON = new Gson();
    
    public static Object serialize(Object value, Class<?> knownType) {
        // let bukkit handle them
        if (knownType.isPrimitive() || knownType.isAssignableFrom(List.class) || knownType.isAssignableFrom(ConfigurationSerializable.class))
            return value;
        
        if (knownType.isAssignableFrom(Map.class))
            return Collections.singletonList(value);
        
        if (knownType.isAssignableFrom(Collection.class))
            return Lists.newArrayList((Collection<?>) value);
        
        return GSON.toJson(value);
    }
    
    @SneakyThrows
    @SuppressWarnings("unchecked")
    public static Object deserialize(Object value, Object container) {
        Class<?> type = container.getClass();
        // let bukkit handle them
        if (type.isPrimitive() || type.isAssignableFrom(List.class) || type.isAssignableFrom(ConfigurationSerializable.class))
            return value;
        
        if (type.isAssignableFrom(Map.class))
            return List.class.cast(value).get(0);
        
        if (type.isAssignableFrom(Collection.class)) {
            val set = (Collection<?>) container;
            set.clear();
            set.addAll(Collection.class.cast(value));
        }
        
        return GSON.fromJson(String.valueOf(value), type);
    }
}
