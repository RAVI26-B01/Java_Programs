package practice;

import java.util.*;


class lNode{
	lNode next;
	int val;
	lNode(lNode next, int val){
		this.next= next;
		this.val = val;
	}
}
public class Demo1 {
	static lNode head = null;
	public static void main(String[] args)  {
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("press 1 to insertFront");
			System.out.println("press 2 to insertRear");
			System.out.println("press 3 to deleteFront");
			System.out.println("press 4 to deleteRear");
			System.out.println("press 5 to display");
			System.out.println("press 6 to sort");
			System.out.println("enter your choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:insert_front();break;
			case 2:insert_rear();break;
			case 3:delete_front();break;
			case 4:delete_rear();break;
			case 5:display();break;
			case 6 :sort();break;
			default :System.out.println("program terminated :-((");System.exit(0);
			}
		}
	}

	private static void sort() {
		lNode temp1 = head;
		
		while(temp1.next!=null) {
			lNode temp2 = head;
			while(temp2.next !=null) {
				if(temp2.val >temp2.next.val) {
					int t = temp2.val;
					temp2.val = temp2.next.val;
					temp2.next.val = t;
				}
				temp2= temp2.next;
			}
			temp1=temp1.next;
		}
	}

	private static void delete_rear() {
		lNode temp = head;
		if(head==null) {
			System.out.println("deletion not possible");
		}
		else if(head.next==null) {
			System.out.println("element deleted is :"+ head.val);
			head = null;
		}
		else {
			while(temp.next.next!=null)
				temp=temp.next;
			System.out.println("element deleted is :"+ temp.next.val);
			temp.next=null;
		}
		
	}

	private static void delete_front() {
		if(head==null) {
			System.out.println("deletion not possible");
		}
		else {
			lNode temp = head;
			head = head.next;
			System.out.println("element deleted is :"+ temp.val);
			temp.next=null;
		}
	}

	private static void insert_rear() {
		lNode temp = head;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter element : ");
		int nextInt = scan.nextInt();
		lNode l =new lNode(null, nextInt);
		if(head ==null) {
			head = l;
		}else 
		{
			while(temp.next!=null)
				temp=temp.next;
			
			temp.next = l;
		}
	}

	private static void display() {
		if(head==null) {
			System.out.println("no element");
		}else {
			lNode temp = head;
			while(temp !=null) {
				System.out.print(temp.val+ " ");
				temp=temp.next;
			}
			System.out.println();
		}
	}

	private static void insert_front() {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter element : ");
		int nextInt = scan.nextInt();
		lNode l =new lNode(null, nextInt);
		
		l.next = head;
		head = l;
		l=null;
		
		
	}
}

