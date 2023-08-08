package leetcode;

import java.util.Scanner;

public class SumOfBinary {

	public static void main(String[] args) {
		String b1="100";
		String b2="110";
		String binarySum = BinarySum(b1,b2);
		System.out.println(binarySum);
	}

	private static String BinarySum(String b1, String b2) {
		int n=b1.length();
		int m=b2.length();
		int carry=0;
		StringBuffer res = new StringBuffer();
		while(n>=0 || m>=0 || carry>0)
		{
			int x=n>0?b1.charAt(n-1)-'0':0;
			int y=m>0?b2.charAt(m-1)-'0':0;
			res.append((x+y+carry)%2);
			carry=(x+y)/2;
			n--;m--;
		}
		res.reverse();
		
		return res.toString();
	}

}
