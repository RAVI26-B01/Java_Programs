package recursion.codingbat;

/*
 * add star between characters
 */
public class AddStar {
	
	public static void main(String[] args) {
		String allStar = allStar("abc");
		System.out.println(allStar);
	}
	
	public static String allStar(String str) {
		  if(str.length()<=1)
		    return str;
		  return str.charAt(0)+"*"+allStar(str.substring(1));
		}

}
