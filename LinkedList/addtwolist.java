package LinkedList;

import java.util.Stack;

import LinkedList.AddTwoLinkedList.Node;
/*
 * add two list
 */
public class addtwolist {
	
	static class Node{
		int data;
		Node next;   
		Node(int data){
			this.data=data;
		}
	}
	static Node l1,l2,result;
	
	public static void main(String[] args) {

		int arr1[] = { 5, 6, 7 };
		int arr2[] = { 1, 8 };


		// Create first list as 5->6->7
		int i;
		for(i = arr1.length - 1; i >= 0; --i)
			push(arr1[i]);

		// Create second list as 1->8
		for(i = arr2.length - 1; i >= 0; --i)
			push1(arr2[i]);

		result = addTwoNumbers();

		printList();

	}

	private static void printList() {
		while(result!=null){
			System.out.print(result.data+" ");
			result=result.next;
		}
		System.out.println();
	}

	private static Node addTwoNumbers() {
		
		int sum=0;
		int carry=0;
		Stack<Integer> s1=new Stack<>();
		Stack<Integer> s2=new Stack<>();
		while(l1!=null){
			s1.push(l1.data);
			l1=l1.next;
		}
		while(l2!=null){
			s2.push(l2.data);
			l2=l2.next;
		}
		
		while(!s1.empty() || !s2.empty()){
			int a=0; 
			int b=0;
			if(!s1.isEmpty()){
				a=s1.pop();
			}
			
			if((!s2.isEmpty())){
				b=s2.pop();
			}
			
			sum=a+b+carry;
			carry=sum/10;
			int rem=sum%10;
			
			Node temp=new Node(rem);
			if(result == null)
			{
				result = temp;
			}
			else
			{
				temp.next = result;
				result = temp;
			}
		}
		if(carry!=0){
			Node t=new Node(carry);
			t.next=result;
			result=t;
		}
		return result;
	}

	private static void push1(int new_data) {
		
		Node new_node = new Node(0);

		new_node.data = new_data;

		new_node.next = l2;

		l2 = new_node;
	}

	private static void push(int new_data) {
		
		Node new_node = new Node(0);

		new_node.data = new_data;

		new_node.next = l1;

		l1 = new_node;
	}
	
}
