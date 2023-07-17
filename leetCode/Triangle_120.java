package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> l =
				new ArrayList<ArrayList<Integer>>();
		l.add(new ArrayList<>(Arrays.asList(-1)));
		l.add(new ArrayList<>(Arrays.asList(2,3)));
		l.add(new ArrayList<> (Arrays.asList(1,-1,-3)));
		//l.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
		System.out.println(l);
		int minimumTotal = minimumTotal(l);
		System.out.println(minimumTotal);
	}

	 public static int minimumTotal(ArrayList<ArrayList<Integer>> l) {
		 int sum = l.get(0).get(0);
		 int index = 0;
		 
		 for(int i=1 ; i<l.size();i++) {
			 int intMinIndex = 0;
			 if(l.get(i).get(index)<l.get(i).get(index+1)) {
				 intMinIndex=index;
			 }else {
				 intMinIndex=index+1;
			 }
			 sum=sum+l.get(i).get(intMinIndex);
		 }
	        return sum;
	    }
}
