package leetcode;

public class SqrtOfNumber_69 {

	public static void main(String[] args) {

		int n=8;
		int findSqrt = findSqrt(n);
		System.out.println(findSqrt);
	}

	private static int findSqrt(int n) {
		int end=n;
		int start=0;
		int mid=0;
		int ans=0;
		if(n==1 || n==0)
			return n;
		while(start<=end){
			mid=start+(end-start)/2;
			if( mid * mid <= n){
				start=mid+1;
				ans = mid;
			}else{
				end=mid-1;
			}
		}
		return ans;
		
	}

}
