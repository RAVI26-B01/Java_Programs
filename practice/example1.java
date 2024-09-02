package practice;

import java.util.Arrays;

class ll{
	ll next;
	int data;
	public ll(ll next, int data) {
		this.next = next;
		this.data = data;
	}
}
public class example1 {
	static ll head = null;
    public static void main(String[] args) {
    	StringBuffer sb = new StringBuffer();
    	sb.append("aasdasdads");
    	sb.ensureCapacity(1005);
    	System.out.println(sb.capacity());
//    	int[] ar = {10, 20,10,40,40};
//    	for(int i = 0 ; i<ar.length ; i++) {]
//    		head = new ll(head,ar[i]);
//    	}
//    	
//    	display();
//    	removeDuplicates();
//    	display();
//    	moveLastToFirst();
//    	display();
    }
    
	private static void moveLastToFirst() {
		
		ll temp =head;
		while(temp.next.next!=null)
			temp = temp.next;
		
		ll last = temp.next;
		temp.next=null;
		
		last.next = head;
		head=last;
		
	}

	private static void removeDuplicates() {

		if(head == null)
			System.out.println("can't remove duplicates");
		else if( head.next==null)
			System.out.println("can't remove duplicates");
		else {
			ll p1 = head;
			ll p2 =null;
			
			while(p1.next!=null) {
				p2 = p1;
				
				while(p2.next!=null) {
					if(p1.data == p2.next.data) {
						p2.next = p2.next.next;
					}else {
						p2 = p2.next;
					}
				}
				p1 = p1.next;
			}
		}
		
	}
	private static void display() {
		ll temp = head;
		System.out.print("head");
		while(temp !=null) {
			System.out.print("->"+temp.data);
			temp=temp.next;
		}
		
		System.out.println();
	}

}