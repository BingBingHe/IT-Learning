package ContinuousSubarraySum_523;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0 };
		System.out.println(new Solution().checkSubarraySum(nums, 0));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,22);}};
		System.out.println(map.get(0));
	}

	public boolean checkSubarraySum(int[] nums, int k) {
		boolean max = false;
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			int sum = nums[i];
			int j = i + 1;
			while (j < size) {
				sum += nums[j++];
				if ((k == 0 && sum == 0) || (k != 0 && sum % k == 0)) {
					return true;
				}
			}
		}
		return false;
	}
}