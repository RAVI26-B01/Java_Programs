package practice;

import java.util.Scanner;

public class demo1 {
	
	public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        System.out.println("n1 :"+ n1);
        System.out.println("n2 :"+ n2);
        System.out.println("s1 :"+ s1);
        System.out.println("s2 :"+ s2);
	    scan.close();
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
