package sorting;

import java.util.Arrays;

public class QuickSortLow {

	  public static void main(String[] args) {
	        int[] arr = {6, 4, 2, 9, 8, 5};

	        quickSort(arr, 0, arr.length - 1);
	        System.out.println(Arrays.toString(arr));
	    }
	
	  public static void quickSort(int[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            quickSort(arr, low, pi - 1);
	            quickSort(arr, pi + 1, high);
	        }
	    }

	    private static int partition(int[] arr, int low, int high) {
	        int pivot = arr[low];
	        int i = low + 1;
	        int j = high;

	        while (i <= j) {
	            while (i <= high && arr[i] <= pivot) {
	                i++;
	            }
	            while (arr[j] > pivot) {
	                j--;
	            }

	            if (i < j) {
	                swap(arr, i, j);
	            }
	        }

	        swap(arr, low, j);
	        return j;
	    }

	    private static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}