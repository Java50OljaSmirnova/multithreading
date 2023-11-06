package telran.examples;

public class Printer extends Thread {
	int nNumbers;
	int number;
	int amount;
	Printer nextPrinter;
	public Printer(int nNumbers, int number, int portions) {
		this.nNumbers = nNumbers;
		this.number = number;
		this.amount = nNumbers / portions;
	}
	
	public void setNextPrinter(Printer nextPrinter) {
		this.nextPrinter = nextPrinter;
	}

	@Override
	public void run() {
		while(nNumbers != 0) {
			try {
				sleep(0);
			} catch (InterruptedException e) {
				for(int i = 0; i < amount; i++) {
					System.out.printf(number + "");
				}
				System.out.println();
				nNumbers -= amount;
				nextPrinter.interrupt();
			}
		}
	}
}
