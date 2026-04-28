package oop.thema04;

abstract public class LSG_Spiel {
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
	
	abstract public boolean step();
}
