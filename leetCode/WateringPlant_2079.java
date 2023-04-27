package leetCode;

public class WateringPlant_2079 {

	public static void main(String[] args) {

		int[] arr= {1,1,1,4,2,3};
		int capacity =4;
		int wateringPlant = wateringPlant(arr,capacity);
		System.out.println(wateringPlant);
	}

	private static int wateringPlant(int[] arr, int capacity) {
		int count=0;
		int currCapacity = capacity;
		for(int i=0 ; i<arr.length ;i++) {
			if(currCapacity >= arr[i]) {
				currCapacity=currCapacity-arr[i];
				count++;
			}else {
				 currCapacity = capacity;
				 count=count+2*i;
				 i--;
			}
		}
		return count;
	}

}
