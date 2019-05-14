package cc.bukkit.server;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import lombok.SneakyThrows;

public class PlayerdataUtils {
	/**
	 * Get playerdata File of a player
	 * 
	 * @param playerUUID The player's uuid
	 * @return playerdata file, if the file not exist, it will return null.
	 * @throws IOException 
	 * 
	 */
	public static File getPlayerdataFile(UUID playerUUID) throws IOException {
		if(!Bukkit.getOfflinePlayer(playerUUID).hasPlayedBefore())
			return null;
		File playerdataFile = new File(Bukkit.getWorldContainer(), Bukkit.getWorlds().get(0).getName());
		playerdataFile = new File(playerdataFile, "playerdata");
		if(!playerdataFile.exists())
			throw new IOException("Can't found playerdata folder under: "+playerdataFile.toString());
		playerdataFile = new File(playerdataFile, playerUUID.toString()+".dat");
		if(!playerdataFile.exists())
			return null;
		return playerdataFile;
	}
	

	/**
	 * 
	 * @param uuid
	 * @return
	 */
	@SneakyThrows
	public static Player getOfflinePlayer(UUID uuid) {
		String version = "v" + Bukkit.getServer().getClass().getPackage().getName().split("v")[1];

		Object profile = Class.forName("com.mojang.authlib.GameProfile").
				getConstructor(UUID.class, String.class).
				newInstance(uuid, Bukkit.getOfflinePlayer(uuid).getName());
		
		Object server  = Class.forName("net.minecraft.server".concat(version).concat("MinecraftServer")).
				getDeclaredMethod("getServer").invoke(null);
		
		Object world   = server.getClass().getDeclaredMethod("getWorldServer").invoke(
					Class.forName("net.minecraft.server".concat(version).concat("DimensionManager")).
						getDeclaredMethod("a", int.class).invoke(null, 0)
				);
		
		Object manager = Class.forName("net.minecraft.server".concat(version).concat("PlayerInteractManager")).
				getConstructor(world.getClass()).newInstance(world);
		
		Object player  = Class.forName("net.minecraft.server".concat(version).concat("EntityPlayer")).
				getConstructor(server.getClass(), world.getClass(), profile.getClass(), manager.getClass()).
				newInstance(server, world, profile, manager);
		
		Player target = player == null ? null : Player.class.cast(player.getClass().getDeclaredMethod("getBukkitEntity").invoke(player));
		
        if (target != null)
            target.loadData();
        
        return target;
	}

}
