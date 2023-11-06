package telran.examples;

public class PrintNumbersPortionsAppl {
	
	private static final int N_PRINTERS = 5;
	private static final int N_NUMBERS = 100;
	private static final int N_PORTIONS = 20;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		Printer[] printers = new Printer[N_PRINTERS];
		if(N_NUMBERS % N_PORTIONS != 0) {
			throw new RuntimeException("" + N_NUMBERS + "does not divide to " + N_PORTIONS);
		}
		fillPrinters(printers);
		sequence(printers);
		startPrint(printers);
		printers[0].interrupt();
		
	}

	private static void fillPrinters(Printer[] printers) {
		for(int i = 0; i < N_PRINTERS; i++) {
			printers[i] = new Printer(N_NUMBERS, i + 1, N_PORTIONS);
		}
		
	}

	private static void sequence(Printer[] printers) {
		for(int i = 0; i < N_PRINTERS; i++) {
			printers[i].setNextPrinter(printers[(i + 1)%N_PRINTERS]);
		}
		
	}

	private static void startPrint(Printer[] printers) {
		for(Printer printer : printers) {
			  printer.start();
		}
		
	}

}
