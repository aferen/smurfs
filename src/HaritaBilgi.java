import java.awt.*;
import java.util.ArrayList;

public class HaritaBilgi {
	
	private int[][] harita;
		
	private ArrayList<Karakter> karakterler;

	
	public HaritaBilgi(int[][] harita, ArrayList<Karakter> karakterler) {
		super();
		this.harita = harita;
		this.karakterler = karakterler;
	}

	public int[][] getHarita() {
		return harita;
	}

	public ArrayList<Karakter> getKarakterler() {
		return karakterler;
	}

}
