package practice;

import java.util.Scanner;

public class demo1 {
	
	public static void main(String[] args) {
        
        int n = -37;
        int x =-3;
        // System.out.println(n>>>2);
        // System.out.println(Integer.toBinaryString(-12));
        // System.out.println(Integer.toBinaryString(-12>>2));;
        int i =n>>>x;
        System.out.println(i);
        // System.out.println(Integer.toBinaryString(1073741821));
       
	}

	
	public static void drawPatternB(int h, int w){  
        int mid = (h / 2);  
        for(int i = 0; i < h; i++) {  
            System.out.print("*");  
            for(int j = 0; j < w; j++) {  
                if((i == 0 || i == h - 1 || i == mid) && j < (w - 2)) {  
                    System.out.print("*");  
                } else if (j == (w - 2) && !(i == 0 || i == h - 1 || i == mid)) {  
                    System.out.print("*");  
                } else {  
                    System.out.print(" ");  
                }  
            }  
            System.out.print("\n");  
        }  
    }  
}
