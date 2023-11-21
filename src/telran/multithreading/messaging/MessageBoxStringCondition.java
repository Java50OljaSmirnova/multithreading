package telran.multithreading.messaging;

import java.util.concurrent.locks.*;

public class MessageBoxStringCondition implements MessageBox {
	private String message;
	private Lock lock = new ReentrantLock();
	private Condition consumerWaiting = lock.newCondition();
	private Condition producerWaiting = lock.newCondition();

	@Override
	public void put(String message) {
		try {
		lock.lock();
		while(this.message != null) {
			try {
				producerWaiting.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.message = message;
		consumerWaiting.signal();
		} finally{
			lock.unlock();
		}

	}

	@Override
	synchronized public String take() throws InterruptedException {
		try {
			lock.lock();
			while(message == null) {
			consumerWaiting.await();
		}
		String res = message;
		message = null;
		producerWaiting.signal();
		return res;
		}finally {
			lock.unlock();
		}
	}

	@Override
	synchronized public String pull() {
		
		try {
			lock.lock();
			String str = message;
			message = null;
			producerWaiting.signal();
			return str;
		} finally {
			lock.unlock();
		}
	}

}
