package geeksforgeeks;

import java.util.stream.IntStream;


public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int ar1[] = {1, 3, 4, 8};
		int ar2[] = {2, 5, 6, 8};
		
		double median = getMedian(ar1, ar2);
		System.out.println("median : "+ median);
		
		System.out.println(medianOf2(ar1, ar2));

	}

	private static double getMedian(int[] ar1, int[] ar2) {
		
		int[] array = IntStream.concat(IntStream.of(ar1), IntStream.of(ar2)).sorted().toArray();
		int n = array.length;
		if(array.length % 2 ==1) {
			return array[n/2];
		}
		else {
			return (array[n/2-1]+array[n/2])/2.0;
		}
	}

	/*
	 * Time Complexity: O(log(min(m, n)), 
	 * since binary search is applied on the smaller array.
	 *	Auxiliary Space: O(1)
	 */
			
   public static double medianOf2(int[] ar1, int[] ar2) {
        int n = ar1.length, m = ar2.length;
        
        // If ar1 has more elements, then call medianOf2 
        // with reversed parameters
        if (n > m) {
            return medianOf2(ar2, ar1);
        }
        
        int low = 0, high = n;
        while (low <= high) {
            int i1 = (low + high) / 2;
            int i2 = (n + m + 1) / 2 - i1;

            // Find elements to the left and right of partition in ar1
            int max1 = (i1 == 0 ? Integer.MIN_VALUE : ar1[i1 - 1]);
            int min1 = (i1 == n ? Integer.MAX_VALUE : ar1[i1]);

            // Find elements to the left and right of partition in ar2
            int max2 = (i2 == 0 ? Integer.MIN_VALUE : ar2[i2 - 1]);
            int min2 = (i2 == m ? Integer.MAX_VALUE : ar2[i2]);

            // If it is a valid partition
            if (max1 <= min2 && max2 <= min1) {
              
                // If the total elements are even, then median is 
                // the average of two middle elements
                if ((n + m) % 2 == 0) {
                    return (Math.max(max1, max2) + Math.min(min1, min2)) / 2.0;
                } 
              
                // If the total elements are odd, then median is 
                // the middle element
                else {
                    return Math.max(max1, max2);
                }
            }

            // Check if we need to take lesser elements from ar1
            if (max1 > min2) {
                high = i1 - 1;
            } 
          
            // Check if we need to take more elements from ar1
            else {
                low = i1 + 1;
            }
        }
        
        return 0;
    }

}

