package leetcode;

import java.util.Arrays;

public class SortColor_75 {

	public static void main(String[] args) {

		int[] ar = {2,0,2,1,1,0, 1,0};
		sortColors(ar);

	}
	
	   public static void sortColors(int[] nums) {
	        int i=0;
	        int j= nums.length - 1;
	        int k=0;
	        while(k<=j ){
	            if(nums[k]==0){
	            	int temp = nums[k];
	            	nums[k] = nums[i];
	            	nums[i]= temp;
	            	i++;
	            	k++;
	            }
	            else if( nums[k] == 1){
	            	k++;
	            }
	            else {

	            	int temp = nums[k];
	            	nums[k] = nums[j];
	            	nums[j]= temp;
	            	j--;
	            }
	            
	        }
	        
	        System.out.println(Arrays.toString(nums));
	    }

}
