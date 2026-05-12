package oop.thema06;

public class Lehrkraft extends Person {

	private String[] unterrichtsfaecher;

	public Lehrkraft() {
		// TODO 
	}

	@Override
	public void printInformation() {
		System.out.println("Name: " + vorname + " " + nachname);
		System.out.println("Alter: " + alter);
		System.out.print("Unterrichtsfaecher: ");
		printUnterrichtsfacher();
	}

	private void printUnterrichtsfacher() {
		for (String fach : unterrichtsfaecher) {
			System.out.print(fach + " ");
		}
	}

}
