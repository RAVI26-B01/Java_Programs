package practice;

public class Practice {
	public static void main(String[] args) {
	  String s = ".,";
	  boolean palindrome = isPalindrome(s);
	  System.out.println(palindrome);
	}
	
	public static boolean isPalindrome(String s) {
        char[] chArr = s.toCharArray();
        int l = 0;
        int r = chArr.length-1;

        while(l<r){
            if(!Character.isAlphabetic(chArr[l]))
            	l++;
            if( !Character.isAlphabetic(chArr[r]))
            	r--;
            else{
	            if(Character.toLowerCase(chArr[l]) != Character.toLowerCase(chArr[r])) {
	            	return false;
	            }
	            l++;r--;
            }
           
            	
            
        }
		return true;
    }
	
}