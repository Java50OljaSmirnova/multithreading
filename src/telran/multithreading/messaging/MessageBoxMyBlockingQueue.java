package telran.multithreading.messaging;

import java.util.concurrent.*;

public class MessageBoxMyBlockingQueue implements MessageBox {
	private MyBlockingQueue<String> messages = new MyLinkedBlockingQueue<>(1);

	@Override
	public void put(String message) {
		try {
			messages.put(message);
		} catch (InterruptedException e) {
			
		}

	}

	@Override
	public String take() throws InterruptedException {
		return messages.take();
	}

	@Override
	synchronized public String pull() {
		
		return messages.poll();
	}

}
