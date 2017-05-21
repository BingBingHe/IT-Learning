package IntegerToRoman_12;

import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		System.out.println(intToRoman(93));
	}
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[][] map = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
        		{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        		{"","C","CC","CCC","CD","D","DC","DCC","DCCC","XM"},
        		{"","M","MM","MMM"}};
        
        sb.append(map[3][num/1000]);
        sb.append(map[2][num%1000/100]);
        sb.append(map[1][num%100/10]);
        sb.append(map[0][num%10]);
        return sb.toString();
    }
}
