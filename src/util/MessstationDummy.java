package util;

import java.util.Arrays;

/**
* @brief Ein Digital-Twin einer Messstation
* 
* @class MessstationDummy
*
* Diese Klasse dient als Digital-Twin unserer Messtation 
* um die Datenanalyse auch ohne Zugriff auf die echte Station zu testen.
*/
public class MessstationDummy {

	/**
	* gemessene Größen: Lufttemperatur in °C, Taupunkt in °C, Relative Feuchte in %, Windgeschwindigkeit in km/h, Luftdruck in hPa, Niederschlag aktuell in mm
	*/
	private static final String[] SENSOR_TYPES= {"TL", "TP", "RF", "WG", "LD", "NA"}; 	// Lufttemperatur, Taupunkt, Relative Feuchte, Windgeschwindigkeit, Luftdruck, Niederschlag aktuell
																						// TODO: Get from here: https://www.meteo.physik.uni-muenchen.de/mesomikro/stadt/messung.php
	private static final int SENSOR_COUNT = SENSOR_TYPES.length;
		// Decide on initial SensorType
		private static int type_i = (int) Math.floor(Math.random() * SENSOR_COUNT);
	private static final double ERROR_RATE = 0.1;
	/**
	* Länge der Messwerte: 6	* 
	*/
	private static final int MEA_LENGTH = 6;
	
