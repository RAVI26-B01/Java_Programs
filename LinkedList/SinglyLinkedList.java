package LinkedList;

import java.util.Scanner;

public class SinglyLinkedList {
	static Node head =null;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		while(true) {
			System.out.println("Press 1 to Insert Front");
			System.out.println("Press 2 to Insert Rare");
			System.out.println("Press 3 to Delete Front");
			System.out.println("Press 4 to Delete Rare");
			System.out.println("Press 5 to Insert At Index");
			System.out.println("Press 6 to Delete At Index");
			System.out.println("Press 7 to Delete Duplicates");
			System.out.println("Press 8 to Display");
			System.out.println("Press 9 to Reverse");
			System.out.println("Press 10 to find middle element in single pass");
			System.out.println("Press 11 Move last element to first");
			System.out.println("Press 12 to check Palindrome or not");
			System.out.println("Press 13 to Sort");
			System.out.println("Press 14 to check Circularity");
			
			int key=scan.nextInt();  
			switch (key) {
			case 1:Insert_front();break;
			case 2:Insert_rare();break;
			case 3:Delete_front();break;
			case 4:Delete_rear();break;
			case 5:Insert_at_index();break;
			case 6:Delete_at_index();break;
			case 7:Delete_Duplicates();break;
			case 8:display();break;
			case 9:Reverse_a_List();break;
			case 10:FindMiddleNodeInSinglePass();break;
			case 11:MoveLastElementToFirst();break;
			case 12:CheckPalindrome();break;
			case 13:Sort();break;
			case 14:check_circular();break;
			
			default:System.exit(0);
				break;
			} 
		}
	}

	private static void MoveLastElementToFirst() {
		Node temp = null;
		Node lastEle =null;
		if(head !=null && head.next !=null){
			temp=head;
			while(temp.next.next!=null){
				temp=temp.next;
			}
			lastEle=temp.next;
			temp.next=null;
			
			lastEle.next=head;
			head=lastEle;
			
		}
		display();
	}


	private static void Delete_Duplicates() {
		if(head==null) {
			System.err.println("Reverse Not Possible");
		}
		else if(head.next==null) {
			System.err.println("Only one elemnt is present can't campare and delete");
		}
		else{
			Node ptr1=head;
			Node ptr2=null;
			
			while(ptr1!=null && ptr1.next!=null){
				ptr2=ptr1;
				
				while(ptr2.next!=null){
					if(ptr1.data == ptr2.next.data){
						ptr2.next=ptr2.next.next;
					}else{
						ptr2=ptr2.next;
					}
				}
				ptr1=ptr1.next;
			}
			
			System.out.println("Duplicates removed");
		}
		
	}


	private static void Reverse_a_List() {
		if(head==null) {
			System.err.println("Reverse Not Possible");
		}
		else if(head.next==null) {
			System.err.println("Only one elemnt is present No need to reverse");
		}
		else{
			Node x=head;
			Node y=head.next;
			Node z=head.next.next;
			while(y!=null){
				y.next=x;
				x=y;
				y=z;
				if(z!=null)
					z=z.next;
			}
			head.next=null;
			head=x;
		}
	}


	private static void FindMiddleNodeInSinglePass() {
		Node current =null;
		Node middle=null;
		int length=0;
		if(head==null) {
			System.err.println("No elements found");

		}
		else if(head.next==null) {
			System.out.printf("Middle Element is: %d\n",head.data);
		}else {
			current=head;
			middle=head;
			while(current.next!=null){
				length++;
				if(length%2==0){
					middle=middle.next;
				}
				current=current.next;
			}
			System.out.printf("Middle Element is: %d\n",middle.data);
		}
	}


	private static void Delete_at_index() {
		Node temp = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Index:  ");
		int index=scan.nextInt();
		if(head==null) {
			System.err.println("deletion not possilbe");

		}
		else if(head.next==null) {
			System.err.printf("Element deleted is: %d\n",head.data);
			head=null;
		}else {
			temp=head;
			while(temp.next.next!=null && --index>0) {
				temp=temp.next;
			}
			temp.next=temp.next.next;
		}
	}


	private static void Insert_at_index() {
		Node temp = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Index:  ");
		int index=scan.nextInt();
		System.out.print("Enter data to be inserted ");
		int n=scan.nextInt();
		Node node = new Node();
		node.data=n;
		node.next=null;
		if(head==null) {
			head=node;
		}
		 if (index < 0)
	           System.err.print("Invalid index");
		else if(index==0) {
			node.next=head;
			head=node;
		}
		else {
			temp=head;
			while(temp.next!=null && --index>0) {
				temp=temp.next;
			}
			node.next=temp.next;
			temp.next=node;
		}
		
	}


	private static void Delete_rear() {
		Node temp = null;
		if(head==null) {
			System.err.println("deletion not possilbe");

		}
		else if(head.next==null) {
			System.err.printf("Element deleted is: %d\n",head.data);
			head=null;
		}
		else {
			temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			System.err.printf("Element deleted is: %d\n",temp.next.data);
			temp.next=null;
		}
	}


	private static void Delete_front() {
		Node temp = null;
		if(head==null) {
			System.err.println("deletion not possilbe");

		}
		else if(head.next==null) {
			System.err.printf("Element deleted is: %d\n",head.data);
			head=null;
		}else {   
			temp=head;
			head=head.next;
			System.err.printf("Element deleted is: %d\n",temp.data);
			temp=null;
		}
	}
 

	private static void Insert_rare() {
		Node temp = null;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter data to be inserted ");
		int n=scan.nextInt();
		Node node = new Node();
		node.data=n;
		node.next=null;
		if(head==null) {
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


	private static void display() {
		Node temp = null;
		if(head==null) {
			System.err.println("Display not possilbe");

		}
		else if(head.next==null) {
			System.out.println(head.data);
		}else {
			temp=head;
			while(temp!=null) {
				System.out.printf("%d\t",temp.data);
				temp=temp.next;
			}
			System.out.println();
		}  
	}


	private static void Insert_front() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter data to be inserted ");
		int n=scan.nextInt();
		Node node = new Node();
		node.data=n;
		node.next=null;
		
		if(head==null) {
			head=node;
		}else {
			node.next=head;
			head=node;
		}
	}
	
	private static void CheckPalindrome() {
	
		int length=0;
		Node fast=head,secondHalf;
		Node slow=head;
		while(fast.next!=null){
			length++;
			if(length%2==0)
				slow=slow.next;
			fast=fast.next;
		}
		secondHalf=slow.next;
		slow.next=null;
		
//			while(secondHalf!=null){
//				System.out.print(secondHalf.data+" ");
//				secondHalf=secondHalf.next;
//			}
//			System.out.println();
//			
//			while(head!=null){
//				System.out.print(head.data+" ");
//				head=head.next;
//			}
//			System.out.println();
			Node reverse_a_Node = reverse_a_Node(secondHalf);
			boolean compare = compare(head, reverse_a_Node);
			if(compare)
				System.out.println("Palindrome");
			else
				System.out.println("Not-Palindrome");
			Node reverse_a_Node2 = reverse_a_Node(reverse_a_Node);
			slow.next=reverse_a_Node2;

	}
	
public static boolean compare(Node list1, Node list2) {
		
		Node temp1 = list1;
		Node temp2 = list2;
		
		while(temp1!=null && temp2!=null){
			if(temp1.data == temp2.data){
				temp1=temp1.next;
				temp2=temp2.next;
			}else
				return false;
		}
		if(temp1==null || temp2==null){
			return true;
		}
		return false;
	}

private static Node reverse_a_Node(Node list) {
	Node temp=list;
	if(temp==null) {
		System.err.println("Reverse Not Possible");
	}
	else if(temp.next==null) {
		System.err.println("Only one elemnt is present No need to reverse");
	}
	else{
		Node x=temp;
		Node y=temp.next;
		Node z=temp.next.next;
		while(y!=null){
			y.next=x;
			x=y;
			y=z;
			if(z!=null)
				z=z.next;
		}
		temp.next=null;
		temp=x;
	}
	return temp;
}


private static void Sort() {
	Node temp1 = head;
	
	while(temp1.next!=null) {
		Node temp2 = head;
		while(temp2.next !=null) {
			if(temp2.data >temp2.next.data) {
				int t = temp2.data;
				temp2.data = temp2.next.data;
				temp2.next.data = t;
			}
			temp2= temp2.next;
		}
		temp1=temp1.next;
	}
}

public static void check_circular() {
	Node slow,fast;
	if(head==null){
		System.err.println("No element found");
	}
	else if(head.next==head){
		System.out.println("Circular");
	}else{
		 slow=head;
		 fast=head;
		 while(fast!=null && fast.next!=null){
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

}
