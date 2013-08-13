public class Accusation {
	private Card room;
	private Card weapon;
	private Card suspect;

	public Accusation(String aRoom, String aWeapon, String aSuspect) {
		this.room = new Card(aRoom, CardCategory.ROOM);
		this.weapon = new Card(aWeapon, CardCategory.WEAPON);
		this.suspect = new Card(aSuspect, CardCategory.SUSPECT);
	}

	public Card getWeapon() {
		return this.weapon;
	}

	public Card getSuspect() {
		return this.suspect;
	}

	public Card getRoom() {
		return this.room;
	}
}