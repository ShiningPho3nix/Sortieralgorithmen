/**
 * 
 * Simple Implementierung des Shaker Sort Algorithmus.
 * 
 * @author Steffen Dworsky
 *
 */
public class ShakerSort extends SSort implements ISort {

	int temp;

	/**
	 * Sorgt f�r den Programmablauf des Shaker Sort Algorithmus. Ruft die Funktion
	 * welche von vorne nach hinten �ber das Array l�uft und erniedrigt den endwert
	 * um 1. Ruft anschlie�end die Funktion auf welche r�ckw�rts �ber das Array
	 * l�uft und erh�ht anschlie�end den Startwert um 1. Wird solange wiederholt bis
	 * start = end.
	 * 
	 * @param intArr
	 */
	@Override
	public int[] sort(int[] intArr) {
		int start = 0, end = intArr.length - 1;
		while (start < end) {
			shakerUp(start, end, intArr);
			end--;
			shakerDown(start, end, intArr);
			start++;
		}
		return intArr;
	}

	/**
	 * Funktion welche f�r das vorw�rtslaufen �ber das Array verantworlich ist.
	 * Hierbei werden immer zwei benachbarte werte verglichen und geg. ausgetauscht.
	 * 
	 * @param start
	 * @param end
	 */
	private void shakerUp(int start, int end, int[] intArr) {
		for (int i = start; i < end; i++) {
			if (intArr[i] > intArr[i + 1]) {
				swap(i, i + 1, intArr);
			}
		}

	}

	/**
	 * Funktion welche f�r das r�ckwertslaufen �ber das Array verantworlich ist.
	 * Hierbei werden immer zwei benachbarte werte verglichen und geg. ausgetauscht.
	 * 
	 * @param start
	 * @param end
	 */
	private void shakerDown(int start, int end, int[] intArr) {
		for (int i = end; i >= start; i--) {
			if (intArr[i] > intArr[i + 1]) {
				swap(i, i + 1, intArr);
			}
		}

	}

	/**
	 * Die Main Methode nimmt ein String[] an, wandelt es mithilfe der Funkiton
	 * stringArrToIntArr in ein int[] um und l�sst dann den Algorithmus
	 * dr�berlaufen.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		run(args, new ShakerSort());
	}
}
