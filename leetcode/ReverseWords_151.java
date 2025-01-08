package leetcode;

public class ReverseWords_151 {

	public static void main(String[] args)  {
		String s = "a good   example";
		System.out.println(reverseWords1(s));
		
		String s2 = "  hello world  ";
		System.out.println(reverseWords2(s2));
	}

	
	private static String reverseWords1(String s) {
		StringBuilder res = new StringBuilder();
		int i =0;
		int j=0;
		int n = s.length();
		while(i<n) {
			while(i<n && s.charAt(i)==' ') {
				i++;
			}
			 j = i;
			 while(i<n && s.charAt(i) != ' ') {
				 i++;
			 }
			 
			 res.insert(0,s.substring(j,i)).insert(0," ");
		}
		return res.toString().trim();
	}

	
	public static String reverseWords2(String s) {
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1;
        int j = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s.substring(i + 1, j + 1)).append(" ");
        }
        return res.toString().trim();
    }

}
