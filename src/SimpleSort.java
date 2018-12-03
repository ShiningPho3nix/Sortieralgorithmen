/**
 * Einfache Implementierung des Simple Sort Algorithmus.
 * 
 * @author Steffen Dworsky
 *
 */
public class SimpleSort extends SSort implements ISort {

	/*
	 * sort implementiert den Simple Sort Algorithmus. Hierbei l�uft eine for
	 * schleife von hinten �ber das Array. In einer inneren for schleife l�uft ein
	 * zweiter Index j forw�rts und tauscht j und i aus wenn j>=i. Somit ist nach
	 * einem durchlauf der inneren for schleife das kleinste Element an der ersten
	 * position.
	 */
	@Override
	public int[] sort(int[] intArr) {
		for (int i = intArr.length - 1; i >= 1; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (intArr[j] > intArr[i]) {
					swap(i, j, intArr);
				}
			}
		}
		return intArr;
	}

	/**
	 * Startet den Sortieralgorithmus. Durch die Funktion run wird auch eine Ausgabe
	 * des Sortierten Ergebnisses auf der Konsole ausgegeben.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		run(args, new SimpleSort());

	}

}
