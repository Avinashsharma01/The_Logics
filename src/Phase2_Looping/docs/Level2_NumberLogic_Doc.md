# Phase 2 - Looping | Level 2: Number Logic (Q11-Q20)

## Overview
Number-based logic problems using loops - digit manipulation and special numbers.

---

## Q11: Count Digits in a Number

**Problem:** Count how many digits in a number.

**Logic (Detailed):**
- Every time we divide by 10, we remove one digit
- Count how many times we can divide until number becomes 0
- This count = number of digits

**Why dividing by 10 works:**
```
1234 → 4 digits
1234 / 10 = 123 (removed 1 digit) → count = 1
123 / 10 = 12 (removed 1 digit)  → count = 2
12 / 10 = 1 (removed 1 digit)    → count = 3
1 / 10 = 0 (removed 1 digit)     → count = 4
n = 0 → STOP
```

**Mathematical alternative:**
- Digits = floor(log₁₀(n)) + 1
- For n=1234: log₁₀(1234) ≈ 3.09, floor = 3, +1 = 4 digits
- But loop method is easier to understand!

**Edge case:** n = 0 has 1 digit (special handling needed)

---

## Q12: Reverse a Number

**Problem:** Reverse the digits of a number.

**Logic (Detailed):**
- Extract digits from the END (using % 10)
- Build new number from the FRONT
- Each new digit is added to reversed × 10

**The key formula:**
```
reverse = reverse × 10 + digit
```

**Why this works (building a number):**
```
To build 4321 from digits 4, 3, 2, 1:
reverse = 0
reverse = 0 × 10 + 4 = 4
reverse = 4 × 10 + 3 = 43
reverse = 43 × 10 + 2 = 432
reverse = 432 × 10 + 1 = 4321
```

**Step-by-step for n=1234:**
```
Original: 1234, Reverse: 0

digit = 1234 % 10 = 4
reverse = 0 × 10 + 4 = 4
n = 1234 / 10 = 123

digit = 123 % 10 = 3
reverse = 4 × 10 + 3 = 43
n = 123 / 10 = 12

digit = 12 % 10 = 2
reverse = 43 × 10 + 2 = 432
n = 12 / 10 = 1

digit = 1 % 10 = 1
reverse = 432 × 10 + 1 = 4321
n = 1 / 10 = 0

STOP → Reversed = 4321
```

---

## Q13: Check Palindrome Number

**Problem:** Check if number reads same forwards and backwards.

**Logic (Detailed):**
- A palindrome reads the same from both directions
- Examples: 121, 1331, 12321
- **Method:** Reverse the number, compare with original

**Why compare with reverse?**
- If n = reverse(n), it's the same both ways
- 121 reversed = 121 ✓ (palindrome)
- 123 reversed = 321 ✗ (not palindrome)

**Important:** Store original before reversing!
```
original = n  // Save it!
reverse = reverseNumber(n)
if original == reverse → Palindrome!
```

**Step-by-step for n=121:**
```
original = 121
Reverse 121 → 121
121 == 121? YES → Palindrome!
```

---

## Q14: Sum of Digits

**Problem:** Find sum of all digits in a number.

**Logic (Detailed):**
- Extract each digit using % 10
- Add to running sum
- Remove digit using / 10
- Repeat until number becomes 0

**Step-by-step for n=456:**
```
sum = 0

digit = 456 % 10 = 6
sum = 0 + 6 = 6
n = 456 / 10 = 45

digit = 45 % 10 = 5
sum = 6 + 5 = 11
n = 45 / 10 = 4

digit = 4 % 10 = 4
sum = 11 + 4 = 15
n = 4 / 10 = 0

STOP → Sum = 15
```

**Applications:**
- Divisibility by 9: If digit sum divisible by 9, number is too
- Divisibility by 3: If digit sum divisible by 3, number is too
- Digital root: Keep summing until single digit

---

## Q15: Armstrong Number Check

**Problem:** Check if sum of cubes of digits equals the number (for 3-digit numbers).

**Logic (Detailed):**
- Armstrong number: sum of (each digit)^(number of digits) = number
- For 3-digit: abc = a³ + b³ + c³
- For n-digit: each digit raised to power n

**Why cubes for 3-digit numbers?**
- General rule: use power = number of digits
- 153 has 3 digits, so we use cubes
- 1634 has 4 digits, so we use 4th power

**Step-by-step for n=153:**
```
153 has 3 digits, so use power = 3

digit = 3, sum = 3³ = 27
digit = 5, sum = 27 + 5³ = 27 + 125 = 152
digit = 1, sum = 152 + 1³ = 152 + 1 = 153

153 == 153? YES → Armstrong number!
```

