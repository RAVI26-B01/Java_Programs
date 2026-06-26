package Stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

// leetcode 1475
public class FinalPriceDiscount {

	public static void main(String[] args) {
		int[]	prices = {8,7,4,2,8,1,7,7,10,1};
		//1,3,2,1,7,0,0,6,9,1
		System.out.println(Arrays.toString(finalPrices(prices)));
	}
	
	public static int[] finalPrices(int[] prices) {
        for(int i=0;i<prices.length;i++){
            prices[i] = newPrice(prices,i);
        }
        return prices;
    }
    private static int newPrice(int[] prices,int i){
        for(int j=i+1;j<prices.length;j++){
            if(prices[j] <= prices[i]){
                return prices[i] - prices[j];
            }
        }
        return prices[i];
    }
    
    
    
    public static int[] finalPrices2(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        int n = prices.length;

        for(int i = n-1 ; i>=0 ; i--){
        	int price = prices[i];
            while(!stack.isEmpty() && price<stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                prices[i] = price-stack.peek();
            }
            stack.push(price);
        }

        return prices;
    }

}
