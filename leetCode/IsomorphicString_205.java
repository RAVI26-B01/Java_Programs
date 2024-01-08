package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString_205 {

	public static void main(String[] args) {

		String s="badc";
		String t="baba";
		boolean isomorphic = isIsomorphic(s,t);
		System.out.println(isomorphic);
	}
	 public static boolean isIsomorphic(String s, String t) {
		 Map<Character,Character> map = new HashMap<Character, Character>();
		 for(int i= 0 ,j=0;i<s.length() ; i++,j++) {
			 if(!map.containsKey(s.charAt(i))) {
				 map.put(s.charAt(i),t.charAt(j));
			 }else {
				 if(map.get(s.charAt(i))!=t.charAt(j)) {
					 return false;
				 }
			 }
		 }
		 
		 return true;
	 }

}
