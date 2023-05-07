package leetCode;

public class PeakIndexInMountainArray_852 {

	public static void main(String[] args) {
		int[] ar={0,1,2,1,0};
		int peakIndex = peakIndex(ar);
		System.out.println(peakIndex);
	}

	private static int peakIndex(int[] arr) {
		 int index=0;
	        for(int i=0 ; i<arr.length ;i++){
	            if(i+1 < arr.length && arr[i]<arr[i+1])
	                index++;
	        }
	        return index;
	}

}
