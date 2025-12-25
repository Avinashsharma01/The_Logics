/**
 * ============================================
 * PHASE 3 - RECURSION
 * Level 2: Number Recursion (Questions 11-20)
 * ============================================
 * 
 * CONCEPT: Advanced number operations using recursion.
 * These patterns are common in interviews.
 */

import java.util.Scanner;

public class Level2_NumberRecursion {
    
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
    // QUESTION 11: Count digits recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * countDigits(n) = 1 + countDigits(n / 10)
     * countDigits(0) = 0 (or handle single digit case)
     * 
     * Each recursive call removes one digit (by dividing by 10).
     */
    public static void question11() {
        System.out.print("Enter a number: ");
        long num = sc.nextLong();
        
        num = Math.abs(num);
        
        System.out.println("\n=== Count Digits of " + num + " ===");
        int count = countDigits(num);
        System.out.println("Number of digits: " + count);
    }
    
    static int countDigits(long n) {
        // Base case: single digit
        if (n < 10) {
            return 1;
        }
        
        // Recursive case
        return 1 + countDigits(n / 10);
    }
    
    // =========================================================================
    // QUESTION 12: Reverse number recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * This is tricky! We need to know the number of digits.
     * 
     * reverse(n) = lastDigit × 10^(digits-1) + reverse(remaining)
     * 
     * Alternative: Use a helper with accumulator.
     */
    public static void question12() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        boolean negative = num < 0;
        num = Math.abs(num);
        
