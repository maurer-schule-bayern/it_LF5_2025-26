package oop.thema03;

public class SpielMain {

	public static void main(String[] args) {		
		// Spiel initialisieren
		TicTacToe game = new TicTacToe();

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
