package sliding_window;

//leetcode 1248
public class SubArrayKoddNums {
 
	public static void main(String[] args) {
		int[] nums = {2,2,2,1,2,2,1,2,2,2};
		int k = 2;
		int count = numberOfSubarrays(nums, k);
		System.out.println(count);
	}


	public static int numberOfSubarrays(int[] nums, int k) {
	    int n = nums.length;
	    int[] count = new int[n + 1];
	    count[0] = 1;
	    int result = 0, oddCount = 0;
	    for (int num : nums) {
	        oddCount += num & 1;
	        if (oddCount - k >= 0) {
	            result += count[oddCount - k];
	        }
	        count[oddCount]++;
	    }
	    return result;
	}

}