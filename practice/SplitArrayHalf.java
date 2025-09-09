package practice;

public class SplitArrayHalf {
	public static void main(String[] args) {
		int[] nums1= {2,3,4,1,2};
		int[] nums2 = {1,1,1,2,1};
		System.out.println(splitArray(nums1));
		System.out.println(splitArray(nums2));
	}
	
	public static boolean splitArray(int[] ar) {
		int lsum = 0;
		int rsum = 0;
		
		for(int i = 0 ; i<ar.length ; i++) {
			rsum +=ar[i];
		}
		for(int i = 0 ; i<ar.length ; i++) {
			lsum += ar[i];
			rsum -= ar[i];
			
			if(lsum == rsum)
				return true;
		}
		
		return false;
		
	}
}
