package leetcode;

public class RemoveDuplicate_80 {

	public static void main(String[] args) {
		int[] ar = {0,0,1,1,1,1,2,3,3};
		int removeDuplicates = removeDuplicates(ar);
		System.out.println(removeDuplicates);
	
		int removeDuplicates2 = removeDuplicates2(ar);
		System.out.println(removeDuplicates2);
		

		int removeDuplicates3 = removeDuplicates3(ar);
		System.out.println(removeDuplicates3);
	}
	
	public static int removeDuplicates(int[] nums) {
		int n=nums.length;
		int k=1;
		int count=1;
		for(int i=1;i<n;i++)
		{
			if(nums[i]!=nums[i-1])
			{
				nums[k]=nums[i];
				k++;
				count=1;
			}
			else if(count<2){
				nums[k]=nums[i];
				k++;
				count++;
			}
		}
		return k;
    }
	
	public static int removeDuplicates2(int[] nums) {
	       if (nums.length <= 2) {
	            return nums.length;
	        }

	        int i = 1; // Pointer for the position of the last valid element
	        for (int j = 2; j < nums.length; j++) {
	            if (nums[j] != nums[i - 1]) {
	                i++;
	                nums[i] = nums[j];
	            }
	        }
	        return i + 1; // Number of valid elements
	    }
	
	public static int removeDuplicates3(int[] nums) {
        int k = 2;
        for( int i = 2; i < nums.length; i++){
            if( nums[i] != nums[k-2]){
                
                nums[k++] = nums[i];

                }
            }
        
        return k ;
    }
}
