package practice;

import java.util.Arrays;

public class MoveZerosToLeft {

	public static void main(String[] args) {

		int[] ar = {1, 0, 0, 1, 1, 0};
		int[] moveZeros = moveZeros(ar);
		System.out.println(Arrays.toString(moveZeros));
	}

	private static int[] moveZeros(int[] ar) {
		
		int j=0;
		for(int i=1 ; i<ar.length ;i++) {
			if(ar[j]==0) {
				j++;
			}else if (ar[i]==0) {
				int temp = ar[i];
				ar[i]=ar[j];
				ar[j] = temp;
				j++;
			}
		}
		return ar;
	}

}
