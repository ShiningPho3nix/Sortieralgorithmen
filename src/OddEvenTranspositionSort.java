/**
 * Eine einfache Implementiertung des OddEven Sort Algorithmus. Test
 * 
 * @author Steffen Dworsky
 *
 */
public class OddEvenTranspositionSort extends SSort {

	Boolean sorted;

	/**
	 * Im Konstruktor wird das Feld sorted als false inizialisiert, da das Array zum
	 * Starten der sortiermethode als unsortiert betrachtet werden muss.
	 */
	public OddEvenTranspositionSort() {
		sorted = false;
	}

	/*
	 * Die oddEven Methode ist f�r den korrekten Ablauf des Algorithmus
	 * verantwortlich. Es wird hierbei alternierend die Methode sort mit ungeradem
	 * und mit geradem Startwert aufgerufen bis das Array sortiert ist.
	 */
	public int[] oddEven(int[] intArr) {

		while (!sorted) {
			sorted = true; // Die Listen werden zu begin eines jeden durchlaufs der while schleife als
							// sortiert betrachtet. sorted wird nur dann wieder auf fals gesetzt, wenn zwei
							// benachbarte Werte mindestens einmal vertauscht worden sind.
			intArr = sort(intArr, 1); // 1 = ungerade, 0 = gerade paare welche vergleichen werden
			intArr = sort(intArr, 0);
		}
		return intArr;
	}

	/**
	 * Die Funktion sort Pr�ft f�r das �bergebene Array, beginnend bei dem
	 * �bergebenen Startwert alle geraden, bzw. ungeraden paare ( je nach
	 * startwert). Sollte ein wert gr��er als der direkt n�chste sein, so werden die
	 * beiden ausgetauscht und das feld sorted auf false gesetzt.
	 * 
	 * @param intArr
	 * @param start
	 * @return
	 */
	public int[] sort(int[] intArr, int start) {
		for (int i = start; i < intArr.length - 1; i += 2) { // +=2 damit entweder alle gerade oder alle ungeraden
																// betrachtet werden, je nachdem welcher startwert
																// �bergeben wird.
			if (intArr[i] > intArr[i + 1]) {
				swap(i, i + 1, intArr);
				sorted = false; // wurde mindestens ein Austausch vorgenommen, wird die Liste als unsortiert
								// betrachtet und die while schleife l�uft ein weiteres mal durch.
			}
		}
		return intArr;
	}

	/**
	 * Die Main Methode nimmt ein String[] an, wandelt es mithilfe der Funkiton
	 * stringArrToIntArr in ein int[] um und l�sst dann den Algorithmus
	 * dr�berlaufen.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		OddEvenTranspositionSort oe = new OddEvenTranspositionSort();
		int[] intArr = oe.stringArrToIntArr(args);
		int[] sortArr = oe.oddEven(intArr);
		for (int i = 0; i < sortArr.length; i++) {
			System.out.println(i + 1 + ": " + sortArr[i]);
		}
	}
}
