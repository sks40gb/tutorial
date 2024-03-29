package programs.linkedlist;

/**
 *
 * @author sunsingh
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.print(); //     1->2->3->4
        //reverseIterative(linkedList);
       linkedList.head = reverseIterative(linkedList.head);
        System.out.println("After reverse");
        System.out.println();
        linkedList.print();
    }

    public static Node reverseIterative(Node root){

        Node prev = null;
        Node current = root;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    //[1]->[2]->[3]->[4]
    public static Node reverseRecursively(Node node) {  //1 ->2 ->3 ->4
         //base case - tail of original linked list 
        if (node == null || node.next == null) {
            return node;
        }
        Node newHead = reverseRecursively(node.next); // 4 ->3 ->2
        //reverse the link e.g. C->D->null will be null 
        node.next.next = node;                        
        node.next = null;
        return newHead;
    }

}
