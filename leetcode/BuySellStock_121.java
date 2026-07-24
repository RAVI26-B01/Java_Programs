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
	
	 public int maxProfit2(int[] prices) {
	        int min = prices[0];
	        int max = 0;
	        for(int i =0;i<prices.length;i++){
	            min = Math.min(min,prices[i]);
	            max = Math.max(max, (prices[i] - min));
	        }

	        return max;
	    }
}
