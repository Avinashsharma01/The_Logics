package Phase1_Conditionals;
/**
 * ============================================
 * PHASE 1 - CONDITIONAL THINKING
 * Level 3: Math & Number Logic (Questions 21-30)
 * ============================================

 * CONCEPT: These questions combine mathematical thinking with conditionals.
 * You'll work with digit extraction, number properties, and geometric concepts.

 * KEY SKILLS:
 * - Extracting digits from numbers
 * - Mathematical formulas in code
 * - Coordinate geometry basics
 */

import java.util.Scanner;

public class Level3_MathNumberLogic {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment the question you want to practice
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
    // QUESTION 21: Check if digits of 3-digit number are distinct
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For a 3-digit number ABC:
     * - C (units digit) = num % 10
     * - B (tens digit) = (num / 10) % 10
     * - A (hundreds digit) = num / 100
     * 
     * Distinct means: A ≠ B ≠ C and A ≠ C
     * 
     * DIGIT EXTRACTION PATTERN (Very Important!):
     * - Last digit: num % 10
     * - Remove last digit: num / 10
     */
    public static void question21() {
        System.out.print("Enter a 3-digit number: ");
        int num = sc.nextInt();
        
        // Validate 3-digit number
        if (num < 100 || num > 999) {
            System.out.println("Please enter a valid 3-digit number!");
            return;
        }
        
        // Extract digits
        int units = num % 10;           // Last digit
        int tens = (num / 10) % 10;     // Middle digit
        int hundreds = num / 100;        // First digit
        
        System.out.println("Digits: " + hundreds + ", " + tens + ", " + units);
        
        // Check if all are distinct
        if (hundreds != tens && tens != units && hundreds != units) {
            System.out.println("All digits are DISTINCT! ✓");
        } else {
            System.out.println("Digits are NOT all distinct ✗");
            if (hundreds == tens) System.out.println("  - First and second digits are same");
            if (tens == units) System.out.println("  - Second and third digits are same");
            if (hundreds == units) System.out.println("  - First and third digits are same");
        }
    }
    
    // =========================================================================
    // QUESTION 22: Compare middle digit in 3-digit number
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Extract middle digit and compare with first and last.
     * Check if middle is:
     * - Largest among all three
     * - Smallest among all three
     * - In between
     */
    public static void question22() {
        System.out.print("Enter a 3-digit number: ");
        int num = sc.nextInt();
        
        if (num < 100 || num > 999) {
            System.out.println("Please enter a valid 3-digit number!");
            return;
        }
        
        int first = num / 100;
        int middle = (num / 10) % 10;
        int last = num % 10;
        
        System.out.println("Number: " + first + middle + last);
        System.out.println("Middle digit: " + middle);
        
        // Compare middle digit
        if (middle > first && middle > last) {
            System.out.println("Middle digit is the LARGEST");
        } else if (middle < first && middle < last) {
            System.out.println("Middle digit is the SMALLEST");
        } else {
            System.out.println("Middle digit is in BETWEEN");
        }
        
        // Additional analysis
        int max = Math.max(first, Math.max(middle, last));
        int min = Math.min(first, Math.min(middle, last));
        System.out.println("Largest digit: " + max);
        System.out.println("Smallest digit: " + min);
    }
    
    // =========================================================================
    // QUESTION 23: First and last digit equal (4-digit number)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For 4-digit number ABCD:
     * - A (first digit) = num / 1000
     * - D (last digit) = num % 10
     * 
     * Simply compare: A == D
     */
    public static void question23() {
        System.out.print("Enter a 4-digit number: ");
        int num = sc.nextInt();
        
        if (num < 1000 || num > 9999) {
            System.out.println("Please enter a valid 4-digit number!");
            return;
        }
        
        int firstDigit = num / 1000;
        int lastDigit = num % 10;
        
        System.out.println("First digit: " + firstDigit);
        System.out.println("Last digit: " + lastDigit);
        
        if (firstDigit == lastDigit) {
            System.out.println("First and last digits are EQUAL! ✓");
        } else {
            System.out.println("First and last digits are DIFFERENT ✗");
        }
    }
    
    // =========================================================================
    // QUESTION 24: Single / double / multi-digit number
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Single digit: 0-9 (absolute value)
     * - Double digit: 10-99
     * - Multi-digit: 100 and above
     * 
     * ALTERNATIVE: Count digits using loop or Math.log10()
     */
    public static void question24() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int absNum = Math.abs(num);  // Handle negative numbers
        
        // Method 1: Using ranges
        if (absNum >= 0 && absNum <= 9) {
            System.out.println(num + " is a SINGLE-digit number");
        } else if (absNum >= 10 && absNum <= 99) {
            System.out.println(num + " is a DOUBLE-digit number");
        } else {
            System.out.println(num + " is a MULTI-digit number");
        }
        
