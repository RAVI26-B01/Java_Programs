package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeople_1282 {

	public static void main(String[] args) {

		int[] groupSize = {3, 3, 3, 3, 3, 1, 3, 1, 1, 2, 2, 1, 3};
		getOutput(groupSize);
		
		List<List<Integer>> groupThePeople = groupThePeople(groupSize);
		System.out.println(groupThePeople);
	}

	private static List<List<Integer>> getOutput(int[] groupSize) {
		Map<Integer, ArrayList<Integer>> map = new HashMap();
		  List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for(int i= 0 ;i<groupSize.length ; i++) {
			if(map.containsKey(groupSize[i])) {
				ArrayList<Integer> list = map.get(groupSize[i]);
				list.add(i);
			}else {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(i);
				map.put(groupSize[i], l);
			}
		}
		System.out.println(map);
		
		for(Map.Entry<Integer, ArrayList<Integer>> es : map.entrySet()) {
			Integer key = es.getKey();
			ArrayList<Integer> value = es.getValue();
			int N = value.size();
			 for (int i = 0; i < N  ; i += key) {
				 ans.add(new ArrayList<Integer>(
						 value.subList(i, Math.min(N, i + key)))
			        );
			    }
		}
		
		System.out.println(ans);
		 
		return null;
		
	}
	
	    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
	        Map<Integer, List<Integer>> map = new HashMap<>();
	        List<List<Integer>> ans = new ArrayList<>();   
	        for (int i = 0; i < groupSizes.length; i++) {
	            int size = groupSizes[i];   
	            map.putIfAbsent(size, new ArrayList<>());
	            if (map.get(size).size() == size) {
	                ans.add(map.get(size)); 
	                map.put(size, new ArrayList<>());  
	            }
	            map.get(size).add(i);
	        }

	        ans.addAll(map.values());   
	        return ans;   
	    }

}
