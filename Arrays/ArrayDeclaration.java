public class ArrayDeclaration {
    public static void main(String[] args) {

        // Declare and initialize directly
        int[] arr = {10, 20, 30, 40, 50};

        // Declare with size and fill using loop
        int[] arr2 = new int[5];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 10;
        }

        System.out.println("Array initialized successfully");
    }
}