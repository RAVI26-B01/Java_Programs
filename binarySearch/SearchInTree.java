package binarySearch;

import java.util.Scanner;

import binaryTree.Node;

public class SearchInTree {

	public Node search(Node root) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter element to search");
		int val = scan.nextInt();
		while(root != null && root.data != val) {
			root = val > root.data? root.right : root.left;
		}
		return root;
	}
	
	public static int findCeil(Node root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }

            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

	public static int findFloor(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            }

            if (key > root.data) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
	}
}
