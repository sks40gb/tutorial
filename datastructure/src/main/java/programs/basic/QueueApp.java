package programs.basic;

import java.util.LinkedList;
import java.util.Queue;

public class QueueApp {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("element 1");
        queue.add("element 2");
        System.out.println(queue);

        String element2 = queue.remove();
        System.out.println(queue);

        String element1 = queue.poll();
        System.out.println(queue);
    }
}
