package graph;

import java.util.Arrays;

public class FloodFill {

	public static void main(String[] args) {
		int[][] image = {
						{0,0,0},
					    {0,0,0}
					 //   {1,0,1}
					    };
		int sr = 0, sc = 0, color = 0;
		
		floodFill(image,sr,sc,color);
		
		for(int i = 0 ; i<image.length ; i++) {
			System.out.println(Arrays.toString(image[i]));
		}
		
	}
	
	
	 public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		 int[] delRow = {-1, 0 , +1, 0};
		 int[] delCol = {0, +1, 0, -1};
		 floodFill(image,sr,sc,color,delRow,delCol,image[sr][sc]);
		return image;
	        
	 }


	private static void floodFill(int[][] image, int sr, int sc, int color, int[] delRow, int[] delCol,int same) {
		image[sr][sc]=color;
		
		for(int i = 0 ; i<4; i++) {
			int row = sr + delRow[i];
			int col = sc + delCol[i];
			if(row>=0 && row<image.length && col>=0 && col<image[0].length && image[row][col]==same && image[row][col]!=color) {
				floodFill(image,row,col,color,delRow,delCol,same);
			}
		}
		
	}
}
