import java.util.HashSet;

public class Player {
	private String name;
	private boolean male;
	private boolean madeFalseAccusation;
	private BoardSpace position;
	private HashSet<Card> cards;

	public Player(String aName, boolean aMale, BoardSpace aPosition) {
		this.name = aName;
		this.male = aMale;
		this.position = aPosition;
		this.madeFalseAccusation = false;
	}

	public boolean isMale() {
		return this.male;
	}

	public BoardSpace getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}
	
	public boolean madeFalseAccusation(){
		return this.madeFalseAccusation;
	}

	public void move(BoardSpace aPosition) {
	}

	public void assignCard(Card aCard) {
	}

	public boolean hasCard(Card aCard) {
		return this.cards.contains(aCard);
	}
}