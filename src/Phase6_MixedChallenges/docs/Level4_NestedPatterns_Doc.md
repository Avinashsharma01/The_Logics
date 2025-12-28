# Phase 6 - Mixed Challenges | Level 4: Nested Patterns (Q31-Q40)

## Overview
Complex pattern printing using nested loops.

---

## Q31: Number Triangle

```
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

**Logic:** Row i prints numbers 1 to i.

---

## Q32: Inverted Number Triangle

```
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
```

**Logic:** Row i (from n down to 1) prints 1 to i.

---

## Q33: Pyramid Pattern

```
    *
   ***
  *****
 *******
*********
```

**Logic (Detailed):**
- Row i: (n-i) spaces, then (2i-1) stars

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n-i; j++) System.out.print(" ");
    for (int j = 1; j <= 2*i-1; j++) System.out.print("*");
    System.out.println();
}
```

---

## Q34: Diamond Pattern

```
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
```

**Logic:** Upper pyramid + inverted pyramid (skip middle row in one).

---

## Q35: Hollow Diamond

```
    *
   * *
  *   *
 *     *
*       *
 *     *
  *   *
   * *
    *
```

**Logic:** Print star only at first and last position of each row.

---

## Q36: Pascal's Triangle

```
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
```

**Logic (Detailed):**
Each number = C(n,r) = n! / (r! × (n-r)!)

**Efficient calculation:**
```java
int num = 1;
for (int j = 0; j <= i; j++) {
    System.out.print(num + " ");
    num = num * (i - j) / (j + 1);
}
```

---

## Q37: Floyd's Triangle

```
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
```

**Logic:** Continuous numbering, row i has i numbers.

---

## Q38: Butterfly Pattern

```
*      *
**    **
***  ***
********
********
***  ***
**    **
*      *
```

**Logic (Detailed):**
- Row i: i stars + 2(n-i) spaces + i stars
- Upper half: i goes 1→n
- Lower half: i goes n→1

---

## Q39: Sandglass Pattern

```
*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********
```

**Logic:** Inverted pyramid + pyramid.

---

## Q40: Number Pyramid with Reflection

```
    1
   121
  12321
 1234321
123454321
```

**Logic (Detailed):**
- Spaces: n-i
- Ascending numbers: 1 to i
- Descending numbers: i-1 to 1

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n-i; j++) System.out.print(" ");
    for (int j = 1; j <= i; j++) System.out.print(j);
    for (int j = i-1; j >= 1; j--) System.out.print(j);
    System.out.println();
}
```
