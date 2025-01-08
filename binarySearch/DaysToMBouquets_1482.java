package binarySearch;

import java.util.Arrays;

public class DaysToMBouquets_1482 {
	public static void main(String[] args)  {
		int[] bloomDay = {7,7,7,7,12,7,7};
		int m = 2;
		int k = 3;
		System.out.println(minDays(bloomDay, m, k));
	}
	
	public static int minDays(int[] bloomDay, int m, int k) {
		
		if((m*k)> bloomDay.length)
			return -1;
		int start = Arrays.stream(bloomDay).min().getAsInt();
		int end = Arrays.stream(bloomDay).max().getAsInt();
		
		while(start<=end) {
			
			int mid = (start+end)/2;
			int i = find(bloomDay, m , k, mid);
			if(i >= m)
				end=mid-1;
			else
				start = mid+1;
				
		}
		
		return start;
    }

	private static int find(int[] bloomDay, int m, int k, int mid) {
		int count =0;
		int possible =0;
		for(int bloom:bloomDay) {
			if(bloom <=mid) {
				count++;
			}else {
				possible += count/k;
				count=0;
			}
		}
		possible += count/k;
		return possible;
	}

}
