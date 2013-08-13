import java.util.HashSet;

public class UIMaster {
	private Client client;
	private GameWindow gameWindow;
	private static UIMaster instance = null;

	public static UIMaster getInstance() {
		if(instance == null){
			instance = new UIMaster();
		}
		return instance;
	}

	private UIMaster() {
	}

	public void translateMessage(String aMessage) {
	}

	public void notifyServerToMovePiece(DisplaySpace aSpace) {
	}

	public void makeSuggestionToServer(HashSet<DisplayCard> aCards) {
	}

	public void makeAccusationToServer(HashSet<DisplayCard> aCards) {
	}

	public void disproveAccusationToServer(DisplayCard aCard) {
	}

	public void cannotDisproveAccusationToServer() {
	}

	public void tellServerToStartGame() {
	}

	public void tellServerPieceChosen(DisplayPlayer aPlayer) {
	}
}