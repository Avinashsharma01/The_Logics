/**
 * ============================================
 * PHASE 3 - RECURSION
 * Level 1: Basics (Questions 1-10)
 * ============================================
 * 
 * CONCEPT: Recursion is when a function calls itself.
 * 
 * KEY COMPONENTS:
 * 1. Base Case - The condition to stop recursion
 * 2. Recursive Case - The function calls itself with modified input
 * 
 * PATTERN:
 * function(n) {
 *     if (base condition) return result;  // Base case
 *     return function(smaller problem);    // Recursive case
 * }
 * 
 * IMPORTANT: Always ensure the recursive call moves toward the base case!
 */

import java.util.Scanner;

public class Level1_Basics {
    
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
    // QUESTION 1: Print 1–n using recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * To print 1 to n:
     * - First print 1 to n-1 (recursive call)
     * - Then print n
     * 
     * Base case: n == 0 (nothing to print)
     * 
     * Call stack visualization for n=3:
     * print1ToN(3) → print1ToN(2) → print1ToN(1) → print1ToN(0)
     *                                                  ↓ returns
     *                                 prints 1 ←------
     *                 prints 2 ←----------------------
     * prints 3 ←--------------------------------------
     */
    public static void question1() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Print 1 to " + n + " ===");
        print1ToN(n);
        System.out.println();
        
