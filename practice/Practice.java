package practice;

<<<<<<< HEAD
public class Practice{
	
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
=======
public class Practice {

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
>>>>>>> 32d090ef571491f5088873e502d2e27de9d253aa
