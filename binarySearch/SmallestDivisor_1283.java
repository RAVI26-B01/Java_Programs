package binarySearch;

public class SmallestDivisor_1283 {

	public static void main(String[] args) {
		int[] nums = {1,2,5,9};
		int threshold = 6;
		
		System.out.println(smallestDivisor(nums, threshold));
		
		int[] nums2 = {44,22,33,11,1};
		int threshold2 = 5;
		System.out.println(smallestDivisor(nums2, threshold2));
				
	}
	
	 public static int smallestDivisor(int[] nums, int threshold) {        
	        int n = nums.length;
			int start = 1;
			if(n > threshold) return -1;
	        //Find the maximum element:
	        int maxi = Integer.MIN_VALUE;
	        for (int i = 0; i < n; i++) {
	            maxi = Math.max(maxi, nums[i]);
	        }
	        
			int end = maxi;
			int ans =-1;
			while(start <= end) {
				int mid = (start+end)/2;
				int divisorSum = getDivisorSum(nums, mid);
				if(divisorSum<=threshold) {
					ans = mid;
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
			return ans; 
	    }
		
		public static int getDivisorSum(int[] nums, double n) {
			int sum = 0;
			for(int num:nums) {
				sum+=Math.ceil(num/n);
			}
			return sum;
		}
}
