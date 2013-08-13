import java.util.HashSet;

public class Card {
	private CardCategory category;
	private String name;

	public Card(String aName, CardCategory aCategory) {
		this.name = aName;
		this.category = aCategory;
	}

	public static HashSet<Card> createDeck() {
		return new HashSet<Card>();
	}

	public boolean isWeapon() {
		return this.category == CardCategory.WEAPON;
	}

	public boolean isSuspect() {
		return this.category == CardCategory.SUSPECT;
	}

	public boolean isRoom() {
		return this.category == CardCategory.ROOM;
	}
}