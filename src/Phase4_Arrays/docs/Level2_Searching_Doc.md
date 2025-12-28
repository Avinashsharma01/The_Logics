# Phase 4 - Arrays | Level 2: Searching (Q11-Q20)

## Overview
Finding elements, their positions, and counting occurrences in arrays.

---

## Q11: Linear Search

**Problem:** Find if element exists and return its index.

**Logic (Detailed):**

Linear search scans array from start to end until target is found:

```
for i from 0 to n-1:
    if arr[i] == target:
        return i  // Found at index i
return -1  // Not found
```

**Why return -1 for not found:**
- Valid indices are 0 to n-1 (non-negative)
- -1 is a sentinel value indicating "not present"
- Any negative number could work, -1 is convention

**Trace for arr = [10, 25, 7, 14, 30], target = 14:**
```
i=0: arr[0]=10 == 14? NO
i=1: arr[1]=25 == 14? NO
i=2: arr[2]=7 == 14? NO
i=3: arr[3]=14 == 14? YES → return 3

Result: Found at index 3
```

**Trace for target = 99:**
```
i=0: 10 == 99? NO
i=1: 25 == 99? NO
i=2: 7 == 99? NO
i=3: 14 == 99? NO
i=4: 30 == 99? NO
Loop ends → return -1

Result: Not found
```

**Time Complexity:** O(n) - worst case checks all elements

---

## Q12: Count Frequency of Element

**Problem:** Count how many times element appears.

**Logic (Detailed):**

Simple counter - increment when match found:

```
count = 0
for each element in array:
    if element == target:
        count++
return count
```

**Trace for arr = [5, 2, 5, 8, 5, 2], target = 5:**
```
i=0: 5 == 5? YES → count = 1
i=1: 2 == 5? NO
i=2: 5 == 5? YES → count = 2
i=3: 8 == 5? NO
i=4: 5 == 5? YES → count = 3
i=5: 2 == 5? NO

Result: 5 appears 3 times
```

---

## Q13: Find All Occurrences (Indices)

**Problem:** Return list of all indices where element appears.

**Logic (Detailed):**

Collect indices instead of just counting:

```
indices = empty list
for i from 0 to n-1:
    if arr[i] == target:
        indices.add(i)
return indices
```

**Trace for arr = [5, 2, 5, 8, 5, 2], target = 5:**
```
i=0: arr[0]=5 == 5? YES → indices = [0]
i=1: arr[1]=2 == 5? NO
i=2: arr[2]=5 == 5? YES → indices = [0, 2]
i=3: arr[3]=8 == 5? NO
i=4: arr[4]=5 == 5? YES → indices = [0, 2, 4]
i=5: arr[5]=2 == 5? NO

Result: [0, 2, 4]
```

---

## Q14: Binary Search

**Problem:** Efficiently search in SORTED array.

**Logic (Detailed):**

Binary search eliminates half the search space each step:

1. Look at middle element
2. If target found, done!
3. If target < middle, search left half
4. If target > middle, search right half
5. Repeat until found or no elements left

```
left = 0, right = n-1

while left <= right:
    mid = left + (right - left) / 2  // Safer than (left+right)/2
    
    if arr[mid] == target:
        return mid
    else if arr[mid] < target:
        left = mid + 1    // Search right half
    else:
        right = mid - 1   // Search left half

return -1  // Not found
```

**Why `left + (right-left)/2` instead of `(left+right)/2`:**
- Prevents integer overflow for large arrays
- If left=1billion, right=2billion, sum overflows!

**Trace for arr = [2, 5, 8, 12, 16, 23, 38, 45], target = 23:**
```
Step 1: left=0, right=7
        mid = 0 + (7-0)/2 = 3
        arr[3] = 12
        23 > 12 → search right: left = 4

Step 2: left=4, right=7
        mid = 4 + (7-4)/2 = 5
        arr[5] = 23
        23 == 23 → FOUND at index 5!
```

**Time Complexity:** O(log n)
- Each step halves the search space
- For n=1000, max ~10 comparisons
- For n=1,000,000, max ~20 comparisons

**Binary search vs Linear search:**
```
n = 1,000,000 elements
Linear: up to 1,000,000 comparisons
Binary: up to 20 comparisons

That's 50,000x faster!
```

---

## Q15: First and Last Occurrence

**Problem:** Find first and last index of an element.

**Logic (Detailed):**

Single pass solution:
- First occurrence: set only once (when first=-1)
- Last occurrence: update every time

```
first = -1, last = -1

for i from 0 to n-1:
    if arr[i] == target:
        if first == -1:
            first = i  // Set first only once
        last = i       // Always update last
```

**Trace for arr = [5, 2, 5, 8, 5, 2], target = 5:**
```
i=0: 5 == 5? YES
     first == -1? YES → first = 0
     last = 0

i=1: 2 == 5? NO

i=2: 5 == 5? YES
     first == -1? NO (already set)
     last = 2

i=3: 8 == 5? NO

i=4: 5 == 5? YES
     first == -1? NO
     last = 4

i=5: 2 == 5? NO

Result: first=0, last=4
```

---

## Q16: Find All Unique Elements

**Problem:** Print elements that appear (without duplicates).

**Logic (Detailed):**

