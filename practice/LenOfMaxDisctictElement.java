package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LenOfMaxDisctictElement {

	public static void main(String[] args) {

		String s = "school";
		int findDisctLen = findDisctLen(s);
		System.out.println(findDisctLen);
		
		int lengthOfLongestSubstring = lengthOfLongestSubstring(s);
		System.out.println(lengthOfLongestSubstring);
		
	}

	/*
	 * TC - O(n2)
	 *  --> loop O(n) * al.contains(...) takes O(n) 
	 */
	private static int findDisctLen2(String s) {
		int count = 0 ;
		int tempCount = 0;
		List<Character> al = new ArrayList<>();
		for(int i = s.length()-1 ; i >=0 ; i--) {
			if(!al.contains(s.charAt(i))) {
				al.add(s.charAt(i));
				tempCount++;
			}else {
				al.clear();
				tempCount = 0;
			}
			if(count<tempCount)
				count = tempCount;
		}
		
		return count;
	}
	
	public static int lengthOfLongestSubstring(String s) {
	    int i = 0, j = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    while (i < s.length()) 
	    {
	        if (!set.contains(s.charAt(i)))
	        {
	            set.add(s.charAt(i));
	            i++;
	            max = Math.max(max, set.size());
	        }
	        else
	        {
	            set.remove(s.charAt(j));
	            j++;
	        }
	    }
	    return max;
	    }

	
	private static int findDisctLen(String s) {
	    Set<Character> set = new HashSet<>();
	    int maxLength = 0;
	    int l = 0;
	    int r = 0;
	    while ( r < s.length()) {
	        char c = s.charAt(r);

	        while (set.contains(c)) {
	            set.remove(s.charAt(l));
	            l++;
	        }

	        set.add(c);
	        maxLength = Math.max(maxLength, r - l + 1);
	        r++;
	    }

	    return maxLength;
	}
	
}
