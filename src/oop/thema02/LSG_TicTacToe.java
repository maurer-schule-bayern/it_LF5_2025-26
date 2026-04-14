package oop.thema02;

import java.util.Scanner;

import oop.thema01.LSG_Spielfeld;

public class LSG_TicTacToe extends LSG_Spiel {
	
	// Attribute
	private int player;		   	// Player kann 0 oder 1 sein - es startet Player 0
	private int anzahlFelder;  	// das Spiel besteht aus 9 Feldern
	
	private LSG_Spielfeld spielfeld;
	private int besetzteFelder;

	private Scanner input; 		// Scanner um Nutzereingaben einzulesen
	
	// Konstruktor
	public LSG_TicTacToe() {
		name = "TicTacToe";
		rules = "Es wird abwechselnd gespielt.\n"
				+ "\t\tEs darf immer ein Zeichen auf ein freies Feld gesetzt werden.\n"
				+ "\t\tWer zuererst eine ganze Reihe / Spalte / Diagonale mit seinem Symbol befüllt hat, gewinnt.";
		amountPlayers = 2;
		//
		player = 0;
		anzahlFelder = 9;		
		spielfeld = new LSG_Spielfeld();
		besetzteFelder = 0;
		input = new Scanner(System.in);
	}
	
	// Methode zum Ausführen eines Zugs
	public boolean step() {
		// ==================================================================================
		// Anweisungen anzeigen
		// ----------------------------------------------------------------------------------
		System.out.println("Am Zug ist Player: " + player);
		oop.thema01.TicTacToeUtil.Hilfsfunktionen.spielfeldAnzeigen(spielfeld.getFeld(0), spielfeld.getFeld(1), spielfeld.getFeld(2), spielfeld.getFeld(3), spielfeld.getFeld(4), spielfeld.getFeld(5), spielfeld.getFeld(6), spielfeld.getFeld(7), spielfeld.getFeld(8));

		
		// ==================================================================================
		// Zug eines Players durchführen
		// ----------------------------------------------------------------------------------
		while (true) {   // solange kein gültiger Zug durchgeführt wurde, kommt die Aufforderung zur Wiederholung
			int eingabe = oop.thema01.TicTacToeUtil.Hilfsfunktionen.nutzereingabeLesen(input);
			
			boolean zugBeendet = spielfeld.setzen(eingabe, player);

			if (zugBeendet) {
				break;  // Zug beenden
			} else {
				System.out.println("Zug ungültig. Nochmals versuchen.");
			}
		}

		// ==================================================================================
		// Kontrolllogik
		// ----------------------------------------------------------------------------------
		besetzteFelder++;

		if (besetzteFelder == anzahlFelder) {
			// ==================================================================================
			// Endstand ausgeben
			// ----------------------------------------------------------------------------------
			System.out.println("Die maximale Anzahl an Zügen wurde gespielt. Der Endstand lautet:");
			oop.thema01.TicTacToeUtil.Hilfsfunktionen.spielfeldAnzeigen(spielfeld.getFeld(0), spielfeld.getFeld(1), spielfeld.getFeld(2), spielfeld.getFeld(3), spielfeld.getFeld(4), spielfeld.getFeld(5), spielfeld.getFeld(6), spielfeld.getFeld(7), spielfeld.getFeld(8));
			return true;
		} else {
			player = (player + 1) % 2;
			return false;
		}
	}
}
