package bukkit.commons.configuration;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.bukkit.configuration.file.YamlConfiguration;

import bukkit.commons.configuration.annotation.Node;
import bukkit.commons.configuration.annotation.View;
import bukkit.commons.configuration.misc.ConfigurationSerializer;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class Configurations {
    @SneakyThrows
    public static YamlConfiguration loadAndParseConfiguration(YamlConfiguration config, Class<?> providerClass) {
        
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
                    field.set(null, ConfigurationSerializer.deserialize(configuredValue, field.getType()));
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
    public static YamlConfiguration createFileOrLoadYamlConfiguration(File file) {
        if (!file.exists())
            file.createNewFile();
        
        return YamlConfiguration.loadConfiguration(file);
    }
    
    /**
     * 
     * @param file
     * @return
     */
    @SneakyThrows
    public static YamlConfiguration createFileAndParentsOrLoadYamlConfiguration(File file) {
        file.getParentFile().mkdirs();
        return createFileOrLoadYamlConfiguration(file);
    }
}
