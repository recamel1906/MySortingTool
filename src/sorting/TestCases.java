// Test Cases used to test sorting algorithms
package sorting;
import java.security.SecureRandom;

public class TestCases {

    // Generate random doubles values in an array
    public static Double[] randomDoublesGenerator(int sizeArray, int min, int max) {

        // Initialize secure random number object
        SecureRandom random = new SecureRandom();

        // Generate array of random numbers
        double[] x = random.doubles(sizeArray, min, max).toArray();

        // convert to Double[] type
        Double[] array = new Double[x.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = x[i];
        }
        return array;
    }

    // Generate integer values in an array
    public static Integer[] randomIntegersGenerator(int sizeArray, int min, int max) {

        // Initialize secure random number object
        SecureRandom random = new SecureRandom();

        // Generate array of random numbers
        int[] x = random.ints(sizeArray, min, max).toArray();

        // convert to Integer[] type
        Integer[] array = new Integer[x.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = x[i];
        }
        return array;
    }

    // Test Case 1 - Integers
    public static void TestCaseIntegers(String algorithmType, int sizeArray, int min, int max) {

        // Set up an array
        Integer[] x = randomIntegersGenerator(sizeArray, min, max);

        SortingAlgorithmTemplateMethods<Integer> sortAlgTempMethods =
                new SortingAlgorithmTemplateMethods<>();

        // Show original array
        sortAlgTempMethods.displayItems(x);
        System.out.println();

        // Sort array
        SortingAlgorithms<Integer> sortingAlgorithms = new SortingAlgorithms<>();
        sortingAlgorithms.sortingOperation(algorithmType, x);

    }

    // Test Case 2 - Doubles
    public static void TestCaseDoubles(String algorithmType, int sizeArray, int min, int max) {

        // Set up an array
        Double[] x = randomDoublesGenerator(sizeArray, min, max);

        SortingAlgorithmTemplateMethods<Double> sortAlgTempMethods =
                new SortingAlgorithmTemplateMethods<>();

        // Show original array
        sortAlgTempMethods.displayItems(x);
        System.out.println();

        // Sort array
        SortingAlgorithms<Double> sortingAlgorithms = new SortingAlgorithms<>();
        sortingAlgorithms.sortingOperation(algorithmType, x);

        //        // Convert array to list
//        SortingAlgorithmTemplateMethods<Integer> sortingAlgorithmTemplateMethods =
//                new SortingAlgorithmTemplateMethods<>();
//
//        List<Integer> list = sortingAlgorithmTemplateMethods.convertArrayToList(x);
//        sortingAlgorithmTemplateMethods.listInformation(list);
    }




}
