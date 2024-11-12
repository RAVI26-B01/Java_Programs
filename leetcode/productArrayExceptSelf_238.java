package leetcode;

import java.util.Arrays;

public class productArrayExceptSelf_238 {

	public static void main(String[] args) {
		int[] ar= {1, 2, 3, 4, 5};
		int[] productExceptSelf = productExceptSelf(ar);
		System.out.println(Arrays.toString(productExceptSelf));
	}
	
	/*
	 * approach-1 start
	 */
	 public static int[] productExceptSelf(int[] nums) {   
		 int[] result = new int[nums.length];
         int prod=1;

         for(int i=0;i<nums.length;i++){
             result[i]=prod;
             prod=prod*nums[i];
         }
        prod=1;
         for(int i=nums.length-1;i>=0;i--){
             result[i]=result[i]*prod;
             prod=prod*nums[i];
         }
		 return result;  
    }
	 /*
	 * approach-1 ends
	 */
	
	/*
	 * approach-2 start
	public static int[] productExceptSelf(int[] nums) {
		  int[] result = new int[nums.length];
		    for (int i = 0; i < result.length; i++) 
		    	result[i] = 1;
		    int left = 1, right = 1;
		    for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
		        result[i] *= left;
		        result[j] *= right;
		        left *= nums[i];
		        right *= nums[j];
		    }
		    return result;
	}
	
	* approach-2 ends
	*/
	
	 /*
	  * approach-3 start
	  * 
	 public static int[] productExceptSelf1(int[] nums) {
	       int[] newarr = new int[nums.length]; 
		  int n=nums.length;
	       for(int i=0 ; i<n ; i++) {
	    	  int p = getProduct(nums,0,i)*getProduct(nums,i+1,nums.length);
	    	  newarr[i]=p;
	       }
	       return newarr;
	   }

	private static int getProduct(int[] nums, int si, int ei) {
		int p=1;
		for(int i=si;i<ei;i++) {
			p=p*nums[i];
		}
		return p;
	}
	* approach-3 ends
	*/

	 
	 /*
		 int[] result = new int[nums.length];
         int prod=1;
         
         Arrays.fill(result, 1);

         for(int i=0;i<nums.length;i++){
             result[i]=result[i]*prod;
             prod=prod*nums[i];
         }
        prod=1;
         for(int i=nums.length-1;i>=0;i--){
             result[i]=result[i]*prod;
             prod=prod*nums[i];
         }
		 return result;  
	  
	  */
}
