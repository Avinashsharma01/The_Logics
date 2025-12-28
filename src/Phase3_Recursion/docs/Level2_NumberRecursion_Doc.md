# Phase 3 - Recursion | Level 2: Number Recursion (Q11-Q20)

## Overview
Number manipulation using recursive techniques.

---

## Q11: Count Digits Recursively

**Problem:** Count number of digits in a number.

**Logic (Detailed):**
- Remove one digit, count rest, add 1
- Each recursive call handles one digit
- Base case: single digit (n < 10) → return 1

**Recursive insight:**
```
countDigits(n) = 1 + countDigits(n / 10)
```

**Why divide by 10?**
- Removes the last digit
- 1234 / 10 = 123 (3 digits remaining)

**Trace for n=1234:**
```
countDigits(1234):
  return 1 + countDigits(123)
    return 1 + countDigits(12)
      return 1 + countDigits(1)
        return 1 (base case: 1 < 10)
      return 1 + 1 = 2
    return 1 + 2 = 3
  return 1 + 3 = 4

Result: 4 digits
```

---

## Q12: Reverse a Number Recursively

**Problem:** Reverse digits of a number.

**Logic (Detailed):**
- This is tricky because we need to BUILD the result
- Use helper function with accumulator
- Or use mathematical approach with digit count

**Method 1: Accumulator approach:**
```
reverse(n, rev):
  if n == 0 → return rev
  digit = n % 10
  return reverse(n / 10, rev * 10 + digit)
```

**Trace for n=1234:**
```
reverse(1234, 0):
  digit = 4
  reverse(123, 0*10 + 4 = 4):
    digit = 3
    reverse(12, 4*10 + 3 = 43):
      digit = 2
      reverse(1, 43*10 + 2 = 432):
        digit = 1
        reverse(0, 432*10 + 1 = 4321):
          return 4321 (base case)
```

**Method 2: Mathematical:**
```
reverse(n) = (n % 10) × 10^(digits-1) + reverse(n / 10)
```

---

## Q13: Check Palindrome Recursively

**Problem:** Check if number is palindrome.

**Logic (Detailed):**
- A palindrome reads same forwards and backwards
- Compare first and last digits
- If equal, check if middle is palindrome

**Method 1: Reverse and compare:**
```
isPalindrome(n):
  return n == reverse(n)
```

**Method 2: Compare digits recursively:**
```
For number with d digits:
  - First digit: n / 10^(d-1)
  - Last digit: n % 10
  - Middle: (n % 10^(d-1)) / 10
  
If first == last, check if middle is palindrome
```

**Example for n=12321:**
```
First digit: 12321 / 10000 = 1
Last digit: 12321 % 10 = 1
1 == 1 ✓

Middle: (12321 % 10000) / 10 = 2321 / 10 = 232

Check 232:
First: 2, Last: 2, Middle: 3
2 == 2 ✓

Check 3: single digit → palindrome ✓

Result: TRUE
```

---

## Q14: Product of Digits

**Problem:** Find product of all digits.

**Logic (Detailed):**
- Extract last digit, multiply with product of rest
- Similar structure to sum of digits, but multiply instead

**Recursive formula:**
```
productDigits(n) = (n % 10) × productDigits(n / 10)
```

**Base case:**
- n == 0 → return 1 (identity for multiplication)
- Or: n < 10 → return n

**Trace for n=234:**
```
productDigits(234):
  return 4 × productDigits(23)
    return 3 × productDigits(2)
      return 2 (base case: 2 < 10)
    return 3 × 2 = 6
  return 4 × 6 = 24

Result: 24
```

**Edge case:** If any digit is 0, product = 0

---

## Q15: GCD Using Recursion (Euclidean)

**Problem:** Find Greatest Common Divisor.

**Logic (Detailed):**
- Euclidean algorithm: GCD(a, b) = GCD(b, a % b)
- Base case: when b = 0, return a

**Why this works:**
- If d divides both a and b, it also divides (a % b)
- The GCD is preserved through the transformation
- Eventually b becomes 0, and a is the GCD

**Trace for GCD(48, 18):**
```
gcd(48, 18):
  return gcd(18, 48 % 18) = gcd(18, 12)
    return gcd(12, 18 % 12) = gcd(12, 6)
      return gcd(6, 12 % 6) = gcd(6, 0)
        return 6 (base case: b == 0)

Result: 6
```

