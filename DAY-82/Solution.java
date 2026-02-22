class Solution {

    public int binaryGap(int n) {

        // convert to binary string
        //Integer wrapper class of Int 
        String binary = Integer.toBinaryString(n);

        int maxDistance = 0;
        int prevIndex = -1;

        // iterate through bits array
        for (int i = 0; i < binary.length(); i++) {

            if (binary.charAt(i) == '1') {

                // if we already saw a 1 before
                if (prevIndex != -1) {
                    int distance = i - prevIndex;

                    if (distance > maxDistance) {
                        maxDistance = distance;
                    }
                }

                // update previous index
                prevIndex = i;
            }
        }

        return maxDistance;
    }
}