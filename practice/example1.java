package practice;

public class example1 {
	public static void main(String[] args) {
		int[] ar = {3, 5, 6,1, 9,9,6,1}; //6
		int fl = Integer.MIN_VALUE ;
		int sl = Integer.MIN_VALUE;
		for(int i = 0 ; i<ar.length ; i++) {
			if(fl<ar[i]) {
				sl=fl;
				fl=ar[i];
			}
			else if(sl<ar[i] &&ar[i]!=fl ) {
				sl=ar[i];
			}
		}
		System.out.println(sl);
	}
}

  
  
  
  


