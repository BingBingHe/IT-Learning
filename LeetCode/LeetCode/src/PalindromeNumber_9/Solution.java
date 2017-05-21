package PalindromeNumber_9;

public class Solution {
	public static void main(String[] args) {
		System.out.println(isPalindrome(2147483647));
	}
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }else if(x == 0){
            return true;
        }
        int count = 0;
        while((int)(x/(Math.pow(10,count))) != 0){
        	System.out.println(x/(int)(Math.pow(10,count)));
            count++;
        }
        int low = 0;
        int high = count - 1;
        System.out.println(count);
        while(low <= high){
            if(x%(int)(Math.pow(10,low+1))/(int)(Math.pow(10,low)) != x%(int)(Math.pow(10,high+1))/(int)(Math.pow(10,high))){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}