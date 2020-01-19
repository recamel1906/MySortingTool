// Class used to contain different sorting algorithms
package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingAlgorithms<T extends Comparable<T>> extends SortingAlgorithmTemplateMethods<T> {

    // Selection Sort algorithm
    private void selectionSort(T[] array) {

        // Sort array into increasing order
        int n = array.length;
        for (int i= 0; i < n; i++) {

            // Exchange a[i] with smallest entry in a[i],...,a[n-1]
            int min = i; // index of minimal entry
            for (int j = i + 1; j < n; j++) {

                if (less(array[j], array[min])) {
                    min = j;
                }
                exchange(array, i, min);
            }
        }

    }

    // Insertion Sort algorithm
    private void insertionSort(T[] array) {

        // Sort array in increasing order
        int n = array.length;
        for (int i = 1; i < n; i++) {

            // Insert a[i] among a[i-1], a[i-2], a[i-3],...
            for (int j = i; j > 0 && less(array[j], array[j-1]); j--) {
                exchange(array, j, j-1);
            }
        }
    }

    // Shell Sort algorithm
    private void shellSort(T[] array) {

        // Sort array in increasing order
        int n = array.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {

            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(array[j], array[j-h]); j -= h) {
                    exchange(array, j, j - h);
                }
            }
            h = h/3;
        }
    }


    // Merge Sort algorithm
    private void mergeSort(T[] array, int leftIncl, int rightExcl) {

        // the base case: if subarray contains <= 1 items, stop dividing because it's sorted
        if (rightExcl <= leftIncl + 1) {
            return;
        }

        /* divide: calculate the index of the middle element */
        int middle = leftIncl + (rightExcl - leftIncl) / 2;

        mergeSort(array, leftIncl, middle);  // conquer: sort the left subarray
        mergeSort(array, middle, rightExcl); // conquer: sort the right subarray

        /* combine: merge both sorted subarrays into sorted one */
        merge(array, leftIncl, middle, rightExcl);
    }

    // Inner details of merge sort algorithm
    @SuppressWarnings("unchecked") private void merge(T[] array, int left, int middle, int right) {
        int i = left;   // index for the left subarray
        int j = middle; // index for the right subarray
        int k = 0;      // index for the temp subarray

        //@SuppressWarnings (value="unchecked")
        Object[] temp = new Object[right - left]; // temporary array for merging

        /* get the next lesser element from one of two subarrays
       and then insert it in the array until one of the subarrays is empty */
        while (i < middle && j < right) {
            if (array[i].compareTo(array[j]) <= 0) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        /* insert all the remaining elements of the left subarray in the array */
        for (;i < middle; i++, k++) {
            temp[k] = array[i];
        }

        /* insert all the remaining elements of the right subarray in the array */
        for (;j < right; j++, k++) {
            temp[k] = array[j];
        }

        /* effective copying elements from temp to array */
        System.arraycopy(temp, 0, array, left, temp.length);
    }


    // Compute time to complete a sorting operation
    public void sortingOperation(String algorithmType, T[] array) {

        StopWatch timer = new StopWatch();

        if (algorithmType.equals("Selection")) {
            selectionSort(array);
            System.out.println("After sorting...");
            displayItems(array);
            System.out.println();
        }
        if (algorithmType.equals("Insertion")) {
            insertionSort(array);
            System.out.println("After sorting...");
            displayItems(array);
            System.out.println();
        }
        if (algorithmType.equals("Shell")) {
            shellSort(array);
            System.out.println("After sorting...");
            displayItems(array);
            System.out.println();
        }
        if (algorithmType.equals("Merge")) {
            mergeSort(array, 0, array.length);
            System.out.println("After sorting...");
            displayItems(array);
            System.out.println();
        }
        double elapsedTime = timer.elapsedTime(); // calculates elapsed time in seconds
        System.out.printf("Time to complete " + algorithmType + " sort: %.3f seconds%n",  elapsedTime);
    }







}
