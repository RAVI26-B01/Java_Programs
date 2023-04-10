package circularLinkedList;

import java.util.Scanner;


/*
 * circular linked list
 */
public class CircularLinkedListMainProgram {

	public static void main(String[] args) {
		CircularLinkedList cl = new CircularLinkedList();
		
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("press 1 to insertFront");
			System.out.println("press 2 to insertRear");
			System.out.println("press 3 to deleteFront");
			System.out.println("press 4 to deleteRear");
			System.out.println("press 5 to display");
			System.out.println("press 6 to check Circularity");
			System.out.println("press 7 to reverse");
			
			System.out.println("enter your choice");
			int choice=scan.nextInt();
				switch(choice) {
					case 1:cl.insert_front();break;
					case 2:cl.insert_rear();break;
					case 3:cl.delete_front();break;
					case 4:cl.delete_rear();break;
					case 5:cl.display();break;
					case 6:cl.check_circular();break;
					case 7:cl.reverse();break;
					default :System.out.println("program terminated :-((");System.exit(0);
				}
			}
		
	}

}

class Node{
	int data;
	Node next;
	
}
class CircularLinkedList{
	Node head;
	public void insert_front() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter item to insert :");
		int item=scan.nextInt();
		Node node=new Node();
		node.data=item;
		node.next=node;
		Node temp;
		if(head==null) {
			head=node;
		}
		else {
			temp=head;
			while(temp.next!=head){
				temp=temp.next;
			}
			node.next=head;
			temp.next=node;
			head=node;
		}
		
	}
	public void reverse() {
		Node x,y,z;
		if(head==null || head.next==head){
			System.err.println("Reverse not possible");
		}
		else{
			x=head;
			y=head.next;
			z=head.next.next;
			while(y!=head){
				y.next=x;
				x=y;
				y=z;
				z=z.next;
			}
			head.next=x;
			head=x;
		}
	}
	public void check_circular() {
		Node slow,fast;
		if(head==null){
			System.err.println("No element found");
		}
		else if(head.next==head){
			System.out.println("Circular");
		}else{
			 slow=head;
			 fast=head;
			 while(slow!=null && head!=null){
				 slow=slow.next;
				 fast=fast.next.next;
				 if(fast == slow){
					 System.out.println("circular");
					 System.exit(0);
				 }
			 }
			 System.out.println("Not-circular");
			 
			 
		}
	}
	public void delete_rear() {
		Node temp;
		if(head==null){
			System.err.println("Deletion not possible");
		}
		else if(head.next==head){
			System.err.println("Element deleted is :"+ head.data);
			head=null;
		}
		else{
			temp=head;
			while(temp.next.next!=head){
				temp=temp.next;
			}
			System.err.println("Element deleted is :"+ temp.next.data);
			temp.next=head;
		}
	}
	public void delete_front() {
		Node temp,x;
		if(head==null){
			System.err.println("Deletion not possible");
		}
		else if(head.next==head){
			System.err.println("Element deleted is :"+ head.data);
			head=null;
		}
		else{
			temp=head;
			x=head;
			while(temp.next!=head){
				temp=temp.next;
			}
			System.err.println("Element deleted is :"+ head.data);
			head=head.next;
			temp.next=head;
			x.next=null;
		}
	}
	public void insert_rear() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter item to insert :");
		int item=scan.nextInt();
		Node node=new Node();
		node.data=item;
		node.next=node;
		Node temp;
		if(head==null) {
			head=node;
		}else{
			temp=head;
			while(temp.next!=head){
				temp=temp.next;
			}
			temp.next=node;
			node.next=head;
		}
	}
	public void display() {
		Node temp = head;
		if(head==null)
			System.out.println("display not possible");
		else if(head.next==head)
			System.out.println(head.data);
		else{
			while(temp.next!=head){
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.print(temp.data+" ");
			System.out.println();
		}
	}
}