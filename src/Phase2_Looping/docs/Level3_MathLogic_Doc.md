# Phase 2 - Looping | Level 3: Math Logic (Q21-Q30)

## Overview
Mathematical computations using loops - GCD, LCM, factors, and series.

---

## Q21: Print Squares of 1 to N

**Problem:** Print n² for each n from 1 to N.

**Logic (Detailed):**
- Square of a number = number × itself
- i² = i × i
- Loop from 1 to n, calculate and print each square

**Pattern observation:**
```
1² = 1
2² = 4    (difference from previous: 3)
3² = 9    (difference: 5)
4² = 16   (difference: 7)
5² = 25   (difference: 9)
```

**Interesting insight:**
- Difference between consecutive squares = 2n + 1 (odd numbers!)
- n² - (n-1)² = n² - n² + 2n - 1 = 2n - 1

---

## Q22: Print Cubes of 1 to N

**Problem:** Print n³ for each n from 1 to N.

**Logic (Detailed):**
- Cube of a number = number × itself × itself
- i³ = i × i × i

**Visual understanding:**
- A cube with side n has n³ unit cubes
- 3³ = 27 (imagine a Rubik's cube: 3×3×3 = 27 small cubes)

**Pattern:**
```
1³ = 1
2³ = 8
3³ = 27
4³ = 64
5³ = 125
```

**Fascinating property:**
- Sum of first n cubes = (sum of first n numbers)²
- 1³ + 2³ + 3³ = 1 + 8 + 27 = 36 = 6² = (1+2+3)²

---

## Q23: Numbers Divisible by 7 in Range

**Problem:** Print all numbers divisible by 7 in given range.

**Logic (Detailed):**
- A number is divisible by 7 if n % 7 == 0
- Loop through range, check each number

**Efficient approach:**
- Find first multiple of 7 ≥ start
- Then jump by 7 each time

**Finding first multiple:**
```
start = 15
First multiple of 7 >= 15:
15 / 7 = 2 (integer division)
2 × 7 = 14 (too small)
3 × 7 = 21 (first one!)

Formula: first = ((start + 6) / 7) × 7
Or: first = start + (7 - start % 7) % 7
```

---

## Q24: Find GCD/HCF using Euclidean Algorithm

**Problem:** Find Greatest Common Divisor of two numbers.

**Logic (Detailed):**
- GCD = largest number that divides both numbers
- Euclidean algorithm: GCD(a, b) = GCD(b, a % b)
- Repeat until b becomes 0

**Why Euclidean algorithm works:**
- If d divides both a and b, it also divides (a - b)
- More generally, it divides (a % b)
- So GCD(a, b) = GCD(b, a % b)

**Step-by-step for GCD(48, 18):**
```
GCD(48, 18)
= GCD(18, 48 % 18) = GCD(18, 12)
= GCD(12, 18 % 12) = GCD(12, 6)
= GCD(6, 12 % 6) = GCD(6, 0)
= 6 (when second number is 0, first is GCD)
```

**Why is this fast?**
- At each step, remainder < divisor
- Number of steps ≈ log(min(a,b))
- Much faster than checking all divisors!

**Alternative (naive) method:**
- Check all numbers from min(a,b) down to 1
- First one that divides both is GCD
- This is O(min(a,b)) - much slower!

---

## Q25: Find LCM

**Problem:** Find Least Common Multiple.

**Logic (Detailed):**
- LCM = smallest number divisible by both a and b
- Key formula: LCM(a, b) = (a × b) / GCD(a, b)

**Why this formula works:**
- Every common multiple is a × k = b × m for some k, m
- The smallest one relates to how a and b share factors
- GCD captures the shared factors; dividing removes double-counting

**Step-by-step for LCM(4, 6):**
```
GCD(4, 6):
  GCD(4, 6) = GCD(6, 4) = GCD(4, 2) = GCD(2, 0) = 2

LCM = (4 × 6) / 2 = 24 / 2 = 12

Verify: 12 / 4 = 3 ✓, 12 / 6 = 2 ✓
```

**Alternative (naive) method:**
- Start from max(a, b)
- Check if divisible by both
- Increment until found

---

## Q26: Find All Factors

**Problem:** Print all divisors of a number.

**Logic (Detailed):**
- Factor/Divisor: number that divides evenly (no remainder)
- Check each number from 1 to n

**Optimized approach (check only up to √n):**
- Factors come in pairs: if i divides n, so does n/i
- For 36: (1,36), (2,18), (3,12), (4,9), (6,6)
- Only need to find one of each pair!

**Step-by-step for n=36:**
```
√36 = 6, so check 1 to 6:
1 divides 36 → pair: (1, 36)
2 divides 36 → pair: (2, 18)
3 divides 36 → pair: (3, 12)
4 divides 36 → pair: (4, 9)
5 doesn't divide 36
6 divides 36 → pair: (6, 6) - same number!

All factors: 1, 2, 3, 4, 6, 9, 12, 18, 36
```

**Special case:**
- Perfect squares have odd number of factors
- The √n factor pairs with itself

---

## Q27: Sum of All Factors

**Problem:** Find sum of all divisors.

**Logic (Detailed):**
- Find all factors (like Q26)
- Add them all together

**Using the pair optimization:**
```
For n=12:
√12 ≈ 3.46, check 1 to 3

i=1: 12%1=0, factors: 1, 12 → sum += 1 + 12 = 13
i=2: 12%2=0, factors: 2, 6 → sum += 2 + 6 = 21
i=3: 12%3=0, factors: 3, 4 → sum += 3 + 4 = 28

Sum of factors of 12 = 28
```

**Watch for perfect squares:**
- Don't add √n twice when i == n/i

---

## Q28: Strong Number Check

**Problem:** Sum of factorial of digits equals number.

**Logic (Detailed):**
- Extract each digit
- Calculate factorial of each digit
- Sum all factorials
- Compare with original

**Important optimization:**
- Digit can only be 0-9
- Pre-calculate factorials: 0!=1, 1!=1, 2!=2, 3!=6, 4!=24, 5!=120, 6!=720, 7!=5040, 8!=40320, 9!=362880

**Step-by-step for n=145:**
```
Digits: 1, 4, 5

1! = 1
4! = 24
5! = 120

Sum = 1 + 24 + 120 = 145

145 == 145? YES → Strong number!
```

**All strong numbers:**
- Only 4 exist: 1, 2, 145, 40585
- 1: 1! = 1 ✓
- 2: 2! = 2 ✓

---

## Q29: Print AP Series

**Problem:** Print Arithmetic Progression series.

**Logic (Detailed):**
- AP: sequence with constant difference
- Each term = previous term + common difference
- General term: aₙ = a + (n-1)d

**Components:**
- a = first term
- d = common difference
- n = number of terms

**Example: a=2, d=3, n=5:**
```
Term 1: 2
Term 2: 2 + 3 = 5
Term 3: 5 + 3 = 8
Term 4: 8 + 3 = 11
Term 5: 11 + 3 = 14

Series: 2, 5, 8, 11, 14
```

**Sum of AP:**
- Sum = n/2 × (2a + (n-1)d)
- Or: Sum = n/2 × (first term + last term)

---

## Q30: Print GP Series

**Problem:** Print Geometric Progression series.

**Logic (Detailed):**
- GP: sequence with constant ratio
- Each term = previous term × common ratio
- General term: aₙ = a × r^(n-1)

**Components:**
- a = first term
- r = common ratio
- n = number of terms

**Example: a=2, r=3, n=5:**
```
Term 1: 2
Term 2: 2 × 3 = 6
Term 3: 6 × 3 = 18
Term 4: 18 × 3 = 54
Term 5: 54 × 3 = 162

Series: 2, 6, 18, 54, 162
```

**Sum of GP:**
- If r ≠ 1: Sum = a × (r^n - 1) / (r - 1)
- If r = 1: Sum = n × a

**Real-world GPs:**
- Compound interest
- Population growth
- Radioactive decay (r < 1)
