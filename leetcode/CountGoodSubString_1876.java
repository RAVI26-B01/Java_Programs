package leetcode;

import java.util.HashSet;
import java.util.Set;

public class CountGoodSubString_1876 {

	public static void main(String[] args) {
		String s="xyzzaz";
		int count = countGoodSubstrings(s);
		System.out.println(count);
	}
	
	public static int countGoodSubstrings(String s) {
       int count = 0;
		if(s.length()<3)
            return 0;
        int j=3;
        for(int i = 0 ;i<s.length()-2 ;i++){
            if(checkUnique(s.substring(i,j))){
                count++;
            }
            j++;
        }
        return count;
    }

    public static boolean checkUnique(String s){
        Set<Character> set = new HashSet<>();
        for(int i = 0 ;i<s.length() ;i++){
            if(!set.add(s.charAt(i)))
                return false;
        }
            
            return true;
    }
}
