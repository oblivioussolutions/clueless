import java.util.HashSet;

public class Hallway extends BoardSpace {

	public static HashSet<BoardSpace> createHallways() {
		return null;
	}

	public boolean isRoom() {
		return false;
	}

	public boolean canMovePlayerHere(Player aPlayer) {
		return false;
	}
}