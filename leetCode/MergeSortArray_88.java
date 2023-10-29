package leetcode;

import java.util.Arrays;

public class MergeSortArray_88 {

	public static void main(String[] args) {

		int[] ar1={1,2,3,0,0,0}, ar2={2,5,6};
		int m=3;
		int n=3;
		merge(ar1,m,ar2,n);
	}

	
	 public static void merge(int[] nums1, int m, int[] nums2, int n) { 
		 int a = m - 1;
	        int b = n - 1;
	        int c = m + n - 1;
	        
	        while (b >= 0) {
	            if (a >= 0 && nums1[a] > nums2[b]) {
	                nums1[c--] = nums1[a--];
	            } else {
	                nums1[c--] = nums2[b--];
	            }
	        }
     System.out.println(Arrays.toString(nums1));
}
}
