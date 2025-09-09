package practice;

public class SecondLargest {

	public static void main(String[] args) {
//		int[] ar = {2,5,6,9,1,12,15,17,18,19,18,19};
		int[] ar = {10, 9, 8};
		int secondLarge = findSecondLarge(ar);
		System.out.println(secondLarge);
	}

	private static int findSecondLarge(int[] ar) {
		int fl = Integer.MIN_VALUE;
		int sl = Integer.MIN_VALUE;
		
		for(int i = 0 ; i <ar.length ; i++) {
			if(ar[i]>fl) {
				sl = fl;
				fl = ar[i];
			}
			else if(ar[i]>sl && fl != ar[i]) {
				sl = ar[i];
			}
		}
		
		return sl;
	}
}
