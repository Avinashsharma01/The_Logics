# Phase 3 - Recursion | Level 1: Basics (Q1-Q10)

## Overview
Foundation of recursive thinking - a function calling itself.

---

## Q1: Print 1 to N Recursively

**Problem:** Print numbers from 1 to n using recursion.

**Logic (Detailed):**
- Recursion = function calls itself with modified input
- **Key insight:** Print AFTER recursive call for ascending order
- The call stack "holds" numbers, then prints while unwinding

**Why print after recursive call?**
```
print1ToN(5):
  calls print1ToN(4) first, then prints 5
    calls print1ToN(3) first, then prints 4
      calls print1ToN(2) first, then prints 3
        calls print1ToN(1) first, then prints 2
          calls print1ToN(0) - base case, returns
        prints 1
      prints 2
    prints 3
  prints 4
prints 5

Output: 1 2 3 4 5
```

**Base case explained:**
- Base case: when to STOP recursing
- Here: if n < 1, return (do nothing)
- Without base case = infinite recursion = stack overflow!

**Call stack visualization:**
```
print1ToN(5) → waiting
  print1ToN(4) → waiting
    print1ToN(3) → waiting
      print1ToN(2) → waiting
        print1ToN(1) → waiting
          print1ToN(0) → returns (base case)
        print 1, return
      print 2, return
    print 3, return
  print 4, return
print 5, return
```

---

## Q2: Print N to 1 Recursively

**Problem:** Print numbers from n to 1.

**Logic (Detailed):**
- Print BEFORE recursive call for descending order
- Print current n, then recurse for n-1

**Why print before recursive call?**
```
printNTo1(5):
  prints 5
  calls printNTo1(4)
    prints 4
    calls printNTo1(3)
      prints 3
      calls printNTo1(2)
        prints 2
        calls printNTo1(1)
          prints 1
          calls printNTo1(0) - base case, returns
```

Output: 5 4 3 2 1

**Key difference from Q1:**
- Q1: Recurse first, then print (ascending)
- Q2: Print first, then recurse (descending)

---

## Q3: Print Even Numbers 1 to N

**Problem:** Print even numbers using recursion.

**Logic (Detailed):**
- Recurse through all numbers 1 to n
- Only print if current number is even
- Print AFTER recursion for ascending order

**Step-by-step for n=6:**
```
printEven(6):
  printEven(5)
    printEven(4)
      printEven(3)
        printEven(2)
          printEven(1)
            printEven(0) → returns
          1 is odd, don't print
        2 is even, print 2
      3 is odd, don't print
    4 is even, print 4
  5 is odd, don't print
6 is even, print 6

Output: 2 4 6
```

**Alternative approach:**
- Only recurse on even numbers: printEven(n-2)
- Start check: if n is odd, start from n-1

---

## Q4: Print Odd Numbers 1 to N

**Problem:** Print odd numbers using recursion.

**Logic (Detailed):**
- Similar to Q3, but check for odd (n % 2 != 0)
- Recurse through all, print only odds

**Step-by-step for n=6:**
```
printOdd(6):
  ...recursion unwinds...
  1 is odd → print 1
  2 is even → skip
  3 is odd → print 3
  5 is odd → print 5

Output: 1 3 5
```

---

## Q5: Sum of 1 to N

**Problem:** Find sum of first n natural numbers.

**Logic (Detailed):**
- Mathematical definition: sum(n) = 1 + 2 + ... + n
- Recursive insight: sum(n) = n + sum(n-1)
- Base case: sum(0) = 0 or sum(1) = 1

**Why this works:**
```
sum(5) = 5 + sum(4)
       = 5 + 4 + sum(3)
       = 5 + 4 + 3 + sum(2)
       = 5 + 4 + 3 + 2 + sum(1)
       = 5 + 4 + 3 + 2 + 1
       = 15
```

**Trace with returns:**
```
sum(5) calls sum(4), gets 10, returns 5+10=15
  sum(4) calls sum(3), gets 6, returns 4+6=10
    sum(3) calls sum(2), gets 3, returns 3+3=6
      sum(2) calls sum(1), gets 1, returns 2+1=3
        sum(1) returns 1 (base case)
```

---

## Q6: Factorial Using Recursion

