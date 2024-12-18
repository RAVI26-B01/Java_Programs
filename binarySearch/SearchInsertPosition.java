package binarySearch;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 7};
        int x = 6;
        int ind = searchInsert(arr, x);
        System.out.println("The index is: " + ind);
        
        int ind2 = searchInsert2(arr, x);
        System.out.println("The index is: " + ind2);
	}

	//approach-1
	private static int searchInsert(int[] arr, int x) {
		int n = arr.length; // size of the array
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
	}
	
	//approach - 2
	public static int searchInsert2(int[] nums, int target) {
        int low = 0 ;
       int high = nums.length - 1;

       while(low <= high){
           int mid = (low + high) /2;
           if(nums[mid] == target)
               return mid;
           if(nums[mid] < target){
               low =  mid + 1;
           }
           else{
               high = mid - 1;
           }
       }
       return low;
   }
}
