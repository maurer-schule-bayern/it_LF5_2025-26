package oop.thema06;

abstract public class Person {
	protected int alter;
	protected String vorname;
	protected String nachname;
	
	public Person(int alter, String vorname, String nachname) {
		this.alter = alter;
		this.vorname = vorname;
		this.nachname = nachname;
	}
		
	abstract public void printInformation();
	
}