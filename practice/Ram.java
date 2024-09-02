package practice;

import java.util.Arrays;

public class Ram {

    public static void main(String[] args) {
    	int[] A = {3, 4, 4, 6, 1, 4, 4};
    	int N=5;
    	
    	int[] solution = solution(N, A);
    	System.out.println(Arrays.toString(solution));
    }

	private static int[] solution(int N, int[] A) {
		int[] res = new int[N];
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i<A.length ; i++) {
			if(A[i]>N) {
				Arrays.fill(res, max);
			}else {
				res[A[i]-1]++;
				max=Math.max(max, res[A[i]-1]);
			}
		}
		return res;
	}

}
