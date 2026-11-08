package leetcode;
/*
 * kadane's algorithm
 */
public class MaxSubarray_53 {

	public static void main(String[] args) {
		int[] ar = {-2,1,-3,4,-1,2,1,-5,4};
		int maxSubArray = maxSubArray(ar);
		System.out.println(maxSubArray);
		
	}
	
	public static int maxSubArray(int[] a) {
		int size = a.length;
       int sum = 0;
       int max =a[0];
       for(int i = 0 ; i<size ; i++) {
    	   sum+=a[i];
    	   max=Math.max(max, sum);
    	   if(sum<0) {
    		   sum=0;
    	   }
       }
       return max;
    }
	
//	public static int maxSubArray(int[] a) {
//		int size = a.length;
//        int max_so_far = Integer.MIN_VALUE, max_ending_here  = 0;
//
//        for (int i = 0; i < size; i++) {
//            max_ending_here = max_ending_here + a[i];
//            if (max_so_far < max_ending_here)
//                max_so_far = max_ending_here;
//            if (max_ending_here < 0)
//                max_ending_here = 0;
//        }
//        return max_so_far;
//    }
}
