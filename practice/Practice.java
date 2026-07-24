package practice;

import java.util.Arrays;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		
		int[] ar = {5,7,9,6,7,4,5,1,3,7};
				//	7,9,-1,7,-1,5,7,3,7,-1
		findNextLarge(ar);
		System.out.println(Arrays.toString(ar));
	
	}

	private static void findNextLarge(int[] ar) {
		Stack<Integer> stack = new Stack<>();
		int n = ar.length;
		
		for(int i = n-1 ; i >=0 ; i--) {
			int temp = ar[i];
			while(!stack.isEmpty() && stack.peek()<=temp)
				stack.pop();
			if(!stack.isEmpty())
				ar[i]=stack.peek();
			else
				ar[i]=-1;
			stack.push(temp);
		}
	}


}