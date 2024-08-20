package sliding_window;

import java.util.Arrays;

public class CountAnagrams {

	 public static void main(String args[])
	 {
	     String text = "forfxxorfxdofr";
	     String word = "for";
	     System.out.print(countAnagrams(text, word));
	 }
	 
	 
	 public static int countAnagrams(String s, String p)
	 {
	     int CHARACTERS = 26;
	     int sn = s.length();
	     int pn = p.length();
	     int count = 0;
	     if (sn < 0 || pn < 0 || sn < pn)
	         return 0;

	     int[] pArr = new int[CHARACTERS];
	     int[] sArr = new int[CHARACTERS];
	     int i = 0;
	     // till window size
	     for (; i < pn; i++) {
	         sArr[ s.charAt(i)-97]++;
	         pArr[ p.charAt(i)-97]++;
	     }
	     if (Arrays.equals(pArr, sArr))
	         count += 1;
	     // next window
	     for (; i < sn; i++) {
	         sArr[ s.charAt(i)-97]++;
	         sArr[ s.charAt(i - pn)-97]--;

	         if (Arrays.equals(pArr, sArr))
	             count += 1;
	     }
	     return count;
	 }
}
