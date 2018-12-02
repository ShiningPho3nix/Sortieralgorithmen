/**
 * Eine einfache Implementierung des Quicksort Algorithmus. Test
 * 
 * @author Steffen Dworsky
 *
 */
public class QuickSort extends SSort {

	/**
	 * Der durch die Methode partition zur�ckgegebene Wert wird hier f�r die
	 * Aufteilung des Arrays verwendet. Die Methode ruft sich dann selbst auf,
	 * zun�chst mit dem erhaltenen Wert als Obergrenze, bis zur minimalen
	 * aufteilung. Anschlie�end wird der Wert +1 als untergrenze verwendet. Die
	 * Sortierung der Werte findet immer in der partition Methode statt.
	 * 
	 * @param intArr
	 * @param start
	 * @param end
	 * @return
	 */
	private int[] sort(int[] intArr, int start, int end) {
		int x;
		if (start < end) {
			x = partition(intArr, start, end);
			sort(intArr, start, x);
			sort(intArr, x + 1, end);
		}

		return intArr;
	}

	/**
	 * Die Methode partition startet dem dem Wert an der stelle start als pivot
	 * Element. von dem start und endpunkt ausgehend wird jeweils geschaut ob der
	 * Wert gr��er, bzw. kleiner als das pivotelement ist. Wurde einer gefunden h�lt
	 * der entsprechende marker an. Sind beide Marker angehalten, so wird ein neues
	 * pivot element zur�ckgegeben, oder es werden die Werte an denen sich die
	 * Marker aktuell befinden ausgetauscht, je nachdem ob i>=j erf�llt ist oder
	 * nicht
	 * 
	 * @param intArr
	 * @param start
	 * @param end
	 * @return
	 */
	public int partition(int[] intArr, int start, int end) {
		int pivot = intArr[start];
		int i = start - 1; // i und j werden so gew�hlt, das inizial i>j gegeben ist. Wird eine sortierte
							// Liste �bergeben, so kann das Programm ohne probleme durchlaufen und endet
							// nicht in der endlosschleife while(true) fest.
		int j = end + 1;
		while (true) {
			do {
				i++;
			} while (intArr[i] < pivot); // Durchl�uft das Array von vorne, bis ein Wert gefunden wurde, welcher gr��er
											// ist als das gew�hlte Pivotelement, oder das Pivotelement erreicht wurde
											// ohne ein gr��eres Element zu finden.
			do {
				j--;
			} while (intArr[j] > pivot); // Durchl�uft das Array von hinten, bis ein Wert gefunden wurde welcher gr��er
											// ist als das gew�hlte Pivotelement, oder das Pivoelement erreicht wurde
											// ohne ein kleineres Element zu finden.
			if (i >= j) { // Sollte i gr��er als j geworden sein, oder gleich j (das Pivotelement selbst),
							// so wird j als neues Pivotelement gew�hlt und von der Methode zur�ckgegeben.
				return j;
			} else { // Sollte vor oder hinter dem Pivotelement ein Wert gefunden worden sein der
						// gr��er oder kleiner als das Pivotelement ist, so ist i<j und die werte an den
						// stellen i und j werden vertauscht.
				// Es gibt 3 M�glichkeiten hierbei: 1. unterhalb des Pivotelements wurde ein
				// Wert entdeckt, oberhalb aber nicht, so wird das Pivotelement mit dem
				// gefudnene wert vertauscht. 2.Ein wert wurde oberhalb gefunden, welcher
				// kleiner ist als das Pivotelement, in der unteren h�lfte wurde kein wert
				// gefunden, welcher gr��er ist. So wird wieder das pivotelement mit dem
				// gefundene wert vertauscht. 3. Es wurde eine wert in der unteren, welcher
				// gr��er als das pivorelement ist, gefunden und einer in der oberen H�lfte,
				// welcher kleiner ist als das pivoelement. In diesem fall werden die beiden
				// werte vertauscht. In allen drei f�llen wird weitergemacht bis i>=j.
				swap(i, j, intArr);
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
		QuickSort qs = new QuickSort();
		int[] intArr = qs.stringArrToIntArr(args);
		int[] sortArr = qs.sort(intArr, 0, intArr.length - 1);
		for (int i = 0; i < sortArr.length; i++) {
			System.out.println(i + 1 + ": " + sortArr[i]);
		}
	}
}
