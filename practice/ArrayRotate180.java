package practice;

public class ArrayRotate180 {

	public static void main(String[] args) {
		int [][] ar = {{1,2,3},{4,5,6},{7,8,9}};
		
		rotateArray(ar);

		for(int i=0;i<ar.length ;i++) {
			for(int j=0; j<ar.length ;j++) {
				System.out.print(ar[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void rotateArray(int[][] matrix) {
		transpose(matrix);			// transpose
		rotateAntiClockWise(matrix);// -90 rotate
		transpose(matrix);			// transpose
		rotateAntiClockWise(matrix);// -90 rotate
	}

	private static void rotateAntiClockWise(int[][] matrix) {
		for(int i =0 ; i<matrix.length/2; i++){
            for(int j = 0; j<matrix.length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }
		
	}

	private static void transpose(int[][] matrix) {
		for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
		
	}
		
}
