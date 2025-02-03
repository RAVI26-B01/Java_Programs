package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import binaryTree.Node;

public class Demo2 {
	public static void main(String[] args) {
		
		int ar1[] = {1,3,5,6,7};
		int ar2[] = {2,3,4,8,10};
		System.out.println(findMedian(ar1, ar2));;
	}

	private static double findMedian(int[] ar1, int[] ar2) {
		int n = ar1.length;
		int m = ar2.length;
		
		if(n>m)
			findMedian(ar2, ar1);
		
		int start = 0;
		int end = ar1.length;
		
		while(start <= end) {
			int i1 = (start + end)/2;
			int i2 = (n+m+1)/2-i1;
			
			int max1 = (i1==0)? Integer.MIN_VALUE:ar1[i1-1];
			int min1 = (i1==n)? Integer.MAX_VALUE:ar1[i1];
			int max2 = (i2==0)? Integer.MIN_VALUE:ar2[i2-1];
			int min2 = (i2==m)? Integer.MAX_VALUE:ar2[i2];
			
			if(max1<min2 && max2<min1) {
				if((n+m)%2==0) {
					return (Math.max(max1, max2)+Math.min(min1, min2))/2.0;
				}else {
					return Math.max(max1, max2);
				}
			}else if(max1>min2) {
				end = i1-1;
			}else {
				start = i1+1;
			}
		}
		return 0;
	}
	
}
	
	
