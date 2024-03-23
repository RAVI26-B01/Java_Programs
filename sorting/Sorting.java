package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
	 public static void main(String[] args) {
		
		 int ar[]={8, 4, 5, 9, 2, 11, 6, 7};
		 Scanner scan=new Scanner(System.in);
			while(true) {
				System.out.println("press 1 to Bubble Sort");
				System.out.println("press 2 to Selection Sort");
				System.out.println("press 3 to Insertion Sort");
				System.out.println("press 4 to Merge Sort");
				System.out.println("press 5 to Heap Sort");
				System.out.println("press 6 to Quick Sort");
				System.out.println("enter your choice");
				int choice=scan.nextInt();
				switch(choice) {
				case 1:bubble_sort(ar);break;
				case 2:selection_sort(ar);break;
				case 3:insertion_sort(ar);break;
				case 4:merge_sort(ar);break;
				case 5:heap_sort(ar);break;
				case 6:quick_sort(ar);break;
				default :System.out.println("program terminated :-(("); scan.close();System.exit(0);
				}
				
			}
			
	}

	 private static void quick_sort(int[] ar) {
		quickSort(ar, 0 , ar.length-1);
		System.out.println(Arrays.toString(ar));
	}

	private static void quickSort(int[] ar, int low, int hi) {
		if(low>hi)
			return;
		int start = low;
		int end = hi;
		int mid = low + (hi-low)/2;
		int pivot = ar[mid];
		while(start<=end){

			while(ar[start]< pivot)
			{
				start++;
			}
			while(ar[end]> pivot)
			{
				end--;
			}
			if(start<=end){
				int temp = ar[start];
				ar[start]= ar[end];
				ar[end] = temp;
				start++;
				end--;
			}
			
		}
		quickSort(ar, low, end);
		quickSort(ar, start, hi);
	}

	/*
	  * Heap sort starts
	  */
	 private static void heap_sort(int[] ar) {
		 int n=ar.length;
		 for(int i=n/2-1 ; i>=0; i--){
			 heapify(ar,n,i);
		 }
		 
		 for( int i=n-1 ; i>=0 ; i--){
			 int temp=ar[0];
			 ar[0]=ar[i];
			 ar[i]=temp;
			 heapify(ar,i,0);
		 }
		 System.out.println(Arrays.toString(ar));
	 }
	 
	 private static int[] heapify(int[] ar, int n, int i) {
		
		 int left = 2 * i + 1;
		 int right = 2 * i + 2;
		 int largest = i;
		 
		 if(left < n && ar[left]>ar[largest]){
			 largest = left;
		 }
		 if(right < n && ar[right]>ar[largest]){
			 largest = right;
		 }
		 
		 if(largest !=i ){
			 int temp = ar[largest];
			 ar[largest] = ar[i];
			 ar[i] = temp;
			 heapify(ar,n,largest);
		 }
		 return ar;
	 }
	 /*
	  * Heap sort ends
	  */

	/*
	  * Merge sort starts
	  */
	private static void merge_sort(int[] ar) {
		int n=ar.length;
		divide(ar,0,n-1);
		System.out.println(Arrays.toString(ar));
	}
	
	private static void divide(int[] ar, int si, int ei) {
		if(si >= ei){
			return;
		}
		int mid= si+(ei-si)/2;
		divide(ar, si, mid);
		divide(ar, mid+1, ei);
		conquer(ar, si, mid, ei);
	}

	private static void conquer(int[] ar, int si, int mid, int ei) {
		int[] merged = new int[ei-si+1];
		int indx1 = si;
		int indx2 = mid+1;
		int k=0;
		
		while(indx1 <= mid && indx2 <= ei){
			if(ar[indx1] <= ar[indx2]){
				merged[k++]=ar[indx1++];
				//k++;indx1++;
			}else{
				merged[k++]=ar[indx2++];
			}
		}
		
		while(indx1 <= mid){
			merged[k++]=ar[indx1++];
		}
		
		while(indx2 <= ei){
			merged[k++]=ar[indx2++];
		}

		for(int i=0,j=si; i<merged.length; i++,j++){
			ar[j]=merged[i];
		}
	}
	/*
	 * Merged sort ended
	 */
	
	
	
	/*
	 * all items to the left are smaller
	 */
	private static void insertion_sort(int[] arr) {
		
			int item,j;
			for(int i=0 ; i<arr.length ; i++) {
				item=arr[i];
				for( j=i-1 ; j>=0 && arr[j]>item ; --j) {
					arr[j+1]=arr[j];
				}
				arr[j+1]=item;
//				j=i-1;
//				while(j>=0 && arr[j]>item) {
//					int t=arr[j+1];
//					arr[j+1]=arr[j];
//					arr[j]=t;
//					--j;
//				}
			}
			System.out.println(Arrays.toString(arr));
	}

	
	private static void selection_sort(int[] ar) {
		int k=0,j;
		for(int i=0;i<ar.length ;i++){
			k=i;
			for(j=i;j<ar.length;j++){
				if(ar[k]>ar[j]){
					k=j;
				}
			}
			int smallNum=ar[k];
			ar[k]=ar[i];
			ar[i]=smallNum;
		}
		System.out.println(Arrays.toString(ar));
	}

	private static void bubble_sort(int[] ar) {
		
		for(int i=0;i<ar.length-1 ;i++){
			for(int j=0; j<ar.length-1-i ;j++){
				if(ar[j]>ar[j+1]){
					int temp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(ar));
	}
}
