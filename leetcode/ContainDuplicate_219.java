package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainDuplicate_219 {
    public static void main(String[] args) {
        boolean x=  containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2);
       System.out.println(x);
       boolean ans1=  containsNearbyDuplicate2(new int[]{1,2,4,5,6,6},2);
       System.out.println(ans1);
       boolean ans2=  containsNearbyDuplicate2(new int[]{1,2,3,1},3);
       System.out.println(ans2);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0 ;i<nums.length;i++){
            int j=i+1;
            while( j<=i+k && j<nums.length){
                if(nums[i]==nums[j++])
                    return true;
                
            }   
        }
        return false;
    }
  
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
       for (int i = 0; i < nums.length; i++) {
           if (i > k) {
               set.remove(nums[i - k - 1]);
           }
           if (!set.add(nums[i])) {
               return true;
           }
       }
       return false;
   }
  

}
