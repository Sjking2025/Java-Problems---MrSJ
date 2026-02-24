package Operations.Searching;
public class ArraySearch {
    public static void main(String[] args) {

        int[] arr = {4, 7, 1, 9, 3};
        int key = 9;

        boolean found = false;

        for (int num : arr) {
            if (num == key) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "Element found" : "Not found");
    }
}