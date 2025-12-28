# Phase 6 - Mixed Challenges | Level 1: Number Logic (Q1-Q10)

## Overview
Complex number-based problems combining multiple concepts.

---

## Q1: Perfect Number Check

**Problem:** Check if sum of proper divisors equals the number.

**Logic (Detailed):**
- Proper divisors: all divisors except the number itself
- Example: 28 → divisors: 1,2,4,7,14 → sum = 28 ✓

```java
int sum = 0;
for (int i = 1; i <= n / 2; i++) {
    if (n % i == 0) sum += i;
}
return sum == n;
```

**Perfect numbers:** 6, 28, 496, 8128...

---

## Q2: Abundant vs Deficient

**Problem:** Classify based on sum of proper divisors.

**Logic:**
- **Abundant:** sum > n (e.g., 12: 1+2+3+4+6=16 > 12)
- **Perfect:** sum = n
- **Deficient:** sum < n (e.g., 8: 1+2+4=7 < 8)

---

## Q3: Nth Fibonacci Number

**Problem:** Find F(n) where F(n) = F(n-1) + F(n-2).

**Logic (Detailed):**
```java
int prev2 = 0, prev1 = 1, current = 0;
for (int i = 3; i <= n; i++) {
    current = prev1 + prev2;
    prev2 = prev1;
    prev1 = current;
}
```

**Sequence:** 0, 1, 1, 2, 3, 5, 8, 13, 21...

---

## Q4: Check if Fibonacci Number

**Problem:** Is n in the Fibonacci sequence?

**Logic (Detailed):**

**Mathematical property:** n is Fibonacci if (5n² + 4) or (5n² - 4) is a perfect square.

```java
boolean isFib = isPerfectSquare(5L*n*n + 4) || isPerfectSquare(5L*n*n - 4);
```

---

## Q5: Happy Number

**Problem:** Replace number with sum of squares of digits until 1 or cycle.

**Logic (Detailed):**

**Example:** 19 → 1²+9²=82 → 68 → 100 → 1 ✓ Happy!

Use Floyd's cycle detection:
```java
int slow = n, fast = n;
do {
    slow = sumOfSquares(slow);
    fast = sumOfSquares(sumOfSquares(fast));
} while (slow != fast && slow != 1);
return slow == 1;
```

---

## Q6: Strong Number

**Problem:** Sum of factorial of digits equals number.

**Logic:** 145 = 1! + 4! + 5! = 1 + 24 + 120 = 145 ✓

---

## Q7: Harshad (Niven) Number

**Problem:** Number divisible by sum of its digits.

**Logic:** 18 → 1+8=9 → 18÷9=2 (divisible) ✓

---

## Q8: Pronic Number

**Problem:** Product of two consecutive integers: n = k × (k+1)

**Examples:** 6=2×3, 12=3×4, 20=4×5, 30=5×6

---

## Q9: Automorphic Number

**Problem:** Square ends with the number itself.

**Examples:**
- 5² = 25 (ends with 5) ✓
- 6² = 36 (ends with 6) ✓
- 25² = 625 (ends with 25) ✓
- 76² = 5776 (ends with 76) ✓

---

## Q10: Kaprekar Number

**Problem:** Square can be split into two parts that sum to original.

**Examples:**
- 9² = 81 → 8+1 = 9 ✓
- 45² = 2025 → 20+25 = 45 ✓
- 297² = 88209 → 88+209 = 297 ✓
