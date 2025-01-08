package leetcode;

public class SqrtOfNumber_69 {

	public static void main(String[] args) {

		int n=37;
		int findSqrt = findSqrt(n);
		System.out.println(findSqrt);
		
		int findSqrt1 = findSqrt1(n);
		System.out.println(findSqrt1);
		
	}

	// naive approach
	private static int findSqrt1(int n) {
		int ans = 0;
		for(int i = 0 ; i <= n ; i++) {
			if(i*i<=n)
				ans = i;
			else
				break;
		}
		return ans;
	}

	//better approach
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
