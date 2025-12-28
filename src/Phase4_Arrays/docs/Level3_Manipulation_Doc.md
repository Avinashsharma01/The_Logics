# Phase 4 - Arrays | Level 3: Manipulation (Q21-Q30)

## Overview
Transforming arrays: reversing, rotating, copying, and modifying elements.

---

## Q21: Reverse an Array

**Problem:** Reverse elements in-place.

**Logic (Detailed):**

**Two-pointer technique:**
- Start pointer at beginning (index 0)
- End pointer at last element (index n-1)
- Swap elements and move pointers toward center

```
start = 0, end = n-1

while start < end:
    swap(arr[start], arr[end])
    start++
    end--
```

**Why `start < end` (not `<=`):**
- When pointers meet/cross, all swaps done
- If odd length, middle element stays in place

**Visualization for arr = [1, 2, 3, 4, 5]:**
```
Initial:  [1, 2, 3, 4, 5]
           ↑           ↑
           s           e

Step 1:   [5, 2, 3, 4, 1]  (swap 1,5)
              ↑     ↑
              s     e

Step 2:   [5, 4, 3, 2, 1]  (swap 2,4)
                 ↑
               s=e (stop!)

Result:   [5, 4, 3, 2, 1]
```

**Time:** O(n/2) = O(n)
**Space:** O(1) - in-place, no extra array

---

## Q22: Swap Two Elements

**Problem:** Swap elements at given indices.

**Logic (Detailed):**

Classic three-variable swap:

```
temp = arr[i]
arr[i] = arr[j]
arr[j] = temp
```

**Step-by-step:**
```
Before: arr[i]=10, arr[j]=50

temp = arr[i] = 10        | temp=10, arr[i]=10
arr[i] = arr[j] = 50      | temp=10, arr[i]=50
arr[j] = temp = 10        | arr[j]=10

After: arr[i]=50, arr[j]=10
```

**Why can't we do direct swap?**
```
arr[i] = arr[j]  // arr[i] becomes 50
arr[j] = arr[i]  // arr[j] becomes 50 (we lost original arr[i]!)
```

**Alternative without temp (XOR swap):**
```
arr[i] = arr[i] ^ arr[j]
arr[j] = arr[i] ^ arr[j]
arr[i] = arr[i] ^ arr[j]
```

---

## Q23: Rotate Array Left by K Positions

**Problem:** Move first k elements to end.

**Logic (Detailed):**

**Reversal Algorithm (elegant, O(1) space):**
1. Reverse first k elements
2. Reverse remaining elements  
3. Reverse entire array

```
Original: [1, 2, 3, 4, 5], k=2

Step 1: Reverse [0, k-1] = [0,1]
        [2, 1, 3, 4, 5]
        
Step 2: Reverse [k, n-1] = [2,4]
        [2, 1, 5, 4, 3]
        
Step 3: Reverse [0, n-1] = [0,4]
        [3, 4, 5, 1, 2]

Result: [3, 4, 5, 1, 2] ✓
```

**Why this works mathematically:**
```
Original:    [A, B] where A = first k, B = rest
After rev A: [A', B]
After rev B: [A', B']
After rev all: (A'B')' = BA ✓
```

**Handle k > n:**
```
k = k % n  // Rotation of n is same as 0
```

---

## Q24: Rotate Array Right by K Positions

**Problem:** Move last k elements to front.

**Logic (Detailed):**

**Reversal Algorithm for right rotation:**
1. Reverse last k elements
2. Reverse first n-k elements
3. Reverse entire array

```
Original: [1, 2, 3, 4, 5], k=2

Step 1: Reverse [n-k, n-1] = [3,4]
        [1, 2, 3, 5, 4]
        
Step 2: Reverse [0, n-k-1] = [0,2]
        [3, 2, 1, 5, 4]
        
Step 3: Reverse [0, n-1] = [0,4]
        [4, 5, 1, 2, 3]

Result: [4, 5, 1, 2, 3] ✓
```

**Relationship between left and right rotation:**
```
Right rotate by k = Left rotate by (n-k)
```

---

## Q25: Copy Array

**Problem:** Create duplicate of array.

**Logic (Detailed):**

**Multiple methods in Java:**

**Method 1: Manual loop**
```java
int[] copy = new int[arr.length];
for (int i = 0; i < arr.length; i++) {
    copy[i] = arr[i];
}
```

**Method 2: Arrays.copyOf()**
```java
int[] copy = Arrays.copyOf(arr, arr.length);
// Can also copy partial: Arrays.copyOf(arr, 3)
```

**Method 3: clone()**
```java
int[] copy = arr.clone();
```

**Method 4: System.arraycopy()**
```java
int[] copy = new int[arr.length];
System.arraycopy(arr, 0, copy, 0, arr.length);
// (source, srcPos, dest, destPos, length)
```

**Why can't we just do `copy = arr`?**
```java
int[] copy = arr;  // WRONG!
// Both variables point to SAME array in memory
// Modifying copy[0] changes arr[0] too!
```

