package thema05;
 
public class A5_1_Visualizer {	
 
	public static void main(String[] args) {
		// Messwerte auslesen
		String[] Messwerte = new String[6];
		for (int i = 0; i < util.MessstationDummy.getSENSOR_TYPES().length; i++) {
			Messwertanalyse(Messwerte);
		}
		System.out.println(Messwerte[0]);
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
	
	public static void Messwertauflösung(String field_g, double field_w, String[] Messwerte) {
		// Messwertauflösung
		if (field_g.equals("TL")) {
			Messwerte[1] = "Temperatur: " + field_w + "°C";
		} else if (field_g.equals("TP")) {
			Messwerte[5] = "Taupunkt: " + field_w + "°C";
		} else if (field_g.equals("RF")) {
			Messwerte[2] = "Relative Feuchte: " + field_w + "%";
		} else if (field_g.equals("WG")) {
			Messwerte[4] = "Windgeschwindigkeit: " + field_w + "km/h";
		} else if (field_g.equals("LD")) {
			Messwerte[3] = "Luftdruck: " + field_w + "hPa";
		} else if (field_g.equals("NA")) {
			Messwerte[0] = "Niederschlag: " + field_w + "mm";
		} else {
			System.out.println("Größe nicht bekannt.");
		}
	}
	
	public static void Messwertanalyse(String[] Messwerte) {
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