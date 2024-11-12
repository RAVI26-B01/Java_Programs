package leetcode;


public class RemoveElements_203 {
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

        int[] keys = { 1, 2, 6, 3, 4, 5, 6 };
        int val = 6;
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        printList(head);
        removeElements(head,val);
        printList(head);
	}
	
	private static void removeElements(Node head, int val) {
		Node fakeHead = new Node(-1);
	    fakeHead.next = head;
	    Node curr = head, prev = fakeHead;
	    while (curr != null) {
	        if (curr.data == val) {
	            prev.next = curr.next;
	        } else {
	            prev = prev.next;
	        }
	        curr = curr.next;
	    }
	    
	    // (or)
	    
//	    Node temp = head;
//        while(temp!=null && temp.next != null){
//            if(temp.next.data!=val)
//                temp = temp.next;
//            else
//             temp.next = temp.next.next;
//        }
//        if(head!=null && head.data == val)
//            head=head.next;
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
