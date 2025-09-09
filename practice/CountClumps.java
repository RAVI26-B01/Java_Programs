package practice;

public class CountClumps {
	public static void main(String[] args) {
		int[] ar = {1,2,2,3,4,4};
		
		int count = count(ar);
		System.out.println(count);
	}

	private static int count(int[] ar) {

		int count = 0;
		for(int i = 0 ; i<ar.length ; i++) {
			if(ar[i] == ar[i+1]) {
				count++;
			}
			while(i<ar.length-1 && ar[i] == ar[i+1]) {
				i++;
			}
		}
		
		return count;
	}
}
