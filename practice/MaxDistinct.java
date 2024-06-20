package practice;

import java.util.HashSet;
import java.util.Set;

public class MaxDistinct {
	public static void main(String[] args) {
		String s = "abcda";
		int count = 0 ;
		int maxcount = 0;
		Set<Character> set = new HashSet<>();
		for(int i = 0 ; i<s.length() ; i++) {
			if(set.add(s.charAt(i))) {
				set.add(s.charAt(i));
				count++;
			}else {
				set.clear();
				count=0;
			}
			if(count>maxcount) {
				maxcount = count;
			}
			
		}
		System.out.println(maxcount);
	
	}
}
