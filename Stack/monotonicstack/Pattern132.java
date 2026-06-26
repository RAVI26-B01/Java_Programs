package Stack.monotonicstack;

import java.util.Stack;

public class Pattern132 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		
		System.out.println(find132pattern(nums));
	}

	 public static boolean find132pattern(int[] nums) {
		 
		 int second = Integer.MIN_VALUE;
		 Stack<Integer> stack = new Stack<>();
		 
		 int n = nums.length;
		 
		 for(int i = n-1 ; i>=0 ; i-- ) {
			 
			 if(nums[i]<second)
				 return true;
			 
			 while(!stack.isEmpty() && nums[i]>stack.peek()) {
				 second = stack.pop();
			 }
			 
			 stack.push(nums[i]);
		 }
		return false;
	       
	    }
	}