package practice;

import java.util.Arrays;

public class example1 {
	public static void main(String[] args) {
		int[] ar = {3, 8, 1, -2, 7, 9, 12, 4};
		heapSort(ar);
		
		System.out.println(Arrays.toString(ar));
	}

	private static void heapSort(int[] ar) {
		int n = ar.length;
		 for(int i=n/2-1 ; i>=0; i--){
			 heapify(ar,n,i);
		 }
		 
		 for(int i = n-1 ; i>=0 ;i--) {
			 int temp = ar[0];
			 ar[0] = ar[i];
			 ar[i] = temp;
			 heapify(ar, i, 0);
		 }
	}

	private static void heapify(int[] ar, int n, int i) {
		
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		int largest = i ;
		
		if(l < n && ar[l] > ar[largest]) {
			largest = l ;
		}
		if(r < n  && ar[r] > ar[largest]) {
			largest = r  ;
		}
		
		if(i != largest) {
			int temp = ar[i];
			ar[i] = ar[largest];
			ar[largest] = temp;
			heapify(ar, n, largest);
		}
		
	}

	private static void insertionSort(int[] arr) {
		int j = 0;
		for(int i = 0 ; i<arr.length;  i++) {
			j=i;
			while(j>0 && arr[j-1] > arr[j]) {
				int t=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=t;
				--j;
			}
		}
		
	}

	private static void selectionSort(int[] ar) {
		
		for(int i = 0 ; i< ar.length ; i++) {
			
			int j = i;
			int smallest = i;
			while(j < ar.length) {
				if(ar[j] < ar[smallest]) {
					smallest = j;
				}
				j++;
			}
			
			int temp = ar[i];
			ar[i] = ar[smallest];
			ar[smallest] = temp;
		}
	}

	private static void bubbleSort(int[] ar) {

		for(int i = 0 ; i<ar.length-1; i++) {
			for(int j = 0 ; j< ar.length - 1- i ; j++) {
				if(ar[j]> ar[j+1]) {
					int temp = ar[j];
					ar[j]= ar[j+1];
					ar[j+1]= temp;
				}
			}
		}
		
	}
	
}