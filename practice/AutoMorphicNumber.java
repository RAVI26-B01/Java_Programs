package practice;

public class AutoMorphicNumber {

	public static void main(String[] args) {
		int n = 76;
		boolean checkAutoMorphic = checkAutoMorphic(n);
		if(checkAutoMorphic)
			System.out.println("Auto-Morphic");
		else
			System.out.println("Not Auto-Morphic");
	}

	private static boolean checkAutoMorphic(int n) {
		
		int sqrt = n*n;
		while(n>0) {
			if(n%10 != sqrt%10) {
				return false;
			}
			n=n/10;
			sqrt/=10;
		}
		
		return true;
	}

}
