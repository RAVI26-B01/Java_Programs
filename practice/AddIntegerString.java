package practice;

public class AddIntegerString {

	public static void main(String[] args) {
		String num1="1000";
		String num2="12";
		
		String addIntegerString = addIntegerString(num1,num2);
		System.out.println(addIntegerString);
	}

	private static String addIntegerString(String num1, String num2) {
		StringBuffer res=new StringBuffer();
		int n=num1.length()-1;
		int m=num2.length()-1;
		int carry=0;
		while(n>=0 || m>=0 || carry>0){
			int x=n>=0?num1.charAt(n)-'0':0;
			int y=m>=0?num2.charAt(m)-'0':0;
			int sum=x+y+carry;
			carry=sum/10;
			res.append(sum%10);
			m--;n--;
			
		}
		res.reverse();
		return res.toString();
		
	}

}
