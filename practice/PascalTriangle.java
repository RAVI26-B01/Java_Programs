package practice;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		int n = 7;
		List<List<Integer>> pascal = getPascal(n);
		for(List<Integer> p : pascal) {
			System.out.println(p);
		}
	}

	/*
	    [1]
		[1, 1]
		[1, 2, 1]
		[1, 3, 3, 1]
		[1, 4, 6, 4, 1]
	 */
	private static List<List<Integer>> getPascal(int rows) {
		List<List<Integer>> ans = new ArrayList<>();
		
		for(int row = 0 ; row<rows ; row++) {
			List<Integer> currentRow = new ArrayList<>();
			for(int col = 0 ; col<=row; col++) {
				if( col == 0 || col==row )
					currentRow.add(1);
				else {
					int temp = ans.get(row-1).get(col-1)+ ans.get(row-1).get(col);
					currentRow.add(temp);
				}
			}
			ans.add(currentRow);
		}
		
		
		return ans;
		
	}
}
