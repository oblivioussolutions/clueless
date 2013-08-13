import java.util.ArrayList;
import java.util.HashSet;

public class GameBoard {
	private ArrayList<Player> players;
	private HashSet<BoardSpace> spaces;
	private Solution solution;
	private int currentPlayerIndex;
	private GameMaster gameMaster;
	private static GameBoard instance = null;

	public static GameBoard getInstance() {
		if(instance == null){
			instance = new GameBoard();
		}
		return instance;
	}

	private GameBoard() {
	}
	
	public boolean addPlayer(String aPlayer) {
		return false;
	}

	public void movePlayer(String aPlayer, String aSpace) {
	}

	public void makeSuggestion(String aPlayer, Suggestion aSuggestion) {
	}

	public void makeAccusation(String aPlayer, Accusation aAccusation) {
	}

	public void nextTurn() {
	}

	private void setupBoard() {
	}

	private Player getPlayerFromName(String aName) {
		return null;
	}

	private Card getCardFromName(String aName) {
		return null;
	}

	private BoardSpace getSpaceFromName(String aName) {
		return null;
	}
}