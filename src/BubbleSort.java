/**
 * Eine einfache, rekursive Implementation von Bubblesort. Sortiert ein zahlen
 * Array in aufsteigender Reihenfolge. Test
 * 
 * @author Steffen Dworsky
 *
 */
public class BubbleSort extends SSort implements ISort {

	/**
	 * sort() Methode implementiert den Bubble Sort algorithmus.
	 * 
	 * return
	 */
	@Override
	public int[] sort(int[] intArr) {

		for (int i = 0; i < intArr.length - 1; i++) {
			if (intArr[i] < intArr[i + 1]) {
				continue; // Prüft immer zwei benachbarte Zahlen. Sind diese bereits in Aufsteigender
							// Reihenfolge, so wird mit den nächsten fortgefahren.
			}
			swap(i, i + 1, intArr);
			sort(intArr);
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
		run(args, new BubbleSort());
	}
}
