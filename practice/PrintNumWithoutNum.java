package practice;

/*
 * print numbers without using numbers
 */
public class PrintNumWithoutNum {
    public static void main(String[] args) {
        int  begin = '&'/'&'; // any character by character will give 1;
        int end ='d';
        String s = "!@#$%^&*()";
        for(int i = begin ; i<=end ; i++){
            System.out.println(i);
        }

        for(int i = begin ; i<=(s.length()*s.length()) ; i++){
            System.out.println(i);
        }
    }
}
