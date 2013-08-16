package oblivioussolutions.game;
import java.util.HashSet;

public abstract class BoardSpace {
	protected HashSet<BoardSpace> neighbors;
	protected HashSet<Player> players;
	protected String name;

	public static HashSet<BoardSpace> createSpaces() {
		HashSet<BoardSpace> spaces = new HashSet<BoardSpace>();
		spaces.addAll(Room.createRooms());
		spaces.addAll(Hallway.createHallways());
		return spaces;
	}

	private static void setNeighbors(BoardSpace aSpace1, BoardSpace aSpace2) {
	}

	public boolean hasNeighbor(BoardSpace aSpace) {
		return neighbors.contains(aSpace);
	}

	public void movePlayerHere(Player aPlayer) {
	}

	public abstract boolean isRoom();

	public abstract boolean canMovePlayerHere(Player aPlayer);
}