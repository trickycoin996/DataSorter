import java.util.ArrayList;

public class QuickSort {

    public static SortResult sort(ArrayList<Integer> data) {
        ArrayList<Integer> arr = new ArrayList<>(data);
        Counter counter = new Counter();
        long startTime = System.nanoTime();

        quickSort(arr, 0, arr.size() - 1, counter);

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000.0;
        return new SortResult(arr, counter.steps, elapsedTime);
    }

    private static void quickSort(ArrayList<Integer> arr, int low, int high, Counter counter) {
        if (low < high) {
            int pi = partition(arr, low, high, counter);
            quickSort(arr, low, pi - 1, counter);
            quickSort(arr, pi + 1, high, counter);
        }
    }

    private static int partition(ArrayList<Integer> arr, int low, int high, Counter counter) {
        int pivot = arr.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            counter.steps++;
            if (arr.get(j) <= pivot) {
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    static class Counter {
        int steps = 0;
    }
}
