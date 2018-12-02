/**
 * SSort vererbt hauptsächlich eine Methode an alle Sortieralgorithmen.
 * 
 * @author Steffen Dworsky
 *
 */
public class SSort {

	/**
	 * Methode um aus den in der Main Methode übergebenen Strings, ein int[] zu
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

	/**
	 * Funktion zum Austauschen zweier Werte i und j.
	 * 
	 * @param i
	 * @param j
	 * @param intArr
	 * @return
	 */
	public int[] swap(int i, int j, int[] intArr) {
		int temp = intArr[i];
		intArr[i] = intArr[j];
		intArr[j] = temp;
		return intArr;
	}

	public static void run(String[] args, ISort sorter) {
		int[] intArr = sorter.stringArrToIntArr(args);
		int[] sortArr = sorter.sort(intArr);
		for (int i = 0; i < sortArr.length; i++) {
			System.out.println(i + 1 + ": " + sortArr[i]);
		}
	}

}
