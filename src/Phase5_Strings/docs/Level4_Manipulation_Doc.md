# Phase 5 - Strings | Level 4: Manipulation (Q31-Q40)

## Overview
String transformation: removing, replacing, compressing, and formatting characters.

---

## Q31: Remove All Spaces

**Problem:** Delete all space characters from string.

**Logic (Detailed):**

**Method 1: Built-in replace**
```java
String result = str.replace(" ", "");
```

**Method 2: Manual filter**
```java
StringBuilder result = new StringBuilder();
for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) != ' ') {
        result.append(str.charAt(i));
    }
}
```

**Trace for "Hello World Program":**
```
H → keep
e → keep
l → keep
l → keep
o → keep
  → skip (space)
W → keep
...

Result: "HelloWorldProgram"
```

---

## Q32: Remove All Vowels

**Problem:** Delete all vowel characters (a, e, i, o, u).

**Logic (Detailed):**

```java
StringBuilder result = new StringBuilder();

for (int i = 0; i < str.length(); i++) {
    char ch = Character.toLowerCase(str.charAt(i));
    if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
        result.append(str.charAt(i));  // Keep original case
    }
}
```

**Using regex:**
```java
String result = str.replaceAll("[aeiouAEIOU]", "");
```

**Trace for "Beautiful":**
```
B → not vowel → keep
e → vowel → skip
a → vowel → skip
u → vowel → skip
t → keep
i → vowel → skip
f → keep
u → vowel → skip
l → keep

Result: "Btfl"
```

---

## Q33: Remove Duplicate Characters

**Problem:** Keep only first occurrence of each character.

**Logic (Detailed):**

**Key technique: Boolean tracking array**

```java
boolean[] seen = new boolean[256];  // Track seen characters
StringBuilder result = new StringBuilder();

for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (!seen[ch]) {
        seen[ch] = true;  // Mark as seen
        result.append(ch);
    }
}
```

**Trace for "programming":**
```
p → not seen, add, seen[p]=true → "p"
r → not seen, add → "pr"
o → not seen, add → "pro"
g → not seen, add → "prog"
r → already seen, skip
a → not seen, add → "proga"
m → not seen, add → "progam"
m → already seen, skip
i → not seen, add → "progami"
n → not seen, add → "progamin"
g → already seen, skip

Result: "progamin"
```

---

## Q34: Replace Character

**Problem:** Replace all occurrences of one character with another.

**Logic (Detailed):**

**Method 1: Built-in**
```java
String result = str.replace(oldChar, newChar);
```

**Method 2: Manual**
```java
StringBuilder result = new StringBuilder();
for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) == oldChar) {
        result.append(newChar);
    } else {
        result.append(str.charAt(i));
    }
}
```

**Trace for str="hello", old='l', new='x':**
```
h → not 'l' → 'h'
e → not 'l' → 'e'
l → is 'l' → 'x'
l → is 'l' → 'x'
o → not 'l' → 'o'

Result: "hexxo"
```

---

## Q35: Remove Specific Character

**Problem:** Delete all occurrences of target character.

**Logic (Detailed):**

Same as replace, but append nothing for target:

```java
StringBuilder result = new StringBuilder();
for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) != target) {
        result.append(str.charAt(i));
    }
}
```

**This is essentially filtering - keep only non-matching characters.**

---

## Q36: Remove Consecutive Duplicates

**Problem:** "aabbcc" → "abc" (keep one of each consecutive group)

**Logic (Detailed):**

Add character only if different from previous:

```java
if (str.length() == 0) return "";

StringBuilder result = new StringBuilder();
result.append(str.charAt(0));  // Always add first

for (int i = 1; i < str.length(); i++) {
    if (str.charAt(i) != str.charAt(i - 1)) {
        result.append(str.charAt(i));
    }
}
```

**Trace for "aabbbcccc":**
```
i=0: 'a' → always add first → "a"
i=1: 'a' == prev 'a'? YES → skip
i=2: 'b' == prev 'a'? NO → add → "ab"
i=3: 'b' == prev 'b'? YES → skip
i=4: 'b' == prev 'b'? YES → skip
i=5: 'c' == prev 'b'? NO → add → "abc"
i=6,7,8: 'c' == prev 'c'? YES → skip

Result: "abc"
```

**Compare Q33 vs Q36:**
- Q33: Remove ALL duplicates globally
- Q36: Remove only CONSECUTIVE duplicates

