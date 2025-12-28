# Phase 3 - Recursion | Level 4: String Recursion (Q31-Q40)

## Overview
String manipulation using recursive techniques.

---

## Q31: Reverse String Recursively

**Problem:** Reverse a string using recursion.

**Logic (Detailed):**
- Take the first character, put it at the end
- Reverse the rest of the string
- Combine: reverse(rest) + first character

**Recursive insight:**
```
reverse("hello") = reverse("ello") + "h"
                 = reverse("llo") + "e" + "h"
                 = reverse("lo") + "l" + "e" + "h"
                 = reverse("o") + "l" + "l" + "e" + "h"
                 = "o" + "l" + "l" + "e" + "h"
                 = "olleh"
```

**Base case:**
- Empty string or single character → return as is

**Code structure:**
```
reverse(str):
  if str.length <= 1 → return str
  return reverse(str.substring(1)) + str.charAt(0)
```

**Step-by-step trace:**
```
reverse("abc"):
  return reverse("bc") + "a"
    return reverse("c") + "b"
      return "c" (base case)
    return "c" + "b" = "cb"
  return "cb" + "a" = "cba"
```

---

## Q32: Check String Palindrome

**Problem:** Check if string is palindrome recursively.

**Logic (Detailed):**
- Compare first and last characters
- If they match, check if middle is palindrome
- If they don't match, NOT a palindrome

**Recursive insight:**
```
isPalindrome("madam"):
  'm' == 'm'? YES
  isPalindrome("ada"):
    'a' == 'a'? YES
    isPalindrome("d"):
      length <= 1 → TRUE (base case)
    return TRUE
  return TRUE
return TRUE
```

**Structure:**
```
isPalindrome(str):
  if str.length <= 1 → return true (base case)
  if str.first != str.last → return false
  return isPalindrome(str.middle)
```

**Getting middle:**
- str.substring(1, str.length - 1)
- "madam" → "ada"
- "ada" → "d"

**Non-palindrome example:**
```
isPalindrome("hello"):
  'h' == 'o'? NO
  return FALSE immediately
```

---

## Q33: Count Vowels in String

**Problem:** Count vowels using recursion.

**Logic (Detailed):**
- Check if first character is a vowel
- If yes, count = 1 + count in rest
- If no, count = 0 + count in rest

**Vowels:** a, e, i, o, u (and uppercase versions)

**Recursive formula:**
```
countVowels(str):
  if str is empty → return 0
  if str.first is vowel:
    return 1 + countVowels(str.rest)
  else:
    return countVowels(str.rest)
```

**Trace for "hello":**
```
countVowels("hello"):
  'h' is vowel? NO
  return 0 + countVowels("ello")
    'e' is vowel? YES
    return 1 + countVowels("llo")
      'l' is vowel? NO
      return 0 + countVowels("lo")
        'l' is vowel? NO
        return 0 + countVowels("o")
          'o' is vowel? YES
          return 1 + countVowels("")
            return 0 (base case)
          return 1
        return 1
      return 1
    return 2
  return 2

Result: 2 vowels (e, o)
```

---

## Q34: Remove Spaces from String

**Problem:** Remove all spaces recursively.

**Logic (Detailed):**
- If first character is space, skip it
- Otherwise, keep it and process rest
- Build result by concatenation

**Structure:**
```
removeSpaces(str):
  if str is empty → return ""
  if str.first == ' ':
    return removeSpaces(str.rest)  // Skip space
  else:
    return str.first + removeSpaces(str.rest)  // Keep char
```

**Trace for "a b c":**
```
removeSpaces("a b c"):
  'a' ≠ ' ' → "a" + removeSpaces(" b c")
    ' ' == ' ' → removeSpaces("b c")  // Skip space
      'b' ≠ ' ' → "b" + removeSpaces(" c")
        ' ' == ' ' → removeSpaces("c")
          'c' ≠ ' ' → "c" + removeSpaces("")
            return "" (base)
          return "c"
        return "c"
      return "bc"
    return "bc"
  return "abc"

Result: "abc"
```

---

## Q35: Replace Character in String

**Problem:** Replace all occurrences of a character.

**Logic (Detailed):**
- Check each character
- If it matches target, use replacement
- Otherwise, keep original

**Structure:**
```
replace(str, oldChar, newChar):
  if str is empty → return ""
  if str.first == oldChar:
    return newChar + replace(str.rest, oldChar, newChar)
  else:
    return str.first + replace(str.rest, oldChar, newChar)
```

