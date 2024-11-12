package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber_17 {
    
    public static void main(String[] args) {
        letterCombinations("23");
    }

    public static void letterCombinations(String digits) {
         healper("", digits);
        
    }

    private static void healper(String p, String s) {
        String[] ar = {"","","abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};
        if(s.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = s.charAt(0) -'0';
        String val = ar[digit];
        for( int i = 0 ; i<val.length() ; i++){
            char ch = val.charAt(i);
            healper(p+ch, s.substring(1));
        }

    }

    @SuppressWarnings("unused")
    private static List<String> healper1(String p, String s) {
        String[] ar = {"","","abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};
        if(s.isEmpty()){
           ArrayList<String> l = new ArrayList<>();
           l.add(p);
           return l;
        }
        ArrayList<String> ans = new ArrayList<>();
        int digit = s.charAt(0) -'0';
        String val = ar[digit];
        for( int i = 0 ; i<val.length() ; i++){
            char ch = val.charAt(i);
            ans.addAll(healper1(p+ch, s.substring(1))) ;
        }
        return ans;
    }
}
