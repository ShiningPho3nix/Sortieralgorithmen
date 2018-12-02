/**
 * Interface für die meisten Sortieralgorithmen.
 * 
 * @author Steffen Dworsky
 *
 */
public interface ISort {

	public int[] sort(int[] intArr);

	public int[] stringArrToIntArr(String[] s);

	public int[] swap(int i, int j, int[] intArr);
}
