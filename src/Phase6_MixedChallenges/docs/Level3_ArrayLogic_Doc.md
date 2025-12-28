# Phase 6 - Mixed Challenges | Level 3: Array Logic (Q21-Q30)

## Overview
Advanced array problems: sliding window, two pointers, matrix operations.

---

## Q21: Rotate Matrix 90° Clockwise

**Problem:** Rotate n×n matrix in-place.

**Logic (Detailed):**
1. Transpose (swap rows↔columns)
2. Reverse each row

```
Original:    Transpose:   Reverse rows:
1 2 3        1 4 7        7 4 1
4 5 6   →    2 5 8   →    8 5 2
7 8 9        3 6 9        9 6 3
```

---

## Q22: Spiral Order Traversal

**Problem:** Print matrix in spiral: right→down→left→up.

**Logic (Detailed):**
Maintain 4 boundaries: top, bottom, left, right. Shrink after each direction.

```java
while (top <= bottom && left <= right) {
    for (j = left to right) print matrix[top][j];  top++;
    for (i = top to bottom) print matrix[i][right]; right--;
    if (top <= bottom) {
        for (j = right to left) print matrix[bottom][j]; bottom--;
    }
    if (left <= right) {
        for (i = bottom to top) print matrix[i][left]; left++;
    }
}
```

---

## Q23: Max Sum Subarray of Size K (Sliding Window)

**Problem:** Find maximum sum of any k consecutive elements.

**Logic (Detailed):**
```java
// Initial window
int windowSum = sum of first k elements;
int maxSum = windowSum;

// Slide: add new, remove old
for (int i = k; i < n; i++) {
    windowSum = windowSum + arr[i] - arr[i-k];
    maxSum = Math.max(maxSum, windowSum);
}
```

**Time:** O(n)

---

## Q24: Container With Most Water (Two Pointers)

**Problem:** Find max area between two lines.

**Logic (Detailed):**
- Area = width × min(height_left, height_right)
- Start with widest container (left=0, right=n-1)
- Move pointer with shorter height inward

```java
int left = 0, right = n-1, maxArea = 0;
while (left < right) {
    int area = (right-left) * Math.min(heights[left], heights[right]);
    maxArea = Math.max(maxArea, area);
    if (heights[left] < heights[right]) left++;
    else right--;
}
```

---

## Q25: Three Sum = 0

**Problem:** Find all unique triplets summing to zero.

**Logic (Detailed):**
1. Sort array
2. Fix one element, use two pointers for other two
3. Skip duplicates

**Time:** O(n²)

---

## Q26: Dutch National Flag (Sort 0s, 1s, 2s)

**Problem:** Sort array containing only 0, 1, 2.

**Logic (Detailed):**
Three pointers: low, mid, high
- 0 → swap with low, increment both
- 1 → just move mid
- 2 → swap with high, decrement high

```java
while (mid <= high) {
    if (arr[mid] == 0) swap(low++, mid++);
    else if (arr[mid] == 1) mid++;
    else swap(mid, high--);
}
```

**Time:** O(n), **Space:** O(1)

---

## Q27: Next Permutation

**Problem:** Find next lexicographically greater arrangement.

**Logic (Detailed):**
1. Find rightmost pair where arr[i] < arr[i+1]
2. Find rightmost element > arr[i]
3. Swap them
4. Reverse suffix after i

**Example:** [1,2,3] → [1,3,2] → [2,1,3] → [2,3,1] → [3,1,2] → [3,2,1]

---

## Q28: Maximum Product Subarray

**Problem:** Find contiguous subarray with largest product.

**Logic:** Track both max and min (negative × negative = positive).

```java
int maxProd = arr[0], minProd = arr[0], result = arr[0];
for (int i = 1; i < n; i++) {
    if (arr[i] < 0) swap(maxProd, minProd);
    maxProd = Math.max(arr[i], maxProd * arr[i]);
    minProd = Math.min(arr[i], minProd * arr[i]);
    result = Math.max(result, maxProd);
}
```

---

## Q29: Trapping Rain Water

**Problem:** Calculate water trapped between bars.

**Logic:** Water at i = min(maxLeft, maxRight) - height[i]

---

## Q30: Merge Intervals

**Problem:** Merge overlapping intervals.

**Logic:** Sort by start, merge if current.start <= prev.end.
