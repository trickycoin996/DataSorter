import java.util.ArrayList;

public class MergeSort {

    public static SortResult sort(ArrayList<Integer> data) {
        ArrayList<Integer> arr = new ArrayList<>(data);
        Counter counter = new Counter();
        long startTime = System.nanoTime();

        ArrayList<Integer> sorted = mergeSort(arr, counter);

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000.0;
        return new SortResult(sorted, counter.steps, elapsedTime);
    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> arr, Counter counter) {
        if (arr.size() <= 1) return arr;

        int mid = arr.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(mid, arr.size()));

        left = mergeSort(left, counter);
        right = mergeSort(right, counter);

        return merge(left, right, counter);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, Counter counter) {
        ArrayList<Integer> result = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            counter.steps++;
            if (left.get(0) <= right.get(0)) {
                result.add(left.remove(0));
            } else {
                result.add(right.remove(0));
            }
        }

        result.addAll(left);
        result.addAll(right);
        return result;
    }

    static class Counter {
        int steps = 0;
    }
}
