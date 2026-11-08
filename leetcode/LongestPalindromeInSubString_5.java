package leetcode;

public class LongestPalindromeInSubString_5 {
	
	public static void main(String[] args) {
		String s = "cbbd";
		System.out.println(findLongestPalindrome(s));
	}

	private static String findLongestPalindrome(String s) {
		int startingIndx = 0;
		int maxLen = 0;
		for(int i = 0 ; i<s.length() ; i++) {
			for(int j = i+1; j<s.length() ; j++) {
				if((j-i)>maxLen && isPalindrome(s, i,j)) {
					maxLen = j-i;
					startingIndx = i;
				}
			}
		}
		
		return s.substring(startingIndx,startingIndx + maxLen+1);
	}

	private static boolean isPalindrome(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
