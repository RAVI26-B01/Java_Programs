package recursion.codingbat;

public class GroupSum {

	public static void main(String[] args) {
		boolean groupSum = groupSum(0, new int[] {10,2,2,5}, 17);
		System.out.println(groupSum);
	}
	
	public static boolean groupSum(int start, int[] nums, int target) {
		  if (start >= nums.length)
			  return (target == 0);
		  
		  
		  if (groupSum(start + 1, nums, target - nums[start])) 
			  return true;
		  
		  if (groupSum(start + 1, nums, target)) 
			  return true;
		  return false;
	}
}