**Famous Armstrong numbers:**
- 3-digit: 153, 370, 371, 407
- 4-digit: 1634, 8208, 9474

---

## Q16: Perfect Number Check

**Problem:** Sum of proper divisors equals the number.

**Logic (Detailed):**
- Proper divisors = all divisors EXCEPT the number itself
- For 6: divisors are 1, 2, 3, 6. Proper divisors: 1, 2, 3
- Sum = 1 + 2 + 3 = 6 = original ✓

**Why check only up to n/2?**
- No proper divisor can be > n/2
- If d divides n and d > n/2, then n/d < 2
- Only possibility is d = n (not a proper divisor)

**Step-by-step for n=28:**
```
Check divisors from 1 to 14 (28/2):
1 divides 28 ✓ → sum = 1
2 divides 28 ✓ → sum = 3
4 divides 28 ✓ → sum = 7
7 divides 28 ✓ → sum = 14
14 divides 28 ✓ → sum = 28

Sum = 28 = original → Perfect number!
```

**Perfect numbers are rare:**
- 6, 28, 496, 8128, 33550336...
- All known perfect numbers are EVEN
- Related to Mersenne primes: 2^(p-1) × (2^p - 1)

---

## Q17: Print All Prime Numbers up to N

**Problem:** Print all primes from 2 to n.

**Logic (Detailed):**
- Prime: divisible only by 1 and itself
- Check each number from 2 to n
- For each, verify if it's prime

**How to check if number is prime:**
- Try dividing by all numbers from 2 to √n
- If any divides evenly, NOT prime
- If none divide, it IS prime

**Why only check up to √n?**
- If n = a × b, one factor must be ≤ √n
- If we've checked all up to √n and found nothing, number is prime
- This reduces checks significantly!

**Example: Is 37 prime?**
```
√37 ≈ 6.08, so check 2, 3, 4, 5, 6
37 % 2 = 1 (not divisible)
37 % 3 = 1 (not divisible)
37 % 4 = 1 (not divisible)
37 % 5 = 2 (not divisible)
37 % 6 = 1 (not divisible)
No divisors found → 37 is PRIME
```

---

## Q18: Check if Number is Prime

**Problem:** Determine if a single number is prime.

**Logic (Detailed):**
- Prime has exactly 2 factors: 1 and itself
- 1 is NOT prime (only 1 factor)
- 2 is the only even prime

**Optimized prime check:**
1. If n < 2, not prime
2. If n == 2, prime (only even prime)
3. If n is even, not prime
4. Check odd divisors from 3 to √n

**Why skip even divisors after 2?**
- If n is divisible by any even number, it's divisible by 2
- We already checked 2 separately
- So only check odd numbers: 3, 5, 7, 9...

**Step-by-step for n=29:**
```
29 >= 2? YES
29 == 2? NO
29 is even? NO (29 % 2 = 1)
Check 3: 29 % 3 = 2 (not divisible)
Check 5: 29 % 5 = 4 (not divisible)
√29 ≈ 5.4, so we stop
No divisors → 29 is PRIME
```

---

## Q19: Print Fibonacci Series up to N Terms

**Problem:** Print first n Fibonacci numbers.

**Logic (Detailed):**
- Fibonacci: each number = sum of previous two
- F(n) = F(n-1) + F(n-2)
- Start: F(0) = 0, F(1) = 1

**The sequence:**
```
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55...
     ↑
    0+1=1, 1+1=2, 1+2=3, 2+3=5...
```

**How to generate:**
```
a = 0, b = 1 (first two numbers)
print a, print b
next = a + b = 1
a = b = 1
b = next = 1
next = a + b = 2
...and so on
```

**Real-world appearances:**
- Flower petals often Fibonacci numbers
- Spiral patterns in shells and galaxies
- Golden ratio: F(n+1)/F(n) approaches 1.618...

---

## Q20: Sum of Fibonacci Series

**Problem:** Find sum of first n Fibonacci numbers.

**Logic (Detailed):**
- Generate Fibonacci series
- Add each term to running sum

**Beautiful shortcut:**
- Sum of first n Fibonacci = F(n+2) - 1
- For n=7: Sum = F(9) - 1 = 34 - 1 = 33

**Verification for n=7:**
```
F: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
First 7: 0+1+1+2+3+5+8 = 20
F(9) = 34, 34 - 1 = 33
Wait... let's recount: starting from F(1)=1
1+1+2+3+5+8+13 = 33 ✓
```

**Note:** Be careful about indexing (0-based vs 1-based)!
