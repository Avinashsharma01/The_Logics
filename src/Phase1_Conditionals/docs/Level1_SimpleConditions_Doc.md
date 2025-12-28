# Phase 1 - Conditionals | Level 1: Simple Conditions (Q1-Q10)

## Overview
Foundation of programming logic using if-else statements and comparison operators.

---

## Q1: Check Positive, Negative, or Zero

**Problem:** Classify a number as positive, negative, or zero.

**Logic (Detailed):**

Numbers exist on a number line with zero as the dividing point:
- **Positive:** Any number greater than 0 (to the right of zero)
- **Negative:** Any number less than 0 (to the left of zero)
- **Zero:** The neutral point

```java
if (num > 0) → POSITIVE
else if (num < 0) → NEGATIVE
else → ZERO
```

**Key Concept:** Comparison operators `>`, `<`, `==`

---

## Q2: Check Even or Odd

**Problem:** Determine if a number is even or odd.

**Logic (Detailed):**

The **modulo operator (%)** returns the remainder after division.

```
Even numbers: divisible by 2 (remainder = 0)
Odd numbers: remainder = 1 when divided by 2
```

**Examples:**
```
4 % 2 = 0  → Even
5 % 2 = 1  → Odd
10 % 2 = 0 → Even
7 % 2 = 1  → Odd
```

**Why it works:** Every even number can be expressed as 2×k, so dividing by 2 leaves no remainder.

---

## Q3: Check Divisibility by 5

**Problem:** Check if number is divisible by 5.

**Logic (Detailed):**

A number is divisible by 5 if `num % 5 == 0`

**Pattern:** Numbers divisible by 5 always end in 0 or 5.

```
10 % 5 = 0 ✓
15 % 5 = 0 ✓
7 % 5 = 2  ✗
23 % 5 = 3 ✗
```

---

## Q4: Divisible by Both 3 AND 5

**Problem:** Check if divisible by both 3 and 5.

**Logic (Detailed):**

Use the **AND operator (&&)** - both conditions must be true.

```java
if (num % 3 == 0 && num % 5 == 0) → divisible by both
```

**Key Insight:** Numbers divisible by both 3 and 5 are divisible by 15 (LCM).

**Examples:**
```
15: 15%3=0 ✓, 15%5=0 ✓ → Both ✓
30: 30%3=0 ✓, 30%5=0 ✓ → Both ✓
10: 10%3=1 ✗, 10%5=0 ✓ → Only by 5
9:  9%3=0  ✓, 9%5=4  ✗ → Only by 3
```

---

## Q5: Leap Year Check ⭐ (Interview Favorite!)

**Problem:** Determine if a year is a leap year.

**Logic (Detailed):**

A year is a leap year if:
1. Divisible by 4 **AND**
2. Either NOT divisible by 100 **OR** divisible by 400

```java
boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
```

**Why this rule exists:**
- Solar year ≈ 365.2422 days
- Adding 1 day every 4 years: 365.25 (too much!)
- Skip century years: 365.24 (close!)
- But keep every 400th year: 365.2425 (very close!)

**Trace Examples:**
```
2024: 2024%4=0 ✓, 2024%100=24≠0 → LEAP
1900: 1900%4=0 ✓, 1900%100=0, 1900%400=300≠0 → NOT LEAP
2000: 2000%400=0 → LEAP (century but divisible by 400)
2023: 2023%4=3≠0 → NOT LEAP
```

---

## Q6: Larger of Two Numbers

**Problem:** Find the larger of two numbers.

**Logic (Detailed):**

```java
if (a > b) → a is larger
else if (b > a) → b is larger
else → both are equal
```

**Alternative Methods:**
```java
// Ternary operator
int larger = (a > b) ? a : b;

// Built-in function
int larger = Math.max(a, b);
```

---

## Q7: Largest of Three Numbers

**Problem:** Find the largest among three numbers.

**Logic (Detailed):**

**Method 1: If-else chain**
```java
if (a >= b && a >= c) → a is largest
else if (b >= a && b >= c) → b is largest
else → c is largest
```

**Method 2: Progressive comparison**
```java
int max = a;
if (b > max) max = b;
if (c > max) max = c;
```

**Method 3: Built-in**
```java
int max = Math.max(Math.max(a, b), c);
```

---

## Q8: Temperature Classification

**Problem:** Classify temperature as Cold, Warm, or Hot.

**Logic (Detailed):**

Define temperature ranges (Celsius):
```
Cold: < 15°C
Warm: 15°C to 30°C
Hot:  > 30°C
```

**Use if-else-if ladder:**
```java
if (temp < 15) → Cold
else if (temp <= 30) → Warm
else → Hot
```

**Note:** Order matters! Check from one end to the other.

---

## Q9: Vowel or Consonant

**Problem:** Check if a character is a vowel or consonant.

**Logic (Detailed):**

**Vowels:** a, e, i, o, u (and uppercase A, E, I, O, U)
**Consonants:** All other letters

**Method 1: Multiple OR conditions**
```java
char lowerCh = Character.toLowerCase(ch);
if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || 
    lowerCh == 'o' || lowerCh == 'u') → Vowel
```

**Method 2: String contains**
```java
String vowels = "aeiouAEIOU";
if (vowels.indexOf(ch) != -1) → Vowel
```

**Edge case:** First check if character is a letter!

---

## Q10: Character Classification

**Problem:** Classify character as uppercase, lowercase, digit, or special.

**Logic (Detailed):**

**ASCII Ranges:**
```
Uppercase: 'A' to 'Z' (65-90)
Lowercase: 'a' to 'z' (97-122)
Digit:     '0' to '9' (48-57)
Special:   Everything else
```

**Method 1: Character class methods (Recommended)**
```java
if (Character.isUpperCase(ch)) → Uppercase
else if (Character.isLowerCase(ch)) → Lowercase
else if (Character.isDigit(ch)) → Digit
else → Special character
```

**Method 2: ASCII ranges**
```java
if (ch >= 'A' && ch <= 'Z') → Uppercase
else if (ch >= 'a' && ch <= 'z') → Lowercase
else if (ch >= '0' && ch <= '9') → Digit
else → Special
```
