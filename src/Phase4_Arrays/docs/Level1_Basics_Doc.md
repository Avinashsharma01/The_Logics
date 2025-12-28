# Phase 4 - Arrays | Level 1: Basics (Q1-Q10)

## Overview
Fundamental array operations: input, output, traversal, and basic computations.

---

## Q1: Input and Print Array

**Problem:** Read array elements and display them.

**Logic (Detailed):**

Arrays are contiguous memory blocks storing elements of the same type. To work with arrays:

1. **Declaration:** Create array with specified size
   - `int[] arr = new int[n];` → allocates n slots in memory
   - All slots initialized to 0 for int arrays

2. **Input phase:** Fill each slot using index
   - Index runs from 0 to n-1 (0-indexed)
   - `arr[i] = value` assigns value to position i

3. **Output phase:** Read each slot in sequence
   - Can use traditional for-loop with index
   - Can use enhanced for-each loop (cleaner)

**Three printing methods:**
```
Method 1 - Traditional for loop:
for (int i = 0; i < arr.length; i++)
    print arr[i]

Method 2 - Enhanced for-each:
for (int element : arr)
    print element
    
Method 3 - Arrays.toString():
print Arrays.toString(arr)  → "[1, 2, 3, 4, 5]"
```

**Memory visualization:**
```
Array: arr = new int[5]

Index:    [0]  [1]  [2]  [3]  [4]
Values:    10   20   30   40   50
Address:  100  104  108  112  116  (each int = 4 bytes)
```

---

## Q2: Sum of Array Elements

**Problem:** Calculate sum of all elements.

**Logic (Detailed):**

The **accumulator pattern** - start with 0, add each element:

```
sum = 0
for each element in array:
    sum = sum + element
```

**Why initialize sum to 0:**
- 0 is the identity element for addition (x + 0 = x)
- Starting anywhere else would corrupt the result

**Trace for arr = [10, 20, 30, 40]:**
```
Initial: sum = 0
i=0: sum = 0 + 10 = 10
i=1: sum = 10 + 20 = 30
i=2: sum = 30 + 30 = 60
i=3: sum = 60 + 40 = 100
Result: 100
```

**Time Complexity:** O(n) - must visit every element once
**Space Complexity:** O(1) - only one variable needed

---

## Q3: Average of Array Elements

**Problem:** Calculate average (mean) of elements.

**Logic (Detailed):**

Average = Sum ÷ Count

**Key insight:** Use `double` for accurate division!

```java
int sum = 0;
for (int element : arr) {
    sum += element;
}
double average = (double) sum / arr.length;  // Cast to double!
```

**Why cast to double:**
```
int/int = int (truncated)
5/2 = 2 (wrong!)

double/int = double
5.0/2 = 2.5 (correct!)
```

**Trace for arr = [10, 20, 30]:**
```
sum = 10 + 20 + 30 = 60
count = 3
average = 60.0 / 3 = 20.0
```

---

## Q4: Maximum Element

**Problem:** Find the largest element.

**Logic (Detailed):**

**Key insight:** Start by assuming first element is maximum, then challenge that assumption.

```
max = arr[0]  // Assume first is largest
for i from 1 to n-1:
    if arr[i] > max:
        max = arr[i]  // Found larger, update
```

**Why start from index 1:**
- arr[0] is already our assumed max
- Comparing it to itself is wasteful

**Why not initialize to 0:**
```
arr = [-5, -3, -1]
If max = 0:
    max stays 0 (wrong! max should be -1)
If max = arr[0] = -5:
    After loop, max = -1 (correct!)
```

**Trace for arr = [25, 11, 47, 33, 15]:**
```
Initial: max = 25
i=1: 11 > 25? NO
i=2: 47 > 25? YES → max = 47
i=3: 33 > 47? NO
i=4: 15 > 47? NO
Result: max = 47
```

---

## Q5: Minimum Element

**Problem:** Find the smallest element.

**Logic (Detailed):**

Mirror of maximum - assume first is minimum, update when smaller found:

```
min = arr[0]
for i from 1 to n-1:
    if arr[i] < min:
        min = arr[i]
```

