package bukkit.commons.configuration.misc;

import com.google.gson.Gson;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ConfigurationSerializer {
    private final static Gson GSON = new Gson();
    
    public static String serialize(Object defaultValue) { // field (default) value -> configured (to save) value
        return GSON.toJson(defaultValue);
    }
    
    public static <T> T deserialize(String configuredValue, Class<? extends T> type) { // configured (saved) value -> field (to set) value
        return GSON.fromJson(configuredValue, type);
    }
}
