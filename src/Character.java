
public class Character {
	
	private int id;
	
	private String name;
	
	private CharacterType type;
	
	private Location location;

	public Character() {}
	
	public Character(int id, String name, CharacterType type, Location location) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CharacterType getType() {
		return type;
	}

	public void setType(CharacterType type) {
		this.type = type;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void shortestPath() {}
}
