package LinkedList;

public class ConcateTwoListAndSort {
    static node head1 = null;
    static node head2 = null;

    static class node {
        int data;
        node next;
    };

    static void printList(node head) {
        node tmp;
        tmp = head;
        
        while (tmp.next != null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.println( tmp.data );
    }

    static node AddNode(node head, int num) {
        // Creating a new node
        node temp = new node();
        node tail = head;

        temp.data = num;
        temp.next = null;

        // If head is null then create linked list
        // with temp as tail and head of the linked list
        if (head == null) {
            head = temp;
            tail = temp;
        }

        // Else insert the temp node
        // after the tail of the existing
        // node and make the temp node
        // as the tail of the linked list
        else {
            while (tail != null) {
                if (tail.next == null) {
                    tail.next = temp;
                    tail = tail.next;
                }
                tail = tail.next;
            }
        }

        // Return the list
        return head;
    }

    // This function will concatenate
    // the two linked list
    // 1 -> 6 -> 10 -> 5 -> 3 -> 9
    static node concatenateList() {
        node tail = head1;

        while (tail != null) {
            if (tail.next == null && head2 != null) {
                tail.next = head2;
                break;
            }
            tail = tail.next;
        }

        return head1;
    }

    // This function will sort the linked list
    static void sort() {
        node current = head1;
        node temp = head1;

        // Compares the elements(bubble sort)
        // If node->next->data is less than node->data
        // then we will swap the data.
        while (current.next != null) {
            temp = current.next;
            while (temp != null) {
                if (temp.data < current.data) {
                    int t = temp.data;
                    temp.data = current.data;
                    current.data = t;
                }
                temp = temp.next;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        // First linked list
        head1 = AddNode(head1, 1);
        head1 = AddNode(head1, 6);
        head1 = AddNode(head1, 10);
        System.out.println("List1:");
        printList(head1);
        // Second Linked list
        head2 = AddNode(head2, 5);
        head2 = AddNode(head2, 3);
        head2 = AddNode(head2, 9);
        System.out.println("List2:");
        printList(head2);

        head1 = concatenateList();

        sort();
        System.out.println("Final merged list:");
        printList(head1);
    }
}