**Problem:** Calculate n! recursively.

**Logic (Detailed):**
- Mathematical: n! = n × (n-1) × (n-2) × ... × 1
- Recursive insight: n! = n × (n-1)!
- Base case: 0! = 1 and 1! = 1

**Why n! = n × (n-1)!:**
```
5! = 5 × 4 × 3 × 2 × 1
   = 5 × (4 × 3 × 2 × 1)
   = 5 × 4!
```

**Trace for factorial(5):**
```
factorial(5) = 5 × factorial(4)
             = 5 × 4 × factorial(3)
             = 5 × 4 × 3 × factorial(2)
             = 5 × 4 × 3 × 2 × factorial(1)
             = 5 × 4 × 3 × 2 × 1
             = 120
```

**Return trace:**
```
factorial(5):
  factorial(4) returns 24
  return 5 × 24 = 120
    factorial(3) returns 6
    return 4 × 6 = 24
      factorial(2) returns 2
      return 3 × 2 = 6
        factorial(1) returns 1
        return 2 × 1 = 2
          factorial(0) returns 1 (base)
```

---

## Q7: Power x^n Using Recursion

**Problem:** Calculate x raised to power n.

**Logic (Detailed):**
- Mathematical: x^n = x × x × x × ... (n times)
- Recursive insight: x^n = x × x^(n-1)
- Base case: x^0 = 1

**Simple recursion:**
```
power(2, 5) = 2 × power(2, 4)
            = 2 × 2 × power(2, 3)
            = 2 × 2 × 2 × power(2, 2)
            = 2 × 2 × 2 × 2 × power(2, 1)
            = 2 × 2 × 2 × 2 × 2 × power(2, 0)
            = 2 × 2 × 2 × 2 × 2 × 1
            = 32
```

**Optimized (Fast exponentiation):**
- If n is even: x^n = (x^(n/2))²
- If n is odd: x^n = x × x^(n-1)

```
power(2, 8):
  = power(2, 4)² = 16² = 256 (only 4 multiplications!)

vs simple: 2×2×2×2×2×2×2×2 (8 multiplications)
```

---

## Q8: Check if Array Element Exists

**Problem:** Recursively check if element exists in array.

**Logic (Detailed):**
- Check first element; if match, return true
- Otherwise, recursively search in rest of array
- Base case: empty array → return false

**Recursive structure:**
```
contains(arr, target, index):
  if index >= arr.length → return false (base case)
  if arr[index] == target → return true (found!)
  return contains(arr, target, index + 1) (check rest)
```

**Step-by-step for arr=[1,3,5,7], target=5:**
```
contains(arr, 5, 0):
  arr[0]=1 ≠ 5, recurse with index=1
  contains(arr, 5, 1):
    arr[1]=3 ≠ 5, recurse with index=2
    contains(arr, 5, 2):
      arr[2]=5 == 5, return TRUE!
    returns true
  returns true
returns true
```

---

## Q9: Find Maximum in Array

**Problem:** Find largest element recursively.

**Logic (Detailed):**
- Compare first element with max of rest
- Return the larger one
- Base case: single element array → return that element

**Recursive insight:**
```
max(arr) = max(arr[0], max(arr[1:]))
         = max(first element, max of remaining)
```

**Step-by-step for arr=[3,1,4,1,5,9,2,6]:**
```
findMax(arr, 0):
  return max(3, findMax(arr, 1))
    return max(1, findMax(arr, 2))
      return max(4, findMax(arr, 3))
        ...continues until last element...
            return 6 (last element, base case)
          return max(2, 6) = 6
        return max(9, 6) = 9
      return max(5, 9) = 9
    return max(1, 9) = 9
  return max(4, 9) = 9
return max(1, 9) = 9
return max(3, 9) = 9
```

---

## Q10: Find Minimum in Array

**Problem:** Find smallest element recursively.

**Logic (Detailed):**
- Same structure as Q9, but use min instead of max
- Compare first element with min of rest
- Return the smaller one

**Recursive structure:**
```
findMin(arr, index):
  if index == last → return arr[last] (base case)
  return min(arr[index], findMin(arr, index + 1))
```

**Key insight for recursion:**
- Complex problem → simpler subproblem + small step
- "Find min of array" → "Find min of smaller array" + compare
