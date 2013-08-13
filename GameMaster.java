import java.util.HashMap;

public class GameMaster {
	private Server server;
	private GameBoard board;
	private HashMap<Player, Socket> playersToClients;
	private static GameMaster instance = null;

	public static GameMaster getInstance() {
		if(instance == null){
			instance = new GameMaster();
		}
		return instance;
	}

	private GameMaster() {
		//setup game - create spaces, cards, etc
	}

	public void translateMessage(String aMessage) {
	}

	public void notifyPlayersOfTurnChange() {
	}

	public void askPlayerForSuggestion(Player aPlayer, Suggestion aSuggestion) {
	}

	public void notifyPlayerOfInvalidMove(Player aPlayer) {
	}

	public void notifyPlayerOfDisprovedSuggestion(Player aCurrentPlayer, Player aAskedPlayer) {
	}

	public void notifyPlayerOfInvalidDisprovedSuggestion(Player aPlayer) {
	}

	public void notifyPlayerSuggestionWasNotDisproved(Player aCurrentPlayer, Player aAskedPlayer) {
	}

	public void notifyPlayersOfNewPlayer() {
	}

	public void notifyPlayersOfGameStart() {
	}

	private void notifyPlayerOfInvalidOperation(Client aClient) {
	}
}