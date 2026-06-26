package Stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestElement2 {
	public static void main(String[] args) {
		int[] ar = {1,2,3,8,4,6};
		int n = ar.length;
		int[] ans = new int[n];
		
		Stack<Integer> stack = new Stack<>();
		
		/*
		    Conceptually:
			1 2 3 8 4 6 | 1 2 3 8 4 6
		 */
		for(int i = (2 * n)-1 ; i>=0 ; i--) {
			
			while(!stack.isEmpty() && ar[i%n]>=stack.peek()) {
				stack.pop();
			}
			if(i<n) {
				if(stack.isEmpty()) {
					ans[i]=-1;
				}else {
					ans[i]=stack.peek();
				}
				
			}
			
			stack.push(ar[i%n]);
		}
		
		System.out.println(Arrays.toString(ans));
	}
}
