/**
 * Simple Implementierung des Selection Sort Algorithmus.
 * 
 * @author Steffen Dworsky
 *
 */
public class SelectionSort extends SSort implements ISort {

	/**
	 * sort() Methode implementiert den Selection Sort algorithmus.
	 * 
	 * return
	 */
	@Override
	public int[] sort(int[] intArr) {
		for (int i = 0; i < intArr.length - 1; i++) { // Array wird durchlaufen.
			int min = i; // i wird immer zu begin als mon wert festgelegt, damit der wert immer
							// inizialisiert wird mit unsortierten werten.
			for (int j = i + 1; j < intArr.length; j++) { // Zweite schleife läuft alle Werte ab i+1 durch
				if (intArr[j] < intArr[min]) { // Wann immer ein kleinerer Wert gefunden wird, wird mit aktualiesiert.
												// Ist die innere Schleife durchgelaufen, so wurde der kleinste wert
												// gefunden.
					min = j;
				}
			}
			if (min != i) { // Wenn der kleinste WErt nicht der aktuell erste im unsortierten bereich des
							// Arrays ist, so wird der gefundenen min Wert als erster WErt im unsortiertem
							// bereich gesetzt.
				int k = intArr[i];
				intArr[i] = intArr[min];
				intArr[min] = k;
			}
		}
		return intArr;
	}

	/**
	 * Der Main Methode können Zahlen in form eines Strings übergeben werden.
	 * Ausgegeben wird auf der Konsole die Zahlen in Aufsteigender Reihenfolge.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		int[] intArr = ss.stringArrToIntArr(args);
		int[] sortArr = ss.sort(intArr);
		for (int i = 0; i < sortArr.length; i++) {
			System.out.println(i + 1 + ": " + sortArr[i]);
		}
	}
}
