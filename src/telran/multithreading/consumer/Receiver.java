package telran.multithreading.consumer;

import telran.multithreading.messaging.*;

public class Receiver extends Thread {
	private MessageBox messageBox;
	private String lastMessage = "finish";

	public Receiver(MessageBox messageBox) {
		this.messageBox = messageBox;
		
		}

	@Override
	public void run() {
		boolean state = true;
		while(state) {
			String message = null;
			try {
				message = messageBox.take();
			} catch (InterruptedException e){
				
			}
			if(message == lastMessage) {
				state = false;
			} else {
			System.out.printf("thread id: %d, message: %s\n", getId(), message);
			}
		}
		this.interrupt();
	}

}
