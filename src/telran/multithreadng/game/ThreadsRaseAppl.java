package telran.multithreadng.game;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.IntStream;

import telran.view.*;

public class ThreadsRaseAppl {

	private static final int MIN_THREADS = 3;
	private static final int MAX_THREADS = 10;
	private static final int MIN_DISTANCE = 100;
	private static final int MAX_DISTANCE = 3500;
	private static final int MIN_SLEEP = 2;
	private static final int MAX_SLEEP = 5;
	public static void main(String[] args) {
		InputOutput io = new SystemInputOutput();
		Menu menu = new Menu("Threads reads", Item.of("Start new game", ThreadsRaseAppl :: startGame), Item.exit());
		menu.perform(io);

	}
	static void startGame(InputOutput io) {
		int nThreads = io.readInt("Enter numbers of runners", "Wrong number of runners", MIN_THREADS, MAX_THREADS);
		int distance = io.readInt("Enter distance in the range", "Wromg distance", MIN_DISTANCE, MAX_DISTANCE);
		Race race = new Race(distance, MIN_SLEEP, MAX_SLEEP, Instant.now(), new ArrayList<Runner>());
		Runner[] runners = new Runner[nThreads];
		startRunners(runners, race);
		try {
			joinRunners(runners);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		displayResultsTable(race);
		
	}
	private static void displayResultsTable(Race race) {
		System.out.println("place\tracer number\ttime");
		ArrayList<Runner> resultsTable = race.getResultsTable();
		IntStream.range(0, resultsTable.size()).mapToObj(i ->  toPrintedString(i, race))
		.forEach(System.out::println);
		
	}
	
	private static String toPrintedString(int index, Race race) {
		Runner runner = race.getResultsTable().get(index);
		return String.format("%3d\t%7d\t\t%d", index + 1, runner.getRunnerId(),
				ChronoUnit.MILLIS.between(race.getStartTime(), runner.getFinishTime()));
	}
	
	private static void startRunners(Runner[] runners, Race race) {
		for(int i = 0; i < runners.length; i++) {
			runners[i] = new Runner(race, i + 1);
			runners[i].start();
		}
		
	}
	private static void joinRunners(Runner[] runners) throws InterruptedException {
		for(int i = 0; i < runners.length; i++) {
				runners[i].join();
		}
	
	}

}
