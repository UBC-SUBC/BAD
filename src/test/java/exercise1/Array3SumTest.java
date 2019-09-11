package exercise1;

/**
 * All tests in the folder "test" are executed
 * when the "Test" action is invoked.
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;


public class Array3SumTest {

    @Test
    public final void testSingleElementArray1() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 3 };
        boolean expectedResult = false;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with one element, does not have a zero three-sum",
                actualResult == expectedResult);
    }

    @Test
    public final void testSingleElementArray2() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 0 };
        boolean expectedResult = true;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with one element, has a zero three-sum",
                actualResult == expectedResult);
    }


    @Test
    public final void testEmptyArray() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { };
        boolean expectedResult = false;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Empty array",
                actualResult == expectedResult);
    }

    @Test
    public final void testMultiElementArray1() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 3, 5, 2, 1 };
        boolean expectedResult = false;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with multiple element, does not have a zero three-sum",
                actualResult == expectedResult);
    }

    @Test
    public final void testMultiElementArray2() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 3, -2, 1, 4, -1, -2 };
        boolean expectedResult = true;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with multiple elements, has a zero three-sum",
                actualResult == expectedResult);
    }

    @Test
    public final void testMultiElementArray3() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 2, -1, 4, 5 };
        boolean expectedResult = true;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with multiple elements, has a zero three-sum with duplicates",
                actualResult == expectedResult);
    }

}
