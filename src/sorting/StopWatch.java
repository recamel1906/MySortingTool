// Abstract data type to mimic elapsed time for a program to complete
package sorting;

public class StopWatch {

    // Start time variable
    private final long start;

    // Constructor
    public StopWatch() {
        start = System.currentTimeMillis();
    }

    // Compute elapsed time
    public double elapsedTime() {

        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
