package sliding_window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
 * First negative integer in every window of size k
 */
public class FirstNegative {

	public static void main(String[] args) 
	{
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		int n = arr.length;
		int k = 3;
		List<Integer> negatives = getNegatives(arr, n , k);
		System.out.println(negatives);
	}

	private static List<Integer> getNegatives(int[] arr, int n, int k) {
		List<Integer> l = new ArrayList<>();
		Deque<Integer> dq = new LinkedList<>();
		int i=0 ;
		for(; i<k;i++) {
			if(arr[i]<0)
				dq.add(i);
		}
				
		for( ; i<n ; i++) {
			
			 // if deque is not empty then the element 
	         // at the front of the queue is the first 
	        // negative integer of the previous window
			if(!dq.isEmpty()) {
				l.add(arr[dq.peek()]);
			}else {
				l.add(0);
			}
				
			// Remove the elements which are
	        // out of this window
			while(!dq.isEmpty() && dq.peek()< i-k+1) {
				dq.poll();
			}
			
			// Add current element at the rear of deque
	        // if it is a negative integer
			if(arr[i]<0)
				dq.offer(i);
		}
		
		// integer of last window
		if (!dq.isEmpty()) {
			l.add(arr[dq.peek()]);
		}else {
			l.add(0);
		}
		
		return l;
	}
}
