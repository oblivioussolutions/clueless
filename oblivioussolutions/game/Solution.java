package oblivioussolutions.game;
public class Solution {
	private Card room;
	private Card weapon;
	private Card suspect;

	public Solution(Card aRoom, Card aWeapon, Card aSuspect) {
		this.room = aRoom;
		this.weapon = aWeapon;
		this.suspect = aSuspect;
	}

	public boolean validateAccusation(Accusation aAccusation) {
		boolean correctRoom = aAccusation.getRoom() == this.room;
		boolean correctWeapon = aAccusation.getWeapon() == this.weapon;
		boolean correctSuspect = aAccusation.getSuspect() == this.suspect;
		return correctRoom && correctWeapon && correctSuspect;
	}
}