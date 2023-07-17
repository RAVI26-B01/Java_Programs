package leetCode;

public class WaterContainer_11 {

	public static void main(String[] args) {

		int[] ar = {1,8,6,2,5,4,8,3,7};
		int maxArea = maxArea(ar);
		System.out.println(maxArea);
	}

	public static int maxArea(int[] height) {
		int left=0;
		int right = height.length - 1;
		
		int max = 0;
		while(left<right) {
			int w = right-left;
			
			int h = Math.min(height[right], height[left]);
			int area = h*w;
			
			
			max=Math.max(max, area);
			if(height[right]<height[left]) right--;
			else if(height[right]>height[left]) left++;
			else {
				right--;
				left++;
			}
		}
        return max;
    }
}