For each element, check if it appeared earlier:

```
for i from 0 to n-1:
    isUnique = true
    
    // Check if appeared before at earlier index
    for j from 0 to i-1:
        if arr[j] == arr[i]:
            isUnique = false
            break
    
    if isUnique:
        print arr[i]
```

**Trace for arr = [5, 2, 5, 8, 2]:**
```
i=0 (5): Check j=0 to -1: no previous → UNIQUE, print 5
i=1 (2): Check j=0 to 0: arr[0]=5≠2 → UNIQUE, print 2
i=2 (5): Check j=0 to 1: arr[0]=5==5 → not unique, skip
i=3 (8): Check j=0 to 2: none match → UNIQUE, print 8
i=4 (2): Check j=0 to 3: arr[1]=2==2 → not unique, skip

Output: 5 2 8
```

**Time Complexity:** O(n²) due to nested loops

---

## Q17: Find Duplicate Elements

**Problem:** Print elements that appear more than once.

**Logic (Detailed):**

For each element:
1. Check if already printed (appeared before)
2. If not, check if appears later

```
for i from 0 to n-1:
    // Skip if already printed
    alreadyPrinted = false
    for j from 0 to i-1:
        if arr[j] == arr[i]:
            alreadyPrinted = true
            break
    
    if not alreadyPrinted:
        // Check if appears later
        for j from i+1 to n-1:
            if arr[j] == arr[i]:
                print arr[i]
                break
```

**Trace for arr = [5, 2, 5, 8, 2, 5]:**
```
i=0 (5): Not printed before. Appears at i=2? YES → print 5
i=1 (2): Not printed before. Appears at i=4? YES → print 2
i=2 (5): Already at i=0, skip
i=3 (8): Not printed before. Appears later? NO
i=4 (2): Already at i=1, skip
i=5 (5): Already at i=0, skip

Output: 5 2
```

---

## Q18: Frequency of All Elements

**Problem:** Print each unique element with its count.

**Logic (Detailed):**

Use visited array to avoid recounting:

```
visited[] = all false

for i from 0 to n-1:
    if not visited[i]:
        count = 1
        
        for j from i+1 to n-1:
            if arr[j] == arr[i]:
                count++
                visited[j] = true  // Mark as counted
        
        print arr[i] + " appears " + count + " times"
```

**Trace for arr = [5, 2, 5, 8, 2]:**
```
visited = [F, F, F, F, F]

i=0: not visited, count 5s from i=1 onwards
     j=2: arr[2]=5, count=2, visited[2]=T
     Print: "5 appears 2 times"

i=1: not visited, count 2s
     j=4: arr[4]=2, count=2, visited[4]=T
     Print: "2 appears 2 times"

i=2: visited[2]=T, skip

i=3: not visited, count 8s → none found
     Print: "8 appears 1 time"

i=4: visited[4]=T, skip
```

---

## Q19: Find Missing Number (1 to n)

**Problem:** Array has n-1 numbers from 1 to n, find missing one.

**Logic (Detailed):**

**Mathematical approach:**
- Sum of 1 to n = n(n+1)/2 (known formula)
- Missing = Expected sum - Actual sum

```
expectedSum = n * (n + 1) / 2
actualSum = sum of all elements in array
missing = expectedSum - actualSum
```

**Why this works:**
```
Numbers 1 to 5: 1 + 2 + 3 + 4 + 5 = 15
If 3 is missing: 1 + 2 + 4 + 5 = 12
Missing = 15 - 12 = 3 ✓
```

**Trace for arr = [1, 2, 4, 5], n = 5:**
```
Expected = 5 × 6 / 2 = 15
Actual = 1 + 2 + 4 + 5 = 12
Missing = 15 - 12 = 3
```

**Alternative: XOR approach (handles overflow):**
```
XOR all numbers 1 to n
XOR all elements in array
Result = missing number

Why: a ⊕ a = 0, and 0 ⊕ a = a
All paired numbers cancel, leaving missing one.
```

---

## Q20: Find Element Appearing Once

**Problem:** All elements appear twice except one. Find it.

**Logic (Detailed):**

**XOR approach (elegant!):**
- a ⊕ a = 0 (any number XORed with itself = 0)
- a ⊕ 0 = a (any number XORed with 0 = itself)
- XOR all elements → pairs cancel, unique remains

```
result = 0
for each element:
    result = result XOR element
return result
```

**Trace for arr = [2, 3, 5, 3, 2]:**
```
result = 0
result = 0 ⊕ 2 = 2    (binary: 00 ⊕ 10 = 10)
result = 2 ⊕ 3 = 1    (binary: 10 ⊕ 11 = 01)
result = 1 ⊕ 5 = 4    (binary: 001 ⊕ 101 = 100)
result = 4 ⊕ 3 = 7    (binary: 100 ⊕ 011 = 111)
result = 7 ⊕ 2 = 5    (binary: 111 ⊕ 010 = 101)

Result: 5 (the unique element!)
```

**Why XOR works here:**
```
2 ⊕ 2 = 0 (pair cancels)
3 ⊕ 3 = 0 (pair cancels)
5 remains!
```

**Time:** O(n), **Space:** O(1) - optimal!

**Alternative: Frequency count** (O(n²) or O(n) with HashMap)
