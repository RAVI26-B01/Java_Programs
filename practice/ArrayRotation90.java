package practice;

public class ArrayRotation90 {

	public static void main(String[] args) {
	
		int [][] ar = {{1,2,3},{4,5,6},{7,8,9}};
		rotateArray(ar);
	}

	private static void rotateArray(int[][] matrix) {
	      
		for(int i=0;i<matrix.length ;i++) {
			for(int j=0; j<matrix.length ;j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}   
			System.out.println();
		}
		System.out.println();
		
		
		//transpose of a matrix m[i][j]=m[j][i];
		for(int i = 0; i<matrix.length; i++){
	            for(int j = i; j<matrix[0].length; j++){
	                int temp = 0;
	                temp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = temp;
	            }
	        }
		
		/*
		 * +90 degree rotate
		 */
		for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
		

		/*
		 * -90 degree rotate
		 */
	        for(int i =0 ; i<matrix.length/2; i++){
	            for(int j = 0; j<matrix.length; j++){
	                int temp = 0;
	                temp = matrix[i][j];
	                matrix[i][j] = matrix[matrix.length-1-i][j];
	                matrix[matrix.length-1-i][j] = temp;
	            }
	        }
		

	
		
		
		for(int i=0;i<matrix.length ;i++) {
			for(int j=0; j<matrix.length ;j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
