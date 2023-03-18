package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
	 public static void main(String[] args) {
		
		 int ar[]={12,2,5,13,6,1,9};
		 Scanner scan=new Scanner(System.in);
			while(true) {
				System.out.println("press 1 to Bubble Sort");
				System.out.println("press 2 to Selection Sort");
				System.out.println("press 3 to Insertion Sort");
				System.out.println("press 4 to Merge Sort");
				System.out.println("press 5 to display");
				System.out.println("enter your choice");
				int choice=scan.nextInt();
				switch(choice) {
				case 1:bubble_sort(ar);break;
				case 2:selection_sort(ar);break;
				case 3:insertion_sort(ar);break;
				case 4:merge_sort(ar);break;
				default :System.out.println("program terminated :-((");System.exit(0);
				}
			}
	}

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
