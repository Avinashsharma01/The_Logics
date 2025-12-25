/**
 * ============================================
 * PHASE 2 - LOOPING & PATTERNS
 * Level 3: Math Logic (Questions 21-30)
 * ============================================
 * 
 * CONCEPT: Mathematical operations using loops.
 * Topics: Squares, cubes, HCF, LCM, factors, sequences.
 */

import java.util.Scanner;

public class Level3_MathLogic {
    
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
    // QUESTION 21: Squares 1–n
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print square of each number from 1 to n.
     * Square = number × number = number²
     */
    public static void question21() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Squares from 1 to " + n + " ===");
        System.out.println("Number | Square");
        System.out.println("-------|-------");
        
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            System.out.printf("  %3d  |  %5d%n", i, square);
        }
        
        // Sum of squares formula: n(n+1)(2n+1)/6
        long sumOfSquares = (long) n * (n + 1) * (2 * n + 1) / 6;
        System.out.println("\nSum of squares (1² + 2² + ... + " + n + "²) = " + sumOfSquares);
    }
    
    // =========================================================================
    // QUESTION 22: Cubes 1–n
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Print cube of each number from 1 to n.
     * Cube = number × number × number = number³
     */
    public static void question22() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Cubes from 1 to " + n + " ===");
        System.out.println("Number | Cube");
        System.out.println("-------|-------");
        
        for (int i = 1; i <= n; i++) {
            int cube = i * i * i;
            System.out.printf("  %3d  |  %6d%n", i, cube);
        }
        
        // Sum of cubes formula: [n(n+1)/2]² = (sum of first n numbers)²
        long sum = (long) n * (n + 1) / 2;
        long sumOfCubes = sum * sum;
        System.out.println("\nSum of cubes (1³ + 2³ + ... + " + n + "³) = " + sumOfCubes);
        System.out.println("This equals (1 + 2 + ... + " + n + ")² = " + sum + "² = " + sumOfCubes);
    }
    
    // =========================================================================
    // QUESTION 23: Numbers divisible by 7
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find all numbers divisible by 7 in a given range.
     * A number is divisible by 7 if num % 7 == 0
     */
    public static void question23() {
        System.out.print("Enter range (start end): ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        System.out.println("\n=== Numbers divisible by 7 (" + start + " to " + end + ") ===");
        
        // Find first number divisible by 7 in range
        int first = start;
        if (first % 7 != 0) {
            first = first + (7 - first % 7);
        }
        
        int count = 0;
        int sum = 0;
        
        for (int i = first; i <= end; i += 7) {
            System.out.print(i + " ");
            count++;
            sum += i;
            if (count % 10 == 0) System.out.println();
        }
        
        System.out.println("\n\nCount: " + count);
        System.out.println("Sum: " + sum);
    }
    
    // =========================================================================
    // QUESTION 24: HCF using loops (Euclidean Algorithm)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * HCF (Highest Common Factor) = GCD (Greatest Common Divisor)
     * 
     * Euclidean Algorithm:
     * GCD(a, b) = GCD(b, a % b) until b becomes 0
     * 
     * Example: GCD(48, 18)
     * GCD(48, 18) → GCD(18, 48%18=12) → GCD(12, 18%12=6) → GCD(6, 12%6=0) → 6
     */
    public static void question24() {
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int originalA = a, originalB = b;
        a = Math.abs(a);
        b = Math.abs(b);
        
        System.out.println("\n=== HCF/GCD of " + originalA + " and " + originalB + " ===");
        System.out.println("\nUsing Euclidean Algorithm:");
        
        int tempA = a, tempB = b;
        while (tempB != 0) {
            System.out.println("GCD(" + tempA + ", " + tempB + ") → " + 
                             "GCD(" + tempB + ", " + (tempA % tempB) + ")");
            int temp = tempB;
            tempB = tempA % tempB;
            tempA = temp;
        }
        
        int hcf = tempA;
        System.out.println("\nHCF = " + hcf);
        
        // Verify by showing common factors
        System.out.print("\nFactors of " + a + ": ");
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) System.out.print(i + " ");
        }
        System.out.print("\nFactors of " + b + ": ");
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) System.out.print(i + " ");
        }
        System.out.print("\nCommon factors: ");
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) System.out.print(i + " ");
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 25: LCM using loops
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * LCM (Least Common Multiple) is the smallest number divisible by both.
     * 
     * Formula: LCM(a, b) = (a × b) / GCD(a, b)
     * 
     * OR: Start from max(a,b) and keep incrementing until divisible by both.
     */
    public static void question25() {
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        a = Math.abs(a);
        b = Math.abs(b);
        
        if (a == 0 || b == 0) {
            System.out.println("LCM with 0 is undefined!");
            return;
        }
        
        System.out.println("\n=== LCM of " + a + " and " + b + " ===");
        
        // Method 1: Using GCD (efficient)
        int tempA = a, tempB = b;
        while (tempB != 0) {
            int temp = tempB;
            tempB = tempA % tempB;
            tempA = temp;
        }
        int gcd = tempA;
        long lcm = (long) a * b / gcd;
        
        System.out.println("Method 1 (using GCD):");
        System.out.println("  GCD = " + gcd);
        System.out.println("  LCM = (" + a + " × " + b + ") / " + gcd + " = " + lcm);
        
        // Method 2: Brute force (for demonstration)
        System.out.println("\nMethod 2 (brute force):");
        int max = Math.max(a, b);
        int lcm2 = max;
        while (lcm2 % a != 0 || lcm2 % b != 0) {
            lcm2 += max;
        }
        System.out.println("  LCM = " + lcm2);
        
        // Show first few multiples
        System.out.print("\nMultiples of " + a + ": ");
        for (int i = 1; i <= 10; i++) System.out.print((a * i) + " ");
        System.out.print("\nMultiples of " + b + ": ");
        for (int i = 1; i <= 10; i++) System.out.print((b * i) + " ");
        System.out.println("\nFirst common multiple: " + lcm);
    }
    
    // =========================================================================
    // QUESTION 26: Factors of number
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Factors are numbers that divide evenly (remainder = 0).
     * 
     * Optimization: Only check up to √n, factors come in pairs.
     * If i is a factor, then n/i is also a factor.
     */
    public static void question26() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        num = Math.abs(num);
        
        System.out.println("\n=== Factors of " + num + " ===");
        
        // Method 1: Check all numbers (simple)
        System.out.print("All factors: ");
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("\nTotal factors: " + count);
        
        // Method 2: Efficient (using pairs)
        System.out.println("\nFactor pairs:");
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                int pair = num / i;
                if (i == pair) {
                    System.out.println(i + " × " + i + " = " + num);
                } else {
                    System.out.println(i + " × " + pair + " = " + num);
                }
            }
        }
        
        // Check if perfect number
        int sumOfFactors = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sumOfFactors += i;
        }
        System.out.println("\nSum of proper factors: " + sumOfFactors);
        if (sumOfFactors == num) {
            System.out.println("✓ This is a perfect number!");
        }
    }
    
    // =========================================================================
    // QUESTION 27: Sum of factors
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find all factors and add them together.
     * 
     * σ(n) = sum of all divisors of n
     * This is called the divisor function.
     */
    public static void question27() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        num = Math.abs(num);
        
        System.out.println("\n=== Sum of Factors of " + num + " ===");
        
        int sum = 0;
        System.out.print("Factors: ");
        
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i);
                sum += i;
                if (i < num) System.out.print(" + ");
            }
        }
        
        System.out.println(" = " + sum);
        
        // Also show sum of proper divisors
        int properSum = sum - num;
        System.out.println("Sum of proper divisors (excluding " + num + "): " + properSum);
        
        // Classification
        if (properSum == num) {
            System.out.println("Classification: PERFECT number");
        } else if (properSum < num) {
            System.out.println("Classification: DEFICIENT number");
        } else {
            System.out.println("Classification: ABUNDANT number");
        }
    }
    
    // =========================================================================
    // QUESTION 28: Strong number
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A strong number is one where sum of factorials of digits equals the number.
     * 
     * Examples:
     * - 145 = 1! + 4! + 5! = 1 + 24 + 120 = 145 ✓
     * - 40585 = 4! + 0! + 5! + 8! + 5! = 24 + 1 + 120 + 40320 + 120 = 40585 ✓
     */
    public static void question28() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num < 0) {
            System.out.println("Please enter a positive number!");
            return;
        }
        
        int original = num;
        int sum = 0;
        
        // Pre-compute factorials of 0-9
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        
        System.out.println("\n=== Strong Number Check for " + num + " ===");
        System.out.print("Calculation: ");
        
        boolean first = true;
        while (num > 0) {
            int digit = num % 10;
            if (!first) System.out.print(" + ");
            System.out.print(digit + "!(" + factorial[digit] + ")");
            sum += factorial[digit];
            num /= 10;
            first = false;
        }
        
        System.out.println(" = " + sum);
        
        if (original == sum) {
            System.out.println("✓ " + original + " is a STRONG number! 💪");
        } else {
            System.out.println("✗ NOT a strong number");
        }
        
        // Find strong numbers in a range
        System.out.println("\n--- Strong numbers (1-100000) ---");
        for (int n = 1; n <= 100000; n++) {
            int s = 0;
            int temp = n;
            while (temp > 0) {
                s += factorial[temp % 10];
                temp /= 10;
            }
            if (n == s) System.out.print(n + " ");
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 29: Arithmetic progression
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * AP: a, a+d, a+2d, a+3d, ...
     * - a = first term
     * - d = common difference
     * - nth term = a + (n-1)d
     * - Sum = n/2 × (2a + (n-1)d) = n/2 × (first + last)
     */
    public static void question29() {
        System.out.print("Enter first term (a): ");
        double a = sc.nextDouble();
        System.out.print("Enter common difference (d): ");
        double d = sc.nextDouble();
        System.out.print("Enter number of terms (n): ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Arithmetic Progression ===");
        System.out.println("First term (a) = " + a);
        System.out.println("Common difference (d) = " + d);
        System.out.println("Number of terms (n) = " + n);
        
        System.out.print("\nAP Series: ");
        double sum = 0;
        double term = a;
        
        for (int i = 1; i <= n; i++) {
            System.out.print(term);
            sum += term;
            if (i < n) System.out.print(", ");
            term += d;
        }
        System.out.println();
        
        double lastTerm = a + (n - 1) * d;
        double sumFormula = (n / 2.0) * (a + lastTerm);
        
        System.out.println("\nLast term = a + (n-1)d = " + a + " + " + (n-1) + "×" + d + " = " + lastTerm);
        System.out.println("Sum (by loop) = " + sum);
        System.out.println("Sum (by formula n/2(a+l)) = " + sumFormula);
    }
    
    // =========================================================================
    // QUESTION 30: Geometric progression
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * GP: a, ar, ar², ar³, ...
     * - a = first term
     * - r = common ratio
     * - nth term = a × r^(n-1)
     * - Sum = a(r^n - 1)/(r - 1) if r ≠ 1
     */
    public static void question30() {
        System.out.print("Enter first term (a): ");
        double a = sc.nextDouble();
        System.out.print("Enter common ratio (r): ");
        double r = sc.nextDouble();
        System.out.print("Enter number of terms (n): ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Geometric Progression ===");
        System.out.println("First term (a) = " + a);
        System.out.println("Common ratio (r) = " + r);
        System.out.println("Number of terms (n) = " + n);
        
        System.out.print("\nGP Series: ");
        double sum = 0;
        double term = a;
        
        for (int i = 1; i <= n; i++) {
            System.out.printf("%.2f", term);
            sum += term;
            if (i < n) System.out.print(", ");
            term *= r;
        }
        System.out.println();
        
        double lastTerm = a * Math.pow(r, n - 1);
        double sumFormula;
        if (r == 1) {
            sumFormula = n * a;
        } else {
            sumFormula = a * (Math.pow(r, n) - 1) / (r - 1);
        }
        
        System.out.printf("%nLast term = a × r^(n-1) = %.2f%n", lastTerm);
        System.out.printf("Sum (by loop) = %.2f%n", sum);
        System.out.printf("Sum (by formula) = %.2f%n", sumFormula);
        
        // Product of GP terms
        double product = Math.pow(a, n) * Math.pow(r, n * (n - 1) / 2);
        System.out.printf("Product of all terms = %.2f%n", product);
    }
}
