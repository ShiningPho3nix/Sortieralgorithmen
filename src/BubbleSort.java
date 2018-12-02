/**
 * Eine einfache, rekursive Implementation von Bubblesort. Sortiert ein zahlen
 * Array in aufsteigender Reihenfolge. Test
 * 
 * @author Steffen Dworsky
 *
 */
public class BubbleSort extends SSort implements ISort {

	@Override
	public int[] sort(int[] intArr) {

		int j;
		for (int i = 0; i < intArr.length - 1; i++) {
			if (intArr[i] < intArr[i + 1]) {
				continue; // Prüft immer zwei benachbarte Zahlen. Sind diese bereits in Aufsteigender
							// Reihenfolge, so wird mit den nächsten fortgefahren.
			}
			j = intArr[i]; // Zwischenspeichern von i
			intArr[i] = intArr[i + 1]; // i = nachfolgende Zahl
			intArr[i + 1] = j; // nachfolgende Zahl = i
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
		BubbleSort bs = new BubbleSort();
		int[] intArr = bs.stringArrToIntArr(args);
		int[] sortArr = bs.sort(intArr);
		for (int i = 0; i < sortArr.length; i++) {
			System.out.println(i + 1 + ": " + sortArr[i]);
		}
	}
}
