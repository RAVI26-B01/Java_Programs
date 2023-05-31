package practice;

public class A3B2C4 {

	public static void main(String[] args) {

		String s="a3b1c5";
		String appendChar = appendChar(s);
		System.out.println(appendChar);
	}

	private static String appendChar(String s) {
		StringBuffer sb = new StringBuffer();
		for(int i=0 ; i<s.length() ; i+=2) {
			char c = s.charAt(i);
			int t = s.charAt(i+1)-'0';
			while(t>0) {
				sb.append(c);
				t--;
			}
		}
		return sb.toString();
		
	}

}
