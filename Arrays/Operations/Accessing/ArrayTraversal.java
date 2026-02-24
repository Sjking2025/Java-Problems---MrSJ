package Operations.Accessing;
public class ArrayTraversal {
    public static void main(String[] args) {

        int[] arr = {5, 10, 15, 20};

        // Access element
        System.out.println("First element: " + arr[0]);

        // Traverse
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}