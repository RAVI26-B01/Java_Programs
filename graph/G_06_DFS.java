package graph;

import java.util.ArrayList;
import java.util.Arrays;


/*
 TC -> O(N)+(2xE)
 
    1
    |
    0
   / \
  2   3
  |
  4
  
  
 */
public class G_06_DFS {
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
		ArrayList<Integer> dfs = dfs(adj);
		System.out.println(dfs);
	}
	
	 public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
		 ArrayList<Integer> ans = new ArrayList<>();
		 boolean[] vis = new boolean[adj.size()];
		 adj(3, adj, vis, ans);
		return ans;  
    }

	 private static void adj(int node , ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
		 vis[node] = true;
		 ans.add(node);
		 for(Integer i : adj.get(node)) {
			 if(!vis[i])
				 adj(i, adj, vis, ans);
		 }
	 }
}
