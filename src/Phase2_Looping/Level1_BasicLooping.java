/**
 * ============================================
 * PHASE 2 - LOOPING & PATTERNS
 * Level 1: Basic Looping (Questions 1-10)
 * ============================================
 * 
 * CONCEPT: Loops allow you to execute a block of code repeatedly.
 * 
 * THREE TYPES OF LOOPS:
 * 
 * 1. for loop - Use when you know the number of iterations
 *    for (init; condition; update) { }
 * 
 * 2. while loop - Use when condition is checked before execution
 *    while (condition) { }
 * 
 * 3. do-while loop - Use when you need at least one execution
 *    do { } while (condition);
 * 
 * LOOP CONTROL:
 * - break: Exit the loop immediately
 * - continue: Skip to next iteration
 */

import java.util.Scanner;

public class Level1_BasicLooping {
    
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
    // QUESTION 1: Print 1–10
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use a for loop starting from 1, ending at 10.
     * 
     * Loop anatomy:
     * for (i = 1; i <= 10; i++)
     *      ↑        ↑       ↑
     *    start   condition  increment
     */
    public static void question1() {
        System.out.println("=== Printing 1 to 10 ===");
        
        // Method 1: for loop (most common)
        System.out.print("Using for loop: ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Method 2: while loop
        System.out.print("Using while loop: ");
        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
        
        // Method 3: do-while loop
        System.out.print("Using do-while: ");
        int j = 1;
        do {
            System.out.print(j + " ");
            j++;
        } while (j <= 10);
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 2: Even numbers 1–100
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A number is even if num % 2 == 0
     * 
     * Two approaches:
     * 1. Check each number from 1-100 if it's even
     * 2. Start from 2 and increment by 2 (more efficient!)
     */
    public static void question2() {
        System.out.println("=== Even Numbers from 1 to 100 ===");
        
        // Method 1: Check each number (less efficient)
        System.out.println("Method 1 - Check each:");
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) System.out.println();  // Line break every 10
            }
        }
        
        System.out.println("\nMethod 2 - Start from 2, step by 2:");
        count = 0;
        // Method 2: Start from 2, increment by 2 (more efficient)
        for (int i = 2; i <= 100; i += 2) {
            System.out.print(i + " ");
            count++;
            if (count % 10 == 0) System.out.println();
        }
        
