package Phase1_Conditionals; /**
 * ============================================
 * PHASE 1 - CONDITIONAL THINKING
 * Level 4: Logical Operators (Questions 31-40)
 * ============================================
 * 
 * CONCEPT: Combine multiple conditions using logical operators.
 * 
 * LOGICAL OPERATORS:
 * - && (AND): Both conditions must be true
 * - || (OR): At least one condition must be true
 * - ! (NOT): Negates the condition
 * 
 * SHORT-CIRCUIT EVALUATION:
 * - In &&, if first condition is false, second is not evaluated
 * - In ||, if first condition is true, second is not evaluated
 */

import java.util.Scanner;

public class Level4_LogicalOperators {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment the question you want to practice
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
    // QUESTION 31: Character type (letter/digit/neither)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use Character class methods or ASCII ranges:
     * - Letter: A-Z (65-90) or a-z (97-122)
     * - Digit: 0-9 (48-57)
     * - Neither: Everything else (special characters)
     */
    public static void question31() {
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);
        
        // Method 1: Using Character methods
        if (Character.isLetter(ch)) {
            System.out.println("'" + ch + "' is a LETTER");
            if (Character.isUpperCase(ch)) {
                System.out.println("  - Uppercase letter");
            } else {
                System.out.println("  - Lowercase letter");
            }
        } else if (Character.isDigit(ch)) {
            System.out.println("'" + ch + "' is a DIGIT");
            System.out.println("  - Numeric value: " + Character.getNumericValue(ch));
        } else {
            System.out.println("'" + ch + "' is a SPECIAL CHARACTER");
        }
        
        // Method 2: Using ASCII ranges
        /*
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            System.out.println("Letter");
        } else if (ch >= '0' && ch <= '9') {
            System.out.println("Digit");
        } else {
            System.out.println("Special");
        }
        */
        
