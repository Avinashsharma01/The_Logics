/**
 * ============================================
 * PHASE 2 - LOOPING & PATTERNS
 * Level 2: Number Logic (Questions 11-20)
 * ============================================
 * 
 * CONCEPT: These problems combine loops with number theory.
 * Key skills: digit extraction, number reversal, special numbers.
 * 
 * IMPORTANT PATTERNS:
 * - Digit extraction: num % 10 (get last), num / 10 (remove last)
 * - Building a number: result = result * 10 + digit
 */

import java.util.Scanner;

public class Level2_NumberLogic {
    
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
    // QUESTION 11: Count digits
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Count how many digits are in a number.
     * 
     * Method 1: Keep dividing by 10 until number becomes 0
     * Method 2: Convert to string and get length
     * Method 3: Use log10 (mathematical)
     */
    public static void question11() {
        System.out.print("Enter a number: ");
        long num = sc.nextLong();
        
        long absNum = Math.abs(num);
        
        // Method 1: Division loop (most common in interviews)
        int count = 0;
        long temp = absNum;
        
        if (temp == 0) {
            count = 1;  // 0 has 1 digit
        } else {
            while (temp > 0) {
                temp /= 10;
                count++;
            }
        }
        
        System.out.println("\nNumber: " + num);
        System.out.println("Digit count (loop): " + count);
        
        // Method 2: String length
        int countString = String.valueOf(absNum).length();
        System.out.println("Digit count (string): " + countString);
        
        // Method 3: Logarithm (careful with 0!)
        int countLog = (absNum == 0) ? 1 : (int) Math.log10(absNum) + 1;
        System.out.println("Digit count (log10): " + countLog);
    }
    
    // =========================================================================
    // QUESTION 12: Reverse number
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Build the reversed number digit by digit.
     * 
     * Algorithm:
     * 1. Extract last digit: digit = num % 10
     * 2. Add to reversed: reversed = reversed * 10 + digit
     * 3. Remove last digit: num = num / 10
     * 4. Repeat until num is 0
     * 
     * Example: 123 → 321
     *   digit=3, reversed=3, num=12
     *   digit=2, reversed=32, num=1
     *   digit=1, reversed=321, num=0
     */
    public static void question12() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int original = num;
        int reversed = 0;
        boolean isNegative = num < 0;
        num = Math.abs(num);
        
