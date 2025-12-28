# Phase 2 - Looping | Level 5: Logical Combinations (Q31-Q40)

## Overview
Complex problems combining multiple loop concepts.

---

## Q31: Numbers with Even Digit Sum

**Problem:** Print numbers 1-100 with even digit sum.

**Logic (Detailed):**
- For each number, calculate sum of its digits
- Check if that sum is even (divisible by 2)
- Print if yes

**Why combine two concepts:**
- Outer loop: iterate through range
- Inner logic: calculate digit sum for each number

**Step-by-step for checking 47:**
```
n = 47
Digit sum: 4 + 7 = 11
Is 11 even? 11 % 2 = 1 (NO)
Don't print 47

n = 48
Digit sum: 4 + 8 = 12
Is 12 even? 12 % 2 = 0 (YES)
Print 48!
```

---

## Q32: Divisible by 7 but not 5

**Problem:** Print numbers divisible by 7 but NOT by 5.

**Logic (Detailed):**
- Condition 1: n % 7 == 0 (divisible by 7)
- Condition 2: n % 5 != 0 (NOT divisible by 5)
- Both conditions must be true (AND)

**Why use AND (&&):**
- Both conditions must be satisfied simultaneously
- "divisible by 7" AND "not divisible by 5"

**Example analysis:**
```
35: 35 % 7 = 0 ✓, 35 % 5 = 0 ✗ → Skip (divisible by both)
7:  7 % 7 = 0 ✓, 7 % 5 = 2 ✓ → Print!
21: 21 % 7 = 0 ✓, 21 % 5 = 1 ✓ → Print!
70: 70 % 7 = 0 ✓, 70 % 5 = 0 ✗ → Skip
```

**Pattern:** Multiples of 35 (LCM of 7 and 5) are excluded

---

## Q33: All Palindromes 1 to 500

**Problem:** Find all palindrome numbers in range.

**Logic (Detailed):**
- For each number, reverse it
- Compare with original
- If equal, it's a palindrome

**Key insight:**
- Single-digit numbers (1-9) are always palindromes
- Two-digit palindromes: 11, 22, 33, ..., 99
- Three-digit palindromes: 101, 111, 121, 131, ...

**Efficient for 3-digit:**
- For 3-digit palindrome ABC: A must equal C
- Middle digit B can be anything
- So check: first digit == last digit

**Palindromes up to 500:**
```
1-9: All 9 numbers (1,2,3,4,5,6,7,8,9)
10-99: 11,22,33,44,55,66,77,88,99 (9 numbers)
100-500: 101,111,121,131,141,...,191,
         202,212,222,...,292,
         303,313,...,393,
         404,414,...,494 (40 numbers)
```

---

## Q34: Digit Sum Divisible by 3

**Problem:** Numbers whose digit sum is multiple of 3.

**Logic (Detailed):**
- Calculate sum of digits
- Check if sum % 3 == 0

**Mathematical insight (Divisibility rule for 3):**
- A number is divisible by 3 if and only if its digit sum is divisible by 3
- This is NOT a coincidence!

**Why this rule works:**
```
Any number = aₙ×10ⁿ + ... + a₁×10 + a₀
10 ≡ 1 (mod 3), so 10ⁿ ≡ 1 (mod 3)
Therefore: number ≡ aₙ + ... + a₁ + a₀ (mod 3)
                  ≡ digit sum (mod 3)
```

**This means:** Finding numbers with digit sum divisible by 3 = finding numbers divisible by 3!

---

## Q35: Smallest and Largest Digit

**Problem:** Find smallest and largest digit in a number.

**Logic (Detailed):**
- Track two values: min and max
- Initialize min = 9, max = 0 (or use first digit)
- For each digit, update min and max

**Why initialize min=9, max=0?**
- Any digit (0-9) will be ≤ 9, so if we start min at 9, first digit will become new min
- Any digit (0-9) will be ≥ 0, so if we start max at 0, first digit will become new max

**Step-by-step for n=3927:**
```
min = 9, max = 0

digit = 7: min = min(9,7) = 7, max = max(0,7) = 7
digit = 2: min = min(7,2) = 2, max = max(7,2) = 7
digit = 9: min = min(2,9) = 2, max = max(7,9) = 9
digit = 3: min = min(2,3) = 2, max = max(9,3) = 9

Result: smallest = 2, largest = 9
```

---

## Q36: Count 1s in Binary

**Problem:** Count number of 1 bits in binary representation.

**Logic (Detailed):**
- Binary uses only 0s and 1s
- We need to count how many 1s
- Use bitwise AND with 1 to check last bit

