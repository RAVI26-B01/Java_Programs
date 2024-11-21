package practice;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class DynamicTopElement {

	public static void main(String[] args) {
		int[] ar = {3, 4, 1, 6, 9 , 10, 12, 2, 14};
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the required top element :");
		int n = scan.nextInt();
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i =0 ; i< ar.length ; i++) {
			pq.add(ar[i]);
			if (pq.size() > n) {
                pq.poll();  // Remove the smallest element
            }
		}
		System.out.println(pq.peek());
	}
}
