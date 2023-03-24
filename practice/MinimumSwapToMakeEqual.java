package practice;

public class MinimumSwapToMakeEqual {

	public static void main(String[] args) {
		String s1 = "10011001";
		String s2 = "01100101";
		int countSwap = countSwap(s1, s2);
		System.out.println(countSwap);
	}

	private static int countSwap(String s1, String s2) {
		int count=0;
		for(int i = 0 ; i<s1.length() ; i++) {
			if(s1.charAt(i) != s2.charAt(i))
				count++;
		}
		return count/2;
	}

}
