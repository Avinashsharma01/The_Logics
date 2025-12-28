# Phase 2 - Looping | Level 1: Basic Looping (Q1-Q10)

## Overview
Basic loop patterns - foundation for all iterative logic.

---

## Q1: Print Numbers 1 to 10

**Problem:** Print numbers from 1 to 10.

**Logic (Detailed):**
- A loop repeats a block of code multiple times
- We need to start from 1 and go up to 10
- Each iteration, we print the current number and move to next
- The loop variable `i` acts as our counter
- We initialize it to 1 (starting point)
- We continue while i ≤ 10 (stopping condition)
- We increment i by 1 after each iteration (progress)

**Why it works:**
```
i=1: print 1, then i becomes 2
i=2: print 2, then i becomes 3
...
i=10: print 10, then i becomes 11
i=11: condition (i≤10) is FALSE, loop stops
```

**Three parts of a for loop:**
1. **Initialization:** `i = 1` - where to start
2. **Condition:** `i <= 10` - when to stop
3. **Update:** `i++` - how to progress

---

## Q2: Print Even Numbers 1 to 20

**Problem:** Print all even numbers between 1 and 20.

**Logic (Detailed):**
- Even numbers are divisible by 2 (remainder = 0)
- Even numbers: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20
- **Method 1:** Check every number, print if even
- **Method 2:** Start from 2, increment by 2 (more efficient!)

**Why Method 2 is better:**
- Method 1: Checks 20 numbers, prints 10
- Method 2: Checks and prints only 10 numbers
- Skipping odd numbers saves unnecessary iterations

**Mathematical insight:**
- Even number = 2 × k (where k = 1, 2, 3...)
- Every second number starting from 2 is even
- Pattern: 2, 4, 6, 8... (constant difference of 2)

**Step-by-step execution:**
```
i=2: print 2, i becomes 4
i=4: print 4, i becomes 6
...continues until i=20
i=22: condition fails, stop
```

---

## Q3: Print Odd Numbers 1 to 20

**Problem:** Print all odd numbers between 1 and 20.

**Logic (Detailed):**
- Odd numbers give remainder 1 when divided by 2
- Odd numbers: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19
- Start from 1 (first odd), jump by 2 each time

**Mathematical insight:**
- Odd number = 2k + 1 (where k = 0, 1, 2...)
- odd + 2 = next odd (1+2=3, 3+2=5, etc.)
- The difference between consecutive odds is always 2

**Why this pattern works:**
- If n is odd, n+1 is even, n+2 is odd again
- So skipping by 2 from any odd gives next odd

---

## Q4: Countdown from N to 1

**Problem:** Print countdown from N to 1.

**Logic (Detailed):**
- Unlike counting up, we count DOWN here
- Start from the largest number (n)
- Decrease by 1 each time
- Stop when we reach 0 (when i < 1)

**Key insight - Decrementing loop:**
- Initialize: `i = n` (start from top)
- Condition: `i >= 1` (continue until 1)
- Update: `i--` (decrease by 1)

**Example with n=5:**
```
i=5: print 5, i becomes 4
i=4: print 4, i becomes 3
i=3: print 3, i becomes 2
i=2: print 2, i becomes 1
i=1: print 1, i becomes 0
i=0: condition (i>=1) is FALSE, stop
```

**When to use decrementing loops:**
- Countdowns
- Processing from end to beginning
- Reverse traversals

---

## Q5: Multiplication Table

**Problem:** Print multiplication table of a number.

**Logic (Detailed):**
- Multiplication table shows: n×1, n×2, n×3, ... n×10
- We multiply input number with 1 through 10
- The multiplier (1 to 10) is our loop variable
- The number (n) stays constant throughout

**Breaking down the pattern:**
```
5 × 1 = 5   → n × i where i=1
5 × 2 = 10  → n × i where i=2
5 × 3 = 15  → n × i where i=3
...
5 × 10 = 50 → n × i where i=10
```

**Why use loop variable as multiplier:**
- n is fixed (user input)
- Only the multiplier changes (1, 2, 3...10)
- The changing value should be the loop variable

---

## Q6: Sum of First N Natural Numbers

**Problem:** Find sum of 1 + 2 + 3 + ... + n.

**Logic (Detailed):**
- We need to add numbers from 1 to n
- Use an "accumulator" variable to store running sum
- Start with sum = 0 (nothing added yet)
- Add each number one by one

**Accumulator Pattern explained:**
```
sum = 0 (initial)
sum = 0 + 1 = 1
sum = 1 + 2 = 3
sum = 3 + 3 = 6
sum = 6 + 4 = 10
sum = 10 + 5 = 15
Final: 15
```

