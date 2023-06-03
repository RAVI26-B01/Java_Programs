package practice;

public class DontAddBtw67 {

	public static void main(String[] args) {

		int[] ar = {3,4,1,9,6,4,2,7,8};
		int dontAdd = dontAdd(ar);
		System.out.println(dontAdd);
	}

	/*
	 * Don't add the numbers between 6  &7
	 */
	private static int dontAdd(int[] ar) {
		int sum=0;
		
		for(int i=0 ; i< ar.length ; i++) {
			if(ar[i]==6) {
				i++;
				while(ar[i]!=7)
					i++;
			}else {
				sum+=ar[i];
			}
		}
		return sum;
	}

}
