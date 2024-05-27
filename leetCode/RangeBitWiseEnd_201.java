package leetcode;

public class RangeBitWiseEnd_201 {
    public static void main(String[] args) {
        int left = 5;
        int right = 1;
        rangeBitwiseAnd(left, right);

    }

    public static int rangeBitwiseAnd(int left, int right) {
        System.out.println(Integer.toBinaryString(left));;
       System.out.println( Integer.toBinaryString(right));
      String leftBin =  Integer.toBinaryString(left);
      String rightBin =  Integer.toBinaryString(right);

      for(int i = 0 ; i<rightBin.length() ; i++){
       // if()
      }
        return 0;
    }
}
