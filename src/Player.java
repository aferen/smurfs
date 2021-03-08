
public class Player extends Character {
	
	private int playerId;
	
	private String playerName;
	
	private String playerType;
	
	private int Score;
	
	public Player() {}
	
	public Player(int playerId, String playerName, String playerType, int score) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerType = playerType;
		Score = score;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public void showScore() {}
}
