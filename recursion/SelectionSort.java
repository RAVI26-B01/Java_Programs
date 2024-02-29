package recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] ar= {4, 1, 8, 3, 6};

        sort(ar, ar.length, 0 , 0);
        System.out.println(Arrays.toString(ar));
    }

    private static void sort(int[] ar, int r, int c, int max) {
        if(r==0){
            return;
        }
        if(c<r){
           if(ar[c] > ar[max]){
            sort(ar, r, c+1, c);
           }else
            sort(ar, r, c+1, max);
        }
        else{
           int temp = ar[max];
           ar[max] = ar[r-1];
           ar[r-1]= temp;
            sort(ar, r-1, 0,0);
            
        }
    }
}
