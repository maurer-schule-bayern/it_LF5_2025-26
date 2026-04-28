package oop.thema04;

public class LSG_GameTester {
	// Attribute
	private LSG_Spiel game;
	
	// Konstruktor
	public LSG_GameTester(LSG_Spiel game) {
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
