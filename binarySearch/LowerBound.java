package binarySearch;

/*
 The lower bound algorithm finds the first or the smallest index in a sorted array
 where the value at that index is greater than or equal to a given key i.e. x.
 The lower bound is the smallest index, ind, where arr[ind] >= x
 */
public class LowerBound {

	public static void main(String[] args) {
		int[] arr = {3, 5, 8, 15, 19};
        int n = 5, x = 9;
        int ind = lowerBound(arr, n, x);
        System.out.println("The lower bound is the index: " + ind);
	}

	private static int lowerBound(int[] arr, int n, int x) {
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
}
