package cc.bukkit.math;

public class NumberUtils {
	public static boolean between(int target, int int2, int int3) {
		int[] array = {int2,int3};
		SortNumbers sortNumbers = new SortNumbers(array);
		if(target>sortNumbers.getSmall() && target<sortNumbers.getBig())
			return true;
		return false;
	}
	public static boolean between_checkBorder(int target, int int2, int int3) {
		int[] array = {int2,int3};
		SortNumbers sortNumbers = new SortNumbers(array);
		if(target>=sortNumbers.getSmall() && target<=sortNumbers.getBig())
			return true;
		return false;
	}
}
