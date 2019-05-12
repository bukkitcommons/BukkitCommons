package cc.bukkit.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.inventory.InventoryHolder;

public class BlockUtils {
	/**
	 * Returns the chest attached to the given chest. The given block must be a
	 * chest.
	 *
	 * @param b
	 *            The chest to check.
	 * @return the block which is also a chest and connected to b.
	 */
	public static Block getSecondHalfChest(Block b) {
		if(b.getType() != Material.CHEST && b.getType() != Material.TRAPPED_CHEST){
			return null;
		}
		Chest oneSideOfChest = (Chest)b.getState();
		InventoryHolder chestHolder = oneSideOfChest.getInventory().getHolder();
		if(chestHolder instanceof DoubleChest){
			DoubleChest doubleChest = (DoubleChest)chestHolder;
			InventoryHolder left = doubleChest.getLeftSide();
			InventoryHolder right = doubleChest.getRightSide();

			Chest leftC = (Chest)left;
			Chest rightC = (Chest)right;
			if(equalsBlockStateLocation(oneSideOfChest, leftC)) 
				return rightC.getBlock();
			if(equalsBlockStateLocation(oneSideOfChest, leftC)) 
				return leftC.getBlock();
			return null;
		}else{
			return null;
		}
	}
	
	private static final boolean equalsBlockStateLocation(BlockState b1, BlockState b2) {
	    return b1.getX() == b2.getX() && b1.getY() == b2.getY() && b1.getZ() == b2.getZ();
	}
}
