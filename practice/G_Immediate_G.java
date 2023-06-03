package practice;

public class G_Immediate_G {

	public static void main(String[] args) {
		String s="xxggxggxgx";
		System.out.println(gg(s));
	}

	/*
	 * Return true if G is immediate of Another G
	 */
	private static boolean gg(String s) {
		boolean flag=true;
		for(int i=0 ;i<s.length() ;i++) {
			int c=0;
			while(i<s.length() && s.charAt(i)=='g') {
				c++;
				i++;
			}
			if(c==1)
				return false;
		}
		return flag;
	}

}
