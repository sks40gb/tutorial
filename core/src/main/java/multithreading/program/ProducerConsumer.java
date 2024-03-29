package multithreading.program;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sunil
 */
public class ProducerConsumer {

    public static int count;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Thread t1 = new Thread(new Producer(list));
        t1.setName("You and Me");
        t1.start();
        new Thread(new Consumer(list, "ONE")).start();
        new Thread(new Consumer(list, "TWO")).start();
        new Thread(new Consumer(list, "THR")).start();
    }
}

class Producer implements Runnable {

    private final List<Integer> list;

    public Producer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                list.add(ProducerConsumer.count++);
                System.out.println("Producing : " + ProducerConsumer.count);
                list.notifyAll();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class Consumer implements Runnable {

    private String name;
    private final List<Integer> list;

    public Consumer(List<Integer> list, String name) {
        this.name = name;
        this.list = list;
    }

    public void run() {
        while (true) {
            try {
                synchronized (list) {
                    if (!list.isEmpty()) {
                        System.out.println("Consuming : " + name + " : " + list.get(0));
                        list.remove(0);
                        try {
                            list.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
