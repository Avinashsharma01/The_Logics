package Phase1_Conditionals;
/**
 * ============================================
 * PHASE 1 - CONDITIONAL THINKING
 * Level 2: Nested If & Multiple Conditions (Questions 11-20)
 * ============================================

 * CONCEPT: Nested conditions allow you to check conditions within conditions.
 * This is useful when a decision depends on multiple factors.

 * PATTERN:
 * if (condition1) {
 *     if (condition2) {
 *         // Both conditions true
 *     }
 * }
 */

import java.util.Scanner;

public class Level2_NestedConditions {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Uncomment the question you want to practice
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
    // QUESTION 11: Check if three sides form a valid triangle
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Triangle Inequality Theorem: The sum of any two sides must be greater
     * than the third side.
     * 
     * Conditions to check:
     * - a + b > c
     * - b + c > a
     * - a + c > b
     * 
     * All three conditions must be true for a valid triangle.
     */
    public static void question11() {
        System.out.print("Enter three sides of triangle: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        // First check if all sides are positive
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Sides must be positive numbers!");
            return;
        }
        
        // Triangle inequality theorem
        if (a + b > c && b + c > a && a + c > b) {
            System.out.println("YES! These sides form a valid triangle ✓");
        } else {
            System.out.println("NO! These sides cannot form a triangle ✗");
        }
    }
    
    // =========================================================================
    // QUESTION 12: Identify triangle type (equilateral/isosceles/scalene)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Equilateral: All three sides are equal (a == b == c)
     * - Isosceles: Exactly two sides are equal
     * - Scalene: All three sides are different
     * 
     * ORDER MATTERS: Check equilateral first, then isosceles, then scalene
     */
    public static void question12() {
        System.out.print("Enter three sides of triangle: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        // First verify it's a valid triangle
        if (!(a + b > c && b + c > a && a + c > b)) {
            System.out.println("Not a valid triangle!");
            return;
        }
        
        // Now classify the triangle
        if (a == b && b == c) {
            System.out.println("EQUILATERAL Triangle (all sides equal)");
        } else if (a == b || b == c || a == c) {
            System.out.println("ISOSCELES Triangle (two sides equal)");
        } else {
            System.out.println("SCALENE Triangle (all sides different)");
        }
    }
    
    // =========================================================================
    // QUESTION 13: Print grade from marks (0–100)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Use if-else-if ladder to check mark ranges
     * 
     * Common Grading:
     * - 90-100: A (Outstanding)
     * - 80-89: B (Excellent)
     * - 70-79: C (Good)
     * - 60-69: D (Average)
     * - 50-59: E (Pass)
     * - Below 50: F (Fail)
     * 
     * TIP: Start from highest and go down, OR start from lowest and go up
     */
    public static void question13() {
        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();
        
        // Input validation
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! Must be between 0-100");
            return;
        }
        
        // Grade calculation using if-else-if ladder
        char grade;
        String remark;
        
        if (marks >= 90) {
            grade = 'A';
            remark = "Outstanding! 🌟";
        } else if (marks >= 80) {
            grade = 'B';
            remark = "Excellent! 😊";
        } else if (marks >= 70) {
            grade = 'C';
            remark = "Good! 👍";
        } else if (marks >= 60) {
            grade = 'D';
            remark = "Average";
        } else if (marks >= 50) {
            grade = 'E';
            remark = "Pass (Need Improvement)";
        } else {
            grade = 'F';
            remark = "Fail 😞";
        }
        
        System.out.println("Grade: " + grade);
        System.out.println("Remark: " + remark);
    }
    
    // =========================================================================
    // QUESTION 14: Check if one number is multiple of another
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Number 'a' is a multiple of 'b' if a % b == 0
     * 
     * Example: 15 is a multiple of 3 because 15 % 3 == 0
     * 
     * EDGE CASE: Division by zero! Check if b is not zero.
     */
    public static void question14() {
        System.out.print("Enter two numbers (a b): ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // Handle edge case
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return;
        }
        
        if (a % b == 0) {
            System.out.println(a + " is a multiple of " + b);
            System.out.println(a + " = " + b + " × " + (a / b));
        } else {
            System.out.println(a + " is NOT a multiple of " + b);
            System.out.println("Remainder: " + (a % b));
        }
    }
    
    // =========================================================================
    // QUESTION 15: Print greeting based on hour (0–23)
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * 24-hour clock based greetings:
     * - 0-11: Good Morning
     * - 12-16: Good Afternoon
     * - 17-20: Good Evening
     * - 21-23: Good Night
     * 
     * This is a classic nested range check problem.
     */
    public static void question15() {
        System.out.print("Enter hour (0-23): ");
        int hour = sc.nextInt();
        
        // Input validation
        if (hour < 0 || hour > 23) {
            System.out.println("Invalid hour! Must be 0-23");
            return;
        }
        
        String greeting;
        String emoji;
        
        if (hour >= 0 && hour < 12) {
            greeting = "Good Morning";
            emoji = "🌅";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good Afternoon";
            emoji = "☀️";
        } else if (hour >= 17 && hour < 21) {
            greeting = "Good Evening";
            emoji = "🌆";
        } else {
            greeting = "Good Night";
            emoji = "🌙";
        }
        
        System.out.println(greeting + "! " + emoji);
    }
    
