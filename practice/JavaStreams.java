package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class JavaStreams {
 
	public static void main(String[] args) {
 
		List<Integer> list=Arrays.asList(10,30,20,40,30,10,9,7);
		
		List<Integer> collect = list.stream().filter(x->x*x>100).collect(Collectors.toList());
		
		System.out.println(collect);

		List<String> listString=Arrays.asList("raghu","reddy","loki","raghu","reddy");
		
		Map<String, Long> collect3 = listString.stream().collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
		System.out.println(collect3);

		List<Integer> evenNum=list.stream().filter(x-> x%2==0).collect(Collectors.toList());

		System.out.println(evenNum);

		List<String> upperCase=listString.stream().map(String::toUpperCase).collect(Collectors.toList());

		System.out.println(upperCase);

		List<String> ascSort=listString.stream().sorted().collect(Collectors.toList());

		System.out.println(ascSort);

		List<String> desSort=listString.stream().sorted((a1,a2) -> a2.compareTo(a1)).collect(Collectors.toList());

		System.out.println(desSort);

		Integer minNum=list.stream().min(Integer::compareTo).get();

		Integer minNum1=list.stream().min((a1,a2) -> a1.compareTo(a2)).get();

		System.out.println(minNum1);

		System.out.println(minNum);

		Integer maxNum=list.stream().max(Integer::compareTo).get();

		System.out.println(maxNum);

		String stringJoin=listString.stream().collect(Collectors.joining(", "));

		System.out.println(stringJoin);

		Integer combineAsOne=list.stream().reduce((a,b) -> a+b).get();

		System.out.println(combineAsOne);

		Set<Integer> set=new HashSet<>();

		List<Integer> printDuplicate=list.stream().filter(x-> !set.add(x)).collect(Collectors.toList());

		System.out.println(printDuplicate);

		Set<String> setString=new HashSet<>();

		System.out.println(listString.stream().filter(x -> !setString.add(x)).collect(Collectors.toList()));

		Map<Integer,List<String>> groupingByLength=listString.stream().collect(Collectors.groupingBy(String::length));

		groupingByLength.forEach((length,group) -> System.out.println(length +" "+ group));

		String findFirst=listString.stream().filter(x -> x.startsWith("r")).findFirst().get();

		System.out.println(findFirst);

		Integer sum=list.stream().mapToInt(Integer::intValue).sum();

		System.out.println(sum);

		OptionalDouble average=list.stream().mapToInt(Integer::intValue).average();

		System.out.println(average);

		List<String> removeDuplicates=listString.stream().distinct().collect(Collectors.toList());

		System.out.println(removeDuplicates);

		List<String> startsWithList=listString.stream().filter(x -> x.startsWith("r")).collect(Collectors.toList());

		System.out.println(startsWithList);

		Map<String,Long> noOfOccur=listString.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));

		noOfOccur.forEach((key,value) -> System.out.println(key +" "+ value));

		Map<Integer,Long> numOcc=list.stream().collect(Collectors.groupingBy(n -> n,Collectors.counting()));

		numOcc.forEach((key,value) -> System.out.println(key +" "+ value));

		String s="raghureddy";

//		char[] c=s.toCharArray();

		System.out.println(s.chars().mapToObj(e -> (char)e).collect(Collectors.groupingBy(t -> t,Collectors.counting())));

		
		List<abc> l = new ArrayList<>();
		l.add(new abc(1,"xyz",2));
		l.add(new abc(2,"abc",2));
		l.add(new abc(3,"wer",9));
		l.add(new abc(4,"klmn",10));
		
		Map<Integer, List<abc>> collect5 = l.stream().collect(Collectors.groupingBy(abc::getDept));
		System.out.println(collect5);
		
		 Map<Integer, Long> collect4 = l.stream().collect(Collectors.groupingBy(abc::getDept,Collectors.counting()));
		System.out.println(collect4);
		Entry<Integer, Long> entry = collect4.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(entry);
		 
		Map<Integer, Double> collect2 = l.stream().collect(Collectors.groupingBy(abc::getDept, Collectors.averagingInt(abc::getId)));
		System.out.println(collect2);
		
	
		Map<Object, Long> collect6 = s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(x->x, Collectors.counting()));
		System.out.println(collect6);
		
		
		Stream.iterate(1, i->i+1).limit(15).forEach(System.out::print);
		System.out.println();
		int sum2 = Stream.iterate(1, i->i+1).limit(15).mapToInt(Integer::intValue).sum();
		System.out.println(sum2);
		
		int sum3 = Stream.iterate(1, i->i+1).limit(15).reduce(0, (i,j)->i+j);
		System.out.println(sum3);
		
		
		String[] strlist= {"a","b","c"};
		Arrays.stream(strlist).map(x-> x+"z").forEach(System.out::print);
	}
 
}


class abc{
	int id;
	String name;
	int dept;
	public abc(int id, String name, int dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	
	
	
}

 
