package practice;

import java.util.Arrays;

public class FindTwoUnique {

    // Function to find two non-repeating numbers in an array
    public static int[] get2NonRepeatingNos(int[] nums) {
        // Pass 1:
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        // Get its last set bit
        diff &= -diff;

        // Pass 2:
        int[] rets = new int[2]; // this array stores the two numbers we will return
        Arrays.fill(rets, 0);
        for (int num : nums) {
            if ((num & diff) == 0) { // the bit is not set
                rets[0] ^= num;
            } else { // the bit is set
                rets[1] ^= num;
            }
        }

        return rets;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {8, 4, 8, 4, 7,9};
        int[] result = get2NonRepeatingNos(arr);
        System.out.println("The non-repeating elements are " + result[0] + " and " + result[1]);
    }
}
