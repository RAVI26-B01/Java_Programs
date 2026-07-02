package theory_practice;

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer{

	private final Queue<Integer> queue = new LinkedList<>();
	final int bufferSize = 5;
	
	public synchronized void producer(int value) throws InterruptedException {
		
		while(queue.size() == bufferSize) {
			wait();
		}
		
		queue.add(value);
		System.out.println("Produced: " + value);
		notifyAll();
		
	}
	
	public synchronized int consumer() throws InterruptedException {
		while(queue.isEmpty()) {
			wait();
		}
		
		int value = queue.poll();
		System.out.println("Consumed: " + value);
        notifyAll();
        
		return value;
	}

}

public class ProducerConsumer {
	public static void main(String[] args) {
		
		SharedBuffer buffer = new SharedBuffer();
		
			 Thread producer = new Thread(() -> {
		            int value = 1;
		            try {
		                while (true) {
		                    buffer.producer(value++);
		                    Thread.sleep(500);
		                }
		            } catch (InterruptedException e) {
		                Thread.currentThread().interrupt();
		            }
		        });
			 
			 Thread consumer = new Thread(() -> {
		            try {
		                while (true) {
		                    buffer.consumer();
		                    Thread.sleep(1000);
		                }
		            } catch (InterruptedException e) {
		                Thread.currentThread().interrupt();
		            }
		        });

		        producer.start();
		        consumer.start();
	}
}
