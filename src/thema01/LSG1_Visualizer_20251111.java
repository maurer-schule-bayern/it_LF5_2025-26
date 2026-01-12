package thema01;

public class LSG1_Visualizer_20251111 {

	public static void main(String[] args) {
		String messung = util.MessstationDummy.getMeasurementValue();
		String field_f = messung.substring(0, 1);
		String field_g = messung.substring(1, 3);
		double field_w = Double.parseDouble(messung.substring(3, 9).trim());
		String field_c = messung.substring(9, 10);

		// Teil I
		if (field_f.equals("1")) {
			System.out.println("Fehler");
		} else {
			System.out.println("Funktionstüchtig");
		}

		// Teil II - Eichel
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

		// Teil II - Herz
		switch (field_g) {
			case "TL":
				System.out.println("Temperatur: " + field_w + "°C");
				break;
			case "TP":
				System.out.println("Taupunkt: " + field_w + "°C");
				break;
			case "RF":
				System.out.println("Relative Feuchte: " + field_w + "%");
				break;
			case "WG":
				System.out.println("Windgeschwindigkeit: " + field_w + "km/h");
				break;
			case "LD":
				System.out.println("Luftdruck: " + field_w + "hPa");
				break;
			case "NA":
				System.out.println("Niederschlag: " + field_w + "mm");
				break;
			default:
				System.out.println("Größe nicht bekannt.");
				break;
		}
	}
}
