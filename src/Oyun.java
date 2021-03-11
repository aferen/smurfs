import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;
public class Oyun extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton[][] buttons;

	private Oyuncu sirin;
	private int sayiYukseklik = 11;
	private int sayiGenislik = 13;

	public Oyun(Oyuncu sirin) {
		this.sirin = sirin;
		setTitle("The Smurfs");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.white);

		setSize(590, 460);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		HaritaBilgi haritaBilgi = readFile(this.sirin, "/resources/harita.txt");

		haritaOlustur(panel,haritaBilgi);
		haritaGuncelle(haritaBilgi);

		JLabel puan = new JLabel("Puan : " + sirin.getPuan());
		puan.setForeground(Color.BLUE);
		puan.setBounds(20, 5, 200, 10);
		ImageIcon sirineIcon = getIconImage("sirine", 40, 40);
		JLabel sirine = new JLabel(sirineIcon);
		sirine.setBounds(540, 260, 40, 40);
		
		panel.add(sirine);
		panel.add(puan);
		
		add(panel);
		setVisible(true);
	}

	private void ilerle(int keyCode, HaritaBilgi haritaBilgi) throws InterruptedException {
		int x, y, birim;
		for (Karakter karakter : haritaBilgi.getKarakterler()) {
			if (karakter.getTur() == KarakterTip.Oyuncu) {
				x = karakter.getLokasyon().getX();
				y = karakter.getLokasyon().getY();
				birim = karakter.getOyuncuDavranis().getBirim();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					if (x - birim > 0) {
						if (haritaBilgi.getHarita()[x - birim][y] != 0) {
							for (int i = 1; i <= birim; i++) {
								if (haritaBilgi.getHarita()[x - i][y] != 0) {
									karakter.getLokasyon().setX(x - i);
									buttons[x - i][y].setIcon(buttons[x-i+1][y].getIcon());
									buttons[x-i+1][y].setIcon(null);
									//Thread.sleep(100);
								} else {
									break;
								}
								
							}
						}
					}
					break;
				case KeyEvent.VK_DOWN:
					if (x + birim < sayiYukseklik) {
						if (haritaBilgi.getHarita()[x + birim][y] != 0) {
							for (int i = 1; i <= birim; i++) {
								if (haritaBilgi.getHarita()[x + i][y] != 0) {
									karakter.getLokasyon().setX(x + i);
									buttons[x + i][y].setIcon(buttons[x+i-1][y].getIcon());
									buttons[x+i-1][y].setIcon(null);
								} else {
									break;
								}
							}
						}
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (y + birim < sayiGenislik) {
						if (haritaBilgi.getHarita()[x][y + birim] != 0) {
							for (int i = 1; i <= birim; i++) {
								if (haritaBilgi.getHarita()[x][y+i] != 0) {
									karakter.getLokasyon().setY(y + i);
									buttons[x][y + i].setIcon(buttons[x][y+i-1].getIcon());
									buttons[x][y+i-1].setIcon(null);
								} else {
									break;
								}
							}
							
						}
					}
					break;
				case KeyEvent.VK_LEFT:
					if (y - birim > 0) {
						if (haritaBilgi.getHarita()[x][y - birim] != 0) {
							for (int i = 1; i <= birim; i++) {
								if (haritaBilgi.getHarita()[x][y-i] != 0) {
									karakter.getLokasyon().setY(y - i);
									buttons[x][y - i].setIcon(buttons[x][y-i+1].getIcon());
									buttons[x][y-i+1].setIcon(null);
								} else {
									break;
								}
							}
						}
					}
					break;
				}

			}
		}

	}

	private void haritaOlustur(JPanel panel,HaritaBilgi haritaBilgi) {
		int buttonWidth = 40;
		int buttonHeight = 35;
		String door;
		buttons = new JButton[sayiYukseklik][sayiGenislik];
		for (int i = 0; i < sayiYukseklik; i++) {
			for (int j = 0; j < sayiGenislik; j++) {
				door = doorInfo(i, j);
				buttons[i][j] = new JButton();
				buttons[i][j].setForeground(Color.BLACK);
				buttons[i][j].setBorder(new LineBorder(Color.BLACK));

				if (haritaBilgi.getHarita()[i][j] == 0) {
					buttons[i][j].setBackground(new Color(152, 152, 152));
				} else if (door != "") {
					buttons[i][j].setBackground(new Color(255, 51, 51));
					for (Karakter karakter : haritaBilgi.getKarakterler()) {
						if (karakter.getLokasyon().getX() == i && karakter.getLokasyon().getY() == j) {
							buttons[i][j].setBackground(Color.WHITE);
						} else {
							buttons[i][j].setText(door);
						}
					}
				} else {
					buttons[i][j].setBackground(Color.WHITE);
				}
				
				buttons[i][j].setBounds(20 + j * buttonWidth, 20 + i * buttonHeight, buttonWidth, buttonHeight);
				buttons[i][j].addKeyListener(new KeyListener() {
					@Override
					public void keyTyped(KeyEvent e) {

					}

					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
								|| e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT)
							try {
								ilerle(e.getKeyCode(), haritaBilgi);
							} catch (InterruptedException ie) {
								System.out.println(ie);
							}
					}

					@Override
					public void keyReleased(KeyEvent e) {

					}
				});

				panel.add(buttons[i][j]);
			}
		}
	}

	private void haritaGuncelle(HaritaBilgi haritaBilgi) {
		String imageName = "";
		int x, y;
		for (Karakter karakter : haritaBilgi.getKarakterler()) {
			x = karakter.getLokasyon().getX();
			y = karakter.getLokasyon().getY();
			switch (karakter.getAd()) {
			case "Gargamel":
				imageName = "gargamel";
				break;
			case "Azman":
				imageName = "azman";
				break;
			case "Gözlüklü Şirin":
				imageName = "gozlukluSirin";
				break;
			case "Tembel Şirin":
				imageName = "tembelSirin";
				break;
			}
			buttons[x][y].setText("");
			buttons[x][y].setIcon(getIconImage(imageName, 25, 25));

		}
	}

	private ImageIcon getIconImage(String imageName, int witdh, int height) {
		Image image;
		ImageIcon imageIcon = null;
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream("/resources/images/" + imageName + ".png"))
					.getScaledInstance(witdh, height, java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(image);
		} catch (IOException ex) {
			System.out.print(ex);
		}
		return imageIcon;
	}

	private String doorInfo(int i, int j) {
		if (i == 0 && j == 3) {
			return "A";
		} else if (i == 0 && j == 10) {
			return "B";
		} else if (i == 5 && j == 0) {
			return "C";
		} else if (i == 10 && j == 3) {
			return "D";
		} else if (i == 5 && j == 6) {
			return "S";
		} else {
			return "";
		}
	}

	private HaritaBilgi readFile(Oyuncu sirin, String filePath) {
		Dusman dusman;
		Lokasyon lokasyon = new Lokasyon(0, 0);
		int[][] harita = new int[sayiYukseklik][sayiGenislik];
		int dusmanSayi = 1, satirSayi = 0, dusmanId;
		String dusmanAd = "";
		ArrayList<Karakter> karakterler = new ArrayList<Karakter>();

		karakterler.add(sirin);
		// characters.add(new Player(smurf.getId(), smurf.getName(),
		// smurf.getPlayerType(), smurf.getScore(), new Location(5, 6)));
		try {
			Scanner scn = new Scanner(this.getClass().getResourceAsStream(filePath));
			String satir;
			while (scn.hasNextLine()) {
				satir = scn.nextLine();
				if (satir.startsWith("Karakter:")) {
					dusmanId = dusmanSayi++;
					for (var item : satir.split(",")) {
						item = item.substring(item.indexOf(":") + 1);
						if (item.length() > 1) {
							dusmanAd = item;
						} else {
							switch (item) {
							case "A":
								lokasyon = new Lokasyon(0, 3);
								break;
							case "B":
								lokasyon = new Lokasyon(0, 10);
								break;
							case "C":
								lokasyon = new Lokasyon(5, 0);
								break;
							case "D":
								lokasyon = new Lokasyon(10, 3);
								break;
							}
						}
					}
					if (dusmanAd.startsWith("Gargamel")) {
						dusman = new Gargamel(new DusmanDavranis(2,true),dusmanId, dusmanAd, lokasyon);
						karakterler.add(dusman);
					} else if (dusmanAd.startsWith("Azman")) {
						dusman = new Azman(new DusmanDavranis(1,false),dusmanId, dusmanAd, lokasyon);
						karakterler.add(dusman);
					}

				} else {
					int i = 0;
					for (var item : satir.split("	")) {
						harita[satirSayi][i] = Integer.parseInt(item);
						i++;
					}
					satirSayi++;
				}
			}
		} catch (Exception e) {
			System.err.println("Error:" + e);
		}
		return new HaritaBilgi(harita, karakterler);
	}

}
