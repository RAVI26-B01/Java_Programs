package sliding_window;

public class SW_8_CharacterReplacement {
	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 2;
		System.out.println(characterReplacement(s, k));;
	}
	
	 public static int characterReplacement(String s, int k) {
		 int[] arr = new int[26];
		 int l = 0;
		 int r = 0;
		 int maxLen = 0;
		 int maxFreq = 0;
		 
		 while(r<s.length()) {
			 arr[s.charAt(r)-'A']++;
			 maxFreq = Math.max(maxFreq, arr[s.charAt(r)-'A']);
			 
			 if((r-l+1)-maxFreq>k) {
				 arr[s.charAt(l)-'A']--;
				 l++;
			 }
			 
			 if((r-l+1)-maxFreq<=k) {
				 maxLen = Math.max(maxLen, r-l+1);
			}
			 r++;
		 }
		return maxLen;
	 }
}
