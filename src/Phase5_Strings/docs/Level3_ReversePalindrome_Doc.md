# Phase 5 - Strings | Level 3: Reverse & Palindrome (Q21-Q30)

## Overview
String reversal techniques and palindrome detection algorithms.

---

## Q21: Reverse a String

**Problem:** Reverse the order of characters.

**Logic (Detailed):**

**Method 1: StringBuilder.reverse()**
```java
String reversed = new StringBuilder(str).reverse().toString();
```

**Method 2: Build backwards**
```java
StringBuilder result = new StringBuilder();
for (int i = str.length() - 1; i >= 0; i--) {
    result.append(str.charAt(i));
}
```

**Method 3: Two-pointer swap (in-place on char array)**
```java
char[] chars = str.toCharArray();
int left = 0, right = chars.length - 1;

while (left < right) {
    // Swap
    char temp = chars[left];
    chars[left] = chars[right];
    chars[right] = temp;
    left++;
    right--;
}

String reversed = new String(chars);
```

**Trace of two-pointer for "Hello":**
```
Initial: [H, e, l, l, o]
          ↑           ↑
          L           R

Step 1:  [o, e, l, l, H]  swap H↔o
             ↑     ↑
             L     R

Step 2:  [o, l, l, e, H]  swap e↔l
                ↑
              L=R (stop)

Result: "olleH"
```

---

## Q22: Check if Palindrome

**Problem:** Check if string reads same forwards and backwards.

**Logic (Detailed):**

**Two-pointer approach:**
- Compare first and last characters
- Move inward
- If any mismatch, not palindrome

```java
int left = 0, right = str.length() - 1;

while (left < right) {
    if (str.charAt(left) != str.charAt(right)) {
        return false;  // Mismatch found
    }
    left++;
    right--;
}
return true;  // All matched
```

**Trace for "radar":**
```
left=0, right=4: 'r' == 'r' ✓
left=1, right=3: 'a' == 'a' ✓
left=2, right=2: left >= right, stop

Result: palindrome ✓
```

**Trace for "hello":**
```
left=0, right=4: 'h' == 'o'? NO

Result: not palindrome
```

**Alternative - Compare with reverse:**
```java
String reverse = new StringBuilder(str).reverse().toString();
return str.equals(reverse);
```

---

## Q23: Palindrome Ignoring Non-Alphanumeric

**Problem:** Check palindrome considering only letters and digits.

**Logic (Detailed):**

**Example:** "A man, a plan, a canal: Panama" → true

**Two-step approach:**
1. Clean string (keep only alphanumeric, convert to lowercase)
2. Check palindrome on cleaned string

```java
// Step 1: Clean
StringBuilder clean = new StringBuilder();
for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (Character.isLetterOrDigit(ch)) {
        clean.append(Character.toLowerCase(ch));
    }
}

// Step 2: Check palindrome
String cleanStr = clean.toString();
String reverse = clean.reverse().toString();
return cleanStr.equals(reverse);
```

**Trace for "A man, a plan, a canal: Panama":**
```
Original: "A man, a plan, a canal: Panama"
Cleaned: "amanaplanacanalpanama"
Reverse: "amanaplanacanalpanama"
Equal? YES → palindrome!
```

---

## Q24: Reverse Words in Sentence

**Problem:** "Hello World" → "World Hello"

**Logic (Detailed):**

**Method: Split, reverse array, join**

```java
String[] words = str.trim().split("\\s+");
StringBuilder result = new StringBuilder();

for (int i = words.length - 1; i >= 0; i--) {
    result.append(words[i]);
    if (i > 0) {
        result.append(" ");
    }
}
```

**Trace for "The quick brown fox":**
```
Split: ["The", "quick", "brown", "fox"]
Iterate backwards:
  i=3: "fox"
  i=2: "fox brown"
  i=1: "fox brown quick"
  i=0: "fox brown quick The"

Result: "fox brown quick The"
```

---

## Q25: Reverse Each Word

**Problem:** "Hello World" → "olleH dlroW"

**Logic (Detailed):**

Keep word positions, reverse characters within each word:

```java
String[] words = str.split(" ");
StringBuilder result = new StringBuilder();

for (int i = 0; i < words.length; i++) {
    String reversedWord = new StringBuilder(words[i]).reverse().toString();
    result.append(reversedWord);
    if (i < words.length - 1) {
        result.append(" ");
    }
}
```

**Trace for "Hello World":**
```
words: ["Hello", "World"]

"Hello" reversed → "olleH"
"World" reversed → "dlroW"

Result: "olleH dlroW"
```

