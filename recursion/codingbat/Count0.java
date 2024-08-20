package recursion.codingbat;

public class Count0 {

	public static void main(String[] args) {
		int countZero = countZero(990760600);
		System.out.println(countZero);

	}
	private static int countZero(int n) {
		
		if(n<1)
			return 0;
		if(n%10==0)
			return 1+countZero(n/10);
		
		return countZero(n/10);
		
		
	}	
}
