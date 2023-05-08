package leetCode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MinimumInsertionPalindrome_1312 {

	public static void main(String[] args) {
		String s="zjveiiwvc";
		int minInsertions = minInsertions(s);
		System.out.println(minInsertions);
	}

	private static int minInsertions(String s) {
		Map<Character,Integer> map = new HashMap();
		int count=0;
		for (int i = 0; i < s.length() ; i++) {
			if(map.containsKey(s.charAt(i))) {
				Integer integer = map.get(s.charAt(i));
				map.put(s.charAt(i), integer+1);
			}else {
				map.put(s.charAt(i), 1);
			}
		}
		System.out.println(map);
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if((entry.getValue() & 1)==1)
				count++;
		}
		
		return count-1;
		
	}

}
