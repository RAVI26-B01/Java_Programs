package leetcode;

import java.util.Arrays;

public class KokoBanana_875 {

	public static void main(String[] args) {
		int[] piles1 = {3,6,7,11};
		int h1 = 8;
		System.out.println(minEatingSpeed(piles1, h1));
		System.out.println(minEatingSpeed2(piles1, h1));
		
		int[] piles2 = {30,11,23,4,20};
		int h2 = 5;
		System.out.println(minEatingSpeed(piles2, h2));
		System.out.println(minEatingSpeed2(piles2, h2));
	}
	public static int minEatingSpeed(int[] v, int h) {
        int low = 1, high = findMax(v);

        //apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(v, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }
    
    
    //approach 2
    public static int minEatingSpeed2(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {
            int mid = low + (high - low) / 2;
            int hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}
