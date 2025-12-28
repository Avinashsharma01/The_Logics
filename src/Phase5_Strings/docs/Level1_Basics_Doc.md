# Phase 5 - Strings | Level 1: Basics (Q1-Q10)

## Overview
Fundamental string operations: input/output, length, character access, case conversion, comparison.

---

## Q1: Input and Print String

**Problem:** Read and display strings.

**Logic (Detailed):**

Java provides two main ways to read strings:

**Method 1: `next()` - Single word**
- Reads until whitespace (space, tab, newline)
- "Hello World" → only "Hello" is read

**Method 2: `nextLine()` - Full line**
- Reads entire line including spaces
- "Hello World" → "Hello World" is read

```java
Scanner sc = new Scanner(System.in);

String word = sc.next();        // Reads one word
String line = sc.nextLine();    // Reads entire line
```

**Common pitfall - Buffer issue:**
```java
int num = sc.nextInt();
String str = sc.nextLine();  // This reads empty string!
```

**Why?** `nextInt()` leaves newline in buffer. Solution:
```java
int num = sc.nextInt();
sc.nextLine();               // Consume leftover newline
String str = sc.nextLine();  // Now reads correctly
```

---

## Q2: Find String Length

**Problem:** Get number of characters in string.

**Logic (Detailed):**

Use `length()` method (not property!):

```java
String str = "Hello";
int len = str.length();  // Returns 5
```

**Important distinction:**
- `String` uses `length()` method: `str.length()`
- `Array` uses `length` property: `arr.length`
- `ArrayList` uses `size()` method: `list.size()`

**How it works internally:**
- String stores a `char[]` array internally
- `length()` returns this array's length
- Time: O(1) - length is cached, not counted each time

---

## Q3: Print Each Character

**Problem:** Display characters one by one.

**Logic (Detailed):**

Use `charAt(index)` to access individual characters:

```java
String str = "Hello";

for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    System.out.println("Index " + i + ": " + ch);
}
```

**Trace for "Hello":**
```
i=0: charAt(0) = 'H'
i=1: charAt(1) = 'e'
i=2: charAt(2) = 'l'
i=3: charAt(3) = 'l'
i=4: charAt(4) = 'o'
```

**Index is 0-based:**
- First character: index 0
- Last character: index (length - 1)
- Accessing invalid index → `StringIndexOutOfBoundsException`

---

## Q4: Convert to Uppercase

**Problem:** Convert all lowercase letters to uppercase.

**Logic (Detailed):**

**Method 1: Built-in**
```java
String upper = str.toUpperCase();
```

**Method 2: Manual using ASCII**

ASCII values:
- 'a' to 'z' = 97 to 122
- 'A' to 'Z' = 65 to 90
- Difference = 32

```java
StringBuilder result = new StringBuilder();
for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (ch >= 'a' && ch <= 'z') {
        result.append((char)(ch - 32));  // Convert to uppercase
    } else {
        result.append(ch);
    }
}
```

**Why subtract 32:**
```
'a' = 97, 'A' = 65 → 97 - 32 = 65
'z' = 122, 'Z' = 90 → 122 - 32 = 90
```

**Trace for "Hello":**
```
'H' → not lowercase → 'H'
'e' → 101 - 32 = 69 → 'E'
'l' → 108 - 32 = 76 → 'L'
'l' → 108 - 32 = 76 → 'L'
'o' → 111 - 32 = 79 → 'O'

Result: "HELLO"
```

---

## Q5: Convert to Lowercase

**Problem:** Convert all uppercase letters to lowercase.

**Logic (Detailed):**

**Method 1: Built-in**
```java
String lower = str.toLowerCase();
```

**Method 2: Manual**
```java
if (ch >= 'A' && ch <= 'Z') {
    result.append((char)(ch + 32));  // Add 32 instead!
}
```

**Why add 32:**
```
'A' = 65, 'a' = 97 → 65 + 32 = 97
'Z' = 90, 'z' = 122 → 90 + 32 = 122
```

---

## Q6: Toggle Case

**Problem:** Swap uppercase ↔ lowercase.

