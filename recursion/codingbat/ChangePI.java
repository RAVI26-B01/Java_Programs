package recursion.codingbat;

public class ChangePI {

	public static void main(String[] args) {
		String changePi = changePi("xpix");
		System.out.println(changePi);
	}
	
	public static String changePi(String str) {
		  
		  if(str.length()==0)
		    return "";
		    
		  if(str.startsWith("pi")){
		    return "3.14"+changePi(str.substring(str.indexOf("pi")+2));
		  }  
		  
		  return str.charAt(0)+ changePi(str.substring(1));
		}

}
