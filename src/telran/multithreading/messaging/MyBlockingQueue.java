package telran.multithreading.messaging;

import java.util.concurrent.*;

public interface MyBlockingQueue<T> {
	boolean add(T obj);
	boolean offer(T obj);
	void put(T obj) throws InterruptedException;
	boolean offer(T obj, long timeout, TimeUnit unit) throws InterruptedException;
	T remove();
	T poll();
	T take() throws InterruptedException;
	T poll(long timeout, TimeUnit unit) throws InterruptedException;
	T element();
	T peek();
}