**Logic (Detailed):**

Apply both conversions based on character type:

```java
for each character ch:
    if (ch >= 'a' && ch <= 'z'):
        result += (ch - 32)   // lowercase → uppercase
    else if (ch >= 'A' && ch <= 'Z'):
        result += (ch + 32)   // uppercase → lowercase
    else:
        result += ch          // keep as is
```

**Trace for "HeLLo":**
```
'H' → uppercase → 'h'
'e' → lowercase → 'E'
'L' → uppercase → 'l'
'L' → uppercase → 'l'
'o' → lowercase → 'O'

Result: "hEllO"
```

---

## Q7: Check String Equality

**Problem:** Compare two strings for equality.

**Logic (Detailed):**

**CRITICAL: Never use `==` for string comparison!**

```java
String a = "Hello";
String b = "Hello";
String c = new String("Hello");

a == b       // May be true (string pool optimization)
a == c       // FALSE! Different objects
a.equals(c)  // TRUE! Same content
```

**Why `==` fails:**
- `==` compares memory addresses (references)
- Two strings can have same content but different addresses

**Correct methods:**
```java
str1.equals(str2)           // Case-sensitive
str1.equalsIgnoreCase(str2) // Case-insensitive
str1.compareTo(str2)        // Returns: 0 if equal,
                            //          <0 if str1 < str2
                            //          >0 if str1 > str2
```

**compareTo works lexicographically:**
```
"apple".compareTo("banana") = -1 (a < b)
"cat".compareTo("car") = 19 (t > r, ASCII diff)
```

---

## Q8: Concatenate Strings

**Problem:** Join two strings together.

**Logic (Detailed):**

**Method 1: + operator**
```java
String result = str1 + str2;
```

**Method 2: concat() method**
```java
String result = str1.concat(str2);
```

**Method 3: StringBuilder (most efficient for multiple)**
```java
StringBuilder sb = new StringBuilder();
sb.append(str1).append(str2);
String result = sb.toString();
```

**Why StringBuilder is better for many concatenations:**

Strings are immutable. Each `+` creates new object:
```java
String s = "";
s = s + "a";  // Creates new String
s = s + "b";  // Creates another new String
s = s + "c";  // Creates yet another!
```

StringBuilder modifies same buffer:
```java
StringBuilder sb = new StringBuilder();
sb.append("a").append("b").append("c");  // Same object
```

**Performance for 1000 concatenations:**
- String +: Creates 1000 intermediate objects
- StringBuilder: Creates 1 object

---

## Q9: Extract Substring

**Problem:** Get portion of string.

**Logic (Detailed):**

```java
str.substring(start)       // From start to end
str.substring(start, end)  // From start to end-1 (exclusive!)
```

**Key insight: end is EXCLUSIVE**
```java
"Hello".substring(1, 4);  // Returns "ell" (indices 1,2,3)
```

**Manual implementation:**
```java
StringBuilder result = new StringBuilder();
for (int i = start; i < end; i++) {
    result.append(str.charAt(i));
}
```

**Trace for "Programming", substring(3, 7):**
```
Index: 0  1  2  3  4  5  6  7  8  9  10
Char:  P  r  o  g  r  a  m  m  i  n  g
           start→  g  r  a  m  ←end(exclusive)
           
Result: "gram"
```

---

## Q10: Check Contains Substring

**Problem:** Determine if substring exists within string.

**Logic (Detailed):**

**Method 1: contains()** - returns boolean
```java
boolean found = main.contains(sub);
```

**Method 2: indexOf()** - returns position or -1
```java
int index = main.indexOf(sub);
if (index != -1) {
    // Found at position 'index'
}
```

**How indexOf works internally (simplified):**
```
For each starting position in main:
    Try to match all characters of sub
    If complete match found, return position
Return -1 if no match
```

**Trace for main="Hello World", sub="World":**
```
Try from index 0: "Hello" ≠ "World"
Try from index 1: "ello " ≠ "World"
...
Try from index 6: "World" = "World" ✓

indexOf returns 6
contains returns true
```

**Time Complexity:** O(n × m) where n = main length, m = sub length
