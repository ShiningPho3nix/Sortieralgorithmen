/**
 * Eine einfache Implementierung des Insertsort Algorithmus. Sortiert ein zahlen
 * Array in aufsteigender Reihenfolge. Test
 * 
 * @author Steffen Dworsky
 *
 */
public class InsertSort extends SSort implements ISort {

	/**
	 * sort Methode implementiert den Insert Sort Algorithmus.
	 */
	@Override
	public int[] sort(int[] intArr) {
		for (int i = 0; i < intArr.length; i++) { // läuft die komlette länge des Arrays durch
			for (int j = intArr.length - 1; j > 0; j--) { // läuft das Array von hinten durch
				if (intArr[j - 1] > intArr[j]) { // wenn die höhere Zahl weiter vorne im Array ist.
					swap(j, j - 1, intArr);
				}
			}
		}
		return intArr;
	}

	/**
	 * Die Main Methode nimmt ein String[] an, wandelt es mithilfe der Funkiton
	 * stringArrToIntArr in ein int[] umd un lässt dann den Instertsort Algorithmus
	 * mit der Funktion sort drüberlaufen.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		run(args, new InsertSort());

	}
}