**Compare Q24 vs Q25:**
- Q24: Reverse order of words
- Q25: Reverse letters within each word

---

## Q26: Longest Palindromic Substring

**Problem:** Find longest palindrome within string.

**Logic (Detailed):**

**Expand Around Center Algorithm:**

For each position, try to expand outward while characters match:
- Handle odd length: center is single character
- Handle even length: center is between two characters

```java
for (int i = 0; i < str.length(); i++) {
    // Odd length palindrome
    int len1 = expandAroundCenter(str, i, i);
    
    // Even length palindrome
    int len2 = expandAroundCenter(str, i, i + 1);
    
    int maxLen = Math.max(len1, len2);
    // Update if longer than current best
}

int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() 
           && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;  // Length of palindrome
}
```

**Trace for "babad":**
```
i=0 (b): expand(0,0) → "b" (len 1)
         expand(0,1) → "ba" not palindrome (len 0)

i=1 (a): expand(1,1) → "bab" (len 3) ✓
         expand(1,2) → "ab" not palindrome

i=2 (b): expand(2,2) → "aba" (len 3)
         expand(2,3) → "ba" not palindrome

...

Longest: "bab" or "aba" (length 3)
```

**Time:** O(n²), **Space:** O(1)

---

## Q27: Count Palindromic Substrings

**Problem:** Count all palindromic substrings.

**Logic (Detailed):**

Same expand approach, but count instead of track longest:

```java
int count = 0;
for (int i = 0; i < str.length(); i++) {
    count += countPalindromes(str, i, i);      // Odd
    count += countPalindromes(str, i, i + 1);  // Even
}

int countPalindromes(String s, int left, int right) {
    int count = 0;
    while (left >= 0 && right < s.length() 
           && s.charAt(left) == s.charAt(right)) {
        count++;  // Found one palindrome
        left--;
        right++;
    }
    return count;
}
```

**Trace for "aaa":**
```
i=0: expand(0,0) → "a" (1), then "aa" not possible from this center
     expand(0,1) → "aa" (1)
i=1: expand(1,1) → "a" (1), "aaa" (1)
     expand(1,2) → "aa" (1)
i=2: expand(2,2) → "a" (1)
     expand(2,3) → nothing

Total: 1+1+1+1+1+1 = 6
Palindromes: "a", "a", "a", "aa", "aa", "aaa"
```

---

## Q28: Check if Rotation is Palindrome

**Problem:** Can any rotation of string form a palindrome?

**Logic (Detailed):**

Check all possible rotations:

```java
String doubled = str + str;  // All rotations are substrings

for (int i = 0; i < str.length(); i++) {
    String rotation = doubled.substring(i, i + str.length());
    if (isPalindrome(rotation)) {
        return true;
    }
}
return false;
```

**Why str + str works:**
```
str = "abc"
str + str = "abcabc"

Rotations:
  substring(0, 3) = "abc"
  substring(1, 4) = "bca"
  substring(2, 5) = "cab"
```

---

## Q29: Minimum Characters to Append for Palindrome

**Problem:** Find minimum characters to add at end to make palindrome.

**Logic (Detailed):**

**Key insight:** Find longest palindromic suffix, then append reverse of remaining prefix.

```java
// Find longest palindromic suffix
int i;
for (i = 0; i < str.length(); i++) {
    String suffix = str.substring(i);
    if (isPalindrome(suffix)) {
        break;
    }
}

// Characters to append = reverse of prefix
String prefix = str.substring(0, i);
String toAppend = new StringBuilder(prefix).reverse().toString();
```

**Trace for "race":**
```
i=0: suffix "race" → palindrome? NO
i=1: suffix "ace" → palindrome? NO
i=2: suffix "ce" → palindrome? NO
i=3: suffix "e" → palindrome? YES!

prefix = "rac"
toAppend = reverse("rac") = "car"

Result: "race" + "car" = "racecar" ✓
```

---

## Q30: Check if Two Strings are Palindrome of Each Other

**Problem:** Is str1 the reverse of str2?

**Logic (Detailed):**

```java
String reverse1 = new StringBuilder(str1).reverse().toString();
String reverse2 = new StringBuilder(str2).reverse().toString();

// str1 is palindrome of str2 if str1 == reverse(str2)
boolean result = str1.equals(reverse2);
```

**Example:**
```
str1 = "abc"
str2 = "cba"

reverse(str2) = "abc"
str1 == "abc"? YES

str1 and str2 are palindromes of each other
```

**Note:** This is different from both being palindromes individually!
- "abc" is NOT a palindrome
- "cba" is NOT a palindrome
- But "abc" is reverse of "cba"
