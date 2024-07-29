package recursion.codingbat;
//fibonacci
public class Three {

	public static void main(String[] args) {
		int n = fibonacci(7);
		System.out.println(n);
	}

	private static int fibonacci(int i) {
		if(i <2)
			return i;
		return fibonacci(i-1)+ fibonacci(i-2);
	}
}
