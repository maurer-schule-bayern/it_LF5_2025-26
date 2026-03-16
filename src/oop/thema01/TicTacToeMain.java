package oop.thema01;

import java.util.Scanner;

/* ==================================================================================
TicTacToe ohne Überprüfung der Gewinnbedingungen
-------------------------------------------------------------------------------------
In dieser sehr einfachen Version von TicTacToe müssen die Spielenden selbst überprüfen 
ob jemand gewonnen hat und das Spiel bei Bedarf mit Cmd + C / Strg + C / Terminate in 
der IDE abbrechen.
*/ 
public class TicTacToeMain {
	public static void main(String[] args) {
		int player = 0;		    // Player kann 0 oder 1 sein - es startet Player 0
		int anzahlFelder = 9;   // das Spiel besteht aus 9 Feldern
		
		
		// TODO: Spielfeld mit 9 Feldern deklarieren, konstruieren (und initialisieren)
		

		Scanner input = new Scanner(System.in); // Scanner um Nutzereingaben einzulesen

		// Es sind max. 9 Züge möglich, da 9 Felder
		for (int besetzteFelder = 0; besetzteFelder < anzahlFelder; besetzteFelder++) {

			// ==================================================================================
			// Anweisungen anzeigen
			// ----------------------------------------------------------------------------------
			System.out.println("Am Zug ist Player: " + player);
			// TODO: aktuelles Spielfeld anzeigen indem ' ' ersetzt wird
			oop.thema01.TicTacToeUtil.Hilfsfunktionen.spielfeldAnzeigen(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ');

			
			// ==================================================================================
			// Zug eines Players durchführen
			// ----------------------------------------------------------------------------------
			while (true) {   // solange kein gültiger Zug durchgeführt wurde, kommt die Aufforderung zur Wiederholung
				int eingabe = oop.thema01.TicTacToeUtil.Hilfsfunktionen.nutzereingabeLesen(input);
				/*
				TODO: Logik zum Setzen eines Feldes einfügen: 
					- Variable eingabe (int zwischen 0 und 8) nutzen
					- Falls Zug erlaubt war, muss zugBeendet auf true gesetzt werden (ansonsten auf false): zugBeendet = ...
				*/
				boolean zugBeendet = true; // TODO: ersetzen

				if (zugBeendet) {
					break;  // Zug beenden
				} else {
					System.out.println("Zug ungültig. Nochmals versuchen.");
				}
			}

			// ==================================================================================
			// Player wechseln
			// ----------------------------------------------------------------------------------
			player = (player + 1) % 2;
		}
		
		// ==================================================================================
		// Endstand ausgeben
		// ----------------------------------------------------------------------------------
		System.out.println("Die maximale Anzahl an Zügen wurde gespielt. Der Endstand lautet:");
		// TODO: aktuelles Spielfeld anzeigen indem ' ' ersetzt wird
		oop.thema01.TicTacToeUtil.Hilfsfunktionen.spielfeldAnzeigen(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ');
	} 
}
