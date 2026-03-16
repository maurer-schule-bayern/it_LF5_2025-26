package oop.thema01.TicTacToeUtil;

import java.util.Scanner;

public class Hilfsfunktionen {
	public static int nutzereingabeLesen(Scanner input) {
		System.out.println("Wähle das Feld deines nächsten Zugs durch Auswahl der Feldnummer:");
		String eingabe;
		while (true) {
			eingabe = input.nextLine();
			// Prüfen ob die Eingabe aus nur einem Zeichen besteht und eine Ziffer zwischen 0 und 8 ist.
			if (eingabe.length() != 1 || eingabe.charAt(0) < '0' || eingabe.charAt(0) > '8') {
				System.out.println("Ungültige Eingabe. Es sind nur die Zahlen 0-8 erlaubt.");
				System.out.println("Neue Eingabe:");
			} else {
				System.out.println();
				break;
			}
		}
		return Character.getNumericValue(eingabe.charAt(0));
	}

	
	public static void spielfeldAnzeigen(char Feld0, char Feld1, char Feld2, char Feld3, char Feld4, char Feld5, char Feld6, char Feld7, char Feld8) {
		Feld0 = (Feld0 == '\u0000') ? ' ' : Feld0;
		Feld1 = (Feld1 == '\u0000') ? ' ' : Feld1;
		Feld2 = (Feld2 == '\u0000') ? ' ' : Feld2;
		Feld3 = (Feld3 == '\u0000') ? ' ' : Feld3;
		Feld4 = (Feld4 == '\u0000') ? ' ' : Feld4;
		Feld5 = (Feld5 == '\u0000') ? ' ' : Feld5;
		Feld6 = (Feld6 == '\u0000') ? ' ' : Feld6;
		Feld7 = (Feld7 == '\u0000') ? ' ' : Feld7;
		Feld8 = (Feld8 == '\u0000') ? ' ' : Feld8;
		System.out.println("Aktueller Spielstand:\t\tFeldnummern:");
		System.out.printf(" %C | %C | %C\t\t\t 0 | 1 | 2 \n", Feld0, Feld1, Feld2);
		System.out.println("---+---+---\t\t\t---+---+---");
		System.out.printf(" %C | %C | %C\t\t\t 3 | 4 | 5 \n", Feld3, Feld4, Feld5);
		System.out.println("---+---+---\t\t\t---+---+---");
		System.out.printf(" %C | %C | %C\t\t\t 6 | 7 | 8 \n", Feld6, Feld7, Feld8);
	}
	// TODO: Support also String, Array, noArgument
	// TODO: beautify code, by using constants


	public static void konsoleLeeren(boolean Eclipse) {
			if (Eclipse) {
				for (int i = 0; i < 25; i++) {
					System.out.println("\n");
				}
			} else {
				System.out.print("\033[H\033[2J");
			}
	}   
}
