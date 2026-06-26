package practice;


class A{
	public synchronized void m1(B b) {
		System.out.println("Thread 1 start executing m1");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Calling B's m2");
		b.Bm2();
	}
	
	public synchronized void Am1() {
		System.out.println("A's m1 method");
	}
}

class B{
	public synchronized void m2(A a) {
		System.out.println("Thread 2 start executing m2");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Calling A's m1");
		a.Am1();
	}
	
	public synchronized void Bm2() {
		System.out.println("B's m2 method");
	}
}



public class DeadLock extends Thread{

	A a = new A();
	B b = new B();
	
	public void m() {
		this.start();
		a.m1(b);	// executed by main thread
	}
	
	public void run() {
		b.m2(a); 	// executed by child thread
	}
	
	public static void main(String[] args) {
		DeadLock d = new DeadLock();
		d.m(); 
		
	}

}