**Trace for replace("hello", 'l', 'x'):**
```
replace("hello", 'l', 'x'):
  'h' ≠ 'l' → "h" + replace("ello")
    'e' ≠ 'l' → "e" + replace("llo")
      'l' == 'l' → "x" + replace("lo")
        'l' == 'l' → "x" + replace("o")
          'o' ≠ 'l' → "o" + replace("")
            return ""
          return "o"
        return "xo"
      return "xxo"
    return "exxo"
  return "hexxo"

Result: "hexxo"
```

---

## Q36: Remove All Occurrences of Character

**Problem:** Remove specific character from string.

**Logic (Detailed):**
- If character matches target, skip it (don't include)
- Otherwise, include in result

**Structure:**
```
removeChar(str, ch):
  if str is empty → return ""
  if str.first == ch:
    return removeChar(str.rest, ch)  // Skip
  else:
    return str.first + removeChar(str.rest, ch)  // Keep
```

**This is identical to Q34 (remove spaces), just with any character!**

**Trace for removeChar("hello", 'l'):**
```
removeChar("hello", 'l'):
  'h' ≠ 'l' → "h" + removeChar("ello")
    'e' ≠ 'l' → "e" + removeChar("llo")
      'l' == 'l' → removeChar("lo")  // Skip
        'l' == 'l' → removeChar("o")  // Skip
          'o' ≠ 'l' → "o" + removeChar("")
            return ""
          return "o"
        return "o"
      return "o"
    return "eo"
  return "heo"

Result: "heo"
```

---

## Q37: Print Characters One by One

**Problem:** Print each character on new line.

**Logic (Detailed):**
- Print first character
- Recurse for rest of string
- Base case: empty string

**Structure:**
```
printChars(str):
  if str is empty → return
  print str.first
  printChars(str.rest)
```

**Trace for "abc":**
```
printChars("abc"):
  print 'a'
  printChars("bc"):
    print 'b'
    printChars("c"):
      print 'c'
      printChars(""):
        return

Output:
a
b
c
```

---

## Q38: Print Characters in Reverse

**Problem:** Print characters in reverse order.

**Logic (Detailed):**
- Recurse FIRST, then print
- Deepest recursion prints first (last character)
- Uses call stack as implicit storage

**Structure:**
```
printReverse(str):
  if str is empty → return
  printReverse(str.rest)  // Go to end first
  print str.first         // Print on way back
```

**Trace for "abc":**
```
printReverse("abc"):
  printReverse("bc"):
    printReverse("c"):
      printReverse(""):
        return
      print 'c'
    print 'b'
  print 'a'

Output:
c
b
a
```

**Key pattern:** Recurse-then-act = reverse order

---

## Q39: Count Specific Character

**Problem:** Count occurrences of a character.

**Logic (Detailed):**
- If first matches target, count = 1 + count in rest
- If not, count = just count in rest

**Structure:**
```
countChar(str, ch):
  if str is empty → return 0
  if str.first == ch:
    return 1 + countChar(str.rest, ch)
  else:
    return countChar(str.rest, ch)
```

**Trace for countChar("mississippi", 's'):**
```
countChar("mississippi", 's'):
  'm' ≠ 's' → countChar("ississippi")
    'i' ≠ 's' → countChar("ssissippi")
      's' == 's' → 1 + countChar("sissippi")
        's' == 's' → 1 + countChar("issippi")
          'i' ≠ 's' → countChar("ssippi")
            's' == 's' → 1 + countChar("sippi")
              's' == 's' → 1 + countChar("ippi")
                'i' ≠ 's' → countChar("ppi")
                  ... continues ...
                  eventually returns 0

Working backwards: 0 → 0 → 0 → 1 → 2 → 2 → 3 → 4

Result: 4
```

---

## Q40: Check if String Contains Character

**Problem:** Check if character exists in string.

**Logic (Detailed):**
- If first matches target, return TRUE immediately
- If not, check in rest of string
- Base case: empty string → FALSE (not found)

**Structure:**
```
contains(str, ch):
  if str is empty → return false
  if str.first == ch → return true  // Found!
  return contains(str.rest, ch)
```

**Key insight - Short circuit:**
- Return TRUE immediately when found
- No need to check rest of string!

**Trace for contains("hello", 'l'):**
```
contains("hello", 'l'):
  'h' ≠ 'l' → contains("ello", 'l')
    'e' ≠ 'l' → contains("llo", 'l')
      'l' == 'l' → return TRUE immediately!

Result: true (found at 3rd character)
```

**Trace for contains("hello", 'z'):**
```
contains("hello", 'z'):
  'h' ≠ 'z' → contains("ello")
    'e' ≠ 'z' → contains("llo")
      'l' ≠ 'z' → contains("lo")
        'l' ≠ 'z' → contains("o")
          'o' ≠ 'z' → contains("")
            return FALSE (base case)

Result: false (not found after checking all)
```
