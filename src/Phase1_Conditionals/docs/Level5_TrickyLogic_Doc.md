# Phase 1 - Conditionals | Level 5: Tricky Logic (Q41-Q50)

## Overview
Deeper mathematical thinking and careful edge case handling. Common in interviews!

---

## Q41: Point on Axis or Origin

**Problem:** Determine if point is on axis, at origin, or in quadrant.

**Logic (Detailed):**

**Check order matters:**
```java
if (x == 0 && y == 0) → Origin
else if (x == 0) → On Y-axis
else if (y == 0) → On X-axis
else → In a quadrant
```

**Distance from origin:** `sqrt(x² + y²)`

---

## Q42: Pythagorean Triplet ⭐

**Problem:** Check if three numbers satisfy a² + b² = c².

**Logic (Detailed):**

**Key insight:** c must be the largest (hypotenuse).

```java
// Find the largest
int max = Math.max(a, Math.max(b, c));

// Check the Pythagorean condition
if (max == c) check: a² + b² == c²
else if (max == b) check: a² + c² == b²
else check: b² + c² == a²
```

**Common triplets:**
```
(3, 4, 5):   9 + 16 = 25 ✓
(5, 12, 13): 25 + 144 = 169 ✓
(8, 15, 17): 64 + 225 = 289 ✓
(7, 24, 25): 49 + 576 = 625 ✓
```

---

## Q43: Valid Calendar Date

**Problem:** Check if day/month/year is valid.

**Logic (Detailed):**

**Validation steps:**
1. Year must be positive
2. Month must be 1-12
3. Day must be valid for that month

**Days per month:**
```
Jan, Mar, May, Jul, Aug, Oct, Dec: 31 days
Apr, Jun, Sep, Nov: 30 days
Feb: 28 days (29 in leap year)
```

```java
int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

// Adjust February for leap year
if (isLeapYear(year)) daysInMonth[1] = 29;

if (day >= 1 && day <= daysInMonth[month - 1]) → Valid
```

---

## Q44: Clock Angle Problem ⭐

**Problem:** Find angle between hour and minute hands.

**Logic (Detailed):**

**Key formulas:**
- Hour hand: moves 360° in 12 hours = **0.5° per minute**
- Minute hand: moves 360° in 60 minutes = **6° per minute**

```java
// Hour hand position from 12 o'clock
double hourAngle = (hour % 12) * 30 + minute * 0.5;

// Minute hand position from 12 o'clock
double minuteAngle = minute * 6;

// Difference
double angle = Math.abs(hourAngle - minuteAngle);

// Return smaller angle (≤ 180°)
if (angle > 180) angle = 360 - angle;
```

**Trace for 3:30:**
```
hourAngle = 3 * 30 + 30 * 0.5 = 90 + 15 = 105°
minuteAngle = 30 * 6 = 180°
angle = |105 - 180| = 75°
```

---

## Q45: Arithmetic Progression Check

**Problem:** Are three numbers in AP?

**Logic (Detailed):**

**AP condition:** Common difference is constant.
```
b - a = c - b
OR: 2b = a + c
```

```java
if ((b - a) == (c - b)) → In AP
```

**Common difference:** d = b - a

**Next terms:** c + d, c + 2d, ...

---

## Q46: Geometric Progression Check

**Problem:** Are three numbers in GP?

**Logic (Detailed):**

**GP condition:** Common ratio is constant.
```
b/a = c/b
OR: b² = a × c
```

```java
// Using multiplication avoids division by zero
if (b * b == a * c) → In GP
```

**Common ratio:** r = b / a

**Edge case:** Handle a = 0 or b = 0

---

## Q47: Digit Sum Analysis (3-digit)

**Problem:** Analyze properties of digit sum.

**Logic (Detailed):**

```java
int d1 = num / 100;
int d2 = (num / 10) % 10;
int d3 = num % 10;

int sum = d1 + d2 + d3;
int product = d1 * d2 * d3;
```

**Interesting checks:**
- Is number divisible by its digit sum?
- Is digit sum equal to any digit?
- Are digits in ascending/descending order?
- Are all digits same (repdigit)?

---

## Q48: Digit Sum vs Digit Product

**Problem:** Compare sum and product of digits.

**Logic (Detailed):**

```java
int sum = d1 + d2 + d3;
int product = d1 * d2 * d3;

if (sum > product) → Sum is greater
else if (product > sum) → Product is greater
else → Equal
```

**Insight:** Product = 0 if any digit is 0!

---

## Q49: Power of 2 Check

**Problem:** Is number a power of 2?

**Logic (Detailed):**

**Method 1: Bit manipulation (Most efficient)**
```java
// Powers of 2 have exactly one bit set
// n & (n-1) removes the lowest set bit
if (n > 0 && (n & (n - 1)) == 0) → Power of 2
```

**Why it works:**
```
8 = 1000 (binary)
7 = 0111
8 & 7 = 0000 → Power of 2 ✓

6 = 0110
5 = 0101
6 & 5 = 0100 ≠ 0 → Not power of 2
```

**Method 2: Loop division**
```java
while (n > 1) {
    if (n % 2 != 0) return false;
    n /= 2;
}
return n == 1;
```

---

## Q50: Perfect Square Check

**Problem:** Is number a perfect square?

**Logic (Detailed):**

**Method 1: Square root comparison**
```java
int sqrt = (int) Math.sqrt(n);
if (sqrt * sqrt == n) → Perfect square
```

**Method 2: Binary search**
```java
// Search for x where x² = n
int low = 1, high = n;
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (mid * mid == n) return true;
    else if (mid * mid < n) low = mid + 1;
    else high = mid - 1;
}
return false;
```

**Perfect squares:** 1, 4, 9, 16, 25, 36, 49, 64, 81, 100...

**Digital root property:** Perfect squares have digital root of 1, 4, 7, or 9.
