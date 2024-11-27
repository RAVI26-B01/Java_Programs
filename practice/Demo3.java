package practice;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class a{
	private void m1() {
		System.out.println("a method");
	}
}

class b extends a{
	 void m1() {
		System.out.println("b method");
	}
}
public class Demo3 {
	public static void main(String[] args) {
//		int[] ar = {3, 4, 5, 3, 4, 6};
//		quickSort(ar);
//		System.out.println(ar);
		
//		a b = new b();
//		b.m1();
	}

	private static void quickSort(int[] ar) {
		int low = 0 ;
		int high = ar.length-1;
		quick_sort(ar,low, high);
		
	}

	private static void quick_sort(int[] ar, int low, int high) {

		if(low>high)
			return;
		else {
			int pivot = getPivot(ar, low, high);
			quick_sort(ar, low, pivot-1);
			quick_sort(ar, pivot, high);
		}
	}

	private static int getPivot(int[] ar, int low, int high) {
		int pivot = ar[low];
		int i = low;
		int j = high;
		
		while(i <= j) {
			while(ar[i]<pivot)
			{
				i++;
			}
			while(ar[j]>pivot) {
				j--;
			}
			int temp = ar[i];
			ar[i]=ar[j];
			ar[j] = temp;
		}
		
		int temp = ar[low];
		ar[low]=ar[j];
		ar[j]=temp;
		
		return j;
	}

	private static void find2Unique(int[] ar) {
		int diff =0;
		int[] ans = new int[2];
		for(int i = 0 ; i<ar.length ; i++) {
			diff^=ar[i];
		}
		 String l= Integer.toBinaryString(-diff);
		diff &= -diff;
		
		for(int i = 0 ; i<ar.length ; i++) {
			if((ar[i] & diff)==0) {
				ans[0]^=ar[i];
			}else {
				ans[1]^=ar[i];
			}
				
		}
		System.out.println(Arrays.toString(ans));
		
	}

	private static void moveZeroToLeft(int[] nums) {
		int j = nums.length-1 ;
		for(int i = nums.length-1 ; i>=0 ; i--) {
			
			if(nums[i]!=0) {
				//swap;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] =temp;
				j--;
			}
		}
		
		
		System.out.println(Arrays.toString(nums));
		
	}

	private static void moveZeroToRight(int[] nums) {

		int j =0;
		for(int i = 0 ; i<nums.length ; i++) {
			if(nums[i] !=0) {
				//swap;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] =temp;
				j++;
			}
		}
		
		System.out.println(Arrays.toString(nums));
	}

	private static void findReduce(String s, int k) {
		int ans = 0;
		int sum =0;
		
		for(int i = 0 ; i<s.length() ; i++) {
			int num = s.charAt(i)-'a'+1;
			while(num > 0) {
				int rem = num%10;
				sum+=rem;
				num/=10;
			}
		}
		System.out.println(sum);
		int temp =0;
		while(--k >0 && sum>9) {
			temp=0;
			
			while(sum>0) {
				int rem = sum%10;
				temp+=rem;
				sum/=10;
			}
			sum=temp;
		}
		System.out.println(sum);
	}

	private static void sum(String s1, String s2) {
		int i = s1.length()-1;
		int j = s2.length()-1;
		int sum = 0;
		int carry =0;
		int x = 0;
		int y = 0;
		StringBuffer ans = new StringBuffer();
		while(carry > 0 || i>0 || j>0 ) {
			x = i!=-1?s1.charAt(i)-'0':0;
			y = j!=-1?s2.charAt(j)-'0':0;
			sum = x+y+carry;
			carry = sum/10;
			ans.append(sum%10);
			
			i--;j--;
		}
		
		System.out.println(ans.reverse());
	}

	private static void printPermutation(String p, String s) {

		if(s.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		 char ch = s.charAt(0);
		for(int i =0 ; i <=p.length() ; i++) {
			String f = p.substring(0,i);
			String l = p.substring(i,p.length());
			printPermutation(f+ch+l, s.substring(1));
		}
		
		
		
	}


}
