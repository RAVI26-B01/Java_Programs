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
			System.out.println("press 6 to search an element");
			
			System.out.println("enter your choice");
			int choice=scan.nextInt();
				switch(choice) {
					case 1:cl.insert_front();break;
					case 2:cl.insert_rear();break;
					case 3:cl.delete_front();break;
//					case 4:ll.delete_rear();break;
					case 5:cl.display();break;
//					case 6:ll.search();break;
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
	public void delete_front() {
		Node temp,x;
		if(head==null){
			System.err.println("Deletion not possible");
		}
		else if(head.next==head){
			System.err.println("Element deleted is :"+ head.data);
			head.next=null;
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