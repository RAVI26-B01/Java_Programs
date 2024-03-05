package recursion;

import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
       int [] res =  sort(arr);
       System.out.println(Arrays.toString(res));
    }

    static int[] sort(int[] ar){
        if(ar.length == 1)
            return ar;
        int mid= ar.length/2;
        int[] left = sort(Arrays.copyOfRange(ar, 0,mid));
        int[] right = sort(Arrays.copyOfRange(ar, mid, ar.length));
        return conquer(left, right);
    }

    static int[] conquer(int[] first, int[] second){
        int[] res = new int[first.length+second.length];
        int i = 0;
        int j= 0 ;
        int k =0;

        while(i < first.length && j<second.length){
            if(first[i]<second[j]){
                res[k]=first[i];
                k++;i++;
            }
            else{
                res[k]=second[j];
                k++;j++;
            }
        }

        while(i<first.length){
            res[k]=first[i];
            k++;i++;
        }

        while(j < second.length){
            res[k]= second[j];
            k++;j++;
        }

        return res;
    }
}