        // Method 2: Count digits
        int digitCount = 0;
        int temp = absNum;
        if (temp == 0) digitCount = 1;  // Special case for 0
        while (temp > 0) {
            digitCount++;
            temp /= 10;
        }
        System.out.println("Total digits: " + digitCount);
        
        // Method 3: Using logarithm (elegant but be careful with 0)
        /*
        if (absNum == 0) {
            digitCount = 1;
        } else {
            digitCount = (int) Math.log10(absNum) + 1;
        }
        */
    }
    
    // =========================================================================
    // QUESTION 25: Multiple of 7 or ends with 7
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Two conditions (use OR):
     * 1. num % 7 == 0 (multiple of 7)
     * 2. num % 10 == 7 (ends with 7)
     * 
     * Examples:
     * - 14: Multiple of 7 ✓, doesn't end with 7
     * - 17: Not multiple of 7, ends with 7 ✓
     * - 7: Both ✓
     * - 37: Ends with 7 ✓
     * - 49: Multiple of 7 ✓
     */
    public static void question25() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        boolean isMultipleOf7 = (num % 7 == 0);
        boolean endsWith7 = (Math.abs(num) % 10 == 7);
        
        System.out.println("Multiple of 7: " + (isMultipleOf7 ? "Yes" : "No"));
        System.out.println("Ends with 7: " + (endsWith7 ? "Yes" : "No"));
        
        if (isMultipleOf7 || endsWith7) {
            if (isMultipleOf7 && endsWith7) {
                System.out.println(num + " is BOTH multiple of 7 AND ends with 7! 🎯");
            } else if (isMultipleOf7) {
                System.out.println(num + " is a multiple of 7");
            } else {
                System.out.println(num + " ends with 7");
            }
        } else {
            System.out.println(num + " is neither multiple of 7 nor ends with 7");
        }
    }
    
    // =========================================================================
    // QUESTION 26: Quadrant of point (x, y)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Coordinate plane is divided into 4 quadrants:
     * 
     *          Y+
     *          |
     *    Q2    |    Q1
     *  (-,+)   |   (+,+)
     * ---------+---------> X+
     *    Q3    |    Q4
     *  (-,-)   |   (+,-)
     *          |
     * 
     * - Q1: x > 0, y > 0
     * - Q2: x < 0, y > 0
     * - Q3: x < 0, y < 0
     * - Q4: x > 0, y < 0
     * - On axis if x = 0 or y = 0
     * - Origin if x = 0 and y = 0
     */
    public static void question26() {
        System.out.print("Enter x coordinate: ");
        double x = sc.nextDouble();
        System.out.print("Enter y coordinate: ");
        double y = sc.nextDouble();
        
        System.out.println("\nPoint (" + x + ", " + y + ") lies in:");
        
        if (x == 0 && y == 0) {
            System.out.println("ORIGIN (0, 0)");
        } else if (x == 0) {
            if (y > 0) {
                System.out.println("Positive Y-axis");
            } else {
                System.out.println("Negative Y-axis");
            }
        } else if (y == 0) {
            if (x > 0) {
                System.out.println("Positive X-axis");
            } else {
                System.out.println("Negative X-axis");
            }
        } else if (x > 0 && y > 0) {
            System.out.println("FIRST QUADRANT (Q1)");
        } else if (x < 0 && y > 0) {
            System.out.println("SECOND QUADRANT (Q2)");
        } else if (x < 0 && y < 0) {
            System.out.println("THIRD QUADRANT (Q3)");
        } else {
            System.out.println("FOURTH QUADRANT (Q4)");
        }
    }
    
    // =========================================================================
    // QUESTION 27: Currency note division (2000/500/100)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Greedy approach - start with largest denomination first.
     * 
     * Steps:
     * 1. Divide amount by 2000 → get count of 2000 notes
     * 2. Use remainder, divide by 500 → get count of 500 notes
     * 3. Use remainder, divide by 100 → get count of 100 notes
     * 4. Remaining amount cannot be represented
     * 
     * This is similar to coin change problem (greedy version).
     */
    public static void question27() {
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();
        
        if (amount < 0) {
            System.out.println("Amount cannot be negative!");
            return;
        }
        
        int originalAmount = amount;
        
        // Count notes using integer division
        int notes2000 = amount / 2000;
        amount = amount % 2000;
        
        int notes500 = amount / 500;
        amount = amount % 500;
        
        int notes100 = amount / 100;
        amount = amount % 100;
        
        // Display result
        System.out.println("\n=== Currency Breakdown for ₹" + originalAmount + " ===");
        System.out.println("₹2000 notes: " + notes2000);
        System.out.println("₹500 notes: " + notes500);
        System.out.println("₹100 notes: " + notes100);
        
        if (amount > 0) {
            System.out.println("Remaining (cannot be divided): ₹" + amount);
        }
        
        int totalNotes = notes2000 + notes500 + notes100;
        System.out.println("Total notes used: " + totalNotes);
    }
    
    // =========================================================================
    // QUESTION 28: Check if number in range 100–999
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Simple range check using AND operator.
     * num >= 100 AND num <= 999
     * 
     * This range represents all 3-digit numbers.
     */
    public static void question28() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num >= 100 && num <= 999) {
            System.out.println(num + " is in range [100, 999] ✓");
            System.out.println("It's a 3-digit number!");
        } else {
            System.out.println(num + " is NOT in range [100, 999] ✗");
            
            if (num < 100) {
                System.out.println("It's less than the range (too small)");
            } else {
                System.out.println("It's greater than the range (too large)");
            }
        }
    }
    
    // =========================================================================
    // QUESTION 29: Find third angle of triangle
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Sum of all angles in a triangle = 180°
     * 
     * If we know two angles (a and b):
     * Third angle (c) = 180 - a - b
     * 
     * VALIDATION:
     * - Each angle must be positive
     * - Sum of given angles must be less than 180
     */
    public static void question29() {
        System.out.print("Enter first angle: ");
        double angle1 = sc.nextDouble();
        System.out.print("Enter second angle: ");
        double angle2 = sc.nextDouble();
        
        // Validation
        if (angle1 <= 0 || angle2 <= 0) {
            System.out.println("Angles must be positive!");
            return;
        }
        
        if (angle1 + angle2 >= 180) {
            System.out.println("Invalid! Sum of two angles must be less than 180°");
            return;
        }
        
        double angle3 = 180 - angle1 - angle2;
        
        System.out.println("\n=== Triangle Angles ===");
        System.out.println("Angle 1: " + angle1 + "°");
        System.out.println("Angle 2: " + angle2 + "°");
        System.out.println("Angle 3: " + angle3 + "°");
        System.out.println("Sum: " + (angle1 + angle2 + angle3) + "°");
        
        // Classify triangle by angles
        if (angle1 == 60 && angle2 == 60 && angle3 == 60) {
            System.out.println("Type: Equilateral Triangle");
        } else if (angle1 == 90 || angle2 == 90 || angle3 == 90) {
            System.out.println("Type: Right-angled Triangle");
        } else if (angle1 > 90 || angle2 > 90 || angle3 > 90) {
            System.out.println("Type: Obtuse Triangle");
        } else {
            System.out.println("Type: Acute Triangle");
        }
    }
    
    // =========================================================================
    // QUESTION 30: Check perfect square (without using sqrt)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A number is a perfect square if some integer i exists where i × i = num
     * 
     * Methods:
     * 1. Brute force: Check all numbers from 1 to num
     * 2. Optimized: Check only up to √num (approximate using num/2 or binary search)
     * 3. Using property: Odd number sum = 1+3+5+7+... = perfect squares
     * 
     * We'll use the optimized approach.
     */
    public static void question30() {
        System.out.print("Enter a number: ");
        long num = sc.nextLong();
        
        if (num < 0) {
            System.out.println("Negative numbers cannot be perfect squares!");
            return;
        }
        
        if (num == 0 || num == 1) {
            System.out.println(num + " is a PERFECT SQUARE (" + num + " × " + num + ")");
            return;
        }
        
        // Method 1: Iterate and check (optimized to check only till num/2)
        boolean isPerfectSquare = false;
        long root = 0;
        
        for (long i = 1; i * i <= num; i++) {
            if (i * i == num) {
                isPerfectSquare = true;
                root = i;
                break;
            }
        }
        
        if (isPerfectSquare) {
            System.out.println(num + " is a PERFECT SQUARE (" + root + " × " + root + ") ✓");
        } else {
            // Find nearest perfect squares
            long lower = 1;
            for (long i = 1; i * i < num; i++) {
                lower = i;
            }
            long upper = lower + 1;
            
            System.out.println(num + " is NOT a perfect square ✗");
            System.out.println("Nearest perfect squares:");
            System.out.println("  - " + (lower * lower) + " = " + lower + "²");
            System.out.println("  - " + (upper * upper) + " = " + upper + "²");
        }
        
        /*
         * Method 2: Binary Search approach
         * 
         * long low = 1, high = num;
         * while (low <= high) {
         *     long mid = low + (high - low) / 2;
         *     if (mid * mid == num) {
         *         // Perfect square found
         *         break;
         *     } else if (mid * mid < num) {
         *         low = mid + 1;
         *     } else {
         *         high = mid - 1;
         *     }
         * }
         */
    }
}
