package leetCode;

public class MountainArray_941 {

	public static void main(String[] args) {
		/*
		 * strictly increasing and  decreasing
		 * 0>2>3>4>5<2<1<0
		 * 
		 * not strictly increasing and  decreasing (Equal condition)
		 * 0>2>3=3>5<2<1<0
		 */
		
		int[] arr= {0,2,3,4,5,2,1,0};
		boolean validMountatinArray = validMountatinArray(arr);
		System.out.println(validMountatinArray);
		
		int[] arr1= {0,2,3,3,5,2,1,0};
		boolean validMountatinArray1 = validMountatinArray(arr1);
		System.out.println(validMountatinArray1);
	}

	private static boolean validMountatinArray(int[] A) {
		int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
	}
}
