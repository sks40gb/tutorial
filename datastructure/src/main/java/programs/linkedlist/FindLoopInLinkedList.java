package programs.linkedlist;

/*

https://nbviewer.org/github/donnemartin/interactive-coding-challenges/blob/master/linked_lists/find_loop_start/find_loop_start_solution.ipynb

Algorithm
-------------------------
Use two references slow, fast, initialized to the head
Increment slow and fast until they meet
fast is incremented twice as fast as slow
If fast.next is None, we do not have a circular list
When slow and fast meet, move slow to the head
Increment slow and fast one node at a time until they meet
Where they meet is the start of the loop

 */
public class FindLoopInLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        Node node4 = new Node(4);
        list.head.next.next.next = node4;
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);
        list.head.next.next.next.next.next.next.next.next = new Node(9);
        list.head.next.next.next.next.next.next.next.next.next = node4;

        System.out.println(getFirstNode(list));
    }

    private static Node getFirstNode(LinkedList list) {

        if(list.head == null || list.head.next == null){
            return null;
        }
        Node slow = list.head;
        Node fast = list.head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if(slow == fast){
                break;
            }
        }

        slow = list.head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
            //Is below code required
            if(fast == null){
                return null;
            }
        }
        return slow;
    }
}
