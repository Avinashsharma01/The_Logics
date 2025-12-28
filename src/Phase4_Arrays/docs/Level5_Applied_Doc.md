# Phase 4 - Arrays | Level 5: Applied Logic (Q41-Q50)

## Overview
Advanced array problems: sorted checks, pair/triplet sums, subarrays, Kadane's algorithm.

---

## Q41: Check if Array is Sorted

**Problem:** Determine if array is sorted (ascending or descending).

**Logic (Detailed):**

**Ascending:** Each element ≥ previous element
**Descending:** Each element ≤ previous element

```
sortedAsc = true
sortedDesc = true

for i from 1 to n-1:
    if arr[i] < arr[i-1]:
        sortedAsc = false
    if arr[i] > arr[i-1]:
        sortedDesc = false

if sortedAsc:
    "Ascending"
else if sortedDesc:
    "Descending"
else:
    "Not sorted"
```

**Trace for arr = [1, 3, 5, 4, 7]:**
```
i=1: 3 < 1? NO, 3 > 1? YES → sortedDesc = false
i=2: 5 < 3? NO, 5 > 3? YES → (already false)
i=3: 4 < 5? YES → sortedAsc = false, 4 > 5? NO
i=4: 7 < 4? NO, 7 > 4? YES

Both flags false → NOT sorted
```

---

## Q42: Second Largest Element

**Problem:** Find second maximum value.

**Logic (Detailed):**

Track both largest and second largest in single pass:

```
largest = MIN_VALUE
secondLargest = MIN_VALUE

for num in arr:
    if num > largest:
        secondLargest = largest  // Demote current largest
        largest = num            // New largest
    else if num > secondLargest AND num != largest:
        secondLargest = num
```

**Key insight:** When finding new largest, old largest becomes second!

**Trace for arr = [12, 35, 1, 10, 34, 1]:**
```
num=12: 12 > MIN? YES → second=MIN, largest=12
num=35: 35 > 12? YES → second=12, largest=35
num=1:  1 > 35? NO. 1 > 12? NO
num=10: 10 > 35? NO. 10 > 12? NO
num=34: 34 > 35? NO. 34 > 12 AND 34≠35? YES → second=34
num=1:  Already checked

Result: largest=35, secondLargest=34
```

**Edge cases:**
- All elements same: No second largest
- Only one element: No second largest

---

## Q43: Second Smallest Element

**Problem:** Find second minimum value.

**Logic (Detailed):**

Mirror of Q42 with reversed comparisons:

```
smallest = MAX_VALUE
secondSmallest = MAX_VALUE

for num in arr:
    if num < smallest:
        secondSmallest = smallest
        smallest = num
    else if num < secondSmallest AND num != smallest:
        secondSmallest = num
```

**Trace for arr = [12, 13, 1, 10, 34, 1]:**
```
num=12: 12 < MAX? YES → secondSmall=MAX, smallest=12
num=13: 13 < 12? NO. 13 < MAX? YES → secondSmall=13
num=1:  1 < 12? YES → secondSmall=12, smallest=1
num=10: 10 < 1? NO. 10 < 12 AND 10≠1? YES → secondSmall=10
num=34: 34 < 1? NO. 34 < 10? NO
num=1:  1 == smallest, skip

Result: smallest=1, secondSmallest=10
```

---

## Q44: Find Pair with Given Sum

**Problem:** Find two elements that add up to target.

**Logic (Detailed):**

**Method 1: Brute Force O(n²)**
Check all possible pairs:

```
for i from 0 to n-2:
    for j from i+1 to n-1:
        if arr[i] + arr[j] == target:
            print pair (arr[i], arr[j])
```

**Why j starts at i+1:** Avoid duplicate pairs (i,j) and (j,i)

**Trace for arr = [1, 5, 7, 1, 5], target = 6:**
```
i=0, j=1: 1+5 = 6 ✓ → pair (1, 5)
i=0, j=2: 1+7 = 8 ✗
i=0, j=3: 1+1 = 2 ✗
i=0, j=4: 1+5 = 6 ✓ → pair (1, 5)
i=1, j=2: 5+7 = 12 ✗
...and so on
```

