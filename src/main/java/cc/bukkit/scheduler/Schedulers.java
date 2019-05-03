package cc.bukkit.scheduler;

import java.util.function.Predicate;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import cc.bukkit.plugin.CommonsPlugin;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class Schedulers {
    /**
     * 
     * @param runnable
     * @param delay
     * @param period
     * @param cancel
     * @return
     */
    public static BukkitTask runTaskTimerThenCancel(Runnable runnable, int delay, int period, int cancel) {
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(CommonsPlugin.getInstance(), runnable, delay, period);
        Bukkit.getScheduler().runTaskLater(CommonsPlugin.getPlugin(CommonsPlugin.class), BukkitTask::cancel, cancel);
        return task;
    }
    
    /**
     * 
     * @param runnable
     * @param delay
     * @param period
     * @param predicate
     * @param cancel
     * @return
     */
    public static BukkitTask runTaskTimerThenCancelIf(Runnable runnable, int delay, int period, Predicate<BukkitTask> predicate, int cancel) {
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(CommonsPlugin.getInstance(), runnable, delay, period);
        Bukkit.getScheduler().runTaskLater(CommonsPlugin.getPlugin(CommonsPlugin.class), () -> {
            if (predicate.test(task))
                task.cancel();
        }, cancel);
        return task;
    }
}
