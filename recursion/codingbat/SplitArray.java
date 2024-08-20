package recursion.codingbat;

public class SplitArray {
	public static void main(String[] args) {
		int[] nums= {4, 1, 1, 2};
		System.out.println(splitArrayHelper(0, nums, 0, 0));
	}


public static boolean splitArrayHelper(int start, int[] nums, int group1, 
	    int group2) {
	    if(start >= nums.length)
	        return group1 == group2;
	            
	    if(splitArrayHelper(start+1, nums, group1 + nums[start], group2))
	        return true;
	                      
	    if(splitArrayHelper(start+1, nums, group1, group2 + nums[start]))
	        return true;
	                                
	    return false;
	}
}