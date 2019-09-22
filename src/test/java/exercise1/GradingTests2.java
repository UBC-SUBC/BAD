package exercise1;

import static org.junit.Assert.*;
import org.junit.Test;


public class GradingTests2 {

    @Test
    public final void testSingleElementArray1() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 7 };
        boolean expectedResult = false;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum_noDups(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with one element, does not have a zero three-sum",
                actualResult == expectedResult);
    }

    @Test
    public final void testSingleElementArray2() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 0 };
        boolean expectedResult = false;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum_noDups(testInput);

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
        boolean actualResult = ArrayThreeSum.check3Sum_noDups(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Empty array",
                actualResult == expectedResult);
    }

    @Test
    public final void testMultiElementArray1() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 2, 2, 5, 7, 1, 6 };
        boolean expectedResult = false;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum_noDups(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with multiple element, does not have a zero three-sum",
                actualResult == expectedResult);
    }

    @Test
    public final void testMultiElementArray2() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 3, 4, -2, 1, 10, 9, 1, -1 };
        boolean expectedResult = true;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum_noDups(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with multiple elements, has a zero three-sum",
                actualResult == expectedResult);
    }

    @Test
    public final void testMultiElementArray3() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 4, -2, 7 };
        boolean expectedResult = false;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum_noDups(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with multiple elements, does not have a zero three-sum",
                actualResult == expectedResult);
    }

    @Test
    public final void testMultiElementArray4() {

        // we define some test input and what result we would expect
        int[] testInput = new int[] { 2, 3, 9, -4, -1, 0, -7, 5, -2 };
        boolean expectedResult = true;

        // call the findMaximumElement function
        // with test input
        boolean actualResult = ArrayThreeSum.check3Sum_noDups(testInput);

        // the actualResult value should be the same as the expectedResult value
        assertTrue("Array with multiple elements, has a zero three-sum",
                actualResult == expectedResult);
    }

}
