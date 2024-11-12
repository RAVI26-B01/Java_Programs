package leetcode;

import java.util.Arrays;

public class SubstringAll3Chars_1358 {

	public static void main(String[] args) {
		String s = "abcabc";
		int numberOfSubstrings = numberOfSubstrings(s);
		System.out.println(numberOfSubstrings);
	}
	
	public static int numberOfSubstrings(String s) {
        int len=0;
        int r=0;
        int[] arr=new int[3];
        Arrays.fill(arr,-1);
        while(r<s.length()){
            arr[s.charAt(r)-'a']=r;
            if(arr[0]!=-1 && arr[1]!=-1 && arr[2]!=-1){
                len = len + 1 + Math.min(arr[0], Math.min(arr[1], arr[2]));

            }
            r++;   
        }
        return len;
    
    }
}
