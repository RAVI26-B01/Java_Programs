package practice;
/*
 * w.a.p to check if a given number can be written in sum of power of 5
 */
public class cordis {
    public static void main(String[] args) {
        check(126);
    }

    static void check(int n ){
        while(n%5 < 2 && n>1)
            n/=5;
        System.out.println(n==1);
    }
}
