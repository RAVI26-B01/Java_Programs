package leetcode;

public class RemoveDuplicates_83 {

	static class Node
	{
	    int data;
	    Node next;
	 
	    Node(int data)
	    {
	        this.data = data;
	    }
	    Node(int data, Node next)
	    {
	        this.data = data;
	        this.next = next;
	    }
	}
	
	public static void main(String[] args) {

        int[] keys = { 1, 1, 2, 3, 3,4};
        int val = 6;
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        printList(head);
        deleteDuplicates(head);
        printList(head);
	}
	
	private static void deleteDuplicates(Node head) {
		if(head == null)
			return;
		else {
			Node temp = head;
			while(temp!=null) {
				if(temp.next != null && temp.data==temp.next.data) {
					temp.next=temp.next.next;
				}else
					temp=temp.next;
			}
			
		}
		
	}

	public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " �> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
}
