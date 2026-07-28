package practice;

public class Practice {
	public static void main(String[] args) {

		 int[] arr =  {2, 4, 6, 8, 8, 8,8, 11, 13};
	        int n = 8, x = 8;
	        int ans = count(arr, n, x);
	        System.out.println("The number of occurrences is: " + ans);
	}

	private static int count(int[] arr, int n, int target) {
		int[] firstandLast = findFirstandLast(arr, n , target);
		if(firstandLast[0]==-1)return 0;
		 return firstandLast[1]-firstandLast[0]+1;
	}

	private static int[] findFirstandLast(int[] arr, int n, int target) {
		int first = findFirst(arr, n , target);
		if(first == -1)
			return new int[] {-1,-1};
		int last = findlast(arr, n , target);
		return new int[] {first,last};
		
	}

	private static int findFirst(int[] arr, int n, int target) {
		
		int low = 0 ; 
		int high = n-1;
		int first = -1;
		while(low<=high) {
			int mid = (low+high)/2;
			
			if(arr[mid]==target) {
				first = mid;
				high = mid-1;
			}
			else if(arr[mid] > target) {
				high = mid - 1;
			}
			else
			{
				low = mid+1;
			}
		}
		return first;
		
	}

private static int findlast(int[] arr, int n, int target) {
		
		int low = 0 ; 
		int high = n-1;
		int last = -1;
		while(low<=high) {
			int mid = (low+high)/2;
			
			if(arr[mid]==target) {
				last = mid;
				low = mid+1;
			}
			else if(arr[mid] > target) {
				high = mid - 1;
			}
			else
			{
				low = mid+1;
			}
		}
		return last;
		
	}
}