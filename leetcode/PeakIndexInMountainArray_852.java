package leetcode;

public class PeakIndexInMountainArray_852 {

	public static void main(String[] args) {
		int[] ar={0,1,2,0};
		int peakIndex = peakIndex(ar);
		System.out.println(peakIndex);
		int peakIndexInMountainArray = peakIndexInMountainArray(ar);
		System.out.println(peakIndexInMountainArray);
	}

	
	 public static int peakIndexInMountainArray(int[] arr) {
	        int start = 0, end = arr.length - 1, mid;
	        while (start < end) {
	            mid = (start + end) / 2;
	            if (arr[mid] < arr[mid + 1])
	                start = mid + 1;
	            else
	                end = mid;
	        }
	        return start;
	    }
	 
	private static int peakIndex(int[] arr) {
	        for(int i=1 ; i<arr.length ;i++){
	            if(i < arr.length && arr[i]<arr[i-1])
	            	return i-1;
	        }
	        return 0;
	}

}
