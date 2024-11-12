package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange_228 {

	public static void main(String[] args) {
		int[] nums= {0,2,3,4,6,8,9};
		//["0->2","4->5","7"]
		
		// [0,2,3,4,6,8,9]
		// ["0","2->4","6","8->9"]
		List<String> summaryRanges = summaryRanges(nums);
		System.out.println(summaryRanges);

	}

	private static List<String> summaryRanges(int[] nums) {
		int start = nums[0];
		int end = nums[0];
		
		List<String> ans = new ArrayList<String>();
		
		
		for(int i=1 ; i<nums.length;i++) {
			if(nums[i] == 1+nums[i-1]) {
				end=nums[i];
			}else if(start==end){
				ans.add(""+start);
				start=nums[i];
				end=nums[i];
			}else {
				ans.add(start+"->"+end);
				start=nums[i];
				end=nums[i];
			}
			
		}
		if(start==end){
			ans.add(""+start);
		}else {
			ans.add(start+"->"+end);
		
		
		
		
	}
		return ans;
}
}