    // =========================================================================
    // QUESTION 16: Check voting eligibility
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - In most countries, voting age is 18+
     * - You might also want to consider citizenship status
     * 
     * This demonstrates nested conditions for multiple eligibility checks.
     */
    public static void question16() {
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        
        System.out.print("Are you a citizen? (yes/no): ");
        String citizen = sc.next().toLowerCase();
        
        // Nested conditions
        if (age >= 18) {
            if (citizen.equals("yes")) {
                System.out.println("You are ELIGIBLE to vote! 🗳️");
            } else {
                System.out.println("Sorry, only citizens can vote.");
            }
        } else {
            int yearsLeft = 18 - age;
            System.out.println("You are NOT eligible to vote.");
            System.out.println("Wait " + yearsLeft + " more year(s)!");
        }
    }
    
    // =========================================================================
    // QUESTION 17: Compare parity of two numbers
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Parity = Even or Odd
     * 
     * Cases:
     * - Both even
     * - Both odd
     * - One even, one odd (different parity)
     * 
     * KEY INSIGHT: If (a + b) is even, both have same parity
     * OR use XOR: (a % 2) == (b % 2)
     */
    public static void question17() {
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        boolean aIsEven = (a % 2 == 0);
        boolean bIsEven = (b % 2 == 0);
        
        // Method 1: Explicit comparison
        if (aIsEven && bIsEven) {
            System.out.println("Both numbers are EVEN");
        } else if (!aIsEven && !bIsEven) {
            System.out.println("Both numbers are ODD");
        } else {
            System.out.println("Numbers have DIFFERENT parity");
            System.out.println(a + " is " + (aIsEven ? "even" : "odd"));
            System.out.println(b + " is " + (bIsEven ? "even" : "odd"));
        }
        
        // Method 2: Using XOR-like logic
        /*
        if (aIsEven == bIsEven) {
            System.out.println("Same parity");
        } else {
            System.out.println("Different parity");
        }
        */
    }
    
    // =========================================================================
    // QUESTION 18: Alphabet between a–m or n–z
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - First half of alphabet: a to m (13 letters)
     * - Second half: n to z (13 letters)
     * 
     * Use character comparison with ASCII values.
     * 'a' to 'm' are ASCII 97-109
     * 'n' to 'z' are ASCII 110-122
     */
    public static void question18() {
        System.out.print("Enter an alphabet: ");
        char ch = sc.next().toLowerCase().charAt(0);
        
        // Validate input
        if (ch < 'a' || ch > 'z') {
            System.out.println("Please enter a valid alphabet (a-z)!");
            return;
        }
        
        if (ch >= 'a' && ch <= 'm') {
            System.out.println(ch + " is in FIRST HALF (a-m)");
            System.out.println("Position from 'a': " + (ch - 'a' + 1));
        } else {
            System.out.println(ch + " is in SECOND HALF (n-z)");
            System.out.println("Position from 'n': " + (ch - 'n' + 1));
        }
    }
    
    // =========================================================================
    // QUESTION 19: Day number → day name
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * Convert 1-7 to day names
     * 
     * This is perfect for switch-case statement!
     * Switch is often cleaner than multiple if-else for fixed mappings.
     */
    public static void question19() {
        System.out.print("Enter day number (1-7): ");
        int day = sc.nextInt();
        
        String dayName;
        
        // Method 1: Using switch (Recommended for this type)
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day number!";
        }
        
        System.out.println("Day " + day + " is " + dayName);
        
        // Check if weekend
        if (day == 6 || day == 7) {
            System.out.println("It's a WEEKEND! 🎉");
        } else if (day >= 1 && day <= 5) {
            System.out.println("It's a WEEKDAY 💼");
        }
        
        // Method 2: Using array (more elegant)
        /*
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", 
                         "Friday", "Saturday", "Sunday"};
        if (day >= 1 && day <= 7) {
            System.out.println(days[day - 1]);
        }
        */
    }
    
    // =========================================================================
    // QUESTION 20: Month number → days in month
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - 30 days: Apr, Jun, Sep, Nov (4, 6, 9, 11)
     * - 31 days: Jan, Mar, May, Jul, Aug, Oct, Dec (1, 3, 5, 7, 8, 10, 12)
     * - 28/29 days: Feb (2) - depends on leap year
     * 
     * MEMORY TIP: "30 days has September, April, June, and November..."
     */
    public static void question20() {
        System.out.print("Enter month number (1-12): ");
        int month = sc.nextInt();
        
        System.out.print("Enter year (for February): ");
        int year = sc.nextInt();
        
        String monthName;
        int days;
        
        switch (month) {
            case 1:
                monthName = "January";
                days = 31;
                break;
            case 2:
                monthName = "February";
                // Check leap year
                boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                days = isLeap ? 29 : 28;
                break;
            case 3:
                monthName = "March";
                days = 31;
                break;
            case 4:
                monthName = "April";
                days = 30;
                break;
            case 5:
                monthName = "May";
                days = 31;
                break;
            case 6:
                monthName = "June";
                days = 30;
                break;
            case 7:
                monthName = "July";
                days = 31;
                break;
            case 8:
                monthName = "August";
                days = 31;
                break;
            case 9:
                monthName = "September";
                days = 30;
                break;
            case 10:
                monthName = "October";
                days = 31;
                break;
            case 11:
                monthName = "November";
                days = 30;
                break;
            case 12:
                monthName = "December";
                days = 31;
                break;
            default:
                System.out.println("Invalid month number!");
                return;
        }
        
        System.out.println(monthName + " " + year + " has " + days + " days");
    }
}
