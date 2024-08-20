package recursion.codingbat;

public class GroupNoAdj {
	public static void main(String[] args) {
		boolean groupSum = groupAdj(0, new int[] {2, 5, 10, 4}, 12);
		System.out.println(groupSum);
	}

	private static boolean groupAdj(int start, int[] nums, int target) {
		  if (start >= nums.length)
			  return (target == 0);
		  
		  
		  if (groupAdj(start + 2, nums, target - nums[start])) 
			  return true;
		  
		  if (groupAdj(start + 1, nums, target)) 
			  return true;
		  return false;
	}
}
