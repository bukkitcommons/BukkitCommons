package cc.bukkit.math;

public class MathHelper {
	public static boolean between(int target, int int2, int int3) {
		int[] array = {int2,int3};
		IntSorter sortNumbers = new IntSorter(array);
		if(target>sortNumbers.getSmall() && target<sortNumbers.getBig())
			return true;
		return false;
	}
	public static boolean between_checkBorder(int target, int int2, int int3) {
		int[] array = {int2,int3};
		IntSorter sortNumbers = new IntSorter(array);
		if(target>=sortNumbers.getSmall() && target<=sortNumbers.getBig())
			return true;
		return false;
	}
}
