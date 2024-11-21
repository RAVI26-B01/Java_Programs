package practice;

public class LongestCommonSubsequence {

	int lcs(char[] X, char[] Y, int m, int n, int[][] ar)
	{
		if (m == X.length || n == Y.length)
			return 0;
		if(ar[m][n]!=0)
			return ar[m][n];
		if (X[m] == Y[n])
			return  ar[m][n]=1 + lcs(X, Y, m + 1, n + 1, ar);
		else
			return ar[m][n]= Math.max(lcs(X, Y, m+1 , n, ar ), lcs(X, Y, m, n+1, ar));
	}

	public static void main(String[] args)
	{
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "abc";
		String s2 = "alkop";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = 0;
		int n = 0;
		int[][] ar = new int[s1.length()][s2.length()];
		System.out.println("Length of LCS is"
						+ " " + lcs.lcs(X, Y, m, n, ar));
	}
}

