package leetcode;

public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] ar = {2,2,1,1,1,2,2};
        int x =  majorityElement(ar);
        System.out.println(x);
    }

    public static int majorityElement(int[] nums) {
      
        int el=-1;
         int count=0;
         for(int num:nums){
            if(count==0){
                el=num;count=1;
            }
            else if(num==el){
                count++;
            }
            else {count--;}
         }
     
        count=0;
         for(int i=0;i<nums.length;i++){
             if(nums[i]==el){
                 count++;
             }
         }
         if(count>(nums.length/2))
             return el;
         return -1;
     }
}
