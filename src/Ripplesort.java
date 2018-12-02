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
	 * Diese Funktion implementiert den Cocktailsort Algorithmus. Ähnlich wie beim
	 * Bubblesort werden hier Elemente mit dem Nachfolger vergleichen. Hinzu kommt
	 * das in beide Richtungen dieser Vergleich durchgeführt wird. Dabei werden
	 * immer die Grenzen aktualisiert um unnötiges überprüfen zu vermeiden.
	 */
	@Override
	public int[] sort(int[] intArr) {
		int start = 0; // Zu begin wird das ganze Array betrachtet.
		int end = intArr.length - 1;
		int newStart = end; // Damit die Werte immer inizialisiert sind und der Algorithmus auch bei bereits
		int newEnd = start; // sortierten Array funktioniert und nicht endlos weiterläuft.

		while (start < end) { // Ab dem zweiten durchlauf wurden die Grenzen aktualisiert. Sobald start=end
								// sind alle elemente sortiert und das sortierte Array kann zurückgegebn werden.
			for (int i = start; i < end; i++) { // Fürs vorwärts durchlaufen des Arrays
				if (intArr[i] > intArr[i + 1]) { // Ist ein Wert größer als sein Nachfolger werden diese getauscht.
					swap(i, i + 1, intArr);
					newEnd = i; // Als neuer endpunkt wird immer i gesetzt wenn getauscht wird. Beim letztn
								// tausch sind ab einschließlich i alle Elemente sortiert.
				}
			}
			end = newEnd - 1; // end wird gesetzt, da ab jetzt alles hinter (einschließlich) newend nicht
								// weiter
								// betrachtet werden muss.
			for (int i = end; i > start; i--) { // Fürs Rückwerts durchlaufen des Arrays
				if (intArr[i] < intArr[i - 1]) { // Ist ein Wert kleiner als sein Vorgänger werdne diese getauscht.
					swap(i, i - 1, intArr);
					newStart = i; // Als neuer startpunkt wird immer i gesetzt wenn getauscht wird. Beim letztn
									// tausch sind vor einschließlich i alle Elemente sortiert.
				}
			}
			start = newStart + 1; // start wird gesetzt, alle vor diesem wert sind sortiert und müssen nicht
									// weiter betrachtet werden.
		}
		return intArr;
	}

	/**
	 * Die Main Methode nimmt ein String[] an, wandelt es mithilfe der Funkiton
	 * stringArrToIntArr in ein int[] um und lässt dann den Algorithmus
	 * drüberlaufen.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		run(args, new Ripplesort());
	}

}