**Method 2: Two Pointers O(n log n)** (for sorted arrays)
```
sort(arr)
left = 0, right = n-1

while left < right:
    sum = arr[left] + arr[right]
    if sum == target:
        found!
    else if sum < target:
        left++  // Need larger sum
    else:
        right--  // Need smaller sum
```

---

## Q45: Find Triplet with Given Sum

**Problem:** Find three elements that add up to target.

**Logic (Detailed):**

**Brute Force O(n³):**
```
for i from 0 to n-3:
    for j from i+1 to n-2:
        for k from j+1 to n-1:
            if arr[i] + arr[j] + arr[k] == target:
                print triplet
```

**Trace for arr = [1, 2, 3, 4, 5], target = 9:**
```
i=0, j=1, k=2: 1+2+3 = 6 ✗
i=0, j=1, k=3: 1+2+4 = 7 ✗
i=0, j=1, k=4: 1+2+5 = 8 ✗
i=0, j=2, k=3: 1+3+4 = 8 ✗
i=0, j=2, k=4: 1+3+5 = 9 ✓ → triplet (1, 3, 5)
i=0, j=3, k=4: 1+4+5 = 10 ✗
i=1, j=2, k=3: 2+3+4 = 9 ✓ → triplet (2, 3, 4)
...
```

**Optimized O(n²):** Fix one element, use two-pointer for remaining two.

---

## Q46: Product of Array Except Self

**Problem:** result[i] = product of all elements except arr[i].

**Logic (Detailed):**

**Method 1: Simple O(n²)**
```
for i from 0 to n-1:
    product = 1
    for j from 0 to n-1:
        if i != j:
            product *= arr[j]
    result[i] = product
```

**Method 2: Efficient O(n) with prefix/suffix products**

Build two arrays:
- left[i] = product of elements to the LEFT of i
- right[i] = product of elements to the RIGHT of i
- result[i] = left[i] × right[i]

```
left[0] = 1  // Nothing to left of first element
for i from 1 to n-1:
    left[i] = left[i-1] × arr[i-1]

right[n-1] = 1  // Nothing to right of last element
for i from n-2 to 0:
    right[i] = right[i+1] × arr[i+1]

for i from 0 to n-1:
    result[i] = left[i] × right[i]
```

**Trace for arr = [1, 2, 3, 4]:**
```
left[]:  [1,    1,   2,    6]
         (1,  1×1, 1×2, 1×2×3)

right[]: [24,  12,   4,    1]
         (2×3×4, 3×4, 4, 1)

result[]: [1×24, 1×12, 2×4, 6×1] = [24, 12, 8, 6]

Verify: 
result[0] = 2×3×4 = 24 ✓
result[1] = 1×3×4 = 12 ✓
result[2] = 1×2×4 = 8 ✓
result[3] = 1×2×3 = 6 ✓
```

---

## Q47: Maximum Subarray Sum (Kadane's Algorithm)

**Problem:** Find contiguous subarray with largest sum.

**Logic (Detailed):**

**Kadane's Algorithm - The Key Insight:**

At each position, we have two choices:
1. Extend the previous subarray (add current to running sum)
2. Start fresh from current element

Choose whichever is larger!

```
maxSum = arr[0]
currentSum = arr[0]

for i from 1 to n-1:
    // Choice: extend previous OR start fresh
    currentSum = max(arr[i], currentSum + arr[i])
    
    // Update overall maximum
    maxSum = max(maxSum, currentSum)
```

**Why this works:**
- If currentSum becomes negative, starting fresh is better
- We're essentially "resetting" when sum drops below current element

**Trace for arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]:**
```
i=0: currentSum=-2, maxSum=-2
i=1: max(1, -2+1=-1) = 1, maxSum=1
i=2: max(-3, 1-3=-2) = -2, maxSum=1
i=3: max(4, -2+4=2) = 4, maxSum=4    ← Fresh start!
i=4: max(-1, 4-1=3) = 3, maxSum=4
i=5: max(2, 3+2=5) = 5, maxSum=5
i=6: max(1, 5+1=6) = 6, maxSum=6     ← Maximum!
i=7: max(-5, 6-5=1) = 1, maxSum=6
i=8: max(4, 1+4=5) = 5, maxSum=6

Result: maxSum = 6, subarray = [4, -1, 2, 1]
```

