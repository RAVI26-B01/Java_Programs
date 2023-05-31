package practice;

public class DeletePairOfAdjecent {

	public static void main(String[] args) {

		String s="aaabbccaddd";
		
		String deletePair = deletePair(s);
		System.out.println(deletePair);
	}

	private static String deletePair(String s) {

		StringBuffer sb = new StringBuffer(s);
		int i=0;
		while(i<sb.length()-1) {
			
			if(sb.charAt(i)==sb.charAt(i+1)) {
				sb.delete(i, i+2);
				i=0;
			}
			else {
				i++;
			}
		}
		return sb.toString();
	}

}
