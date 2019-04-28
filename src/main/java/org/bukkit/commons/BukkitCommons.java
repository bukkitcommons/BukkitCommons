package org.bukkit.commons;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.function.Consumer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class BukkitCommons {
    /**
     * 
     * @param consumer
     * @return
     */
    public Collection<? extends Player> forEachOnlinePlayers(Consumer<Player> consumer) {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        onlinePlayers.forEach(consumer);
        return onlinePlayers;
    }
    
    /**
     * 
     * @param maxPlayers
     * @return
     */
    @SneakyThrows
    public int setMaxPlayers(int maxPlayers) {
        Field playerListField = Bukkit.getServer().getClass().getDeclaredField("playerList");
        Field maxPlayersField = playerListField.getDeclaringClass().getDeclaredField("maxPlayers");
        maxPlayersField.setAccessible(true);
        maxPlayersField.set(playerListField.get(Bukkit.getServer()), maxPlayers);
        return maxPlayers;
    }
}
