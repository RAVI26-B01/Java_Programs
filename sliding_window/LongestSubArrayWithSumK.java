package sliding_window;

public class LongestSubArrayWithSumK {

	public static void main(String[] args) {
		int[] ar = {10, 20, 50, 30, 10, 20, 40};
		int k = 60;
		int longestSubArr = longestSubArr(ar, k);
		System.out.println(longestSubArr);
	}

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
}
