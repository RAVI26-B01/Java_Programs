package leetcode;

public class RearrangeSpaces_1592 {
	public static void main(String[] args) {
		String s ="  this   is  a sentence ";
		String reorderSpaces = reorderSpaces(s);
		System.out.println(reorderSpaces);
		
	}
	
	public static String reorderSpaces(String text) {
		StringBuffer ans = new StringBuffer();
		int space = 0;
		String[] strings = text.trim().split("\\s+");
		for(int i= 0 ; i<text.length() ; i++) {
			if(text.charAt(i)== ' ') {
				space++;
			}
		}
		
		int spaceBtwWords = space/(strings.length-1);
		int extraSpace = space % (strings.length-1);
		for(int i = 0 ; i<strings.length ; i++) {
			ans.append(strings[i]);
			for( int j =0 ; j<spaceBtwWords && i<strings.length -1 ;j++)
				ans.append(" ");
		}
		for( int j =0 ; j<extraSpace ;j++)
			ans.append(" ");
		
		return ans.toString();
        
    }
}
