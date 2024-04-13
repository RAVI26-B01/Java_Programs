package leetcode;

public class IsSubsequence {
    public static void main(String[] args) {
       String s = "abc", t = "ahbgdc";

       System.out.println(checkSubSeq(s,t));;
    }

    private static boolean checkSubSeq(String s, String t) {
        int start = 0;
        int count = 0;
        for(int i =0 ; i<s.length() ; i++){
            for(int j= start ;j<t.length() ;j++){
                if(s.charAt(i)== t.charAt(j)){
                    start=j+1;
                    count++;
                    break;
                }
            }
        }
        return count == s.length();
    }

    public boolean checkSubSeq2(String s, String t) {
        int index = 0;
        for(int i =0; i<s.length();i++)
        {
            int charPresent = t.indexOf(s.charAt(i),index);
            if(charPresent == -1) return false;
            index = charPresent+1;
        }
        return true;
    }

    public boolean checkSubSeq3(String s, String t) {
        
        int i = 0;
        int j = 0;

        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();

        while(i < tArray.length && j < sArray.length){
            if(tArray[i] == sArray[j]){
                j++;
            }
            i++;
        }

        return s.length() == j;
    }
}
