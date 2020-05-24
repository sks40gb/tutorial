package com.core.multithreading.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Sunil A semaphore controls access to a shared resource through the use of a counter. If the counter is
 * greater than zero, then access is allowed. If it is zero, then access is denied. What the counter is counting are
 * permits that allow access to the shared resource. Thus, to access the resource, a thread must be granted a permit
 * from the semaphore.
 */
public class SemaphoreApp {
// max 2 people

    static Semaphore semaphore = new Semaphore(2);

    static class MyATMThread extends Thread {

        String name = "";

        MyATMThread(String name) {
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : got the permit!");

                try {
                    System.out.println(name + " : is performing operation "
                            + ", available Semaphore permits : "
                            + semaphore.availablePermits());

                    // sleep 1 second
                    Thread.sleep(5000);

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available Semaphore permits now: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    @Test
    public void main()  {

        System.out.println("Total available Semaphore permits : "
                + semaphore.availablePermits());

        MyATMThread t1 = new MyATMThread("A");
        t1.start();

        MyATMThread t2 = new MyATMThread("B");
        t2.start();

        MyATMThread t3 = new MyATMThread("C");
        t3.start();

    }
}
