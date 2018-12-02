/**
 * Implementierung des Cocktail shaker sort, bzw. bidirectional bubble sort,
 * cocktail sort, shaker sort, ripple sort, shuffle sort, shuttle sort. Mit
 * Optimierung, in form des Merkens der zuletzt gewechselten Indexe und updaten
 * der Grenzen.
 * 
 * @author Steffen Dworsky
 *
 */
public class Ripplesort extends SSort implements ISort {

	/**
	 * Diese Funktion implementiert den Cocktailsort Algorithmus. �hnlich wie beim
	 * Bubblesort werden hier Elemente mit dem Nachfolger vergleichen. Hinzu kommt
	 * das in beide Richtungen dieser Vergleich durchgef�hrt wird. Dabei werden
	 * immer die Grenzen aktualisiert um unn�tiges �berpr�fen zu vermeiden.
	 */
	@Override
	public int[] sort(int[] intArr) {
		int start = 0; // Zu begin wird das ganze Array betrachtet.
		int end = intArr.length - 1;
		int newStart = end; // Damit die Werte immer inizialisiert sind und der Algorithmus auch bei bereits
		int newEnd = start; // sortierten Array funktioniert und nicht endlos weiterl�uft.

		while (start < end) { // Ab dem zweiten durchlauf wurden die Grenzen aktualisiert. Sobald start=end
								// sind alle elemente sortiert und das sortierte Array kann zur�ckgegebn werden.
			for (int i = start; i < end; i++) { // F�rs vorw�rts durchlaufen des Arrays
				if (intArr[i] > intArr[i + 1]) { // Ist ein Wert gr��er als sein Nachfolger werden diese getauscht.
					swap(i, i + 1, intArr);
					newEnd = i; // Als neuer endpunkt wird immer i gesetzt wenn getauscht wird. Beim letztn
								// tausch sind ab einschlie�lich i alle Elemente sortiert.
				}
			}
			end = newEnd - 1; // end wird gesetzt, da ab jetzt alles hinter (einschlie�lich) newend nicht
								// weiter
								// betrachtet werden muss.
			for (int i = end; i > start; i--) { // F�rs R�ckwerts durchlaufen des Arrays
				if (intArr[i] < intArr[i - 1]) { // Ist ein Wert kleiner als sein Vorg�nger werdne diese getauscht.
					swap(i, i - 1, intArr);
					newStart = i; // Als neuer startpunkt wird immer i gesetzt wenn getauscht wird. Beim letztn
									// tausch sind vor einschlie�lich i alle Elemente sortiert.
				}
			}
			start = newStart + 1; // start wird gesetzt, alle vor diesem wert sind sortiert und m�ssen nicht
									// weiter betrachtet werden.
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
		run(args, new Ripplesort());
	}

}
