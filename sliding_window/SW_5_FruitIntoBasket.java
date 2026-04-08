package sliding_window;

import java.util.HashMap;
import java.util.Map;

// leetcode 904
public class SW_5_FruitIntoBasket {

	public static void main(String[] args) {
		int[] ar = {3, 3, 5, 3, 5, 4, 3, 3};
		int totalFruit = totalFruit(ar);
		System.out.println(totalFruit);
	}
	
	public static int totalFruit(int[] fruits) {
		int f = -1; // first fruit type
        int s = -1; // second fruit type

        int l = 0; // left pointer
        int r = 0; // right pointer
        int ans = 0;

        while (r < fruits.length) {
            if (f == -1 || fruits[r] == fruits[f]) { // no fruit or  first same fruit
                f = r;
            } else if (s == -1 || fruits[r] == fruits[s]) { // no fruit or  second same fruit
                s = r;
            } else {
                // When a new fruit type is encountered
                if (f < s) {
                    l = f + 1;
                    f = r;
                } else {
                    l = s + 1;
                    s = r;
                }
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
        
    }
	
	public static int totalFruit1(int[] fruits) {
	    Map<Integer, Integer> countMap = new HashMap<>();
	    int l = 0, maxLen = 0;

	    for (int r = 0; r < fruits.length; r++) {
	        countMap.put(fruits[r], countMap.getOrDefault(fruits[r], 0) + 1);

	        // Shrink the window if we have more than 2 distinct fruits
	        while (countMap.size() > 2) {
	            int leftFruit = fruits[l];
	            countMap.put(leftFruit, countMap.get(leftFruit) - 1);
	            if (countMap.get(leftFruit) == 0) {
	                countMap.remove(leftFruit);
	            }
	            l++;
	        }

	        maxLen = Math.max(maxLen, r - l + 1);
	    }

	    return maxLen;
	}
}
