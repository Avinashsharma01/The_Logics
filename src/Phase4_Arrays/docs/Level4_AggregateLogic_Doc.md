# Phase 4 - Arrays | Level 4: Aggregate Logic (Q31-Q40)

## Overview
Operations involving multiple arrays: merging, comparing, set operations.

---

## Q31: Merge Two Arrays

**Problem:** Combine two arrays into one.

**Logic (Detailed):**

Simple concatenation:
1. Create array of combined size
2. Copy all elements from first array
3. Copy all elements from second array

```
merged = new array[len1 + len2]
index = 0

for num in arr1:
    merged[index++] = num

for num in arr2:
    merged[index++] = num
```

**Trace for arr1 = [1, 2, 3], arr2 = [4, 5]:**
```
merged = new int[5]
Copy arr1: merged = [1, 2, 3, _, _]
Copy arr2: merged = [1, 2, 3, 4, 5]
```

---

## Q32: Merge Two Sorted Arrays (Maintaining Order)

**Problem:** Merge sorted arrays into one sorted array.

**Logic (Detailed):**

**Two-pointer technique:**
- Pointer i for arr1, pointer j for arr2
- Compare elements, add smaller to result
- Move that pointer forward
- Handle remaining elements

```
i = 0, j = 0, k = 0
merged = new array[len1 + len2]

// Compare and merge
while i < len1 AND j < len2:
    if arr1[i] <= arr2[j]:
        merged[k++] = arr1[i++]
    else:
        merged[k++] = arr2[j++]

// Copy remaining from arr1
while i < len1:
    merged[k++] = arr1[i++]

// Copy remaining from arr2
while j < len2:
    merged[k++] = arr2[j++]
```

**Trace for arr1 = [1, 3, 5], arr2 = [2, 4, 6]:**
```
i=0, j=0: 1 <= 2? YES → merged[0]=1, i=1
i=1, j=0: 3 <= 2? NO  → merged[1]=2, j=1
i=1, j=1: 3 <= 4? YES → merged[2]=3, i=2
i=2, j=1: 5 <= 4? NO  → merged[3]=4, j=2
i=2, j=2: 5 <= 6? YES → merged[4]=5, i=3
i=3: arr1 exhausted, copy rest of arr2
j=2: merged[5]=6

Result: [1, 2, 3, 4, 5, 6]
```

**Time:** O(n+m), **Space:** O(n+m)

**This is the merge step in Merge Sort!**

---

## Q33: Check if Two Arrays are Equal

**Problem:** Check if arrays have same elements in same order.

**Logic (Detailed):**

Two conditions for equality:
1. Same length
2. Same element at each position

```
if len1 != len2:
    return false

for i from 0 to len1-1:
    if arr1[i] != arr2[i]:
        return false

return true
```

**Trace for arr1 = [1, 2, 3], arr2 = [1, 2, 4]:**
```
Length check: 3 == 3 ✓
i=0: arr1[0]=1 == arr2[0]=1 ✓
i=1: arr1[1]=2 == arr2[1]=2 ✓
i=2: arr1[2]=3 == arr2[2]=4 ✗

Result: NOT EQUAL
```

**Java shortcut:** `Arrays.equals(arr1, arr2)`

---

## Q34: Find Common Elements (Intersection)

**Problem:** Elements present in both arrays.

**Logic (Detailed):**

For each element in arr1:
1. Check if already added (avoid duplicates)
2. Check if exists in arr2
3. If both conditions met, add to result

```
common = empty list

for i from 0 to len1-1:
    // Check if duplicate in arr1
    alreadyAdded = false
    for j from 0 to i-1:
        if arr1[j] == arr1[i]:
            alreadyAdded = true
            break
    
    if not alreadyAdded:
        // Check if in arr2
        for num in arr2:
            if arr1[i] == num:
                common.add(arr1[i])
                break
```

**Trace for arr1 = [1, 2, 2, 3], arr2 = [2, 3, 4]:**
```
i=0 (1): Not duplicate. In arr2? NO
i=1 (2): Not duplicate. In arr2? YES → common = [2]
i=2 (2): Duplicate of i=1, skip
i=3 (3): Not duplicate. In arr2? YES → common = [2, 3]

Result: [2, 3]
```

**Set notation:** A ∩ B

---

## Q35: Find Union of Two Arrays

**Problem:** All unique elements from both arrays.

**Logic (Detailed):**

Add elements if not already in result:

```
union = empty list

for num in arr1:
    if num NOT in union:
        union.add(num)

for num in arr2:
    if num NOT in union:
        union.add(num)
```

**Trace for arr1 = [1, 2, 3], arr2 = [2, 3, 4]:**
```
From arr1:
  1: not in union → union = [1]
  2: not in union → union = [1, 2]
  3: not in union → union = [1, 2, 3]

From arr2:
  2: already in union, skip
  3: already in union, skip
  4: not in union → union = [1, 2, 3, 4]

Result: [1, 2, 3, 4]
```

