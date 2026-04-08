package practice;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		int[] ar = {6, 4, 2, 9, 8, 5};
		int n = ar.length;
		
		quickSort(ar, 0, n-1);
		System.out.println(Arrays.toString(ar));
	}

	private static void quickSort(int[] ar, int l, int h) {

		if(l<h) {
			int pivot = partion(ar, l, h);
			quickSort(ar, l, pivot-1);
			quickSort(ar, pivot+1, h);
		}
	}

	private static int partion(int[] ar, int l, int h) {
		int i = l-1;
		int pivot = ar[h];
		
		for(int j = l; j<h ; j++) {
			
			if(ar[j]<pivot)
			{
				i++;
				int temp= ar[i];
				ar[i]=ar[j];
				ar[j]=temp;
			}
		}
		
		int temp = ar[i+1];
		ar[i+1]=ar[h];
		ar[h]=temp;
		return i+1;
	}




}
