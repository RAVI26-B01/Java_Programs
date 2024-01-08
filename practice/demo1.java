package practice;

import java.util.ArrayList;

public class demo1 {
	
	public static void main(String[] args) {
		drawPatternB(10,7);
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
