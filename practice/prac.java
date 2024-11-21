package practice;

public class prac {
    public static void main(String[] args) {
    	int ar1[] = {1, 3, 4, 8};
		int ar2[] = {2, 5, 6, 8};
		
		double median = findMedian(ar1, ar2);
		System.out.println(median);
		
    }

	private static double findMedian(int[] ar1, int[] ar2) {
		int n = ar1.length;
		int m = ar2.length;
		int low = 0;
		int high = ar1.length-1;
		
		while(low <= high) {
			int i1 = (low+high)/2;
			int i2 = (n+m+1)/2 - i1;
			
			int max1 = (i1==0)?Integer.MIN_VALUE: ar1[i1-1];
			int max2 = (i2==0)?Integer.MIN_VALUE: ar2[i2-1];
			int min1 = (i1 == n)? Integer.MAX_VALUE: ar1[i1];
			int min2 = (i2 == n)? Integer.MAX_VALUE: ar2[i2];
			if(max1<= min2 && max2<=min1) {
				 if ((n + m) % 2 == 0) {
	                    return (Math.max(max1, max2) + Math.min(min1, min2)) / 2.0;
	                } 
	              
	                // If the total elements are odd, then median is 
	                // the middle element
	                else {
	                    return Math.max(max1, max2);
	                }
			}else if (max1>min2){
				high = i1-1;
				
			}else {
				low = i1+1;
			}
		}
		return 0;
		
	}

}
