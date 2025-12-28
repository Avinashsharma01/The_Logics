# Phase 6 - Mixed Challenges | Level 2: String Logic (Q11-Q20)

## Overview
Complex string problems combining multiple techniques.

---

## Q11: Valid Parentheses

**Problem:** Check if parentheses are balanced.

**Logic (Detailed):**
```java
int count = 0;
for (char ch : str.toCharArray()) {
    if (ch == '(') count++;
    else if (ch == ')') {
        count--;
        if (count < 0) return false;  // Extra ')'
    }
}
return count == 0;  // No unclosed '('
```

**Trace for "(())":**
```
( → count=1
( → count=2
) → count=1
) → count=0 → Valid!
```

---

## Q12: Check if String is Numeric

**Problem:** Validate if string represents a valid number.

**Logic:** Handle: optional sign, digits, optional decimal point.

```java
boolean hasDigit = false, hasDecimal = false;
int start = (str.charAt(0) == '+' || str.charAt(0) == '-') ? 1 : 0;

for (int i = start; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (ch == '.') {
        if (hasDecimal) return false;
        hasDecimal = true;
    } else if (Character.isDigit(ch)) {
        hasDigit = true;
    } else {
        return false;
    }
}
return hasDigit;
```

---

## Q13: Extract Numbers from String

**Problem:** Find all numbers in mixed string.

**Logic:** Scan for digit sequences, parse each.

**Example:** "abc123def45" → [123, 45]

---

## Q14: Roman to Integer

**Problem:** Convert Roman numeral to integer.

**Logic (Detailed):**
- I=1, V=5, X=10, L=50, C=100, D=500, M=1000
- If smaller before larger, subtract: IV=4, IX=9, XL=40

```java
int result = 0;
for (int i = 0; i < roman.length(); i++) {
    int curr = romanValue(roman.charAt(i));
    int next = (i+1 < roman.length()) ? romanValue(roman.charAt(i+1)) : 0;
    result += (curr < next) ? -curr : curr;
}
```

**Trace for "MCMXCIV" (1994):**
```
M=1000, C<M so -100, M=1000, X<C so -10, C=100, I<V so -1, V=5
= 1000 - 100 + 1000 - 10 + 100 - 1 + 5 = 1994
```

---

## Q15: Integer to Roman

**Problem:** Convert integer to Roman numeral.

**Logic:** Greedy - subtract largest possible value repeatedly.

```java
int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

StringBuilder roman = new StringBuilder();
for (int i = 0; i < values.length; i++) {
    while (num >= values[i]) {
        roman.append(symbols[i]);
        num -= values[i];
    }
}
```

---

## Q16: Decode Encoded String

**Problem:** "3[a]2[bc]" → "aaabcbc"

**Logic:** Parse number, read content in brackets, repeat.

---

## Q17: Zigzag String Conversion

**Problem:** Arrange string in zigzag pattern across n rows.

**Example:** "PAYPALISHIRING", 3 rows:
```
P   A   H   N
A P L S I I G
Y   I   R
```
Read row-by-row: "PAHNAPLSIIGYIR"

---

## Q18: Look-and-Say Sequence

**Problem:** Describe previous term.

**Sequence:**
```
1           → "one 1"
11          → "two 1s"
21          → "one 2, one 1"
1211        → "one 1, one 2, two 1s"
111221      → ...
```

---

## Q19: String Multiplication

**Problem:** Multiply two number strings.

**Logic:** Grade-school multiplication digit by digit.

---

## Q20: Valid Anagram with Unicode

**Problem:** Check anagram supporting all characters.

**Logic:** Use HashMap for character frequency counting.
