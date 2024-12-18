package binarySearch;

public class FindFloor {

	public static void main(String[] args) {
		int arr[] = {1, 2, 8, 10, 11, 12, 19};
		int k = 5;
		System.out.println(findFloor(arr, k ));
	}
	
	static int findFloor(int[] arr, int k) {
        int low = 0 ;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(k >= arr[mid])
            {
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}
