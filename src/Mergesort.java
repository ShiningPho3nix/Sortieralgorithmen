/**
 * Simple Implementierung des Mergesort Algorithmus. Sortiert ein zahlen Array
 * in aufsteigender Reihenfolge.
 * 
 * @author Steffen Dworsky
 *
 */
public class Mergesort extends SSort {

	static int[] intArrField;

	public int[] sort(int a, int b) {
		if (a < b) {
			int m = (a + b) / 2; // In m wird der Mittelpunkt zwischen a und b gefunden und
									// gespeichert (abgerundet). Bsp. m = (0 + 11) / 2 = 5
			sort(a, m); // rekursiv wird dann wieder der mittelpunkt in der ersten h�lfte gesucht daher
						// von a bis zum eben gefundenen mittelpunkt. Bsp. sort(0,5), sort(0,2),
						// sort(0,1), sort(0,0)
			sort(m + 1, b); // nachdem bei sort(a,m) das erste mal returned wurde wird dieser abschnitt
							// ausgef�rt sort(0+1,1),
			merge(a, m, b); // Nachdem sort(m+1,b) das erste mal retuned hat, wird die Methode merge
							// ausgef�hrt. Dadurch wird der erste teilabschnitt sortiert. Bsp. merge(0,0,1)
		}
		return intArrField; // Sollte nicht weiter aufgeteilt Bsp. sort(0,0) werden oder die rekursiven
							// aufrufe aufgel�st, wird ein return zur�ckgegeben. relevant ist nur das aller
							// letzte return.
	}

	public void merge(int a, int m, int b) {
		int[] localArr = new int[intArrField.length];
		int i, j;
		for (i = a; i <= m; i++) {// Die erste h�lfte des Teilabschnittes wird in das Array geladen, sodass der
									// h�chste wert des ersten teilabschnittes bei m liegt.
			localArr[i] = intArrField[i];
		}
		for (j = m + 1; j <= b; j++) { // Die Zweite h�lfte wird in das Array geladen, r�ckwerts. Sollte es sich
										// hierbei um einen bereits sortierten teilabschnitt handeln wird dieser
										// absteigend eingetragen. Somit ist der h�chste wert an der stelle m+1
			localArr[b + m + 1 - j] = intArrField[j];
		}
		i = a;
		j = b;
		for (int k = a; k <= b; k++) { // k sorgt daf�r das die for schleife so oft durchl�uft, das genau alle elemente
										// betrachtet werden, bzw. vergleichen werden. Auch sorgt k daf�r das die
										// positionierung des jeweiligen wertes stimmt.
			if (localArr[i] <= localArr[j]) { // beginnend mit dem ersten und dem letzten wert (also jeweils den
												// kleinsten werten beider teilabschnitte): ist der erste Wert kleiner
												// oder gleich dem zweiten, wird dieser an die stelle k geschrieben.
				intArrField[k] = localArr[i];
				i++; // Ist der kleinste Wert aus der ersten h�lfte kleiner, so wird dieser im
						// n�chsten schritt ignoriert, da er der kleinste aus beiden war. Es wird im
						// n�chsten schritt der zweitkleinste verwendet
			} else {
				intArrField[k] = localArr[j]; // Wenn der zweite wert gr��er ist wird dieser an die stelle k
												// geschrieben.
				j--; // Da der kleinste wert aus der zweiten h�lfte kam wird im n�chsten schritt der
						// n�chst kleinere wert der zweitren h�lfte verwendet.
			} // Wurde ein kleinster wert gefunden, so wird dieser im n�chsten schritt
				// ignoriert (i++ oder j--) und der n�chst kleinere Wert der jeweiligen h�lfte
				// wird verwendet.
		}
	}

	/**
	 * Der Main Methode k�nnen Zahlen in form eines Strings �bergeben werden.
	 * Ausgegeben wird auf der Konsole die Zahlen in Aufsteigender Reihenfolge.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Mergesort ms = new Mergesort();
		intArrField = ms.stringArrToIntArr(args);
		int[] sortArr = ms.sort(0, intArrField.length - 1);
		for (int i = 0; i < sortArr.length; i++) {
			System.out.println(i + 1 + ": " + sortArr[i]);
		}
	}
}
