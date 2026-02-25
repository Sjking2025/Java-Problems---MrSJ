# LeetCode 1356 — Sort Integers by The Number of 1 Bits

## 📝 Problem Statement

Given an integer array `arr`, sort the integers in ascending order based on the number of `1`s in their binary representation.

If two or more integers have the same number of `1`s, then sort them in ascending numerical order.

Return the array after sorting it.

---

## 📌 Example 1

**Input:**

```
arr = [0,1,2,3,4,5,6,7,8]
```

**Output:**

```
[0,1,2,4,8,3,5,6,7]
```

**Explanation:**

| Number | Binary | Count of 1s |
| ------ | ------ | ----------- |
| 0      | 0      | 0           |
| 1      | 1      | 1           |
| 2      | 10     | 1           |
| 4      | 100    | 1           |
| 8      | 1000   | 1           |
| 3      | 11     | 2           |
| 5      | 101    | 2           |
| 6      | 110    | 2           |
| 7      | 111    | 3           |

Sorted first by bit count, then by numeric value.

---

## 📌 Example 2

**Input:**

```
arr = [1024,512,256,128,64,32,16,8,4,2,1]
```

**Output:**

```
[1,2,4,8,16,32,64,128,256,512,1024]
```

All numbers contain exactly one `1` in their binary representation, so they are sorted normally in ascending order.

---

# 💡 Key Insight

This is a **custom sorting problem**.

We are not sorting based on the binary number itself.
We are sorting based on a **property** of the number — the count of `1` bits.

Sorting Rule:

1. Primary condition → Number of 1 bits (ascending)
2. Secondary condition → Numeric value (ascending)

---

# 🪜 Approach

### Step 1: Convert `int[]` to `Integer[]`

`Arrays.sort()` with a custom comparator works only with object arrays, not primitive arrays.

### Step 2: Use `Integer.bitCount()`

This method returns the number of `1`s in the binary representation of a number.

Example:

```
Integer.bitCount(5) → 2
(5 = 101 in binary)
```

### Step 3: Define Custom Comparator

* If bit counts are different → sort by bit count
* If bit counts are equal → sort numerically

### Step 4: Convert back to `int[]`

---

# 💻 Java Implementation

```java
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
```

---

# 🔎 Dry Run (Step-by-Step Flow)

### Input:

```
[3, 4, 2]
```

Binary + Bit Count:

| Number | Binary | 1s |
| ------ | ------ | -- |
| 3      | 11     | 2  |
| 4      | 100    | 1  |
| 2      | 10     | 1  |

---

### Comparator Calls (Simulated)

### Compare (3, 4)

```
countA = 2
countB = 1
2 - 1 = 1 (positive)
```

→ 4 comes before 3
Array becomes: `[4, 3, 2]`

---

### Compare (3, 2)

```
countA = 2
countB = 1
2 - 1 = 1 (positive)
```

→ 2 comes before 3
Array becomes: `[4, 2, 3]`

---

### Compare (4, 2)

```
countA = 1
countB = 1
Equal bit count → compare numerically
4 - 2 = 2 (positive)
```

→ 2 comes before 4
Final Array: `[2, 4, 3]`

---

# 📊 Time and Space Complexity

**Time Complexity:**
`O(n log n)` — due to sorting

**Space Complexity:**
`O(n)` — for using Integer array

---

# 🎯 Mistakes I Initially Made

* Tried converting numbers into binary strings unnecessarily
* Treated it like a max-finding problem
* Overcomplicated the sorting logic
* Forgot that this is a rule-based ordering problem

---

# 📚 What I Learned

* Custom sorting requires defining a comparison rule
* Comparator return values control ordering:

  * Negative → first comes before second
  * Positive → second comes before first
  * Zero → equal
* `Integer.bitCount()` simplifies bit counting
* Avoid overengineering simple problems

---

# 🚀 Final Reflection

This problem strengthened my understanding of:

* Custom comparators
* Bit manipulation fundamentals
* Sorting by multiple conditions
* Clean problem analysis before coding

Small problem. Big conceptual clarity.
