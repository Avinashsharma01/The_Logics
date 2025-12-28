# Phase 6 - Mixed Challenges | Level 5: Applied Logic (Q41-Q50)

## Overview
Real-world problems: recursion, backtracking, dynamic programming.

---

## Q41: Tower of Hanoi

**Problem:** Move n disks from source to destination using auxiliary.

**Logic (Detailed):**
1. Move n-1 disks: source → auxiliary
2. Move largest disk: source → destination
3. Move n-1 disks: auxiliary → destination

**Minimum moves:** 2ⁿ - 1

```java
void hanoi(int n, char src, char dest, char aux) {
    if (n == 1) { move disk 1; return; }
    hanoi(n-1, src, aux, dest);
    move disk n from src to dest;
    hanoi(n-1, aux, dest, src);
}
```

---

## Q42: N-Queens

**Problem:** Place N queens on N×N board with no attacks.

**Logic (Detailed):**
Use backtracking - try placing queen row by row.

**Safety check:** No queen in same column or diagonal.
```java
boolean isSafe(int[] queens, int row, int col) {
    for (int i = 0; i < row; i++) {
        if (queens[i] == col) return false;  // Same column
        if (Math.abs(queens[i] - col) == row - i) return false;  // Diagonal
    }
    return true;
}
```

---

## Q43: Generate All Permutations

**Problem:** Generate all arrangements of characters.

**Logic:** Swap each element to current position, recurse for rest, backtrack.

```java
void permute(char[] chars, int index) {
    if (index == chars.length) { print; return; }
    for (int i = index; i < chars.length; i++) {
        swap(chars, index, i);
        permute(chars, index + 1);
        swap(chars, index, i);  // Backtrack
    }
}
```

---

## Q44: Power Set (All Subsets)

**Problem:** Generate all 2ⁿ subsets.

**Logic (Detailed):**
Use bit manipulation - each number 0 to 2ⁿ-1 represents a subset.

```java
for (int mask = 0; mask < (1 << n); mask++) {
    for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) != 0) {
            include arr[i] in subset
        }
    }
}
```

---

## Q45: Josephus Problem

**Problem:** N people in circle, every k-th eliminated. Find survivor.

**Logic (Detailed):**
Recursive formula: J(n, k) = (J(n-1, k) + k) % n
Base case: J(1, k) = 0

---

## Q46: Coin Change (Minimum Coins)

**Problem:** Minimum coins to make amount.

**Logic (Detailed):**
DP: dp[i] = minimum coins for amount i

```java
dp[0] = 0;
for (int i = 1; i <= amount; i++) {
    for (int coin : coins) {
        if (coin <= i) {
            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
    }
}
```

---

## Q47: Longest Increasing Subsequence

**Problem:** Length of longest strictly increasing subsequence.

**Logic (Detailed):**
dp[i] = LIS length ending at index i

```java
for (int i = 1; i < n; i++) {
    for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
}
```

**Time:** O(n²)

---

## Q48: Sudoku Validator

**Problem:** Check if Sudoku board is valid.

**Logic:** Verify no duplicates in:
1. Each row
2. Each column
3. Each 3×3 box

---

## Q49: Jump Game

**Problem:** Can you reach last index? arr[i] = max jump from i.

**Logic (Detailed):**
Greedy - track farthest reachable position.

```java
int farthest = 0;
for (int i = 0; i < n; i++) {
    if (i > farthest) return false;  // Can't reach here
    farthest = Math.max(farthest, i + arr[i]);
}
return true;
```

---

## Q50: Climbing Stairs

**Problem:** Ways to climb n stairs (1 or 2 steps at a time).

**Logic (Detailed):**
This is Fibonacci! ways(n) = ways(n-1) + ways(n-2)

```java
// ways(1)=1, ways(2)=2
int prev2 = 1, prev1 = 2, current;
for (int i = 3; i <= n; i++) {
    current = prev1 + prev2;
    prev2 = prev1;
    prev1 = current;
}
```

**Example for n=4:** 5 ways
- 1+1+1+1
- 1+1+2
- 1+2+1
- 2+1+1
- 2+2
