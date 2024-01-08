package leetcode;

public class CountAndSay_38 {

	public static void main(String[] args) {
		String countAndSay = countAndSay(5);
		System.out.println(countAndSay);
	}

	private static String countAndSay(int n) {
		int j;
		String str = "1";
		int count =1;
		StringBuffer newStr = new StringBuffer();
		for(int i = 0 ; i<n-1 ;i++) {
			count=1;
			newStr.setLength(0);
			for (j=0 ; j<str.length()-1 ; j++) {
				if(str.charAt(j)== str.charAt(j+1)) {
					count++;
				}else {
                    newStr.append(count);
                    newStr.append(str.charAt(j)) ;
                    count=1;
				}
			}
			newStr.append(count);
            newStr.append(str.charAt(j)) ;
			str=newStr.toString();
		}
		return str;
	
    }
}
