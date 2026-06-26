package practice;

public class DeadlockExample {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    static class ThreadA extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("ThreadA acquired lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("ThreadA waiting for lock2");

                synchronized (lock2) {
                    System.out.println("ThreadA acquired lock2");
                }
            }
        }
    }

    static class ThreadB extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("ThreadB acquired lock2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("ThreadB waiting for lock1");

                synchronized (lock1) {
                    System.out.println("ThreadB acquired lock1");
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();
        ThreadB t2 = new ThreadB();

        t1.start();
        t2.start();
    }
}
