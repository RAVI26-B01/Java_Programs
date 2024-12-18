package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class JavaStreams {
 
	public static void main(String[] args) {
 
		List<Integer> list=Arrays.asList(10,30,20,40,30,10,9,7);
		
		List<Integer> collect = list.stream().filter(x->x*x>100).collect(Collectors.toList());
		
		System.out.println("filter x*x > 100: " + collect);

		List<String> listString=Arrays.asList("raghu","reddy","loki","raghu","reddy");
		
		Map<String, Long> keyPairNames = listString.stream().collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
		System.out.println("GroupBy Names : "+keyPairNames);

		List<Integer> evenNum=list.stream().filter(x-> x%2==0).collect(Collectors.toList());
		System.out.println("Even Numbers : " +evenNum);

		List<String> upperCase=listString.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("UpperCase : "+ upperCase);

		List<String> ascSort=listString.stream().sorted().collect(Collectors.toList());
		System.out.println("Asscending Order : "+ascSort);

		List<String> desSort=listString.stream().sorted((a1,a2) -> a2.compareTo(a1)).collect(Collectors.toList());
		System.out.println("Descending Order : "+desSort);

		Integer minNum=list.stream().min(Integer::compareTo).get();
		Integer minNum1=list.stream().min((a1,a2) -> a1.compareTo(a2)).get();
		System.out.println("minimun Number : "+minNum1);
		System.out.println("minimun Number : "+minNum);

		
		Integer maxNum=list.stream().max(Integer::compareTo).get();
		System.out.println("Max Number : "+maxNum);

		String stringJoin=listString.stream().collect(Collectors.joining(", "));
		System.out.println("Join String by , : "+stringJoin);

		Integer combineAsOne=list.stream().reduce((a,b) -> a+b).get();
		System.out.println("reduce : "+combineAsOne);

		Set<Integer> set=new HashSet<>();
		List<Integer> printDuplicate=list.stream().filter(x-> !set.add(x)).collect(Collectors.toList());
		System.out.println("printDuplicate : "+printDuplicate);

		Map<Integer,List<String>> groupingByLength=listString.stream().collect(Collectors.groupingBy(String::length));
		groupingByLength.forEach((length,group) -> System.out.println(length +" "+ group));

		String findFirst=listString.stream().filter(x -> x.startsWith("r")).findFirst().get();
		System.out.println(findFirst);

		Integer sum=list.stream().mapToInt(Integer::intValue).sum();
		Integer integer = list.stream().reduce((x,y)->x+y).get();
		System.out.println(sum + " " + integer);

		OptionalDouble average=list.stream().mapToInt(Integer::intValue).average();
		System.out.println("average :"+ average);

		List<String> removeDuplicates=listString.stream().distinct().collect(Collectors.toList());
		System.out.println(removeDuplicates);

		List<String> startsWithList=listString.stream().filter(x -> x.startsWith("r")).collect(Collectors.toList());
		System.out.println(startsWithList);

		String s="raghureddy";
		Map<Object, Long> collect6 = s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(x->x, LinkedHashMap::new, Collectors.counting()));
		System.out.println("key value pair: "+collect6);
		
		List<abc> l = new ArrayList<>();
		l.add(new abc(1,"xyz",2));
		l.add(new abc(2,"abc",2));
		l.add(new abc(3,"wer",9));
		l.add(new abc(4,"klmn",10));
		
		Map<Integer, List<abc>> collect5 = l.stream().collect(Collectors.groupingBy(abc::getDept));
		System.out.println("collect5: "+collect5);
		
		 Map<Integer, Long> collect4 = l.stream().collect(Collectors.groupingBy(abc::getDept,Collectors.counting()));
		System.out.println("collect4: "+collect4);
		Entry<Integer, Long> entry = collect4.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("entry: "+entry);
		 
		Map<Integer, Double> collect2 = l.stream().collect(Collectors.groupingBy(abc::getDept, Collectors.averagingInt(abc::getId)));
		System.out.println(collect2);
	
		
		Stream.iterate(1, i->i+1).limit(15).forEach(System.out::print);
		System.out.println();
		int sum2 = Stream.iterate(1, i->i+1).limit(15).mapToInt(Integer::intValue).sum();
		System.out.println(sum2);
		
		int sum3 = Stream.iterate(1, i->i+1).limit(15).reduce(0, (i,j)->i+j);
		int sm4 = Stream.iterate(1, i->i+1).limit(15).reduce(0, Integer::sum);
		System.out.println(sum3);
		
		
		String[] strlist= {"a","b","c"};
		Arrays.stream(strlist).map(x-> x+"z").forEach(System.out::println);
		System.out.println();
		
		
		List<Integer> i= Arrays.asList(1, 2, 3 ,4, 3, 1);
		List<List<Integer>> ll = new ArrayList<>();
		ll.add(i);
		Stream<Integer> flatMap = ll.stream().flatMap(x->x.stream()); // flatMap return stream<Integer>
		int flatMapSum = flatMap.mapToInt(x->x).sum();	//maptoInt() converts to IntStream so we can apply sum()
		System.out.println("flatmap sum :" + flatMapSum);
		
		/*
		 * Note
		 *  flatMap on 2d arrays
		 *  flatMapToInt we have to use for primitive array
		 *  Arrays::stream
		 */
		int[][] ar = {{1, 2, 3} ,{4, 3, 1}};
		int flatSum = Stream.of(ar).flatMapToInt(Arrays::stream).sum();
		System.out.println(flatSum);
		 Stream<Integer> boxedArray = Stream.of(ar).flatMapToInt(Arrays::stream).boxed();
		 System.out.println(boxedArray);
		 
		 // count character in a string
		 String str = "malayalam";
		 char c = 'a';
		 long sum4 =  str.chars().filter(x->x==c).count();
		 System.out.println("Character count = " + sum4);
		 
		 
		 String str2 = "Indivisibilities";
		 Map<Character,Long> collect3 = str2.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 long count = collect3.values().stream().filter(x->x>1).count();
		 System.out.println(count);
		 
		 List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		 Map<Boolean, List<Integer>> oddEvenNumbersMap = 
	                listOfIntegers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
         Set<Entry<Boolean, List<Integer>>> entrySet = oddEvenNumbersMap.entrySet();
         System.out.println("Odd and Even Numbers : "+ entrySet);
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

 
