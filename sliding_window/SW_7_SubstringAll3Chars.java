package sliding_window;

import java.util.Arrays;

public class SW_7_SubstringAll3Chars {

	public static void main(String[] args) {
		String s = "aaacbbc";
		int numberOfSubstrings = numberOfSubstrings(s);
		System.out.println(numberOfSubstrings);
	}
	
//	public static int numberOfSubstrings(String s) {
//        int len=0;
//        int r=0;
//        int[] arr=new int[3];
//        Arrays.fill(arr,-1);
//        while(r<s.length()){
//            arr[s.charAt(r)-'a']=r;
//            if(arr[0]!=-1 && arr[1]!=-1 && arr[2]!=-1){
//                len = len + 1 + Math.min(arr[0], Math.min(arr[1], arr[2]));
//
//            }
//            r++;   
//        }
//        return len;
//    
//    }
	
	public static int numberOfSubstrings(String s) {
	  char[] ch=s.toCharArray();
      int[] arr=new int[3];
      int l=0, count=0, ans=0;
      for(int r=0;r<ch.length;r++)
      {
    	  // important logic -> increment count before adding adding into array
    	  if(arr[ch[r]-'a']==0)
          {
              count++;
          }
          arr[ch[r]-'a']++;
         
          while(count==3)
          {
              ans=ans+ch.length-r;
              arr[ch[l]-'a']--;
              if(arr[ch[l]-'a']==0)
              {
                  count--;
              }
              l++;
          }
      }
      return ans;
	}
	
	
	// preferred
	public static int numberOfSubstrings1(String s) {
	    int[] count = new int[3];
	    int left = 0, unique = 0, result = 0;

	    for (int right = 0; right < s.length(); right++) {
	        int idx = s.charAt(right) - 'a';
	        if(count[idx] == 0) 
	        	unique++;
	        count[idx]++;

	        while (unique == 3) {
	            result += s.length() - right;
	            int leftIdx = s.charAt(left) - 'a';
	            count[leftIdx]--;
	            if(count[leftIdx] == 0) 
	            	unique--;
	            left++;
	        }
	    }

	    return result;
	}
}
