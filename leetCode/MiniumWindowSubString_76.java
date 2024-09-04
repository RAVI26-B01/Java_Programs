package leetcode;

public class MiniumWindowSubString_76 {
	public static void main(String[] args) {
		String s= "ADOBECODEBANC";
		String t= "ABC";
		String minWindow = minWindow(s, t);
		System.out.println(minWindow); //BANC
	}

	
	public static String minWindow(String s, String t) {
        int[] chars = new int[256];
		int l =0 ;
		int r= 0;
		int count = 0;
		int sIndex = -1;
		int minLen = Integer.MAX_VALUE;
		
		for(int i = 0 ; i<t.length() ;i++) {
			chars[t.charAt(i)]++;
		}
		while(r<s.length()) {
			
			if(chars[s.charAt(r)]>0) {
				count++;
			}
			chars[s.charAt(r)]--;
			while(count == t.length()) {
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    sIndex=l;
                }

				chars[s.charAt(l)]++;
				if(chars[s.charAt(l)] > 0)
					count--;
				l++;
			}
			r++;
		}
		return sIndex == -1?"":s.substring(sIndex,sIndex+minLen);
    }
}
