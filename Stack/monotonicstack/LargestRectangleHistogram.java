package Stack.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		int largestRectangleArea = largestRectangleArea(heights); // TC O(5n) + SC O(2n)
		System.out.println(largestRectangleArea);
		
		int largestRectangleArea2 = largestRectangleArea2(heights); // TC O(2n) + SC O(n)
		System.out.println(largestRectangleArea2);
		
		int largestRectangleArea3 = largestRectangleArea3(heights); // TC O(2n) + SC O(n) using ArrayDeque
		System.out.println(largestRectangleArea3);
		
	}
	
	
	  public static int largestRectangleArea3(int[] heights) {
	        int n = heights.length;
	        Deque<Integer> stack = new ArrayDeque<>();
	        int maxArea = 0;
	        
	        for (int i = 0; i <= n; i++) {
	            int currHeight = (i == n) ? 0 : heights[i];
	            
	            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
	                int h = heights[stack.pop()];
	                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
	                maxArea = Math.max(maxArea, h * w);
	            }
	            
	            stack.push(i); // only drawback is adding invalid index at the last iteration (i==n)
	        }
	        
	        return maxArea;
	    }
	  
	private static int largestRectangleArea2(int[] heights) {
		int largest = 0;
		Stack<Integer> stack = new Stack<>();
		int n = heights.length;
		int[] pse = new int[n];
		
		for(int i = 0 ; i <heights.length ; i++) {
			
			while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
				int element = stack.peek();
				stack.pop();
				int ns = i;
				int ps = stack.isEmpty()?-1:stack.peek();
				largest = Math.max(largest, heights[element] * (ns-ps-1));
			}
			stack.push(i);
			
		}
		
		while(!stack.isEmpty()) {
			int element = stack.peek();
			stack.pop();
			int ns = n;
			int ps = stack.isEmpty()?-1:stack.peek();
			largest = Math.max(largest, heights[element] * (ns-ps-1));
		}
		return largest ;
	}









	public static int largestRectangleArea(int[] heights) {
		int largest = 0;
		int[] nse = nse(heights); // TC O(2n) + SC O(n)
		int[] pse = pse(heights); // TC O(2n) + SC O(n)
		
//		System.out.println(Arrays.toString(nse));
//		System.out.println(Arrays.toString(pse));
		
		for(int i = 0 ; i<heights.length; i++) // TC O(n)
			largest = Math.max(largest, heights[i] *(nse[i] - pse[i]-1) );
		return largest;
    }

	private static int[] pse(int[] heights) {
		int[] ps = new int[heights.length];
		Stack<Integer> stack = new Stack<>();
		int n = heights.length;
		
		for(int i = 0 ; i<n ; i++) {
			
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			
			if(!stack.isEmpty()) {
				ps[i]= stack.peek();
			}else {
				ps[i]=-1;
			}
			stack.push(i);
		}
		
		return ps;
	}

	private static int[] nse(int[] heights) {
		int[] ns = new int[heights.length];
		Stack<Integer> stack =  new Stack<>();
		int n = heights.length;
		
		for(int i = n-1 ; i>=0 ; i-- ) {
			
			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
				stack.pop();
			
			if(!stack.isEmpty()) {
				ns[i]=stack.peek();
			}else {
				ns[i]=n;
			}
			stack.push(i);
		}
		
		return ns;
	}
}
