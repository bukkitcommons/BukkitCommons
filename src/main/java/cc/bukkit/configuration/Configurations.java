package cc.bukkit.configuration;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import cc.bukkit.configuration.annotation.Node;
import cc.bukkit.configuration.annotation.View;
import cc.bukkit.configuration.misc.ConfigurationSerializer;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class Configurations {
    public static YamlConfiguration parseConfiguration(File configFile, Class<?> providerClass) {
        return parseConfiguration(loadYamlConfiguration(configFile), providerClass);
    }
    
    @SneakyThrows
    public static YamlConfiguration parseConfiguration(YamlConfiguration config, Class<?> providerClass) {
        
        for (Field field : providerClass.getDeclaredFields()) {
            Node node = field.getAnnotation(Node.class);
            // skip fields without annotation
            if (node == null)
                continue;
            
            field.setAccessible(true);
            // the field should be static and public
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) && Modifier.isPublic(mod)) {
                // hack final field
                if (Modifier.isFinal(mod)) {
                    Field modifiersField = Field.class.getDeclaredField("modifiers");
                    modifiersField.setAccessible(true);
                    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                }
                
                Object defaultValue = field.get(null);
                String path = node.value();
                Object configuredValue = config.get(path);
                
                View view = field.getAnnotation(View.class);
                // forcely override config-view options or saving default value
                if (view != null || configuredValue == null) { 
                    config.set(path, ConfigurationSerializer.serialize(defaultValue, field.getType()));
                } else {
                    field.set(null, ConfigurationSerializer.deserialize(configuredValue, field.get(null)));
                }
                
                // add final back
                if (Modifier.isFinal(mod)) {
                    Field modifiersField = Field.class.getDeclaredField("modifiers");
                    modifiersField.setAccessible(true);
                    modifiersField.setInt(field, field.getModifiers() & Modifier.FINAL);
                }
            }
        }
        
        return config;
    }
    
    /**
     * 
     * @param file
     * @return
     */
    @SneakyThrows
    public static YamlConfiguration loadYamlConfiguration(File file) {
        file.getParentFile().mkdirs();
        
        if (!file.exists())
            file.createNewFile();
        
        return YamlConfiguration.loadConfiguration(file);
    }
    
    public static void parseColours(YamlConfiguration config) {
		Set<String> keys = config.getKeys(true);
		for (String key : keys) {
			String filtered = config.getString(key);
			if (filtered.startsWith("MemorySection")) {
				continue;
			}
			filtered = ChatColor.translateAlternateColorCodes('&', filtered);
			config.set(key, filtered);
		}
	}
	public static String parseColours(String text) {
		text = ChatColor.translateAlternateColorCodes('&', text);
		return text;
	}
}
