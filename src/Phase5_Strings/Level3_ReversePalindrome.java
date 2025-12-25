/**
 * ============================================
 * PHASE 5 - STRINGS
 * Level 3: Reverse & Palindrome (Questions 21-30)
 * ============================================
 * 
 * CONCEPT: String reversal and palindrome checking.
 * 
 * KEY TECHNIQUES:
 * - Two-pointer approach
 * - StringBuilder reverse()
 * - Character array manipulation
 */

import java.util.Scanner;

public class Level3_ReversePalindrome {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment to practice
        // question21();
        // question22();
        // question23();
        // question24();
        // question25();
        // question26();
        // question27();
        // question28();
        // question29();
        // question30();
    }
    
    // =========================================================================
    // QUESTION 21: Reverse a string
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Multiple methods:
     * 1. StringBuilder reverse()
     * 2. Character array swap
     * 3. Build string backwards
     * 4. Recursion
     */
    public static void question21() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Reverse String ===");
        System.out.println("Original: \"" + str + "\"");
        
        // Method 1: StringBuilder
        String rev1 = new StringBuilder(str).reverse().toString();
        System.out.println("StringBuilder: \"" + rev1 + "\"");
        
        // Method 2: Build backwards
        StringBuilder rev2 = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            rev2.append(str.charAt(i));
        }
        System.out.println("Build backwards: \"" + rev2 + "\"");
        
        // Method 3: Character array
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        System.out.println("Char array swap: \"" + new String(chars) + "\"");
    }
    
    // =========================================================================
    // QUESTION 22: Check if palindrome
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Palindrome: reads same forwards and backwards.
     * Compare characters from both ends moving inward.
     * 
     * Examples: "radar", "level", "noon"
     */
    public static void question22() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Palindrome Check ===");
        System.out.println("String: \"" + str + "\"");
        
        String lower = str.toLowerCase();
        boolean isPalindrome = true;
        
        int left = 0, right = lower.length() - 1;
        
        while (left < right) {
            if (lower.charAt(left) != lower.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        
        System.out.println(str + " is " + (isPalindrome ? "" : "NOT ") + "a palindrome");
        
        // Alternative: Compare with reverse
        String reverse = new StringBuilder(lower).reverse().toString();
        System.out.println("Using reverse comparison: " + lower.equals(reverse));
    }
    
    // =========================================================================
    // QUESTION 23: Check palindrome ignoring spaces and punctuation
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Clean the string first - keep only alphanumeric.
     * Then check palindrome.
     * 
     * Example: "A man, a plan, a canal: Panama" → true
     */
    public static void question23() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Palindrome (Alphanumeric Only) ===");
        System.out.println("Original: \"" + str + "\"");
        
        // Clean string - keep only alphanumeric
        StringBuilder clean = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || 
                (ch >= 'A' && ch <= 'Z') || 
                (ch >= '0' && ch <= '9')) {
                clean.append(Character.toLowerCase(ch));
            }
        }
        
        String cleanStr = clean.toString();
        System.out.println("Cleaned: \"" + cleanStr + "\"");
        
        // Check palindrome
        String reverse = clean.reverse().toString();
        boolean isPalindrome = cleanStr.equals(reverse);
        
        System.out.println("Is palindrome: " + isPalindrome);
    }
    
    // =========================================================================
    // QUESTION 24: Reverse words in a sentence
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * "Hello World" → "World Hello"
     * 
     * Method 1: Split, reverse array, join
     * Method 2: Reverse entire string, then reverse each word
     */
    public static void question24() {
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Reverse Words ===");
        System.out.println("Original: \"" + str + "\"");
        
        // Method 1: Split and reverse
        String[] words = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        
        System.out.println("Words reversed: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 25: Reverse each word in a sentence
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * "Hello World" → "olleH dlroW"
     * Keep word positions same, but reverse each word.
     */
    public static void question25() {
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Reverse Each Word ===");
        System.out.println("Original: \"" + str + "\"");
        
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        System.out.println("Each word reversed: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 26: Longest palindromic substring
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Expand around center approach:
     * For each position, expand outward while characters match.
     * Handle both odd and even length palindromes.
     * 
     * Time: O(n²)
     */
    public static void question26() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Longest Palindromic Substring ===");
        System.out.println("String: \"" + str + "\"");
        
        if (str.length() == 0) {
            System.out.println("Empty string");
            return;
        }
        
        int start = 0, maxLen = 1;
        
        for (int i = 0; i < str.length(); i++) {
            // Odd length palindrome (center at i)
            int len1 = expandAroundCenter(str, i, i);
            
            // Even length palindrome (center between i and i+1)
            int len2 = expandAroundCenter(str, i, i + 1);
            
            int len = Math.max(len1, len2);
            
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        
        String longest = str.substring(start, start + maxLen);
        System.out.println("Longest palindrome: \"" + longest + "\"");
        System.out.println("Length: " + maxLen);
    }
    
    static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    // =========================================================================
    // QUESTION 27: Count palindromic substrings
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use expand around center for each position.
     * Count all palindromes found.
     */
    public static void question27() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Count Palindromic Substrings ===");
        System.out.println("String: \"" + str + "\"");
        
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            // Odd length
            count += countPalindromes(str, i, i);
            
            // Even length
            count += countPalindromes(str, i, i + 1);
        }
        
        System.out.println("Palindromic substrings: " + count);
    }
    
    static int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
    
    // =========================================================================
    // QUESTION 28: Check if rotation is palindrome
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Check if any rotation of string is a palindrome.
     */
    public static void question28() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Rotation Palindrome Check ===");
        System.out.println("String: \"" + str + "\"");
        
        int n = str.length();
        String doubled = str + str;
        
        for (int i = 0; i < n; i++) {
            String rotation = doubled.substring(i, i + n);
            String reverse = new StringBuilder(rotation).reverse().toString();
            
            if (rotation.equals(reverse)) {
                System.out.println("Rotation \"" + rotation + "\" is a palindrome");
                System.out.println("Rotation by " + i + " positions");
                return;
            }
        }
        
        System.out.println("No rotation is a palindrome");
    }
    
    // =========================================================================
    // QUESTION 29: Make palindrome by appending minimum characters
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find longest palindromic suffix.
     * Append reverse of remaining prefix.
     */
    public static void question29() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Minimum Append for Palindrome ===");
        System.out.println("String: \"" + str + "\"");
        
        // Find longest palindromic suffix
        int i;
        for (i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            String reverse = new StringBuilder(suffix).reverse().toString();
            if (suffix.equals(reverse)) {
                break;
            }
        }
        
        // Append reverse of prefix
        String prefix = str.substring(0, i);
        String toAppend = new StringBuilder(prefix).reverse().toString();
        String result = str + toAppend;
        
        System.out.println("Characters to append: \"" + toAppend + "\"");
        System.out.println("Minimum characters: " + toAppend.length());
        System.out.println("Result: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 30: Check if two strings are palindrome of each other
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * String A is palindrome of String B if A == reverse(B).
     */
    public static void question30() {
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        
        System.out.println("\n=== Mutual Palindrome Check ===");
        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        
        String reverse1 = new StringBuilder(str1).reverse().toString();
        String reverse2 = new StringBuilder(str2).reverse().toString();
        
        boolean mutualPalindrome = str1.equals(reverse2) || str2.equals(reverse1);
        
        if (str1.equals(reverse2)) {
            System.out.println("String 1 is reverse of String 2");
        }
        if (str2.equals(reverse1)) {
            System.out.println("String 2 is reverse of String 1");
        }
        
        System.out.println("Mutual palindromes: " + mutualPalindrome);
    }
}
