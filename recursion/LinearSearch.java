package recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] ar = {1, 2, 4, 6, 8, 9 , 3, 6};
        int target = 6;
        boolean search = search(ar, target, 0);
        System.out.println(search);
        ArrayList<Integer> l = new ArrayList<>();
        findAllIndex(ar, target, 0, l);

        System.out.println(l);
    }

    private static void findAllIndex(int[] ar, int target, int i, ArrayList<Integer> l) {
        if(i == ar.length){
            return;
        }
        if(ar[i]== target)
            l.add(i);
        
        findAllIndex(ar, target, i+1, l);
    }

    static boolean search(int[] ar, int target, int index){

        if(ar[index] == ar.length - 1)
            return false;
        
        return ar[index] == target || search(ar, target, index+1);
    }
}
