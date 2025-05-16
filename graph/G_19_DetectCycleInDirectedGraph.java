package graph;

import java.util.ArrayList;
import java.util.List;

public class G_19_DetectCycleInDirectedGraph {

	public static void main(String[] args) {
		int[][] edges = {
				{3,0},
				{4,2},
				{1,2}
		};
		System.out.println(Solution.isCyclic(5, edges));;
	}
	
	class Solution {
	    public static boolean isCyclic(int V, int[][] edges) {
	       boolean[] vis = new boolean[V];
			boolean[] track = new boolean[V];
			
			 List<List<Integer>> adj = new ArrayList<>();
	        for(int i=0; i<V; i++){
	            adj.add(new ArrayList<>());
	        }
	        for(int[] edge : edges){
	            adj.get(edge[0]).add(edge[1]);
	        }
	        System.out.println(adj);
			for(int i=0; i<V ;i++) {
				if(!vis[i]) {
					if(dfs(i, adj, vis, track))
					    return true;
				}
			}
			
	        return false;
	    }
	    
	    private static boolean dfs(int node ,List<List<Integer>> adj, boolean[] vis, boolean[] track) {
			vis[node] = true;
			track[node]= true;
			
			for(Integer n:adj.get(node)) {
				// when the node is not visited 
				if(!vis[n]) {
					if(dfs(n, adj,vis, track))
						return true;
				}
				// if the node has been previously visited
	            // but it has to be visited on the same path
				else if(track[n]) {
					return true;
				}
			}
			
			track[node]=false;
			return false;
		}
	}

}

