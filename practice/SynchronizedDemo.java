package practice;


class Display{
	public synchronized void wish(String name) {
		
		for(int i = 0 ; i<3 ; i++) {
			
			System.out.println("Good Morning : "+ name );
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class myThread extends Thread{
	Display d;
	String name;
	
	 myThread(Display d, String name) {
		 this.d = d;
		 this.name = name;
	}
	 
	public void run() {
		d.wish(name);
	}
}

public class SynchronizedDemo {

	/*
	Good Morning : Raj
	Good Morning : Raj
	Good Morning : Raj
	Good Morning : Ravi
	Good Morning : Ravi
	Good Morning : Ravi
	 
	public static void main(String[] args) {
		Display d = new Display();
		myThread t1 = new myThread(d, "Ravi");
		myThread t2 = new myThread(d, "Raj");
		t1.start();
		t2.start();
	}
	*/
	
	
	/*
	 	Good Morning : Raj
		Good Morning : Ravi
		Good Morning : Raj
		Good Morning : Ravi
		Good Morning : Ravi
		Good Morning : Raj
	 */
	public static void main(String[] args) {
		Display d1 = new Display();
		Display d2 = new Display();
		myThread t1 = new myThread(d1, "Ravi");
		myThread t2 = new myThread(d2, "Raj");
		t1.start();
		t2.start();
	}
	
}
