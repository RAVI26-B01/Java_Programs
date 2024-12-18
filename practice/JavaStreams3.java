package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams3 {

	public static void main(String[] args) {
		List<Integer> listOfIntegers1 = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		 Map<Boolean, List<Integer>> oddEvenNumbersMap = 
               listOfIntegers1.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
       Set<Entry<Boolean, List<Integer>>> entrySet = oddEvenNumbersMap.entrySet();
       System.out.println("Odd and Even Numbers : "+ entrySet);
       
       List<String> listOfStrings1 = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
       String joining = listOfStrings1.stream().collect(Collectors.joining(",", "[", "]"));
       System.out.println("Joining : "+joining);
       
       List<Integer> listOfIntegers5 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
       List<Integer> multiples_5 = listOfIntegers5.stream().filter(x->x%5==0).collect(Collectors.toList());
       System.out.println("Multiple of 5's" +multiples_5 );
       
       List<Integer> listOfIntegers2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
       Integer min = listOfIntegers2.stream().min(Integer::compareTo).get();
       System.out.println("Minium :" + min);
       Integer max = listOfIntegers2.stream().max((a,b)->a.compareTo(b)).get();
       System.out.println("Maxium :"+ max);
       
       int[] a = new int[] {4, 2, 7, 1};
       int[] b = new int[] {8, 3, 9, 5};
       int[] array = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
       System.out.println("Distinct & Sort 2 Arrays : "+ Arrays.toString(array));
       
       List<Integer> listOfIntegers3 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
       List<Integer> min_3_nums = listOfIntegers3.stream().sorted().limit(3).collect(Collectors.toList());
       System.out.println("Minimum 3 Numbers "+ min_3_nums);
       
       List<Integer> max_3_nums = listOfIntegers3.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
       System.out.println("Maxium 3 Numbers "+ max_3_nums);
       
       String s1 = "RaceCar";
       String s2 = "CarRace";
       s1 = Stream.of(s1.split("")).map(x->x.toUpperCase()).sorted().collect(Collectors.joining());
       s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
       if (s1.equals(s2)) 
       {
           System.out.println("Two strings are anagrams");
       }
       else
       {
           System.out.println("Two strings are not anagrams");
       }
       
       int i = 15623;
       Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
       System.out.println("Sum Of Digits 15623 :" +sumOfDigits);
       int reduce = String.valueOf(i).chars().map(x->(x-'0')).sum();
       System.out.println(reduce);
       
       List<Integer> listOfIntegers4 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
       Integer secondLargestNumber = listOfIntegers4.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
       System.out.println("Second Largest : "+ secondLargestNumber);


       List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
       List<String> lenString = listOfStrings.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
       System.out.println("sort Strings according to increasing order of their length" + lenString);
       
       int[] a1 = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
       int sum = Arrays.stream(a1).sum();
       System.out.println("Sum : "+sum);
       double average = Arrays.stream(a1).average().getAsDouble();
       System.out.println("Average : "+average);
       
       List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
       List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
       List<Integer> common = list1.stream().filter(list2::contains).collect(Collectors.toList());
       System.out.println("common elements between two Lists : " + common);
       
       String str = "Java Concept Of The Day";
       String reversedStr = Arrays.stream(str.split(" "))
                                   .map(word -> new StringBuffer(word).reverse())
                                   .collect(Collectors.joining(" "));
       System.out.println("Reverse Each Word : " + reversedStr);
       
       int sum1 = IntStream.range(1, 11).sum();
       System.out.println("First 10 Natural Number sum : "+ sum1);
       
       int[] array1 = new int[] {5, 1, 7, 3, 9, 6};
       int[] reversedArray = IntStream.rangeClosed(1, array1.length).map(x -> array1[array1.length - x]).toArray();
       System.out.println("Reverse Array : "+ Arrays.toString(reversedArray));
       
       int[] reversedArray1 = IntStream.range(0, array1.length).map(x -> array1[array1.length - 1 - x]).toArray();
       System.out.println("Reverse Array : "+ Arrays.toString(reversedArray1));
       
       int[] array2 = Stream.iterate(0, x->x+1).limit(array1.length).mapToInt(x -> array1[array1.length - 1 - x]).toArray();
       System.out.println("Reverse Array : "+ Arrays.toString(array2));
       
       List<Integer> evenNums = IntStream.rangeClosed(1, 10).map(x -> x * 2).mapToObj(x->x).collect(Collectors.toList());
       System.out.println("First 10 even Numbers : "+ evenNums);
       
       List<String> listOfStrings2 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
       Map<String, Long> elementCountMap = listOfStrings2.stream()
                                                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
       Entry<String, Long> mostFrequentElement = elementCountMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
       System.out.println("Most Frequent element : "+ mostFrequentElement);
        
       
       String str1 = "ROTATOR";
       boolean isItPalindrome = IntStream.range(0, str1.length()/2).
               noneMatch(x -> str1.charAt(x) != str1.charAt(str1.length() - x -1));
       if (isItPalindrome)
       {
           System.out.println(str1+" is a palindrome");
       }
       else
       {
           System.out.println(str1+" is not a palindrome");
       }
       

       List<String> listOfStrings3 = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
       List<String> startNums = listOfStrings3.stream().filter(x -> Character.isDigit(x.charAt(0))).collect(Collectors.toList());
       System.out.println("strings which start with a number : " + startNums);
       
       
       List<Integer> listOfIntegers6 = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
       Set<Integer> uniqueElements = new HashSet<>();
       Set<Integer> duplicateElements = listOfIntegers6.stream().filter(x -> !uniqueElements.add(x)).collect(Collectors.toSet());
       System.out.println("Duplicate Elements in List : "+ duplicateElements);
       
       String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
       Set<String> uniqueChars = new HashSet<>();
       Set<String> duplicateChars =   Arrays.stream(inputString.split(""))
                       .filter(ch -> ! uniqueChars.add(ch))
                       .collect(Collectors.toSet());
       System.out.println("Duplicate Character in String : " + duplicateChars);
       
       String inputString2 = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
       Map<String, Long> charCountMap = 
                           Arrays.stream(inputString2.split(""))
                                   .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
       String firstRepeatedChar = charCountMap.entrySet()
                                               .stream()
                                               .filter(entry -> entry.getValue() > 1)
                                               .map(entry -> entry.getKey())
                                               .findFirst()
                                               .get();
       System.out.println("First Repeated Chracter : "+ firstRepeatedChar);
       
       String firstNonRepeatedChar = charCountMap.entrySet()
                                               .stream()
                                               .filter(entry -> entry.getValue() == 1)
                                               .map(entry -> entry.getKey())
                                               .findFirst()
                                               .get();
       System.out.println("First Non-Repeated Chracter : "+ firstNonRepeatedChar);
       
       List<String> listOfStrings4 = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
       String lastElement = listOfStrings4.stream().skip(listOfStrings4.size() - 1).findFirst().get();
       System.out.println("Last Element in an array : "+ lastElement);
       
       // find first element in a list
       List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
       myList.stream()
             .findFirst()
             .ifPresent(System.out::println);
       
	}
}
