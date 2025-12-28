# Phase 1 - Conditionals | Level 4: Logical Operators (Q31-Q40)

## Overview
Combining conditions using AND (&&), OR (||), and NOT (!) operators.

---

## Q31: Character Type (Letter/Digit/Special)

**Problem:** Classify character into category.

**Logic (Detailed):**

**Using Character class:**
```java
if (Character.isLetter(ch)) → Letter
else if (Character.isDigit(ch)) → Digit
else → Special character
```

**Using ASCII ranges:**
```java
if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) → Letter
else if (ch >= '0' && ch <= '9') → Digit
else → Special
```

**Note:** ASCII value: `(int) ch`

---

## Q32: FizzBuzz ⭐ (Classic Interview Question!)

**Problem:** Print Fizz, Buzz, FizzBuzz, or number.

**Logic (Detailed):**

```
Divisible by 3 AND 5 → "FizzBuzz"
Divisible by 3 only  → "Fizz"
Divisible by 5 only  → "Buzz"
Otherwise            → Print the number
```

**ORDER MATTERS!** Check "both" condition FIRST:
```java
if (n % 3 == 0 && n % 5 == 0) → FizzBuzz
else if (n % 3 == 0) → Fizz
else if (n % 5 == 0) → Buzz
else → n
```

**Why order matters:**
If you check `n % 3 == 0` first, 15 would print "Fizz" instead of "FizzBuzz".

---

## Q33: Median of Three Numbers

**Problem:** Find the middle value.

**Logic (Detailed):**

**Median:** The value that's neither maximum nor minimum.

```java
// a is median if it's between b and c
if ((a >= b && a <= c) || (a <= b && a >= c)) median = a;
else if ((b >= a && b <= c) || (b <= a && b >= c)) median = b;
else median = c;
```

**Using Math functions:**
```java
median = Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
```

---

## Q34: AM or PM from 24-Hour Time

**Problem:** Convert 24-hour format to 12-hour with AM/PM.

**Logic (Detailed):**

```
Hours 0-11:  AM
Hours 12-23: PM

12-hour = hour % 12 (use 12 if result is 0)
```

```java
String period = (hour < 12) ? "AM" : "PM";
int hour12 = hour % 12;
if (hour12 == 0) hour12 = 12;
```

**Trace:**
```
hour=0:  0%12=0 → 12 AM (midnight)
hour=12: 12%12=0 → 12 PM (noon)
hour=13: 13%12=1 → 1 PM
hour=23: 23%12=11 → 11 PM
```

---

## Q35: Tax Eligibility

**Problem:** Calculate tax based on income slabs.

**Logic (Detailed):**

**Slab-based calculation (India example):**
```
₹0 - 3L:      0%
₹3L - 6L:     5%
₹6L - 9L:     10%
₹9L - 12L:    15%
₹12L - 15L:   20%
Above ₹15L:   30%
```

**Calculate progressively:**
```java
double tax = 0;
if (income > 1500000) {
    tax += (income - 1500000) * 0.30;
    income = 1500000;
}
if (income > 1200000) {
    tax += (income - 1200000) * 0.20;
    income = 1200000;
}
// ... continue for each slab
```

---

## Q36: Both Positive AND Sum < 100

**Problem:** Check if both conditions are satisfied.

**Logic (Detailed):**

Use **AND (&&)** to combine conditions:
```java
boolean bothPositive = (a > 0 && b > 0);
boolean sumLessThan100 = (a + b < 100);

if (bothPositive && sumLessThan100) → Both satisfied
```

**Short-circuit evaluation:** If first condition is false, second isn't checked.

---

## Q37: Digit to Word

**Problem:** Convert 0-9 to English word.

**Logic (Detailed):**

**Switch-case is ideal:**
```java
switch (digit) {
    case 0: return "Zero";
    case 1: return "One";
    // ...
    case 9: return "Nine";
}
```

**Array method (more elegant):**
```java
String[] words = {"Zero", "One", "Two", "Three", "Four",
                  "Five", "Six", "Seven", "Eight", "Nine"};
return words[digit];
```

---

## Q38: Weekday or Weekend

**Problem:** Classify day as weekday or weekend.

**Logic (Detailed):**

```java
// Using OR for weekend check
if (day == 6 || day == 7) → Weekend
else if (day >= 1 && day <= 5) → Weekday
```

**Alternative using range:**
```java
if (day >= 1 && day <= 5) → Weekday
else → Weekend
```

---

## Q39: Electricity Bill (Tiered Pricing)

**Problem:** Calculate bill with slab-based rates.

**Logic (Detailed):**

**Example rates:**
```
0-100 units:    ₹1.50/unit
101-200 units:  ₹2.00/unit
201-500 units:  ₹3.00/unit
Above 500:      ₹4.00/unit
```

**Calculate tier by tier:**
```java
double bill = 0;
if (units > 500) {
    bill += (units - 500) * 4.00;
    units = 500;
}
if (units > 200) {
    bill += (units - 200) * 3.00;
    units = 200;
}
if (units > 100) {
    bill += (units - 100) * 2.00;
    units = 100;
}
bill += units * 1.50;
```

---

## Q40: Simple Calculator

**Problem:** Perform operation based on operator input.

**Logic (Detailed):**

```java
switch (operator) {
    case '+': result = a + b; break;
    case '-': result = a - b; break;
    case '*': result = a * b; break;
    case '/': 
        if (b != 0) result = a / b;
        else → "Division by zero error!"
        break;
    case '%': result = a % b; break;
    default: → "Invalid operator"
}
```

**Edge cases:**
- Division by zero
- Integer division truncates (use double for precise division)
