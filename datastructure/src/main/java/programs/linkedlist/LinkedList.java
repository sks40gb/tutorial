package programs.linkedlist;

/**
 *
 * @author sunsingh
 */
public class LinkedList {

    public Node head;

    public LinkedList(){

    }

    public LinkedList(Node head){
        this.head = head;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;

            }
            temp.next = new Node(data);
        }
    }
}
