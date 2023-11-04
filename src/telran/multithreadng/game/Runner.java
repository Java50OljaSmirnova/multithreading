package telran.multithreadng.game;

public class Runner extends Thread{
	
	private Race race;
	private int runnerId;
	public Runner(Race race, int runnerId) {
		this.race = race;
		this.runnerId = runnerId;
	}
	@Override
	public void run() {
		int minSleep = race.getMinSleep();
		int sleepRange = race.getMaxSleep() - minSleep + 1;
		for(int i = 0; i < race.getDistance(); i++) {
			try {
				sleep((long) (minSleep + Math.random() * sleepRange));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("%d - step %d\n", runnerId, i);
		}
		race.setWinner(runnerId);
	}

}
