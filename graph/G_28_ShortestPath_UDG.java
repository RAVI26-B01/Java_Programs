package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class G_28_ShortestPath_UDG {

	public static void main(String[] args) {

		int V=9, E=10;
		int[][] edges= {
						{0, 1},
						{0, 3},
						{3, 4},
						{4, 5},
						{5, 6},
						{1, 2},
						{2, 6},
						{6, 7},
						{7, 8},
						{6, 8},
					  };
		
		int[] shortestPath = Solution.shortestPath(V,E, edges, 0);
		System.out.println(Arrays.toString(shortestPath));
		
	}

	class Solution {

	    public static int[] shortestPath(int V, int E, int[][] edges, int src) {
	    	ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	    	
	    	 for(int i=0; i<V; i++){
		            adj.add(new ArrayList<Integer>());
		       }
	    	 for(int[] edge : edges){
		            adj.get(edge[0]).add(edge[1]);
		        }
			        
	    	 
	    	 int dist[] = new int[V];
	    	 Arrays.fill(dist, (int)1e9);
	    	dist[0]=0;
	     	Arrays.fill(dist, (int)1e9);
	     	Queue<Integer> q = new LinkedList<>();
	     	dist[src]=0;
	     	q.add(src);
	     	
	     	while(!q.isEmpty()){
	     	    int node = q.peek();
	     	    q.poll();
	     	    for(Integer it : adj.get(node)){
	     	        
	     	        if(dist[node] + 1 < dist[it])
	     	        {
	     	            dist[it] = dist[node]+1;
	     	            q.add(it);
	     	        }
	     	    }
	     	}
	     	
	         for (int i = 0; i < V; i++) {
    	      if (dist[i] == 1e9) dist[i] = -1;
    	    }
    	    
		return dist;
	        
	    }

	}	
}