	/**
	 * Default von getMeasurementValue() <br>
	 * getMeasurementValue() ist mehrfach überladen um seine Verwendung zu vereinfachen. <br>
	 * Diese Version generiert zufällige Messwerte für die verschiedenen Größen. 
	 * Die erste ausgegebene Größe wird zufällig bestimmt, alle weiteren folgen der Sortierung in SENSOR_TYPES.<br>
	 * Die Ausgabe der Funktionstüchtigkeit der Messstation gibt zu 90% funktionstüchtig und zu 10% fehlerhaft aus. <br>
	 * Die Checksumme ist immer korrekt.
	 * 
	 * @return String mit FGGWWWWWWC <br>
	 * F = Funktionsfähigkeit (1 = fehlerhaft, 0 = fehlerfrei)<br>
	 * G = Größe (siehe SENSOR_TYPES) <br>
	 * W = Messwert der Länge MEA_LENGTH <br>
	 * C = Checksumme = Paritybit der Quersumme der ASCI-Repräsentation von FGW 
	 */
	public static String getMeasurementValue() {
		return getMeasurementValue(false, "X", "X", 'f');
	}
	/**
	 * getMeasurementValue() ist mehrfach überladen um seine Verwendung zu vereinfachen. <br>
	 * Diese Version generiert zufällige Messwerte für die verschiedenen Größen. 
	 * Die erste ausgegebene Größe wird zufällig bestimmt, alle weiteren folgen der Sortierung in SENSOR_TYPES.<br>
	 * Die Ausgabe der Funktionstüchtigkeit kann manuell auf fehlerhaft gesetzt werden. <br>
	 * Die Checksumme ist immer korrekt.
	 * 
	 * @return String mit FGGWWWWWWC <br>
	 * F = Funktionsfähigkeit (1 = fehlerhaft, 0 = fehlerfrei)<br>
	 * G = Größe (siehe SENSOR_TYPES) <br>
	 * W = Messwert der Länge MEA_LENGTH <br>
	 * C = Checksumme = Paritybit der Quersumme der ASCI-Repräsentation von FGW 
	 * 
	 * @param error_f boolean: true erzwingt F = 1 sonst random
	 */
	public static String getMeasurementValue(boolean error_f) {
		return getMeasurementValue(error_f, "X", "X", 'f');
	}
	/**
	 * getMeasurementValue() ist mehrfach überladen um seine Verwendung zu vereinfachen. <br>
	 * Diese Version generiert zufällige Messwerte für die verschiedenen Größen. 
	 * Die erste ausgegebene Größe wird zufällig bestimmt, alle weiteren folgen der Sortierung in SENSOR_TYPES.<br>
	 * Die Ausgabe der Funktionstüchtigkeit der Messstation gibt zu 90% funktionstüchtig und zu 10% fehlerhaft aus. <br>
	 * Die Checksumme kann manuell korruptiert werden.
	 * 
	 * @return String mit FGGWWWWWWC <br>
	 * F = Funktionsfähigkeit (1 = fehlerhaft, 0 = fehlerfrei)<br>
	 * G = Größe (siehe SENSOR_TYPES) <br>
	 * W = Messwert der Länge MEA_LENGTH <br>
	 * C = Checksumme = Paritybit der Quersumme der ASCI-Repräsentation von FGW 
	 * 
	 * @param cs_f char: 'f' erzwingt eine fehlerhafte Checksumme
	 */
	public static String getMeasurementValue(char cs_f) {
		return getMeasurementValue(false, "X", "X", cs_f);
	}
	/**
	 * getMeasurementValue() ist mehrfach überladen um seine Verwendung zu vereinfachen. <br>
	 * Diese Version erlaubt es die ausgegebene Größe und den Messwert manuell festzulegen.<br>
	 * Die Ausgabe der Funktionstüchtigkeit der Messstation gibt zu 90% funktionstüchtig und zu 10% fehlerhaft aus. <br>
	 * Die Checksumme ist immer korrekt.
	 * 
	 * @return String mit FGGWWWWWWC <br>
	 * F = Funktionsfähigkeit (1 = fehlerhaft, 0 = fehlerfrei)<br>
	 * G = Größe (siehe SENSOR_TYPES) <br>
	 * W = Messwert der Länge MEA_LENGTH <br>
	 * C = Checksumme = Paritybit der Quersumme der ASCI-Repräsentation von FGW 
	 * 
	 * @param type_f String: legt die Messgröße fest. Muss aus SENSOR_TYPES sein.
	 * @param value_f String: legt den Messwert fest. Muss MEA_LENGTH lang sein.
	 */
	public static String getMeasurementValue(String type_f, String value_f) {
		return getMeasurementValue(false, type_f, value_f, 'f');
	}
	/**
	 * getMeasurementValue() ist mehrfach überladen um seine Verwendung zu vereinfachen. <br>
	 * Diese Version erlaubt es die ausgegebene Größe manuell festzulegen.<br>
	 * Die Ausgabe der Funktionstüchtigkeit der Messstation gibt zu 90% funktionstüchtig und zu 10% fehlerhaft aus. <br>
	 * Die Checksumme ist immer korrekt.
	 * 
	 * @return String mit FGGWWWWWWC <br>
	 * F = Funktionsfähigkeit (1 = fehlerhaft, 0 = fehlerfrei)<br>
	 * G = Größe (siehe SENSOR_TYPES) <br>
	 * W = Messwert der Länge MEA_LENGTH <br>
	 * C = Checksumme = Paritybit der Quersumme der ASCI-Repräsentation von FGW 
	 * 
	 * @param type_f String: legt die Messgröße fest. Muss aus SENSOR_TYPES sein.
	 */
	public static String getMeasurementValue(String type_f) {
		return getMeasurementValue(false, type_f, "X", 'f');
	}
	/**
	 * getMeasurementValue() ist mehrfach überladen um seine Verwendung zu vereinfachen. <br>
	 * Diese Version erlaubt es die ausgegebene Größe und den Messwert manuell festzulegen.<br>
	 * Die Ausgabe der Funktionstüchtigkeit kann manuell auf fehlerhaft gesetzt werden.<br>
	 * Die Checksumme ist immer korrekt.
	 * 
	 * @return String mit FGGWWWWWWC <br>
	 * F = Funktionsfähigkeit (1 = fehlerhaft, 0 = fehlerfrei)<br>
	 * G = Größe (siehe SENSOR_TYPES) <br>
	 * W = Messwert der Länge MEA_LENGTH <br>
	 * C = Checksumme = Paritybit der Quersumme der ASCI-Repräsentation von FGW 
	 * 
	 * @param error_f boolean: true erzwingt F = 1 sonst random
	 * @param type_f String: legt die Messgröße fest. Muss aus SENSOR_TYPES sein.
	 * @param value_f String: legt den Messwert fest. Muss MEA_LENGTH lang sein.
	 */
	public static String getMeasurementValue(Boolean error_f, String type_f, String value_f) {
		return getMeasurementValue(error_f, type_f, value_f, 'f');
	}
	/**
	 * getMeasurementValue() ist mehrfach überladen um seine Verwendung zu vereinfachen. <br>
	 * Diese Version erlaubt es die ausgegebene Größe und den Messwert manuell festzulegen.<br>
	 * Die Ausgabe der Funktionstüchtigkeit der Messstation gibt zu 90% funktionstüchtig und zu 10% fehlerhaft aus. <br>
	 * Die Checksumme kann manuell korruptiert werden.
	 * 
	 * @return String mit FGGWWWWWWC <br>
	 * F = Funktionsfähigkeit (1 = fehlerhaft, 0 = fehlerfrei)<br>
	 * G = Größe (siehe SENSOR_TYPES) <br>
	 * W = Messwert der Länge MEA_LENGTH <br>
	 * C = Checksumme = Paritybit der Quersumme der ASCI-Repräsentation von FGW 
	 * 
	 * @param type_f String: legt die Messgröße fest. Muss aus SENSOR_TYPES sein.
	 * @param value_f String: legt den Messwert fest. Muss MEA_LENGTH lang sein.
	 * @param cs_f char: 'f' erzwingt eine fehlerhafte Checksumme
	 */
	public static String getMeasurementValue(String type_f, String value_f, char cs_f) {
		return getMeasurementValue(false, type_f, value_f, cs_f);
	}
	public static String getMeasurementValue(boolean error_f, String type_f, String value_f, char cs_f) {
		// Decide on Error
		int error_i = (error_f ? 1 : ((Math.random() < ERROR_RATE) ? 1 : 0));
		String message = String.valueOf(error_i);
		// Get SensorType
		String type_s = Arrays.asList(SENSOR_TYPES).contains(type_f) ? type_f : SENSOR_TYPES[type_i];
		message += type_s;
		type_i = (type_i + 1) % SENSOR_COUNT;
		if (value_f.length() == MEA_LENGTH) {
			message += value_f;
		} else {
			// Get SensorValue
			switch (type_s) {
				case "TL":
					message += getRandomValue(-10, 20, 1);
					break;
				case "TP":
					message += getRandomValue(-10, 20, 1);
					break;
				case "RF":
					message += getRandomValue(0, 100, 1);
					break;
				case "WG":
					message += getRandomValue(0, 160, 1);
					break;
				case "LD":
					message += getRandomValue(970, 1030, 1);
					break;
				case "NA":
					message += getRandomValue(0, 25, 2);
					break;
				default:
					message = String.valueOf(1);
					break;
			}
		}
		// Add Checksum
		message += calcChecksum(message, cs_f);
		// Return Output
		return(message);
	}
		// Calculate Dummy Measurement Values
		private static String getRandomValue(int minVal, int maxVal, int precission){
			int range = maxVal - minVal;
			return paddString(String.valueOf(Math.round((Math.random()*range+minVal)*Math.pow(10.0, precission))/Math.pow(10.0, precission)));
		}
		// Helper Function
		private static String paddString(String str) {
			return String.format("%1$" + MEA_LENGTH + "s", str); //.replace(' ', '0');
		}
		// Calculate Checksum
		private static String calcChecksum(String input, char err){
			int sum = 0;
			for (int i=0; i<input.length(); i++) {
				sum += Integer.bitCount((int) input.charAt(i));
			}
			if (err != 'f') {
				return String.valueOf(sum % 2 == 0 ? 1 : 0);
			} else {
				return String.valueOf(sum % 2 == 0 ? 0 : 1);
			}
		}
	/**
	* GETTER für SENSOR_TYPES
	*/
	public static String[] getSENSOR_TYPES() {
		return SENSOR_TYPES;
	}
	/**
	* GETTER für MEA_LENGTH
	*/
	public static int getMEA_LENGTH() {
		return MEA_LENGTH;
	}
}
