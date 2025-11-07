import java.util.*;

public class Menu {
    private ArrayList<Integer> data = new ArrayList<>();
    private Map<String, SortResult> results = new LinkedHashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    data = Utils.getManualInput(sc);
                    System.out.println("Data loaded: " + data);
                    break;
                case "2":
                    System.out.print("Enter number of elements: ");
                    int size = Integer.parseInt(sc.nextLine());
                    data = Utils.generateRandomData(size);
                    System.out.println("Generated data: " + data);
                    break;
                case "3":
                    performSort("Bubble Sort", BubbleSort.sort(data));
                    break;
                case "4":
                    performSort("Merge Sort", MergeSort.sort(data));
                    break;
                case "5":
                    performSort("Quick Sort", QuickSort.sort(data));
                    break;
                case "6":
                    if (results.isEmpty()) System.out.println("No results yet.");
                    else Utils.showComparison(results);
                    break;
                case "7":
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void performSort(String name, SortResult result) {
        if (data.isEmpty()) {
            System.out.println("No data loaded. Please enter or generate data first.");
            return;
        }
        results.put(name, result);
        System.out.println(name + " Result: " + result.sortedData);
        System.out.printf("Steps: %d, Time: %.4fms%n", result.steps, result.timeMs);
    }
}
