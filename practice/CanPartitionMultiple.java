package practice;

public class CanPartitionMultiple {
	public static void main(String[] args) {
//		int[] ar = {2, 8, 4, 1};              -> true
//		int[] ar = {-1, 10, -1, -2, 20};      -> false
		int[] ar = {-1, 20, 5, -1, -2, 2};  //-> true
		boolean canPartation = canPartation(ar);
		System.out.println(canPartation);
	}

	private static boolean canPartation(int[] ar) {
		
		for(int i = 0 ; i<ar.length ; i++) {
			
			int curr = ar[i];
			int total = 1;
			for(int j = 0 ; j<ar.length ; j++) {
				if(j!=i)
					total *= ar[i];
			}
			
			if(total == curr)
				return true;
		}
		return false;
		
	}
}
