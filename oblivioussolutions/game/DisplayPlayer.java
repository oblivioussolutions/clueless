package oblivioussolutions.game;
import java.awt.Image;

public class DisplayPlayer {
	private String name;
	private Image image;

	public DisplayPlayer(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}
}