**Why initialize sum = 0?**
- 0 is the "identity element" for addition
- x + 0 = x (adding 0 doesn't change value)
- Starting with 0 means first addition gives first number
- Any other starting value would give wrong result

**Mathematical shortcut (Gauss's Formula):**
```
sum = n × (n + 1) / 2
For n=100: sum = 100 × 101 / 2 = 5050
```
- Story: Young Gauss found this when asked to sum 1-100
- Paired numbers: 1+100=101, 2+99=101... 50 pairs of 101

---

## Q7: Sum of Even Numbers up to N

**Problem:** Find sum of even numbers from 1 to n.

**Logic (Detailed):**
- Similar to Q6, but only add EVEN numbers
- Even numbers: 2, 4, 6, 8, ... up to n
- Use step of 2 to only visit even numbers

**Example for n=10:**
```
Even numbers: 2, 4, 6, 8, 10
Sum = 2 + 4 + 6 + 8 + 10 = 30
```

**Mathematical insight:**
- Sum of first k even numbers = k × (k + 1)
- k = n/2 (count of even numbers up to n)
- For n=10: k=5, sum = 5 × 6 = 30

**Why step by 2?**
- Visiting every number and checking: O(n) checks
- Stepping by 2: O(n/2) iterations, no checks
- More efficient!

---

## Q8: Sum of Odd Numbers up to N

**Problem:** Find sum of odd numbers from 1 to n.

**Logic (Detailed):**
- Only add ODD numbers (1, 3, 5, 7, ...)
- Start from 1, increment by 2 each time

**Example for n=10:**
```
Odd numbers: 1, 3, 5, 7, 9
Sum = 1 + 3 + 5 + 7 + 9 = 25
```

**Beautiful mathematical insight:**
- Sum of first k odd numbers = k²
- 1 = 1² = 1
- 1 + 3 = 2² = 4
- 1 + 3 + 5 = 3² = 9
- 1 + 3 + 5 + 7 = 4² = 16
- This is why perfect squares matter!

---

## Q9: Factorial of N

**Problem:** Find n! = 1 × 2 × 3 × ... × n.

**Logic (Detailed):**
- Factorial is product of all numbers from 1 to n
- n! = n × (n-1) × (n-2) × ... × 2 × 1
- Use "product accumulator" (like sum, but multiply)
- **MUST start with result = 1 (NOT 0!)**

**Why start with 1, not 0?**
- 0 is identity for addition (x + 0 = x)
- 1 is identity for multiplication (x × 1 = x)
- Starting with 0 would make EVERYTHING 0!

**Step-by-step for n=5:**
```
result = 1
result = 1 × 1 = 1
result = 1 × 2 = 2
result = 2 × 3 = 6
result = 6 × 4 = 24
result = 24 × 5 = 120
5! = 120
```

**Special cases:**
- 0! = 1 (by mathematical definition)
- 1! = 1
- Factorials grow VERY fast (20! > 2 billion)

**Real-world uses:**
- Permutations: n! ways to arrange n items
- Combinations: n!/(r!(n-r)!)
- Probability calculations

---

## Q10: Product of Digits

**Problem:** Find product of all digits in a number.

**Logic (Detailed):**
- Extract each digit from the number
- Multiply all digits together
- Use modulo (%) to get last digit
- Use division (/) to remove last digit

**Digit extraction technique:**
```
n = 234

Step 1: n % 10 = 4 (last digit)
        n / 10 = 23 (remaining)

Step 2: n % 10 = 3 (last digit)
        n / 10 = 2 (remaining)

Step 3: n % 10 = 2 (last digit)
        n / 10 = 0 (remaining)

n = 0 → STOP
```

**Why % 10 gives last digit?**
- % gives remainder after division
- Any number ÷ 10 has last digit as remainder
- 234 ÷ 10 = 23 remainder **4**
- 1987 ÷ 10 = 198 remainder **7**

**Why / 10 removes last digit?**
- Integer division truncates (cuts off) decimal
- 234 / 10 = 23 (not 23.4)
- This effectively "chops off" the last digit

**Example for n=234:**
```
product = 1
digit = 234 % 10 = 4, product = 1 × 4 = 4, n = 23
digit = 23 % 10 = 3, product = 4 × 3 = 12, n = 2
digit = 2 % 10 = 2, product = 12 × 2 = 24, n = 0
STOP → Product = 24
```

**Edge case:** If any digit is 0, product becomes 0!
- 102 → 1 × 0 × 2 = 0
