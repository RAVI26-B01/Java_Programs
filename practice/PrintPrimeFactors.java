package practice;

import java.util.Scanner;

public class PrintPrimeFactors {

	/*
	 * 
	 Note: 
	 Time complexity : O(sqrt(N) + log N) 
	  -> sqrt(N) for loop
	  -> log N for dividing number
	 
	 Space complexity: if we are storing ans in a list its depends on answer length 
	 
	 */
    // Method to print the prime factors of a number
    public static void printPrimeFactors(int number) {
        if (number <= 1) {
            System.out.println("Number should be greater than 1.");
            return;
        }

        // Print number of 2s that divide the number
        while (number % 2 == 0) {
            System.out.print(2 + " ");
            number /= 2;
        }

        // Print odd factors from 3 onwards
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                System.out.print(i + " ");
                number /= i;
            }
        }

        // If number is a prime number greater than 2
        if (number > 2) {
            System.out.print(number);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Print the prime factors of the entered number
        printPrimeFactors(number);
    }



}
