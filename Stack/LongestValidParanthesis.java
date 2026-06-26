package Stack;

import java.util.Stack;

public class LongestValidParanthesis {

	public static void main(String[] args) {
		String s = "(()";
		System.out.println(longestValidParentheses2(s));
		
		System.out.println(longestValidParentheses(")()(()()("));
	}
	
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Base index
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
    
    
    public static int longestValidParentheses2(String s) {

        int left = 0;
        int right = 0;
        int maxLen = 0;
        // validate right orphaned ) bracket       example-> ()))
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxLen = Math.max(maxLen, 2 * right);

            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        // validate left orphaned ( bracket     example-> (()
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxLen = Math.max(maxLen, 2 * left);

            else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLen;
    }
}





