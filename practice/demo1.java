package practice;

import java.util.Scanner;

public class demo1 {
	
	public static void main(String[] args) {

        String s1= new String ("Durga");
        String s2 = s1.concat("software");
        String s3= s2.intern();
        System.out.println(s2==s3);
	}

    public static int majorityElement(int[] nums) {
      
        int el=-1;
         int count=0;
         for(int num:nums){
            if(count==0){
                el=num;count=1;
            }
            else if(num==el){
                count++;
            }
            else {count--;}
         }
     
        count=0;
         for(int i=0;i<nums.length;i++){
             if(nums[i]==el){
                 count++;
             }
         }
         if(count>(nums.length/2))
             return el;
         return -1;
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
