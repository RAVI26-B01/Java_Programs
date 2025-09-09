package practice;

import java.util.Stack;

public class DeletePairOfAdjecent {

	public static void main(String[] args) {

		String s = "aaabbccaddd";

		String deletePair = deletePair(s);
		System.out.println(deletePair);

		String removeAdjacentPairs = removeAdjacentPairs(s);
		System.out.println(removeAdjacentPairs);
	}

	/*
	 * TC - O(n²) --> we are initializing i = 0
	 */
	private static String deletePair(String s) {

		StringBuffer sb = new StringBuffer(s);
		int i = 0;
		while (i < sb.length() - 1) {

			if (sb.charAt(i) == sb.charAt(i + 1)) {
				sb.delete(i, i + 2);
				i = 0;
			} else {
				i++;
			}
		}
		return sb.toString();
	}

	public static String removeAdjacentPairs(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop(); // Remove the pair
			} else {
				stack.push(c);
			}
		}

		// Build the result from the stack
		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}

		return sb.toString();
	}

}
