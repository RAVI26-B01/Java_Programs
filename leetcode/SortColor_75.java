package leetcode;

import java.util.Arrays;

public class SortColor_75 {

	public static void main(String[] args) {

		int n = 41;
		System.out.println(steps(n));

	}
	
	   private static int steps(int n) {
		return helper(n , 0);
	}

	private static int helper(int n, int c) {
		if(n==0)
			return c;
		if(n%2 == 0)
			return helper(n/2, c+1);
		else
			return helper(n-1, c+1);
	}

	private static int sumOfDigits(int n) {
		   if(n <= 0 )
			   return 0;
		   
		return sumOfDigits(n/10)+ n%10;
	}

	public static void sortColors(int[] ar) {
			int n = ar.length;
			int low = 0 ;
			int high = n-1;
			int mid = 0;
			
			while(mid<=high) {
				if(ar[mid]==0){
					int temp = ar[low];
					ar[low]=ar[mid];
					ar[mid]=temp;
					low++;mid++;
				}
				else if(ar[mid]==1){
					mid++;
				}
				else{
					int temp = ar[high];
					ar[high]=ar[mid];
					ar[mid]=temp;
					high--;
				}
			}
		}

}
