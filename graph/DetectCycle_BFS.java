package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycle_BFS {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		adj.add(new ArrayList<>(Arrays.asList(2,4)));
		adj.add(new ArrayList<>(Arrays.asList(1,3)));
		adj.add(new ArrayList<>(Arrays.asList(2,6)));
		adj.add(new ArrayList<>(Arrays.asList(1,7,5)));
		adj.add(new ArrayList<>(Arrays.asList(6,4)));
		adj.add(new ArrayList<>(Arrays.asList(3,5)));
		adj.add(new ArrayList<>(Arrays.asList(4)));
//		System.out.println(adj);
		boolean detectCycle = detectCycle(adj);
		if(detectCycle) {
			System.out.println("Cycle is Present");
		}else {
			System.err.println("Cycle is not Present");
		}
	}

	private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis = new boolean[adj.size()+1];
		for(int i = 0 ; i <adj.size(); i++) {
			if(!vis[i]) {
				if(detectCycle(i, -1, adj, vis))
					return true;
			}
		}
		return false;
	}

	private static boolean detectCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
		
		for(int n :adj.get(node-1)) {
			if(!vis[n]) {
				vis[n]=true;
				return detectCycle(n, node, adj, vis);
			}else if(n != parent) {
				return true;
			}
		}
		
		return false;
	}
}
