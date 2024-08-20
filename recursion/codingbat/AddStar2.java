package recursion.codingbat;

public class AddStar2 {
	
	public static void main(String[] args) {
		String allStar = allStar("xxyy");
		System.out.println(allStar);
	}
	
	public static String allStar(String str) {
		  if(str.length()<=1)
		    return str;
		  if(str.charAt(0)==str.charAt(1))
			  return str.charAt(0)+"*"+allStar(str.substring(1));
		  
		  return str.charAt(0)+allStar(str.substring(1));
		}



}
