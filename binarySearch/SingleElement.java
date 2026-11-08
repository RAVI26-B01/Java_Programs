package binarySearch;

public class SingleElement {

	public static void main(String[] args) {
		int[]  nums = {1,1,2,3,3,4,4,8,8};
		System.out.println(singleNonDuplicate(nums));
		int[] nums2 = {3,3,7,7,11,11,12,13,13};
		System.out.println(singleNonDuplicate(nums2));
		
	}
	
	// (even, odd) == same --> element lies on right half
	// (odd, even) == same --> element lies on left half
	public static int singleNonDuplicate(int[] nums) {
        // initilaize the left and right pointer
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            // if mid is odd, decrement it to make it even
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1)
                mid--;

            // if the elements at mid and mid + 1 are the same, 
            // then the single element must
            // appear after the midpoint
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            }
            // otherwise, we must search for the 
            // single element before the midpoint
            else {
                r = mid;
            }
        }
        return nums[l];
    }
}
