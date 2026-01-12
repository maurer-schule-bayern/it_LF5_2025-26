package thema01;

public class A1_Visualizer {

	public static void main(String[] args) {
		// Messwert abrufen
		String messung = util.MessstationDummy.getMeasurementValue();
		// Felder F, GG, WWWWWW, C auflösen
		String field_f = messung.substring(0, 1);
		String field_g = messung.substring(1, 3);
		double field_w = Double.parseDouble(messung.substring(3, 9).trim());
		String field_c = messung.substring(9, 10);
		// Extend here
	}
}
