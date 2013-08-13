import java.awt.Image;

public class DisplayCard {
	private CardCategory category;
	private String name;
	private Image image;

	public DisplayCard(String aName, CardCategory aCategory) {
		this.name = aName;
		this.category = aCategory;
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

	public void draw() {
	}
}