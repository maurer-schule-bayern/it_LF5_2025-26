package oop.thema04;

public class GameTester {
	// Attribute
	private Spiel game;
	
	// Konstruktor
	public GameTester(Spiel game) {
		this.game = game;
	}
	
	public void testing () {
		// Spielinformationen ausgeben
		game.gameInfo();
		
		// Spiel ausführen
		while (true) {
			if (game.step()) {
				break;
			}
		}
	}
}
