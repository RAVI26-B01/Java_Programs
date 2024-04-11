package leetcode;

import java.util.Arrays;

public class RotateArray_189 {
    public static void main(String[] args) {
        int[] ar ={1,2,3,4,5,6,7};
        int k=3;

        healper(ar,k);
        System.out.println(Arrays.toString(ar));
    }

    private static void healper(int[] ar, int k) {
        // reverse(ar, 0 ,ar.length-1-k);
        // reverse(ar,ar.length-k, ar.length-1);
        // reverse(ar, 0 ,ar.length-1);
        int n = ar.length;
        reverse(ar, 0, n-1);
        reverse(ar, 0, k-1);
        reverse(ar, k, n-1);
    }

    private static void reverse(int[] ar, int idx, int length) {
       for(int  i = idx, j=length; i<j; i++,j--){
            int temp = ar[i];
            ar[i]=ar[j];
            ar[j]=temp;
       }
    }
}
