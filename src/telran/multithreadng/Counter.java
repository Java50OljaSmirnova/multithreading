package telran.multithreadng;

public class Counter extends Thread {
	private static int counterResource1 = 0;
	private static int counterResource2 = 0;
	static final Object mutex1 = new Object();
	static final Object mutex2 = new Object();
	private int nCounts;
	
	public Counter(int nCounts) {
		this.nCounts = nCounts;
	}
	
	public static int getCounterResource1() {
		return counterResource1;
	}
	
	public static int getCounterResource2() {
		return counterResource2;
	}

	@Override
	public void run() {
		for(int i = 0; i < nCounts; i++) {
			count1();
			count2();
		}
	}
	static private void count2() {
		synchronized (mutex2) {
			System.out.println("Counter resource #2 = " + counterResource2);
			synchronized (mutex1) {
				counterResource1++;
			}
		}
	}
	static private void count1() {
		synchronized (mutex1) {
			System.out.println("Counter resource #1 = " + counterResource1);
			synchronized (mutex2) {
				counterResource1++;
			}
		}
		
	}
	

}
