/**
 * SSort vererbt hauptsächlich eine Methode an alle Sortieralgorithmen.
 * 
 * @author Steffen Dworsky
 *
 */
public class SSort {

	/**
	 * Mehtode um aus den in der Main Methode übergebenen Strings, ein int[] zu
	 * machen. Zeichen welche keine Zahlen sind werden hierbei ignoriert.
	 * 
	 * @param s
	 * @return
	 */
	public int[] stringArrToIntArr(String[] s) {
		int[] result = new int[s.length];
		for (int i = 0; i < result.length; i++) {
			try {
				result[i] = Integer.parseInt(s[i]);
			} catch (NumberFormatException e) { // Sollte einer der Werte keine Zahl sein, so wird eine Exception
												// geworfen. Würde man diese einfach ignorieren, so wird im int[] der
												// Platz durch eine 0 ausgefüllt. Da der Algorithmus nicht für Zahlen
												// die mehr als einmal vorkommen ausgelegt ist, kann dies zu Fehlern
												// führen.
				e.printStackTrace();
				System.out.println("");
				System.out.println(s[i] + " is not a Number. The program has been stopped!");
				System.exit(42);
			}
		}
		return result;
	}

}
