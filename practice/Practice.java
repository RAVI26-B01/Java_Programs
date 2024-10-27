package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {
	public static void main(String[] args) {
		
//		List<String> s = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
//		
//		Map<String, Long> collect = s.stream().collect(Collectors.groupingBy(Object::toString,Collectors.counting()));
//		System.out.println(collect);
		
		int[] a = new int[] {4, 2, 5, 1};       
		int[] b = new int[] {8, 1, 9, 5};
//		1,2,4,5,8,9
		int[] distinct = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
		System.out.println(Arrays.toString(distinct));
		
//		emp
//		eid ename salary man_id
//		1                 4
//		2                 4
//		3                 5
//		4                 5
//		5                 null
//		
//		select * from emp e join emp m on e.man_id = m.eid 
//		
		
		List<List<Integer>> l = Arrays.asList(Arrays.asList(1,2,3,4),Arrays.asList(1,2,3,4));
		System.out.println(l);
	}
}
