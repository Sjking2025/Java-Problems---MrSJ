package Operations.Searching;
import java.util.Arrays;

public class SearchDemo {

    // Linear Search
    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // index found
            }
        }
        return -1;
    }

    // Binary Search (array must be sorted)
    static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {7, 2, 9, 4, 1};
        int key = 4;

        // Linear Search
        int linearResult = linearSearch(arr, key);
        System.out.println("Linear Search Index: " + linearResult);

        // Sort before Binary Search
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        int binaryResult = binarySearch(arr, key);
        System.out.println("Binary Search Index: " + binaryResult);
    }
}