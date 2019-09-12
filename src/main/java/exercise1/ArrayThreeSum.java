package exercise1;

public class ArrayThreeSum {
    /**
     * Checks if the sum of three numbers in an array is 0.
     * An array element can be picked more than once.
     * @param input the array to search in
     * @return true if the sum of three numbers chosen from input can be 0,
     *          and false otherwise.
     */
    public static boolean check3Sum(int[] input) {
        // TODO: Implement this method
        for (int x = 0; x< input.length; x++){
            for (int j = 0; j< input.length; j++){
                for (int k = 0; k<input.length; k++) {
                    if (input[x] + input[j] + input[k]==0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the sum of three numbers in an array is 0.
     * An array element can be picked at most once.
     * @param input the array to search in
     * @return true if the sum of three numbers in input can be 0,
     *          and false otherwise.
     */
    public static boolean check3Sum_noDups(int[] input) {
        // TODO: Fix this method
        for (int x = 0; x< input.length - 2; x++){
            for (int j = x+1; j< input.length -1; j++){
                for (int k = j+1; k<input.length; k++) {
                    if (input[x] + input[j] + input[k]==0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

