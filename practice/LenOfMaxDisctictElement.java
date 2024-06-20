package practice;

import java.util.ArrayList;
import java.util.List;

public class LenOfMaxDisctictElement {

	public static void main(String[] args) {

		String s = "dvdf";
		int findDisctLen = findDisctLen(s);
		System.out.println(findDisctLen);
	}

	private static int findDisctLen(String s) {
		int count = 0 ;
		int tempCount = 0;
		List<Character> al = new ArrayList<>();
		for(int i = s.length()-1 ; i >=0 ; i--) {
			if(!al.contains(s.charAt(i))) {
				al.add(s.charAt(i));
				tempCount++;
			}else {
				al.clear();
				tempCount = 1;
				al.add(s.charAt(i));
			}
			if(count<tempCount)
				count = tempCount;
		}
		
		return count;
	}

}
