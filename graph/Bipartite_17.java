package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_17 {

	public static void main(String[] args) {
		int[][] adj = {
				{1},
				{0,2,4},
				{1,3},
				{2,4,5},
				{1,3},
				{3,6},
				{5}
			};
		int colorArr[] = new int[adj.length];
		Arrays.fill(colorArr, -1);
		for(int i = 0 ; i<adj.length ;i++) {
			if(colorArr[i] == -1) {
				if(!isBipartite(adj, colorArr, i ))
				{
					System.err.println("not bipartite");
					System.exit(0);
				}
			}
		}
		System.out.println("Bipartite");
		
	}

	private static boolean isBipartite(int[][] adj, int[] colorArr,  int start) {
		Queue<Integer> queue= new LinkedList<>();
		queue.add(start);
		colorArr[start] = 0;
		
		while(!queue.isEmpty())
		{
			Integer poll = queue.poll();
			for(Integer a :adj[poll]) {
				if(colorArr[a] == -1) {
					colorArr[a] = 1 - colorArr[poll] ;
					queue.add(a);
				}else if(colorArr[a] == colorArr[poll] ) {
					return false;
				}
			}
		}
		return true;
		
	}

}
