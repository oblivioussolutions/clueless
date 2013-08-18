import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class CluelessBoard implements Serializable, Cloneable {
    //private ArrayList<Player> players;

    public static Player player1;
    public static Player player2;
    public static Player player3;
    public static Player player4;
    public static Player player5;
    public static Player player6;
    private HashSet<BoardSpace> spaces;
    private Solution solution;
    private int currentPlayerIndex;
    private GameMaster gameMaster;
    private static CluelessBoard instance = null;
    private int turn = 1;
    private Solution gameSolution;
    private Accusation anAccusation;
    public static String NoWinner = "No Winner";
    
    public static CluelessBoard getInstance() {
        if (instance == null) {
            instance = new CluelessBoard();
        }
        return instance;
    }

    public CluelessBoard clone() {
        CluelessBoard clonedBoard = new CluelessBoard();
        /* Todo: clone the board
         * 
         */
        return clonedBoard;
    }

    public void resetBoard() {
        turn = 1;
        /**
         * Todo: reset the board
         */
    }

    CluelessBoard() {
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
    	turn = (turn + 1) % 6;
    }

    public int getTurn() {
    	return turn % 6;
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

    public String getWinner() {
        if (testWinner(player1)) {
            return player1.getName();
        } else if (testWinner(player2)) {
            return player2.getName();
        } else if (testWinner(player3)) {
            return player3.getName();
        } else if (testWinner(player4)) {
            return player4.getName();
        } else if (testWinner(player5)) {
            return player5.getName();
        } else if (testWinner(player6)) {
            return player6.getName();
        } else {
            return "No Winner";
        }
    }

    public boolean testWinner(Player aPlayer) {
        if (gameSolution.getRoomCard().getDescription().equals(anAccusation.getRoom())
            && gameSolution.getSuspect().getDescription().equals(anAccusation.getSuspect())
            && gameSolution.getWeaponCard().getDescription().equals(anAccusation.getWeapon()))
            return true;
        else
            return false;
    }
    
	public boolean isLegalMove(/* need some parameters */) {
		// do something to test
		return false;
	}
}
