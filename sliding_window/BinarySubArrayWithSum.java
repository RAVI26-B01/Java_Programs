package sliding_window;


// lletcode 930
public class BinarySubArrayWithSum {

	public static void main(String[] args) {
		int[] nums = {1, 0, 0, 1, 0, 1,0};
		int goal = 2;
		int count = numSubarraysWithSum(nums, goal);
		System.out.println(count);
	}
	
	/*
	 	TC : O(2*2N) ==> O(N)
	 	SC : O(1)
	 
	 */
	public static int numSubarraysWithSum(int[] nums, int goal) {
		// [ <= goal - <=goal-1 ] == goal
        int ans1 = countSubArray(nums,goal); 
        int ans2 = countSubArray(nums, goal -1);
        System.out.println(ans1+ " "+ ans2);
        return ans1- ans2;
    }
	
	/*
	 
	 below function find less than equal to goal(<= goal)
	 		
	 */
	 private static int countSubArray(int nums[], int goal){
	        int len = nums.length;
	        int l = 0;
	        int r = 0;
	        int sum = 0;
	        int count = 0;
	        
	         if(goal < 0)
	        	 return 0;
	         
	         while(r < len){
	            sum += nums[r];
	            while(sum > goal){
	                sum -= nums[l];
	                l++;
	            }
	            count += r - l + 1;
	            r++;
	         }
	         return count;
	    }
	    
}
