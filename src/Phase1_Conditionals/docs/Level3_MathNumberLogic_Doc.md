# Phase 1 - Conditionals | Level 3: Math & Number Logic (Q21-Q30)

## Overview
Mathematical thinking with digit extraction, number properties, and geometry.

---

## Q21: Check if 3-Digit Number has Distinct Digits

**Problem:** Are all digits in a 3-digit number different?

**Logic (Detailed):**

**Digit Extraction Pattern (Very Important!):**
```
For number ABC (e.g., 123):
- Units (C):    num % 10        → 123 % 10 = 3
- Tens (B):     (num / 10) % 10 → (123/10) % 10 = 12 % 10 = 2
- Hundreds (A): num / 100       → 123 / 100 = 1
```

**Check distinct:**
```java
if (hundreds != tens && tens != units && hundreds != units)
    → All digits are distinct
```

**Trace for 121:**
```
units = 121 % 10 = 1
tens = (121 / 10) % 10 = 12 % 10 = 2
hundreds = 121 / 100 = 1

hundreds == units (both 1) → NOT distinct
```

---

## Q22: Compare Middle Digit

**Problem:** Is middle digit largest, smallest, or in between?

**Logic (Detailed):**

For 3-digit number:
```java
int first = num / 100;
int middle = (num / 10) % 10;
int last = num % 10;

if (middle > first && middle > last) → Largest
else if (middle < first && middle < last) → Smallest
else → In between
```

---

## Q23: First and Last Digit Equal (4-digit)

**Problem:** Check if first and last digits are same in 4-digit number.

**Logic (Detailed):**

```java
int firstDigit = num / 1000;   // 1234 / 1000 = 1
int lastDigit = num % 10;      // 1234 % 10 = 4

if (firstDigit == lastDigit) → Equal
```

**Examples:**
```
1231: first=1, last=1 → Equal ✓
5765: first=5, last=5 → Equal ✓
1234: first=1, last=4 → Not equal
```

---

## Q24: Single/Double/Multi-digit Number

**Problem:** Classify number by digit count.

**Logic (Detailed):**

```java
int absNum = Math.abs(num);  // Handle negatives

if (absNum <= 9) → Single digit
else if (absNum <= 99) → Double digit
else → Multi-digit
```

**Count digits using loop:**
```java
int count = 0;
while (temp > 0) {
    count++;
    temp /= 10;
}
```

**Using logarithm:**
```java
int digits = (int) Math.log10(absNum) + 1;
```

---

## Q25: Multiple of 7 OR Ends with 7

**Problem:** Check either condition using OR.

**Logic (Detailed):**

```java
boolean isMultipleOf7 = (num % 7 == 0);
boolean endsWith7 = (num % 10 == 7);

if (isMultipleOf7 || endsWith7) → Satisfies condition
```

**Examples:**
```
14: 14%7=0 ✓ (multiple of 7)
17: ends with 7 ✓
7:  both ✓
37: ends with 7 ✓
8:  neither ✗
```

---

## Q26: Quadrant of Point (x, y)

**Problem:** Determine which quadrant a point lies in.

**Logic (Detailed):**

**Coordinate plane diagram:**
```
          Y+
          |
    Q2    |    Q1
   (-,+)  |   (+,+)
----------+----------> X+
    Q3    |    Q4
   (-,-)  |   (+,-)
          |
```

```java
if (x == 0 && y == 0) → Origin
else if (x == 0) → On Y-axis
else if (y == 0) → On X-axis
else if (x > 0 && y > 0) → Q1
else if (x < 0 && y > 0) → Q2
else if (x < 0 && y < 0) → Q3
else → Q4
```

---

## Q27: Currency Note Division

**Problem:** Break amount into 2000, 500, 100 notes.

**Logic (Detailed):**

**Greedy approach:** Always use largest denomination first.

```java
int notes2000 = amount / 2000;
amount = amount % 2000;

int notes500 = amount / 500;
amount = amount % 500;

int notes100 = amount / 100;
amount = amount % 100;  // Remaining cannot be divided
```

**Trace for ₹3700:**
```
3700 / 2000 = 1 note, remainder = 1700
1700 / 500 = 3 notes, remainder = 200
200 / 100 = 2 notes, remainder = 0

Result: 1×₹2000 + 3×₹500 + 2×₹100
```

---

## Q28: Number in Range [100, 999]

**Problem:** Check if number is a 3-digit number.

**Logic (Detailed):**

```java
if (num >= 100 && num <= 999) → In range (3-digit)
```

**Use AND (&&)** for range checks - both bounds must be satisfied.

---

## Q29: Third Angle of Triangle

**Problem:** Find third angle given two angles.

**Logic (Detailed):**

**Property:** Sum of angles in triangle = 180°

```java
int thirdAngle = 180 - angle1 - angle2;
```

**Validation needed:**
- Each angle must be positive
- Sum of given angles must be < 180
- Third angle must also be positive

```java
if (angle1 > 0 && angle2 > 0 && (angle1 + angle2) < 180)
    → Valid, thirdAngle = 180 - angle1 - angle2
```

---

## Q30: Right-Angled Triangle Check

**Problem:** Given three angles, check if triangle is right-angled.

**Logic (Detailed):**

A triangle is right-angled if one angle = 90°

```java
if (a == 90 || b == 90 || c == 90) → Right-angled
```

**Also verify:** a + b + c = 180 (valid triangle)

**Using sides (Pythagorean):**
```java
// Find largest side (hypotenuse)
// Check: a² + b² = c²
```
