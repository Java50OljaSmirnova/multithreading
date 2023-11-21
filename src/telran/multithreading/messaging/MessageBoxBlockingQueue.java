package telran.multithreading.messaging;

import java.util.concurrent.*;

public class MessageBoxBlockingQueue implements MessageBox {
	private BlockingQueue<String> messages = new LinkedBlockingQueue<>();

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
