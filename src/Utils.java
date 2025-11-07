import java.util.*;

public class Utils {

    public static ArrayList<Integer> getManualInput(Scanner sc) {
        System.out.println("Enter numbers separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        ArrayList<Integer> data = new ArrayList<>();
        for (String s : input) {
            try {
                data.add(Integer.parseInt(s.trim()));
            } catch (NumberFormatException ignored) {}
        }
        return data;
    }

    public static ArrayList<Integer> generateRandomData(int size) {
        ArrayList<Integer> data = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            data.add(rand.nextInt(100));
        }
        return data;
    }

    public static void showComparison(Map<String, SortResult> results) {
        System.out.println("\n--- Sorting Performance Comparison ---");
        System.out.printf("%-15s %-15s %-15s%n", "Algorithm", "Steps", "Time (ms)");
        System.out.println("-------------------------------------------");

        for (var entry : results.entrySet()) {
            SortResult r = entry.getValue();
            System.out.printf("%-15s %-15d %-15.4f%n", entry.getKey(), r.steps, r.timeMs);
        }
        System.out.println("-------------------------------------------");
    }
}
