package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
    	List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30),
            new Employee("Bob", 25),
            new Employee("Alice", 30),
            new Employee("Charlie", 35),
            new Employee("Bob", 25),
            new Employee("Alice", 40)
        );

        Map<String, Map<Integer, Long>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.groupingBy(Employee::getAge, Collectors.counting())));
        System.out.println(collect);
        collect.forEach((name, ageMap)->{
        	ageMap.forEach((age,count)->{
        		System.out.println(name + "  Age - "+ age+":"+ count );
        	});
        });
  
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Calculate the total length of all names
        int totalLength = names.stream()
            .mapToInt(String::length)  // Transforming String to int (length)
            .sum();
        List<Integer> collect2 = names.stream().map(String::length).collect(Collectors.toList());
        System.out.println(collect2);
       
//        System.out.println(totalLength);
        
//         Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);;
         long count = Stream.iterate(0, n -> n + 2).limit(10).count();
//         System.out.println(count);
         
         Stream.generate(Math::random).limit(5).sorted(Comparator.reverseOrder()).forEach(System.out::println);
         
         Stream<List<String>> streamOfLists = Stream.of(Arrays.asList("a", "b"), Arrays.asList("c", "d"));
          streamOfLists.flatMap(List::stream).forEach(System.out::println);
          
          String reduce = names.stream().reduce("", String::concat);
          System.out.println(reduce);
          
          List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
          Set<Integer> items = new HashSet<>();
           Set<Integer> set = list.stream()
                  .filter(n -> !items.add(n)) // Set.add() returns false if the element was already in the set.
                  .collect(Collectors.toSet());
           System.out.println(set);
           
           Set<Integer> set2 = list.stream().filter(i -> Collections.frequency(list, i) > 1)
           .collect(Collectors.toSet());
           System.out.println(set2);
           
           List<Integer> numbers = Arrays.asList(1, 3,6, 5, 8, 9, 10);

           // Use stream to find any even number
           Optional<Integer> evenNumber = numbers.stream()
               .filter(n -> n % 2 == 0)  // Filter even numbers
               .findFirst();               // Find any even number

           // Print the result
           evenNumber.ifPresent(n -> System.out.println("Found an even number: " + n));
           
    }
}

