package messstation;

/**
 * Checksum berechnet die Checksumme über einen String der aus Nullen und Einsen besteht.
 */
public class A3_Checksum {

	/**
	 * main( String[] args) ist die Hauptmethode und ruft calculateChecksum() auf.
     * 
	 * @param args String[]: wird nicht verwendet
	 */
    public static void main( String[] args ) {
        System.out.println(calculateChecksum("10010101011"));
    }

	/**
	 * calculateChecksum( String bin_input ) berechnet die Checksumme über einen String der aus Nullen und Einsen besteht.
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
            String in1 = bin_input.substring(0, 1);
            String in2;
            if (bin_input.length() == 1) { /* Löst den Fall, falls die Eingabe ein String der Länge eins ist */
                return bin_input;
            } else if (bin_input.length() == 2) {
                in2 = bin_input.substring(1, 2);
            } else {
                in2 = calculateChecksum(bin_input.substring(1));
            }
            return xor(in1, in2);
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
