/**
 * ============================================
 * PHASE 3 - RECURSION
 * Level 4: String Recursion (Questions 31-40)
 * ============================================
 * 
 * CONCEPT: String operations using recursion.
 * Key pattern: Process first character, recurse on rest.
 */

import java.util.Scanner;

public class Level4_StringRecursion {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment to practice
        // question31();
        // question32();
        // question33();
        // question34();
        // question35();
        // question36();
        // question37();
        // question38();
        // question39();
        // question40();
    }
    
    // =========================================================================
    // QUESTION 31: Reverse string recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * reverse("hello") = reverse("ello") + "h"
     * reverse("") = "" (base case)
     * 
     * Take first character, append to reversed rest.
     */
    public static void question31() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Reverse String ===");
        System.out.println("Original: \"" + str + "\"");
        String reversed = reverseString(str);
        System.out.println("Reversed: \"" + reversed + "\"");
    }
    
    static String reverseString(String s) {
        // Base case: empty or single character
        if (s.length() <= 1) {
            return s;
        }
        
        // Recursive case: reverse rest + first character
        return reverseString(s.substring(1)) + s.charAt(0);
    }
    
    // =========================================================================
    // QUESTION 32: Palindrome string check recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A string is palindrome if:
     * 1. First char == Last char, AND
     * 2. Middle substring is also palindrome
     * 
     * Base case: Empty string or single char is palindrome.
     */
    public static void question32() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Palindrome Check ===");
        System.out.println("String: \"" + str + "\"");
        
        boolean isPalin = isPalindrome(str.toLowerCase());
        System.out.println("Is Palindrome: " + (isPalin ? "Yes ✓" : "No ✗"));
    }
    
    static boolean isPalindrome(String s) {
        // Base case: empty or single char
        if (s.length() <= 1) {
            return true;
        }
        
        // Check first and last characters
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        
        // Check middle substring
        return isPalindrome(s.substring(1, s.length() - 1));
    }
    
    // =========================================================================
    // QUESTION 33: Count vowels recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * countVowels(s) = isVowel(first)? 1 : 0 + countVowels(rest)
     */
    public static void question33() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Count Vowels ===");
        System.out.println("String: \"" + str + "\"");
        int count = countVowels(str.toLowerCase());
        System.out.println("Vowel count: " + count);
    }
    
    static int countVowels(String s) {
        // Base case
        if (s.isEmpty()) {
            return 0;
        }
        
        // Check if first character is vowel
        int current = isVowel(s.charAt(0)) ? 1 : 0;
        
        // Add count from rest of string
        return current + countVowels(s.substring(1));
    }
    
    static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    
    // =========================================================================
    // QUESTION 34: Remove spaces recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * If first char is space, skip it.
     * Otherwise, include it and recurse.
     */
    public static void question34() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Remove Spaces ===");
        System.out.println("Original: \"" + str + "\"");
        String result = removeSpaces(str);
        System.out.println("Without spaces: \"" + result + "\"");
    }
    
    static String removeSpaces(String s) {
        // Base case
        if (s.isEmpty()) {
            return "";
        }
        
        char first = s.charAt(0);
        String rest = removeSpaces(s.substring(1));
        
        // Skip if space
        if (first == ' ') {
            return rest;
        }
        
        return first + rest;
    }
    
    // =========================================================================
    // QUESTION 35: Replace character recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Replace all occurrences of oldChar with newChar.
     */
    public static void question35() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Character to replace: ");
        char oldChar = sc.nextLine().charAt(0);
        System.out.print("Replace with: ");
        char newChar = sc.nextLine().charAt(0);
        
        System.out.println("\n=== Replace Character ===");
        System.out.println("Original: \"" + str + "\"");
        String result = replaceChar(str, oldChar, newChar);
        System.out.println("After replacement: \"" + result + "\"");
    }
    
    static String replaceChar(String s, char oldChar, char newChar) {
        // Base case
        if (s.isEmpty()) {
            return "";
        }
        
        char first = s.charAt(0);
        String rest = replaceChar(s.substring(1), oldChar, newChar);
        
        // Replace if matches
        if (first == oldChar) {
            return newChar + rest;
        }
        
        return first + rest;
    }
    
    // =========================================================================
    // QUESTION 36: Remove character recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Remove all occurrences of a character from string.
     */
    public static void question36() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Character to remove: ");
        char toRemove = sc.nextLine().charAt(0);
        
        System.out.println("\n=== Remove Character ===");
        System.out.println("Original: \"" + str + "\"");
        String result = removeChar(str, toRemove);
        System.out.println("After removal: \"" + result + "\"");
    }
    
    static String removeChar(String s, char c) {
        // Base case
        if (s.isEmpty()) {
            return "";
        }
        
        char first = s.charAt(0);
        String rest = removeChar(s.substring(1), c);
        
        // Skip if matches
        if (first == c) {
            return rest;
        }
        
        return first + rest;
    }
    
    // =========================================================================
    // QUESTION 37: Print characters recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print each character on a new line.
     */
    public static void question37() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Print Characters ===");
        printChars(str);
    }
    
    static void printChars(String s) {
        // Base case
        if (s.isEmpty()) {
            return;
        }
        
        // Print first character
        System.out.println("'" + s.charAt(0) + "'");
        
        // Print rest
        printChars(s.substring(1));
    }
    
    // =========================================================================
    // QUESTION 38: Print characters in reverse recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Recurse first, then print. This prints in reverse!
     */
    public static void question38() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Print Characters in Reverse ===");
        printCharsReverse(str);
    }
    
    static void printCharsReverse(String s) {
        // Base case
        if (s.isEmpty()) {
            return;
        }
        
        // Print rest first (recurse)
        printCharsReverse(s.substring(1));
        
        // Then print first character
        System.out.println("'" + s.charAt(0) + "'");
    }
    
    // =========================================================================
    // QUESTION 39: Convert to uppercase recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Convert each character to uppercase.
     */
    public static void question39() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Convert to Uppercase ===");
        System.out.println("Original: \"" + str + "\"");
        String result = toUpperCase(str);
        System.out.println("Uppercase: \"" + result + "\"");
    }
    
    static String toUpperCase(String s) {
        // Base case
        if (s.isEmpty()) {
            return "";
        }
        
        // Convert first character
        char first = s.charAt(0);
        char upper = Character.toUpperCase(first);
        
        // Combine with rest
        return upper + toUpperCase(s.substring(1));
    }
    
    // =========================================================================
    // QUESTION 40: Count vowels and consonants recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Count both vowels and consonants in single pass.
     * Return as an array [vowels, consonants].
     */
    public static void question40() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Count Vowels and Consonants ===");
        System.out.println("String: \"" + str + "\"");
        
        int[] counts = countVowelsConsonants(str.toLowerCase());
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }
    
    static int[] countVowelsConsonants(String s) {
        // Base case
        if (s.isEmpty()) {
            return new int[]{0, 0};
        }
        
        // Get counts from rest
        int[] rest = countVowelsConsonants(s.substring(1));
        
        // Check first character
        char first = s.charAt(0);
        if (Character.isLetter(first)) {
            if (isVowel(first)) {
                rest[0]++;  // Increment vowels
            } else {
                rest[1]++;  // Increment consonants
            }
        }
        
        return rest;
    }
}
