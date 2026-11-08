package Stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMin_907 {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 4 };
		int sum = sumSubarrayMins(arr);
		System.out.println(sum);
		
		int[] arr2 = { 1, 4, 6, 7, 3, 7, 8 , 1};
		int sum2 = sumSubarrayMins2(arr2);
		System.out.println(sum2);
	}
	
	// TC - O(n2)
	public static int sumSubarrayMins(int[] arr) {
		int sum = 0;
		int mod = (int)1e9+7;
		int n = arr.length;
		
		for(int i = 0; i <n ; i++ ) {
			int min = arr[i];
			for(int j = i ; j<n;j++) {
				min = Math.min(min, arr[j]);
				sum +=min;
			}
		}
		return sum % mod;
	}
	
	
	
	// TC - O(3N) 
	// SC - O(2N)
	public static int sumSubarrayMins2(int[] arr) {

	    int n = arr.length;
	    int mod = (int)1e9+7;

	    int[] pse = PSE(arr);
	    int[] nse = NSE(arr);
	    
	    System.out.println(Arrays.toString(pse));
	    System.out.println(Arrays.toString(nse));

	    long ans = 0;

	    for (int i = 0; i < n; i++) {

	        int left = i - pse[i];

	        int right;
	        if (nse[i] == -1) {
	            right = n - i;  // If there is no smaller element to the right then consider all the remaining element to the right
	        } else {
	            right = nse[i] - i;
	        }

	        ans = (ans + (long) arr[i] * left * right) % mod;
	    }

	    return (int) ans;
	}
	
	static int[] NSE(int[] arr) {
	    int n = arr.length;
	    int[] ans = new int[n];

	    Stack<Integer> st = new Stack<>();

	    for (int i = n - 1; i >= 0; i--) {

	        while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
	            st.pop();
	        }

	        ans[i] = st.isEmpty() ? -1 : st.peek();

	        st.push(i);
	    }

	    return ans;
	}
	
	static int[] PSE(int[] arr) {
	    int n = arr.length;
	    int[] ans = new int[n];

	    Stack<Integer> st = new Stack<>();

	    for (int i = 0; i < n; i++) {

	        while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
	            st.pop();
	        }

	        ans[i] = st.isEmpty() ? -1 : st.peek();

	        st.push(i);
	    }

	    return ans;
	}
}
