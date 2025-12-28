# Phase 3 - Recursion | Level 3: Pattern Recursion (Q21-Q30)

## Overview
Printing patterns using recursive calls instead of nested loops.

---

## Q21: Print Line of N Stars

**Problem:** Print n stars in a line recursively.

**Logic (Detailed):**
- Print one star, then print (n-1) more stars
- Base case: n = 0, print nothing

**Recursive insight:**
```
printStars(5) = "*" + printStars(4)
              = "*" + "*" + printStars(3)
              = "*" + "*" + "*" + printStars(2)
              = "*" + "*" + "*" + "*" + printStars(1)
              = "*" + "*" + "*" + "*" + "*" + printStars(0)
              = "*****"
```

**Two approaches:**

**Approach 1 - Print then recurse:**
```
printStars(n):
  if n == 0 → return
  print "*"
  printStars(n - 1)
```

**Approach 2 - Recurse then print:**
```
printStars(n):
  if n == 0 → return
  printStars(n - 1)
  print "*"
```
Both give same output since we're just printing stars!

---

## Q22: Print Square of Stars

**Problem:** Print n×n square of stars.

**Logic (Detailed):**
- Print n rows, each row has n stars
- Use one recursive call per row
- Within each call, print n stars

**Recursive structure:**
```
printSquare(n, row):
  if row > n → return (base case)
  printStars(n)  // Print one row
  println        // New line
  printSquare(n, row + 1)  // Next row
```

**Trace for n=3:**
```
printSquare(3, 1):
  print "***" + newline
  printSquare(3, 2):
    print "***" + newline
    printSquare(3, 3):
      print "***" + newline
      printSquare(3, 4):
        return (row > n)

Output:
***
***
***
```

---

## Q23: Triangle Pattern (Top-Down)

**Problem:** Print decreasing triangle (n stars, then n-1, then n-2...).

**Pattern for n=5:**
```
*****
****
***
**
*
```

**Logic (Detailed):**
- First print n stars
- Then print triangle of n-1 stars
- Base case: n = 0

**Key insight:** Print BEFORE recursing (descending pattern)

**Trace for n=4:**
```
triangle(4):
  print "****" + newline
  triangle(3):
    print "***" + newline
    triangle(2):
      print "**" + newline
      triangle(1):
        print "*" + newline
        triangle(0):
          return (base case)
```

---

## Q24: Triangle Pattern (Bottom-Up)

**Problem:** Print increasing triangle (1 star, then 2, then 3...).

**Pattern for n=5:**
```
*
**
***
****
*****
```

**Logic (Detailed):**
- This time, recurse FIRST, then print
- The smallest row gets printed first (from deepest recursion)

**Key insight:** Recurse BEFORE printing (ascending pattern)

**Trace for n=4:**
```
triangle(4):
  triangle(3)  ← go deeper first
    triangle(2)
      triangle(1)
        triangle(0)
          return
        print "*"
      print "**"
    print "***"
  print "****"

Output:
*
**
***
****
```

**Compare Q23 vs Q24:**
- Q23: Print first, then recurse → top-down (descending)
- Q24: Recurse first, then print → bottom-up (ascending)

---

## Q25: Number Pattern Triangle

**Problem:** Print numbers 1 to row in each row.

**Pattern for n=4:**
```
1
1 2
1 2 3
1 2 3 4
```

**Logic (Detailed):**
- Recurse first (to print smaller rows first)
- Then print numbers 1 to current row

**Helper function needed:**
```
printNumbers(from, to):
  if from > to → return
  print from + " "
  printNumbers(from + 1, to)
```

**Main function:**
```
numberTriangle(n, row):
  if row > n → return
  numberTriangle(n, row + 1)  // Recurse first!
  printNumbers(1, n - row + 1)
  println
```

Wait, let's reconsider for ascending order:
```
numberTriangle(row, max):
  if row > max → return
  numberTriangle(row - 1, max)  // Build smaller rows first
  printNumbers(1, row)
  println
```

