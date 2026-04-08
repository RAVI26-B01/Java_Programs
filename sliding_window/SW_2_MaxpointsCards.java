package sliding_window;

public class SW_2_MaxpointsCards {
	
	public static void main(String[] args) {
		int[] cardPoints = {1,2,3,4,5,6,1};
		int k = 3;
		int maxScore = maxScore(cardPoints, k);
		System.out.println(maxScore);
	}
	
	 public static int maxScore(int[] cardPoints, int k) {
	        
	        int l = 0;
	        int r = cardPoints.length - 1;
	        int max = 0;

	        while(l < k){
	            max += cardPoints[l];
	            l++;
	        }

	        int temp = max;
	        l--;
	        while(l >= 0){
	            temp += cardPoints[r]-cardPoints[l];
	            if(max < temp)
	                max = temp;
	            r--;
	            l--;
	        }
	        return max;
	    }
}
