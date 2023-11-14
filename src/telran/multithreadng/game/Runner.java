package telran.multithreadng.game;

import java.time.Instant;

public class Runner extends Thread{
	
	private Race race;
	private int runnerId;
	private Instant finishTime;
	public Runner(Race race, int runnerId) {
		this.race = race;
		this.runnerId = runnerId;
	}
	public int getRunnerId() {
		return runnerId;
	}
	public Instant getFinishTime() {
		return finishTime;
	}
	@Override
	public void run() {
		int minSleep = race.getMinSleep();
		int sleepRange = race.getMaxSleep() - minSleep + 1;
		int distance = race.getDistance();
		for(int i = 0; i < distance; i++) {
			try {
				sleep((long) (minSleep + Math.random() * sleepRange));
			} catch (InterruptedException e) {
				throw new IllegalStateException();
			}
			System.out.println(runnerId);
		}
		try {
			race.lock.lock();
			finishTime = Instant.now();
			finishRace();
		}finally{
			race.lock.unlock();
		}
		
	}
	private void finishRace() {
		race.getResultsTable().add(this);
		
	}

}
