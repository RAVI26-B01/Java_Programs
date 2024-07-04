package leetcode;

public class BuySellStock_121 {

	public static void main(String[] args) {
		int[] ar = {2 ,4 , 1, 3};
		int maxProfit = maxProfit(ar);
		System.out.println(maxProfit);
		
	}
	
	public static int maxProfit(int[] ar) {
		int n = ar.length;
		int maxProfit = 0;
		int buyPrice  = ar[0];
		for(int i = 1 ; i< n ; i++) {
			if(ar[i]<buyPrice ) {
				buyPrice  = ar[i];
			}
			if((ar[i] - buyPrice  )>maxProfit)
			{
				maxProfit = ar[i] - buyPrice  ;
			}
		}
		
		return maxProfit;
	}
}
