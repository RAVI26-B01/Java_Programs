package sliding_window;

// leetcode 1248  similar to leetcode 930
public class NiceSubArray {

	public static void main(String[] args) {
		int[] nums = {1,5,2,1,3,7};
		int goal = 3;
		int count = numberOfSubarrays(nums, goal);
		System.out.println(count);
		
		int count1 = numberOfSubarrays1(nums, goal);
		System.out.println(count1);
	}
	
	// approach 1
	 public static int numberOfSubarrays(int[] nums, int goal) {
	     int ans1 = countSubArray(nums,goal); 
	   int ans2 = countSubArray(nums, goal -1);
	   // System.out.println(ans1+ " "+ ans2);
	   return ans1- ans2;
	 }

	 private static int countSubArray(int nums[], int goal){
        int len = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        
         if(goal < 0)
        	 return 0;
         
         while(r < len){
            sum += nums[r] %2;
            while(sum > goal){
                sum -= nums[l] %2;
                l++;
            }
            count += r - l + 1;
            r++;
         }
         return count;
	  }
	 
	 
	 //approach 2
    public static int numberOfSubarrays1(int[] nums, int k) {

    	for(int i = 0 ; i < nums.length ; i++){
            nums[i] %= 2;
        }
        
        int []prefix = new int [nums.length + 1];
        prefix[0] = 1;
        int sum = 0 ;
        int ans = 0;
        
        for(int num : nums){
            sum = sum + num;
            if(sum >= k){
                 ans = ans + prefix[sum - k];
            }
            prefix[sum]++;
        }
        return ans;
    }
		  
	    
}
