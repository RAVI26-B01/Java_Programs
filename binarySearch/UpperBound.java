package binarySearch;

/*
 The upper bound algorithm finds the first or the smallest index 
 in a sorted array where the value at that index is greater than the given key i.e. x.
 The upper bound is the smallest index, ind, where arr[ind] > x.
 */
public class UpperBound {
	public static void main(String[] args) {
		int[] arr = {3, 5, 8, 9, 15, 19};
        int n = 6, x = 9;
        int ind = upperBound(arr, x, n);
        System.out.println("The upper bound is the index: " + ind);
	}

	private static int upperBound(int[] arr, int x, int n) {
		int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
	}
}
