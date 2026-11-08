package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G_05_BFS {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
			    Arrays.asList(
			        new ArrayList<>(Arrays.asList(2, 3, 1)),
			        new ArrayList<>(Arrays.asList(0)),
			        new ArrayList<>(Arrays.asList(0, 4)),
			        new ArrayList<>(Arrays.asList(0)),
			        new ArrayList<>(Arrays.asList(2))
			    )
			);
		ArrayList<Integer> bfs = bfs(0,adj);
		System.out.println(bfs);
	}

	private static ArrayList<Integer> bfs(Integer node, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> ans = new ArrayList<>();
		boolean[] vis = new boolean[adj.size()];
		Queue<Integer> queue = new LinkedList<>();
		vis[node]=true;
		queue.add(node);
		while(!queue.isEmpty()) {
			Integer poll = queue.poll();
			ans.add(poll);
			for(Integer i : adj.get(poll)) {
				if(!vis[i]) {
					vis[i]=true;
					queue.add(i);
				}
			}
		}
	
		 
		return ans;  
	}
}
