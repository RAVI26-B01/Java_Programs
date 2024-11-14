package leetcode;

public class MinRotatedBinarySearch_153 {

	public static void main(String[] args) {
		int[] arr1 = {3,4,5,1,2}; 
		System.out.println(findMin(arr1));
	}

	private static int findMin(int[] arr1) {
		int low = 0; int high = arr1.length-1;
		int min = Integer.MAX_VALUE;
		while(low <=high) {
			int mid = (low+high)/2;
			
			//search space is already sorted      
            //then arr[low] will always be
            //the minimum in that search space:
			//i.e arr[low]<= arr[mid] && arr[mid]<=arr[high]==> arr[low]<=arr[high]
            if (arr1[low] <= arr1[high]) {
                min = Math.min(min, arr1[low]);
                break;
            }

            
			if(arr1[low]<=arr1[mid]) { //left is sorted
				min = Math.min(min, arr1[low]);
				low = mid+1;
			}else { // right is sorted
				min = Math.min(min, arr1[low]);
				high = mid-1;
			}
		}
		return min;
	}
}
