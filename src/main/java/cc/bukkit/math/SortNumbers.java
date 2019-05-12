package cc.bukkit.math;

import java.util.Arrays;

public class SortNumbers {
		int big = 0;
		int small = 0;
		public SortNumbers(int... nums) {
			if(nums.length==0)
				throw new IllegalArgumentException("You must give more than 1 args.");
			Arrays.sort(nums);
			this.small = nums[0];
			this.big = nums[nums.length-1];
		}
		public int getBig() {
			return big;
		}
		public int getSmall() {
			return small;
		}
}
