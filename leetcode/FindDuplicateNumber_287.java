package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber_287 {
	public static void main(String[] args) {
		int[] nums = {3,1,3,4,2}; 
		System.out.println(findDuplicateCyclic(nums));
		int[] nums1 = {3,1,3,4,2}; 
		System.out.println(findDuplicate(nums));
		findDuplicate(nums1);
		int[] nums2 = {3,1,3,4,2}; 
		System.out.println(findDuplicate2(nums2));
		int[] nums3 = {3,1,3,4,2}; 
		System.out.println(findDuplicate3(nums3));
	}
	
	 public static int findDuplicateCyclic(int[] nums) {
	        int slow = nums[0];
	        int fast = nums[0];
	        do{
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        }while(slow!=fast);

	        slow = nums[0];
	        while(slow != fast){
	            slow = nums[slow];
	            fast = nums[fast];
	        }

	        return slow;
	    }

	 public static int findDuplicate(int[] nums) {
	        for(int i=0;i<nums.length;i++){
	            int idx=Math.abs(nums[i]);
	            if(nums[idx]<0){
	                return idx;
	            }
	            nums[idx]=-nums[idx];
	        }
	        return -1;
	    }
	 
	 public static int findDuplicate2(int[] nums) {
        boolean[] count = new boolean[nums.length];
        for (int num : nums) {
            if (count[num]) 
            	return num;
            count[num] = true;
        }
        return 0;
    }
	 
	 public static int findDuplicate3(int[] nums) {
         Set<Integer> set = new HashSet<>();
         for (int i = 0; i < nums.length; i++) {
             if (set.contains(nums[i])) {
                 return nums[i];
             }
             set.add(nums[i]);
         }
         return 0;
     }

}