        System.out.println("\nTotal even numbers: 50");
    }
    
    // =========================================================================
    // QUESTION 3: Odd numbers 1–100
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A number is odd if num % 2 != 0 (or num % 2 == 1)
     * 
     * Efficient approach: Start from 1 and increment by 2
     */
    public static void question3() {
        System.out.println("=== Odd Numbers from 1 to 100 ===");
        
        // Efficient method: Start from 1, step by 2
        int count = 0;
        for (int i = 1; i <= 100; i += 2) {
            System.out.print(i + " ");
            count++;
            if (count % 10 == 0) System.out.println();
        }
        
        System.out.println("\nTotal odd numbers: 50");
    }
    
    // =========================================================================
    // QUESTION 4: 10 to 1 (Reverse counting)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Start from 10, decrement by 1 until reaching 1.
     * 
     * Note: i-- is shorthand for i = i - 1
     */
    public static void question4() {
        System.out.println("=== Counting from 10 to 1 ===");
        
        // Method 1: Decrementing loop
        System.out.print("Countdown: ");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println("🚀 LIFTOFF!");
        
        // Fun animation-like output
        System.out.println("\nWith delay effect:");
        for (int i = 10; i >= 1; i--) {
            System.out.println(i + "...");
        }
        System.out.println("🚀 BLAST OFF!");
    }
    
    // =========================================================================
    // QUESTION 5: Multiplication table
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For number n, print n × 1 = n, n × 2 = 2n, ... n × 10 = 10n
     * 
     * Use loop from 1 to 10 and multiply with the given number.
     */
    public static void question5() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Multiplication Table of " + n + " ===");
        
        for (int i = 1; i <= 10; i++) {
            int result = n * i;
            System.out.println(n + " × " + i + " = " + result);
        }
        
        // Extended table up to 20 (optional)
        System.out.println("\n--- Extended (11-20) ---");
        for (int i = 11; i <= 20; i++) {
            System.out.printf("%d × %2d = %d%n", n, i, n * i);
        }
    }
    
    // =========================================================================
    // QUESTION 6: Sum of n natural numbers
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Natural numbers: 1, 2, 3, 4, ...
     * Sum = 1 + 2 + 3 + ... + n
     * 
     * FORMULA: Sum = n × (n + 1) / 2 (Gauss formula)
     * 
     * Both loop and formula approaches shown below.
     */
    public static void question6() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        // Method 1: Using loop
        int sumLoop = 0;
        for (int i = 1; i <= n; i++) {
            sumLoop += i;  // sumLoop = sumLoop + i
        }
        
        // Method 2: Using formula (O(1) time!)
        int sumFormula = n * (n + 1) / 2;
        
        System.out.println("\n=== Sum of first " + n + " natural numbers ===");
        System.out.println("Using loop: " + sumLoop);
        System.out.println("Using formula n(n+1)/2: " + sumFormula);
        
        // Verify both are equal
        System.out.println("Both methods match: " + (sumLoop == sumFormula));
    }
    
    // =========================================================================
    // QUESTION 7: Sum of even numbers 1 to n
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Sum only the even numbers from 1 to n.
     * 
     * FORMULA: If n' = n/2 (number of even terms up to n)
     * Sum = n' × (n' + 1)
     * 
     * Example: Sum of even numbers 1-10 = 2+4+6+8+10 = 30
     */
    public static void question7() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        // Method 1: Loop through all, add if even
        int sum1 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum1 += i;
            }
        }
        
        // Method 2: Loop only even numbers (efficient)
        int sum2 = 0;
        for (int i = 2; i <= n; i += 2) {
            sum2 += i;
        }
        
        // Method 3: Using formula
        int count = n / 2;  // Number of even terms
        int sumFormula = count * (count + 1);
        
        System.out.println("\n=== Sum of even numbers from 1 to " + n + " ===");
        System.out.println("Even numbers: 2, 4, 6, ... up to " + (n / 2 * 2));
        System.out.println("Count of even numbers: " + count);
        System.out.println("Sum (loop): " + sum1);
        System.out.println("Sum (efficient loop): " + sum2);
        System.out.println("Sum (formula): " + sumFormula);
    }
    
    // =========================================================================
    // QUESTION 8: Sum of odd numbers 1 to n
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Sum only the odd numbers from 1 to n.
     * 
     * FORMULA: Sum of first k odd numbers = k²
     * Where k = (n + 1) / 2 (number of odd terms up to n)
     * 
     * Example: 1+3+5+7+9 = 25 = 5²
     */
    public static void question8() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        // Method 1: Loop through all, add if odd
        int sum = 0;
        System.out.print("Odd numbers: ");
        for (int i = 1; i <= n; i += 2) {  // Start from 1, step by 2
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();
        
        // Formula approach
        int count = (n + 1) / 2;  // Number of odd terms
        int sumFormula = count * count;  // k²
        
        System.out.println("\n=== Sum of odd numbers from 1 to " + n + " ===");
        System.out.println("Count of odd numbers: " + count);
        System.out.println("Sum (loop): " + sum);
        System.out.println("Sum (formula k²): " + sumFormula);
    }
    
    // =========================================================================
    // QUESTION 9: Factorial
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * n! = n × (n-1) × (n-2) × ... × 2 × 1
     * 
     * Examples:
     * 5! = 5 × 4 × 3 × 2 × 1 = 120
     * 0! = 1 (by definition)
     * 1! = 1
     * 
     * WARNING: Factorial grows very fast!
     * - 12! fits in int (479,001,600)
     * - 20! fits in long
     * - Larger needs BigInteger
     */
    public static void question9() {
        System.out.print("Enter n (0-20): ");
        int n = sc.nextInt();
        
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers!");
            return;
        }
        
        // Calculate factorial
        long factorial = 1;  // Use long for larger values
        
        System.out.print(n + "! = ");
        if (n == 0) {
            System.out.print("1 (by definition)");
        } else {
            for (int i = n; i >= 1; i--) {
                factorial *= i;
                System.out.print(i);
                if (i > 1) System.out.print(" × ");
            }
        }
        
        System.out.println("\n" + n + "! = " + factorial);
        
        // Show factorial table
        System.out.println("\n--- Factorial Table (0-10) ---");
        long fact = 1;
        System.out.println("0! = 1");
        for (int i = 1; i <= 10; i++) {
            fact *= i;
            System.out.println(i + "! = " + fact);
        }
    }
    
    // =========================================================================
    // QUESTION 10: Product of digits
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Extract each digit and multiply them together.
     * 
     * Digit extraction:
     * - Last digit: num % 10
     * - Remove last digit: num / 10
     * - Repeat until num becomes 0
     * 
     * NOTE: If any digit is 0, the product will be 0!
     */
    public static void question10() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int original = num;
        num = Math.abs(num);  // Work with positive
        
        if (num == 0) {
            System.out.println("Product of digits: 0");
            return;
        }
        
        int product = 1;
        System.out.print("Digits: ");
        
        // We'll collect digits in reverse, then print correctly
        StringBuilder digits = new StringBuilder();
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            digits.insert(0, digit + " ");  // Insert at beginning
            product *= digit;
            temp /= 10;
        }
        
        System.out.println(digits.toString().trim());
        
        // Show the multiplication
        temp = num;
        System.out.print("Product: ");
        StringBuilder multiplication = new StringBuilder();
        while (temp > 0) {
            int digit = temp % 10;
            multiplication.insert(0, digit);
            if (temp / 10 > 0) {
                multiplication.insert(0, " × ");
            }
            temp /= 10;
        }
        System.out.println(multiplication + " = " + product);
        
        // Note about zero
        if (original != num) {
            System.out.println("(Used absolute value for negative number)");
        }
    }
}
