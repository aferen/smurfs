import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Tile {
	
    private Location location;
    
    private Color color;
    
    private int width;
    
    private int height;
        
	public Tile(Location location, Color color, int width, int height) {
		super();
		this.location = location;
		this.color = color;
		this.width = width;
		this.height = height;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
    

    
    
}

@SuppressWarnings("serial")
class TilePane extends JPanel {
    private int numberOfTiles;
    
    private ArrayList<Tile> tiles;

    private MapInfo mapInfo;
    
    public TilePane(MapInfo mapInfo) {
        int width = 40;
        int height = 35;
        Color color;
    	this.mapInfo = mapInfo;
        this.numberOfTiles = this.mapInfo.getMap().length*this.mapInfo.getMap()[0].length;
        
        tiles = new ArrayList<Tile>();
        
		for (int i = 0; i < this.mapInfo.getMap().length; i++) {
			for (int j = 0; j < this.mapInfo.getMap()[0].length; j++) {				
				Location location = new Location(j*width,i*height);
	            if(this.mapInfo.getMap()[i][j] == 0) {
	            	color = Color.GRAY;
	            } else if (isDoor(i,j) != "") {
	            	color = Color.RED;
	            }else {
	            	color = Color.WHITE;
	            }
	            tiles.add(new Tile(location, color, width, height)); 
			}
		}
    }
    
    private String isDoor(int i, int j) {
    	if (i == 0 && j == 3) {
    		return "A";
    	} else if (i == 0 && j == 10) {
    		return "B";
    	} else if (i == 5 && j == 0) {
    		return "C";
    	} else if (i == 10 && j == 3) {
    		return "D";
    	} else {
    		return "";
    	}
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
      
        
        for (int i = 0; i < numberOfTiles; i++) {
            g2d.setColor(tiles.get(i).getColor());
        	g2d.fillRect(tiles.get(i).getLocation().getX(), tiles.get(i).getLocation().getY(), tiles.get(i).getWidth(), tiles.get(i).getHeight()); 
        	g.setColor(Color.BLACK);
            g.drawRect(tiles.get(i).getLocation().getX(), tiles.get(i).getLocation().getY(), tiles.get(i).getWidth(), tiles.get(i).getHeight()); 
        }
    }
    
    @Override
    public Dimension getPreferredSize() { 
        return new Dimension(500, 500);
    }
}
