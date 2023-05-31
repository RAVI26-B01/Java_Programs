package LinkedList;


//Delete every `N` nodes in a linked list after skipping `M` nodes

public class Delete_N_Skipping_M {
	
	static class Node
	{
	    int data;
	    Node next;
	 
	    Node(int data, Node next)
	    {
	        this.data = data;
	        this.next = next;
	    }
	}

	public static void main(String[] args) {

		// input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        printList(head);
        deleteNodes(head, 2, 3);
        printList(head);
	}
	
	private static Node deleteNodes(Node head, int m, int n) {
		if(head==null || head.next==null)
			return head;
		Node prev=null;
		Node curr=head;
		
		//skip m nodes
		for(int i=0 ; curr != null &&  i<m;i++) {
			prev = curr;
			curr=curr.next;
		}
		
		//delete n nodes
		for(int i=0 ;curr != null &&  i<n ;i++) {
			curr = curr.next;
		}
		
		 // link remaining nodes with the last node
        prev.next = curr;
 
        // recur for remaining nodes
        deleteNodes(curr, m, n);
		return head;
	}

	public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }

}
