package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructLargeNumber {

    public static void main(String[] args) {
    List<Integer> nums= Arrays.asList(7,58,87,2,16);
    
    Collections.sort(nums, (a,b)->
    	(String.valueOf(b)+a).compareTo(String.valueOf(a)+b)
    );
    System.out.println(nums);
    System.out.println(nums.stream().map(Object::toString).collect(Collectors.joining("")));
    }
}
