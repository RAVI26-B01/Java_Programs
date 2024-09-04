package sliding_window;

import java.util.HashSet;

public class SubstringwithAtmostKChars {

	public static void main(String[] args) {
		String s = "aaabbccd";
		int k =2;
		int solution = solution(s, k);
		System.out.println(solution);
	}
	
	public static int solution(String str,int k){
	    int n =str.length();
	    int maxLength =0;
	    for(int i=0;i<n;i++){
	        HashSet<Character>set = new HashSet<>();
	        for(int j=i;j<n;j++){
	            set.add(str.charAt(j));
	            if(set.size()<=k){
	                int length =j-i+1;
	                maxLength =Math.max(maxLength,length);
	            }else{
	                break;
	            }
	        }
	    }
	    return maxLength;
	}
}
