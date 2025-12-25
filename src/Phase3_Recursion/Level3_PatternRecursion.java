/**
 * ============================================
 * PHASE 3 - RECURSION
 * Level 3: Pattern Recursion (Questions 21-30)
 * ============================================
 * 
 * CONCEPT: Generate patterns using recursion.
 * Key insight: Print one row, then recursively handle remaining rows.
 */

import java.util.Scanner;

public class Level3_PatternRecursion {
    
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
    // QUESTION 21: Line of stars recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print n stars in a line using recursion.
     * printStars(n) = print one star + printStars(n-1)
     */
    public static void question21() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== " + n + " Stars in a Line ===");
        printStarsLine(n);
        System.out.println();
    }
    
    static void printStarsLine(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        
        // Print one star
        System.out.print("* ");
        
        // Print remaining stars
        printStarsLine(n - 1);
    }
    
    // =========================================================================
    // QUESTION 22: Square of stars recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print n×n square of stars.
     * printSquare(n) = print one row of n stars + newline + printSquare(n-1)
     */
    public static void question22() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== " + n + "×" + n + " Square of Stars ===");
        printSquare(n, n);  // rows remaining, total columns
    }
    
    static void printSquare(int rows, int cols) {
        // Base case
        if (rows == 0) {
            return;
        }
        
        // Print one row of stars
        printStarsLine(cols);
        System.out.println();
        
        // Print remaining rows
        printSquare(rows - 1, cols);
    }
    
    // =========================================================================
    // QUESTION 23: Triangle (top-down) - Right-angled triangle
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Row 1: 1 star
     * Row 2: 2 stars
     * ...
     * Row n: n stars
     * 
     * printTriangle(current, n): print current stars, then recurse for next row
     */
    public static void question23() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Right Triangle (Top-Down) ===");
        printTriangleTopDown(1, n);
    }
    
    static void printTriangleTopDown(int current, int n) {
        // Base case: reached beyond last row
        if (current > n) {
            return;
        }
        
        // Print current row with 'current' stars
        printStarsLine(current);
        System.out.println();
        
        // Print next rows
        printTriangleTopDown(current + 1, n);
    }
    
    // =========================================================================
    // QUESTION 24: Triangle (bottom-up) - Inverted right-angled triangle
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Row 1: n stars
     * Row 2: n-1 stars
     * ...
     * Row n: 1 star
     */
    public static void question24() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Inverted Triangle (Bottom-Up) ===");
        printTriangleBottomUp(n);
    }
    
    static void printTriangleBottomUp(int n) {
        // Base case
        if (n == 0) {
            return;
        }
        
        // Print current row with n stars
        printStarsLine(n);
        System.out.println();
        
        // Print smaller triangle
        printTriangleBottomUp(n - 1);
    }
    
    // =========================================================================
    // QUESTION 25: Number pattern triangle
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * 1
     * 1 2
     * 1 2 3
     * 1 2 3 4
     * ...
     */
    public static void question25() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Number Pattern Triangle ===");
        printNumberTriangle(1, n);
    }
    
    static void printNumberTriangle(int row, int n) {
        // Base case
        if (row > n) {
            return;
        }
        
        // Print numbers 1 to row
        printNumbers(1, row);
        System.out.println();
        
        // Print next row
        printNumberTriangle(row + 1, n);
    }
    
    static void printNumbers(int start, int end) {
        // Base case
        if (start > end) {
            return;
        }
        
        // Print current number
        System.out.print(start + " ");
        
        // Print remaining numbers
        printNumbers(start + 1, end);
    }
    
    // =========================================================================
    // QUESTION 26: Reverse triangle
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * n n-1 ... 2 1
     * n n-1 ... 2
     * ...
     * n n-1
     * n
     */
    public static void question26() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Reverse Number Triangle ===");
        printReverseTriangle(n, n);
    }
    
    static void printReverseTriangle(int row, int n) {
        // Base case
        if (row == 0) {
            return;
        }
        
        // Print numbers from n down to (n-row+1)
        printNumbersReverse(n, n - row + 1);
        System.out.println();
        
        // Print next row with one less number
        printReverseTriangle(row - 1, n);
    }
    
    static void printNumbersReverse(int start, int end) {
        // Base case
        if (start < end) {
            return;
        }
        
        // Print current number
        System.out.print(start + " ");
        
        // Print remaining numbers
        printNumbersReverse(start - 1, end);
    }
    
    // =========================================================================
    // QUESTION 27: Multiplication table using recursion
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print n × 1, n × 2, ... n × 10 recursively.
     */
    public static void question27() {
        System.out.print("Enter number for table: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Multiplication Table of " + n + " ===");
        printTable(n, 1);
    }
    
    static void printTable(int n, int multiplier) {
        // Base case
        if (multiplier > 10) {
            return;
        }
        
        // Print current multiplication
        System.out.println(n + " × " + multiplier + " = " + (n * multiplier));
        
        // Print next
        printTable(n, multiplier + 1);
    }
    
    // =========================================================================
    // QUESTION 28: Increasing then decreasing numbers
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For n=4: 1 2 3 4 3 2 1
     * 
     * Trick: Print before AND after recursive call!
     * - Print current number
     * - Recurse
     * - Print current number again (on the way back)
     */
    public static void question28() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Increasing then Decreasing ===");
        printIncDec(1, n);
        System.out.println();
    }
    
    static void printIncDec(int current, int n) {
        // Print on the way down
        System.out.print(current + " ");
        
        // Base case: reached the peak
        if (current == n) {
            return;
        }
        
        // Go deeper
        printIncDec(current + 1, n);
        
        // Print on the way back up
        System.out.print(current + " ");
    }
    
    // =========================================================================
    // QUESTION 29: Recursive series steps visualization
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Visualize how recursion works step by step.
     * Show the call stack for factorial computation.
     */
    public static void question29() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Recursive Factorial Visualization ===");
        System.out.println("\n--- Going DOWN (calling) ---");
        long result = factorialVisualized(n, 0);
        System.out.println("\n--- Final Result: " + n + "! = " + result + " ---");
    }
    
    static long factorialVisualized(int n, int depth) {
        String indent = "  ".repeat(depth);
        
        System.out.println(indent + "→ factorial(" + n + ") called");
        
        // Base case
        if (n <= 1) {
            System.out.println(indent + "← Base case! Returning 1");
            return 1;
        }
        
        // Recursive call
        long subResult = factorialVisualized(n - 1, depth + 1);
        
        // Calculate result
        long result = n * subResult;
        System.out.println(indent + "← " + n + " × " + subResult + " = " + result);
        
        return result;
    }
    
    // =========================================================================
    // QUESTION 30: Character pattern recursively
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A
     * A B
     * A B C
     * A B C D
     * ...
     */
    public static void question30() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        if (n > 26) {
            System.out.println("Maximum n is 26 (letters A-Z)");
            n = 26;
        }
        
        System.out.println("\n=== Character Pattern ===");
        printCharPattern(1, n);
    }
    
    static void printCharPattern(int row, int n) {
        // Base case
        if (row > n) {
            return;
        }
        
        // Print characters A to (A + row - 1)
        printChars('A', (char) ('A' + row - 1));
        System.out.println();
        
        // Print next row
        printCharPattern(row + 1, n);
    }
    
    static void printChars(char start, char end) {
        // Base case
        if (start > end) {
            return;
        }
        
        // Print current character
        System.out.print(start + " ");
        
        // Print next character
        printChars((char) (start + 1), end);
    }
}
