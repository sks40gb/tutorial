package programs.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunil
 */
public class RemoveDuplicate {

    static class LinkedList {

        Node head;

        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

        /* Function to remove duplicates from an unsorted linked list */
        public void removeDuplicateUsingSet() {
            Node current = head;
            Node unique = null;
            Node uniqueHead = null;
            Set<Integer> dataSet = new HashSet<>();
            while (current != null) {
                if (!dataSet.contains(current.data)) {
                    dataSet.add(current.data);
                    if (unique == null) {
                        unique = new Node(current.data);
                        uniqueHead = unique;
                    } else {
                        unique.next = new Node(current.data);
                        unique = unique.next;
                    }
                }
                current = current.next;
            }
            head = uniqueHead;
        }

        public void removeDuplicate() {

            Node uniqueHead = null;
            Node unique = null;
            Node current = head;
            while (current != null) {
                if (unique == null) {
                    unique = new Node(current.data);
                    uniqueHead = unique;
                } else {
                    if (!foundMatch(uniqueHead, current.data)) {
                        unique.next = new Node(current.data);
                        unique = unique.next;
                    }
                }
                current = current.next;
            }
            head = uniqueHead;
        }

        public boolean foundMatch(Node node, int data) {
            Node current = node;
            while (current != null) {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(10);

        System.out.println(
            "Linked List before removing duplicates : \n ");
        list.printList();

//        list.removeDuplicateUsingSet();
        list.removeDuplicate();
        System.out.println("");
        System.out.println(
            "Linked List after removing duplicates : \n ");
        list.printList();
    }

}
