package programs.linkedlist;

public class PartitionLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(10);
        linkedList.add(2);
        linkedList.add(9);
        linkedList.add(3);
        linkedList.add(8);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(6);
        linkedList.print();

        System.out.println();
        System.out.println("After Partition");

        LinkedList partitionedList = partition(linkedList,6);
        partitionedList.print();
    }

    private static LinkedList partition(LinkedList linkedList, int i) {
        Node current = linkedList.head;

        Node left = null;
        Node leftHead = null;
        Node rightHead = null;
        Node right = null;

        while(current != null){
            if(current.data < i){
                if(left == null){
                    left = new Node(current.data);
                    leftHead = left;
                }else{
                    left.next = new Node(current.data);
                    left = left.next;

                }
            }else{
                if(right == null){
                    right = new Node(current.data);
                    rightHead = right;
                }else{
                    right.next = new Node(current.data);
                    right = right.next;
                }
            }
            current = current.next;
        }
        if(left != null){
            left.next = rightHead;
        }

        LinkedList partitionedList =  new LinkedList();
        partitionedList.head = leftHead;
        return  partitionedList;
    }

}
