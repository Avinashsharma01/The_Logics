/**
 * ============================================
 * PHASE 6 - MIXED CHALLENGES
 * Level 1: Number Logic (Questions 1-10)
 * ============================================
 * 
 * CONCEPT: Complex number-based problems combining multiple concepts.
 * 
 * TOPICS:
 * - Mathematical sequences
 * - Number theory
 * - Digit manipulation
 * - Special number properties
 */

import java.util.Scanner;

public class Level1_NumberLogic {
    
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
    // QUESTION 1: Check if number is perfect number
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Perfect number: sum of proper divisors equals the number.
     * Proper divisors: All divisors excluding the number itself.
     * 
     * Example: 28 = 1 + 2 + 4 + 7 + 14 = 28 ✓
     * Perfect numbers: 6, 28, 496, 8128...
     */
    public static void question1() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Perfect Number Check ===");
        System.out.println("Number: " + n);
        
        int sum = 0;
        System.out.print("Proper divisors: ");
        
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        
        System.out.println("\nSum of divisors: " + sum);
        System.out.println(n + " is " + (sum == n ? "" : "NOT ") + "a perfect number");
    }
    
    // =========================================================================
    // QUESTION 2: Check if number is abundant or deficient
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Abundant: sum of proper divisors > number
     * Perfect: sum of proper divisors = number
     * Deficient: sum of proper divisors < number
     */
    public static void question2() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Abundant/Deficient Check ===");
        System.out.println("Number: " + n);
        
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        
        System.out.println("Sum of proper divisors: " + sum);
        
        if (sum > n) {
            System.out.println(n + " is ABUNDANT (excess: " + (sum - n) + ")");
        } else if (sum < n) {
            System.out.println(n + " is DEFICIENT (shortage: " + (n - sum) + ")");
        } else {
            System.out.println(n + " is PERFECT");
        }
    }
    
    // =========================================================================
    // QUESTION 3: Find nth Fibonacci number
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Fibonacci: F(n) = F(n-1) + F(n-2)
     * F(0)=0, F(1)=1, F(2)=1, F(3)=2, F(4)=3, F(5)=5...
     */
    public static void question3() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Nth Fibonacci ===");
        
        if (n <= 0) {
            System.out.println("N must be positive");
            return;
        }
        
        if (n == 1) {
            System.out.println("F(1) = 0");
            return;
        }
        if (n == 2) {
            System.out.println("F(2) = 1");
            return;
        }
        
        int prev2 = 0, prev1 = 1, current = 0;
        
        System.out.print("Sequence: 0 1 ");
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            System.out.print(current + " ");
            prev2 = prev1;
            prev1 = current;
        }
        
        System.out.println("\nF(" + n + ") = " + current);
    }
    
    // =========================================================================
    // QUESTION 4: Check if number is in Fibonacci sequence
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * N is Fibonacci if either (5*n² + 4) or (5*n² - 4) is a perfect square.
     * Or generate Fibonacci numbers until we find or exceed n.
     */
    public static void question4() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Fibonacci Check ===");
        System.out.println("Number: " + n);
        
        // Method 1: Generate and check
        int a = 0, b = 1;
        
        while (b < n) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        
        boolean isFib = (n == a || n == b || n == 0);
        
        System.out.println(n + " is " + (isFib ? "" : "NOT ") + "a Fibonacci number");
        
        // Method 2: Perfect square check
        long val1 = 5L * n * n + 4;
        long val2 = 5L * n * n - 4;
        boolean mathCheck = isPerfectSquare(val1) || isPerfectSquare(val2);
        System.out.println("Using math formula: " + mathCheck);
    }
    
    static boolean isPerfectSquare(long n) {
        if (n < 0) return false;
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
    
    // =========================================================================
    // QUESTION 5: Happy number check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Happy number: Replace number by sum of squares of digits.
     * Repeat until 1 (happy) or cycle (unhappy).
     * 
     * Example: 19 → 1² + 9² = 82 → 68 → 100 → 1 ✓
     * 
     * Use Floyd's cycle detection or limit iterations.
     */
    public static void question5() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Happy Number Check ===");
        System.out.println("Number: " + n);
        
        int slow = n, fast = n;
        
        System.out.print("Sequence: " + n);
        
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
            System.out.print(" → " + slow);
        } while (slow != fast && slow != 1);
        
        System.out.println();
        System.out.println(n + " is " + (slow == 1 ? "" : "NOT ") + "a happy number");
    }
    
    static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    
    // =========================================================================
    // QUESTION 6: Strong number check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Strong number: sum of factorial of digits equals the number.
     * Example: 145 = 1! + 4! + 5! = 1 + 24 + 120 = 145 ✓
     */
    public static void question6() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Strong Number Check ===");
        System.out.println("Number: " + n);
        
        int original = n;
        int sum = 0;
        StringBuilder calculation = new StringBuilder();
        
        while (n > 0) {
            int digit = n % 10;
            int fact = factorial(digit);
            sum += fact;
            calculation.insert(0, digit + "!(" + fact + ") + ");
            n /= 10;
        }
        
        // Remove trailing " + "
        if (calculation.length() > 3) {
            calculation.setLength(calculation.length() - 3);
        }
        
        System.out.println("Calculation: " + calculation + " = " + sum);
        System.out.println(original + " is " + (sum == original ? "" : "NOT ") + "a strong number");
    }
    
    static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    // =========================================================================
    // QUESTION 7: Harshad (Niven) number check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Harshad number: divisible by sum of its digits.
     * Example: 18 → 1+8=9, 18÷9=2 (divisible) ✓
     */
    public static void question7() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Harshad Number Check ===");
        System.out.println("Number: " + n);
        
        int digitSum = 0;
        int temp = n;
        
        while (temp > 0) {
            digitSum += temp % 10;
            temp /= 10;
        }
        
        System.out.println("Sum of digits: " + digitSum);
        
        boolean isHarshad = (n % digitSum == 0);
        System.out.println(n + " ÷ " + digitSum + " = " + (n / digitSum) + " remainder " + (n % digitSum));
        System.out.println(n + " is " + (isHarshad ? "" : "NOT ") + "a Harshad number");
    }
    
    // =========================================================================
    // QUESTION 8: Pronic number check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Pronic number: product of two consecutive integers.
     * n = k * (k+1) for some k
     * Example: 6 = 2*3, 12 = 3*4, 20 = 4*5
     */
    public static void question8() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Pronic Number Check ===");
        System.out.println("Number: " + n);
        
        boolean isPronic = false;
        
        for (int k = 0; k * (k + 1) <= n; k++) {
            if (k * (k + 1) == n) {
                System.out.println(n + " = " + k + " × " + (k + 1));
                isPronic = true;
                break;
            }
        }
        
        System.out.println(n + " is " + (isPronic ? "" : "NOT ") + "a pronic number");
    }
    
    // =========================================================================
    // QUESTION 9: Automorphic number check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Automorphic: Square ends with the number itself.
     * 5² = 25 (ends with 5) ✓
     * 6² = 36 (ends with 6) ✓
     * 25² = 625 (ends with 25) ✓
     * 76² = 5776 (ends with 76) ✓
     */
    public static void question9() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Automorphic Number Check ===");
        System.out.println("Number: " + n);
        
        long square = (long) n * n;
        System.out.println(n + "² = " + square);
        
        // Count digits in n
        int digits = String.valueOf(n).length();
        
        // Get last 'digits' digits of square
        long divisor = (long) Math.pow(10, digits);
        long lastDigits = square % divisor;
        
        boolean isAutomorphic = (lastDigits == n);
        
        System.out.println("Last " + digits + " digit(s) of square: " + lastDigits);
        System.out.println(n + " is " + (isAutomorphic ? "" : "NOT ") + "an automorphic number");
    }
    
    // =========================================================================
    // QUESTION 10: Kaprekar number check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Kaprekar: Square can be split into two parts that sum to original.
     * 45² = 2025 → 20 + 25 = 45 ✓
     * 297² = 88209 → 88 + 209 = 297 ✓
     * 9² = 81 → 8 + 1 = 9 ✓
     */
    public static void question10() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        System.out.println("\n=== Kaprekar Number Check ===");
        System.out.println("Number: " + n);
        
        long square = (long) n * n;
        String sqStr = String.valueOf(square);
        
        System.out.println(n + "² = " + square);
        
        boolean isKaprekar = false;
        
        // Try all split positions
        for (int i = 1; i < sqStr.length(); i++) {
            String leftPart = sqStr.substring(0, i);
            String rightPart = sqStr.substring(i);
            
            long left = Long.parseLong(leftPart);
            long right = rightPart.isEmpty() ? 0 : Long.parseLong(rightPart);
            
            if (right > 0 && left + right == n) {
                System.out.println("Split: " + left + " + " + right + " = " + n);
                isKaprekar = true;
                break;
            }
        }
        
        // Special case: single digit
        if (n == 1) isKaprekar = true;
        
        System.out.println(n + " is " + (isKaprekar ? "" : "NOT ") + "a Kaprekar number");
    }
}
