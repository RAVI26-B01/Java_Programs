package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class G_21_TopologicalSort {
	public static void main(String[] args) {
		
		/*
		 	1 → 0  ← 3                                5 → 0 ← 4   
		 		↑									  ↓       ↓
		 		2									  2 → 3 ← 1
		 		
		 	[3, 2, 1, 0]							 [4, 5, 0, 1, 2, 3]
			[1, 2, 3, 0]							 [5, 2, 4, 0, 1, 3]
			[2, 3, 1, 0]							 [5, 4, 2, 1, 3, 0]
		 
		 */
		int V = 4, E = 3;
		int edges[][] = {{3, 0}, {1, 0}, {2, 0}};
		ArrayList<Integer> topoSort1 = Solution.topoSort(V, edges);
		System.out.println(topoSort1);
		
		int V1 = 6, E1 = 6;
		int edges2[][] = {
							{1, 3},
							{2, 3}, 
							{4, 1}, 
							{4, 0}, 
							{5, 0}, 
							{5, 2}
						 };	
		
		ArrayList<Integer> topoSort2 = Solution.topoSort(V1, edges2);
		System.out.println(topoSort2);
						
	}
	
	
	class Solution {
	    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
	        ArrayList<Integer> ans = new ArrayList<>();
	        List<List<Integer>> adj = new ArrayList<>();
	        Stack<Integer> stack = new Stack<>();
	        boolean[] vis = new boolean[V];
	        
	        for(int i=0; i<V; i++){
	            adj.add(new ArrayList<>());
	        }
	        for(int[] edge : edges){
	            adj.get(edge[0]).add(edge[1]);
	        }
		        
		    for(int i=0; i<V; i++){
		        if(!vis[i]){
		            dfs(i, vis, adj, stack);
		        }
		    }
		    
		    while(!stack.isEmpty()){
		        ans.add(stack.peek());
		        stack.pop();
		    }
		    
		    return ans;
	    }
	    
	    public static void dfs(int node, boolean[] vis, 
	                           List<List<Integer>> adj, Stack<Integer> stack ){
	        vis[node] = true;
	        for(int it : adj.get(node)){
	             if(!vis[it]){
	                dfs(it, vis, adj, stack);
	             }
	        }
	        stack.add(node);
	    }
	}
}
