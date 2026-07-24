package leetcode;

import java.util.Arrays;

/*
	0 ... low-1      -> all 0s
	low ... mid-1    -> all 1s
	mid ... high     -> unknown (to be processed)
	high+1 ... n-1   -> all 2s
 */
public class SortColor_75 {

	public static void main(String[] args) {
		int[] ar = {2,0,2,1,1,0};
		sortColors(ar);
		System.out.println(Arrays.toString(ar));

	}

	public static void sortColors(int[] ar) {
			int n = ar.length;
			int low = 0 ;
			int high = n-1;
			int mid = 0;
			
			while(mid<=high) {
				if(ar[mid]==0){
					int temp = ar[low];
					ar[low]=ar[mid];
					ar[mid]=temp;
					low++;mid++;
				}
				else if(ar[mid]==1){
					mid++;
				}
				else{
					int temp = ar[high];
					ar[high]=ar[mid];
					ar[mid]=temp;
					high--;
				}
			}
		}

}
