package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        // String s = "abc";
        // printSubSeq("",s);
        // System.out.println(returnSubSeq("",s));
        int[] ar = {1, 2, 2};
        // recursiveSubSet(ar);
        recursiveUniqueSubSet(ar);
    }

    @SuppressWarnings("unused")
    private static void recursiveSubSet(int[] ar) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(Integer num : ar){
            int size = outer.size();
            for(int i= 0 ; i<size ; i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }  
        }
            System.out.println(outer);
    }

    private static void recursiveUniqueSubSet(int[] ar) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0 ;
        int end = 0;
        for(int j= 0 ; j<ar.length ; j++){
            start = 0;
           if(j>0 && ar[j]==ar[j-1]){
            start = end+1;
           }
           end= outer.size();
            for(int i= start  ; i<end ; i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(ar[j]);
                outer.add(inner);
            }  
        }
            System.out.println(outer);
    }

    static void printSubSeq(String u , String s){
        if(s.isEmpty())
        {
            System.out.println(u);
            return;
        }
        char ch = s.charAt(0);
        printSubSeq(u+ch,s.substring(1));
        printSubSeq(u, s.substring(1));
    }

    static ArrayList<String> returnSubSeq(String u , String s){
        if(s.isEmpty())
        {
            ArrayList<String> l = new ArrayList<>();
            l.add(u);
            return l;
        }
        char ch = s.charAt(0);
        ArrayList<String> left =   returnSubSeq(u+ch,s.substring(1));
        ArrayList<String> right =  returnSubSeq(u, s.substring(1));
        left.addAll(right);
        return left;
    }
}
