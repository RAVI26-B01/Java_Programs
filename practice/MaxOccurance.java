package practice;

import java.util.HashMap;
import java.util.Map;

public class MaxOccurance {
	    public static String getMaxOccurrenceCharacters(String str) {
	        Map<Character, Integer> frequencyMap = new HashMap<>();
	        int maxFrequency = 0;
	        StringBuilder result = new StringBuilder();
	        for (char c : str.toCharArray()) {
	            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
	            int frequency = frequencyMap.get(c);
	            if (frequency > maxFrequency) {
	                maxFrequency = frequency;
	                result.setLength(0); // Clear the previous results
	                result.append(c);   
	            } 
	            else if (frequency == maxFrequency) {
	                result.append("$").append(c);
	            }
	        }
	        return result.toString();
	    }

	    public static void main(String[] args) {
	        String input = "abcaabbcc";
	        String result = getMaxOccurrenceCharacters(input);
	        System.out.println("Character(s) with the maximum occurrence: " + result);
	    }
}
