package practice;

import java.util.Stack;

public class BalancedParentheses {
	    public static boolean isBalanced(String expression) {
	        Stack<Character> stack = new Stack<>();

	        for (char ch : expression.toCharArray()) {
	            switch (ch) {
	                case '(':
	                case '[':
	                case '{':
	                    stack.push(ch);
	                    break;
	                case ')':
	                    if (stack.isEmpty() || stack.pop() != '(') {
	                        return false;
	                    }
	                    break;
	                case ']':
	                    if (stack.isEmpty() || stack.pop() != '[') {
	                        return false;
	                    }
	                    break;
	                case '}':
	                    if (stack.isEmpty() || stack.pop() != '{') {
	                        return false;
	                    }
	                    break;
	                default:
	                    break;
	            }
	        }

	        // If the stack is empty, all opening parentheses have been matched
	        return stack.isEmpty();
	    }

	    public static void main(String[] args) {
	        // Test cases
	        String[] expressions = {
	            "([]){}",      // Balanced
	            "({[()]})",    // Balanced
	            "({[)]}",      // Not balanced
	            "((()))",      // Balanced
	            "(()",         // Not balanced
	            "(([]))"       // Balanced
	        };

	        for (String expr : expressions) {
	            System.out.println("Expression: " + expr + " is balanced: " + isBalanced(expr));
	        }
	    }
	}

