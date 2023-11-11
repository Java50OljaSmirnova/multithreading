package telran.multithreadng;

public class Worker extends Thread {
	static final Object mutex1 = new Object();
	static final Object mutex2 = new Object();
	@Override
	public void run() {
	  f1();
	}
	private void f1() {
		synchronized(mutex1) {
			synchronized(mutex2) {
				//working with resources
			}
		}
		synchronized(mutex1) {
			
		}
		synchronized(mutex2){
			
		}
		
	}
	
	

}
