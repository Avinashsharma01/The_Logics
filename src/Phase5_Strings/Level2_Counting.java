/**
 * ============================================
 * PHASE 5 - STRINGS
 * Level 2: Counting (Questions 11-20)
 * ============================================
 * 
 * CONCEPT: Counting characters and patterns in strings.
 * 
 * KEY TECHNIQUES:
 * - Character classification (vowel, consonant, digit, etc.)
 * - Frequency arrays
 * - Pattern matching
 */

import java.util.Scanner;

public class Level2_Counting {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment to practice
        // question11();
        // question12();
        // question13();
        // question14();
        // question15();
        // question16();
        // question17();
        // question18();
        // question19();
        // question20();
    }
    
    // =========================================================================
    // QUESTION 11: Count vowels and consonants
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Vowels: a, e, i, o, u (and uppercase)
     * Consonants: All other alphabets
     * 
     * Check each character and classify.
     */
    public static void question11() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();
        
        System.out.println("\n=== Count Vowels and Consonants ===");
        
        int vowels = 0, consonants = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    // =========================================================================
    // QUESTION 12: Count digits in string
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Digit: '0' to '9' (ASCII 48 to 57)
     * Or use Character.isDigit()
     */
    public static void question12() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Count Digits ===");
        System.out.println("String: \"" + str + "\"");
        
        int digits = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                digits++;
            }
        }
        
        System.out.println("Digits count: " + digits);
        
        // Alternative: Character.isDigit()
        int count2 = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                count2++;
            }
        }
        System.out.println("Using Character.isDigit(): " + count2);
    }
    
    // =========================================================================
    // QUESTION 13: Count uppercase and lowercase
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Uppercase: 'A' to 'Z'
     * Lowercase: 'a' to 'z'
     */
    public static void question13() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Count Uppercase and Lowercase ===");
        System.out.println("String: \"" + str + "\"");
        
        int upper = 0, lower = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') {
                upper++;
            } else if (ch >= 'a' && ch <= 'z') {
                lower++;
            }
        }
        
        System.out.println("Uppercase: " + upper);
        System.out.println("Lowercase: " + lower);
    }
    
    // =========================================================================
    // QUESTION 14: Count spaces
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Count occurrences of space character ' '.
     */
    public static void question14() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Count Spaces ===");
        System.out.println("String: \"" + str + "\"");
        
        int spaces = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaces++;
            }
        }
        
        System.out.println("Spaces: " + spaces);
    }
    
    // =========================================================================
    // QUESTION 15: Count words
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Words are separated by spaces.
     * Method 1: Split by space and count
     * Method 2: Count transitions from space to non-space
     */
    public static void question15() {
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine().trim();
        
        System.out.println("\n=== Count Words ===");
        System.out.println("String: \"" + str + "\"");
        
        if (str.isEmpty()) {
            System.out.println("Words: 0");
            return;
        }
        
        // Method 1: Split
        String[] words = str.split("\\s+");  // Split by one or more spaces
        System.out.println("Using split(): " + words.length);
        
        // Method 2: Count spaces + 1
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i > 0 && str.charAt(i-1) != ' ') {
                count++;
            }
        }
        System.out.println("Manual count: " + count);
    }
    
    // =========================================================================
    // QUESTION 16: Count occurrence of specific character
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Traverse and count matches with target character.
     */
    public static void question16() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter character to count: ");
        char target = sc.next().charAt(0);
        
        System.out.println("\n=== Count Character Occurrence ===");
        System.out.println("String: \"" + str + "\"");
        System.out.println("Target: '" + target + "'");
        
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        
        System.out.println("Count: " + count);
    }
    
    // =========================================================================
    // QUESTION 17: Frequency of each character
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use frequency array of size 256 (ASCII) or 26 (only alphabets).
     * Increment count for each character.
     */
    public static void question17() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();
        
        System.out.println("\n=== Character Frequency ===");
        System.out.println("String: \"" + str + "\"");
        
        // Frequency array for 26 lowercase letters
        int[] freq = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a']++;
            }
        }
        
        System.out.println("\nCharacter frequencies:");
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                System.out.println((char)('a' + i) + ": " + freq[i]);
            }
        }
    }
    
    // =========================================================================
    // QUESTION 18: Find most frequent character
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Build frequency array, then find maximum.
     */
    public static void question18() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();
        
        System.out.println("\n=== Most Frequent Character ===");
        System.out.println("String: \"" + str + "\"");
        
        int[] freq = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a']++;
            }
        }
        
        int maxFreq = 0;
        char maxChar = ' ';
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxChar = (char)('a' + i);
            }
        }
        
        if (maxFreq > 0) {
            System.out.println("Most frequent: '" + maxChar + "' (" + maxFreq + " times)");
        } else {
            System.out.println("No alphabetic characters found");
        }
    }
    
    // =========================================================================
    // QUESTION 19: Find first non-repeating character
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * 1. Build frequency array
     * 2. Traverse string again, find first char with freq=1
     */
    public static void question19() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();
        
        System.out.println("\n=== First Non-Repeating Character ===");
        System.out.println("String: \"" + str + "\"");
        
        int[] freq = new int[256];  // All ASCII
        
        // Build frequency
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        
        // Find first non-repeating
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                System.out.println("First non-repeating: '" + str.charAt(i) + "' at index " + i);
                return;
            }
        }
        
        System.out.println("No non-repeating character found");
    }
    
    // =========================================================================
    // QUESTION 20: Find duplicate characters
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Characters with frequency > 1.
     */
    public static void question20() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();
        
        System.out.println("\n=== Duplicate Characters ===");
        System.out.println("String: \"" + str + "\"");
        
        int[] freq = new int[256];
        
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        
        System.out.print("Duplicates: ");
        boolean found = false;
        
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 1) {
                System.out.print("'" + (char)i + "'(" + freq[i] + ") ");
                found = true;
            }
        }
        
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }
}
