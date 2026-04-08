package sliding_window;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram_438 {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		findAnagrams(s, p);
	}
	
	public static List<Integer> findAnagrams(String s, String t) {
        List<Integer> ans = new ArrayList<>();
        int[] chars = new int[26];
		int l =0 ;
		int r= 0;
		int count = 0;
		int sIndex = -1;
		int minLen = Integer.MAX_VALUE;
		
		for(int i = 0 ; i<t.length() ;i++) {
			chars[t.charAt(i)-'a']++;
		}
		while(r<s.length()) {
			
			if(chars[s.charAt(r)-'a']>0) {
				count++;
			}
			chars[s.charAt(r)-'a']--;

			if(count == t.length()) {
                ans.add(l);
				chars[s.charAt(l)-'a']++;
				if(chars[s.charAt(l)-'a'] > 0)	//reducing the count so that we can go for new window
					count--;
				l++;
			}
			
			r++;
			}
			
		
System.out.println(ans);
    return ans;
    }
}
