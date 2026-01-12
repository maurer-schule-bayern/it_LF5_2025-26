package thema04;

public class LSG4_Visualizer_20251209 {

	public static void main(String[] args) {
		// Gruppe 1
		for (int i = 0; i < util.MessstationDummy.getSENSOR_TYPES().length; i++) {
			Messwertanalyse();
		}
		// Gruppe 2
		int i = 0;
		while (i < util.MessstationDummy.getSENSOR_TYPES().length) {
			Messwertanalyse();
			i++;
		}
		// Gruppe 3
		int j = 0;
		do {
			Messwertanalyse();
			j++;
		} while (j < util.MessstationDummy.getSENSOR_TYPES().length);
	}
	
	public static boolean Fehlererkennung(String field_f) {
		// Fehlererkennung
		if (field_f.equals("1")) {
			System.out.println("Fehler");
			return false;
		} else {
			System.out.println("Funktionstüchtig");
			return true;
		}
	}
	
	public static void Messwertauflösung(String field_g, double field_w) {
		// Messwertauflösung
		if (field_g.equals("TL")) {
			System.out.println("Temperatur: " + field_w + "°C");
		} else if (field_g.equals("TP")) {
			System.out.println("Taupunkt: " + field_w + "°C");
		} else if (field_g.equals("RF")) {
			System.out.println("Relative Feuchte: " + field_w + "%");
		} else if (field_g.equals("WG")) {
			System.out.println("Windgeschwindigkeit: " + field_w + "km/h");
		} else if (field_g.equals("LD")) {
			System.out.println("Luftdruck: " + field_w + "hPa");
		} else if (field_g.equals("NA")) {
			System.out.println("Niederschlag: " + field_w + "mm");
		} else {
			System.out.println("Größe nicht bekannt.");
		}
	}
	
	public static void Messwertanalyse() {
		String messung = util.MessstationDummy.getMeasurementValue();
		String field_f = messung.substring(0, 1);
		String field_g = messung.substring(1, 3);
		double field_w = Double.parseDouble(messung.substring(3, 9).trim());
		String field_c = messung.substring(9, 10);
		
		if (Fehlererkennung(field_f) && messstation.Checksum.verifyChecksum(messung.substring(0,messung.length()-1), field_c)){ // in verifyChecksum wird das letzte Zeichen nicht übergeben
			Messwertauflösung(field_g, field_w);
		}
				
	}
}
