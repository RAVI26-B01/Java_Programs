package Stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestElement {

	public static void main(String[] args) {
		int[] ar = {1,2,3,8,4,6,12,4,16};
		int n = ar.length;
		int[] ans = new int[n];
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = n-1 ; i>=0 ; i--) {
			
			while(!stack.isEmpty() && ar[i]>stack.peek()) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				ans[i]=-1;
			}else {
				ans[i]=stack.peek();
			}
			stack.push(ar[i]);	
		}
		
		System.out.println(Arrays.toString(ans));
		
		
	}

}