---

## Q37: String Compression (Run-Length Encoding)

**Problem:** "aaabbc" → "a3b2c1"

**Logic (Detailed):**

Count consecutive occurrences, append character + count:

```java
StringBuilder result = new StringBuilder();
int count = 1;

for (int i = 1; i <= str.length(); i++) {
    if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
        count++;
    } else {
        result.append(str.charAt(i - 1));
        result.append(count);
        count = 1;  // Reset for next group
    }
}
```

**Trace for "aaabbc":**
```
i=1: 'a'=='a'? YES → count=2
i=2: 'a'=='a'? YES → count=3
i=3: 'b'=='a'? NO → append "a3", reset count=1
i=4: 'b'=='b'? YES → count=2
i=5: 'c'=='b'? NO → append "b2", reset count=1
i=6: end → append "c1"

Result: "a3b2c1"
```

**When compression is useful:**
- "aaaaaaaaaa" (10 chars) → "a10" (3 chars) ✓
- "abc" (3 chars) → "a1b1c1" (6 chars) ✗ worse!

---

## Q38: Expand Compressed String

**Problem:** "a3b2c1" → "aaabbc"

**Logic (Detailed):**

Parse character-count pairs, repeat each character:

```java
StringBuilder result = new StringBuilder();
int i = 0;

while (i < str.length()) {
    char ch = str.charAt(i);
    i++;
    
    // Read the number (can be multi-digit)
    StringBuilder numStr = new StringBuilder();
    while (i < str.length() && Character.isDigit(str.charAt(i))) {
        numStr.append(str.charAt(i));
        i++;
    }
    
    int count = Integer.parseInt(numStr.toString());
    
    // Append character 'count' times
    for (int j = 0; j < count; j++) {
        result.append(ch);
    }
}
```

**Trace for "a3b2c1":**
```
i=0: ch='a', read "3" → count=3 → append "aaa"
i=2: ch='b', read "2" → count=2 → append "bb"
i=4: ch='c', read "1" → count=1 → append "c"

Result: "aaabbc"
```

---

## Q39: Capitalize First Letter of Each Word

**Problem:** "hello world" → "Hello World"

**Logic (Detailed):**

Capitalize character after space (or at beginning):

```java
StringBuilder result = new StringBuilder();
boolean capitalizeNext = true;

for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    
    if (ch == ' ') {
        result.append(ch);
        capitalizeNext = true;
    } else {
        if (capitalizeNext && ch >= 'a' && ch <= 'z') {
            result.append((char)(ch - 32));  // Uppercase
        } else {
            result.append(ch);
        }
        capitalizeNext = false;
    }
}
```

**Trace for "hello world":**
```
capitalizeNext = true
h → capitalize → 'H', capitalizeNext=false
e, l, l, o → keep lowercase
  → space, capitalizeNext=true
w → capitalize → 'W', capitalizeNext=false
o, r, l, d → keep lowercase

Result: "Hello World"
```

---

## Q40: Sentence Case

**Problem:** "hello. world!" → "Hello. World!"

**Logic (Detailed):**

Capitalize after sentence terminators (. ! ?):

```java
StringBuilder result = new StringBuilder();
boolean capitalizeNext = true;

for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    
    if (ch == '.' || ch == '!' || ch == '?') {
        result.append(ch);
        capitalizeNext = true;
    } else if (ch == ' ') {
        result.append(ch);
        // Don't change capitalizeNext
    } else {
        if (capitalizeNext && ch >= 'a' && ch <= 'z') {
            result.append((char)(ch - 32));
            capitalizeNext = false;
        } else if (capitalizeNext && ch >= 'A' && ch <= 'Z') {
            result.append(ch);
            capitalizeNext = false;
        } else {
            result.append(ch);
        }
    }
}
```

**Trace for "hello. how are you? fine!":**
```
capitalizeNext = true
h → capitalize → 'H', capitalizeNext=false
ello → keep
. → terminator, capitalizeNext=true
  → space
h → capitalize → 'H', capitalizeNext=false
ow are you → keep
? → terminator, capitalizeNext=true
  → space
f → capitalize → 'F', capitalizeNext=false
ine → keep
! → terminator

Result: "Hello. How are you? Fine!"
```

**Difference from Q39:**
- Q39: Capitalize after every space (Title Case)
- Q40: Capitalize after sentence terminators (Sentence Case)
