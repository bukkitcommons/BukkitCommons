package cc.bukkit.server;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

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

   public static Player getOfflinePlayer(UUID uuid) {
       String version = "v" + Bukkit.getServer().getClass().getPackage().getName().split("v")[1];
       Class<?> gameProfileClass = Class.forName("net.minecraft.server."+version+".GameProfile");
       
       Constructor<?> gameProfileConstructor = gameProfileClass.getConstructor(UUID.class,OfflinePlayer.class);
       Object gameProfile = gameProfileConstructor.newInstance(uuid,Bukkit.getOfflinePlayer(uuid).getName());
       // [SOLVED] GameProfile profile = new GameProfile(uuid,Bukkit.getOfflinePlayer(uuid));
       Class<?> minecraftServer = Class.forName("net.minecraft.server."+version+".MinecraftServer");
       Object serverInstance = ServerTPS.getNMSClass("MinecraftServer").getMethod("getServer").invoke(null);
       // [SOLVED]MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
       //EntityPlayer entity;
       Class<?> entityClass = Class.forName("net.minecraft.server."+version+".EntityPlayer");
       Object entity;
       if(version.equals("v1_14_R1")){
    	   
           //entity = new EntityPlayer(server, server.getWorldServer(DimensionManager.a(0)), profile, new PlayerInteractManager(server.getWorldServer(DimensionManager.a(0))));
       } else {
           //entity = new EntityPlayer(server, server.getWorldServer(0), profile, new PlayerInteractManager(server.getWorldServer(0)));
       }
      // Player target = entity == null ? null : entity.getBukkitEntity();
       if (target != null) {
           target.loadData();
           return target;
       }
       return target;
   }
   
}
