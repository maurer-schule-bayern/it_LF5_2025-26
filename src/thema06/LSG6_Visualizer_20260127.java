package thema06;

public class LSG6_Visualizer_20260127 {
    private static String[] Messgroessen = {"Niederschlag", "Temperatur", "rel. Feuchte", "Luftdruck", "Windgeschw.", "Taupunkt"};
	private static String[] Messeinheiten = {"mm", "°C", "%", "hPa", "km/h", "°C"};

	public static void main(String[] args) {
		double[][] Messwertspeicher = new double[100][util.MessstationDummy.getSENSOR_TYPES().length];
		// Messwerte einlesen
		for (int j = 0; j < Messwertspeicher.length; j++) {
			for (int i = 0; i < util.MessstationDummy.getSENSOR_TYPES().length; i++) {
				Messwertspeicher[j][i] = Double.NaN;
			}
			// Messwerte auslesen und einsortieren
			for (int i = 0; i < util.MessstationDummy.getSENSOR_TYPES().length; i++) {
				Messwertanalyse(Messwertspeicher[j]);
			}
		}
		// Ausgabe Kopf
		for (String SensorType : Messgroessen) {
			System.out.print(SensorType + "\t");
		}
		System.out.println(""); // neue Zeile
		// Ausgabe Messwerte
		for (int j = 0; j < Messwertspeicher.length; j++) {
			for (int i = 0; i < util.MessstationDummy.getSENSOR_TYPES().length; i++) {
				System.out.print(String.format("%6s", Messwertspeicher[j][i]) + " " + Messeinheiten[i] + " \t");
			}
			System.out.println(""); // neue Zeile
		}
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
	
	public static void Messwertauflösung(String field_g, double field_w, double[] Messwerte) {
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
	
	public static void Messwertanalyse(double[] Messwerte) {
		String messung = util.MessstationDummy.getMeasurementValue();
		String field_f = messung.substring(0, 1);
		String field_g = messung.substring(1, 3);
		double field_w = Double.parseDouble(messung.substring(3, 9).trim());
		String field_c = messung.substring(9, 10);
		
		if (Fehlererkennung(field_f) && messstation.Checksum.verifyChecksum(messung.substring(0,messung.length()-1), field_c)){ // in verifyChecksum wird das letzte Zeichen nicht übergeben
			Messwertauflösung(field_g, field_w, Messwerte);
		}
	}
}
