/**
 * ============================================
 * PHASE 6 - MIXED CHALLENGES
 * Level 4: Nested Patterns (Questions 31-40)
 * ============================================
 * 
 * CONCEPT: Complex pattern printing using nested loops.
 * 
 * TIPS:
 * - Outer loop controls rows
 * - Inner loops control spaces and characters
 * - Identify the pattern formula
 * - Break down into sub-patterns
 */

import java.util.Scanner;

public class Level4_NestedPatterns {
    
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
    // QUESTION 31: Right-angled triangle with numbers
    // =========================================================================
    /*
     * Pattern for n=5:
     * 1
     * 1 2
     * 1 2 3
     * 1 2 3 4
     * 1 2 3 4 5
     */
    public static void question31() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Number Triangle ===");
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 32: Inverted right triangle
    // =========================================================================
    /*
     * Pattern for n=5:
     * 1 2 3 4 5
     * 1 2 3 4
     * 1 2 3
     * 1 2
     * 1
     */
    public static void question32() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Inverted Number Triangle ===");
        
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 33: Pyramid pattern
    // =========================================================================
    /*
     * Pattern for n=5:
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     */
    public static void question33() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Pyramid Pattern ===");
        
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 34: Diamond pattern
    // =========================================================================
    /*
     * Pattern for n=5:
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     *  *******
     *   *****
     *    ***
     *     *
     */
    public static void question34() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Diamond Pattern ===");
        
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 35: Hollow diamond
    // =========================================================================
    /*
     * Pattern for n=5:
     *     *
     *    * *
     *   *   *
     *  *     *
     * *       *
     *  *     *
     *   *   *
     *    * *
     *     *
     */
    public static void question35() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Hollow Diamond ===");
        
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 36: Pascal's Triangle
    // =========================================================================
    /*
     * Pattern for n=5:
     *     1
     *    1 1
     *   1 2 1
     *  1 3 3 1
     * 1 4 6 4 1
     * 
     * Each number = sum of two numbers above it
     * C(n,r) = n! / (r! * (n-r)!)
     */
    public static void question36() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Pascal's Triangle ===");
        
        for (int i = 0; i < n; i++) {
            // Print spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            
            // Print numbers
            int num = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 37: Floyd's Triangle
    // =========================================================================
    /*
     * Pattern for n=5:
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     * 11 12 13 14 15
     */
    public static void question37() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Floyd's Triangle ===");
        
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 38: Butterfly pattern
    // =========================================================================
    /*
     * Pattern for n=4:
     * *      *
     * **    **
     * ***  ***
     * ********
     * ********
     * ***  ***
     * **    **
     * *      *
     */
    public static void question38() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Butterfly Pattern ===");
        
        // Upper half
        for (int i = 1; i <= n; i++) {
            // Left stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Right stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Lower half
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 39: Sandglass pattern
    // =========================================================================
    /*
     * Pattern for n=5:
     * *********
     *  *******
     *   *****
     *    ***
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     */
    public static void question39() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Sandglass Pattern ===");
        
        // Upper half (inverted pyramid)
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Lower half (pyramid)
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // =========================================================================
    // QUESTION 40: Number pyramid with reflection
    // =========================================================================
    /*
     * Pattern for n=5:
     *     1
     *    121
     *   12321
     *  1234321
     * 123454321
     */
    public static void question40() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Number Pyramid with Reflection ===");
        
        for (int i = 1; i <= n; i++) {
            // Leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            
            // Ascending numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            
            // Descending numbers
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            
            System.out.println();
        }
    }
}
