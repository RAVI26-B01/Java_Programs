package practice;

public class PalindromeString {

	public static void main(String[] args) {
		
		String s="madam";
		boolean checkPalindrome = checkPalindrome(s);
		if(checkPalindrome)
			System.out.println("palindrome");
		else
			System.out.println("not - palindorme");
	
	}
	private static boolean checkPalindrome(String s) {
		int count=0;
		for(int i=0 ; i<s.length()/2 ; i++) {
			if(s.charAt(i)==s.charAt(s.length()-i-1))
				count++;
		}
		return count==s.length()/2;
		
	}

}
