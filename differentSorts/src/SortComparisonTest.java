import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

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
 *          			Insert      Select  	QuickSort   MergeIterative  MergeRecursive
 * 
 *10 random 			4200ns      4466ns		7966ns		32200ns			10433ns
 *100 random			233066ns	199800ns	222600ns	554966ns		123800ns
 1000 random			5105433ns	5243900ns	2691966ns	7142600ns		815300ns
 1000 few unique		6033266ns	4772866ns	1898566ns	9599933ns		778833ns
 1000 nearly ordered	5830600ns	7339066ns	3306266ns	5906100ns		702833ns
 1000 reverse order		7922800ns	5237533ns	5156300ns	7392733ns		674933ns
 1000 sorted			5724133ns	4833066ns	5331333ns	5855266ns		786833ns
 *          
 * 
 *          a. Which of the sorting algorithms does the order of input have an
 *          impact on? Why?
 * 
 *          b. Which algorithm has the biggest difference between the best and
 *          worst performance, based on the type of input, for the input of size
 *          1000? Why?
 * 
 *          c. Which algorithm has the best/worst scalability, i.e., the
 *          difference in performance time based on the input size? Please
 *          consider only input files with random order for this answer.
 * 
 *          d. Did you observe any difference between iterative and recursive
 *          implementations of merge sort?
 * 
 *          e. Which algorithm is the fastest for each of the 7 input files?
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
		SortComparison tester = new SortComparison();
		double a[] = new double[0];
		assertTrue(Arrays.equals(tester.quickSort(a), a));
		assertTrue(Arrays.equals(tester.insertionSort(a), a));
		assertTrue(Arrays.equals(tester.selectionSort(a), a));
		assertTrue(Arrays.equals(tester.mergeSortRecursive(a), a));
		assertTrue(Arrays.equals(tester.mergeSortIterative(a), a));

		
		
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

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		long duration = 0;
	//	Scanner inFile = new Scanner(new FileReader("numbers10.txt"));
	//	Scanner inFile = new Scanner(new FileReader("numbers100.txt"));
//		Scanner inFile = new Scanner(new FileReader("numbers1000.txt"));
//	Scanner inFile = new Scanner(new FileReader("numbers1000Duplicates.txt"));
	//	Scanner inFile = new Scanner(new FileReader("numbersNearlyOrdered1000.txt"));
	//	Scanner inFile = new Scanner(new FileReader("numbersReverse1000.txt"));
		Scanner inFile = new Scanner(new FileReader("numbersSorted1000.txt"));
		double a[] = new double[1000];
		int o = 0;
		while (inFile.hasNextLine()) {
			a[o] = Double.parseDouble(inFile.nextLine());
			o++;
		}
		SortComparison tester = new SortComparison();
		for (int j = 0; j < 3; j++) {
			long startTime = System.nanoTime();
			tester.mergeSortRecursive(a);
			long endTime = System.nanoTime();
			System.out.println("Duration of test " + (j + 1) + " was; " + (endTime - startTime));
			duration = duration + (endTime - startTime); // divide by 1000000 to
			// get
			// milliseconds.
		}
		long average = duration / 3;
		System.out.println("Average running time is " + average + "ns");
		

	}

}
