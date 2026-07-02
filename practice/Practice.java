package practice;

public class Practice{
	public static void main(String[] args) {
		
		int n = 12345;
		int sumOfDigits = sumOfDigits(n);
		System.out.println(sumOfDigits);
	}

	private static int sumOfDigits(int n) {
		
		if(n<=0)
			return 0;
		return n%10 + sumOfDigits(n/10);
	}

}
