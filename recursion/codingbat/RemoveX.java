package recursion.codingbat;

public class RemoveX {
	
	public static void main(String[] args) {
		String noX = noX("xaxb");
		System.out.println(noX);
	}
	
	public static String noX(String str) {
		if(str.length() ==0)
				return "";
		if(str.charAt(0)=='x') {
			return noX(str.substring(1));
		}
		return str.charAt(0)+noX(str.substring(1));
		  
	}
}
