package binarySearch;

/*
	Consider my rank was 5, but other student ranks were added in the middle. 
	As ranks 2, 3, 4, and 7 are better than my rank, my rank shifts accordingly to 6, 7, 8, and 9.
	Since rank 11 is not better than 9, my final rank remains 9.
*/
public class FindKthMissing_1539 {
	public static void main(String[] args) {
		int[] ar = { 2, 3, 4, 7, 11 };
		int kthMissing = findKthMissing(ar, 5);
		System.out.println(kthMissing);

		int kthMissing2 = findKthMissing2(ar, 5);
		System.out.println(kthMissing2);
	}

	// TC O(n)
	private static int findKthMissing(int[] ar, int k) {
		for (int i = 0; i < ar.length; i++) {

			if (ar[i] <= k) {
				k++;
			} else {
				break;
			}
		}
		return k;

	}

	// TC = O(logn)
	private static int findKthMissing2(int[] ar, int k) {
		int low = 0;
		int high = ar.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int missing = ar[mid] - (mid + 1);

			if (missing < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return high + 1 + k; // or return low+k
	}

}