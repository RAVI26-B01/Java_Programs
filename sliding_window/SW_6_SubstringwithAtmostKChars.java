package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
// leetcode 340 locked
//Find the longest substring with k unique characters in a given string
public class SW_6_SubstringwithAtmostKChars {

	public static void main(String[] args) {
		String s = "aabacbebebbeeex";
		int k =2;
		int solution = solution1(s, k);
		System.out.println(solution);
	}
	
	private static int solution1(String s, int k) {
	       Map<Character, Integer> map = new HashMap<>();
			int l = 0 ; int r = 0;
			int res = -1;
			while(r < s.length()) {
//				map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0) + 1);
				if(!map.containsKey(s.charAt(r))) {
					map.put(s.charAt(r), 1);
				}else {
					Integer integer = map.get(s.charAt(r));
					map.put(s.charAt(r), integer+1);
				}
				
			while(map.size() > k) {
					Integer integer = map.get(s.charAt(l));
					map.put(s.charAt(l), integer-1);
					if(map.get(s.charAt(l)) == 0)
						map.remove(s.charAt(l));
					l++;
				}
				
				if(map.size() <= k) // for at-most use "<=" and for equal unique characters use "=="
					res = Math.max(res, r-l+1);
				r++;
			}
			return res;
	    }

	public static int solution(String str,int k){
	    int n =str.length();
	    int maxLength =0;
	    for(int i=0;i<n;i++){
	        HashSet<Character>set = new HashSet<>();
	        for(int j=i;j<n;j++){
	            set.add(str.charAt(j));
	            //System.out.print(set+" ");
	            if(set.size()<=k){
	                int length =j-i+1;
	                maxLength =Math.max(maxLength,length);
	            }else{
	                break;
	            }
	        }
	    }
	    return maxLength;
	}
	
	//preferred solution ( same as fruit into basket problem)
	private static int solution3(String s, int k) {

	    Map<Character, Integer> countMap = new HashMap<>();
	    int l = 0, maxLen = 0;

	    for (int r = 0; r < s.length(); r++) {
	        countMap.put(s.charAt(r), countMap.getOrDefault(s.charAt(r), 0) + 1);

	        // Shrink the window if we have more than 2 distinct fruits
	        while (countMap.size() > k) {
	            Character leftFruit = s.charAt(l);
	            countMap.put(leftFruit, countMap.get(leftFruit) - 1);
	            if (countMap.get(leftFruit) == 0) {
	                countMap.remove(leftFruit);
	            }
	            l++;
	        }
	        if(countMap.size() <= k)
	        	maxLen = Math.max(maxLen, r - l + 1);
	    }

	    return maxLen;
	
	}
}
