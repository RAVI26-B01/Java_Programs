package recursion.codingbat;

public class Two {
	public static void main(String[] args) {
		int bunnyEars = bunnyEars(12);
		System.out.println(bunnyEars);
	}
	
	public static int bunnyEars(int bunnies) {
		if(bunnies==0)
			return 0;
		
		return 2 + bunnyEars(bunnies-1);
		  
	}
}
