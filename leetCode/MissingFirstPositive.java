package leetcode;

public class MissingFirstPositive {

	public static void main(String[] args) {
		int[] ar={6,-1,-3,1,2};
		int findMissing = findMissing(ar);
		System.out.println(findMissing);
	}

	private static int findMissing(int[] ar) {
		int size = ar.length;
		int[] newArr  = new int[size+1];
		/*
		 * all elements are placed inside array w.r.t index.
		 * missing value is replaced with 0.
		 * value greater then index will be neglected(not stored in new array)
		 */
		for(int i=0; i<size ; i++){
			int temp=ar[i];
			if(ar[i]>0 && ar[i]<=size){
				newArr[temp]=temp;
			}
		}
		
		for(int i=1;i<newArr.length;i++){
			if(newArr[i]!=i){
				return i;
			}
		}
		return size+1;
		
	}

}
