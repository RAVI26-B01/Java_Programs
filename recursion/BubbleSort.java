package recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        
        int[] ar = {1, 6, 8, 2, 5};
        sort(ar, ar.length-1 , 0);
        System.out.println(Arrays.toString(ar));
    }

    static void sort(int[] ar, int r, int c){
        if(r==0){
            return;
        }
        if(c<r){
            if(ar[c]>ar[c+1]){
                int temp = ar[c];
                ar[c] = ar[c+1];
                ar[c+1]=temp;
            }
            sort(ar, r, c+1);
        }
        else{
           
            sort(ar, r-1, 0);
            
        }
    }
}
