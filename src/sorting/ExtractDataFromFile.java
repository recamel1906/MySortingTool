// Class used to extract data from a file
package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractDataFromFile {

    // Store data from file as String
    public static String readFileAsString(String fileName) {

        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        }
        catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
        return ""; // keep compiler happy
    }

    // Extract String data from file and return as array
    public String[] extractStringDataFromFile(File file) throws FileNotFoundException {

        Scanner sc = new Scanner(file);
        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] a = new String[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            a[i] = lines.get(i);
        }
        return a;
    }


    // Extract integer data from file and return as array
    public Integer[] extractIntegerDataFromFile(File file) throws FileNotFoundException {

        Scanner sc = new Scanner(file);
        List<Integer> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextInt());
        }

        Integer[] a = new Integer[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            a[i] = lines.get(i);
        }
        return a;
    }

    // Extract long data from file and return as array
    public Long[] extractLongIntegerDataFromFile(File file) throws FileNotFoundException {

        Scanner sc = new Scanner(file);
        List<Long> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLong());
        }

        Long[] a = new Long[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            a[i] = lines.get(i);
        }
        return a;
    }

    // Extract doubles data from file and return as array
    public Double[] extractDoubleDataFromFile(File file) throws FileNotFoundException {

        Scanner sc = new Scanner(file);
        List<Double> lines = new ArrayList<>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextDouble());
        }

        Double[] a = new Double[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            a[i] = lines.get(i);
        }
        return a;
    }


}
