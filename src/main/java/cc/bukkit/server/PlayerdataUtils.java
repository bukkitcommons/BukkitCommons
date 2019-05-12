package cc.bukkit.server;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;

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
}
