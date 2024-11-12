package leetcode;

public class ContainDuplicate_219 {
    public static void main(String[] args) {
        boolean x=  containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2);
       System.out.println(x);
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
  
  

}
