package sliding_window;

import java.util.HashMap;

// leetcode 3
public class LongestSubStringWithoutRepeat {

	public static void main(String[] args) {
		String s = "abcabcbb";
		int len = lengthOfLongestSubstring(s);
		System.out.println(len);
	}
	
//	public static int lengthOfLongestSubstring(String s) {
//		int l = 0;
//		int r= 0;
//		int maxlen = 0;
//		int[] arr = new int[256];
//		
//		while(r<s.length()) {
//			arr[s.charAt(r)]++;
//			
//			while(arr[s.charAt(r)]>1) {
//				arr[s.charAt(l)]--;
//				l++;
//			}
//			maxlen = Math.max(maxlen, r-l+1);
//			r++;
//		}
//		
//		return maxlen;
//		
//	}
	
	public static int lengthOfLongestSubstring(String s) {
	 HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
        
	}
}
