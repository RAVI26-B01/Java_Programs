package leetcode;


public class MergeSortedList_21 {
	static class Node{
	int data;
	Node next;   
	Node(int data){
		this.data=data;
	}
}
static Node l1,l2,result;

public static void main(String[] args) {

	int arr1[] = { 1,5,6 };
	int arr2[] = { 1,3,4,7 };


	int i;
	for(i = arr1.length - 1; i >= 0; --i)
		push(arr1[i]);

	for(i = arr2.length - 1; i >= 0; --i)
		push1(arr2[i]);

	mergeTwoLists(l1,l2);


}

	private static Node mergeTwoLists(Node list1, Node list2) {
		Node preHead = new Node(0);
		Node last = preHead;
    
	    while(l1 != null && l2 != null) {
	        if(l1.data > l2.data) {
	            last.next = l2;
	            l2 = l2.next;
	        } else {
	            last.next = l1;
	            l1 = l1.next;
	        }
	        last = last.next;
	    }
	    
	    if(l1 == null) {
	        last.next = l2;
	    } else {
	        last.next = l1;
	    }

		/*
		 * Printing the elements
		 */
	    Node temp = preHead.next;
		while (temp != null)
		{
		System.out.print(temp.data+" ");
		temp = temp.next;
		}
		System.out.println();
		
	    return preHead.next;
    }


	private static void pushRes(int data) {
		Node new_node = new Node(0);
		Node temp;
		new_node.data=data;
		if(result == null) {
			result=new_node;
		}else {
			temp=result;
			while(temp.next !=null) {
				temp=temp.next;
			}
			temp.next=new_node;
		}
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
