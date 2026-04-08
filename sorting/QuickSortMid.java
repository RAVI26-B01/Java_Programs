package sorting;

import java.util.Arrays;

public class QuickSortMid {

	    public static void main(String[] args) {
	        int[] arr = {6, 4, 2, 9, 8, 5};

	        quickSort(arr, 0, arr.length - 1);
	        System.out.println(Arrays.toString(arr));
	    }

	    private static void quickSort(int[] arr, int low, int high) {
	        if (low < high) {
	            int p = partition(arr, low, high);
	            quickSort(arr, low, p);
	            quickSort(arr, p + 1, high);
	        }
	    }

	    // Pivot = middle element
	    private static int partition(int[] arr, int low, int high) {
	        int pivot = arr[low + (high - low) / 2];
	        int i = low - 1;
	        int j = high + 1;

	        while (true) {
	            do {
	                i++;
	            } while (arr[i] < pivot);

	            do {
	                j--;
	            } while (arr[j] > pivot);

	            if (i >= j) {
	                return j;
	            }

	            swap(arr, i, j);
	        }
	    }

	    private static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}