        // Additional info
        System.out.println("ASCII value: " + (int) ch);
    }
    
    // =========================================================================
    // QUESTION 32: FizzBuzz
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Classic interview question!
     * - Print "FizzBuzz" if divisible by both 3 and 5
     * - Print "Fizz" if divisible by 3 only
     * - Print "Buzz" if divisible by 5 only
     * - Print the number otherwise
     * 
     * ORDER MATTERS: Check "both" condition FIRST!
     */
    public static void question32() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Single number check
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
        
        // Bonus: FizzBuzz from 1 to n
        System.out.println("\n--- FizzBuzz from 1 to " + num + " ---");
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
            if (i % 10 == 0) System.out.println();  // Line break every 10 numbers
        }
    }
    
    // =========================================================================
    // QUESTION 33: Median of three numbers
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Median is the middle value when numbers are sorted.
     * 
     * For three numbers a, b, c:
     * - a is median if (b ≤ a ≤ c) OR (c ≤ a ≤ b)
     * - Similarly for b and c
     * 
     * ALTERNATIVE: Sort and pick middle element
     */
    public static void question33() {
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int median;
        
        // Method 1: Using conditions
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            median = a;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            median = b;
        } else {
            median = c;
        }
        
        System.out.println("Numbers: " + a + ", " + b + ", " + c);
        System.out.println("Median: " + median);
        
        // Also find min and max
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        
        // Method 2: Using Math functions
        /*
        median = Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
        */
    }
    
    // =========================================================================
    // QUESTION 34: AM or PM from time
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * 24-hour to 12-hour conversion:
     * - 0:00 to 11:59 → AM (0:00 is 12:00 AM midnight)
     * - 12:00 to 23:59 → PM (12:00 is 12:00 PM noon)
     * 
     * Conversion: hour12 = hour24 % 12 (use 12 if result is 0)
     */
    public static void question34() {
        System.out.print("Enter hour (0-23): ");
        int hour = sc.nextInt();
        System.out.print("Enter minute (0-59): ");
        int minute = sc.nextInt();
        
        // Validate
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            System.out.println("Invalid time!");
            return;
        }
        
        String period = (hour < 12) ? "AM" : "PM";
        
        // Convert to 12-hour format
        int hour12 = hour % 12;
        if (hour12 == 0) hour12 = 12;  // 0 becomes 12
        
        // Format output
        System.out.printf("24-hour format: %02d:%02d%n", hour, minute);
        System.out.printf("12-hour format: %d:%02d %s%n", hour12, minute, period);
        
        // Additional info
        if (hour == 0 && minute == 0) {
            System.out.println("It's MIDNIGHT! 🌙");
        } else if (hour == 12 && minute == 0) {
            System.out.println("It's NOON! ☀️");
        }
    }
    
    // =========================================================================
    // QUESTION 35: Tax eligibility
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Tax slabs (example - India new regime 2024):
     * - Up to 3,00,000: No tax
     * - 3,00,001 - 6,00,000: 5%
     * - 6,00,001 - 9,00,000: 10%
     * - 9,00,001 - 12,00,000: 15%
     * - 12,00,001 - 15,00,000: 20%
     * - Above 15,00,000: 30%
     * 
     * This is a slab-based calculation.
     */
    public static void question35() {
        System.out.print("Enter annual income (in ₹): ");
        double income = sc.nextDouble();
        
        double tax = 0;
        
        if (income <= 300000) {
            tax = 0;
            System.out.println("You are NOT eligible for tax");
        } else {
            // Calculate tax for each slab
            if (income > 1500000) {
                tax += (income - 1500000) * 0.30;
                income = 1500000;
            }
            if (income > 1200000) {
                tax += (income - 1200000) * 0.20;
                income = 1200000;
            }
            if (income > 900000) {
                tax += (income - 900000) * 0.15;
                income = 900000;
            }
            if (income > 600000) {
                tax += (income - 600000) * 0.10;
                income = 600000;
            }
            if (income > 300000) {
                tax += (income - 300000) * 0.05;
            }
            
            System.out.println("You are TAX ELIGIBLE");
        }
        
        System.out.printf("Tax amount: ₹%.2f%n", tax);
    }
    
    // =========================================================================
    // QUESTION 36: Both positive & sum < 100
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use AND (&&) to combine conditions:
     * - a > 0 AND b > 0 AND (a + b) < 100
     * 
     * All three conditions must be true simultaneously.
     */
    public static void question36() {
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        boolean bothPositive = (a > 0 && b > 0);
        boolean sumLessThan100 = (a + b < 100);
        
        System.out.println("Number 1: " + a);
        System.out.println("Number 2: " + b);
        System.out.println("Sum: " + (a + b));
        System.out.println();
        
        System.out.println("Both positive? " + (bothPositive ? "Yes ✓" : "No ✗"));
        System.out.println("Sum < 100? " + (sumLessThan100 ? "Yes ✓" : "No ✗"));
        
        if (bothPositive && sumLessThan100) {
            System.out.println("\n✅ BOTH conditions satisfied!");
        } else {
            System.out.println("\n❌ Conditions NOT satisfied");
            if (!bothPositive) {
                System.out.println("   - At least one number is not positive");
            }
            if (!sumLessThan100) {
                System.out.println("   - Sum is 100 or greater");
            }
        }
    }
    
    // =========================================================================
    // QUESTION 37: Digit to word
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Convert a single digit (0-9) to its English word.
     * 
     * Best approach: Use switch-case or array lookup.
     */
    public static void question37() {
        System.out.print("Enter a single digit (0-9): ");
        int digit = sc.nextInt();
        
        if (digit < 0 || digit > 9) {
            System.out.println("Please enter a single digit (0-9)!");
            return;
        }
        
        // Method 1: Using switch
        String word;
        switch (digit) {
            case 0: word = "Zero"; break;
            case 1: word = "One"; break;
            case 2: word = "Two"; break;
            case 3: word = "Three"; break;
            case 4: word = "Four"; break;
            case 5: word = "Five"; break;
            case 6: word = "Six"; break;
            case 7: word = "Seven"; break;
            case 8: word = "Eight"; break;
            case 9: word = "Nine"; break;
            default: word = "Invalid";
        }
        
        System.out.println(digit + " = " + word);
        
        // Method 2: Using array (more elegant)
        /*
        String[] words = {"Zero", "One", "Two", "Three", "Four", 
                         "Five", "Six", "Seven", "Eight", "Nine"};
        System.out.println(digit + " = " + words[digit]);
        */
    }
    
    // =========================================================================
    // QUESTION 38: Weekday or weekend
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Weekday: Monday to Friday (1-5)
     * - Weekend: Saturday and Sunday (6-7)
     * 
     * Use OR (||) for weekend check.
     */
    public static void question38() {
        System.out.print("Enter day number (1=Mon, 7=Sun): ");
        int day = sc.nextInt();
        
        if (day < 1 || day > 7) {
            System.out.println("Invalid day number! Enter 1-7");
            return;
        }
        
        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", 
                            "Friday", "Saturday", "Sunday"};
        String dayName = dayNames[day - 1];
        
        System.out.println("Day: " + dayName);
        
        // Method 1: Using OR
        if (day == 6 || day == 7) {
            System.out.println("It's a WEEKEND! 🎉");
            System.out.println("Time to relax and enjoy!");
        } else {
            System.out.println("It's a WEEKDAY 💼");
            System.out.println("Time to work!");
        }
        
        // Method 2: Using range
        /*
        if (day >= 1 && day <= 5) {
            System.out.println("Weekday");
        } else {
            System.out.println("Weekend");
        }
        */
    }
    
    // =========================================================================
    // QUESTION 39: Electricity bill calculation
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Tiered/slab-based pricing (example rates):
     * - 0-100 units: ₹1.50 per unit
     * - 101-200 units: ₹2.00 per unit
     * - 201-500 units: ₹3.00 per unit
     * - Above 500 units: ₹5.00 per unit
     * 
     * Plus fixed charges and surcharges.
     */
    public static void question39() {
        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();
        
        if (units < 0) {
            System.out.println("Units cannot be negative!");
            return;
        }
        
        double bill = 0;
        double fixedCharge = 50;  // Fixed monthly charge
        
        // Calculate bill based on slabs
        if (units <= 100) {
            bill = units * 1.50;
        } else if (units <= 200) {
            bill = 100 * 1.50 + (units - 100) * 2.00;
        } else if (units <= 500) {
            bill = 100 * 1.50 + 100 * 2.00 + (units - 200) * 3.00;
        } else {
            bill = 100 * 1.50 + 100 * 2.00 + 300 * 3.00 + (units - 500) * 5.00;
        }
        
        // Add surcharge if bill > 500
        double surcharge = 0;
        if (bill > 500) {
            surcharge = bill * 0.10;  // 10% surcharge
        }
        
        double totalBill = bill + fixedCharge + surcharge;
        
        System.out.println("\n===== ELECTRICITY BILL =====");
        System.out.println("Units consumed: " + units);
        System.out.printf("Energy charges: ₹%.2f%n", bill);
        System.out.printf("Fixed charges: ₹%.2f%n", fixedCharge);
        if (surcharge > 0) {
            System.out.printf("Surcharge (10%%): ₹%.2f%n", surcharge);
        }
        System.out.println("----------------------------");
        System.out.printf("TOTAL BILL: ₹%.2f%n", totalBill);
        System.out.println("============================");
    }
    
    // =========================================================================
    // QUESTION 40: Password validation (basic rules)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Check password against multiple rules:
     * 1. Minimum 8 characters
     * 2. At least one uppercase letter
     * 3. At least one lowercase letter
     * 4. At least one digit
     * 5. At least one special character
     * 
     * Use flags and loops to validate each condition.
     */
    public static void question40() {
        System.out.print("Enter password: ");
        String password = sc.next();
        
        // Initialize flags
        boolean hasMinLength = password.length() >= 8;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        String specialChars = "!@#$%^&*()_+-=[]{}|;':\",./<>?";
        
        // Check each character
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.indexOf(ch) != -1) hasSpecial = true;
        }
        
        // Display validation results
        System.out.println("\n===== PASSWORD VALIDATION =====");
        System.out.println("Password: " + password);
        System.out.println("Length: " + password.length());
        System.out.println();
        
        System.out.println("Criteria Check:");
        System.out.println("  [" + (hasMinLength ? "✓" : "✗") + "] Minimum 8 characters");
        System.out.println("  [" + (hasUpper ? "✓" : "✗") + "] At least one uppercase");
        System.out.println("  [" + (hasLower ? "✓" : "✗") + "] At least one lowercase");
        System.out.println("  [" + (hasDigit ? "✓" : "✗") + "] At least one digit");
        System.out.println("  [" + (hasSpecial ? "✓" : "✗") + "] At least one special character");
        
        // Final verdict
        System.out.println();
        if (hasMinLength && hasUpper && hasLower && hasDigit && hasSpecial) {
            System.out.println("✅ Password is STRONG!");
        } else {
            System.out.println("❌ Password is WEAK!");
            System.out.println("Please fix the issues marked with ✗");
        }
    }
}
