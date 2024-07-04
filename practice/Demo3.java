package practice;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import jdk.nashorn.internal.ir.LiteralNode.ArrayLiteralNode;

 public class Demo3 {

	public static void main(String[] args) {

		int[] arr= {0,2,3,4,5,2,1,0};
		boolean validMountatinArray = validMountatinArray(arr);
		System.out.println(validMountatinArray);
		
		int[] arr1= {0,2,3,3,5,2,1,0};
		boolean validMountatinArray1 = validMountatinArray(arr1);
		System.out.println(validMountatinArray1);
	}

	private static boolean validMountatinArray(int[] arr) {
		int i = 0 ;
		while(i<arr.length-1 && arr[i]<arr[i+1]) {
			i++;
		}
		  
		if (i == 0 || i == arr.length-1)
	            return false;

		
		while(i<arr.length-1 && arr[i]>arr[i+1])
		{
			i++;
			
		}
		return i == arr.length-1;
		
	}



}

