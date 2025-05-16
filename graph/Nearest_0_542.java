package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Nearest_0_542 {

	public static void main(String[] args) {
		int[][] input = {
							{1,0,1},
							{1,1,0},
							{1,0,0}
						};
		/*
		 * output
		 * 0,1,0
		 * 0,0,1 
		 * 0,1,2
		 */
		int[][] updateMatrix = updateMatrix(input);
		for(int i = 0 ; i <updateMatrix.length ; i++) {
			System.out.println(Arrays.toString(updateMatrix[i]));
		}
		
	}
	
	public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
		boolean[][] vis = new boolean[m][n];
		int[][] ans = new int[m][n];
		Queue<pair> queue = new LinkedList<>();
		for(int i = 0 ; i <m ; i++) {
			for(int j = 0 ; j <n ; j++) {
				if(mat[i][j]==1) {
					queue.add(new pair(i, j, 0));
					vis[i][j]=true;
				}
			}
		}
		
		int[] delRow = {-1, 0 , +1, 0};
		int[] delCol = {0, +1, 0, -1};
		
		while(!queue.isEmpty()) {
			int row = queue.peek().first;
			int col = queue.peek().second;
			int step = queue.peek().step;
			queue.poll();
			ans[row][col]=step;
			
			for(int i = 0 ; i<4 ; i++) {
				int nRow = row + delRow[i];
				int nCol = col + delCol[i];
				
				if(nRow >=0 && nRow<m
				&& nCol >=0 && nCol<n
				&& !vis[nRow][nCol]) {
					vis[nRow][nCol]=true;
					queue.add(new pair(nRow, nCol, step+1));
				}
			}
			
		}
		return ans;
    }
}

class pair{
	int first;
	int second;
	int step;
	pair(int first, int second, int step) {
		this.first = first;
		this.second = second;
		this.step = step;
	}
}
