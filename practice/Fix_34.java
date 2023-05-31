package practice;

import java.util.Arrays;

public class Fix_34 {

	public static void main(String[] args) {

		int[] ar = {1, 3, 1, 4, 4, 3, 1,5}; //1 3 4 1 1 3 4
		
		System.out.println(Arrays.toString(fix34(ar)));
	}

	private static int[] fix34(int[] ar) {
		
		int n= ar.length;
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ;j++) {
				if(ar[j]==3 && ar[i]==4) {
					int temp= ar[i];
					ar[i]=ar[j+1];
					ar[j+1]=temp;
				}
			}
		}
		
		return ar;
		
	}

}
