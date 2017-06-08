package MaximumSubarray_53;

public class Solution {
	public static void main(String[] args) {
//		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//		int[] nums = { -2, -1, -3, -4, -1, -2, -1, -5, -4 };
		int[] nums = { 1, -1 , -2};
		System.out.println(new Solution().maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			int tmpSum = nums[i];
			if (tmpSum > max) {
				max = tmpSum;
			}
			int j = i + 1;
			while (tmpSum > 0 && j < size) {
				tmpSum += nums[j++];
				if (tmpSum > max) {
					max = tmpSum;
				}
			}

		}
		return max;
	}
}
