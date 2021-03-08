import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class GameMap extends JFrame {

	public GameMap() {
		setTitle("The Smurfs");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.white);

		setSize(580, 450);
		setLocationRelativeTo(null);

		MapInfo map = readFile("/resources/map.txt");

		TilePane tiles = new TilePane(map);
		tiles.setBackground(Color.white);
		
		JLabel score = new JLabel("Score : 0");
		score.setForeground(Color.BLUE);
		
		try {
			Image smurfetteImage = ImageIO.read(this.getClass().getResourceAsStream("/resources/images/smurfette.png")).getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);;
			ImageIcon smurfetteIcon = new ImageIcon(smurfetteImage);
			JLabel label = new JLabel(smurfetteIcon);
			label.setBounds(10,10,1080,527);
			getContentPane().add(label);

		} catch (IOException ex) {
			System.out.print(ex);
		}
		
		getContentPane().add(tiles);
		getContentPane().add(score, BorderLayout.NORTH);
	
		setVisible(true);
	}

	private MapInfo readFile(String filePath) {
		Location location = new Location(0, 0);
		int[][] map = new int[11][13];
		int enemyCount = 1, lineCount = 0, enemyId;
		String enemyName = "";
		ArrayList<Character> characters = new ArrayList<Character>();
		characters.add(new Character(1, "lazy smurf", CharacterType.Player, new Location(5, 6)));
		try {
			Scanner scn = new Scanner(this.getClass().getResourceAsStream(filePath));
			StringBuilder sb = new StringBuilder();
			String line;
			while (scn.hasNextLine()) {
				line = scn.nextLine();
				if (line.startsWith("Karakter:")) {
					enemyId = enemyCount++;
					for (var item : line.split(",")) {
						item = item.substring(item.indexOf(":"));
						if (item.length() > 1) {
							enemyName = item;
						} else {
							switch (item) {
							case "A":
								location = new Location(0, 3);
								break;
							case "B":
								location = new Location(0, 10);
								break;
							case "C":
								location = new Location(5, 0);
								break;
							case "D":
								location = new Location(10, 3);
								break;
							}
						}
					}
					characters.add(new Character(enemyId, enemyName, CharacterType.Enemy, location));
				} else {
					int i = 0;
					for (var item : line.split("	")) {
						map[lineCount][i] = Integer.parseInt(item);
						i++;
					}
					lineCount++;
				}
			}
		} catch (Exception e) {
			System.err.println("Error:" + e);
		}
		return new MapInfo(map, characters);
	}
}
