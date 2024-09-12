package practice;

import java.util.Arrays;

public class Demo3 {
	public static void main(String[] args) {

		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k =2;
		int longestOnes = longestOnes(nums, k);
		System.out.println(longestOnes);
	}

	private static int longestOnes(int[] nums, int k) {

	    int maxlen = 0;
        int len = 0 ;
        int l=0;
        int r=0;
        int zero=0;
	        
        while(r<nums.length)
        {
        	if(nums[r] == 0)
        		zero++;
        	while(zero>k) {
        		if(nums[l]==0)
        			zero--;
        		l++;
        	}
        	maxlen = Math.max(maxlen, r-l+1);
        	r++;
        }
	        
		return maxlen;
	}

}