---

## Q26: Move Zeros to End

**Problem:** Move all zeros to end, maintain order of non-zeros.

**Logic (Detailed):**

**Two-pointer approach:**
- index: position for next non-zero
- Traverse array, copy non-zeros to index position
- Fill remaining with zeros

```
index = 0

// Phase 1: Move non-zeros forward
for i from 0 to n-1:
    if arr[i] != 0:
        arr[index++] = arr[i]

// Phase 2: Fill remaining with zeros
while index < n:
    arr[index++] = 0
```

**Trace for arr = [0, 1, 0, 3, 12]:**
```
Phase 1:
i=0: 0==0, skip
i=1: 1≠0, arr[0]=1, index=1
i=2: 0==0, skip
i=3: 3≠0, arr[1]=3, index=2
i=4: 12≠0, arr[2]=12, index=3

After Phase 1: [1, 3, 12, 3, 12], index=3

Phase 2:
arr[3] = 0, index=4
arr[4] = 0, index=5

Result: [1, 3, 12, 0, 0] ✓
```

---

## Q27: Separate Even and Odd

**Problem:** All evens first, then odds.

**Logic (Detailed):**

**Two-pass approach:**
1. First pass: copy all evens
2. Second pass: copy all odds

```
result = new array[n]
index = 0

// First pass: evens
for num in arr:
    if num % 2 == 0:
        result[index++] = num

// Second pass: odds
for num in arr:
    if num % 2 != 0:
        result[index++] = num
```

**Trace for arr = [3, 8, 5, 2, 9, 4]:**
```
Pass 1 (evens): 8, 2, 4 → result = [8, 2, 4, _, _, _]
Pass 2 (odds): 3, 5, 9 → result = [8, 2, 4, 3, 5, 9]
```

---

## Q28: Remove Duplicates from Sorted Array

**Problem:** Remove duplicates in-place, return new length.

**Logic (Detailed):**

**Key insight:** In sorted array, duplicates are adjacent!

```
j = 1  // Index for unique elements

for i from 1 to n-1:
    if arr[i] != arr[i-1]:  // Different from previous
        arr[j++] = arr[i]   // It's unique, keep it

return j  // New length
```

**Trace for arr = [1, 1, 2, 2, 2, 3, 4, 4]:**
```
j=1 (arr[0]=1 is always unique)

i=1: arr[1]=1 == arr[0]=1? YES, skip
i=2: arr[2]=2 ≠ arr[1]=1? NO, arr[1]=2, j=2
i=3: arr[3]=2 == arr[2]=2? YES, skip
i=4: arr[4]=2 == arr[3]=2? YES, skip
i=5: arr[5]=3 ≠ arr[4]=2? NO, arr[2]=3, j=3
i=6: arr[6]=4 ≠ arr[5]=3? NO, arr[3]=4, j=4
i=7: arr[7]=4 == arr[6]=4? YES, skip

Result: [1, 2, 3, 4, ...], length = 4
```

**Time:** O(n), **Space:** O(1)

---

## Q29: Insert Element at Position

**Problem:** Insert new element at given index.

**Logic (Detailed):**

Arrays have fixed size, so:
1. Create new array of size n+1
2. Copy elements before position
3. Insert new element
4. Copy remaining elements

```
newArr = new array[n+1]

// Copy before position
for i from 0 to pos-1:
    newArr[i] = arr[i]

// Insert element
newArr[pos] = element

// Copy after position (shifted by 1)
for i from pos to n-1:
    newArr[i+1] = arr[i]
```

**Trace for arr = [1, 2, 4, 5], insert 3 at pos=2:**
```
Copy [0,1]: newArr = [1, 2, _, _, _]
Insert at 2: newArr = [1, 2, 3, _, _]
Copy [2,3] shifted: newArr = [1, 2, 3, 4, 5]
```

**Visual:**
```
Original: [1, 2, 4, 5]
               ↓ insert 3 at position 2
Result:   [1, 2, 3, 4, 5]
```

---

## Q30: Delete Element at Position

**Problem:** Remove element at given index.

**Logic (Detailed):**

1. Create new array of size n-1
2. Copy elements before position
3. Skip the element to delete
4. Copy remaining elements (shifted back)

```
newArr = new array[n-1]

// Copy before position
for i from 0 to pos-1:
    newArr[i] = arr[i]

// Skip position, copy rest (shifted back)
for i from pos+1 to n-1:
    newArr[i-1] = arr[i]
```

**Trace for arr = [1, 2, 3, 4, 5], delete at pos=2:**
```
Copy [0,1]: newArr = [1, 2, _, _]
Skip position 2
Copy [3,4] shifted: newArr = [1, 2, 4, 5]
```

**Visual:**
```
Original: [1, 2, 3, 4, 5]
               ↓ delete at position 2
Result:   [1, 2, 4, 5]
```

**Alternative - shift in-place:**
```
for i from pos to n-2:
    arr[i] = arr[i+1]
// Logically, array now has n-1 valid elements
```
