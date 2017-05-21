package ZigZag_6;

public class Solution {
	public static void main(String[] args) {
		System.out.println(convert("AB",2));
	}
	
	public static String convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder();
		if(numRows == 1){
		    return s;
		}
		int stepHT = 2 * numRows - 2;
		int stepBody = numRows - 1;
		int length = s.length();
		for (int begin = 0; begin < numRows; begin++) {
			if (begin == 0 || begin == numRows - 1) {
			    int i = begin;
				while (i < length) {
					sb.append(s.charAt(i));
					i += stepHT;
				}
			}else{
			    int i = begin;
			    boolean tag = true;
				while (i < length) {
					sb.append(s.charAt(i));
					if(tag){
					    i += (stepHT-2*(i%stepHT));    
					}else{
					    i += (stepHT-2*(i%stepHT));
					    i += stepHT;
					}
					tag= !tag;
				}
			}
		}

		String result = sb.toString();
		return result;
	}

}
