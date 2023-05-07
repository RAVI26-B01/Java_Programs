package practice;

public class SwapFirstAndLastChar {
	public static void main(String[] args) {
		String s= "Ravi is good boy";
		swap(s);
	}

	private static void swap(String s) {
		int len = s.length();
		char[] ar = s.toCharArray();
		int k;
		for(int i = 0 ; i<len ; i++){
			k=i;
			while(i<len && ar[i]!=' '){
				i++;
			}
			char t = ar[i-1];
			ar[i-1] = ar[k];
			ar[k] = t;
			
		}
		System.out.println(ar);
	}
}
