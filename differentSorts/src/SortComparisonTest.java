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
    	
    	assertTrue(Arrays.equals(tester.insertionSort(a),b));
    	
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
    	
    	assertTrue(Arrays.equals(tester.insertionSort(a),b));
    }
    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

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
