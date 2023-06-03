package practice;

public class PalindromeNumber {

	public static void main(String[] args) {
		int n=1221;
		boolean checkPalindrome = checkPalindrome(n);
		if(checkPalindrome)
			System.out.println("palindrome");
		else
			System.out.println("not - palindorme");
	}

	private static boolean checkPalindrome(int n) {
		int temp=n;
		int sum=0;
		while(n>0) {
			int rem = n%10;
			sum=sum*10+rem;
			n=n/10;
					
		}
		return sum==temp;
	}

}
