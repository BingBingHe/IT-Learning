package StringToInteger_8;

public class Solution {
	public static void main(String[] args) {
		System.out.println(myAtoi("-2147483648"));
//		System.out.println(Integer.parseInt("   010"));
	}
	public static int myAtoi(String str) {
        
		char[] charArrayTmp = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < charArrayTmp.length ; i++){
			if(charArrayTmp[i] != ' '){
				while(i<charArrayTmp.length && charArrayTmp[i] != ' '){
					sb.append(""+charArrayTmp[i]);
					i++;
				}
				break;
			}
		}
		char[] charArray = sb.toString().toCharArray();
		int sign = 1;
		int base = 0;
		int i = 0;
		if(charArray.length <= 0 ){
			return 0;
		}
		if(charArray[i] == '-' || charArray[i] == '+'){
			sign = 1 - 2 * ((charArray[i++] == '-') ? 1 : 0); 
		}
		System.out.println(sign);
		while(i < charArray.length && charArray[i] >= '0' && charArray[i] <= '9'  ){
			if(base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE/ 10  && charArray[i] - '0' > 7 )){
				if(sign == 1) return Integer.MAX_VALUE;
				else return Integer.MIN_VALUE;
			}
			base = 10 * base + (charArray[i++] - '0');
			System.out.println(base);
		}
		return base * sign;
		
    }
}
