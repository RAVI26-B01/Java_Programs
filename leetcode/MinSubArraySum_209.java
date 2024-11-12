package leetcode;

public class MinSubArraySum_209 {

	public static void main(String[] args) {
		int ar[] = {2,3,1,2,4,1,1,3,1,1};
		int target = 7;
		int minSubArrayLen = minSubArrayLen(target, ar);
		System.out.println(minSubArrayLen);
		
	}
	
	    public static int minSubArrayLen(int target, int[] nums) {
	        int l = 0;
	        int r = 0;
	        int currSum = 0;
	        int minLen = Integer.MAX_VALUE;
	        while (r < nums.length) {
	            currSum += nums[r];
	            while (l <= r && currSum >= target) {
	                minLen = Math.min(minLen, r - l + 1);
	                currSum -= nums[l++];
	            }
	            ++r;
	        }
	        return minLen == Integer.MAX_VALUE ? 0 : minLen;
	    }

}

