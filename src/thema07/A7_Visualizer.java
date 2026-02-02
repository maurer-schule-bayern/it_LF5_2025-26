package thema07;

import java.util.Scanner;

public class A7_Visualizer {
    private static String[] Messgroessen = {"Niederschlag", "Temperatur", "rel. Feuchte", "Luftdruck", "Windgeschw.", "Taupunkt"};
	private static String[] Messeinheiten = {"mm", "°C", "%", "hPa", "km/h", "°C"};

	public static void main(String[] args) {
		
		String[] MessgroessenMitEinheiten = Messgroessen;
		for (int i = 0; i<MessgroessenMitEinheiten.length ; i++) {
			MessgroessenMitEinheiten[i] += " in "+ Messeinheiten[i];
		}
		
		String[] Messwerte = new String[util.MessstationDummy.getSENSOR_TYPES().length];
		for (int i = 0; i < Messwerte.length; i++) {
			Messwerte[i] = "   NaN"; // mit NaN initialisieren um ungültige Messwerte sichtbar zu machen
		}
		// Messwerte auslesen und einsortieren
		for (int i = 0; i < util.MessstationDummy.getSENSOR_TYPES().length; i++) {
			Messwertanalyse(Messwerte);
		}
		
		// Anzahl ungültiger Messungen ausgeben
		// System.out.println("Anzahl ungültiger Messungen: " + ungueltigeMessungenZaehlen(Messwerte));
		
		Scanner input = new Scanner(System.in);
		System.out.println("Möchten Sie eine Ausgabe mit Einheiten im Tabellenkopf? (Y = Ja; sonst Nein)");
		String Eingabe = input.nextLine();
		
		// Ausgabe Tabellenkopf
		if (Eingabe.equals("Y")) {
			for (String SensorType : MessgroessenMitEinheiten) {
				System.out.print(SensorType + "\t");
			}
		} else {
			for (String SensorType : Messgroessen) {
				System.out.print(SensorType + "\t");
			}
		}
		System.out.println(""); // neue Zeile
		// Ausgabe Messwerte
		if (Eingabe.equals("Y")) {
			for (int i = 0; i < Messwerte.length; i++) {
				System.out.print(Messwerte[i] + " \t\t\t");
			}
		} else {
			for (int i = 0; i < Messwerte.length; i++) {
				System.out.print(Messwerte[i] + " " + Messeinheiten[i] + " \t");
			}
		}
		System.out.println(""); // neue Zeile
	}
	
	public static String ungueltigeMessungenZaehlen(String[] Messwerte_in) {
		if (Messwerte_in[0].equals("   NaN")) {
			Messwerte_in[0] = "1";
		} else {
			Messwerte_in[0] = "0";
		}
		for (int i = 1; i < Messwerte_in.length; i++) {
			if (Messwerte_in[i].equals("   NaN")) {
				Messwerte_in[i] = "1";
			} else {
				Messwerte_in[i] = "0";
			}
			Messwerte_in[i] = util.StringOps.plus(Messwerte_in[i], Messwerte_in[i-1]); 
		}
		return Messwerte_in[Messwerte_in.length - 1];
	}
	
	public static boolean Fehlererkennung(String field_f) {
		// Fehlererkennung
		if (field_f.equals("1")) {
			//System.out.println("Fehler");
			return false;
		} else {
			//System.out.println("Funktionstüchtig");
			return true;
		}
	}
	
	public static void Messwertauflösung(String field_g, String field_w, String[] Messwerte) {
		// Messwertauflösung
		if (field_g.equals("TL")) {
			//System.out.println("Temperatur: " + field_w + "°C");
			Messwerte[1] = field_w;
		} else if (field_g.equals("TP")) {
			//System.out.println("Taupunkt: " + field_w + "°C");
			Messwerte[5] = field_w;
		} else if (field_g.equals("RF")) {
			//System.out.println("Relative Feuchte: " + field_w + "%");
			Messwerte[2] = field_w;
		} else if (field_g.equals("WG")) {
			//System.out.println("Windgeschwindigkeit: " + field_w + "km/h");
			Messwerte[4] = field_w;
		} else if (field_g.equals("LD")) {
			//System.out.println("Luftdruck: " + field_w + "hPa");
			Messwerte[3] = field_w;
		} else if (field_g.equals("NA")) {
			//System.out.println("Niederschlag: " + field_w + "mm");
			Messwerte[0] = field_w;
		} else {
			System.out.println("Größe nicht bekannt.");
		}
	}
	
	public static void Messwertanalyse(String[] Messwerte) {
		String messung = util.MessstationDummy.getMeasurementValue();
		String field_f = messung.substring(0, 1);
		String field_g = messung.substring(1, 3);
		String field_w = messung.substring(3, 9);
		String field_c = messung.substring(9, 10);
		
		if (Fehlererkennung(field_f) && messstation.Checksum.verifyChecksum(messung.substring(0,messung.length()-1), field_c)){ // in verifyChecksum wird das letzte Zeichen nicht übergeben
			Messwertauflösung(field_g, field_w, Messwerte);
		}
	}
}
