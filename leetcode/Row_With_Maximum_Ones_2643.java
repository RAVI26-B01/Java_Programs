package leetcode;

import java.util.Arrays;

public class Row_With_Maximum_Ones_2643 {

	public static void main(String[] args) {
		int[][] mat = {{0,1},{1,0}};
		int[] rowAndMaximumOnes = rowAndMaximumOnes(mat);
		System.out.println(Arrays.toString(rowAndMaximumOnes));
		
		int[][] mat2 = {{0,0},{1,1},{0,0}};
		int[] rowAndMaximumOnes2 = rowAndMaximumOnes(mat2);
		System.out.println(Arrays.toString(rowAndMaximumOnes2));
	}

	
	 public static int[] rowAndMaximumOnes(int[][] mat) {
	        
	        int n = mat.length;
	        int m = mat[0].length;
	        int maxCount = 0;
	        int index = 0;
	        for(int i = 0 ; i< n ; i++){
	            int count = 0;
	            for(int j = 0; j<m ; j++){
	                count = count+mat[i][j];
	            }
	            if(count>maxCount){
	                maxCount = count;
	                 index = i;
	            }
	        }

	        return new int[]{index,maxCount};
	    }
}
