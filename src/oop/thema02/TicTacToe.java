package oop.thema02;

public class TicTacToe {
	// Attribute
	private String name = "TicTacToe";
	private String rules = "Es wird abwechselnd gespielt.\n"
			+ "\t\tEs darf immer ein Zeichen auf ein freies Feld gesetzt werden.\n"
			+ "\t\tWer zuererst eine ganze Reihe / Spalte / Diagonale mit seinem Symbol befüllt hat, gewinnt.";
	private int amountPlayers = 2;
	
	// Konstruktor
	public TicTacToe() {
		//TODO: Konstruktor
	}
	
	// Methode zum Ausführen eines Zugs
	public boolean step() {
		//TODO: Spiel schreiben
		return true;
	}

	// Game Information
	public void gameInfo() {
		System.out.println("Name:\t\t" + name);
		System.out.println("Anzahl Spieler:\t" + amountPlayers);
		System.out.println("Regeln:\t\t" + rules);
	}
}
