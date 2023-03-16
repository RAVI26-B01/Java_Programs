package Converters;

import java.util.Stack;

public class PrefixToInfix {

	public static void main(String[] args) {
		String s="+-*$4233//84+11";
		
		System.out.println(prefixToInfixConvert(s.toCharArray()));
	}

	private static String prefixToInfixConvert(char[] prefix) {
	
		String output="";
		
		Stack<String> s = new Stack();
		int count=0;
		for(int i=0 ; i<prefix.length ; i++){
			char c=prefix[i];
			
			if(Compare.isOperator(c)){
				s.push(c+"");
				count=0;
			}
			else if(Compare.isalpha(c) || Compare.isdigit(c)){
				s.push(c+"");
				count++;
			}
			if(count==2){
				count = converstion(s);
			}
		}
		return "";
	}

	private static int converstion(Stack<String> s) {
		 String op2 = s.pop();
         String op1 = s.pop();
         String oprt = s.pop();
          int c=0;
         // Concat the operands and operator
         String temp = ""+op1 + oprt + op2 ;
         if(!s.isEmpty()){
        	 String peek = s.peek();
             if(Compare.isOperator(peek.charAt(0))){
            	 s.push(temp);
            	 c=1;
             }
             else{
            	 s.push(temp);
            	 converstion(s);
             }
         }else{
        	 System.out.println(temp);
        	 System.exit(0);
         }
         
         return c;
	}
}
