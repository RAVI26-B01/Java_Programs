package Stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

import java.util.*;

public class MonotonicStacks {

    // Next Smaller Element
    static int[] NSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>(); // stores indices

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : arr[st.peek()];
            st.push(i);
        }

        return ans;
    }

    // Next Greater Element
    static int[] NGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : arr[st.peek()];
            st.push(i);
        }

        return ans;
    }

    // Previous Smaller Element
    static int[] PSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : arr[st.peek()];
            st.push(i);
        }

        return ans;
    }

    // Previous Greater Element
    static int[] PGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : arr[st.peek()];
            st.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 8, 1, 5};

        System.out.println("NSE: " + Arrays.toString(NSE(arr)));
        System.out.println("NGE: " + Arrays.toString(NGE(arr)));
        System.out.println("PSE: " + Arrays.toString(PSE(arr)));
        System.out.println("PGE: " + Arrays.toString(PGE(arr)));
    }
}