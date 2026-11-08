package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {

		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		Map<Boolean,List<Integer>> collect = listOfIntegers.stream().collect(Collectors.partitioningBy(x->x%2==0));
		System.out.println(collect);
		
	}

	private static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		
		for(int i = 0 ; i<n-2 ; i++) {
			 if(i>0 && nums[i]==nums[i-1])
				 continue;
			 if(nums[i]>0)
				 break;
			 
			 int j = i+1;
			 int k = n-1;
			 while(j<k) {
				 int sum = nums[i]+nums[j]+nums[k];
				 if(sum>0) {
					 k--;
				 }
				 else if(sum<0) {
					 j++;
				 }
				 else {
					 ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
					 j++;
					 k--;
					 
					 while(j<k && nums[j]==nums[j-1])
						 j++;
					 while(j<k && nums[k]==nums[k+1])
						 k--;
				 }
			 }
		}
		return ans;
	}
}








