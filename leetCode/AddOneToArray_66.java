package leetcode;

import java.util.Arrays;

public class AddOneToArray_66 {

	public static void main(String[] args) {
		int[] ar = {9};
		int[] addOne = addOne(ar);
		System.out.println(Arrays.toString(addOne));
	}

	private static int[] addOne(int[] ar) {
		
		int n = ar.length;
		int carry=0;
		for(int i=n-1 ; i>=0 ; i--){
			if(ar[i]!=9){
				ar[i]++;
				return ar;
			}else{
				ar[i]=0;
			}
		}
		
		int[] newArr = new int[n+1];
		newArr[0]=1;
		return newArr;
		
	}

}
