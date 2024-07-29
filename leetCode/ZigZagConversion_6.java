package leetcode;

import java.util.Arrays;

public class ZigZagConversion_6 {

	public static void main(String[] args) {

		String s = "paypalstring";
		int n =5;
		String convert = convert(s,5);
		System.out.println(convert);
		
	
	}
	
	 public static String convert(String s, int numRows) {
		 int n=s.length();
     StringBuilder[] arr=new StringBuilder[numRows];
     for(int i=0;i<numRows;i++){
         arr[i]=new StringBuilder();
     }
     int i=0;
     while(i<n){
         for(int j=0;j<numRows && i<n;j++){
             arr[j].append(s.charAt(i++));
         }
         for(int j=numRows-2;j>0 && i<n;j--){
             arr[j].append(s.charAt(i++));
         }
     }
     StringBuilder ans = new StringBuilder();
     for(StringBuilder str : arr){
         ans.append(str);
     }
     return ans.toString();}
}
