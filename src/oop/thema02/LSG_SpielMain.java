package oop.thema02;

public class LSG_SpielMain {

	public static void main(String[] args) {		
		// Spiel initialisieren
		LSG_TicTacToe game = new LSG_TicTacToe();

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