        // Trace the recursion
        System.out.println("\n--- Recursion Trace ---");
        print1ToNWithTrace(n, 0);
    }
    
    static void print1ToN(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        
        // Recursive case: first print 1 to n-1
        print1ToN(n - 1);
        
        // Then print n
        System.out.print(n + " ");
    }
    
    static void print1ToNWithTrace(int n, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "Called print1ToN(" + n + ")");
        
        if (n == 0) {
            System.out.println(indent + "Base case reached, returning");
            return;
        }
        
        print1ToNWithTrace(n - 1, depth + 1);
        System.out.println(indent + "Printing: " + n);
    }
    
    // =========================================================================
    // QUESTION 2: Print n–1 using recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * To print n to 1:
     * - First print n
     * - Then print n-1 to 1 (recursive call)
     * 
     * Base case: n == 0 (stop)
     * 
     * This is the reverse of question 1 - just swap print and recursive call!
     */
    public static void question2() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Print " + n + " to 1 ===");
        printNTo1(n);
        System.out.println();
    }
    
    static void printNTo1(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        
        // First print n
        System.out.print(n + " ");
        
        // Then print n-1 to 1
        printNTo1(n - 1);
    }
    
    // =========================================================================
    // QUESTION 3: Even numbers recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print even numbers from 2 to n.
     * 
     * Approach 1: Start from 2, add 2 each time
     * Approach 2: Check each number if even
     */
    public static void question3() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Even Numbers up to " + n + " ===");
        printEven(2, n);  // Start from 2
        System.out.println();
    }
    
    static void printEven(int current, int n) {
        // Base case
        if (current > n) {
            return;
        }
        
        // Print current even number
        System.out.print(current + " ");
        
        // Move to next even number
        printEven(current + 2, n);
    }
    
    // =========================================================================
    // QUESTION 4: Odd numbers recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print odd numbers from 1 to n.
     * Similar to even numbers, but start from 1.
     */
    public static void question4() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Odd Numbers up to " + n + " ===");
        printOdd(1, n);  // Start from 1
        System.out.println();
    }
    
    static void printOdd(int current, int n) {
        // Base case
        if (current > n) {
            return;
        }
        
        // Print current odd number
        System.out.print(current + " ");
        
        // Move to next odd number
        printOdd(current + 2, n);
    }
    
    // =========================================================================
    // QUESTION 5: Sum of n numbers using recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * sum(n) = n + sum(n-1)
     * sum(1) = 1 (base case)
     * 
     * Example: sum(5) = 5 + sum(4) = 5 + 4 + sum(3) = ... = 5+4+3+2+1 = 15
     */
    public static void question5() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Sum of 1 to " + n + " ===");
        int sum = sumN(n);
        System.out.println("Sum = " + sum);
        
        // Verify with formula
        int formulaSum = n * (n + 1) / 2;
        System.out.println("Formula verification: " + formulaSum);
    }
    
    static int sumN(int n) {
        // Base case
        if (n == 1) {
            return 1;
        }
        
        // Recursive case
        return n + sumN(n - 1);
    }
    
    // =========================================================================
    // QUESTION 6: Factorial using recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * n! = n × (n-1)!
     * 0! = 1 (base case)
     * 1! = 1 (can also be base case)
     * 
     * Example: 5! = 5 × 4! = 5 × 4 × 3! = 5 × 4 × 3 × 2! = 5 × 4 × 3 × 2 × 1! = 120
     * 
     * This is the classic recursion example!
     */
    public static void question6() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        if (n < 0) {
            System.out.println("Factorial not defined for negative numbers!");
            return;
        }
        
        System.out.println("\n=== Factorial of " + n + " ===");
        long result = factorial(n);
        System.out.println(n + "! = " + result);
        
        // Show step by step
        System.out.println("\nStep by step:");
        System.out.print(n + "! = ");
        for (int i = n; i >= 1; i--) {
            System.out.print(i);
            if (i > 1) System.out.print(" × ");
        }
        System.out.println(" = " + result);
    }
    
    static long factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // Recursive case
        return n * factorial(n - 1);
    }
    
    // =========================================================================
    // QUESTION 7: Power x^n using recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * x^n = x × x^(n-1)
     * x^0 = 1 (base case)
     * 
     * Optimization (for O(log n)):
     * x^n = (x^(n/2))^2 if n is even
     * x^n = x × (x^(n/2))^2 if n is odd
     */
    public static void question7() {
        System.out.print("Enter base (x): ");
        double x = sc.nextDouble();
        System.out.print("Enter exponent (n): ");
        int n = sc.nextInt();
        
        System.out.println("\n=== " + x + "^" + n + " ===");
        
        // Simple recursive power
        double result = power(x, Math.abs(n));
        if (n < 0) result = 1 / result;
        
        System.out.println("Result: " + result);
        
        // Verify with Math.pow
        System.out.println("Math.pow verification: " + Math.pow(x, n));
        
        // Also show optimized version
        double optimizedResult = powerOptimized(x, Math.abs(n));
        if (n < 0) optimizedResult = 1 / optimizedResult;
        System.out.println("Optimized result: " + optimizedResult);
    }
    
    // Simple O(n) approach
    static double power(double x, int n) {
        // Base case
        if (n == 0) return 1;
        
        // Recursive case
        return x * power(x, n - 1);
    }
    
    // Optimized O(log n) approach
    static double powerOptimized(double x, int n) {
        // Base case
        if (n == 0) return 1;
        
        // Calculate half power
        double half = powerOptimized(x, n / 2);
        
        // If even: x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            return half * half;
        }
        // If odd: x^n = x × (x^(n/2))^2
        else {
            return x * half * half;
        }
    }
    
    // =========================================================================
    // QUESTION 8: nth Fibonacci using recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * F(n) = F(n-1) + F(n-2)
     * F(0) = 0, F(1) = 1 (base cases)
     * 
     * WARNING: Naive recursion is O(2^n) - very slow!
     * Use memoization for efficiency (shown below).
     */
    public static void question8() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== " + n + "th Fibonacci Number ===");
        
        // Naive recursive (slow for large n)
        if (n <= 30) {  // Only for small n
            int fibNaive = fibonacciNaive(n);
            System.out.println("F(" + n + ") = " + fibNaive + " (naive recursion)");
        } else {
            System.out.println("Naive recursion skipped (too slow for n > 30)");
        }
        
        // Memoized (fast)
        long[] memo = new long[n + 1];
        for (int i = 0; i <= n; i++) memo[i] = -1;
        long fibMemo = fibonacciMemo(n, memo);
        System.out.println("F(" + n + ") = " + fibMemo + " (memoized)");
    }
    
    // Naive - O(2^n) time
    static int fibonacciNaive(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Recursive case
        return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
    }
    
    // Memoized - O(n) time
    static long fibonacciMemo(int n, long[] memo) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Check if already computed
        if (memo[n] != -1) return memo[n];
        
        // Compute and store
        memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        return memo[n];
    }
    
    // =========================================================================
    // QUESTION 9: Fibonacci series using recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print the first n Fibonacci numbers.
     * Use a helper function that calculates each term.
     */
    public static void question9() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== First " + n + " Fibonacci Numbers ===");
        
        // Using memoization for efficiency
        long[] memo = new long[n + 1];
        for (int i = 0; i <= n; i++) memo[i] = -1;
        
        printFibonacciSeries(0, n, memo);
        System.out.println();
    }
    
    static void printFibonacciSeries(int current, int n, long[] memo) {
        // Base case
        if (current >= n) {
            return;
        }
        
        // Print current Fibonacci number
        System.out.print(fibonacciMemo(current, memo) + " ");
        
        // Print next
        printFibonacciSeries(current + 1, n, memo);
    }
    
    // =========================================================================
    // QUESTION 10: Sum of digits using recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * sumOfDigits(n) = lastDigit + sumOfDigits(remainingNumber)
     * sumOfDigits(0) = 0 (base case)
     * 
     * Example: sumOfDigits(123)
     * = 3 + sumOfDigits(12)
     * = 3 + 2 + sumOfDigits(1)
     * = 3 + 2 + 1 + sumOfDigits(0)
     * = 3 + 2 + 1 + 0 = 6
     */
    public static void question10() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int absNum = Math.abs(num);
        
        System.out.println("\n=== Sum of Digits of " + num + " ===");
        int sum = sumOfDigits(absNum);
        System.out.println("Sum = " + sum);
        
        // Show the breakdown
        System.out.print("Breakdown: ");
        printDigitBreakdown(absNum);
        System.out.println("= " + sum);
    }
    
    static int sumOfDigits(int n) {
        // Base case
        if (n == 0) {
            return 0;
        }
        
        // Recursive case: last digit + sum of remaining digits
        return (n % 10) + sumOfDigits(n / 10);
    }
    
    static void printDigitBreakdown(int n) {
        if (n < 10) {
            System.out.print(n + " ");
            return;
        }
        printDigitBreakdown(n / 10);
        System.out.print("+ " + (n % 10) + " ");
    }
}
