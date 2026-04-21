package oop.thema04;

public class Spiel {
	// Attribute
	protected String name;
	protected String rules;
	protected int amountPlayers;
	
	// Game Information
	public void gameInfo() {
		System.out.println("Name:\t\t" + name);
		System.out.println("Anzahl Spieler:\t" + amountPlayers);
		System.out.println("Regeln:\t\t" + rules);
	}
}
