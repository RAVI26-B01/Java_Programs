package leetcode;

public class SortVowels_2785 {

	public static void main(String[] args) {
		
		String s = "lYmpH";
		String sortVowels = sortVowels(s);
		//System.out.println(sortVowels);
		
	}
	 public static String sortVowels(String s) {
		 
		
		 
		 char[] ar = s.toCharArray();
		 for(int i = 0 ;i< ar.length ; i++) {
			 for(int j = 0 ; j<ar.length ; j++) {
				if( (ar[i] == 'a' || ar[i] == 'e'
						 ||  ar[i] == 'i' || ar[i] == 'o'
						 ||  ar[i] == 'u'
						 ||  ar[i] == 'A' || ar[i] == 'E'
						 ||  ar[i] == 'I' || ar[i] == 'O'
						 ||  ar[i] == 'U')
						 && ( ar[j] == 'a' || ar[j] == 'e'
						 ||  ar[j] == 'i' || ar[j] == 'o'
						 ||  ar[j] == 'u'
						 ||  ar[j] == 'A' || ar[j] == 'E'
						 ||  ar[j] == 'I' || ar[j] == 'O'
						 ||  ar[j] == 'U' )) {
					 if(ar[i]  < ar[j]) {
						 char temp = ar[i];
						 ar[i] = ar[j];
						 ar[j] = temp;
					 }
				}
				 
				
			 }
		 }
		 
		 
		 System.out.println(ar);
		 
		
		 
	        return ar.toString();
	  }

}
