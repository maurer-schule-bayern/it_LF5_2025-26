package messstation;

/**
 * Checksum berechnet die Checksumme über einen String der aus Nullen und Einsen besteht.
 */
public class Checksum {

	/**
	 * main( String[] args) ist die Hauptmethode und ruft calculateChecksum() auf.
     * 
	 * @param args String[]: wird nicht verwendet
	 */
    public static void main( String[] args ) {
        System.out.println(calculateChecksum("10010101011"));
    }

	/**
	 * verifyChecksum( String inputString ) prüft ob die Quersumme des Eingabestrings inputString gleich der Checksumme ist
	 * @param inputString String: ein String mit belibiger Länge (ohne Checksum)
     * @param String Checksum: ein String der Länge eins
     * 
	 * @return boolean: gibt an ob die Prüfung erfolgreich war
	 */
    public static boolean verifyChecksum( String inputString, String checksum ){
        return calculateChecksum(binarizeString(inputString)).equals(checksum);
    }

	/**
	 * binarizeString( String inputString ) wandelt den Eingabe String in seine Binärrepräsentation um
	 * @param inputString String: ein String mit belibiger Länge
     * 
	 * @return String: gibt die Binärrepräsentation von inputString aus
	 */
    public static String binarizeString( String inputString ) {
        byte[] input_b = inputString.getBytes(); // wandle chars von String in UTF8-Werte (binär)
		String binary = "";
		for (int i=0; i<inputString.length(); i++) { // setzte die UTF8-Werte als einen langen String zusammen
			binary += String.format("%8s", Integer.toBinaryString(Byte.toUnsignedInt(input_b[i]))).replace(' ', '0');			
		}
        return binary;
    }

	/**
	 * calculateChecksum( String bin_input ) berechnet die Checksumme (even parity bit) über einen String der aus Nullen und Einsen besteht.
     * Es wird geprüft, dass der String bin_input nur aus Einsen und Nullen besteht und mindestens ein Element beinhaltet.<br>
     * 
	 * @param bin_input String: ein String mit belibiger Länge
     * 
	 * @return String: gibt die Checksumme aus
	 */
    public static String calculateChecksum( String bin_input ) {
        if (bin_input.isEmpty() || !validateString(bin_input)) { /* prüft ob die Checksumme des Strings berechnet werden kann */
            return "Diese Eingabe wird nicht unterstützt.";
        } else {
            String in1 = bin_input.substring(0, 1); // erste Stelle
            String in2;
            if (bin_input.length() == 1) { /* Löst den Fall, falls die Eingabe ein String der Länge eins ist */
                return bin_input;
            } else if (bin_input.length() == 2) { // Abbruchbedingung
                in2 = bin_input.substring(1, 2); // zweite Stelle
            } else {
                in2 = calculateChecksum(bin_input.substring(1)); // in2 wird rekursiv berechnet
            }
            return xor(in1, in2); // berechnet das even parity bit zweier 0/1 "chars" 
        }
    }

	/**
	 * xor( String in1, String in2 ) bildet das XOR-Logikgatter für Strings nach.
     * Es wird angenommen, dass nur Nullen und Einsen in die Methode übergeben wird. <br>
     * XOR gibt eins/true aus, wenn nur einer der Eingänge gleich eins/true ist (wenn sich die Eingänge unterscheiden).
     * 
	 * @param in1 String: ein String mit Länge eins (in.length() == 1)
	 * @param in2 String: ein String mit Länge eins (in.length() == 1)
     * 
	 * @return String: gibt "1" aus, wenn sich die Eingänge in1 und in2 unterscheiden; ansonsten "0"
	 */
    private static String xor( String in1, String in2 ) {
        if (in1.equals(in2)) { /* prüft die Gleichheit der Strings */
            return "0";
        } else {
            return "1";
        }
    }

	/**
	 * validateString( String in ) überprüft ob der String 'in' nur aus Einsen und Nullen besteht.
	 * 
	 * @param in String: String einer beliebigen Länge, der geprüft werden soll.
     * 
	 * @return boolean: gibt true aus, wenn nur Einsen und Nullen in 'in' vorkommen; ansonsten false
	 */
    private static boolean validateString( String in ) {
        return in.matches("^[01]*$"); /* Verwendung eines regulären Ausdrucks um den String auf Nullen und Einsen zu prüfen */
    }
}
