package Converters;

import java.util.Stack;

public class InfixtoPrefix {
    public static void main(String[] args) {
        String s="4^2*3-3+8/4/1+1";
        convertInfixtoPrefix(s);
    }

    private static void convertInfixtoPrefix(String s) {

        char[] str = s.toCharArray();
       char[] reversedString= reverseString(str);

       for(int i=0 ; i<reversedString.length;i++){
        if(reversedString[i]=='('){
            reversedString[i]=')';
            i++;
        }
        else if(reversedString[i]==')'){
            reversedString[i]='(';
            i++;
        }
       }

       String prefix = infixToPostfix(reversedString);
       char[] ans = reverseString(prefix.toCharArray());
       System.out.println(ans);

    }

    private static String infixToPostfix(char[] reversedString) {
        System.out.println(reversedString);
	    String infix = '(' + String.valueOf(reversedString) + ')';
        String output="";

        Stack<Character> char_stack = new Stack<>();
	
        for (int i = 0; i < infix.length(); i++) {
            if (isalpha(infix.charAt(i)) || isdigit(infix.charAt(i)))
		            output += infix.charAt(i);
           else if(infix.charAt(i)=='('){
                char_stack.add('(');
            }
            else if(infix.charAt(i)==')'){

                while (char_stack.peek() != '(')
                {
                output += char_stack.peek();
                char_stack.pop();
                }
        
                // Remove '(' from the stack
                char_stack.pop();
            }
            else{
                if (isOperator(char_stack.peek()))
                {
                    while ((getPriority(infix.charAt(i)) < getPriority(char_stack.peek()))
                    || (getPriority(infix.charAt(i)) <= getPriority(char_stack.peek())
                    && infix.charAt(i) == '^'))
                    {
                        output += char_stack.peek();
                        char_stack.pop();
                    }
    
            // Push current Operator on stack
            char_stack.add(infix.charAt(i));
            
                }
            }
            
        }

        while(!char_stack.empty()){
            output += char_stack.pop();
        }
        return output;
    }

    private static boolean isalpha(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
            {
            return true;
            }
            return false;
        }   

        static boolean isdigit(char c)
        {
            if (c >= '0' && c <= '9')
            {
            return true;
            }
            return false;
        }

        static boolean isOperator(char c)
        {
            return (!isalpha(c) && !isdigit(c));
        }

        
static int getPriority(char C)
{
	if (C == '-' || C == '+')
	return 1;
	else if (C == '*' || C == '/')
	return 2;
	else if (C == '^')
	return 3;

	return 0;
}

    private static char[] reverseString(char[] str) {

        int i=0;
        int j=str.length-1;
        while(i<j){
            char t= str[i];
            str[i]=str[j];
            str[j]=t;
            i++;
            j--;
        }
        return str;
    }
}
