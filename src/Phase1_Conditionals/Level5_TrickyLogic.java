package Phase1_Conditionals; /**
 * ============================================
 * PHASE 1 - CONDITIONAL THINKING
 * Level 5: Tricky Logic (Questions 41-50)
 * ============================================
 * 
 * CONCEPT: These questions require deeper mathematical thinking
 * and careful consideration of edge cases.
 * 
 * These are often asked in interviews to test your
 * problem-solving ability and attention to detail.
 */

import java.util.Scanner;

public class Level5_TrickyLogic {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment the question you want to practice
        // question41();
        // question42();
        // question43();
        // question44();
        // question45();
        // question46();
        // question47();
        // question48();
        // question49();
        // question50();
    }
    
    // =========================================================================
    // QUESTION 41: Point on axis/origin
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Origin: x = 0 AND y = 0
     * - On X-axis: y = 0 (but not origin)
     * - On Y-axis: x = 0 (but not origin)
     * - Elsewhere: In one of the four quadrants
     */
    public static void question41() {
        System.out.print("Enter x coordinate: ");
        double x = sc.nextDouble();
        System.out.print("Enter y coordinate: ");
        double y = sc.nextDouble();
        
        System.out.println("\nPoint (" + x + ", " + y + "):");
        
        if (x == 0 && y == 0) {
            System.out.println("Lies at the ORIGIN");
        } else if (x == 0) {
            System.out.println("Lies on the Y-AXIS");
            System.out.println("Distance from origin: " + Math.abs(y) + " units");
        } else if (y == 0) {
            System.out.println("Lies on the X-AXIS");
            System.out.println("Distance from origin: " + Math.abs(x) + " units");
        } else {
            // Point is in one of the quadrants
            String quadrant;
            if (x > 0 && y > 0) quadrant = "First Quadrant (I)";
            else if (x < 0 && y > 0) quadrant = "Second Quadrant (II)";
            else if (x < 0 && y < 0) quadrant = "Third Quadrant (III)";
            else quadrant = "Fourth Quadrant (IV)";
            
            System.out.println("Lies in " + quadrant);
            double distance = Math.sqrt(x * x + y * y);
            System.out.printf("Distance from origin: %.2f units%n", distance);
        }
    }
    
    // =========================================================================
    // QUESTION 42: Pythagorean triplet
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Three numbers form a Pythagorean triplet if:
     * a² + b² = c² (where c is the largest)
     * 
     * Common triplets: (3,4,5), (5,12,13), (8,15,17), (7,24,25)
     * 
     * We need to find the largest first, then check the equation.
     */
    public static void question42() {
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        // Find the largest (hypotenuse)
        int max = Math.max(a, Math.max(b, c));
        
        // Calculate squares
        int aSquare = a * a;
        int bSquare = b * b;
        int cSquare = c * c;
        
        boolean isPythagorean = false;
        
        // Check all possible combinations
        if (max == c && aSquare + bSquare == cSquare) {
            isPythagorean = true;
        } else if (max == b && aSquare + cSquare == bSquare) {
            isPythagorean = true;
        } else if (max == a && bSquare + cSquare == aSquare) {
            isPythagorean = true;
        }
        
        System.out.println("\nNumbers: " + a + ", " + b + ", " + c);
        System.out.println("Squares: " + aSquare + ", " + bSquare + ", " + cSquare);
        
        if (isPythagorean) {
            System.out.println("✓ These form a PYTHAGOREAN TRIPLET!");
            System.out.println("They can be sides of a right-angled triangle.");
        } else {
            System.out.println("✗ NOT a Pythagorean triplet");
        }
    }
    
    // =========================================================================
    // QUESTION 43: Valid calendar date
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Check if day/month/year form a valid date:
     * 1. Month should be 1-12
     * 2. Day should be valid for that month
     * 3. February has 28 or 29 days (leap year check)
     * 4. Year should be positive
     */
    public static void question43() {
        System.out.print("Enter date (day month year): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();
        
        boolean isValid = true;
        String errorMsg = "";
        
        // Check year
        if (year < 1) {
            isValid = false;
            errorMsg = "Year must be positive";
        }
        // Check month
        else if (month < 1 || month > 12) {
            isValid = false;
            errorMsg = "Month must be between 1-12";
        }
        // Check day
        else {
            // Days in each month
            int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
            // Adjust February for leap year
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeap) {
                daysInMonth[1] = 29;
            }
            
            int maxDays = daysInMonth[month - 1];
            
            if (day < 1 || day > maxDays) {
                isValid = false;
                errorMsg = "Day must be between 1-" + maxDays + " for month " + month;
            }
        }
        
        // Display result
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                              "July", "August", "September", "October", "November", "December"};
        
        System.out.println("\nInput: " + day + "/" + month + "/" + year);
        
        if (isValid) {
            System.out.println("✓ VALID DATE");
            System.out.println("Formatted: " + day + " " + monthNames[month - 1] + " " + year);
        } else {
            System.out.println("✗ INVALID DATE");
            System.out.println("Reason: " + errorMsg);
        }
    }
    
    // =========================================================================
    // QUESTION 44: Clock angle problem
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Find the angle between hour and minute hands.
     * 
     * - Hour hand moves 360° in 12 hours = 0.5° per minute
     * - Minute hand moves 360° in 60 minutes = 6° per minute
     * 
     * Hour hand position: (hour * 60 + minute) * 0.5
     * Minute hand position: minute * 6
     * 
     * Angle = |hourAngle - minuteAngle|
     * Return the smaller angle (≤ 180°)
     */
    public static void question44() {
        System.out.print("Enter hour (1-12): ");
        int hour = sc.nextInt();
        System.out.print("Enter minute (0-59): ");
        int minute = sc.nextInt();
        
        // Validate input
        if (hour < 1 || hour > 12 || minute < 0 || minute > 59) {
            System.out.println("Invalid time!");
            return;
        }
        
        // Convert hour to 0-11 format
        if (hour == 12) hour = 0;
        
        // Calculate angles from 12 o'clock position
        double hourAngle = (hour * 60 + minute) * 0.5;  // 0.5 degrees per minute
        double minuteAngle = minute * 6;  // 6 degrees per minute
        
        // Find the difference
        double angle = Math.abs(hourAngle - minuteAngle);
        
        // Return the smaller angle
        if (angle > 180) {
            angle = 360 - angle;
        }
        
        System.out.println("\nTime: " + (hour == 0 ? 12 : hour) + ":" + 
                          String.format("%02d", minute));
        System.out.printf("Hour hand position: %.2f°%n", hourAngle);
        System.out.printf("Minute hand position: %.2f°%n", minuteAngle);
        System.out.printf("Angle between hands: %.2f°%n", angle);
        
        // Special cases
        if (angle == 0) {
            System.out.println("The hands overlap! 🕐");
        } else if (angle == 180) {
            System.out.println("The hands are opposite! ↔️");
        } else if (angle == 90) {
            System.out.println("The hands are perpendicular! ⊥");
        }
    }
    
    // =========================================================================
    // QUESTION 45: Arithmetic progression check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Three numbers a, b, c are in AP if:
     * b - a = c - b
     * OR equivalently: 2b = a + c
     * 
     * The common difference d = b - a
     */
    public static void question45() {
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        // Check AP condition
        boolean isAP = (b - a) == (c - b);
        // Alternatively: boolean isAP = (2 * b == a + c);
        
        System.out.println("\nNumbers: " + a + ", " + b + ", " + c);
        System.out.println("Difference (b-a): " + (b - a));
        System.out.println("Difference (c-b): " + (c - b));
        
        if (isAP) {
            int d = b - a;  // Common difference
            System.out.println("✓ These are in ARITHMETIC PROGRESSION");
            System.out.println("Common difference (d): " + d);
            
            // Predict next terms
            System.out.println("Next terms would be: " + (c + d) + ", " + (c + 2*d));
        } else {
            System.out.println("✗ NOT in Arithmetic Progression");
        }
    }
    
    // =========================================================================
    // QUESTION 46: Geometric progression check
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Three numbers a, b, c are in GP if:
     * b/a = c/b
     * OR equivalently: b² = a × c
     * 
     * The common ratio r = b/a
     * 
     * EDGE CASE: Handle division by zero if a = 0
     */
    public static void question46() {
        System.out.print("Enter three numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        
        System.out.println("\nNumbers: " + a + ", " + b + ", " + c);
        
        // Edge case: a or b is zero
        if (a == 0 || b == 0) {
            if (a == 0 && b == 0 && c == 0) {
                System.out.println("All zeros - trivial GP");
            } else {
                System.out.println("Cannot determine GP when first terms are zero");
            }
            return;
        }
        
        // Check GP condition using b² = a × c (avoids division issues)
        boolean isGP = (b * b == a * c);
        
        // For display purposes, also check ratio
        double ratio1 = b / a;
        double ratio2 = c / b;
        
        System.out.printf("Ratio (b/a): %.4f%n", ratio1);
        System.out.printf("Ratio (c/b): %.4f%n", ratio2);
        
        if (isGP) {
            System.out.println("✓ These are in GEOMETRIC PROGRESSION");
            System.out.println("Common ratio (r): " + ratio1);
            
            // Predict next terms
            double next1 = c * ratio1;
            double next2 = next1 * ratio1;
            System.out.printf("Next terms would be: %.2f, %.2f%n", next1, next2);
        } else {
            System.out.println("✗ NOT in Geometric Progression");
        }
    }
    
    // =========================================================================
    // QUESTION 47: Digit sum logic (3-digit number)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * For a 3-digit number, find:
     * - Sum of digits
     * - Product of digits
     * - Check if digit sum equals any digit
     * - Check if number is divisible by digit sum
     */
    public static void question47() {
        System.out.print("Enter a 3-digit number: ");
        int num = sc.nextInt();
        
        if (num < 100 || num > 999) {
            System.out.println("Please enter a 3-digit number!");
            return;
        }
        
        int d1 = num / 100;          // Hundreds digit
        int d2 = (num / 10) % 10;    // Tens digit
        int d3 = num % 10;           // Units digit
        
        int sum = d1 + d2 + d3;
        int product = d1 * d2 * d3;
        
        System.out.println("\nNumber: " + num);
        System.out.println("Digits: " + d1 + ", " + d2 + ", " + d3);
        System.out.println("Sum of digits: " + sum);
        System.out.println("Product of digits: " + product);
        
        // Various checks
        System.out.println("\n--- Analysis ---");
        
        // Check if divisible by digit sum
        if (sum != 0 && num % sum == 0) {
            System.out.println("✓ Number is divisible by its digit sum");
        }
        
        // Check if digit sum equals any digit
        if (sum == d1 || sum == d2 || sum == d3) {
            System.out.println("✓ Digit sum equals one of the digits");
        }
        
        // Check if all digits are same
        if (d1 == d2 && d2 == d3) {
            System.out.println("✓ All digits are identical (repdigit)");
        }
        
        // Check if digits are in ascending/descending order
        if (d1 < d2 && d2 < d3) {
            System.out.println("✓ Digits are in ascending order");
        } else if (d1 > d2 && d2 > d3) {
            System.out.println("✓ Digits are in descending order");
        }
    }
    
    // =========================================================================
    // QUESTION 48: Digit sum > digit product
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Compare digit sum and digit product.
     * 
     * Interesting observation:
     * - If any digit is 0, product = 0
     * - If all digits are 1, sum > product
     * - For larger digits, product grows faster
     */
    public static void question48() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int original = num;
        num = Math.abs(num);  // Work with positive
        
        int sum = 0;
        int product = 1;
        boolean hasZero = false;
        
        // Handle zero specially
        if (num == 0) {
            sum = 0;
            product = 0;
        } else {
            while (num > 0) {
                int digit = num % 10;
                sum += digit;
                product *= digit;
                if (digit == 0) hasZero = true;
                num /= 10;
            }
        }
        
        System.out.println("\nNumber: " + original);
        System.out.println("Sum of digits: " + sum);
        System.out.println("Product of digits: " + product);
        
        if (sum > product) {
            System.out.println("\n✓ Sum > Product");
            if (hasZero) {
                System.out.println("  (Product is 0 because of a zero digit)");
            }
        } else if (sum < product) {
            System.out.println("\n✓ Sum < Product");
        } else {
            System.out.println("\n✓ Sum = Product");
        }
        
        System.out.println("Difference: " + Math.abs(sum - product));
    }
    
    // =========================================================================
    // QUESTION 49: Compare two dates
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Compare two dates (dd mm yyyy) and determine which is earlier.
     * 
     * Comparison order:
     * 1. First compare years
     * 2. If years equal, compare months
     * 3. If months equal, compare days
     */
    public static void question49() {
        System.out.println("Enter first date (day month year):");
        int d1 = sc.nextInt();
        int m1 = sc.nextInt();
        int y1 = sc.nextInt();
        
        System.out.println("Enter second date (day month year):");
        int d2 = sc.nextInt();
        int m2 = sc.nextInt();
        int y2 = sc.nextInt();
        
        System.out.println("\nDate 1: " + d1 + "/" + m1 + "/" + y1);
        System.out.println("Date 2: " + d2 + "/" + m2 + "/" + y2);
        
        // Compare dates
        int result;
        
        if (y1 != y2) {
            result = Integer.compare(y1, y2);
        } else if (m1 != m2) {
            result = Integer.compare(m1, m2);
        } else {
            result = Integer.compare(d1, d2);
        }
        
        System.out.println();
        if (result < 0) {
            System.out.println("Date 1 is EARLIER than Date 2");
        } else if (result > 0) {
            System.out.println("Date 1 is LATER than Date 2");
        } else {
            System.out.println("Both dates are THE SAME");
        }
        
        // Calculate rough difference
        // (Simple approximation - for exact, use java.time API)
        int approxDays1 = y1 * 365 + m1 * 30 + d1;
        int approxDays2 = y2 * 365 + m2 * 30 + d2;
        int diff = Math.abs(approxDays1 - approxDays2);
        System.out.println("Approximate difference: ~" + diff + " days");
    }
    
    // =========================================================================
    // QUESTION 50: Century from year
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * A century is a period of 100 years.
     * 
     * Formula: century = (year + 99) / 100
     * OR: century = (year - 1) / 100 + 1
     * 
     * Examples:
     * - Year 1-100: 1st century
     * - Year 101-200: 2nd century
     * - Year 2000: 20th century
     * - Year 2001: 21st century
     */
    public static void question50() {
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        
        if (year <= 0) {
            System.out.println("Please enter a positive year (AD)!");
            return;
        }
        
        // Calculate century
        int century = (year - 1) / 100 + 1;
        
        // Determine suffix (1st, 2nd, 3rd, 4th, etc.)
        String suffix;
        int lastTwoDigits = century % 100;
        int lastDigit = century % 10;
        
        if (lastTwoDigits >= 11 && lastTwoDigits <= 13) {
            suffix = "th";
        } else if (lastDigit == 1) {
            suffix = "st";
        } else if (lastDigit == 2) {
            suffix = "nd";
        } else if (lastDigit == 3) {
            suffix = "rd";
        } else {
            suffix = "th";
        }
        
        System.out.println("\nYear: " + year);
        System.out.println("Century: " + century + suffix);
        
        // Additional info
        int centuryStart = (century - 1) * 100 + 1;
        int centuryEnd = century * 100;
        System.out.println("This century spans: " + centuryStart + " - " + centuryEnd);
        
        // How many years into the century
        int yearsIntoCentury = year - centuryStart + 1;
        System.out.println("Year " + yearsIntoCentury + " of this century");
        
        // Years remaining in century
        int yearsRemaining = centuryEnd - year;
        System.out.println("Years remaining in this century: " + yearsRemaining);
    }
}
