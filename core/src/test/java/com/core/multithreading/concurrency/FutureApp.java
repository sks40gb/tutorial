package com.core.multithreading.concurrency;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sunil
 */
public class FutureApp {

    @Test
    public void executeInSequence() throws InterruptedException, ExecutionException {
        List<Integer> items = new ArrayList();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<List<Integer>> future1 = executor.submit(new Task(items));
        Future<List<Integer>> future2 = executor.submit(new Task(items));
        Future<List<Integer>> future4 = executor.submit(new Task(items));
        Future<List<Integer>> future3 = executor.submit(new Task(items));
        System.out.println("FUTURE 1 : " + future1.get().size());
        System.out.println("FUTURE 2 : " + future2.get().size());
        System.out.println("FUTURE 3 : " + future3.get().size());
        System.out.println("FUTURE 4 : " + future4.get().size());
        executor.shutdown();
    }

    @Test
    public void executeInParallel() throws InterruptedException, ExecutionException {
        List<Integer> items = new ArrayList();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<List<Integer>> future1 = executor.submit(new Task(items));
        System.out.println("FUTURE 1 : " + future1.get().size());
        Future<List<Integer>> future2 = executor.submit(new Task(items));
        System.out.println("FUTURE 2 : " + future2.get().size());
        Future<List<Integer>> future3 = executor.submit(new Task(items));
        System.out.println("FUTURE 3 : " + future3.get().size());
        Future<List<Integer>> future4 = executor.submit(new Task(items));
        System.out.println("FUTURE 4 : " + future4.get().size());
        executor.shutdown();
    }
}

class Task implements Callable<List<Integer>> {

    List<Integer> items;
    private static int count = 0;

    public Task(List<Integer> items) {
        this.items = items;
    }

    public List<Integer> call() {
        System.out.println("Task " + ++count + " started");
        for (int i = 0; i < 10; i++) {
            items.add(i);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return items;
    }
}
