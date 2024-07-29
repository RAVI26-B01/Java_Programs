package recursion.codingbat;

public class five {
 
	public static void main(String[] args) {
		int n  = triBLocks(4);
		System.out.println(n);
	}

	private static int triBLocks(int rows) {
		if(rows  < 1)
		    return 0;
		  return rows+triBLocks(rows-1);
	}
}
