# Phase 5 - Strings | Level 2: Counting (Q11-Q20)

## Overview
Counting and analyzing characters in strings: vowels, consonants, digits, frequencies.

---

## Q11: Count Vowels and Consonants

**Problem:** Count vowel and consonant letters.

**Logic (Detailed):**

**Vowels:** a, e, i, o, u (and uppercase versions)
**Consonants:** All other alphabetic characters

```java
for each character ch:
    if ch is a letter:
        if ch is 'a', 'e', 'i', 'o', 'u':
            vowelCount++
        else:
            consonantCount++
```

**Implementation tip:** Convert to lowercase first for simpler comparison:
```java
char ch = Character.toLowerCase(str.charAt(i));
```

**Trace for "Hello World":**
```
'h' → letter, not vowel → consonant (1)
'e' → letter, vowel → vowel (1)
'l' → consonant (2)
'l' → consonant (3)
'o' → vowel (2)
' ' → not letter, skip
'w' → consonant (4)
'o' → vowel (3)
'r' → consonant (5)
'l' → consonant (6)
'd' → consonant (7)

Result: 3 vowels, 7 consonants
```

---

## Q12: Count Digits

**Problem:** Count numeric characters (0-9).

**Logic (Detailed):**

**Method 1: ASCII range check**
```java
if (ch >= '0' && ch <= '9') {
    digitCount++;
}
```

**Method 2: Character.isDigit()**
```java
if (Character.isDigit(ch)) {
    digitCount++;
}
```

**Why '0' and not 0:**
- '0' is character (ASCII 48)
- 0 is integer
- "123" contains characters '1', '2', '3', not numbers 1, 2, 3

**Trace for "Hello123World456":**
```
h, e, l, l, o → not digits
'1' → digit (1)
'2' → digit (2)
'3' → digit (3)
W, o, r, l, d → not digits
'4' → digit (4)
'5' → digit (5)
'6' → digit (6)

Result: 6 digits
```

---

## Q13: Count Uppercase and Lowercase

**Problem:** Count capital and small letters separately.

**Logic (Detailed):**

```java
for each character ch:
    if (ch >= 'A' && ch <= 'Z'):
        upperCount++
    else if (ch >= 'a' && ch <= 'z'):
        lowerCount++
```

**Or using Character methods:**
```java
if (Character.isUpperCase(ch)):
    upperCount++
else if (Character.isLowerCase(ch)):
    lowerCount++
```

**Trace for "HeLLo WoRLd":**
```
H → upper (1)
e → lower (1)
L → upper (2)
L → upper (3)
o → lower (2)
  → neither
W → upper (4)
o → lower (3)
R → upper (5)
L → upper (6)
d → lower (4)

Result: 6 uppercase, 4 lowercase
```

---

## Q14: Count Spaces

**Problem:** Count space characters.

**Logic (Detailed):**

Simple comparison:
```java
for each character ch:
    if (ch == ' '):
        spaceCount++
```

**To count ALL whitespace (spaces, tabs, newlines):**
```java
if (Character.isWhitespace(ch)):
    whitespaceCount++
```

---

## Q15: Count Words

**Problem:** Count number of words in sentence.

**Logic (Detailed):**

**Method 1: Split and count**
```java
String[] words = str.trim().split("\\s+");
int count = words.length;
```

**Why `\\s+`:**
- `\s` matches any whitespace
- `+` means one or more
- Handles multiple consecutive spaces

**Method 2: Count transitions**
```java
int count = 0;
boolean inWord = false;

for each character ch:
    if (ch != ' '):
        if (!inWord):
            count++  // Started new word
            inWord = true
    else:
        inWord = false
```

**Trace for "  Hello   World  ":**
```
Split method: ["Hello", "World"] → 2 words
Transition method:
  spaces → not in word
  H → start word 1, inWord=true
  ello → continue
  spaces → inWord=false
  W → start word 2, inWord=true
  orld → continue
  spaces → inWord=false

Result: 2 words
```

---

## Q16: Count Specific Character

**Problem:** Count occurrences of target character.

