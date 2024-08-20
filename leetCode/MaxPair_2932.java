package leetcode;

public class MaxPair_2932 {

	public static void main(String[] args) {
		int[] ar = {1,9,2,4,5};
		int pairSum = maximumStrongPairXor(ar);
		System.out.println(pairSum);
	}
	
	public static int maximumStrongPairXor(int[] nums) {
		int max = 0;
	    for (int x : nums){
	        for (int y : nums) {
	            int temp = x ^ y;
	            if(temp < max){
	                continue;
	            }
	            int abs = Math.abs(x - y);
	            if (abs <= Math.min(x, y)) {
	                max = temp;
	            }
	        }
	
	    }
	    return max;
	   }
}
