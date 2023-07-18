package practice;

public class PrintStarString {

	public static void main(String[] args) {

		System.out.println(printStar(4,3));
	}

	private static String printStar(int n, int m) {

		StringBuffer s = new StringBuffer();
		for(int i=0 ;i<n ; i++) {
			for(int j=0; j <m ;j++) {
				if(i==0 || i==n-1 || j==0 || j==m-1) {
					s.append("*");
				}
				else
					s.append(" ");
			}
			s.append("\n");
		}
		return s.toString();
	}

}
