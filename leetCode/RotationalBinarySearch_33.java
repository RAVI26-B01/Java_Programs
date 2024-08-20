package leetcode;

public class RotationalBinarySearch_33 {

	public static void main(String[] args) {
		int[] ar = {3,1};
		int target =1;
		int search = search(ar, target);
		System.out.println(search);
	}

	private static int search(int[] nums, int target) {

		int s = 0 ;
		int e = nums.length-1;
		while(e>=s) {
			int mid = s+(e-s)/2;
			if(nums[mid] == target)
				return mid;
			
			if(nums[s] <= nums[mid]) { //sorted first half
				if(target >= nums[s] && target <nums[mid] )
				{
					e= mid-1; 
				}
				else {
					s=mid+1;
				}
			}else {
				if(target<=nums[e] && target >nums[mid])
				{
					s= mid+1;
				}
				else {
					e=mid-1;
				}
			}
		}
		return -1;
		
		
	}
}
