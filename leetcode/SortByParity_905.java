package leetcode;

import java.util.Arrays;

public class SortByParity_905 {

	public static void main(String[] args) {
		int[] parity = {3, 2, 1, 4};
		
		System.out.println(Arrays.toString(sortArrayByParity(parity)));

	}
	
	public static int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j = nums.length-1;
        int[] res  = new int[nums.length];
       
       for(int k=0 ; i<=j ; k++){
           if(nums[k] % 2 ==0){
               res[i]=nums[k];
               i+=1;
           }else{
               res[j]=nums[k];
               j-=1;
           }
       }
        return res;
    }

}
