/**
 * ============================================
 * PHASE 1 - CONDITIONAL THINKING
 * Level 1: Simple Conditions (Questions 1-10)
 * ============================================

 * CONCEPT: If-Else statements are the foundation of programming logic.
 * They allow your program to make decisions based on conditions.

 * SYNTAX:
 * if (condition) {
 *     // executes when condition is true
 * } else {
 *     // executes when condition is false
 * }
 */
package Phase1_Conditionals;

import java.util.Scanner;


public class Level1_SimpleConditions {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment the question you want to practice
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
    // QUESTION 1: Check if a number is positive, negative, or zero
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - If number > 0, it's positive
     * - If number < 0, it's negative
     * - If number == 0, it's zero
     * 
     * KEY CONCEPT: Comparison operators (>, <, ==)
     */
    public static void question1() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num > 0) {
            System.out.println(num + " is POSITIVE");
        } else if (num < 0) {
            System.out.println(num + " is NEGATIVE");
        } else {
            System.out.println("The number is ZERO");
        }
    }
    
    // =========================================================================
    // QUESTION 2: Check if a number is even or odd
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Even numbers are divisible by 2 (remainder = 0)
     * - Odd numbers have remainder 1 when divided by 2
     * 
     * KEY CONCEPT: Modulo operator (%) gives remainder
     * Example: 4 % 2 = 0 (even), 5 % 2 = 1 (odd)
     */
    public static void question2() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num % 2 == 0) {
            System.out.println(num + " is EVEN");
        } else {
            System.out.println(num + " is ODD");
        }
    }
    
    // =========================================================================
    // QUESTION 3: Check if a number is divisible by 5
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - A number is divisible by 5 if num % 5 == 0
     * 
     * Examples: 10 % 5 = 0 ✓, 15 % 5 = 0 ✓, 7 % 5 = 2 ✗
     */
    public static void question3() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num % 5 == 0) {
            System.out.println(num + " is divisible by 5");
        } else {
            System.out.println(num + " is NOT divisible by 5");
        }
    }
    
    // =========================================================================
    // QUESTION 4: Check if divisible by both 3 and 5
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Must satisfy BOTH conditions: num % 3 == 0 AND num % 5 == 0
     * - Use logical AND operator (&&)
     * 
     * KEY CONCEPT: Logical operators
     * - && (AND): Both conditions must be true
     * - || (OR): At least one condition must be true
     * 
     * Examples: 15 (yes), 30 (yes), 10 (no - only by 5), 9 (no - only by 3)
     */
    public static void question4() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println(num + " is divisible by BOTH 3 and 5");
        } else if (num % 3 == 0) {
            System.out.println(num + " is divisible by 3 only");
        } else if (num % 5 == 0) {
            System.out.println(num + " is divisible by 5 only");
        } else {
            System.out.println(num + " is NOT divisible by 3 or 5");
        }
    }
    
    // =========================================================================
    // QUESTION 5: Check if a year is a leap year
    // =========================================================================
    /*
     * LOGIC EXPLANATION (IMPORTANT - Common Interview Question!):
     * A year is a leap year if:
     * 1. Divisible by 4 AND
     * 2. Either NOT divisible by 100 OR divisible by 400
     * 
     * FORMULA: (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
     * 
     * Examples:
     * - 2024: 2024 % 4 = 0, 2024 % 100 = 24 (≠0) → LEAP YEAR
     * - 1900: 1900 % 4 = 0, 1900 % 100 = 0, 1900 % 400 = 300 → NOT LEAP
     * - 2000: 2000 % 400 = 0 → LEAP YEAR
     */
    public static void question5() {
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        if (isLeap) {
            System.out.println(year + " is a LEAP YEAR");
        } else {
            System.out.println(year + " is NOT a leap year");
        }
    }
    
    // =========================================================================
    // QUESTION 6: Print larger of two numbers
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Compare two numbers using > operator
     * - Handle the case when both are equal
     * 
     * ALTERNATIVE: Use Math.max(a, b) - built-in function
     */
    public static void question6() {
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        // Method 1: Using if-else
        if (a > b) {
            System.out.println(a + " is larger");
        } else if (b > a) {
            System.out.println(b + " is larger");
        } else {
            System.out.println("Both numbers are equal");
        }
        
        // Method 2: Using ternary operator (one-liner)
        // int larger = (a > b) ? a : b;
        
        // Method 3: Using Math.max()
        // int larger = Math.max(a, b);
    }
    
    // =========================================================================
    // QUESTION 7: Print largest of three numbers
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Compare first with second and third
     * - If first is not largest, compare second with third
     * 
     * APPROACH 1: Nested if-else
     * APPROACH 2: Store max in variable and update
     * APPROACH 3: Math.max(Math.max(a, b), c)
     */
    public static void question7() {
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        // Method 1: Using if-else
        if (a >= b && a >= c) {
            System.out.println(a + " is the largest");
        } else if (b >= a && b >= c) {
            System.out.println(b + " is the largest");
        } else {
            System.out.println(c + " is the largest");
        }
        
        // Method 2: Using variable
        /*
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        System.out.println(max + " is the largest");
        */
        
        // Method 3: Using Math.max
        // int max = Math.max(Math.max(a, b), c);
    }
    
    // =========================================================================
    // QUESTION 8: Classify temperature as Cold/Warm/Hot
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Define temperature ranges
     * - Use if-else-if ladder to check ranges
     * 
     * Common ranges (in Celsius):
     * - Cold: < 15°C
     * - Warm: 15°C to 30°C
     * - Hot: > 30°C
     */
    public static void question8() {
        System.out.print("Enter temperature (in Celsius): ");
        double temp = sc.nextDouble();
        
        if (temp < 15) {
            System.out.println("It's COLD! 🥶");
        } else if (temp <= 30) {
            System.out.println("It's WARM! 😊");
        } else {
            System.out.println("It's HOT! 🥵");
        }
    }
    
    // =========================================================================
    // QUESTION 9: Check if a character is vowel or consonant
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Vowels: a, e, i, o, u (both lowercase and uppercase)
     * - Everything else (if letter) is consonant
     * 
     * KEY CONCEPT: Character comparison
     * - Characters can be compared using == or using String methods
     * - Consider both uppercase and lowercase
     */
    public static void question9() {
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);
        
        // Convert to lowercase for easier comparison
        char lowerCh = Character.toLowerCase(ch);
        
        // Check if it's a letter first
        if (!Character.isLetter(ch)) {
            System.out.println(ch + " is not a letter");
            return;
        }
        
        // Method 1: Using if with OR conditions
        if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || 
            lowerCh == 'o' || lowerCh == 'u') {
            System.out.println(ch + " is a VOWEL");
        } else {
            System.out.println(ch + " is a CONSONANT");
        }
        
        // Method 2: Using String.indexOf
        /*
        String vowels = "aeiouAEIOU";
        if (vowels.indexOf(ch) != -1) {
            System.out.println(ch + " is a VOWEL");
        } else {
            System.out.println(ch + " is a CONSONANT");
        }
        */
    }
    
    // =========================================================================
    // QUESTION 10: Check if a character is uppercase, lowercase, digit, or special
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use ASCII values or Character class methods:
     * - Uppercase: 'A' to 'Z' (ASCII 65-90)
     * - Lowercase: 'a' to 'z' (ASCII 97-122)
     * - Digit: '0' to '9' (ASCII 48-57)
     * - Special: Everything else
     * 
     * KEY CONCEPT: Character class methods
     * - Character.isUpperCase(ch)
     * - Character.isLowerCase(ch)
     * - Character.isDigit(ch)
     */
    public static void question10() {
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);
        
        // Method 1: Using Character class methods (Recommended)
        if (Character.isUpperCase(ch)) {
            System.out.println(ch + " is an UPPERCASE letter");
        } else if (Character.isLowerCase(ch)) {
            System.out.println(ch + " is a LOWERCASE letter");
        } else if (Character.isDigit(ch)) {
            System.out.println(ch + " is a DIGIT");
        } else {
            System.out.println(ch + " is a SPECIAL character");
        }
        
        // Method 2: Using ASCII ranges
        /*
        if (ch >= 'A' && ch <= 'Z') {
            System.out.println("UPPERCASE");
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println("LOWERCASE");
        } else if (ch >= '0' && ch <= '9') {
            System.out.println("DIGIT");
        } else {
            System.out.println("SPECIAL");
        }
        */
    }
}
