package exercise1;

/**
 * Main class of the Java program.
 *
 */
import java.util.Arrays;

public class Main {

    /*
     * Print the contents of an int array
     * @param array is the array to print
     */
    public static String toString(int[] array) {
        if (array == null) {
            return null;
        }
        StringBuffer outStrBuf = new StringBuffer();
        outStrBuf.append("{ ");
        for (int x : array) {
            outStrBuf.append(x);
            outStrBuf.append(" ");
        }
        outStrBuf.append("}");
        return outStrBuf.toString();
    }

    public static void main(String[] args) {

        System.out.println("Zero-Sum Three Sums");

        // set up an array & call the function to find the maximum element
        int[] myArray = new int[] { 3, 4, -2, 1, 10, 9, 1, -1 };
        boolean threeSum = ArrayThreeSum.check3Sum(myArray);

        if (threeSum) {
            System.out.println("One can select three elements from "+toString(myArray)+" that sum to 0.");
        }
        else {
            System.out.println("One cannot select three elements from "+toString(myArray)+" that sum to 0.");
        }
    }
}
