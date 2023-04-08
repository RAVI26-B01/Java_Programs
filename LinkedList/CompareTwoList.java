package LinkedList;


public class CompareTwoList {

	static class Node{
		int data;
		Node next;   
		Node(int data){
			this.data=data;
		}
	}
	static Node l1,l2,result;
	
	
	public static void main(String[] args) {

	/*
	 *  one list should contains same elements as other list
	 */
		int arr1[] = { 1,2,3,4,5};
		int arr2[] = { 1,2,3 };


		int i;
		for(i = arr1.length - 1; i >= 0; --i)
			push(arr1[i]);

		for(i = arr2.length - 1; i >= 0; --i)
			push1(arr2[i]);

		boolean compare = compare(l1,l2);
		if(compare)
			System.out.println("Contains");
		else
			System.out.println("Not-Contains");

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
		if(temp1==null && temp2==null){
			return true;
		}
		return false;
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
