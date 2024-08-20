package recursion.codingbat;

public class MoveXtoLast {

	public static void main(String[] args) {
		String endX = endX("xhixhix");
		System.out.println(endX);
	}
	
	public static String endX(String str) {
		  if(str.length()<1)
			  return "";
		  if(str.charAt(0)=='x')
			  return endX(str.substring(1))+"x";
		  return str.charAt(0)+ endX(str.substring(1));
	}

}
