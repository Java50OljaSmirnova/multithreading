package telran.multithreading.consumer;

import telran.multithreading.messaging.*;

public class Receiver extends Thread {
	private MessageBox messageBox;

	public Receiver(MessageBox messageBox) {
		this.messageBox = messageBox;
		setDaemon(true);
	}

	@Override
	public void run() {
		while(true) {
			String message = null;
			try {
				message = messageBox.take();
			} catch (InterruptedException e){
				
			}
			System.out.printf("thread id: %d, message: %s\n", getId(), message);
		}
	}

}
