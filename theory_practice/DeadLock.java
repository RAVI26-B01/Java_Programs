package theory_practice;

/*
   Thread.sleep(5000) is not required to create a deadlock.
   It simply increases the likelihood that both threads acquire their first lock before trying to acquire the second lock, 
   making the deadlock easy to reproduce consistently.
 */

public class DeadLock extends Thread{

	private static final Object lock1 = new Object();
	private static final Object lock2 = new Object();
	
	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Thread1());
		Thread thread2 = new Thread(new Thread2());
		thread1.start();
		thread2.start();
	}
	
	static class Thread1 implements Runnable{

		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("thread1 acquired lock 1");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread 1 waiting for lock 2");
				
				synchronized (lock2) {
					System.out.println("thread1 acquired lock 2");
				}
			}
		}
	}
	
	static class Thread2 implements Runnable{

		@Override
		public void run() {
			synchronized (lock2) {
				System.out.println("thread2 acquired lock 2");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread 2 waiting for lock 1");
				
				synchronized (lock1) {
					System.out.println("thread2 acquired lock 1");
				}
			}
		}
	}

}
