package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("(()){}[]()"));
		System.out.println(isValid("(())("));
		System.out.println(isValid("{}{]()"));
	}

	public static boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		for (char ch : s.toCharArray()) {
			switch (ch) {
			case '(':
			case '{':
			case '[':
				stack.push(ch);
				break;

			case ')':
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
				break;

			case '}':
				if (stack.isEmpty() || stack.pop() != '{')
					return false;
				break;

			case ']':
				if (stack.isEmpty() || stack.pop() != '[')
					return false;
				break;

			default:
				return false; // Invalid character
			}
		}

		return stack.isEmpty();
	}
	
	
	  public static boolean isValid2(String s) {
	        Stack<Character> stack = new Stack<>();

	        for (char ch : s.toCharArray()) {
	            // Push opening brackets
	            if (ch == '(' || ch == '{' || ch == '[') {
	                stack.push(ch);
	            } else {
	                // If stack is empty or brackets don't match
	                if (stack.isEmpty()) {
	                    return false;
	                }

	                char top = stack.pop();

	                if ((ch == ')' && top != '(') ||
	                    (ch == '}' && top != '{') ||
	                    (ch == ']' && top != '[')) {
	                    return false;
	                }
	            }
	        }

	        // Valid if no unmatched opening brackets remain
	        return stack.isEmpty();
	    }
}
