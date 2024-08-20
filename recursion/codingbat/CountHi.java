package recursion.codingbat;

public class CountHi {
	
	public static void main(String[] args) {
		int countHi = countHi("xhixhix");
		System.out.println(countHi);
	}
	
	public static int countHi(String str) {
		   if(str.length()==0)
				  return 0;
			  if(str.startsWith("hi"))
			    return 1+ countHi(str.substring(str.indexOf("hi")+1));
		    	
			  return countHi(str.substring(1));
		}
}
