package practice;

public class prac {
    public static void main(String[] args) {
        String  s = "abBAcC";
        String ans =   makeGood(s);
        System.out.println(ans);
    }

    public static String makeGood(String s) {
        StringBuffer sb = new StringBuffer(s);

        for(int i = 0 ; i< sb.length()-1 ; i++){
            if(sb.charAt(i) == (sb.charAt(i+1)+32)){
                sb.delete(i, i+2);
                i=-1;
            }
        }

        return sb.toString();
    }
}
