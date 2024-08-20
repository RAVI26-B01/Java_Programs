package recursion;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        String s = "abc";
         printPermutation("",s);
//         System.out.println(permutationList("","abc"));
//
//        System.out.println(countPermutation("","abc"));
    }

    private static void printPermutation(String p, String s) {
       if(s.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch = s.charAt(0);
        for(int i = 0 ; i<=p.length() ; i++){
            String f = p.substring(0, i);
            String l = p.substring(i, p.length());
            printPermutation(f+ch+l, s.substring(1));
        }
    }

    private static ArrayList<String> permutationList(String p, String s) {
        if(s.isEmpty())
         {
            ArrayList<String> l = new ArrayList<>();
            l.add(p);
            return l;
         }
         ArrayList<String> ans = new ArrayList<>();
         char ch = s.charAt(0);
         for(int i = 0 ; i<=p.length() ; i++){
             String f = p.substring(0, i);
             String l = p.substring(i, p.length());
             ArrayList<String> localAns =  permutationList(f+ch+l, s.substring(1));
             ans.addAll(localAns)    ;
         }

         return ans;
     
     }

     private static int countPermutation(String p, String s) {
        if(s.isEmpty())
         {
            
             return 1;
         }
         int count = 0;
         char ch = s.charAt(0);
         for(int i = 0 ; i<=p.length() ; i++){
             String f = p.substring(0, i);
             String l = p.substring(i, p.length());
             count = count + countPermutation(f+ch+l, s.substring(1));
         }

         return count;
     }
}
