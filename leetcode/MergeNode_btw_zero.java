package leetcode;


public class MergeNode_btw_zero {

	static class Node{
		int data;
		Node next;   
		Node(int data){
			this.data=data;
		}
	}
	static Node l1,l2,result;
	
	public static void main(String[] args) {

		int arr1[] = {0,3,1,0,4,5,2,0};
		int i;
		for(i = arr1.length - 1; i >= 0; --i)
			push(arr1[i]);
		
		Node mergeNodes = mergeNodes(l1);
		
			while(mergeNodes!=null){
				System.out.print(mergeNodes.data+" ");
				mergeNodes=mergeNodes.next;
			}
			System.out.println();
	}
	
	private static void push(int new_data) {
		Node new_node = new Node(0);
		new_node.data = new_data;
		new_node.next = l1;
		l1 = new_node;
	}
	
	
	private static Node mergeNodes(Node head) {
		
		Node curr = head.next;
		Node prev=curr;
		int sum=0;
		
		while(curr!=null) {
			
			while(curr.data!=0) {
				sum+=curr.data;
				curr=curr.next;
			}
			prev.data=sum;
			sum=0;
			curr=curr.next;
			prev.next=curr;
			prev=curr;
		}
		
		
		return head.next;
		
        
    }
}
