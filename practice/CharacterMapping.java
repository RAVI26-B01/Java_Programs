package practice;

import java.util.Arrays;
import java.util.HashMap;

public class CharacterMapping {

	public static void main(String[] args) {
		String str="babbcb";
		charMapping(str);
	}

	/*
	 * Starts with 0, and increment by 1 each time if encountered a new character
	 */
	private static void charMapping(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int[] resultArray = new int[str.length()];
		int j=0;
		for(int i = 0 ; i < str.length() ;i++) {
			char c=str.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c,j);
				resultArray[i]=j;
				j++;
			}else {
				resultArray[i]=map.get(c);
			}
		}
		System.out.println(Arrays.toString(resultArray));
	}

}
