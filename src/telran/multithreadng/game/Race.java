package telran.multithreadng.game;

import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	Lock lock = new ReentrantLock(true);
	private Instant startTime;
	private ArrayList<Runner> resultsTable;
	
	
	public Race(int distance, int minSleep, int maxSleep, Instant startTime, ArrayList<Runner> resultsTable) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		this.startTime = startTime;
		this.resultsTable = resultsTable;
	}

	public Instant getStartTime() {
		return startTime;
	}

	public ArrayList<Runner> getResultsTable() {
		return resultsTable;
	}

	public int getDistance() {	
		return distance;
	}
	
	public int getMinSleep() {		
		return minSleep;
	}
	public int getMaxSleep() {		
		return maxSleep;
	}
	
}
