package Stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NearestLeftSmallerElement {

	public static void main(String[] args) {

		int[] ar = {5,7,9,6,7,4,5,1,3,7};
		int[] nearestSmallElement = nearestSmallElement(ar);
		System.out.println(Arrays.toString(nearestSmallElement));
	}

	private static int[] nearestSmallElement(int[] ar) {
		
		Stack<Integer> stack = new Stack<>();
		int[] pse = new int[ar.length];
		for(int i = 0 ; i<ar.length ; i++) {
			
			while(!stack.isEmpty() && stack.peek()>ar[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				pse[i]=-1;
			}else {
				pse[i]=stack.peek();
			}
			stack.push(ar[i]);	
		}
		
		return pse;
	}

}