**Logic (Detailed):**

```java
int count = 0;
for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) == target) {
        count++;
    }
}
```

**Trace for str="mississippi", target='s':**
```
m-i-s-s-i-s-s-i-p-p-i
    ^-^   ^-^
    
s found at indices: 2, 3, 5, 6
Result: 4 occurrences
```

---

## Q17: Frequency of Each Character

**Problem:** Count how many times each character appears.

**Logic (Detailed):**

**Key technique: Frequency Array**

Use array index as character identifier:
```java
int[] freq = new int[26];  // For lowercase letters

for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (ch >= 'a' && ch <= 'z') {
        freq[ch - 'a']++;  // Map 'a'→0, 'b'→1, ..., 'z'→25
    }
}
```

**Why `ch - 'a'`:**
```
'a' - 'a' = 97 - 97 = 0
'b' - 'a' = 98 - 97 = 1
'z' - 'a' = 122 - 97 = 25
```

**For all ASCII characters, use size 256:**
```java
int[] freq = new int[256];
freq[ch]++;  // Use ASCII value directly as index
```

**Trace for "hello":**
```
'h' → freq[7]++ → freq[7] = 1
'e' → freq[4]++ → freq[4] = 1
'l' → freq[11]++ → freq[11] = 1
'l' → freq[11]++ → freq[11] = 2
'o' → freq[14]++ → freq[14] = 1

Result: e=1, h=1, l=2, o=1
```

---

## Q18: Most Frequent Character

**Problem:** Find character with highest count.

**Logic (Detailed):**

Two-step approach:
1. Build frequency array
2. Find maximum in frequency array

```java
// Step 1: Build frequency
int[] freq = new int[26];
for each character:
    freq[ch - 'a']++

// Step 2: Find max
int maxFreq = 0;
char maxChar = ' ';

for (int i = 0; i < 26; i++) {
    if (freq[i] > maxFreq) {
        maxFreq = freq[i];
        maxChar = (char)('a' + i);  // Convert back to character
    }
}
```

**Trace for "abracadabra":**
```
Frequencies: a=5, b=2, c=1, d=1, r=2

Scan for max:
i=0 (a): freq=5 > 0 → maxFreq=5, maxChar='a'
i=1 (b): freq=2 < 5, skip
...

Result: 'a' appears 5 times
```

---

## Q19: First Non-Repeating Character

**Problem:** Find first character that appears exactly once.

**Logic (Detailed):**

Two-pass algorithm:
1. First pass: Build frequency array
2. Second pass: Find first with frequency = 1

```java
// Pass 1: Count frequencies
int[] freq = new int[256];
for (int i = 0; i < str.length(); i++) {
    freq[str.charAt(i)]++;
}

// Pass 2: Find first unique
for (int i = 0; i < str.length(); i++) {
    if (freq[str.charAt(i)] == 1) {
        return str.charAt(i);  // First non-repeating!
    }
}
```

**Why two passes:**
- Pass 1 counts ALL occurrences
- Pass 2 finds FIRST unique (preserving order)

**Trace for "swiss":**
```
Pass 1 - Frequencies:
s = 3, w = 1, i = 1

Pass 2 - Check in order:
s → freq=3 ≠ 1, skip
w → freq=1 = 1 ✓ → return 'w'

Result: 'w' is first non-repeating
```

**Trace for "aabb":**
```
Frequencies: a=2, b=2
No character has freq=1
Result: No non-repeating character
```

---

## Q20: Find Duplicate Characters

**Problem:** List characters that appear more than once.

**Logic (Detailed):**

```java
// Build frequency array
int[] freq = new int[256];
for each character:
    freq[ch]++

// Print duplicates
for (int i = 0; i < 256; i++) {
    if (freq[i] > 1) {
        print (char)i + " appears " + freq[i] + " times"
    }
}
```

**Trace for "programming":**
```
Frequencies:
a=1, g=2, i=1, m=2, n=1, o=1, p=1, r=2

Duplicates (freq > 1):
g → 2 times
m → 2 times
r → 2 times

Result: g, m, r are duplicates
```
