package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        
        int[] ar = {1, 3, 5, 8, 12, 16};
        int target = 1;

        boolean res= search(ar, target);
        System.out.println(res);
    }

    static boolean search(int[] ar, int target){

        return helper(ar, target, 0 , ar.length-1);
    }

    private static boolean helper(int[] ar, int target, int i, int j) {

        if(j<i)
            return false;

        int mid = i + (j-i)/2;

        if(ar[mid]== target)
            return true;
        else if(ar[mid] < target){
            return helper(ar, target, mid+1, j);
        }
        return helper(ar, target, i, mid-1);
    
    }
}
