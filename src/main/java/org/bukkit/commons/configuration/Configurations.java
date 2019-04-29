package org.bukkit.commons.configuration;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class Configurations {
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
