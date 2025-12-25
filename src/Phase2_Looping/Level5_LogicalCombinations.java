/**
 * ============================================
 * PHASE 2 - LOOPING & PATTERNS
 * Level 5: Logical Loop Combinations (Questions 31-40)
 * ============================================
 * 
 * CONCEPT: Complex conditions combined with loops.
 * These problems require creative problem-solving.
 */

import java.util.Scanner;

public class Level5_LogicalCombinations {
    
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
    // QUESTION 31: Numbers with even digit sum
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find numbers in a range where the sum of digits is even.
     * 
     * Example: 12 → 1+2=3 (odd), 13 → 1+3=4 (even) ✓
     */
    public static void question31() {
        System.out.print("Enter range (start end): ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        System.out.println("\n=== Numbers with Even Digit Sum (" + start + " to " + end + ") ===\n");
        
        int count = 0;
        for (int num = start; num <= end; num++) {
            int digitSum = 0;
            int temp = Math.abs(num);
            
            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
            
            if (digitSum % 2 == 0) {
                System.out.print(num + "(sum=" + digitSum + ") ");
                count++;
                if (count % 5 == 0) System.out.println();
            }
        }
        
        System.out.println("\n\nTotal count: " + count);
    }
    
    // =========================================================================
    // QUESTION 32: Count divisible by 7 not 5
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find numbers divisible by 7 BUT NOT by 5.
     * Condition: num % 7 == 0 AND num % 5 != 0
     */
    public static void question32() {
        System.out.print("Enter range (start end): ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        System.out.println("\n=== Divisible by 7 but NOT by 5 ===\n");
        
        int count = 0;
        int sum = 0;
        
        for (int i = start; i <= end; i++) {
            if (i % 7 == 0 && i % 5 != 0) {
                System.out.print(i + " ");
                count++;
                sum += i;
                if (count % 10 == 0) System.out.println();
            }
        }
        
        System.out.println("\n\nCount: " + count);
        System.out.println("Sum: " + sum);
        
        // Also show numbers divisible by both 7 and 5 (i.e., 35)
        System.out.println("\n--- Divisible by BOTH 7 and 5 (excluded above) ---");
        for (int i = start; i <= end; i++) {
            if (i % 35 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 33: Palindromes 1–500
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find all palindrome numbers between 1 and 500.
     * Single digit numbers (1-9) are palindromes.
     * Two-digit palindromes: 11, 22, 33, 44, 55, 66, 77, 88, 99
     * Three-digit: 101, 111, 121, 131, ...
     */
    public static void question33() {
        System.out.println("=== Palindrome Numbers from 1 to 500 ===\n");
        
        int count = 0;
        
        for (int num = 1; num <= 500; num++) {
            int original = num;
            int reversed = 0;
            int temp = num;
            
            while (temp > 0) {
                reversed = reversed * 10 + temp % 10;
                temp /= 10;
            }
            
            if (original == reversed) {
                System.out.printf("%3d ", num);
                count++;
                if (count % 10 == 0) System.out.println();
            }
        }
        
        System.out.println("\n\nTotal palindromes: " + count);
        
        // Breakdown
        System.out.println("\nBreakdown:");
        System.out.println("  1-digit (1-9): 9 palindromes");
        System.out.println("  2-digit (11-99): 9 palindromes");
        System.out.println("  3-digit (101-500): " + (count - 18) + " palindromes");
    }
    
    // =========================================================================
    // QUESTION 34: Digit sum multiple of 3
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A number's digit sum is a multiple of 3 if and only if
     * the number itself is divisible by 3!
     * 
     * This is a famous divisibility rule.
     */
    public static void question34() {
        System.out.print("Enter range (start end): ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        System.out.println("\n=== Numbers with Digit Sum Multiple of 3 ===");
        System.out.println("(These are exactly the numbers divisible by 3!)\n");
        
        int count = 0;
        
        for (int num = start; num <= end; num++) {
            int digitSum = 0;
            int temp = Math.abs(num);
            
            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
            
            if (digitSum % 3 == 0) {
                System.out.print(num + " ");
                count++;
                if (count % 15 == 0) System.out.println();
            }
        }
        
        System.out.println("\n\nTotal: " + count);
        
        // Verify with divisibility by 3
        int div3Count = 0;
        for (int i = start; i <= end; i++) {
            if (i % 3 == 0) div3Count++;
        }
        System.out.println("Numbers divisible by 3: " + div3Count);
        System.out.println("Both counts match: " + (count == div3Count));
    }
    
    // =========================================================================
    // QUESTION 35: Smallest & largest digit
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Extract all digits and track the minimum and maximum.
     * 
     * Initialize: min = 9, max = 0
     * For each digit: update min and max accordingly
     */
    public static void question35() {
        System.out.print("Enter a number: ");
        long num = sc.nextLong();
        
        num = Math.abs(num);
        
        if (num == 0) {
            System.out.println("Both smallest and largest digit: 0");
            return;
        }
        
        int smallest = 9;
        int largest = 0;
        long original = num;
        
        System.out.print("Digits: ");
        while (num > 0) {
            int digit = (int) (num % 10);
            System.out.print(digit + " ");
            
            if (digit < smallest) smallest = digit;
            if (digit > largest) largest = digit;
            
            num /= 10;
        }
        
        System.out.println("\n\nNumber: " + original);
        System.out.println("Smallest digit: " + smallest);
        System.out.println("Largest digit: " + largest);
        System.out.println("Difference: " + (largest - smallest));
        
        // Count occurrences of each
        int[] digitCount = new int[10];
        num = original;
        while (num > 0) {
            digitCount[(int) (num % 10)]++;
            num /= 10;
        }
        
        System.out.println("\nDigit frequency:");
        for (int i = 0; i <= 9; i++) {
            if (digitCount[i] > 0) {
                System.out.println("  " + i + " appears " + digitCount[i] + " time(s)");
            }
        }
    }
    
    // =========================================================================
    // QUESTION 36: Binary with even number of 1s
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Convert number to binary and count the 1s.
     * Check if count is even.
     * 
     * Example: 5 = 101 (two 1s - even) ✓
     *          7 = 111 (three 1s - odd) ✗
     */
    public static void question36() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num < 0) {
            System.out.println("Please enter a non-negative number!");
            return;
        }
        
        // Convert to binary and count 1s
        String binary = Integer.toBinaryString(num);
        int oneCount = 0;
        
        for (char c : binary.toCharArray()) {
            if (c == '1') oneCount++;
        }
        
        System.out.println("\nNumber: " + num);
        System.out.println("Binary: " + binary);
        System.out.println("Count of 1s: " + oneCount);
        
        if (oneCount % 2 == 0) {
            System.out.println("✓ Even number of 1s!");
        } else {
            System.out.println("✗ Odd number of 1s");
        }
        
        // Find numbers 1-n with even 1s
        System.out.println("\n--- Numbers 1-" + num + " with even 1s in binary ---");
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int ones = Integer.bitCount(i);  // Built-in method!
            if (ones % 2 == 0) {
                System.out.print(i + "(" + Integer.toBinaryString(i) + ") ");
                count++;
                if (count % 5 == 0) System.out.println();
            }
        }
        System.out.println("\nTotal: " + count);
    }
    
    // =========================================================================
    // QUESTION 37: i × i pattern
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print pattern where each row i has i printed i times.
     * 
     * 1
     * 2 2
     * 3 3 3
     * 4 4 4 4
     * ...
     */
    public static void question37() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== i × i Pattern ===\n");
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
        // Calculate total numbers printed
        int total = n * (n + 1) / 2;
        System.out.println("\nTotal numbers printed: " + total);
        
        // Sum of all numbers in pattern
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;  // i appears i times
        }
        System.out.println("Sum of all numbers: " + sum);
        
        // Inverted pattern
        System.out.println("\n--- Inverted Pattern ---\n");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 38: Factorials 1–n
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print factorial of each number from 1 to n.
     * 
     * Optimization: Use previous factorial to calculate next.
     * n! = (n-1)! × n
     */
    public static void question38() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Factorials from 1 to " + n + " ===\n");
        
        long factorial = 1;
        long sum = 0;
        
        for (int i = 1; i <= n; i++) {
            factorial *= i;  // n! = (n-1)! × n
            sum += factorial;
            System.out.println(i + "! = " + factorial);
            
            // Warning for overflow
            if (factorial < 0) {
                System.out.println("⚠️ Overflow detected! Use BigInteger for larger values.");
                break;
            }
        }
        
        System.out.println("\nSum of all factorials (1! + 2! + ... + " + n + "!) = " + sum);
        
        // Show formula: Sum = e × n! (approximately)
        if (n <= 20) {
            System.out.println("\nFun fact: 1! + 2! + 3! + ... converges to (e-1) × n! for large n");
        }
    }
    
    // =========================================================================
    // QUESTION 39: Sum of odd & even digits separately
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Separate digits into odd and even, sum each group.
     * 
     * Odd digits: 1, 3, 5, 7, 9
     * Even digits: 0, 2, 4, 6, 8
     */
    public static void question39() {
        System.out.print("Enter a number: ");
        long num = sc.nextLong();
        
        num = Math.abs(num);
        
        int oddSum = 0, evenSum = 0;
        int oddCount = 0, evenCount = 0;
        
        StringBuilder oddDigits = new StringBuilder();
        StringBuilder evenDigits = new StringBuilder();
        
        long temp = num;
        while (temp > 0) {
            int digit = (int) (temp % 10);
            
            if (digit % 2 == 0) {
                evenSum += digit;
                evenCount++;
                evenDigits.insert(0, digit + " ");
            } else {
                oddSum += digit;
                oddCount++;
                oddDigits.insert(0, digit + " ");
            }
            
            temp /= 10;
        }
        
        System.out.println("\n=== Digit Analysis of " + num + " ===\n");
        
        System.out.println("Odd digits: " + (oddDigits.length() > 0 ? oddDigits : "None"));
        System.out.println("Count: " + oddCount);
        System.out.println("Sum: " + oddSum);
        
        System.out.println("\nEven digits: " + (evenDigits.length() > 0 ? evenDigits : "None"));
        System.out.println("Count: " + evenCount);
        System.out.println("Sum: " + evenSum);
        
        System.out.println("\nTotal digit sum: " + (oddSum + evenSum));
        System.out.println("Difference (odd - even): " + (oddSum - evenSum));
    }
    
    // =========================================================================
    // QUESTION 40: Continue statement logic
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Demonstrate the use of 'continue' statement.
     * 'continue' skips the rest of the current iteration
     * and moves to the next iteration.
     * 
     * Example: Print all numbers except multiples of 3
     */
    public static void question40() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Continue Statement Demo ===\n");
        
        // Example 1: Skip multiples of 3
        System.out.println("1. Numbers 1-" + n + " (skipping multiples of 3):");
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                continue;  // Skip this iteration
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Example 2: Skip numbers containing digit 5
        System.out.println("\n2. Numbers 1-" + n + " (skipping numbers with digit 5):");
        for (int i = 1; i <= n; i++) {
            // Check if number contains 5
            int temp = i;
            boolean contains5 = false;
            while (temp > 0) {
                if (temp % 10 == 5) {
                    contains5 = true;
                    break;
                }
                temp /= 10;
            }
            
            if (contains5) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Example 3: Process only even numbers
        System.out.println("\n3. Processing only even numbers (using continue for odd):");
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                continue;  // Skip odd numbers
            }
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println("\nSum of even numbers: " + sum);
        
        // Labeled continue (for nested loops)
        System.out.println("\n4. Labeled continue (skip inner loop when j=3):");
        outer:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    continue outer;  // Jump to next i
                }
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();  // This won't execute when j=3
        }
        System.out.println();
    }
}
