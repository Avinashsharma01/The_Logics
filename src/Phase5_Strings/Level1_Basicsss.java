/**
 * ============================================
 * PHASE 5 - STRINGS
 * Level 1: Basics (Questions 1-10)
 * ============================================
 * 
 * CONCEPT: String fundamentals in Java.
 * 
 * KEY FACTS:
 * - Strings are immutable in Java
 * - String vs StringBuilder vs StringBuffer
 * - Character access: charAt(index)
 * - Length: length() (method, not property)
 * 
 * COMMON OPERATIONS:
 * - Traversal: for loop with charAt()
 * - Comparison: equals(), compareTo()
 * - Conversion: toUpperCase(), toLowerCase()
 */

import java.util.Scanner;

public class Level1_Basicsss {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment to practice
        // question1();
        // question2();
        // question3();
        // question4();
        // question5();
        // question6();
        // question7();
        // question8();
        // question9();
        // question10();
    }
    
    // =========================================================================
    // QUESTION 1: Input and print string
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Two ways to read strings:
     * 1. next() - reads until whitespace
     * 2. nextLine() - reads entire line
     */
    public static void question1() {
        System.out.println("=== Input and Print String ===\n");
        
        // Method 1: Single word
        System.out.print("Enter a single word: ");
        String word = sc.next();
        System.out.println("Word: " + word);
        
        sc.nextLine();  // Consume newline
        
        // Method 2: Full line
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.println("Sentence: " + sentence);
    }
    
    // =========================================================================
    // QUESTION 2: Find length of string
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use length() method.
     * Remember: String uses length() method, Array uses length property.
     */
    public static void question2() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== String Length ===");
        System.out.println("String: \"" + str + "\"");
        System.out.println("Length: " + str.length());
    }
    
    // =========================================================================
    // QUESTION 3: Print each character on new line
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use charAt(i) to access character at index i.
     * Index is 0-based.
     */
    public static void question3() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Characters ===");
        System.out.println("String: \"" + str + "\"");
        System.out.println("Characters:");
        
        for (int i = 0; i < str.length(); i++) {
            System.out.println("Index " + i + ": '" + str.charAt(i) + "'");
        }
    }
    
    // =========================================================================
    // QUESTION 4: Convert to uppercase
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Method 1: toUpperCase() - built-in method
     * Method 2: Manual conversion using ASCII
     *           'a' to 'z' = 97 to 122
     *           'A' to 'Z' = 65 to 90
     *           Difference = 32
     */
    public static void question4() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Convert to Uppercase ===");
        System.out.println("Original: \"" + str + "\"");
        
        // Method 1: Built-in
        System.out.println("Using toUpperCase(): \"" + str.toUpperCase() + "\"");
        
        // Method 2: Manual
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));  // Convert to uppercase
            } else {
                result.append(ch);
            }
        }
        System.out.println("Manual method: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 5: Convert to lowercase
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Similar to uppercase but add 32 instead of subtracting.
     */
    public static void question5() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Convert to Lowercase ===");
        System.out.println("Original: \"" + str + "\"");
        
        // Method 1: Built-in
        System.out.println("Using toLowerCase(): \"" + str.toLowerCase() + "\"");
        
        // Method 2: Manual
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));  // Convert to lowercase
            } else {
                result.append(ch);
            }
        }
        System.out.println("Manual method: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 6: Toggle case
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Convert uppercase to lowercase and vice versa.
     */
    public static void question6() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("\n=== Toggle Case ===");
        System.out.println("Original: \"" + str + "\"");
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));  // To uppercase
            } else if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));  // To lowercase
            } else {
                result.append(ch);
            }
        }
        
        System.out.println("Toggled: \"" + result + "\"");
    }
    
    // =========================================================================
    // QUESTION 7: Check if strings are equal
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * NEVER use == to compare strings! Use equals() or equalsIgnoreCase().
     * 
     * == compares references (memory addresses)
     * equals() compares content
     */
    public static void question7() {
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        
        System.out.println("\n=== String Comparison ===");
        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        
        // Case-sensitive comparison
        boolean equal = str1.equals(str2);
        System.out.println("equals(): " + equal);
        
        // Case-insensitive comparison
        boolean equalIgnoreCase = str1.equalsIgnoreCase(str2);
        System.out.println("equalsIgnoreCase(): " + equalIgnoreCase);
        
        // compareTo returns 0 if equal, <0 if str1 < str2, >0 if str1 > str2
        int comparison = str1.compareTo(str2);
        System.out.println("compareTo(): " + comparison);
    }
    
    // =========================================================================
    // QUESTION 8: Concatenate strings
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Multiple ways to concatenate:
     * 1. + operator
     * 2. concat() method
     * 3. StringBuilder append()
     */
    public static void question8() {
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        
        System.out.println("\n=== String Concatenation ===");
        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        
        // Method 1: + operator
        String result1 = str1 + str2;
        System.out.println("Using +: \"" + result1 + "\"");
        
        // Method 2: concat()
        String result2 = str1.concat(str2);
        System.out.println("Using concat(): \"" + result2 + "\"");
        
        // Method 3: StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(str1).append(str2);
        System.out.println("Using StringBuilder: \"" + sb + "\"");
    }
    
    // =========================================================================
    // QUESTION 9: Extract substring
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * substring(start) - from start to end
     * substring(start, end) - from start to end-1 (end is exclusive)
     */
    public static void question9() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        
        System.out.println("\n=== Substring ===");
        System.out.println("Original: \"" + str + "\"");
        
        if (start >= 0 && end <= str.length() && start <= end) {
            String sub = str.substring(start, end);
            System.out.println("Substring(" + start + ", " + end + "): \"" + sub + "\"");
            
            // Manual extraction
            StringBuilder manual = new StringBuilder();
            for (int i = start; i < end; i++) {
                manual.append(str.charAt(i));
            }
            System.out.println("Manual: \"" + manual + "\"");
        } else {
            System.out.println("Invalid indices!");
        }
    }
    
    // =========================================================================
    // QUESTION 10: Check if string contains substring
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * contains() - returns boolean
     * indexOf() - returns first index of substring, -1 if not found
     */
    public static void question10() {
        System.out.print("Enter main string: ");
        String main = sc.nextLine();
        System.out.print("Enter substring to find: ");
        String sub = sc.nextLine();
        
        System.out.println("\n=== Check Contains ===");
        System.out.println("Main string: \"" + main + "\"");
        System.out.println("Substring: \"" + sub + "\"");
        
        // Method 1: contains
        boolean contains = main.contains(sub);
        System.out.println("contains(): " + contains);
        
        // Method 2: indexOf
        int index = main.indexOf(sub);
        System.out.println("indexOf(): " + index);
        
        if (index != -1) {
            System.out.println("Found at index " + index);
        }
    }
}