        System.out.println("\n=== Reverse " + (negative ? "-" : "") + num + " ===");
        int reversed = reverseNumber(num);
        if (negative) reversed = -reversed;
        System.out.println("Reversed: " + reversed);
    }
    
    static int reverseNumber(int n) {
        // Using helper with accumulator
        return reverseHelper(n, 0);
    }
    
    static int reverseHelper(int n, int reversed) {
        // Base case
        if (n == 0) {
            return reversed;
        }
        
        // Get last digit and add to reversed
        int lastDigit = n % 10;
        reversed = reversed * 10 + lastDigit;
        
        // Recursive call with remaining number
        return reverseHelper(n / 10, reversed);
    }
    
    // =========================================================================
    // QUESTION 13: Palindrome check recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A number is palindrome if it equals its reverse.
     * 
     * OR: Compare first and last digits, then check middle.
     */
    public static void question13() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num < 0) {
            System.out.println("Negative numbers are not palindromes!");
            return;
        }
        
        System.out.println("\n=== Palindrome Check for " + num + " ===");
        
        int reversed = reverseNumber(num);
        boolean isPalindrome = (num == reversed);
        
        System.out.println("Original: " + num);
        System.out.println("Reversed: " + reversed);
        System.out.println("Is Palindrome: " + (isPalindrome ? "Yes ✓" : "No ✗"));
    }
    
    // =========================================================================
    // QUESTION 14: Product of digits recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * productOfDigits(n) = lastDigit × productOfDigits(n / 10)
     * productOfDigits(single digit) = the digit itself
     * 
     * Note: If any digit is 0, product is 0!
     */
    public static void question14() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        num = Math.abs(num);
        
        System.out.println("\n=== Product of Digits of " + num + " ===");
        int product = productOfDigits(num);
        System.out.println("Product = " + product);
    }
    
    static int productOfDigits(int n) {
        // Base case: single digit
        if (n < 10) {
            return n;
        }
        
        // Recursive case
        return (n % 10) * productOfDigits(n / 10);
    }
    
    // =========================================================================
    // QUESTION 15: GCD using Euclidean recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Euclidean Algorithm:
     * GCD(a, b) = GCD(b, a % b)
     * GCD(a, 0) = a (base case)
     * 
     * This is elegant and efficient - O(log(min(a,b)))
     */
    public static void question15() {
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        a = Math.abs(a);
        b = Math.abs(b);
        
        System.out.println("\n=== GCD of " + a + " and " + b + " ===");
        int gcd = gcdRecursive(a, b);
        System.out.println("GCD = " + gcd);
        
        // Also calculate LCM
        long lcm = (long) a * b / gcd;
        System.out.println("LCM = " + lcm);
    }
    
    static int gcdRecursive(int a, int b) {
        // Base case
        if (b == 0) {
            return a;
        }
        
        // Recursive case
        return gcdRecursive(b, a % b);
    }
    
    // =========================================================================
    // QUESTION 16: Decimal to binary recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * To convert decimal to binary:
     * - Get remainder when divided by 2 (gives rightmost binary digit)
     * - Recursively convert quotient
     * - Combine: binary of quotient followed by remainder
     */
    public static void question16() {
        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();
        
        if (num < 0) {
            System.out.println("Please enter a non-negative number!");
            return;
        }
        
        System.out.println("\n=== Decimal to Binary ===");
        System.out.println("Decimal: " + num);
        
        if (num == 0) {
            System.out.println("Binary: 0");
            return;
        }
        
        System.out.print("Binary: ");
        printBinary(num);
        System.out.println();
        
        // Verify with built-in
        System.out.println("Verification: " + Integer.toBinaryString(num));
    }
    
    static void printBinary(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        
        // First print higher bits (recursive call)
        printBinary(n / 2);
        
        // Then print current bit
        System.out.print(n % 2);
    }
    
    // Alternative: Return binary as a number
    static long decimalToBinary(int n) {
        if (n == 0) return 0;
        return (n % 2) + 10 * decimalToBinary(n / 2);
    }
    
    // =========================================================================
    // QUESTION 17: Digits in words recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print each digit as a word.
     * Process from left to right by recursing first.
     */
    public static void question17() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        num = Math.abs(num);
        
        System.out.println("\n=== " + num + " in Words ===");
        printDigitsInWords(num);
        System.out.println();
    }
    
    static String[] words = {"Zero", "One", "Two", "Three", "Four", 
                             "Five", "Six", "Seven", "Eight", "Nine"};
    
    static void printDigitsInWords(int n) {
        // Base case: single digit
        if (n < 10) {
            System.out.print(words[n] + " ");
            return;
        }
        
        // Recursive call for higher digits first
        printDigitsInWords(n / 10);
        
        // Then print current digit
        System.out.print(words[n % 10] + " ");
    }
    
    // =========================================================================
    // QUESTION 18: Sum of even numbers recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Sum even numbers from 2 to n.
     * sumEven(n) = n + sumEven(n-2) if n is even
     *            = sumEven(n-1) if n is odd
     */
    public static void question18() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Sum of Even Numbers up to " + n + " ===");
        int sum = sumEven(n);
        System.out.println("Sum = " + sum);
        
        // Formula verification: sum = k(k+1) where k = n/2
        int k = n / 2;
        System.out.println("Formula verification: " + (k * (k + 1)));
    }
    
    static int sumEven(int n) {
        // Make sure we start with even
        if (n % 2 != 0) {
            n = n - 1;
        }
        
        // Base case
        if (n <= 0) {
            return 0;
        }
        
        // Recursive case
        return n + sumEven(n - 2);
    }
    
    // =========================================================================
    // QUESTION 19: Sum of odd numbers recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Sum odd numbers from 1 to n.
     * sumOdd(n) = n + sumOdd(n-2) if n is odd
     */
    public static void question19() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Sum of Odd Numbers up to " + n + " ===");
        int sum = sumOdd(n);
        System.out.println("Sum = " + sum);
        
        // Formula verification: sum = k² where k = (n+1)/2
        int k = (n + 1) / 2;
        System.out.println("Formula verification (k²): " + (k * k));
    }
    
    static int sumOdd(int n) {
        // Make sure we start with odd
        if (n % 2 == 0) {
            n = n - 1;
        }
        
        // Base case
        if (n <= 0) {
            return 0;
        }
        
        // Recursive case
        return n + sumOdd(n - 2);
    }
    
    // =========================================================================
    // QUESTION 20: nCr (Combinations) recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Pascal's Triangle identity:
     * C(n, r) = C(n-1, r-1) + C(n-1, r)
     * 
     * Base cases:
     * C(n, 0) = 1
     * C(n, n) = 1
     * 
     * This represents "choosing r items from n items".
     */
    public static void question20() {
        System.out.print("Enter n and r: ");
        int n = sc.nextInt();
        int r = sc.nextInt();
        
        if (r > n || n < 0 || r < 0) {
            System.out.println("Invalid input! Need 0 ≤ r ≤ n");
            return;
        }
        
        System.out.println("\n=== C(" + n + ", " + r + ") ===");
        long result = nCr(n, r);
        System.out.println("C(" + n + ", " + r + ") = " + result);
        
        // Show Pascal's triangle row
        System.out.println("\nPascal's Triangle Row " + n + ":");
        for (int i = 0; i <= n; i++) {
            System.out.print(nCr(n, i) + " ");
        }
        System.out.println();
    }
    
    static long nCr(int n, int r) {
        // Base cases
        if (r == 0 || r == n) {
            return 1;
        }
        
        // Recursive case: Pascal's identity
        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
}
