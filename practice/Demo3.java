package practice;

import java.util.*;


 public class Demo3 {

	public static void main(String[] args) {
		int n =152;
		
		while(n%2==0)
		{
			n=n/2;
			System.out.print(2+" ");
		}
		
		for(int i = 3 ; i<Math.sqrt(n) ; i+=2) {
			while(n%i==0)
			{
				n=n/i;
				System.out.print(i+" ");
			}
		}
		
		if(n>2)
			System.out.print(n);
	}

}

