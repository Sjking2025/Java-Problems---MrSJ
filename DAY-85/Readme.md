# 🔢 Sort Array by Number of 1 Bits (LeetCode 1356)

## 🧩 Problem Statement

Given an integer array `arr`, sort the integers in ascending order by:

1. The number of **1’s in their binary representation**
2. If two numbers have the same number of 1’s, then sort them numerically in ascending order.

---

## 📌 Example

Input:

```
arr = [1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1]
```

Output:

```
[1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]
```

---

# 💡 Intuition

Instead of manually converting each number to binary and counting 1’s:

* Java already provides a built-in method:

```
Integer.bitCount(n)
```

This returns the number of set bits (1’s) in the binary form of `n`.

So we use a **custom comparator** inside `Arrays.sort()`.

---

# ⚙️ Approach

### Step 1:

Convert primitive `int[]` to `Integer[]`
(Because custom comparator works only with objects)

### Step 2:

Use `Arrays.sort()` with comparator:

* First compare based on `Integer.bitCount(a)`
* If equal → compare normally (`a - b`)

### Step 3:

Copy sorted result back to original array.

---

# 🧠 Comparator Logic Explained

```java
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
```

### What happens here?

* `Integer.bitCount(a)` → counts number of 1’s in binary of `a`
* If counts are different → smaller count comes first
* If counts are same → smaller number comes first

---

# 🖥️ Full Java Code

```java
import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {

        // Convert int[] to Integer[]
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // Sort using custom comparator
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            if (countA != countB) {
                return countA - countB;
            }

            return a - b;
        });

        // Copy back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}
```

---

# 🔍 Dry Run

Let’s take:

```
arr = [5, 3, 7]
```

### Step 1: Binary + Count

| Number | Binary | 1's Count |
| ------ | ------ | --------- |
| 5      | 101    | 2         |
| 3      | 011    | 2         |
| 7      | 111    | 3         |

---

### Step 2: Sorting Logic

Comparator calls (internally by Java):

1. Compare 5 and 3

   * Both have 2 ones
   * Compare numerically → 3 comes first

2. Compare 7 and 5

   * 7 has 3 ones
   * 5 has 2 ones
   * 5 comes first

---

### Final Sorted Output:

```
[3, 5, 7]
```

---

# 🧠 Key Learning

✅ Learned how to use custom comparator
✅ Understood how Java internally calls comparator multiple times
✅ Learned about `Integer.bitCount()`
✅ Realized sorting logic can be simplified using built-in methods
✅ Understood importance of tie-breaking condition

---

# ⚡ Time & Space Complexity

### Time Complexity:

```
O(n log n)
```

(Because of sorting)

### Space Complexity:

```
O(n)
```

(Used temporary Integer array)

---

# 🚀 Overall Flow Summary

1. Convert array → Integer[]
2. Sort using bitCount comparator
3. Handle tie case using numeric compare
4. Copy back to original array
5. Return result

---

# 📚 Final Thought

Initially tried manually comparing bit counts with loops.
Then realized Java already provides optimized built-in support.

This problem improved:

* Comparator understanding
* Sorting intuition
* Binary manipulation knowledge
* Debugging mindset

