package ThreeSum_15;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };

		System.out.println(s.threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			tmp.add(nums[i]);
		}
		for (int i = 0; i < size - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				for (int j = i + 1; j < size - 1; j++) {
					if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
						int t = -(nums[i] + nums[j]);
						if (tmp.subList(j + 1, size).contains(t)) {
							List<Integer> tmpArray = Arrays.asList(nums[i], nums[j], t);
							list.add(tmpArray);
						}
					}
				}
			}
		}
		return list;
	}

	public List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		int size = nums.length;
		int NULL  = 1 ;
		
		for (int i = 0; i < size - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1, hi = size - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum) {
						lo++;
					} else {
						hi--;
					}
				}
			}
		}
		return list;
	}

}