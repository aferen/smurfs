
public class Mushroom extends Object {
	
	private int count = 1;

	private int score = 50;

	private int visiblePeriod = 20;
	
	private int hiddenPeriod = 7;
	
	public Mushroom() {
		super();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getVisiblePeriod() {
		return visiblePeriod;
	}

	public void setVisiblePeriod(int visiblePeriod) {
		this.visiblePeriod = visiblePeriod;
	}

	public int getHiddenPeriod() {
		return hiddenPeriod;
	}

	public void setHiddenPeriod(int hiddenPeriod) {
		this.hiddenPeriod = hiddenPeriod;
	}
	
	
}
