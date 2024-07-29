package recursion.codingbat;

public class Four {
	public static void main(String[] args) {
		int bunnyEars2 = bunnyEars2(6);
		System.out.println(bunnyEars2);
	}
	

	public static int bunnyEars2(int bunnies) {
	  if(bunnies == 0 )
	    return 0;
	  if(bunnies%2 !=0){
	    return 2+bunnyEars2(bunnies-1);
	  }
	return 3+bunnyEars2(bunnies-1);
	}

}
