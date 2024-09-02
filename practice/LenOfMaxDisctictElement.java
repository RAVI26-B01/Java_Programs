package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LenOfMaxDisctictElement {

	public static void main(String[] args) {

		String s = "cadbzabcdx";
		int findDisctLen = findDisctLen(s);
		System.out.println(findDisctLen);
		
		int lengthOfLongestSubstring = lengthOfLongestSubstring(s);
		System.out.println(lengthOfLongestSubstring);
	}

	private static int findDisctLen(String s) {
		int count = 0 ;
		int tempCount = 0;
		List<Character> al = new ArrayList<>();
		for(int i = s.length()-1 ; i >=0 ; i--) {
			if(!al.contains(s.charAt(i))) {
				al.add(s.charAt(i));
				tempCount++;
			}else {
				al.clear();
				tempCount = 1;
				al.add(s.charAt(i));
			}
			if(count<tempCount)
				count = tempCount;
		}
		
		return count;
	}
	
	public static int lengthOfLongestSubstring(String s) {
	    int i = 0, j = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    while (j < s.length()) 
	    {
	        if (!set.contains(s.charAt(j)))
	        {
	            set.add(s.charAt(j));
	            j++;
	            max = Math.max(max, set.size());
	        }
	        else
	        {
	            set.remove(s.charAt(i));
	            i++;
	        }
	    }
	    return max;
	    }

}
