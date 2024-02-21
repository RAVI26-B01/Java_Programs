package recursion;

public class CheckSortedArrayOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 10};
       boolean check =   check(arr,0);
       System.err.println(check);
    }


    static boolean check(int[] arr, int index){

        if(index == arr.length - 1)
            return true;
        
        return arr[index] < arr[index+1] && check(arr, index+1);
    }
}
