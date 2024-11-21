package leetcode;

public class RotationalBinarySearch_33 {

	public static void main(String[] args) {
		int[] ar = {6, 7, 8 , 1, 2, 3, 4, 5};
		int target =7;
		int search = search(ar, target);
		System.out.println(search);
		
		int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findMin(arr);
        
        System.out.println("The minimum element is: " + ans );
        
        int rotateTimes = findRotateTimes(arr);
        System.out.println("The Rotated Times: " + rotateTimes ); // => fetch the index of lowest element == rotated times
        
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
	
    public static int findMin(int []arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }
            
            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }


    private static int findRotateTimes(int[] arr) {

        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index  = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum
            if (arr[low] <= arr[high]) {
            	if(ans > arr[low])
            	{
            		ans = arr[low];
            		index = low;
            	}
                break;
            }
            
            if (arr[low] <= arr[mid]) {
            	if(ans > arr[low])
            	{
            		ans = arr[low];
            		index = low;
            	}
                low = mid + 1;

            } else { //if right part is sorted:
            	if(ans > arr[mid])
            	{
            		ans = arr[mid];
            		index = mid;
            	}
                high = mid - 1;
            }
        }
        return index;
    
	}
    
}
