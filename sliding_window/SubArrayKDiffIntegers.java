package sliding_window;

// leetcode 992
public class SubArrayKDiffIntegers {

	public static void main(String[] args) {
		int[] nums = {1,2,1,3,4};
		int k = 3;
		int count = subarraysWithKDistinct(nums, k);
		System.out.println(count);
	}
	
	public static int subarraysWithKDistinct(int[] nums, int k) {
		
		int count = helper(nums, k) ;
		int count2 = helper(nums, k-1);
		return count - count2;
       
	}
	
	public static int helper(int[] nums, int k){
		 int l = 0 ;
	        int r= 0 ;
	        int count = 0;
	        int maxLen = 0;
	        
	        if(k<0) {
	        	return 0;
	        }
	        int[] ar = new int[nums.length+1];
	        while(r<nums.length) {
	        	if(ar[nums[r]]==0) {
					count++;
				}
	        	ar[nums[r]]++;
	        	while(count>k) {
	        		ar[nums[l]]--;
	        		if(ar[nums[l]]==0) {
	    				count--;
	    			}
	        		l++;
	        	}
	    		maxLen = maxLen + r-l+1;
	        	r++;
	        }
	        return maxLen;
	}
}
