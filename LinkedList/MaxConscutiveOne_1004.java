package LinkedList;

/*
  Key hint :
  This question is basically asking maximum number of 0's 
  we can have in our window such that this number is less than or equal to k
 */
public class MaxConscutiveOne_1004 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k =2;
		int longestOnes = longestOnes(nums, k);
		System.out.println(longestOnes);
	}
	
	public static int longestOnes(int[] nums, int k) {
        int maxlen = 0;
        int len = 0 , l=0, r=0, zero=0;
        
        while(r<nums.length) {
        	if(nums[r] == 0)
        		zero++;
        	
        	while(zero>k) {
        		if(nums[l] == 0)
        			zero--;
        		l++;
        	}
        	
        	if(zero <= k) {
        		len = r-l+1;
        		maxlen = Math.max(maxlen, len);
        	}
        	
        	r++;
        }
        
	
        return maxlen;
	}
	
	
}