        System.out.println("\nStep-by-step reversal:");
        int step = 1;
        
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            System.out.println("Step " + step + ": digit=" + digit + 
                             ", reversed=" + reversed + ", remaining=" + (num/10));
            num /= 10;
            step++;
        }
        
        if (isNegative) {
            reversed = -reversed;
        }
        
        System.out.println("\nOriginal: " + original);
        System.out.println("Reversed: " + reversed);
    }
    
    // =========================================================================
    // QUESTION 13: Palindrome check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A number is a palindrome if it reads the same forwards and backwards.
     * 
     * Examples: 121, 12321, 1001, 11, 1
     * Non-palindromes: 123, 10, 12
     * 
     * Method: Reverse the number and compare with original.
     */
    public static void question13() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num < 0) {
            System.out.println("Negative numbers are not palindromes!");
            return;
        }
        
        int original = num;
        int reversed = 0;
        
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        
        System.out.println("\nNumber: " + original);
        System.out.println("Reversed: " + reversed);
        
        if (original == reversed) {
            System.out.println("✓ It's a PALINDROME! 🪞");
        } else {
            System.out.println("✗ NOT a palindrome");
        }
        
        // Show some palindrome examples
        System.out.println("\n--- Palindromes between 100-200 ---");
        for (int i = 100; i <= 200; i++) {
            int temp = i, rev = 0;
            while (temp > 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            if (i == rev) System.out.print(i + " ");
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 14: Sum of digits
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Add all digits of a number together.
     * 
     * Algorithm:
     * 1. Extract last digit: digit = num % 10
     * 2. Add to sum: sum += digit
     * 3. Remove last digit: num = num / 10
     * 4. Repeat until num is 0
     * 
     * BONUS: Digital root = keep summing until single digit
     */
    public static void question14() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int original = num;
        num = Math.abs(num);
        int sum = 0;
        
        System.out.print("Digits: ");
        int temp = num;
        // Print digits in correct order
        StringBuilder sb = new StringBuilder();
        while (temp > 0) {
            sb.insert(0, (temp % 10) + " + ");
            temp /= 10;
        }
        if (sb.length() > 3) {
            System.out.println(sb.substring(0, sb.length() - 3));
        }
        
        // Calculate sum
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        System.out.println("Sum of digits: " + sum);
        
        // Digital root (single digit sum)
        int digitalRoot = sum;
        while (digitalRoot > 9) {
            int newSum = 0;
            while (digitalRoot > 0) {
                newSum += digitalRoot % 10;
                digitalRoot /= 10;
            }
            digitalRoot = newSum;
        }
        System.out.println("Digital root: " + digitalRoot);
    }
    
    // =========================================================================
    // QUESTION 15: Armstrong number
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * An Armstrong number (narcissistic number) equals the sum of its 
     * digits each raised to the power of the number of digits.
     * 
     * For 3-digit numbers: abc = a³ + b³ + c³
     * 
     * Examples:
     * - 153 = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153 ✓
     * - 370 = 3³ + 7³ + 0³ = 27 + 343 + 0 = 370 ✓
     * - 9474 = 9⁴ + 4⁴ + 7⁴ + 4⁴ = 6561 + 256 + 2401 + 256 = 9474 ✓
     */
    public static void question15() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num < 0) {
            System.out.println("Armstrong check is for positive numbers!");
            return;
        }
        
        int original = num;
        
        // Count digits first
        int digitCount = String.valueOf(num).length();
        
        // Calculate sum of digits raised to power
        int sum = 0;
        int temp = num;
        System.out.print("Calculation: ");
        while (temp > 0) {
            int digit = temp % 10;
            int power = (int) Math.pow(digit, digitCount);
            sum += power;
            if (temp / 10 > 0) {
                System.out.print(digit + "^" + digitCount + " + ");
            } else {
                System.out.print(digit + "^" + digitCount);
            }
            temp /= 10;
        }
        System.out.println(" = " + sum);
        
        System.out.println("\nNumber: " + original);
        System.out.println("Digit count: " + digitCount);
        System.out.println("Sum of powers: " + sum);
        
        if (original == sum) {
            System.out.println("✓ " + original + " is an ARMSTRONG number! 💪");
        } else {
            System.out.println("✗ NOT an Armstrong number");
        }
        
        // Show Armstrong numbers up to 10000
        System.out.println("\n--- Armstrong numbers (1-10000) ---");
        for (int i = 1; i <= 10000; i++) {
            int digits = String.valueOf(i).length();
            int armSum = 0;
            int t = i;
            while (t > 0) {
                armSum += Math.pow(t % 10, digits);
                t /= 10;
            }
            if (i == armSum) System.out.print(i + " ");
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 16: Perfect number
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A perfect number equals the sum of its proper divisors
     * (divisors excluding the number itself).
     * 
     * Examples:
     * - 6 = 1 + 2 + 3 = 6 ✓
     * - 28 = 1 + 2 + 4 + 7 + 14 = 28 ✓
     * - 496 = 1 + 2 + 4 + 8 + 16 + 31 + 62 + 124 + 248 = 496 ✓
     */
    public static void question16() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num <= 1) {
            System.out.println(num + " is not a perfect number");
            return;
        }
        
        int sum = 0;
        System.out.print("Proper divisors: ");
        
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println();
        
        System.out.println("Sum of divisors: " + sum);
        
        if (sum == num) {
            System.out.println("✓ " + num + " is a PERFECT number! ✨");
        } else {
            System.out.println("✗ NOT a perfect number");
            if (sum < num) {
                System.out.println("  (It's a deficient number: sum < number)");
            } else {
                System.out.println("  (It's an abundant number: sum > number)");
            }
        }
        
        // Show perfect numbers
        System.out.println("\n--- Perfect numbers (up to 10000) ---");
        for (int n = 2; n <= 10000; n++) {
            int s = 1;
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) s += i;
            }
            if (s == n) System.out.print(n + " ");
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 17: Primes 1–100
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A prime number is divisible only by 1 and itself.
     * 
     * To check if n is prime:
     * - Check divisibility from 2 to √n
     * - If any number divides n, it's not prime
     * 
     * Optimization: Only check up to √n (if n = a × b, one must be ≤ √n)
     */
    public static void question17() {
        System.out.println("=== Prime Numbers from 1 to 100 ===\n");
        
        int count = 0;
        
        for (int num = 2; num <= 100; num++) {
            boolean isPrime = true;
            
            // Check divisibility up to √num
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) {
                System.out.printf("%3d ", num);
                count++;
                if (count % 10 == 0) System.out.println();
            }
        }
        
        System.out.println("\n\nTotal primes between 1-100: " + count);
    }
    
    // =========================================================================
    // QUESTION 18: Prime check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Check if a single number is prime.
     * 
     * Special cases:
     * - 0, 1: Not prime
     * - 2: Prime (only even prime)
     * - Even numbers > 2: Not prime
     */
    public static void question18() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        System.out.println("\n=== Prime Check for " + num + " ===");
        
        if (num <= 1) {
            System.out.println(num + " is NOT prime (by definition)");
            return;
        }
        
        if (num == 2) {
            System.out.println("2 is PRIME (the only even prime)");
            return;
        }
        
        if (num % 2 == 0) {
            System.out.println(num + " is NOT prime (divisible by 2)");
            return;
        }
        
        boolean isPrime = true;
        int divisor = 0;
        
        // Check odd numbers from 3 to √num
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                isPrime = false;
                divisor = i;
                break;
            }
        }
        
        if (isPrime) {
            System.out.println("✓ " + num + " is PRIME!");
            System.out.println("It's only divisible by 1 and " + num);
        } else {
            System.out.println("✗ " + num + " is NOT prime");
            System.out.println("It's divisible by " + divisor);
            System.out.println(num + " = " + divisor + " × " + (num / divisor));
        }
    }
    
    // =========================================================================
    // QUESTION 19: Fibonacci series
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Each number is the sum of the two preceding ones.
     * F(n) = F(n-1) + F(n-2)
     * 
     * Series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
     * 
     * Starting values: F(0) = 0, F(1) = 1
     */
    public static void question19() {
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive number!");
            return;
        }
        
        System.out.println("\n=== Fibonacci Series (first " + n + " terms) ===");
        
        long first = 0, second = 1;
        
        System.out.print("F(0) = 0");
        if (n == 1) {
            System.out.println();
            return;
        }
        
        System.out.print(", F(1) = 1");
        
        for (int i = 2; i < n; i++) {
            long next = first + second;
            System.out.print(", F(" + i + ") = " + next);
            first = second;
            second = next;
            
            if (i % 5 == 0) System.out.println();  // Line break
        }
        System.out.println();
        
        // Display as simple series
        System.out.println("\nSimple format:");
        first = 0; second = 1;
        System.out.print(first + " " + second + " ");
        for (int i = 2; i < n; i++) {
            long next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
        System.out.println();
    }
    
    // =========================================================================
    // QUESTION 20: Fibonacci sum
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find the sum of first n Fibonacci numbers.
     * 
     * FORMULA: Sum of first n Fibonacci = F(n+2) - 1
     * 
     * Example: Sum of first 7 Fibonacci (0,1,1,2,3,5,8) = 20
     */
    public static void question20() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive number!");
            return;
        }
        
        System.out.println("\n=== Sum of first " + n + " Fibonacci numbers ===");
        
        long first = 0, second = 1;
        long sum = 0;
        
        System.out.print("Series: ");
        
        if (n >= 1) {
            System.out.print(first);
            sum = first;
        }
        if (n >= 2) {
            System.out.print(" + " + second);
            sum += second;
        }
        
        for (int i = 2; i < n; i++) {
            long next = first + second;
            System.out.print(" + " + next);
            sum += next;
            first = second;
            second = next;
        }
        
        System.out.println("\n\nSum = " + sum);
        
        // Verify with formula: Sum = F(n+2) - 1
        first = 0; second = 1;
        for (int i = 2; i <= n + 1; i++) {
            long next = first + second;
            first = second;
            second = next;
        }
        System.out.println("Formula verification (F(" + (n+2) + ")-1): " + (second - 1));
    }
}