**Time:** O(n), **Space:** O(1) - Optimal!

---

## Q48: Leaders in Array

**Problem:** Element is leader if all elements to its right are smaller.

**Logic (Detailed):**

Traverse from RIGHT, track maximum seen:

```
maxFromRight = arr[n-1]  // Rightmost is always leader
print maxFromRight

for i from n-2 to 0:
    if arr[i] > maxFromRight:
        print arr[i]  // It's a leader
        maxFromRight = arr[i]
```

**Why traverse from right:**
- Leader depends on elements to the RIGHT
- Tracking max from right tells us instantly if current is larger than all to its right

**Trace for arr = [16, 17, 4, 3, 5, 2]:**
```
i=5: maxFromRight = 2, print 2 (rightmost is leader)
i=4: 5 > 2? YES → print 5, maxFromRight = 5
i=3: 3 > 5? NO
i=2: 4 > 5? NO
i=1: 17 > 5? YES → print 17, maxFromRight = 17
i=0: 16 > 17? NO

Leaders (in reverse): [2, 5, 17]
Leaders (in order): [17, 5, 2]
```

---

## Q49: Equilibrium Index

**Problem:** Index where left sum equals right sum.

**Logic (Detailed):**

**Key formula:**
- leftSum + arr[i] + rightSum = totalSum
- If leftSum == rightSum, i is equilibrium

```
totalSum = sum of all elements

leftSum = 0
for i from 0 to n-1:
    rightSum = totalSum - leftSum - arr[i]
    
    if leftSum == rightSum:
        return i  // Equilibrium found!
    
    leftSum += arr[i]  // Update for next iteration
```

**Trace for arr = [-7, 1, 5, 2, -4, 3, 0]:**
```
totalSum = -7 + 1 + 5 + 2 - 4 + 3 + 0 = 0

i=0: leftSum=0, rightSum=0-0-(-7)=7
     0 == 7? NO. leftSum += -7 → leftSum=-7

i=1: leftSum=-7, rightSum=0-(-7)-1=6
     -7 == 6? NO. leftSum += 1 → leftSum=-6

i=2: leftSum=-6, rightSum=0-(-6)-5=1
     -6 == 1? NO. leftSum += 5 → leftSum=-1

i=3: leftSum=-1, rightSum=0-(-1)-2=-1
     -1 == -1? YES! Equilibrium at index 3

Verify:
Left of index 3: -7 + 1 + 5 = -1
Right of index 3: -4 + 3 + 0 = -1 ✓
```

---

## Q50: Peak Element

**Problem:** Element greater than its neighbors.

**Logic (Detailed):**

**Definition:**
- arr[i] is peak if arr[i] > arr[i-1] AND arr[i] > arr[i+1]
- First element: only check arr[0] > arr[1]
- Last element: only check arr[n-1] > arr[n-2]

```
// Check first element
if arr[0] > arr[1]:
    print arr[0] as peak

// Check middle elements
for i from 1 to n-2:
    if arr[i] > arr[i-1] AND arr[i] > arr[i+1]:
        print arr[i] as peak

// Check last element
if arr[n-1] > arr[n-2]:
    print arr[n-1] as peak
```

**Trace for arr = [1, 3, 2, 4, 1, 0]:**
```
i=0: 1 > 3? NO
i=1: 3 > 1 AND 3 > 2? YES → Peak: 3
i=2: 2 > 3? NO
i=3: 4 > 2 AND 4 > 1? YES → Peak: 4
i=4: 1 > 4? NO
i=5: 0 > 1? NO

Peaks: [3, 4]
```

**Binary Search for Peak (Interview optimization):**
```
If arr[mid] > arr[mid-1] AND arr[mid] > arr[mid+1]:
    Found peak!
Else if arr[mid] < arr[mid+1]:
    Peak exists in right half
Else:
    Peak exists in left half
```

Time: O(log n) - Always at least one peak in any array!
