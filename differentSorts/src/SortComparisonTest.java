import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    }
    
    @Test
    public void testQuick(){
    	SortComparison tester = new SortComparison();
    	double a[] = new double[]{4,7,1,10,9,14,29,21,50,19,23};
    	double b[] = new double[]{1,4,7,9,10,14,19,21,23,29,50};
    	
    	assertTrue(Arrays.equals(tester.quickSort(a),b));
    	
    }
    
    @Test
    public void testInsertion(){
    	SortComparison tester = new SortComparison();
    	double a[] = new double[]{4,7,1,10,9,14,29,21,50,19,23};
    	double b[] = new double[]{1,4,7,9,10,14,19,21,23,29,50};
    	
    	assertTrue(Arrays.equals(tester.insertionSort(a),b));
    }
    @Test
    public void testSelection(){
    	SortComparison tester = new SortComparison();
    	double a[] = new double[]{4,7,1,10,9,14,29,21,50,19,23};
    	double b[] = new double[]{1,4,7,9,10,14,19,21,23,29,50};
    	
    	assertTrue(Arrays.equals(tester.selectionSort(a),b));
    }
    @Test
    public void testMergeRecursive(){
    	SortComparison tester = new SortComparison();
    	double a[] = new double[]{4,7,1,10,9,14,29,21,50,19,23};
    	double b[] = new double[]{1,4,7,9,10,14,19,21,23,29,50};
    	
    	assertTrue(Arrays.equals(tester.mergeSortRecursive(a),b));
    }
    @Test
    public void testMergeIterative(){
    	SortComparison tester = new SortComparison();
    	double a[] = new double[]{4,7,1,10,9,14,29,21,50,19,23};
    	double b[] = new double[]{1,4,7,9,10,14,19,21,23,29,50};
    	
    	assertTrue(Arrays.equals(tester.mergeSortIterative(a),b));
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
