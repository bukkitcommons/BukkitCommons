package org.bukkit.commons.collection.misc;

import java.util.function.Consumer;

import org.bukkit.entity.Player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@RequiredArgsConstructor
@Accessors(fluent = true)
public class CollectionWithPlayerConsumer<T> {
    private final T collection;
    private final Consumer<Player> consumer;
    
    public boolean has() {
        return consumer == null;
    }
    
    public static <T> CollectionWithPlayerConsumer<T> of(T collection, PlayerConsumer... consumer) {
        return new CollectionWithPlayerConsumer<T>(collection, consumer.length == 0 ? null : consumer[0]);
    }
}