**Set notation:** A ∪ B

---

## Q36: Find Difference (arr1 - arr2)

**Problem:** Elements in arr1 but NOT in arr2.

**Logic (Detailed):**

For each unique element in arr1, check if NOT in arr2:

```
difference = empty list

for i from 0 to len1-1:
    // Skip duplicates
    if arr1[i] appeared before in arr1:
        continue
    
    // Check if NOT in arr2
    foundInArr2 = false
    for num in arr2:
        if arr1[i] == num:
            foundInArr2 = true
            break
    
    if not foundInArr2:
        difference.add(arr1[i])
```

**Trace for arr1 = [1, 2, 3, 4], arr2 = [3, 4, 5]:**
```
1: Not in arr2 → difference = [1]
2: Not in arr2 → difference = [1, 2]
3: In arr2, skip
4: In arr2, skip

Result: [1, 2]
```

**Set notation:** A - B (A minus B)

---

## Q37: Check if Subset

**Problem:** Check if arr1 is subset of arr2.

**Logic (Detailed):**

arr1 ⊆ arr2 if every element in arr1 exists in arr2:

```
for each num in arr1:
    found = false
    for each val in arr2:
        if num == val:
            found = true
            break
    
    if not found:
        return false  // Missing element

return true  // All elements found
```

**Trace for arr1 = [2, 3], arr2 = [1, 2, 3, 4]:**
```
Check 2: Found in arr2 ✓
Check 3: Found in arr2 ✓
All found → arr1 IS a subset of arr2
```

**Trace for arr1 = [2, 5], arr2 = [1, 2, 3, 4]:**
```
Check 2: Found ✓
Check 5: NOT found in arr2 ✗
→ arr1 is NOT a subset
```

---

## Q38: Element-wise Sum

**Problem:** Add corresponding elements.

**Logic (Detailed):**

Handle different lengths by treating missing as 0:

```
maxLen = max(len1, len2)
sum = new array[maxLen]

for i from 0 to maxLen-1:
    val1 = (i < len1) ? arr1[i] : 0
    val2 = (i < len2) ? arr2[i] : 0
    sum[i] = val1 + val2
```

**Trace for arr1 = [1, 2, 3], arr2 = [4, 5]:**
```
i=0: sum[0] = 1 + 4 = 5
i=1: sum[1] = 2 + 5 = 7
i=2: sum[2] = 3 + 0 = 3  (arr2 exhausted, use 0)

Result: [5, 7, 3]
```

---

## Q39: Symmetric Difference

**Problem:** Elements in either array but NOT in both.

**Logic (Detailed):**

Symmetric difference = (A - B) ∪ (B - A)

```
result = empty list

// Elements in arr1 but not arr2
for num in arr1:
    if num NOT in arr2 AND num NOT in result:
        result.add(num)

// Elements in arr2 but not arr1
for num in arr2:
    if num NOT in arr1 AND num NOT in result:
        result.add(num)
```

**Trace for arr1 = [1, 2, 3], arr2 = [2, 3, 4]:**
```
From arr1:
  1: not in arr2 → result = [1]
  2: in arr2, skip
  3: in arr2, skip

From arr2:
  2: in arr1, skip
  3: in arr1, skip
  4: not in arr1 → result = [1, 4]

Result: [1, 4]
```

**Venn diagram visualization:**
```
    arr1          arr2
   ┌────┐       ┌────┐
   │ 1  │┌─────┐│  4 │
   │    ││ 2,3 ││    │
   └────┘└─────┘└────┘
     ↑             ↑
  Only in A    Only in B
  
Symmetric difference = {1, 4}
```

---

## Q40: Dot Product

**Problem:** Sum of products of corresponding elements.

**Logic (Detailed):**

Dot product (scalar product):
- A · B = a₁b₁ + a₂b₂ + ... + aₙbₙ
- Arrays must be same length

```
if len1 != len2:
    error("Lengths must match!")

dotProduct = 0
for i from 0 to n-1:
    dotProduct += arr1[i] * arr2[i]
```

**Trace for arr1 = [1, 2, 3], arr2 = [4, 5, 6]:**
```
i=0: 1 × 4 = 4
i=1: 2 × 5 = 10
i=2: 3 × 6 = 18

Dot Product = 4 + 10 + 18 = 32
```

**Mathematical representation:**
```
[1, 2, 3] · [4, 5, 6] = 1×4 + 2×5 + 3×6 = 32
```

**Applications:**
- Vector mathematics
- Machine learning (neural networks)
- Physics (work = force · displacement)
- Graphics (lighting calculations)

**Geometric interpretation:**
```
A · B = |A| × |B| × cos(θ)
where θ is angle between vectors

If A · B = 0, vectors are perpendicular!
```
