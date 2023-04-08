package DoublyLinkedList;

import java.util.Scanner;

public class DoublyLinkedListMainProgram {

	public static void main(String[] args) {
		DoublyLinkedList ll=new DoublyLinkedList();

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
						case 1:ll.insert_front();break;
						case 2:ll.insert_rear();break;
						case 3:ll.delete_front();break;
						case 4:ll.delete_rear();break;
						case 5:ll.show();break;
						case 6:ll.search();break;
						default :System.out.println("program terminated :-((");System.exit(0);
					}
				}
			
		}

	}

class Node{
	Node lnext;
	int data;
	Node rnext;
	
}
class DoublyLinkedList{
	Node head;
	public void insert_front() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter item to insert :");
		int item=scan.nextInt();
		Node node=new Node();
		node.lnext=null;
		node.data=item;
		node.rnext=null;
		
		if(head==null) {
			head=node;
		}
		else {
			node.rnext=head;
			head.lnext=node;
			head=node;
		}
		
	}
	
	public void search() {
		Node temp;
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter element to be Searched :");
		int item=scan.nextInt();
		if(head==null) {
			System.out.println("Seach not possible");
		}
		else if(head.rnext==null)
		{
			if(item == head.data){
				System.out.println("Element found");
			}
		}else{
			temp=head;
			while(temp.rnext!=null){
				if(temp.data == item){
					System.out.println("Element found :-)");
					System.exit(0);
				}
				temp=temp.rnext;
			}
			System.out.println("Element not found");
		}
		
	}

	public void delete_front() {
		Node temp;
		if(head==null) {
			System.out.println("Deletion not possible");
		}
		else if(head.rnext==null)
		{
			System.out.printf("Element deleted is :%d\n",head.data);
			System.out.println();
			head=null;
		}
		else {
			temp=head;
			head=head.rnext;
			System.out.printf("Element deleted is :%d\n",temp.data);
			System.out.println();
			temp=null;
		}		
	}

	public void delete_rear() {
		Node temp;
		if(head==null) {
			System.out.println("Deletion not possible");
		}
		else if(head.rnext==null)
		{
			System.out.printf("Element deleted is :%d\n",head.data);
			System.out.println();
			head=null;
		}
		else {
			temp=head;
			while(temp.rnext.rnext!=null) {
				temp=temp.rnext;
			}
			System.out.printf("Element deleted is :%d\n",temp.rnext.data);
			temp.rnext=null;
		}
		
	}
	public void insert_rear() {
		Node temp;
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter item to insert :");
		int item=scan.nextInt();
		Node node=new Node();
		node.lnext=null;
		node.data=item;
		node.rnext=null;
		
		if(head==null) {
			head=node;
		}
		else {
			temp=head;
			while(temp.rnext!=null) {
				temp=temp.rnext;
			}
			temp.rnext=node;
			node.lnext=temp;
		}
		
	}
	public void show() {
		Node temp;
		if(head==null) {
			System.out.println("display not possilbe");
		}
		else {
			temp=head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.rnext;
			}
			System.out.println();
		}
	}
	
}






