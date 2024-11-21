package practice;

import java.util.HashMap;
import java.util.Map;

public class CalculateFractionOfTwoNums {
	public static String calculateFraction(int num, int den)
    {
		StringBuffer sb = new StringBuffer();
		if(num == 0 || den ==0)
			return "0";
		if((num<0) ^ (den<0))
			sb.append("-");
		
		num = Math.abs(num);
		den = Math.abs(den);
		
		int quo = num / den;
		int rem = num % den * 10;
		
		sb.append(quo);
		if(rem == 0)
			return sb.append("0").toString();
		else {
			sb.append(".");
	        Map<Integer, Integer> m   = new HashMap<>();
	        while(rem != 0) {
	        	
	        	if(m.containsKey(rem)) {
	        		
	        		Integer len = m.get(rem);
	        		String part1 = sb.substring(0,len);
	        		 String part2 = "("
                             + sb.substring(
                                 len, sb.length())
                             + ")";
              return part1 + part2;
	        		
	        	}
	        	m.put(rem, sb.length());
	        	quo = rem / den;
	    		rem = rem % den * 10;
	    		sb.append(quo);
	    		
	        }
		}
		return sb.toString();
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int num = 16;
        int den = 7;
 
        String resString1 = calculateFraction(num, den);
        System.out.println(resString1);
    }
}
