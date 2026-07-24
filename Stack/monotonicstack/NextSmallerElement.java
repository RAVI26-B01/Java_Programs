package Stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		int[] ar = {5,7,9,6,7,4,5,1,3,7};
		int[] nextSmallerElement = nextSmallerElement(ar);
		System.out.println(Arrays.toString(nextSmallerElement));
	}
	
	private static int[] nextSmallerElement(int[] ar) {

	    Stack<Integer> stack = new Stack<>();
	    int[] nse = new int[ar.length];

	    for (int i = ar.length - 1; i >= 0; i--) {

	        while (!stack.isEmpty() && stack.peek() >= ar[i]) {
	            stack.pop();
	        }

	        if (stack.isEmpty()) {
	            nse[i] = -1;
	        } else {
	            nse[i] = stack.peek();
	        }

	        stack.push(ar[i]);
	    }

	    return nse;
	}
}
