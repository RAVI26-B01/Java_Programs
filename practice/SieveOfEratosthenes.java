package practice;

import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		int n =30;
		printPrime(n);
	}

	private static void printPrime(int n) {
		
		int[] prime = new int[n+1];
		Arrays.fill(prime, 1);
		
		 for (int i = 2; i * i <= n; i++) {
			 if(prime[i] == 1 ) {
				 for (int j = i * i; j <= n; j += i)
	                    prime[j] = 0;
			 }
		 }
		 
		 for(int i = 2 ; i <=n ;i++) {
			 if(prime[i]==1)
				 System.out.print(i+" ");
		 }
	}
}
