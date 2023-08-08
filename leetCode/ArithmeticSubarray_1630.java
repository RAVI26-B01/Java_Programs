package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarray_1630 {

	 public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		 List<Boolean> ans = new ArrayList<Boolean>();
		 for(int i=0 ; i<l.length ;i++) {
			 int[] copyOfRange = Arrays.copyOfRange(nums, l[i], r[i]+1);
			 Arrays.sort(copyOfRange);
			 Boolean checkArithmetic = checkArithmetic(copyOfRange,copyOfRange[0]-copyOfRange[1]);
			 ans.add(checkArithmetic);
		 }
		
		return ans;
	        
	    }
	
	private static Boolean checkArithmetic(int[] copyOfRange, int diff) {
		for(int i=1 ; i<copyOfRange.length-1 ;i++) {
			if(copyOfRange[i]-copyOfRange[i+1]!=diff) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
		int[] l= {0,1,6,4,8,7};
		int[] r= {4,4,9,7,9,10};
		
		List<Boolean> checkArithmeticSubarrays = checkArithmeticSubarrays(nums,l,r);
		System.out.println(checkArithmeticSubarrays);
	}

}