**Mathematical proof:**
```
Let d = gcd(a, b)
a = d × m, b = d × n (for some m, n)
a % b = a - k×b = d×m - k×d×n = d×(m - k×n)
So d also divides (a % b)
```

---

## Q16: Decimal to Binary

**Problem:** Convert decimal to binary recursively.

**Logic (Detailed):**
- Binary representation uses only 0 and 1
- Each bit = remainder when divided by 2
- Recursively handle quotient, then print remainder

**Key insight - Order matters:**
- We get bits from right to left (LSB first)
- But we need to print left to right (MSB first)
- So: recurse first, THEN print

**Trace for n=13:**
```
decToBin(13):
  decToBin(13 / 2 = 6) → do this first
    decToBin(6 / 2 = 3)
      decToBin(3 / 2 = 1)
        decToBin(1 / 2 = 0)
          return (base case)
        print 1 % 2 = 1
      print 3 % 2 = 1
    print 6 % 2 = 0
  print 13 % 2 = 1

Output: 1101 (which is 13 in binary!)
```

**Verification:** 1×8 + 1×4 + 0×2 + 1×1 = 8+4+0+1 = 13 ✓

---

## Q17: Print Digits in Words

**Problem:** Print each digit as word.

**Logic (Detailed):**
- Process most significant digit first
- Recurse for n/10 first (handles digits left to right)
- Then print word for current last digit

**Trace for n=123:**
```
printWords(123):
  printWords(12) → first
    printWords(1) → first
      printWords(0) → base case, return
    print word for 1 % 10 = 1 → "One"
  print word for 12 % 10 = 2 → "Two"
print word for 123 % 10 = 3 → "Three"

Output: One Two Three
```

**Word mapping:**
```
0 → Zero, 1 → One, 2 → Two, 3 → Three, 4 → Four
5 → Five, 6 → Six, 7 → Seven, 8 → Eight, 9 → Nine
```

---

## Q18: Sum of Even Digits

**Problem:** Find sum of only even digits.

**Logic (Detailed):**
- Extract digit, check if even
- If even, add to sum of rest
- If odd, just return sum of rest

**Recursive formula:**
```
sumEvenDigits(n):
  if n == 0 → return 0
  digit = n % 10
  if digit is even:
    return digit + sumEvenDigits(n / 10)
  else:
    return sumEvenDigits(n / 10)
```

**Trace for n=12345:**
```
sumEvenDigits(12345):
  digit = 5 (odd) → sumEvenDigits(1234)
    digit = 4 (even) → 4 + sumEvenDigits(123)
      digit = 3 (odd) → sumEvenDigits(12)
        digit = 2 (even) → 2 + sumEvenDigits(1)
          digit = 1 (odd) → sumEvenDigits(0)
            return 0
          return 0
        return 2 + 0 = 2
      return 2
    return 4 + 2 = 6
  return 6

Result: 6 (even digits: 2, 4)
```

---

## Q19: Sum of Odd Digits

**Problem:** Find sum of only odd digits.

**Logic (Detailed):**
- Same structure as Q18
- Check for odd instead (digit % 2 != 0)

**For n=12345:**
- Odd digits: 1, 3, 5
- Sum = 1 + 3 + 5 = 9

---

## Q20: Nth Fibonacci Number

**Problem:** Find nth Fibonacci using recursion.

**Logic (Detailed):**
- Fibonacci: F(n) = F(n-1) + F(n-2)
- Base cases: F(0) = 0, F(1) = 1

**Recursive formula:**
```
fib(n):
  if n <= 1 → return n
  return fib(n-1) + fib(n-2)
```

**Trace for fib(5):**
```
fib(5) = fib(4) + fib(3)
       = (fib(3) + fib(2)) + (fib(2) + fib(1))
       = ((fib(2)+fib(1)) + (fib(1)+fib(0))) + ((fib(1)+fib(0)) + 1)
       = ((1+1) + (1+0)) + ((1+0) + 1)
       = (2 + 1) + (1 + 1)
       = 3 + 2
       = 5
```

**WARNING - Inefficiency:**
- Pure recursion recalculates same values many times!
- fib(5) calculates fib(3) twice, fib(2) three times!
- Time complexity: O(2^n) - exponential!

**Solution - Memoization:**
- Store calculated values
- Before recursing, check if already computed
- Reduces to O(n) time complexity
