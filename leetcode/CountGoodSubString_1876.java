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
    
    
    public int countGoodSubstrings2(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;

        for(int i=0; i+2<charArray.length; i++){
            char c1 = charArray[i];
            char c2 = charArray[i+1];
            char c3 = charArray[i+2];
            if(c1!=c2 && c2!=c3 && c3!=c1){
                result++;
            }
        }

        return result;
        
    }
}
