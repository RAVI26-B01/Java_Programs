package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class G_32_DijkstrasAlgorithm {

	public static void main(String[] args) {
		int v=6;
		int src=0;
		int[][] edges = {
				 			{0,2,4},
				 			{0,1,4},
				 			{1,0,4},
				 			{1,2,2},
				 			{2,0,4},
				 			{2,1,2},
				 			{2,3,3},
				 			{2,4,1},
				 			{2,5,6},
				 			{3,2,3},
				 			{3,5,2},
				 			{4,2,1},
				 			{4,5,3},
				 			{5,2,6},
				 			{5,3,2},
				 			{5,4,3}
						};
		
		System.out.println(Arrays.toString(dijkstra(v,edges,src)));;
	}
	
	
	public static int[] dijkstra(int V, int[][] edges, int src) {
		int dist[] = new int[V];
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
   	 	for(int i=0; i<V; i++){
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
 
	   	for(int i = 0 ; i <edges.length ; i++) {
	   		int u = edges[i][0];
	   		int v = edges[i][1];
	   		int wt = edges[i][2];
	   		adj.get(u).add(new ArrayList<Integer>(Arrays.asList(v,wt)));
	   	}
	   	System.out.println(adj);
	   	
	   	
	   	Arrays.fill(dist, (int) 1e9);
	   	PriorityQueue<pair32> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
	   	pq.add(new pair32(0,src));
	   	dist[src]=0;
	   	
	   	while(!pq.isEmpty()) {
	   		int distance = pq.peek().distance;
	   		int node = pq.peek().node;
	   		pq.poll();
	   		
	   		for(ArrayList<Integer> x:adj.get(node)) {
	   			Integer adjNode = x.get(0);
	   			Integer weight = x.get(1);
	   			if(distance+weight < dist[adjNode]) {
	   				dist[adjNode] = distance+weight;
	   				pq.add(new pair32(dist[adjNode], adjNode));
	   			}
	   		}
	   	}
		return dist;
        
    }
}

class pair32{
	int distance;
	int node;
	pair32(int _distance, int _node){
		this.distance = _distance;
		this.node = _node;
	}
}