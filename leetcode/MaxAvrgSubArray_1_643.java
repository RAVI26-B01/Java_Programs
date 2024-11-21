package leetcode;

public class MaxAvrgSubArray_1_643 {

	public static void main(String[] args) {
		int[] nums = {0,1,1,3,3};
		int k = 4;
		
		System.out.println(findMaxAverage(nums, k));
	}
	
	 public static double findMaxAverage(int[] nums, int k) {
		 int r = 0; int l = 0; int sum = 0;
		 double avg = Integer.MIN_VALUE;
		 int j = k-1;
		 while(r<k) {
			 sum+=nums[r];
			 r++;
		 }
		 
		 while(j != nums.length) {
	         double currentAvrg =(double)  sum/k;
			 avg = Math.max(avg, currentAvrg);
			 
			 sum =sum -nums[l];
			 j++;
			 l++;
			 if(j != nums.length) // checking after j increment still valid index or not
				 sum+=nums[j];
		 }
		return avg;
	 }
}
