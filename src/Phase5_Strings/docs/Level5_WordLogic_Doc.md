# Phase 5 - Strings | Level 5: Word Logic (Q41-Q50)

## Overview
Word-level operations: longest/shortest word, anagrams, rotations, subsequences.

---

## Q41: Find Longest Word

**Problem:** Find word with most characters in sentence.

**Logic (Detailed):**

```java
String[] words = str.split("\\s+");
String longest = "";

for (String word : words) {
    if (word.length() > longest.length()) {
        longest = word;
    }
}
```

**Trace for "The quick brown fox jumps":**
```
words: ["The", "quick", "brown", "fox", "jumps"]

"The" (3) > "" (0) → longest = "The"
"quick" (5) > "The" (3) → longest = "quick"
"brown" (5) > "quick" (5)? NO
"fox" (3) > "quick" (5)? NO
"jumps" (5) > "quick" (5)? NO

Result: "quick" (5 characters)
```

**Note:** If multiple words have same length, first one wins.

---

## Q42: Find Shortest Word

**Problem:** Find word with fewest characters.

**Logic (Detailed):**

```java
String[] words = str.split("\\s+");
String shortest = words[0];  // Start with first word

for (String word : words) {
    if (word.length() < shortest.length()) {
        shortest = word;
    }
}
```

**Trace for "The quick brown fox jumps":**
```
shortest = "The" (3)
"quick" (5) < 3? NO
"brown" (5) < 3? NO
"fox" (3) < 3? NO (equal, not less)
"jumps" (5) < 3? NO

Result: "The" (3 characters)
```

---

## Q43: Check if Two Strings are Anagrams

**Problem:** Do strings contain same characters in different order?

**Logic (Detailed):**

**Anagrams:** "listen" and "silent", "evil" and "vile"

**Method 1: Sort and compare**
```java
char[] arr1 = str1.toCharArray();
char[] arr2 = str2.toCharArray();
Arrays.sort(arr1);
Arrays.sort(arr2);
boolean isAnagram = Arrays.equals(arr1, arr2);
```

**Method 2: Frequency count (more efficient)**
```java
if (str1.length() != str2.length()) return false;

int[] freq = new int[26];

for (int i = 0; i < str1.length(); i++) {
    freq[str1.charAt(i) - 'a']++;  // Increment for str1
    freq[str2.charAt(i) - 'a']--;  // Decrement for str2
}

// If anagrams, all counts should be 0
for (int count : freq) {
    if (count != 0) return false;
}
return true;
```

**Why frequency method works:**
- Each char in str1 adds +1
- Same char in str2 subtracts -1
- If same characters, everything cancels to 0

**Trace for "listen" and "silent":**
```
Method 1:
sorted("listen") = "eilnst"
sorted("silent") = "eilnst"
Equal? YES → anagrams

Method 2:
freq after processing:
l: +1-1=0, i: +1-1=0, s: +1-1=0
t: +1-1=0, e: +1-1=0, n: +1-1=0

All zeros → anagrams
```

---

## Q44: Check if Rotation

**Problem:** Is one string a rotation of another?

**Logic (Detailed):**

**Key insight:** If A is rotation of B, then A is substring of B+B

```
A = "waterbottle"
B = "erbottlewat"

B + B = "erbottlewaterbottlewat"
           ^----------^
           Contains A!
```

**Why this works:**
- Rotation means cutting at some point and rejoining
- B+B contains all possible rotations of B

```java
if (str1.length() != str2.length()) return false;
String doubled = str2 + str2;
return doubled.contains(str1);
```

**Trace for "abc" and "bca":**
```
doubled = "bcabca"
"bcabca".contains("abc")?
  "bca" → NO
  "cab" → NO
  "abc" → YES!

Result: "abc" is rotation of "bca"
```

---

## Q45: Check All Unique Characters

**Problem:** Does string have all distinct characters?

**Logic (Detailed):**

```java
boolean[] seen = new boolean[256];

for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (seen[ch]) {
        return false;  // Already seen this character
    }
    seen[ch] = true;
}
return true;  // No duplicates
```

**Trace for "world":**
```
'w' → seen[w]=false → mark true, continue
'o' → seen[o]=false → mark true, continue
'r' → seen[r]=false → mark true, continue
'l' → seen[l]=false → mark true, continue
'd' → seen[d]=false → mark true, continue

All unique: true
```

**Trace for "hello":**
```
'h' → not seen → mark
'e' → not seen → mark
'l' → not seen → mark
'l' → ALREADY SEEN → return false

Result: false (has duplicate 'l')
```

---

## Q46: Find Common Characters

**Problem:** Characters present in both strings.

**Logic (Detailed):**

```java
boolean[] inStr1 = new boolean[26];

// Mark characters in str1
for (int i = 0; i < str1.length(); i++) {
    char ch = str1.charAt(i);
    if (ch >= 'a' && ch <= 'z') {
        inStr1[ch - 'a'] = true;
    }
}

boolean[] common = new boolean[26];

// Find common with str2
for (int i = 0; i < str2.length(); i++) {
    char ch = str2.charAt(i);
    if (ch >= 'a' && ch <= 'z' && inStr1[ch - 'a']) {
        common[ch - 'a'] = true;
    }
}
```

