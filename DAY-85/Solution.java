import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        // Convert primitive array to Integer array
        Integer[] temp = new Integer[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        
        // Custom sorting
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            // First condition: sort by number of 1 bits
            if (countA != countB) {
                return countA - countB;
            }
            
            // Second condition: if equal, sort numerically
            return a - b;
        });
        
        // Convert back to primitive array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        
        return arr;
    }
}