package oblivioussolutions.game;
import java.awt.Image;
import java.util.HashSet;

public class DisplaySpace {
	private HashSet<DisplayPlayer> players;
	private Image background;
	private String name;

	public void addPlayer(DisplayPlayer aPlayer) {
		//add player to space;
		this.draw();
	}

	public void removePlayer(DisplayPlayer aPlayer) {
		//remove player from space;
		this.draw();
	}
	
	private void draw(){
		
	}
}