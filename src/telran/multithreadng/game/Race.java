package telran.multithreadng.game;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	private int winner = -1;
	public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
	}
	public int getDistance() {
		
		return distance;
	}
	public int getWinner() {
		
		return winner;
	}
	public int getMinSleep() {
		
		return minSleep;
	}
	public int getMaxSleep() {
		
		return maxSleep;
	}
	public void setWinner(int winner) {
		
		if(this.winner == -1) {
			this.winner = winner;
		}
	}

}
