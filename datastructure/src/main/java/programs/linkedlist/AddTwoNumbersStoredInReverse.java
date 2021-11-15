package programs.linkedlist;

/**
 * https://nbviewer.org/github/donnemartin/interactive-coding-challenges/blob/master/linked_lists/add_reverse/add_reverse_solution.ipynb
 *
 * Problem: Add two numbers whose digits are stored in a linked list in reverse order.¶
 * Input 1: 6->5->None
 * Input 2: 9->8->7
 * Result: 5->4->8
 */
public class AddTwoNumbersStoredInReverse {

    public static void main(String[] args) {
        LinkedList first = new LinkedList();
        first.add(6);
        first.add(5);

        LinkedList second = new LinkedList();
        second.add(9);
        second.add(8);
        second.add(7);

        sum(first, second).print();

    }

    public static LinkedList sum(LinkedList first, LinkedList second) {
        Node n1 = first.head;
        Node n2 = second.head;
        Node result = null;
        Node resultHead = null;
        int carry = 0;
        while (n1 != null && n2 != null) {
            int sum = n1.data + n2.data + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            if (result == null) {
                result = new Node(sum);
                resultHead = result;
            } else {
                result.next = new Node(sum);
                result = result.next;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        while (n1 != null) {
            int sum = n1.data + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }else{
                carry = 0;
            }
            if (result == null) {
                result = new Node(sum);
                resultHead = result;
            } else {
                result.next = new Node(sum);
                result = result.next;
            }
            n1 = n1.next;
        }

        while (n2 != null) {
            int sum = n2.data + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }else{
                carry = 0;
            }
            if (result == null) {
                result = new Node(sum);
                resultHead = result;
            } else {
                result.next = new Node(sum);
                result = result.next;
            }
            n2 = n2.next;
        }

        if (carry > 0) {
            result.next = new Node(carry);
        }

        return new LinkedList(resultHead);
    }


}
