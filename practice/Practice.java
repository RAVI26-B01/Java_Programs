package practice;

<<<<<<< HEAD
public class Practice{
	public static void main(String[] args) {
		
		int n = 12345;
		int sumOfDigits = sumOfDigits(n);
		System.out.println(sumOfDigits);
	}

	private static int sumOfDigits(int n) {
		
		if(n<=0)
			return 0;
		return n%10 + sumOfDigits(n/10);
	}

}
=======
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
>>>>>>> 2f11a8c28949928787b171149213865319e761d1
