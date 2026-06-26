package Stack.monotonicstack;

import java.util.Stack;

//leetcode 402
public class RemoveKDigits {

	public static void main(String[] args) {
		String num = "10";
		int k = 2;
		String removeKdigits = removeKdigits(num, k);
		System.out.println(removeKdigits);
	}
	
	public static String removeKdigits(String num, int k) {
        String ans = "";
        Stack<Integer> stack = new Stack<>();
        int n = num.length();
        
        for(int i = 0 ; i<n ; i++) {
        	
        	while(!stack.isEmpty() && k>0 && stack.peek() > num.charAt(i)-'0') {
        		stack.pop();
        		k--;
        	}
        	
        	stack.push(num.charAt(i)-'0');
        }
        
        while(!stack.isEmpty() && k>0) {
        	stack.pop();
        	k--;
        }
        
        if(stack.isEmpty())
        	return "0";
        
        while(!stack.isEmpty()) {
        	ans = stack.pop() + ans;
        }
        
        // remove Leading zero's
        ans = ans.replaceFirst("^0+", "");
        
        return ans.isEmpty()?"0":ans;
    }
}
