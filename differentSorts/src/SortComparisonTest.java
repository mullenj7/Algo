import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for SortComparison.java
 *
 * @author
 * @version HT 2020
 * 
 *          Running Times Average Table:
 * 
 *          Insert Select QuickSort MergeIterative MergeRecursive
 * 
 *          10 random -------------------------------.
 *          100 random -------------------------------.
 *          1000 random --------------------------.
 *          1000 few unique ------------------------------
 *          1000 nearly ordered ---------------------------
 *          1000 reverse order ----------------------------
 *          1000 sorted ------------------------------------
 * 
 *          a. Which of the sorting algorithms does the order of input have an
 *          impact on? Why?
 * 
 *          b. Which algorithm has the biggest difference between the best and
 *          worst performance, based on the type of input, for the input of size
 *          1000? Why? 
 *          
 *          c. Which algorithm has the best/worst scalability, i.e.,
 *          the difference in performance time based on the input size? Please
 *          consider only input files with random order for this answer. 
 *          
 *          d. Did you observe any difference between iterative and recursive
 *          implementations of merge sort? 
 *          
 *          e. Which algorithm is the fastest for
 *          each of the 7 input files?
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new SortComparison();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty() {
	}

	@Test
	public void testQuick() {
		SortComparison tester = new SortComparison();
		double a[] = new double[] { 4, 7, 1, 10, 9, 14, 29, 21, 50, 19, 23 };
		double b[] = new double[] { 1, 4, 7, 9, 10, 14, 19, 21, 23, 29, 50 };

		assertTrue(Arrays.equals(tester.quickSort(a), b));

	}

	@Test
	public void testInsertion() {
		SortComparison tester = new SortComparison();
		double a[] = new double[] { 4, 7, 1, 10, 9, 14, 29, 21, 50, 19, 23 };
		double b[] = new double[] { 1, 4, 7, 9, 10, 14, 19, 21, 23, 29, 50 };

		assertTrue(Arrays.equals(tester.insertionSort(a), b));
	}

	@Test
	public void testSelection() {
		SortComparison tester = new SortComparison();
		double a[] = new double[] { 4, 7, 1, 10, 9, 14, 29, 21, 50, 19, 23 };
		double b[] = new double[] { 1, 4, 7, 9, 10, 14, 19, 21, 23, 29, 50 };

		assertTrue(Arrays.equals(tester.selectionSort(a), b));
	}

	@Test
	public void testMergeRecursive() {
		SortComparison tester = new SortComparison();
		double a[] = new double[] { 4, 7, 1, 10, 9, 14, 29, 21, 50, 19, 23 };
		double b[] = new double[] { 1, 4, 7, 9, 10, 14, 19, 21, 23, 29, 50 };

		assertTrue(Arrays.equals(tester.mergeSortRecursive(a), b));
	}

	@Test
	public void testMergeIterative() {
		SortComparison tester = new SortComparison();
		double a[] = new double[] { 4, 7, 1, 10, 9, 14, 29, 21, 50, 19, 23 };
		double b[] = new double[] { 1, 4, 7, 9, 10, 14, 19, 21, 23, 29, 50 };

		assertTrue(Arrays.equals(tester.mergeSortIterative(a), b));
	}

	// ----------------------------------------------------------
	/**
	 * Main Method. Use this main method to create the experiments needed to
	 * answer the experimental performance questions of this assignment.
	 *
	 */
	public static void main(String[] args) {
		long duration = 0;
		SortComparison tester = new SortComparison();
		for (int j = 0; j < 3; j++) {
			long startTime = System.nanoTime();
			tester.insertionSort(a);
			long endTime = System.nanoTime();
			duration = duration + (endTime - startTime); // divide by 1000000 to
															// get
			// milliseconds.
		}
		long average = duration / 3;
		System.out.println("Average running time is " + average);
	}

}
