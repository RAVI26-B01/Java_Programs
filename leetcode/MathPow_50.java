package leetcode;

public class MathPow_50 {
    public static void main(String[] args) {
    int n=-2;
    double x=2;
                
                if(n < 0){
                    n = -n;
                    x = 1 / x;
                }
                
                double pow = 1;
                
                while(n != 0){
                    if((n & 1) != 0){
                        pow *= x;
                    } 
                        
                    x *= x;
                    n >>>= 1;
                    
                }
                
                System.out.println(pow);
            }
        
}
