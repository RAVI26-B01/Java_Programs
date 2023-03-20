package leetCode;

public class Number_Of_Pair_2023 {

	public static void main(String[] args) {
		String[] ar= {"1","1","1"};
		String  target = "11";
		int numOfPairs = numOfPairs(ar, target);
		System.out.println(numOfPairs);
	}

	 public static int numOfPairs(String[] nums, String target) {
	     int count=0;
	     
	     for(int i=0; i<nums.length ; i++) {
	    	 for(int j=0;j<nums.length ; j++) {
	    		 if(i!=j) {
	    			 if((nums[i]+nums[j]).equals(target))
	    				 count++;
	    		 }
	    	 }
	     }
		 return count;
	    }
}
