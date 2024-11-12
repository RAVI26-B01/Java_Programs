package leetcode;

public class StepsToReduceZero_1342{
    public static void main(String[] args) {
       int steps =  numberOfSteps(41);
       System.out.println(steps);
    }

    public static int numberOfSteps(int num) {
        return helper(num ,0);
    }

    public static int helper(int num , int c){
        if(num == 0)
            return c;
        if(num % 2 ==0){
            return helper(num/2,c+1);
        }
        return helper(num-1,c+1);
    }
}