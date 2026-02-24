package Operations;
import java.util.Arrays;

public class ArrayInsertion {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int newElement = 99;
        int index = 2;

        int[] newArr = new int[arr.length + 1];

        // Insert at index
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == index) {
                newArr[i] = newElement;
            } else {
                newArr[i] = arr[j++];
            }
        }

        System.out.println(Arrays.toString(newArr));
    }
}