**Trace for arr = [25, 11, 47, 33, 15]:**
```
Initial: min = 25
i=1: 11 < 25? YES → min = 11
i=2: 47 < 11? NO
i=3: 33 < 11? NO
i=4: 15 < 11? NO
Result: min = 11
```

---

## Q6: Count Positive, Negative, Zero

**Problem:** Count elements by sign.

**Logic (Detailed):**

Use three counters, increment based on element's sign:

```
positive = 0, negative = 0, zero = 0

for each element:
    if element > 0:
        positive++
    else if element < 0:
        negative++
    else:
        zero++
```

**Trace for arr = [5, -3, 0, -1, 8, 0]:**
```
Element  | Condition    | Counters (pos, neg, zero)
---------|--------------|-------------------------
5        | > 0          | (1, 0, 0)
-3       | < 0          | (1, 1, 0)
0        | == 0         | (1, 1, 1)
-1       | < 0          | (1, 2, 1)
8        | > 0          | (2, 2, 1)
0        | == 0         | (2, 2, 2)

Result: 2 positive, 2 negative, 2 zeros
```

---

## Q7: Count Even and Odd

**Problem:** Count even and odd numbers.

**Logic (Detailed):**

A number is even if divisible by 2, otherwise odd:
- `element % 2 == 0` → even
- `element % 2 != 0` → odd

```
even = 0, odd = 0

for each element:
    if element % 2 == 0:
        even++
    else:
        odd++
```

**How modulo works:**
```
10 % 2 = 0 (10 = 2×5 + 0) → even
7 % 2 = 1 (7 = 2×3 + 1) → odd
```

**Trace for arr = [2, 7, 10, 3, 8]:**
```
Element | element % 2 | Type | Counters (even, odd)
--------|-------------|------|--------------------
2       | 0           | even | (1, 0)
7       | 1           | odd  | (1, 1)
10      | 0           | even | (2, 1)
3       | 1           | odd  | (2, 2)
8       | 0           | even | (3, 2)

Result: 3 even, 2 odd
```

---

## Q8: Index of Maximum Element

**Problem:** Find position where maximum occurs.

**Logic (Detailed):**

Track the index, not the value:

```
maxIndex = 0  // Assume max is at index 0

for i from 1 to n-1:
    if arr[i] > arr[maxIndex]:
        maxIndex = i  // Update index
```

**Key insight:** Compare using `arr[i] > arr[maxIndex]`
- This compares VALUES at those positions
- Updates INDEX when larger value found

**Trace for arr = [25, 11, 47, 33, 47]:**
```
Initial: maxIndex = 0, arr[0] = 25
i=1: arr[1]=11 > arr[0]=25? NO
i=2: arr[2]=47 > arr[0]=25? YES → maxIndex = 2
i=3: arr[3]=33 > arr[2]=47? NO
i=4: arr[4]=47 > arr[2]=47? NO (equal, not greater)

Result: maxIndex = 2 (first occurrence of 47)
```

---

## Q9: Index of Minimum Element

**Problem:** Find position where minimum occurs.

**Logic (Detailed):**

Same as Q8 but with < comparison:

```
minIndex = 0

for i from 1 to n-1:
    if arr[i] < arr[minIndex]:
        minIndex = i
```

**Trace for arr = [25, 11, 47, 11, 33]:**
```
Initial: minIndex = 0, arr[0] = 25
i=1: arr[1]=11 < arr[0]=25? YES → minIndex = 1
i=2: arr[2]=47 < arr[1]=11? NO
i=3: arr[3]=11 < arr[1]=11? NO (equal)
i=4: arr[4]=33 < arr[1]=11? NO

Result: minIndex = 1 (first occurrence of 11)
```

---

## Q10: Elements Greater Than K

**Problem:** Print elements exceeding threshold k.

**Logic (Detailed):**

Simple filtering - check each element against condition:

```
for each element:
    if element > k:
        print element
        count++
```

**Trace for arr = [5, 12, 3, 18, 7], k = 10:**
```
Element | element > 10 | Action
--------|--------------|--------
5       | NO           | skip
12      | YES          | print 12, count=1
3       | NO           | skip
18      | YES          | print 18, count=2
7       | NO           | skip

Output: 12 18
Count: 2
```

**Variation possibilities:**
- Greater than or equal: `element >= k`
- Less than: `element < k`
- In range: `element >= low && element <= high`
