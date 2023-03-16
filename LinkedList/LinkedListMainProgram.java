package LinkedList;
import java.util.Scanner;

public class LinkedListMainProgram {

	public static void main(String[] args){
		LinkedList ll=new LinkedList();
	//	ll.insert();
		//ll.show();
		
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("press 1 to insertFront");
			System.out.println("press 2 to insertRear");
			System.out.println("press 3 to deleteFront");
			System.out.println("press 4 to deleteRear");
			System.out.println("press 5 to display");
			System.out.println("enter your choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:ll.insert_front();break;
			case 2:ll.insert_rear();break;
			case 3:ll.delete_front();break;
			case 4:ll.delete_rear();break;
			case 5:ll.show();break;
			default :System.out.println("program terminated :-((");System.exit(0);
			}
		}
		
	}
}

class Node{
	int data;
	Node next;
}

class LinkedList{
	Node head;
	
	public void insert_front() {
		Node node=new Node();
		System.out.print("enter item to insert : ");
		Scanner scan=new Scanner(System.in);
		int data=scan.nextInt();
		node.data=data;
		node.next=null;
		if(head==null) {
			head=node;
		}else {
			node.next=head;
			head=node;
		}
	}
	
	
	public void insert_rear() {
		Node node=new Node();
		System.out.print("enter item to insert : ");
		Scanner scan=new Scanner(System.in);
		int data=scan.nextInt();
		node.data=data;
		node.next=null;
		Node temp;
		if(head==null)
		{
			head=node;
		}
		else {
			temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=node;
		}
	}
	
	
	public void delete_front() {
		Node temp;
		if(head==null) {
			System.out.println("deletion not possilbe");
		}
		else if(head.next==null) {
			System.out.printf("Element deleted is :%d\n",head.data);
			head=null;
		}
		else {
			System.out.printf("Element deleted is :%d\n",head.data);
			temp=head;
			head=head.next;
		}
	}
	
	public void delete_rear() {
		Node temp;
		if(head==null) {
			System.out.println("deletion not possible");
		}
		else if(head.next==null) {
			System.out.printf("Element deleted is :%d\n",head.data);
			head=null;
		}
		else {
			temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			System.out.printf("Element deleted is :%d\n",temp.next.data);
			temp.next=null;
			temp=null;
		}
		
	}
	public void show() {
		if(head==null) {
			System.out.println("display not possible");
		}
		else {
			Node node=head;
			while(node!=null) {
				System.out.print(node.data+" ");
				node=node.next;
			}
			System.out.println();
		}
	}
}