---

## Q26: Reverse Triangle with Spaces

**Problem:** Right-aligned triangle.

**Pattern for n=5:**
```
    *
   **
  ***
 ****
*****
```

**Logic (Detailed):**
- Each row has (n - row) spaces, then (row) stars
- Row 1: 4 spaces, 1 star
- Row 2: 3 spaces, 2 stars
- Row 5: 0 spaces, 5 stars

**Need two helpers:**
```
printSpaces(n):
  if n == 0 → return
  print " "
  printSpaces(n - 1)

printStars(n):
  if n == 0 → return
  print "*"
  printStars(n - 1)
```

**Main recursive function:**
```
rightTriangle(row, n):
  if row > n → return
  rightTriangle(row - 1, n)  // Smaller rows first
  printSpaces(n - row)
  printStars(row)
  println
```

---

## Q27: Multiplication Table Recursively

**Problem:** Print multiplication table using recursion.

**Logic (Detailed):**
- Print n × 1, n × 2, ... n × 10
- Each line is n × i = result
- Recurse for next multiplier

**Approach 1 - Ascending (print after recurse):**
```
printTable(n, i):
  if i > 10 → return
  printTable(n, i + 1)  // Go to end first
  print n + " × " + i + " = " + (n*i)
```
This prints 10, 9, 8... (wrong order!)

**Approach 2 - Correct order (print before recurse):**
```
printTable(n, i):
  if i > 10 → return
  print n + " × " + i + " = " + (n*i)
  printTable(n, i + 1)
```

**Trace for printTable(5, 1):**
```
printTable(5, 1):
  print "5 × 1 = 5"
  printTable(5, 2):
    print "5 × 2 = 10"
    printTable(5, 3):
      print "5 × 3 = 15"
      ...continues to 10...
```

---

## Q28: Increasing Then Decreasing

**Problem:** Print 1 to n, then n to 1.

**Logic (Detailed):**
- Print current number BEFORE and AFTER recursive call
- This creates mirror effect!

**Key insight:**
```
func(n):
  if n == 0 → return
  print n          // Before recursion
  func(n - 1)      // Go deeper
  print n          // After recursion (on way back)
```

**Trace for n=3:**
```
func(3):
  print 3
  func(2):
    print 2
    func(1):
      print 1
      func(0):
        return
      print 1
    print 2
  print 3

Output: 3 2 1 1 2 3
```

**Why this works:**
- Going DOWN the recursion: prints 3, 2, 1
- Coming BACK UP: prints 1, 2, 3

---

## Q29: Print Array Elements

**Problem:** Print array using recursion.

**Logic (Detailed):**
- Print first element, then recurse for rest
- Use index to track position
- Base case: index reaches array length

**Structure:**
```
printArray(arr, index):
  if index >= arr.length → return
  print arr[index]
  printArray(arr, index + 1)
```

**Trace for arr=[10, 20, 30]:**
```
printArray(arr, 0):
  print 10
  printArray(arr, 1):
    print 20
    printArray(arr, 2):
      print 30
      printArray(arr, 3):
        return (index >= length)

Output: 10 20 30
```

---

## Q30: Print Array in Reverse

**Problem:** Print array elements in reverse order.

**Logic (Detailed):**
- Recurse FIRST, then print (backtracking approach)
- Elements print while unwinding from recursion

**Structure:**
```
printReverse(arr, index):
  if index >= arr.length → return
  printReverse(arr, index + 1)  // Go to end first
  print arr[index]              // Print on way back
```

**Trace for arr=[10, 20, 30]:**
```
printReverse(arr, 0):
  printReverse(arr, 1):
    printReverse(arr, 2):
      printReverse(arr, 3):
        return
      print 30
    print 20
  print 10

Output: 30 20 10
```

**Compare Q29 vs Q30:**
- Q29: Print then recurse → forward order
- Q30: Recurse then print → reverse order

**This is a fundamental recursion pattern!**
