// Common methods for sorting algorithms
package sorting;

import java.util.*;

public class SortingAlgorithmTemplateMethods<T extends Comparable<T>> {

     // Determine whether one item is less than the other item
    public boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    // Swap one value with another value
    public void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Determine whether an array is sorted or not
    public boolean isSorted(T[] a) {

        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }


    // Print items within list
    public void displayItems(T[] array) {

        System.out.println("Array contains the following: ");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Place array data into a List
    public List<T> convertArrayToList(T[] array) {

        List<T> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }

    // Find maximum value in list
    public T maxValue(List<T> list) {

        T maxValue = list.get(0); // initialize max value
        for (T value : list) {

            if (value.compareTo(maxValue) > 0) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    // Find minimum value in list
    public T minValue(List<T> list) {

        T minValue = list.get(0); // initialize min value
        for (T value : list) {

            if (value.compareTo(minValue) < 0) {
                minValue = value;
            }
        }
        return minValue;
    }


    // Find number of occurrence of an element in a List
    public int numberOfElementOccurrencesInList(List<T> list, T value) {

        int numberOfOccurrences = 0;
        for (T element : list) {

            if (element == value) {
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }

    // Remove duplicates in list
    public List<T> removeDuplicates(List<T> list) {

        // Create a new LinkedHashSet

        // Add the elements to set
        Set<T> set = new LinkedHashSet<>(list);

        // Clear the list
        list.clear();

        // add the elements of set
        // with no duplicates to the list
        list.addAll(set);

        // return the list
        return list;
    }

    // List information
    public void listInformation(List<T> list) {

        System.out.println("Minimum element in list is " + minValue(list));
        System.out.println("Maximum element in list is " + maxValue(list));

        // Remove duplicates from a list
        //List<T> uniqueElementList = removeDuplicates(list);

        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            int count = numberOfElementOccurrencesInList(list, element);
            System.out.println(element + ": " + count);
        }
    }



}