**Trace for str1="hello", str2="world":**
```
inStr1: e, h, l, o marked true

Check str2:
'w' → in str1? NO
'o' → in str1? YES → common[o]=true
'r' → in str1? NO
'l' → in str1? YES → common[l]=true
'd' → in str1? NO

Common characters: l, o
```

---

## Q47: Remove Words Containing Character

**Problem:** Remove words that contain specific character.

**Logic (Detailed):**

```java
String[] words = str.split("\\s+");
StringBuilder result = new StringBuilder();

for (String word : words) {
    boolean hasTarget = word.toLowerCase().indexOf(target) != -1;
    
    if (!hasTarget) {
        if (result.length() > 0) result.append(" ");
        result.append(word);
    }
}
```

**Trace for "The quick brown fox", target='o':**
```
"The" → contains 'o'? NO → keep
"quick" → contains 'o'? NO → keep
"brown" → contains 'o'? YES → remove
"fox" → contains 'o'? YES → remove

Result: "The quick"
```

---

## Q48: Sort Words Alphabetically

**Problem:** Arrange words in alphabetical order.

**Logic (Detailed):**

```java
String[] words = str.split("\\s+");

// Bubble sort for understanding
for (int i = 0; i < words.length - 1; i++) {
    for (int j = 0; j < words.length - 1 - i; j++) {
        if (words[j].compareToIgnoreCase(words[j + 1]) > 0) {
            // Swap
            String temp = words[j];
            words[j] = words[j + 1];
            words[j + 1] = temp;
        }
    }
}
```

**How compareToIgnoreCase works:**
- Returns negative if first < second
- Returns 0 if equal
- Returns positive if first > second

**Trace for "delta alpha charlie bravo":**
```
Initial: ["delta", "alpha", "charlie", "bravo"]

Pass 1:
  delta > alpha? YES → swap → ["alpha", "delta", "charlie", "bravo"]
  delta > charlie? YES → swap → ["alpha", "charlie", "delta", "bravo"]
  delta > bravo? YES → swap → ["alpha", "charlie", "bravo", "delta"]

Pass 2:
  alpha > charlie? NO
  charlie > bravo? YES → swap → ["alpha", "bravo", "charlie", "delta"]

Pass 3:
  alpha > bravo? NO
  ...

Result: "alpha bravo charlie delta"
```

---

## Q49: Check Subsequence

**Problem:** Is one string a subsequence of another?

**Logic (Detailed):**

**Subsequence:** Characters appear in same order but not necessarily consecutive.
- "ace" is subsequence of "abcde"
- "aec" is NOT subsequence of "abcde" (wrong order)

**Two-pointer approach:**
```java
int i = 0;  // Pointer for main string
int j = 0;  // Pointer for potential subsequence

while (i < main.length() && j < sub.length()) {
    if (main.charAt(i) == sub.charAt(j)) {
        j++;  // Match found, advance sub pointer
    }
    i++;  // Always advance main pointer
}

return j == sub.length();  // All sub chars found in order?
```

**Trace for main="abcde", sub="ace":**
```
i=0, j=0: main[0]='a' == sub[0]='a' → j++
i=1, j=1: main[1]='b' != sub[1]='c'
i=2, j=1: main[2]='c' == sub[1]='c' → j++
i=3, j=2: main[3]='d' != sub[2]='e'
i=4, j=2: main[4]='e' == sub[2]='e' → j++

j=3 == sub.length()=3 → TRUE, is subsequence
```

**Trace for main="abcde", sub="aec":**
```
i=0, j=0: 'a'=='a' → j=1
i=1, j=1: 'b'!='e'
i=2, j=1: 'c'!='e'
i=3, j=1: 'd'!='e'
i=4, j=1: 'e'=='e' → j=2
End of main, j=2 != sub.length()=3

FALSE, not subsequence (need 'c' after 'e')
```

---

## Q50: Permutation Check

**Problem:** Is one string a permutation (rearrangement) of another?

**Logic (Detailed):**

**Same as anagram!** Permutation = same characters, different order.

**Method: Frequency count**
```java
if (str1.length() != str2.length()) return false;

int[] freq = new int[256];  // All ASCII

for (int i = 0; i < str1.length(); i++) {
    freq[str1.charAt(i)]++;
    freq[str2.charAt(i)]--;
}

for (int count : freq) {
    if (count != 0) return false;
}
return true;
```

**Trace for "dog" and "god":**
```
Frequency after processing:
'd': +1-0=1, then 0-1=-1... wait

Let's trace properly:
i=0: freq['d']++, freq['g']-- → d=1, g=-1
i=1: freq['o']++, freq['o']-- → o=0
i=2: freq['g']++, freq['d']-- → g=0, d=0

All zeros → permutations ✓
```

**Time:** O(n), **Space:** O(1) with fixed-size array

**Difference: Anagram vs Permutation:**
- Anagram typically refers to words/phrases
- Permutation is mathematical term
- For strings, they mean the same thing!
