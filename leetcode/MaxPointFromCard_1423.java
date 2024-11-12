package leetcode;

public class MaxPointFromCard_1423 {

	public static void main(String[] args) {
		int[] ar = {1,2,3,4,5,6,1};
		int k = 3;
		int maxScore = maxScore(ar,k);
		System.out.println(maxScore);
	}
	
	public static int maxScore(int[] ar, int k) {
        
		int l=0,r=ar.length-1;
		int max = 0;
		while(l<k) {
			max = max+ar[l];
			l++;
		}
		
		int temp = max;
		l--;
		while(l>=0)
		{
			temp = temp-ar[l]+ar[r];
			if(temp>max)    
				max=temp;
			l--;
			r--;
		}
		
		return max;
	
    }
}
