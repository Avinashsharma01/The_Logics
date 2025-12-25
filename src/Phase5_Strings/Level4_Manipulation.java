/**
 * ============================================
 * PHASE 5 - STRINGS
 * Level 4: Manipulation (Questions 31-40)
 * ============================================
 * 
 * CONCEPT: String transformations and modifications.
 * 
 * KEY TECHNIQUES:
 * - Character replacement
 * - String building
 * - Pattern-based manipulation
 */

import java.util.Scanner;

public class Level4_Manipulation {
    
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
    // QUESTION 31: Remove all spaces
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Skip space characters while building new string.
     */
    public static void question31() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Remove Spaces ===");
        System.out.println("Original: \"" + str + "\"");
        
        // Method 1: Built-in
        String result1 = str.replace(" ", "");
        System.out.println("Using replace(): \"" + result1 + "\"");
        
        // Method 2: Manual
        StringBuilder result2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                result2.append(str.charAt(i));
            }
        }
        System.out.println("Manual: \"" + result2 + "\"");
    }
    
    // =========================================================================
    // QUESTION 32: Remove all vowels
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Skip vowel characters (a, e, i, o, u).
     */
    public static void question32() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Remove Vowels ===");
        System.out.println("Original: \"" + str + "\"");
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                result.append(str.charAt(i));
            }
        }
        
        System.out.println("Without vowels: \"" + result + "\"");
        
        // Using regex
        String regex = str.replaceAll("[aeiouAEIOU]", "");
        System.out.println("Using regex: \"" + regex + "\"");
    }
    
    // =========================================================================
    // QUESTION 33: Remove duplicate characters
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Keep track of characters seen using boolean array.
     * Only add character if not seen before.
     */
    public static void question33() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Remove Duplicates ===");
        System.out.println("Original: \"" + str + "\"");
        
        boolean[] seen = new boolean[256];  // ASCII
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }
        
        System.out.println("Without duplicates: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 34: Replace character
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Replace all occurrences of one character with another.
     */
    public static void question34() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter character to replace: ");
        char oldChar = sc.next().charAt(0);
        System.out.print("Enter new character: ");
        char newChar = sc.next().charAt(0);
        
        System.out.println("\n=== Replace Character ===");
        System.out.println("Original: \"" + str + "\"");
        
        // Method 1: Built-in
        String result1 = str.replace(oldChar, newChar);
        System.out.println("Using replace(): \"" + result1 + "\"");
        
        // Method 2: Manual
        StringBuilder result2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == oldChar) {
                result2.append(newChar);
            } else {
                result2.append(str.charAt(i));
            }
        }
        System.out.println("Manual: \"" + result2 + "\"");
    }
    
    // =========================================================================
    // QUESTION 35: Remove specific character
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Skip the target character while building result.
     */
    public static void question35() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter character to remove: ");
        char target = sc.next().charAt(0);
        
        System.out.println("\n=== Remove Character ===");
        System.out.println("Original: \"" + str + "\"");
        System.out.println("Removing: '" + target + "'");
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != target) {
                result.append(str.charAt(i));
            }
        }
        
        System.out.println("Result: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 36: Remove consecutive duplicates
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * "aabbcc" → "abc"
     * Add character only if different from previous.
     */
    public static void question36() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Remove Consecutive Duplicates ===");
        System.out.println("Original: \"" + str + "\"");
        
        if (str.length() == 0) {
            System.out.println("Result: \"\"");
            return;
        }
        
        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));  // Always add first
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                result.append(str.charAt(i));
            }
        }
        
        System.out.println("Result: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 37: Compress string (Run-length encoding)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * "aaabbc" → "a3b2c1"
     * Count consecutive characters.
     */
    public static void question37() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== String Compression ===");
        System.out.println("Original: \"" + str + "\"");
        
        if (str.length() == 0) {
            System.out.println("Compressed: \"\"");
            return;
        }
        
        StringBuilder result = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i <= str.length(); i++) {
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1));
                result.append(count);
                count = 1;
            }
        }
        
        System.out.println("Compressed: \"" + result + "\"");
        
        // Only use if shorter
        if (result.length() < str.length()) {
            System.out.println("Compression saved " + (str.length() - result.length()) + " characters");
        } else {
            System.out.println("Original is shorter or equal, compression not beneficial");
        }
    }
    
    // =========================================================================
    // QUESTION 38: Expand compressed string
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * "a3b2c1" → "aaabbc"
     * Parse character and count, repeat character.
     */
    public static void question38() {
        System.out.print("Enter compressed string (e.g., a3b2c1): ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Expand Compressed String ===");
        System.out.println("Compressed: \"" + str + "\"");
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < str.length()) {
            char ch = str.charAt(i);
            i++;
            
            // Read the number
            StringBuilder numStr = new StringBuilder();
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                numStr.append(str.charAt(i));
                i++;
            }
            
            int count = numStr.length() > 0 ? Integer.parseInt(numStr.toString()) : 1;
            
            // Repeat character
            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
        }
        
        System.out.println("Expanded: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 39: Capitalize first letter of each word
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * "hello world" → "Hello World"
     * Capitalize character after space.
     */
    public static void question39() {
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Capitalize First Letters ===");
        System.out.println("Original: \"" + str + "\"");
        
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
        
        System.out.println("Capitalized: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 40: Sentence case (first letter of sentence uppercase)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * "hello. world!" → "Hello. World!"
     * Capitalize after sentence terminators (. ! ?)
     */
    public static void question40() {
        System.out.print("Enter text: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Sentence Case ===");
        System.out.println("Original: \"" + str + "\"");
        
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '.' || ch == '!' || ch == '?') {
                result.append(ch);
                capitalizeNext = true;
            } else if (ch == ' ') {
                result.append(ch);
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
        
        System.out.println("Sentence case: \"" + result + "\"");
    }
}
