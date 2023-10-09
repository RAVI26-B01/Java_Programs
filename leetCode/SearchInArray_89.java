package leetcode;

public class SearchInArray_89 {
	public static void main(String[] args) {
		int nums[] = {1,2,2,3,5,6,0,0}, target = 1;
		boolean search = search(nums,target);
		System.out.println(search);
	}
	
	
    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) 
            	return true;

            if (nums[low] == nums[mid]) {
                low++;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) 
                	high = mid - 1;
                else 
                	low = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[high])
                	low = mid + 1;
                else 
                	high = mid - 1;
            }
        }
        return false;
    }
}
