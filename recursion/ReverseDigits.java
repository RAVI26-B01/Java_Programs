package recursion;

public class ReverseDigits {
    public static void main(String[] args) {
         reverse(1234);
         System.out.println(sum);

         int rev =   reverse2(1234);
         System.out.println(rev);

         System.out.println(palindrome(1231));
    }

    static int sum =0;
    static void reverse(int n){
        if(n==0)
            return;
        
        int rem = n%10;
        sum = sum*10 + rem;
         reverse(n/10);
    }

    static int reverse2(int n){
        int digits = (int)(Math.log10(n))+1; // return numbers of digits in a number
        return helper(n,digits);
    }

    /*
      n = 1234
      4 * 10^3 + rev(123)
            ||
      3 * 10^2 + rev(12)
            ||
      2 * 10^1 + rev(1)
            ||
      1 * 10^0 + return
     */

    static int helper(int n, int digits){
        if(n%10 == n){
            return n;
        }
        int rem = n% 10;
        return rem * (int)(Math.pow(10, digits-1))+ helper(n/10, digits-1);

    }

    static boolean palindrome (int n){
        return n == reverse2(n);
    }
}
