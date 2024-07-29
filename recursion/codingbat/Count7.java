package recursion.codingbat;

public class Count7 {

	public static void main(String[] args) {
		int count = count(71177);
		System.out.println(count);
	}

	private static int count(int n) {

		if(n == 0)
			return 0;
		if(n % 10 == 7)
			return 1+ count(n/10);
		return count(n/10);
	}
}
