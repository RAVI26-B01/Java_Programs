package sliding_window;

import java.util.HashMap;

public class LongestSubArrayWithSumK {

	public static void main(String[] args) {
		int[] ar = {10, 20, 50, 30, 10, 20, 40};
		int k = 60;
		int longestSubArr = longestSubArr(ar, k);
		System.out.println(longestSubArr);
		
		int longestSubArrWithNegatives = longestSubArrWithNegatives(ar, k);
		System.out.println(longestSubArrWithNegatives);
	}

	/*
	 * below code only works for positive numbers
	 */
	private static int longestSubArr(int[] ar, int k) {
		int maxLen = 0;
		int left = 0, right = 0;
		int n = ar.length;
		int sum = 0;
		while(right < n) {
			sum+=ar[right];
			
			while(left<=right && sum>k)
			{
				sum-=ar[left];
				left++;
			}
			
			if(sum == k )
				maxLen = Math.max(maxLen, right -left + 1);
			right++;
		}
		
		return maxLen;
	}
	
	
	
	/*
	 * below code works for both positive and negative numbers
	 */
	private static int longestSubArrWithNegatives(int[] ar, int k) {
	    HashMap<Integer, Integer> prefixSumIndices = new HashMap<>();
	    prefixSumIndices.put(0, -1);  // prefix sum 0 at index -1
	    
	    int prefixSum = 0;
	    int maxLen = 0;
	    
	    for (int i = 0; i < ar.length; i++) {
	        prefixSum += ar[i];
	        
	        int requiredPrefix = prefixSum - k;
	        if (prefixSumIndices.containsKey(requiredPrefix)) {
	            int startIndex = prefixSumIndices.get(requiredPrefix);
	            int currentLen = i - startIndex;
	            if (currentLen > maxLen) {
	                maxLen = currentLen;
	            }
	        }
	        
	        // Only store the earliest index to maximize length of subarray
	        prefixSumIndices.putIfAbsent(prefixSum, i);
	    }
	    
	    return maxLen;
	}
}
