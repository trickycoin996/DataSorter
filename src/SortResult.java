import java.util.ArrayList;

public class SortResult {
    ArrayList<Integer> sortedData;
    int steps;
    double timeMs;

    public SortResult(ArrayList<Integer> sortedData, int steps, double timeMs) {
        this.sortedData = sortedData;
        this.steps = steps;
        this.timeMs = timeMs;
    }
}
