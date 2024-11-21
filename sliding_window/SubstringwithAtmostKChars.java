package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
// leetcode 340 locked
//Find the longest substring with k unique characters in a given string
public class SubstringwithAtmostKChars {

	public static void main(String[] args) {
		String s = "aabacbebebe";
		int k =2;
		int solution = solution1(s, k);
		System.out.println(solution);
	}
	
	private static int solution1(String s, int k) {
	       Map<Character, Integer> map = new HashMap<>();
			int l = 0 ; int r = 0;
			int res = -1;
			while(r < s.length()) {
				if(!map.containsKey(s.charAt(r))) {
					map.put(s.charAt(r), 1);
				}else {
					Integer integer = map.get(s.charAt(r));
					map.put(s.charAt(r), integer+1);
				}
				
			while(map.size() > k) {
					Integer integer = map.get(s.charAt(l));
					map.put(s.charAt(l), integer-1);
					if(integer-1 == 0)
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
}
