# Phase 1 - Conditionals | Level 2: Nested Conditions (Q11-Q20)

## Overview
Nested conditions and multiple factors in decision making.

---

## Q11: Valid Triangle Check

**Problem:** Check if three sides can form a valid triangle.

**Logic (Detailed):**

**Triangle Inequality Theorem:** The sum of any two sides must be greater than the third side.

```java
// All three conditions must be true:
a + b > c  AND
b + c > a  AND
a + c > b
```

**Why it works:** If one side is too long (≥ sum of others), the other two sides can't "reach" to form a closed shape.

**Examples:**
```
(3, 4, 5): 3+4=7>5 ✓, 4+5=9>3 ✓, 3+5=8>4 ✓ → Valid
(1, 2, 10): 1+2=3>10? NO → Invalid
```

---

## Q12: Triangle Type Classification

**Problem:** Identify if triangle is equilateral, isosceles, or scalene.

**Logic (Detailed):**

```
Equilateral: a == b == c (all sides equal)
Isosceles:   exactly two sides equal
Scalene:     all sides different
```

**Order matters!** Check equilateral first:
```java
if (a == b && b == c) → Equilateral
else if (a == b || b == c || a == c) → Isosceles
else → Scalene
```

---

## Q13: Grade from Marks

**Problem:** Convert marks (0-100) to letter grade.

**Logic (Detailed):**

**If-else-if ladder** for range checking:
```
90-100: A
80-89:  B
70-79:  C
60-69:  D
50-59:  E
<50:    F
```

```java
if (marks >= 90) grade = 'A';
else if (marks >= 80) grade = 'B';
else if (marks >= 70) grade = 'C';
// ... and so on
```

**Key:** Start from highest, no need for upper bound in each condition since previous conditions handle it.

---

## Q14: Check if Multiple

**Problem:** Is one number a multiple of another?

**Logic (Detailed):**

Number `a` is a multiple of `b` if `a % b == 0`

```java
if (a % b == 0) → a is multiple of b
```

**Edge Case:** Always check `b != 0` to avoid division by zero!

**Example:**
```
15 % 3 = 0 → 15 is multiple of 3 (15 = 3 × 5)
17 % 3 = 2 → 17 is NOT multiple of 3
```

---

## Q15: Time-based Greeting

**Problem:** Print greeting based on hour (0-23).

**Logic (Detailed):**

24-hour clock mapping:
```
0-11:  Good Morning
12-16: Good Afternoon
17-20: Good Evening
21-23: Good Night
```

```java
if (hour >= 0 && hour < 12) → Morning
else if (hour >= 12 && hour < 17) → Afternoon
else if (hour >= 17 && hour < 21) → Evening
else → Night
```

---

## Q16: Voting Eligibility

**Problem:** Check if person can vote (age + citizenship).

**Logic (Detailed):**

**Nested conditions** for multiple criteria:
```java
if (age >= 18) {
    if (isCitizen) {
        → Eligible to vote
    } else {
        → Not eligible (not a citizen)
    }
} else {
    → Not eligible (too young)
}
```

This shows how decisions can depend on multiple factors.

---

## Q17: Compare Parity

**Problem:** Check if two numbers have same parity (both even or both odd).

**Logic (Detailed):**

```java
boolean aIsEven = (a % 2 == 0);
boolean bIsEven = (b % 2 == 0);

if (aIsEven && bIsEven) → Both even
else if (!aIsEven && !bIsEven) → Both odd
else → Different parity
```

**Shortcut:** If `(a + b)` is even, both have same parity!

---

## Q18: Alphabet Half Check

**Problem:** Is letter in first half (a-m) or second half (n-z)?

**Logic (Detailed):**

```
First half:  a to m (13 letters)
Second half: n to z (13 letters)
```

**Using character comparison:**
```java
char ch = Character.toLowerCase(input);
if (ch >= 'a' && ch <= 'm') → First half
else if (ch >= 'n' && ch <= 'z') → Second half
```

**Position calculation:** `ch - 'a' + 1` gives position (a=1, b=2, ...)

---

## Q19: Day Number to Name

**Problem:** Convert 1-7 to day name.

**Logic (Detailed):**

**Switch-case is ideal** for fixed mappings:

```java
switch (day) {
    case 1: return "Monday";
    case 2: return "Tuesday";
    // ...
    case 7: return "Sunday";
    default: return "Invalid";
}
```

**Array method (elegant):**
```java
String[] days = {"Monday", "Tuesday", "Wednesday", 
                 "Thursday", "Friday", "Saturday", "Sunday"};
return days[day - 1];  // day-1 for 0-based index
```

---

## Q20: BMI Calculator

**Problem:** Calculate BMI and classify weight status.

**Logic (Detailed):**

**Formula:** BMI = weight(kg) / height(m)²

**Classification:**
```
BMI < 18.5:        Underweight
18.5 ≤ BMI < 25:   Normal
25 ≤ BMI < 30:     Overweight
BMI ≥ 30:          Obese
```

```java
double bmi = weight / (height * height);

if (bmi < 18.5) → Underweight
else if (bmi < 25) → Normal
else if (bmi < 30) → Overweight
else → Obese
```
