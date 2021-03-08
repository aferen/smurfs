
public class Enemy extends Character {

	private int enemyId;
	
	private String enemyName;
	
	private String enemyType;

	public Enemy() {}
	
	public Enemy(int enemyId, String enemyName, String enemyType) {
		super();
		this.enemyId = enemyId;
		this.enemyName = enemyName;
		this.enemyType = enemyType;
	}

	public int getEnemyId() {
		return enemyId;
	}

	public void setEnemyId(int enemyId) {
		this.enemyId = enemyId;
	}

	public String getEnemyName() {
		return enemyName;
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}

	public String getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(String enemyType) {
		this.enemyType = enemyType;
	}
	
	
}