**How n & 1 works:**
```
n & 1 isolates the last (rightmost) bit
If n ends in 1: n & 1 = 1
If n ends in 0: n & 1 = 0

13 = 1101 in binary
13 & 1 = 1101 & 0001 = 0001 = 1 (last bit is 1)
```

**How n >> 1 works (right shift):**
```
Shifts all bits right by 1, removing last bit
13 = 1101
13 >> 1 = 110 = 6
```

**Step-by-step for n=13 (binary: 1101):**
```
n = 13 (1101), count = 0
n & 1 = 1 → count = 1, n = 13 >> 1 = 6 (110)
n & 1 = 0 → count = 1, n = 6 >> 1 = 3 (11)
n & 1 = 1 → count = 2, n = 3 >> 1 = 1 (1)
n & 1 = 1 → count = 3, n = 1 >> 1 = 0

Result: 3 ones in binary of 13
```

**Alternative (Brian Kernighan's Algorithm):**
- n = n & (n-1) removes the rightmost 1 bit
- Count how many times we can do this

---

## Q37: Print Pattern i×i

**Problem:** Print sequential numbers in increasing rows.

**Logic (Detailed):**
- Row 1: 1 number
- Row 2: 2 numbers
- Row 3: 3 numbers
- Numbers continue sequentially

**Pattern:**
```
1
2 3
4 5 6
7 8 9 10
```

**Understanding the sequence:**
- We need a single counter that keeps incrementing
- Outer loop controls rows
- Inner loop controls columns (= row number)

**Step-by-step:**
```
num = 1
Row 1: print 1, then newline. num = 2
Row 2: print 2, 3, then newline. num = 4
Row 3: print 4, 5, 6, then newline. num = 7
Row 4: print 7, 8, 9, 10, then newline. num = 11
```

---

## Q38: Print All Factorials 1 to N

**Problem:** Print factorial of each number from 1 to n.

**Logic (Detailed):**
- Calculate 1!, 2!, 3!, ..., n!
- Key insight: n! = (n-1)! × n
- So we can BUILD on previous result!

**Naive approach (inefficient):**
```
for each i from 1 to n:
    calculate i! from scratch (1×2×...×i)
```
- This recalculates everything each time!

**Efficient approach (reuse):**
```
fact = 1
for i from 1 to n:
    fact = fact × i  // builds on previous
    print i! = fact
```

**Step-by-step for n=5:**
```
fact = 1
i=1: fact = 1 × 1 = 1, print "1! = 1"
i=2: fact = 1 × 2 = 2, print "2! = 2"
i=3: fact = 2 × 3 = 6, print "3! = 6"
i=4: fact = 6 × 4 = 24, print "4! = 24"
i=5: fact = 24 × 5 = 120, print "5! = 120"
```

---

## Q39: Separate Odd/Even Digit Sums

**Problem:** Find sum of odd digits and even digits separately.

**Logic (Detailed):**
- Extract each digit
- Check if digit is odd or even
- Add to appropriate sum

**Step-by-step for n=12345:**
```
oddSum = 0, evenSum = 0

digit = 5 (odd):  oddSum = 0 + 5 = 5
digit = 4 (even): evenSum = 0 + 4 = 4
digit = 3 (odd):  oddSum = 5 + 3 = 8
digit = 2 (even): evenSum = 4 + 2 = 6
digit = 1 (odd):  oddSum = 8 + 1 = 9

Result: oddSum = 9 (1+3+5), evenSum = 6 (2+4)
```

**Key insight:**
- We're checking the DIGIT's parity, not its position
- digit % 2 == 0 means digit is even

---

## Q40: Continue Statement Practice

**Problem:** Skip certain values in a loop.

**Logic (Detailed):**
- `continue` skips the rest of current iteration
- Jumps to next iteration immediately
- Different from `break` (which exits loop entirely)

**Comparison:**
```
for i = 1 to 5:
    if i == 3:
        continue    // Skip only i=3
    print i
Output: 1, 2, 4, 5

for i = 1 to 5:
    if i == 3:
        break       // Exit loop at i=3
    print i
Output: 1, 2
```

**Common use cases:**
- Skip negative numbers in processing
- Skip already-processed items
- Skip invalid inputs

**Example: Skip multiples of 3:**
```
for i = 1 to 10:
    if i % 3 == 0:
        continue
    print i

Output: 1, 2, 4, 5, 7, 8, 10
(3, 6, 9 are skipped)
```

**Nested loops:**
- `continue` only affects the innermost loop
- Use labeled continue for outer loops
