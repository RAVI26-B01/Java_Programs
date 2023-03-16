package Stack;

import java.util.Scanner;
public class stackProgram {

	public static void main(String[] args) {
		Stack s=new Stack();
		Scanner scan=new Scanner(System.in);
		while(true) {
		System.out.println("press 1 to push");
		System.out.println("press 2 to pop");
		System.out.println("press 3 to display");
		System.out.println("press 4 to exit");
		System.out.println("enter user choice");
		int choice=scan.nextInt();
		switch(choice) {
		case 1:s.push();break;
		case 2:s.pop();break;
		case 3:s.display();break;
		default:System.out.println("program ended :-(((");System.exit(0);
		}
		}
	}
}

class Stack{
	int size=5;
	int my_stack[]=new int[5];
	int top=-1;
	Scanner scan=new Scanner(System.in);
	public void push() {
		if(top==size-1) {
			System.out.println("stack over flow");
		}
		else {
			System.out.print("enter item to be pushed: ");
			int item=scan.nextInt();
			top++;
			my_stack[top]=item;
		}
	}
	
	public void pop() {
		if(top==-1) {
			System.out.println("stack under flow");
		}
		else {
			System.out.printf("element poped is  :  %d\n1",my_stack[top]);
			top--;
		}
	}
	
	public void display() {
		for(int i=top;i>=0;i--) {
			System.out.println(my_stack[i]);
		}
	}
}