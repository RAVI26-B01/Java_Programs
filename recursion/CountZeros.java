package recursion;

public class CountZeros {
    public static void main(String[] args) {
        int count = count(32000040);
        System.out.println(count);
    }

    static int count(int n){
        return helper(n , 0);
    }

    /*
      f(30204, 0)
      f(3020, 0)
      f(302, 1)
      f(30, 1)
      f(3, 2)
      retrun ans
     */
    static int helper(int n, int c){

        if( n == 0)
            return c;
        int rem = n % 10;
        if(rem == 0)
            return helper(n/10, c+1);
       return  helper(n/10, c);
    }


}
