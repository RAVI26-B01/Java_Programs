package binarySearch;

import java.util.Arrays;

public class FindFLoorCeil {
		
	public static void main(String[] args) {
		int a[]= {3, 4, 7, 8, 8, 10}, n=6, x=5;   
		int[] floorAndCeil = getFloorAndCeil(a,n,x);
		System.out.println(Arrays.toString(floorAndCeil));
		
		
		int a2[]= {3, 4, 4, 7, 8, 10}, n2=6, x2=8;   
		int[] floorAndCeil2 = getFloorAndCeil(a2,n2,x2);
		System.out.println(Arrays.toString(floorAndCeil2));
		
	}
	
	    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
	      int f = findFloor(arr, n, x); 
	        int c = findCeil(arr, n, x);
	        return new int[] {f, c};
	    }

	     static int findFloor(int[] arr, int n, int x) {
	        int low = 0, high = n - 1;
	        int ans = -1;

	        while (low <= high) {
	            int mid = (low + high) / 2;
	            
	            if (arr[mid] <= x) {
	                ans = arr[mid];
	                low = mid + 1;
	            } else {
	                high = mid - 1; 
	            }
	        }
	        return ans;
	    }

	    static int findCeil(int[] arr, int n, int x) {
	        int low = 0, high = n - 1;
	        int ans = -1;

	        while (low <= high) {
	            int mid = (low + high) / 2;
	            if (arr[mid] >= x) {
	                ans = arr[mid];
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        }
	        return ans;
	    }
	    
	}
