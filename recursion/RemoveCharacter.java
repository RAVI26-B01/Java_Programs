package recursion;

public class RemoveCharacter {
    public static void main(String[] args) {
        removeChar("abbacca",'a',"");

        System.out.println(removeChar("goodmorning",'o'));
    }

    static void removeChar(String s, Character c, String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        if(ch == c){
            removeChar(s.substring(1), c, ans);
        }
        else{
            ans+=ch;
            removeChar(s.substring(1), c, ans);
        }
    }

    static String removeChar(String s, Character c){
        if(s.isEmpty()){
            return "";
        }
        char ch = s.charAt(0);
        if(ch == c){
          return  removeChar(s.substring(1), c);
        }
        else{
            
            return ch+ removeChar(s.substring(1), c);
        }
    
    }
}
