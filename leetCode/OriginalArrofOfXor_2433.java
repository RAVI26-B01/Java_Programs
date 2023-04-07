package leetCode;

import java.util.Arrays;

public class OriginalArrofOfXor_2433 {

	public static void main(String[] args) {

		int[] ar= {5,2,0,3,1};
		int[] findArray = findArray(ar);
		System.out.println(Arrays.toString(findArray));
	}
	
public static int[] findArray(int[] pref) {
        int[] newArr = new int[pref.length];
        newArr[0]=pref[0];
        for(int i=0; i<pref.length-1 ;i++) {
        	newArr[i+1]= pref[i]^pref[i+1];
        }
	return newArr;
    }

}
