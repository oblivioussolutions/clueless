import java.util.HashSet;

public class GameWindow {
	private UIMaster uiMaster;
	private DisplayBoard board;
	private ConfidentialFolder confidentialFolder;
	private MessagesFromServerBox messagesFromServer;
	private DetectiveNotebook detectiveNotebook;
	private CardsInHand cards;
	private static GameWindow instance = null;

	public static GameWindow getInstance() {
		if(instance == null){
			instance = new GameWindow();
		}
		return instance;
	}

	private GameWindow() {
	}

	public void movePlayerOnBoard(String aPlayer, String aSpace) {
	}

	public void disproveSuggestion(HashSet<DisplayCard> aCards) {
	}

	public void makeSuggestion() {
	}

	public void suggestionDisproved(DisplayCard aCard) {
	}

	public void suggestionNotDisproved() {
	}

	public void anotherPlayersSuggestionDisproved(DisplayCard aCard) {
	}

	public void anotherPlayersSuggestionNotDisproved() {
	}

	public void makeAccusation() {
	}

	public void successfulAccusation() {
	}

	public void failedAccusation(HashSet<DisplayCard> aResults) {
	}

	private void setupWindow() {
	}

	private void startGameSetup(HashSet<DisplayCard> aCards) {
	}

	private String weaponPopup() {
		return "";
	}

	private String roomPopup() {
		return "";
	}

	private String suspectPopup() {
		return "";
	}
}