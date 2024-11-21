package practice;

import java.util.HashMap;

public class StudentMaxAvrg {

	public static void main(String[] args) {
		   String[][] students = {
	                {"Charles", "84"},
	                {"John", "100"},
	                {"Andy", "37"},
	                {"John", "23"},
	                {"Charles", "20"}
	        };

		   System.out.println(highestAverageMarks(students)); // Output: 61.5
	}

	private static double highestAverageMarks(String[][] students) {
        HashMap<String ,int[]> map = new HashMap<>();
        for(String [] s: students){
            String name = s[0];
            int marks = Integer.parseInt(s[1]);

            if(!map.containsKey(name)){
                map.put(name, new int[]{0,0});
            }
            map.get(name)[0]+=marks;
            map.get(name)[1]++;
        }
        double maxAvg = Double.NEGATIVE_INFINITY;
        for(String s: map.keySet()){
            int mark  = map.get(s)[0];
            int repeat = map.get(s)[1];
            double avg = (double) mark/repeat;
            maxAvg = Math.max(maxAvg,avg);
        }
        return maxAvg;
    }
}
