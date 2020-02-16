
// -------------------------------------------------------------------------
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author
 * @version HT 2020
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static,
	 * thus it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {
		if (a.length <= 1) {
			return a;
		}
		double x;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					x = a[j];
					a[j] = a[j - 1];
					a[j - 1] = x;
				}
			}
		}
		/*for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i] + "y");
		}*/
		return a;
	}// end insertionsort

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static,
	 * thus it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {
		if (a.length <= 1) {
			return a;
		}
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < a.length - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < a.length; j++)
				if (a[j] < a[min_idx])
					min_idx = j;
			// Swap the found minimum element with the first
			// element
			double temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}
		/*for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i] + "z");
		}*/
		return a;
	}// end
		// selectionsort

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double a[]) {
		if (a.length <= 1) {
			return a;
		}
		quickRecursive(a, 0, a.length - 1);

		/*for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i] + "x");
		}*/
		return a;

	}// end quicksort

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSortIterative(double a[]) {
		if (a.length <= 1) {
			return a;
		} 
		mergeSort(a);
		/*for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i] + "v");
		}*/
		return a;
	}// end mergesortIterative

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSortRecursive(double a[]) {

		double[] aux = new double[a.length];
		mergeSort(a, aux, 0, a.length - 1);
		/*for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i] + "w");
		}*/
		return a;
	}// end mergeSortRecursive

	public static void main(String[] args) {

		// todo: do experiments as per assignment instructions
	}

	// [3,6,1] lo =0; hi=2;
	static int partition(double[] numbers, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		double pivot = numbers[lo]; // pivot=3, i=0, j=3
		while (true) {
			while ((numbers[++i] < pivot)) { // while numbers<pivot
				if (i == hi)
					break;
			}
			while (pivot < (numbers[--j])) {
				if (j == lo)
					break;
			}
			if (i >= j)
				break;
			double temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		numbers[lo] = numbers[j];
		numbers[j] = pivot;
		return j;
	}

	public static void mergeSort(double[] a, double[] aux, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = lo + ((hi - lo) / 2);
		mergeSort(a, aux, lo, mid);
		mergeSort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	public static void mergeSort(double[] a){
		double[] aux = new double[a.length];
		for (int i=1; i<a.length;i++){
			for (int lo=0; lo<a.length-i; lo+=i+i){
				merge(a, aux, lo, lo+i-1, Math.min(lo+i+i-1, a.length-1));
			}
		}

	}
	public static void merge(double[] a, double[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if ((aux[j] < aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}

	public static void quickRecursive(double[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int pivot = partition(a, lo, hi);
		quickRecursive(a, lo, pivot - 1);
		quickRecursive(a, pivot + 1, hi);
	}
}// end class
