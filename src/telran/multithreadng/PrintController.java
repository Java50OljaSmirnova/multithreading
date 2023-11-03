package telran.multithreadng;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PrintController {

	public static void main(String[] args) throws InterruptedException {
		Printer printer1 = new Printer('#', 100);
		Printer printer2 = new Printer('*', 100);
		Instant start = Instant.now();
		printer1.start();
		printer2.start();
		printer1.join();
		printer2.join();
		Instant finish = Instant.now();
		System.out.printf("running time is %d\n", ChronoUnit.MILLIS.between(start, finish));

	}

}
