package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;




public class Practice {
	public static void main(String[] args) {
		String[] str = {"ravi","raj",""," ","king",null};
		List<Integer> list=Arrays.asList(10,30,20,40,30,10,9,7,7);
		
		String[] array = Arrays.stream(str)
				.filter(Objects::nonNull)
				.filter(x-> x!=null && !x.isBlank() ).toArray(String[]::new);
		System.out.println(Arrays.toString(array));
		
		Integer collect = list.stream().min((a1,a2)->a2.compareTo(a1)).get();
		System.out.println(collect);
		
		Set<Integer> set = new HashSet<>();
		List<Integer> dup = list.stream().filter(x->!set.add(x)).collect(Collectors.toList());
		System.out.println(dup);
		
		String s = "abcdabcklm";
		
		Map<String,Long> collect2 = s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Object::toString,Collectors.counting()));
		System.out.println(collect2);
		
		Entry<String, Long> entry = collect2.entrySet().stream().filter(x->x.getValue()==1).map(x->x).findFirst().get();
		System.out.println(entry);
		
		Entry<String, Long> entry2 = collect2.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("max  : " + entry2);
		
		int sum = IntStream.rangeClosed(1, 15).sum();
		System.out.println(sum);
		
		int sum2 = Stream.iterate(1, i->i+1).limit(15).mapToInt(x->x).sum();
		System.out.println("sum2 "+sum2);
		
		
		Function<Integer, Integer> fun = Demo::square;
		
		System.out.println(fun.apply(10));;
		
		String s1 = "malayalam";
		
		boolean noneMatch = IntStream.range(0, s1.length()/2).allMatch(i-> s1.charAt(i) == s1.charAt(s1.length()-1-i));
		System.out.println(noneMatch);
		
		int[] ar = {2,4,3,5,6,6,2,7,8,3};
		
		Set<Integer> collect3 = Arrays.stream(ar).boxed().collect(Collectors.toSet());
		
		int[] array2 = IntStream.rangeClosed(1, 9).filter(i-> !collect3.contains(i)).toArray();
		System.out.println(Arrays.toString(array2));
		
		
		 String s2 = "Java Concept Of The Day";
		 
		 String collect4 = Arrays.stream(s2.split(" "))
		 .map(x-> new StringBuffer(x).reverse())
		 .collect(Collectors.joining(" "));
		 
		 System.out.println(collect4);
		 
		 int[] array1 = new int[] {5, 1, 7, 3, 9, 6};
		 
		 int[] array3 = IntStream.range(0, array1.length).map(i -> array1[array1.length-i-1]).toArray();
		 System.out.println(Arrays.toString(array3));
		
		
		
	}
	
	class Demo{
		
		public static int square(int n) {
			return n*n;
		}
	}





}
