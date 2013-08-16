package oblivioussolutions.game;
import java.util.HashSet;

public class Room extends BoardSpace {

	public Room(String aName) {
		this.name = aName;
	}

	public static HashSet<BoardSpace> createRooms() {
		return null;
	}

	public boolean isRoom() {
		return true;
	}

	public boolean canMovePlayerHere(Player aPlayer) {
		return false;
	}
}