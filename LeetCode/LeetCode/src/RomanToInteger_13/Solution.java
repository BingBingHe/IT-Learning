package RomanToInteger_13;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("X"));
	}
	
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('X',10);
        map.put('C',100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);
        
        char[] letters = s.toCharArray();
        int sum = 0;
        for(int i=0 ; i < letters.length-1 ; i ++){
        	if(map.get(letters[i]) < map.get(letters[i+1])){
        	    sum -= map.get(letters[i]);
        	}else{
        	    sum += map.get(letters[i]);
        	}
        }
        sum += map.get(letters[letters.length-1]);
        return sum;
    }

}
