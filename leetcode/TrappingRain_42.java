package leetcode;

public class TrappingRain_42 {

	public static void main(String[] args) {
		int ar[]= {4,2,0,3,2,2};
		int waterFillCount = waterFillCount(ar);
		System.out.println(waterFillCount);
	}

	//O(n) Time and O(1) Space:
	private static  int waterFillCount(int[] height) {
		int left = 0, right = height.length - 1;
    int l_max = 0, r_max = 0;

    int res = 0;
    while (left < right) {
        l_max = Math.max(l_max, height[left]);
        r_max = Math.max(r_max, height[right]);

        if (l_max < r_max) {
            res += l_max - height[left];
            left++;
        } else {
            res += r_max - height[right];
            right--;
        }
    }
    return res;
    }
	
	
	//O(n) Time and O(n) Space
		/*
		 	Consider arr[] = {3, 0, 2, 0, 4}
			Therefore, left[] = {3, 3, 3, 3, 4} and right[] = {4, 4, 4, 4, 4}
		 */
		 static int findWater(int[] arr) {
		        int n = arr.length;
		        // Left[i] contains height of tallest bar to the
		        // left of i'th bar including itself
		        int[] left = new int[n];

		        // Right[i] contains height of tallest bar to
		        // the right of i'th bar including itself
		        int[] right = new int[n];

		        int res = 0;

		        left[0] = arr[0];
		        for (int i = 1; i < n; i++)
		            left[i] = Math.max(left[i - 1], arr[i]);

		        right[n - 1] = arr[n - 1];
		        for (int i = n - 2; i >= 0; i--)
		            right[i] = Math.max(right[i + 1], arr[i]);

		        for (int i = 1; i < n - 1; i++) {
		            int minOf2 = Math.min(left[i - 1], right[i + 1]);
		            if (minOf2 > arr[i]) {
		                res += minOf2 - arr[i];
		            }
		        }
		        return res;
		    }
}
