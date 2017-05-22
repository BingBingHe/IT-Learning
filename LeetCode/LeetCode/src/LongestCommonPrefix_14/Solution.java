package LongestCommonPrefix_14;

public class Solution {

	public static void main(String[] args) {
//		String[] strs = { "1223", "122245" };
		String[] strs = { "1" ,"1"};
		System.out.println(new Solution().longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length <= 0){
			return "";
		}
		if (strs.length == 1){
			return strs[0];
		}
		int length = strs.length;
		int longestLength = 0;
		int LengthTmp = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			LengthTmp = strs[i].length() < LengthTmp ? strs[i].length() : LengthTmp;
		}
//		System.out.println(LengthTmp);
		for (int j = 1; j <= LengthTmp; j++) {
			int i = 0;
			for (; i < length - 1; i++) {
				if (!strs[i].substring(0, j).equals(strs[i + 1].substring(0, j))) {
					break;
				}
			}
			if (i != length - 1) {
				break;
			}
			longestLength = j;
		}
		return strs[0].substring(0, longestLength);
	}
}
