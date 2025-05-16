package graph;

import java.util.ArrayList;
import java.util.List;

/*
 * below are the not safe nodes
 * 1. any node which is part of cycle
 * 2. any node leads to a cycle 
 */

public class G_20_EventualSafeState {

	public static void main(String[] args) {
		/*
		 
		  0 → 1 → 2 → 3 → 5          						 0 → 1 → 2 → 3 ← 5                    
              ↑       ↓   ↓										 ↑       ↓   ↑
              8       4	→ 6 → 7									 8       4 → 6 → 7
              ↓ ↖												 ↓ ↖
              9→10												 9→10
             ↗													↗
           11												  11
           
           
		 */
		
		int[][] edges1 = {
				{0,1},
				{1,2},
				{2,3},
				{3,4},
				{3,5},
				{4,6},
				{5,6},
				{6,7},
				{8,1},
				{8,9},
				{9,10},
				{10,8},
				{11,9}
		};
		
		int[][] edges2 = {
				{0,1},
				{1,2},
				{2,3},
				{3,4},
				{4,6},
				{6,5},
				{5,3},
				{6,7},
				{8,1},
				{8,9},
				{9,10},
				{10,8},
				{11,9}
		};
		List<Integer> eventualSafe1 = Solution.eventualSafe(12, edges1);
		System.out.println(eventualSafe1);
		
		List<Integer> eventualSafe2 = Solution.eventualSafe(12, edges2);
		System.out.println(eventualSafe2);
	}
	
	class Solution {
	    public static List<Integer> eventualSafe(int V, int[][] edges) {
	       boolean[] vis = new boolean[V];
			boolean[] track = new boolean[V];
			int[] check = new int[V];
			List<Integer> ans = new ArrayList<>();
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
					dfs(i, adj, vis, track, check);
				}
			}
			
			for(int i = 0 ; i<V; i++) {
				if(check[i]==1)
					ans.add(i);
			}
			
	       return ans;
	    }
	    
	    private static boolean dfs(int node ,List<List<Integer>> adj, boolean[] vis, boolean[] track, int[] check) {
			vis[node] = true;
			track[node]= true;
			check[node]=0;
			for(Integer n:adj.get(node)) {
				// when the node is not visited 
				if(!vis[n]) {
					if(dfs(n, adj,vis, track, check))
						return true;
				}
				// if the node has been previously visited
	            // but it has to be visited on the same path
				else if(track[n]) {
					return true;
				}
			}
			
			check[node]=1;
			track[node]=false;
			return false;
		}
	}

}


