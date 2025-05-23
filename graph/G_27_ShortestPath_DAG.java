package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class G_27_ShortestPath_DAG {

	public static void main(String[] args) {

		/*
		 
		       2         3       6
		   0 ─────▶ 1 ─────▶ 2 ─────▶ 3
		   │               ▲          ▲
		   │          2    │          │
		   │  1   ┌────────┘      1   │
		   └────▶ 4 ─────▶ 5 ─────────┘
		              4
		              

		 */
		int V=6, E=7;
		int[][] edges= {
						{0,1,2},
						{0,4,1},
						{4,5,4},
						{4,2,2},
						{1,2,3},
						{2,3,6},
						{5,3,1}
					  };
		
		int[] shortestPath = Solution.shortestPath(V,E, edges);
		System.out.println(Arrays.toString(shortestPath));
		
	}
	
	class Solution {

	    public static int[] shortestPath(int V, int E, int[][] edges) {
	    	ArrayList<ArrayList<pair>> adj = new ArrayList<>();
	    	
	    	 for(int i=0; i<V; i++){
		            adj.add(new ArrayList<pair>());
		       }
	    	 
	    	for(int i = 0 ; i <E ; i++) {
	    		int u = edges[i][0];
	    		int v = edges[i][1];
	    		int wt = edges[i][2];
	    		adj.get(u).add(new pair(v, wt));
	    	}
	    	
	    	boolean[] vis = new boolean[V];
	    	Stack<Integer> stack = new Stack<>();
	    	
	    	for(int i = 0 ; i < V ; i++) {
	    		if(!vis[i]) {
	    			topoSort(i, vis, stack, adj);
	    		}
	    	}
	    	
	    	int dist[] = new int[V];
	    	Arrays.fill(dist, (int)1e9);
	    	dist[0]=0;
	    	
	    	while(!stack.isEmpty()) {
	    		Integer node = stack.peek();
	    		stack.pop();
	    		
	    		for(pair it : adj.get(node)) {
	    			int v = it.first;
	    			int wt = it.second;
	    			
	    			if(dist[node] + wt < dist[v]) {
	    				dist[v] = dist[node] + wt;
	    			}
	    		}
	    		
	    	}
	    	
	    	 for (int i = 0; i < V; i++) {
	    	      if (dist[i] == 1e9) dist[i] = -1;
	    	    }
	    	    
			return dist;
	        
	    }

		private static void topoSort(int node, boolean[] vis, Stack<Integer> stack, ArrayList<ArrayList<pair>> adj) {
			vis[node] = true;
			
			for(pair it : adj.get(node)) {
				int v = it.first;
				if(!vis[v]) {
					topoSort(v, vis, stack, adj);
				}
			}
			
			stack.push(node);
		}
		
		static class pair{
			int first, second;
			pair(int _first, int _second){
				this.first = _first;   //vertex
				this.second = _second; //weight
			}
		}
	}
	

}
