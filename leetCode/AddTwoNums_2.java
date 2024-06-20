package leetcode;

import java.util.Stack;

public class AddTwoNums_2 {
	static class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
		}
		public Node(int data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}

	static Node l1, l2, result;

	//To push a new node to linked list
	public static void push(int new_data)
	{
		
		// Allocate node
		Node new_node = new Node(0);

		// Put in the data
		new_node.data = new_data;

		// Link the old list of the new node
		new_node.next = l1;

		// Move the head to point to the new node
		l1 = new_node;
	}

	public static void push1(int new_data)
	{
		
		// Allocate node
		Node new_node = new Node(0);

		// Put in the data
		new_node.data = new_data;

		// Link the old list of the new node
		new_node.next = l2;

		// Move the head to point to
		// the new node
		l2 = new_node;
	}

	//To add two new numbers
	public static Node addTwoNumbers()
	{
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while (l1 != null)
		{
			stack1.add(l1.data);
			l1 = l1.next;
		}

		while (l2 != null)
		{
			stack2.add(l2.data);
			l2 = l2.next;
		}

		int carry = 0;
		Node result = null;

		while (!stack1.isEmpty() ||
			!stack2.isEmpty())
		{
			int a = 0, b = 0;

			if (!stack1.isEmpty())
			{
				a = stack1.pop();
			}

			if (!stack2.isEmpty())
			{
				b = stack2.pop();
			}

			int total = a + b + carry;

			Node temp = new Node(total % 10);
			carry = total / 10;

			if (result == null)
			{
				result = temp;
			}
			else
			{
				temp.next = result;
				result = temp;
			}
		}

		if (carry != 0)
		{
			Node temp = new Node(carry);
			temp.next = result;
			result = temp;
		}
		return result;
	}

	//To print a linked list
	public static void printList()
	{
		while (result != null)
		{
			System.out.print(result.data + " ");
			result = result.next;
		}
		System.out.println();
	}

	//Driver code
	public static void main(String[] args)
	{
		int arr1[] = { 9,9,9};
		int arr2[] = {1 };


		// Create first list as 5->6->7
		int i;
		for(i = arr1.length - 1; i >= 0; --i)
			push(arr1[i]);

		// Create second list as 1->8
		for(i = arr2.length - 1; i >= 0; --i)
			push1(arr2[i]);

//		result = addTwoNumbers();
		
		result = addNums();

		printList();
	}

		private static Node addNums() {
			Node ans = null;
	        int carry = 0;
	        
	        if(l1 == null && l2 ==null)
	            return ans;
	        if(l1 == null && l2 !=null)
	        	return l2;
	        if(l2 ==null && l1 !=null )
	        	return l1;
	        
	        while(l1 != null || l2 != null || carry>0){
	            int x =l1 != null? l1.data:0;
	            int y =  l2 != null?l2.data:0;

	            int sum = x+y+carry;
	            int rem = sum % 10;
	            carry = sum /10;
	            Node ansNode = new Node(rem, null);
	            if(ans == null) {
	            	ans = ansNode;
	            }
	            else {
	            	Node temp = ans;
	            	while(temp.next!=null) {
	            		temp=temp.next;
	            	}
	            	
	            	temp.next =ansNode;
	            }
	            if(l1!=null)
	        	l1=l1.next;
	            if(l2!=null)
	        	l2=l2.next;
	        }

	        return ans;
	    }
}
