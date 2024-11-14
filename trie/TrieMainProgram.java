package trie;

import java.util.Scanner;


public class TrieMainProgram {
	static Node root ;
	
	TrieMainProgram() {
        //Write your code here
        root = new Node();
    }

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		TrieMainProgram mainProgram = new TrieMainProgram();
		while(true) {
			System.out.println("press 1 to Insert");
			System.out.println("press 2 to Search");
			System.out.println("press 3 to StartsWith");
			System.out.println("enter your choice");
			
			int choice=scan.nextInt();
				switch(choice) {
					case 1:insert();break;
					case 2:startsWith(root);break;
					case 3:search(root);break;
				}
		}
		
		
	}
			
	public static void insert() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter String to insert :");
		String word=scan.next();
		
		Node temp = root;
		for(int i = 0 ; i<word.length() ; i++) {
			if(!temp.containsKey(word.charAt(i))) {
				temp.put(word.charAt(i), new Node());
			}
			temp = temp.get(word.charAt(i));
		}
		temp.setEnd();
	}

	public static boolean startsWith(Node root) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter String to check Startwith :");
		String word=scan.next();
		Node temp = root;
		for(int i = 0 ; i<word.length() ; i++) {
			if(!temp.containsKey(word.charAt(i))) {
				return false;
			}
			temp = temp.get(word.charAt(i));
		}
		return true;
	}

	public static boolean search(Node root) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter String to Search:");
		String word=scan.next();
		Node temp = root;
		for(int i = 0 ; i<word.length() ; i++) {
			if(!temp.containsKey(word.charAt(i))) {
				return false;
			}
			temp = temp.get(word.charAt(i));
		}
		return temp.isEnd();
	}
}

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

