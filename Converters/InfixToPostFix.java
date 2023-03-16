package Converters;

import java.util.Stack;

public class InfixToPostFix {
    
    public static void main(String[] args) {
        String s="4$2*3-3+8/4/(1+1)";

        System.out.println(ConvertInfixtoPostFix(s.toCharArray()));
    }

    private static String ConvertInfixtoPostFix(char[] infixArr) {
        String infix = '(' + String.valueOf(infixArr) + ')';
       
        Stack<Character> char_stack = new Stack<>();
        String output="";

        for (int index = 0; index < infix.length(); index++) {
            if (isalpha(infix.charAt(index)) || isdigit(infix.charAt(index))){
                output += infix.charAt(index);
                }
            else if(infix.charAt(index)=='('){
                char_stack.push(infix.charAt(index));
            }
            else if(infix.charAt(index)==')'){
                while(char_stack.peek()!='('){
                    output+=char_stack.peek();
                    char_stack.pop();
                }
                char_stack.pop();
            }
            else{
                if(isOperator(infix.charAt(index))){
                    if (isOperator(char_stack.peek()))
                    {
                    while ((getPriority(infix.charAt(index)) <= getPriority(char_stack.peek()))
                            || (getPriority(infix.charAt(index)) < getPriority(char_stack.peek())
                            && (infix.charAt(index) == '^' || infix.charAt(index) == '$') ))
                    {
                        output += char_stack.peek();
                        char_stack.pop();
                    }
            
                    // Push current Operator on stack
                    char_stack.add(infix.charAt(index));
                    }
                }
            }
          }
          while(!char_stack.empty()){
            output += char_stack.pop();
        }
    return output;
}

    private static int getPriority(char c) {
        if(c=='^' || c=='$'){
            return 3;
        }
        if(c=='*' || c=='/')
            return 2;
        if(c=='+' || c=='-')
            return 1;
        return 0;
    }

    private static boolean isOperator(char c) {
        return (!isalpha(c)) && (!isdigit(c));
    }

    private static boolean isdigit(char c) {
        if(c>'0' && c<'9'){
            return true;
        }
        return false;
    }

    private static boolean isalpha(char c) {
       
        if(c>'a' && c<'z'){
            return true;
        }
        return false;
    }
}
    
