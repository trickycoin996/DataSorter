import java.util.ArrayList;

public class BubbleSort {
    public static SortResult sort(ArrayList<Integer> data) {
        ArrayList<Integer> arr = new ArrayList<>(data);
        int steps = 0;
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                steps++;
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    steps++;
                }
            }
        }

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000.0; // ms

        return new SortResult(arr, steps, elapsedTime);
    }
}
