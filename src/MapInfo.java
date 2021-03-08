import java.awt.*;
import java.util.ArrayList;

public class MapInfo {
	
	private int[][] map;
		
	private ArrayList<Character> characters;

	
	public MapInfo(int[][] map, ArrayList<Character> characters) {
		super();
		this.map = map;
		this.characters = characters;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	public void setEnemies(ArrayList<Character> characters) {
		this.characters = characters;
	}
	

}
