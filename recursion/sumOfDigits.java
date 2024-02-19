 package recursion;

public class sumOfDigits {

    public static void main(String[] args) {
        int sum = sum(12345);
        System.out.println(sum);
    }

    static int sum(int n){

        if(n<=0)
            return 0;
        return sum(n/10)+(n%10);
    }
    
}